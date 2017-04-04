<!DOCTYPE html>
<html lang="en">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<head>
<title>Bootstrap Case</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	function newDoc() {
		window.location.assign("http://localhost:6060/SCFE1/")

	}
</script>
<style type="text/css">
body {
	background-color:  #66D194;
	background-image: url("paper.gif");
}
</style>

</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">

			<ul class="nav navbar-nav">
				<li class="active"><a href="#" type="button" onclick="newDoc()"><span
						class="glyphicon glyphicon-home  "></span>Home</a></li>

				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Electronics <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="laptop">Laptops</a></li>
						<li><a href="mobile">Mobile</a></li>
						<li><a href="#">Pagers</a></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Appliances<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Refrigerator</a></li>
						<li><a href="#">Washing Machines</a></li>
						<li><a href="#">Kitchen Appliances</a></li>
					</ul></li>

			</ul>
		</div>
	</nav>


</body>
</html>
