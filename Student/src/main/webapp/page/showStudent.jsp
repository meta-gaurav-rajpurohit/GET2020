<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../includes/header.jsp" %>

<table class="table table-striped">
    <thead>
      <tr>
      	<th>First Name</th>
        <th>Last Name</th>
        <th>Father Name</th>
        <th>Email</th>
        <th>Age</th>
        <th>Class</th>
      </tr>
    </thead>
    <tbody>
    
    <c:forEach items="${students}" var="student">
      
 <tr>   <td>${student.first_name}</td>
        <td>${student.last_name}</td>
        <td>${student.father_name}</td>
        <td>${student.email}</td>
        <td>${student.age}</td>
        <td>${student.cls}</td>
         <td><a href="/showStudent/${student.email}" class="btn btn-primary">Edit</a> </td>
      </tr>

		</c:forEach>

    </tbody>
  </table>



<%@include file="../includes/footer.jsp" %>

