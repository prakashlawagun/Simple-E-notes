<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Notes</title>
<%@include file="/WEB-INF/resources/component/all_link.jsp" %>
</head>
<body>

<%@include file="/WEB-INF/resources/component/navbar.jsp" %>

		<div class="container mt-5">
			<div class="row">
				<div class="col-md-6 offset-md-3">
					<div class="card">
						<div class="card-body">
							<h3>Add Notes</h3>
						</div>
						<div class="card-body">
							<form action="saveNotes" method="post" >
								<div class="mb-3">
									<label>Enter Title</label>
									<input type="text" name="title" class="form-control" placeholder="Title"/>
								</div>
								<div class="mb-3">
									<label>Enter Description</label>
									<textarea rows="6" cols="" name="description" class="form-control" placeholder="Enter Description"></textarea>
								</div>

								<button type="submit" class="btn btn-primary">Save</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
</body>
</html>