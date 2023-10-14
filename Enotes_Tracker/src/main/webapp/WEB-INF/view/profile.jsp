<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/WEB-INF/resources/component/all_link.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/resources/component/navbar.jsp" %>
	<h2>Welcome,${loginuser.fullName}</h2>
	
	
</body>
</html>