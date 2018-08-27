<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>


<body>


			<h2>GSS - Grading System School</h2>


			<!-- put new button: Add Customer -->
		
			<input type="button" value="Add Student"
				   onclick="window.location.href='formForAdd'; return false;"
				   class="add-button"
			/>
	
		
		
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Address</th>
					<th>City</th>
				</tr>
				
				
				<c:forEach var="tempStudent" items="${students}">
				
					<c:url var="updateLink" value="/student/formForUpdate">
						<c:param name="studentId" value="${tempStudent.studentId}" />
					</c:url>
					
					<c:url var="deleteLink" value="/student/delete">
						<c:param name="studentId" value="${tempStudent.studentId}" />
					</c:url>
					
					
					<tr>
						<td> ${tempStudent.firstName} </td>
						<td> ${tempStudent.lastName} </td>
						<td> ${tempStudent.email} </td>
						<td> ${tempStudent.address} </td>
						<td> ${tempStudent.city} </td>
						<td> <a href="${updateLink}">Update</a> 
						     <a href="${deleteLink}"  onclick="if (!(confirm('Are you sure?'))) return false">Delete</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
	

</body>

</html>









