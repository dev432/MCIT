<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>


<body>


			<h2>GSS - Grading System School</h2>


			<!-- put new button: Add Customer -->
		
			<input type="button" value="Add Course"
				   onclick="window.location.href='formForAdd'; return false;"
				   class="add-button"
			/>
	
		
		
			<table>
				<tr>
					<th>Course Name</th>
					<th>Credit Number</th>
					
				</tr>
				
				
				<c:forEach var="tempCourse" items="${courses}">
				
					<c:url var="updateLink" value="/course/formForUpdate">
						<c:param name="courseId" value="${tempCourse.courseId}" />
					</c:url>
					
					<c:url var="deleteLink" value="/course/delete">
						<c:param name="courseId" value="${tempCourse.courseId}" />
					</c:url>
					
					
					<tr>
						<td> ${tempCourse.courseName} </td>
						<td> ${tempCourse.creditNumber} </td>
						<td> <a href="${updateLink}">Update</a> 
						     <a href="${deleteLink}"  onclick="if (!(confirm('Are you sure?'))) return false">Delete</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
	

</body>

</html>









