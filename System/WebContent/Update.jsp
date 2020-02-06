<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.sql.*, system.DatabaseConnectivity, javax.servlet.http.HttpSession"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Styling.css">
<script src = 'registration.js'></script>
</head>
<body>
<%
ResultSet rs = null;
DatabaseConnectivity dc = DatabaseConnectivity.getInstance();
dc.connection();

rs = dc.searchData((int) session.getAttribute("empId"));
System.out.println(rs);

String M1 ="",M2 ="",M3 ="";
System.out.println("hello:"+rs.getString("organization"));
if("M1".equals(rs.getString("organization"))){
    M1 = "select";
}else if("M1".equals(rs.getString("organization"))){
    M2 = "select";
}else{
    M3 = "select";
}

%>
        <div id = "containRegistrationForm" class = "empForm">
            <div class = "empFormHeading">
                <h1>UPDATE</h1>
            </div>
            <form action = "Update" method = "post">
                
                <fieldset>
                <legend>Name</legend>
                <input id = "Name" class = "input" type = "text" name = "Name" placeholder = "Name" value = <%=rs.getString("name")%> required/><br>
                </fieldset>

                <fieldset>
                    <legend>Email ID</legend>
                    <input id = "EmailID" class = "input" type = "email" name = "email" placeholder = "Email ID" value = <%=rs.getString("emailId")%> required/><br>
                </fieldset>
                
                <fieldset>
                    <legend>Mobile Number</legend>
                    <input id = "MobileNumber" class = "input" type = "text" name = "number" placeholder = "Mobile Number" value = <%=rs.getString("number")%> required/><br>
                </fieldset>
           
				<select id = "Organization" name = "Organization">
				
                    <option value = "M1" <%=M1 %> >M1</option>
                    <option value = "M2" <%=M2 %>>M2</option>
                    <option value = "M3" <%=M3 %>>M3</option>
                </select><br>
                
                <input id = "submitRegistration" type = "submit" value="SUBMIT" onclick = "registration()"/>
                
                <br><br><br>
                
            </form>
        </div>
        <%dc.close(); %>>
</body>
</html>