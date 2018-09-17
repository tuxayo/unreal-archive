package net.shrimpworks.unreal.archive;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

import net.shrimpworks.unreal.archive.maps.Map;

import org.junit.Test;

import static org.junit.Assert.*;

public class YAMLTest {

	@Test
	public void serialiseStuff() throws IOException {
		Map m = makeMap();

		String yaml = YAML.toString(m);

		assertNotNull(yaml);
		assertTrue(yaml.contains(m.name) && yaml.contains(m.author) && yaml.contains("shot2.jpg"));

		Map copy = YAML.fromString(yaml, Map.class);

		assertNotNull(copy);

		assertEquals(m.title, copy.title);
		assertEquals(m.screenshots.get(1), copy.screenshots.get(1));

		Path wrote = Files.write(Files.createTempFile("test-map", ".yaml"),
								 YAML.toString(copy).getBytes(StandardCharsets.UTF_8),
								 StandardOpenOption.CREATE);

		Map another = YAML.fromFile(wrote, Map.class);
		assertNotNull(another);
		assertEquals(m.title, another.title);
		assertEquals(m.screenshots.get(1), another.screenshots.get(1));

		System.out.println(YAML.toString(another));
	}

	private Map makeMap() {
		Map m = ContentClassifier.ContentType.MAP.newContent(null);

		m.firstIndex = LocalDateTime.now().minus(1, ChronoUnit.DAYS);
		m.lastIndex = LocalDateTime.now();

		m.game = "Unreal Tournament";
		m.name = "DM-MyMap";
		m.gametype = "Deathmatch";
		m.title = "My Map";
		m.author = "Joe Soap";
		m.playerCount = "2 - 4 Players";
		m.releaseDate = "2001-05";
		m.screenshots = Arrays.asList("Screenshot1.png", "shot2.jpg");
		m.sha1 = "123456789";
		m.fileSize = 564231;
		m.files = Arrays.asList(file("DM-MyMap.unr"), file("MyTex.utx"));
		m.downloads = Arrays.asList(download("mysite.com/map.zip"), download("http://maps.com/map.rar"));

		m.deleted = false;

		return m;
	}

	private ContentFile file(String name) {
		return new ContentFile(name, (int)(Math.random() * 10240), "abc" + (Math.random() * 20480));
	}

	private Download download(String url) {
		return new Download(url,
							LocalDate.now().minus((long)(Math.random() * 500), ChronoUnit.DAYS),
							LocalDate.now().minus((long)(Math.random() * 100), ChronoUnit.DAYS),
							true, false, false
		);
	}
}
