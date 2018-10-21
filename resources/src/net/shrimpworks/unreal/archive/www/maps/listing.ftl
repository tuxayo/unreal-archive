<#include "_header.ftl">

	<section class="header">
		<h1>
		${page.letter.gametype.game.name} / ${page.letter.gametype.name} / ${page.letter.letter} / pg ${page.number}
		</h1>
	</section>
	<article>
		<table class="maplist">
			<thead>
			<tr>
				<th>Map</th>
				<th>Title</th>
				<th>Author</th>
				<th>Players</th>
			</tr>
			</thead>
			<tbody>
				<#list page.maps as m>
				<tr>
					<td><a href="${relUrl(root, m.path + ".html")}">${m.map.name}</a></td>
					<td>${m.map.title}</td>
					<td>${m.map.author}</td>
					<td>${m.map.playerCount}</td>
				</tr>
				</#list>
			</tbody>
		</table>
	</article>

<#include "_footer.ftl">