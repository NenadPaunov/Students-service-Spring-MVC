<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath}/static/css/main.css" type="text/css" rel="stylesheet">
<meta charset="UTF-8">
<title>layout</title>
<link href="https://fonts.googleapis.com/css?family=Open+Sans"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
	crossorigin="anonymous">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<div id="slika">
				<img src="images/logo.png" alt="logo" title="logo">
			</div>
			<div id="slikaText">
				<h2>Lorem ipsum dolor sit amet</h2>
			</div>
		</div>
		<div id="nav">
			<ul>
				<li><a href="index.html"> Home page</a></li>
				<li><a href="info.html">Info</a></li>
				<li><a href="work.html">Work</a></li>
				<li><a href="about.html">About us &amp; contact</a></li>
			</ul>
			<div id="social">
				<a href=""><i class="fab fa-facebook"></i></a> <a href=""><i
					class="fab fa-twitter"></i></a> <a href=""><i
					class="fab fa-linkedin"></i></a>
			</div>
		</div>
		<div id="main">
			<h1>What is Lorem Ipsum?</h1>
			<p>Lorem Ipsum is simply dummy text of the printing and
				typesetting industry. Lorem Ipsum has been the industry's standard
				dummy text ever since the 1500s, when an unknown printer took a
				galley of type and scrambled it to make a type specimen book. It has
				survived not only five centuries, but also the leap into electronic
				typesetting, remaining essentially unchanged. It was popularised in
				the 1960s with the release of Letraset sheets containing Lorem Ipsum
				passages, and more recently with desktop publishing software like
				Aldus PageMaker including versions of Lorem Ipsum.</p>
			<img src="${pageContext.request.contextPath}/static/images/hero.jpg" alt="hero" title="hero">
			<p>Contrary to popular belief, Lorem Ipsum is not simply random
				text. It has roots in a piece of classical Latin literature from 45
				BC, making it over 2000 years old. Richard McClintock, a Latin
				professor at Hampden-Sydney College in Virginia, looked up one of
				the more obscure Latin words, consectetur, from a Lorem Ipsum
				passage, and going through the cites of the word in classical
				literature, discovered the undoubtable source. Lorem Ipsum comes
				from sections 1.10.32 and 1.10.33 of "de Finibus Bonorum et Malorum"
				(The Extremes of Good and Evil) by Cicero, written in 45 BC. This
				book is a treatise on the theory of ethics, very popular during the
				Renaissance. The first line of Lorem Ipsum, "Lorem ipsum dolor sit
				amet..", comes from a line in section 1.10.32.</p>
			<h2>Where does it come from</h2>
			<p>Neque porro quisquam est qui dolorem ipsum quia dolor sit
				amet, consectetur</p>
			<ul>
				<li>Lorem ipsum dolor sit amet</li>
				<li>Consectetur adipiscing elit</li>
				<li>Praesent pharetra eu mi id varius</li>
				<li>Mauris luctus odio eu arcu lacinia</li>
			</ul>
			<p>Mauris ut ante et lectus facilisis dignissim at et purus. Cras
				posuere leo sed leo pretium molestie. Mauris luctus odio eu arcu
				lacinia mattis. Praesent id orci eu mauris mollis sollicitudin.
				Pellentesque habitant morbi tristique senectus et netus et malesuada
				fames ac turpis egestas. Etiam in cursus velit. Cras nec sem eu erat
				rutrum iaculis. Pellentesque vel diam sed ante facilisis luctus.
				Pellentesque at convallis purus. Donec eu interdum mauris. Ut
				blandit pellentesque nisl ac euismod. Cras eget egestas turpis,
				mollis facilisis elit. Suspendisse lorem dui, fermentum in congue
				in, dignissim eget ex.</p>



		</div>
		<div id="sidebar">
			<p class="vero">Vero provident</p>
			<p>Mauris ut ante et lectus facilisis dignissim at et purus. Cras
				posuere leo sed leo pretium molestie. Mauris luctus odio eu arcu
				lacinia mattis. Praesent id orci eu mauris mollis sollicitudin.
				Pellentesque habitant morbi tristique senectus et netus et malesuada
				fames ac turpis egestas. Etiam in cursus velit. Cras nec sem eu erat
				rutrum iaculis.</p>
			<p class="vero">Officiis</p>
			<p>Phasellus in ipsum sodales, congue lacus vitae, scelerisque
				turpis. In sit amet auctor dolor, laoreet elementum enim. Maecenas
				mollis iaculis quam ac aliquam. Sed tristique ex a quam laoreet
				rhoncus a ac augue. Quisque lacinia est vel lacus vestibulum posuere
				in pharetra quam. Sed congue vel felis non volutpat.</p>
			<p class="vero">Iste quo asperiores</p>
			<img src="images/location.png" alt="lokacija" title="location">
		</div>
		<div id="footer">
			<p id="parag">Copyright @ Lineweb</p>
		</div>

	</div>
</body>
</html>