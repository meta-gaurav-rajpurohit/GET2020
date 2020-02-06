<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.sql.*, system.DatabaseConnectivity, javax.servlet.http.HttpSession"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	margin: 0;
}

* {
	box-sizing: border-box;
}
/* Header/logo Title */
.header {
	padding: 80px;
	text-align: center;
	background: #1abc9c;
	color: white;
}

/* Increase the font size of the heading */
.header h1 {
	font-size: 40px;
}

.navbar {
	overflow: hidden;
	background-color: #333;
	position: sticky;
	top: 0;
}

/* Style the navigation bar links */
.navbar a {
	float: left;
	display: block;
	color: white;
	text-align: center;
	padding: 14px 20px;
	text-decoration: none;
}

/* Right-aligned link */
.navbar a.right {
	float: right;
}

/* Change color on hover */
.navbar a:hover {
	background-color: #ddd;
	color: black;
}

/* Active/current link */
.navbar a.active {
	background-color: #666;
	color: white;
}

.avt {
	width: 100px;
	border: 1px solid black;
	border-radius: 50%;
	margin: 12px 0 12px 0;
	text-align: center;
	border: none;
}

fieldset {
	margin: 80px auto;
	padding: 20px;
	padding-bottom: 0px;
	width: 800px;
	height: auto;
	border-radius: 25px;
	border: none;
	background: rgba(175, 238, 238, 0.575);
	box-shadow: 5px 25px 25px rgba(175, 238, 238, 0.575);
}

legend {
	text-align: center;
}

.column {
	float: left;
	width: 25%;
	padding: 0 10px;
	display: inline-block;
}

.row:after {
	content: "";
	display: table;
	clear: both;
}

.row {
	margin: 0 10px;
	overflow: auto;
	width: 100%;
	height: 160px;
	white-space: nowrap;
}

.card {
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
	padding: 16px;
	text-align: center;
	background-color: #f1f1f1;
}

.footer {
	padding: 10px;
	text-align: center;
	background: #ddd;
}

table {
	margin-right: 205px;
}

table, th, td {
	border: none;
	border-collapse: collapse;
}

th, td {
	padding: 15px;
}

th {
	text-align: left;
}

table {
	margin: auto;
}
</style>
</head>
<body>
	<%
	    response.setHeader("Cache-Control",
						"no-cache, no-store, must-revalidate");
				if (session.getAttribute("emailId") == null) {
					response.sendRedirect("loggin.html");
					return;
				}
				int id = (int) session.getAttribute("empId");
				System.out.println(id);
	%>
	<div class="header">
		<h1>Metacube Parking System</h1>
		<!--   <p>A <b>responsive</b> website created by me.</p> -->
	</div>
	<nav class="navbar"> <a href="#home" class="active">Home</a> <a
		href="vehicleRegistration.html?empId=<%=id%>">Vehicle Registration</a>
	<a href="Update.jsp">Update</a> <a href="changePassword.html">Change
		Password</a> <a href="#tour">About us</a> <a
		href="http://localhost:8006/System/logout" class="right">Log Out</a> </nav>
	<section> <img class="mySlides" src="po.jpg"
		style="width: 100%"> <img class="mySlides" src="parking1.jpg"
		style="width: 100%"> <img class="mySlides" src="parking2.jpg"
		style="width: 100%"> <img class="mySlides" src="parking3.jpg"
		style="width: 100%"> <img class="mySlides" src="parking4.jpg"
		style="width: 100%"> <script>
			// Automatic Slideshow - change image every 3 seconds
			var myIndex = 0;
			carousel();

			function carousel() {
				var i;
				var x = document.getElementsByClassName("mySlides");
				for (i = 0; i < x.length; i++) {
					x[i].style.display = "none";
				}
				myIndex++;
				if (myIndex > x.length) {
					myIndex = 1
				}
				x[myIndex - 1].style.display = "block";
				setTimeout(carousel, 3000);
			}
		</script> <%
     DatabaseConnectivity dc = DatabaseConnectivity.getInstance();
     dc.connection();
     int empId = (int) session.getAttribute("empId");
     ResultSet rss = dc.userInformation(empId);
     rss.next();
 %>

	<div class="empForm">
		<fieldset>
			<legend>
				<img src="Avatar.jpg" class="avt">
			</legend>
			<table id="information">
				<tr>
					<th colspan="3" id="personalInformText"><h2>Personal
							Information</h2></th>
				</tr>
				<tr>
					<th>Employee ID</th>
					<th>:</th>
					<td id="idInReceipt"><%=empId%></td>

				</tr>
				<tr>
					<th>Name</th>
					<th>:</th>
					<td id="nameInReceipt"><%=rss.getString("name")%></td>

				</tr>
				<tr>
					<th>Email ID</th>
					<th>:</th>
					<td id="nameInReceipt"><%=rss.getString("emailId")%></td>

				</tr>
				<tr>
					<th>Organization</th>
					<th>:</th>
					<td id="nameInReceipt"><%=rss.getString("organization")%></td>

				</tr>
				<tr>
					<th>Mobile Number</th>
					<th>:</th>
					<td id="numberInReceipt"><%=rss.getString("number")%></td>
				</tr>
				<tr>
					<th>Gender</th>
					<th>:</th>
					<td id="genderInReceipt"><%=rss.getString("gender")%></td>

				</tr>

			</table>

		</fieldset>
	</div>
	</section>
	<h2>Friends</h2>

	<div class="row">

		<%
		    dc.close();

		    ResultSet rs = null;
		    dc.connection();

		    rs = dc.friendsList(empId);
		    System.out.println(rs);
		    while (rs.next()) {
		%>

		<div class="column">
			<div class="card">
				<h3><%=rs.getString("name")%></h3>
				<p><%=rs.getString("organization")%></p>
				<p><%=rs.getString("emailId")%></p>
			</div>
		</div>

		<%
		    }
		    dc.close();
		%>
	</div>

	<div class="footer">
		<h2>Footer</h2>
	</div>

</body>
</html>