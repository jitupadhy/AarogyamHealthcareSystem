<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>


<body>
	<form method="post" action="UpdateContact">
		<center>
			<table border="1" width="30%" cellpadding="5">
				<thead>
					<tr>
						<th colspan="2">Enter Information Here</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>User ID</td>
						<td><input type="text" name="uname" value="" /></td>
					</tr>
					<tr>
						<td>Telephone Number</td>
						<td><input type="text" name="umobilenumber" value="" /></td>
					</tr>
					<tr>
						<td>Confirm Telephone Number</td>
						<td><input type="text" name="confirmumobilenumber" value="" /></td>
					</tr>

					<tr>
						<td><input type="submit" value="Submit" /></td>
						<td><input type="reset" value="Reset" /></td>
					</tr>

				</tbody>
			</table>
		</center>
	</form>
</body>


</html>