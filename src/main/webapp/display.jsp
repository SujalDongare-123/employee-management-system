<%@ page import="java.util.List, in.soft.entity.Employee"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee List</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/style.css">
</head>

<body>

	<nav class="navbar navbar-dark px-4">
		<span class="navbar-brand">Employee System</span>
	</nav>

	<div class="container mt-5">

		<h2 class="text-center title mb-4">Employee List</h2>

		<%
		List<Employee> list = (List<Employee>) request.getAttribute("data");
		%>

		<div class="table-container">

			<table class="table custom-table text-center">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Email</th>
						<th>Salary</th>
						<th>Action</th>
					</tr>
				</thead>

				<tbody>

					<%
					if (list != null && !list.isEmpty()) {
						for (Employee e : list) {
					%>

					<tr>
						<td><%=e.getId()%></td>
						<td><%=e.getName()%></td>
						<td><%=e.getEmail()%></td>
						<td><%=e.getSalary()%></td>
						<td><a
							href="update.html?id=<%=e.getId()%>&name=<%=e.getName()%>&email=<%=e.getEmail()%>&salary=<%=e.getSalary()%>"
							class="btn btn-warning btn-sm">Update</a>
							 <a
							href="delete?id=<%=e.getId()%>" class="btn btn-danger btn-sm"
							onclick="return confirm('Delete this employee?')">Delete</a>
	
							</td>
	
							
					</tr>

					<%
					}
					} else {
					%>

					<tr>
						<td colspan="5">No Data Found</td>
					</tr>

					<%
}
%>

				</tbody>
			</table>

<div class="text-center mt-3">
    <a href="index.html" class="btn btn-secondary">Back</a>
</div>

		</div>

	</div>

</body>
</html>