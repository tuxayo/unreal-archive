package net.shrimpworks.unreal.archive.content.models;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import net.shrimpworks.unreal.archive.content.Content;
import net.shrimpworks.unreal.archive.content.Incoming;
import net.shrimpworks.unreal.archive.content.IndexHandler;
import net.shrimpworks.unreal.archive.content.IndexLog;
import net.shrimpworks.unreal.archive.content.IndexResult;
import net.shrimpworks.unreal.archive.content.IndexUtils;
import net.shrimpworks.unreal.archive.content.skins.SkinIndexHandler;
import net.shrimpworks.unreal.packages.IntFile;

public class ModelIndexHandler implements IndexHandler<Model> {

	public static class ModelIndexHandlerFactory implements IndexHandlerFactory<Model> {

		@Override
		public IndexHandler<Model> get() {
			return new ModelIndexHandler();
		}
	}

	@Override
	public void index(Incoming incoming, Content current, Consumer<IndexResult<Model>> completed) {
		Model m = (Model)current;
		IndexLog log = incoming.log;

		Set<IndexResult.NewAttachment> attachments = new HashSet<>();

		String origName = m.name;

		// UT2003/4 model is defined by a UPL file
		if (!incoming.files(Incoming.FileType.PLAYER).isEmpty()) {
			// each record contains both mesh and skin information, so keep track of seen meshes vs skins
			Set<String> meshes = new HashSet<>();

			SkinIndexHandler.playerDescriptors(incoming).forEach(p -> {
				if (p.containsKey("DefaultName")) {
					if (p.containsKey("Mesh") && !meshes.contains(p.get("Mesh").trim())) {
						m.models.add(p.get("DefaultName").trim());
						meshes.add(p.get("Mesh").trim());
					}

					if (m.name == null || m.name.equals(origName)) m.name = p.get("DefaultName");
					m.skins.add(p.get("DefaultName").trim());
				}
			});
		} else {
			// find model and skin information via .int files
			modelDescriptors(incoming).forEach(d -> {
				if (d.containsKey("Description") && Model.NAME_MATCH.matcher(d.get("Name")).matches()) {
					if (m.name == null || m.name.equals(origName)) m.name = d.get("Description");
					m.models.add(d.get("Description").trim());
				}
			});

			SkinIndexHandler.skinDescriptors(incoming).forEach(d -> {
				if (d.containsKey("Description") && Model.NAME_MATCH.matcher(d.get("Name")).matches()) {
					if (m.name == null || m.name.equals(origName)) m.name = d.get("Description");
					m.skins.add(d.get("Description").trim());
				}
			});
		}

		try {
			if (m.releaseDate != null && m.releaseDate.compareTo(IndexUtils.RELEASE_UT99) < 0) m.game = "Unreal";
			m.game = game(incoming);
		} catch (Exception e) {
			log.log(IndexLog.EntryType.CONTINUE, "Could not determine game for model", e);
		}

		try {
			m.author = IndexUtils.findAuthor(incoming);
		} catch (IOException e) {
			log.log(IndexLog.EntryType.CONTINUE, "Failed attempt to read author", e);
		}

		try {
			// see if there are any images the author may have included in the package
			List<BufferedImage> images = IndexUtils.findImageFiles(incoming);

			// also see if we can at least include chat portrait images
			SkinIndexHandler.findPortraits(incoming, images);

			IndexUtils.saveImages(IndexUtils.SHOT_NAME, m, images, attachments);
		} catch (IOException e) {
			log.log(IndexLog.EntryType.CONTINUE, "Failed to save images", e);
		}

		completed.accept(new IndexResult<>(m, attachments));
	}

	public static List<IntFile.MapValue> modelDescriptors(Incoming incoming) {
		return IndexUtils.readIntFiles(incoming, incoming.files(Incoming.FileType.INT))
						 .filter(Objects::nonNull)
						 .flatMap(intFile -> {
							 List<IntFile.MapValue> vals = new ArrayList<>();

							 IntFile.Section section = intFile.section("public");
							 if (section == null) return Stream.empty();

							 IntFile.ListValue objects = section.asList("Object");
							 for (IntFile.Value value : objects.values) {
								 if (value instanceof IntFile.MapValue
									 && ((IntFile.MapValue)value).containsKey("Name")
									 && ((IntFile.MapValue)value).containsKey("MetaClass")
									 && ((IntFile.MapValue)value).containsKey("Description")
									 && ((IntFile.MapValue)value).get("MetaClass").equalsIgnoreCase(Model.UT_PLAYER_CLASS)) {

									 vals.add((IntFile.MapValue)value);
								 }
							 }

							 return vals.stream();
						 })
						 .filter(Objects::nonNull)
						 .collect(Collectors.toList());
	}

	private String game(Incoming incoming) throws IOException {
		if (incoming.submission.override.get("game", null) != null) return incoming.submission.override.get("game", "Unreal Tournament");

		if (!incoming.files(Incoming.FileType.PLAYER, Incoming.FileType.ANIMATION).isEmpty()) return "Unreal Tournament 2004";

		return IndexUtils.game(incoming.files(Incoming.FileType.PACKAGES));
	}

}
