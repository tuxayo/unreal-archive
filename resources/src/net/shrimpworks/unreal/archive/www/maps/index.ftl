<#include "_header.ftl">

	<section class="header">
		<h1>
			Hello World
		</h1>
	</section>
	<article>
		<ul>
		<#list games.games as k, v>
			<li><a href="${v.slug}.html">${v.name}</a></li>
		</#list>
		</ul>
	</article>

<#include "_footer.ftl">