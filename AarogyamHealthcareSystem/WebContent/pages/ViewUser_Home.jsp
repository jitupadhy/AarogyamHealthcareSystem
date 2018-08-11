<%@page import="aarogyam.healthcare.bean.EmployeeBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<script type="text/javascript">
	function func(orderId) {

		document.orderDetailsForm.action = "orderdetails.do?linkOrderId="
				+ orderId;
		document.orderDetailsForm.submit();

	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/app_styles_en.css" />
<title>Orders Inquiry</title>
</head>

<body>

	<%!List<EmployeeBean> employeeList = new ArrayList<EmployeeBean>();%>
	
	<%
		employeeList = (ArrayList) request.getAttribute("employeeList");
	%>

	<form action="ViewUser" method="post" name="orderDetailsForm"
		id="orderDetailsForm">
		<table width="100%" border="0" cellspacing="3" cellpadding="3">
			<tr>
				<td>User ID</td>
				<td><input type="text" name="uname" value="" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
				<td><input type="reset" value="Reset" /></td>
			</tr>
			<tr bgcolor="#CCCCCC">
				<td colspan="10"></td>
			</tr>
			<tr>
				<td class="smallprompt" width="53%">
					<p style="margin-bottom: 10px;">Jitu</p>
				</td>
			</tr>
			<tr>
				<td>
					<table width="100%" class="tableoutline">
						<tr>
							<td>
								<hr>
								<table width="93%" background=#3e3e3e border=1 frame=HSIDES
									rules=ROWS bordercolor=#CCCCCC cellspacing=0
									border-collapse="collapse" border-spacing="0" align="center">
									<tr>
										<td height="20"
											class="tableheadrow gdorderborder gdorderouterlining">
											<div align="center" class="texttab">ID</div>
										</td>
										<td height="20"
											class="tableheadrow gdorderborder gdorderouterlining">
											<div align="center" class="texttab">Name</div>
										</td>
										<td height="20"
											class="tableheadrow gdorderborder gdorderouterlining">
											<div align="center" class="texttab">Emp ID</div>
										</td>
										<td height="20" class="tableheadrow gdorderborder">
											<div align="center" class="texttab">Mail ID</div>
										</td>
										<td height="20" class="tableheadrow gdorderborder">
											<div align="center" class="texttab">City</div>
										</td>
										<td height="20" class="tableheadrow gdorderborder">
											<div align="center" class="texttab">DOB</div>
										</td>
										<td height="20" class="tableheadrow gdorderborder">
											<div align="center" class="texttab">Telephone</div>
										</td>
										<td height="20" class="tableheadrow gdorderborder">
											<div align="center" class="texttab">Role</div>
										</td>
										<td height="20" class="tableheadrow gdorderborder">
											<div align="center" class="texttab">Active</div>
										</td>
										<td height="20" class="tableheadrow gdorderborder">
											<div align="center" class="texttab">Password Duration</div>
										</td>
									</tr>
									<%
										for (EmployeeBean employeeListBean : employeeList) {
									%>
									<tr>
										<td height="20"
											class="normal gdorderborder gdorderouterlining">
											<div align="center">
												<%=employeeListBean.getId()%>
											</div>
										</td>
										<td height="20"
											class="normal gdorderborder gdorderouterlining">
											<div align="center">
												<%=employeeListBean.getEmpName()%>
											</div>
										</td>
										<td height="20"
											class="normal gdorderborder gdorderouterlining">
											<div align="center">
												<%=employeeListBean.getEmpId()%>
											</div>
										</td>
										<td height="20" class="normal gdorderborder">
											<div align="left">
												<%=employeeListBean.getEmpMailId()%>
											</div>
										</td>
										<td height="20" class="normal gdorderborder">
											<div align="left">
												<%=employeeListBean.getEmpCity()%>
											</div>
										</td>
										<td height="20" class="normal gdorderborder">
											<div align="left">
												<%=employeeListBean.getEmpDOB()%>
											</div>
										</td>
										<td height="20" class="normal gdorderborder">
											<div align="left">
												<%=employeeListBean.getEmpTelephone()%>
											</div>
										</td>
										<td height="20" class="normal gdorderborder">
											<div align="left">
												<%=employeeListBean.getEmpRole()%>
											</div>
										</td>
										<td height="20" class="normal gdorderborder">
											<div align="left">
												<%=employeeListBean.getEmpActiveId()%>
											</div>
										</td>
										<td height="20" class="normal gdorderborder">
											<div align="left">
												<%=employeeListBean.getEmpUpdateDate()%>
											</div>
										</td>
									</tr>
									<%
										}
									%>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<p>&nbsp;</p>
		</table>
	</form>
</body>
</html>