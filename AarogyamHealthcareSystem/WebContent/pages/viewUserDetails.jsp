<%@page import="aarogyam.healthcare.bean.EmployeeBean"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% List<EmployeeBean> employeeList = (ArrayList)request.getAttribute("employeeList") ; %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">

		<tr bgcolor="#CBE0F5" height="20px">
			<td bgcolor="#A2A2A2" width="10px"></td>
			<td class="loginbold">Name</td>
		</tr>
		<tr>
			<td colspan="11" bgcolor="#A2A2A2" height="1px"></td>

			<td>
				<%  for(int i=0; i<employeeList.size(); i++){ %> <%=	employeeList.get(i).getEmpName() %></td>
			<td colspan="11" bgcolor="#A2A2A2" height="1px"></td>
		</tr>


		<%} %>
	</table>

</body>
</html>