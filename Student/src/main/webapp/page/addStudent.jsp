<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="../includes/header.jsp" %>
hello student

<spring:url value="/addStudent" var="userActionUrl" />
<form:form modelAttribute="student" method="post" action="${userActionUrl}">

		<form:errors />
		<div class="form-group">
			<form:label path="first_name">First Name</form:label>
			<form:input path="first_name" type="text" class="form-control"
				id="exampleInputEmail1" placeholder="First Name" />
			<form:errors path="first_name" cssClass="text-danger" />
		</div>
		<div class="form-group">
			<form:label path="last_name">Last Lame</form:label>
			<form:input path="last_name" type="text" class="form-control"
				id="exampleInputEmail1" placeholder="Last Name" />
			<form:errors path="last_name" cssClass="text-danger" />
		</div>
		<div class="form-group">
			<form:label path="father_name">Father Name</form:label>
			<form:input path="father_name" type="text" class="form-control"
				id="exampleInputEmail1" placeholder="Father Name" />
			<form:errors path="father_name" cssClass="text-danger" />
		</div>
		<div class="form-group">
			<form:label path="email">Email ID</form:label>
			<form:input path="email" type="text" class="form-control"
				id="exampleInputEmail1" placeholder="Email ID" />
			<form:errors path="email" cssClass="text-danger" />
		</div>
		<div class="form-group">
			<form:label path="cls">Class</form:label>
			<form:input path="cls" type="text" class="form-control"
				id="exampleInputPassword1" placeholder="Class" />
			<form:errors path="cls" cssClass="text-danger" />
		</div>
		<div class="form-group">
			<form:label path="age">Age</form:label>
			<form:input path="age" type="text" class="form-control"
				id="exampleInputName1" placeholder="Age" />
			<form:errors path="age" cssClass="text-danger" />
		</div>
		
		
		<button type="submit" class="btn btn-primary">Submit</button>		
	
	</form:form>
<%@include file="../includes/footer.jsp" %>