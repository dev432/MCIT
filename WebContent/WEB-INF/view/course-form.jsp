<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Create Course</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-course-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>GSS - Grading System School</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Course</h3>
	
		<form:form action="saveCourse" modelAttribute="course" method="POST">
		
		<!--  associate the data with course id -->
		<form:hidden path="courseId"/>
		
			<table>
				<tbody>
					<tr>
						<td><label>Course Name:</label></td>
						<td><form:input path="courseName" /></td>
					</tr>
				
					<tr>
						<td><label>Credits :</label></td>
						<td><form:input path="creditNumber" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/course/list">Back to List</a>
		</p>
	
	</div>

</body>

</html>










