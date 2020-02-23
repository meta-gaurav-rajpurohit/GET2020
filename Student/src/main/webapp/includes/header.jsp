<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>


body {
	font-family: Arial, Helvetica, sans-serif;
	margin: 0;
}

* {
	box-sizing: border-box;
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
</style>

<meta charset="UTF-8">
<title>Home</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="/lib/bootstrap-4.1.3-dist/css/bootstrap.min.css">
</head>
<body>
 <nav class="navbar"> 
 	<a href="#home" class="active">Home</a> 
 	<a href="/addStudent">Add Student</a>
	<a href="/showStudent">Show Student</a> 
 </nav>

<div class="container">
  
