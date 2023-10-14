<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
							<form method="post" action="updateNotes">
								<div class="mb-3">
									<label>Enter Title</label>
									<input type="text" name="title" class="form-control" placeholder="Title" value="${notes.title}"/>
								</div>
								<div class="mb-3">
									<label>Enter Description</label>
									<textarea rows="6" cols="" class="form-control" placeholder="Enter Description">${notes.description}</textarea>
								</div>
								<input type="hidden" id="id" value="${notes.id}">
								<button type="submit" class="btn btn-primary">Update</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>

</body>
</html>