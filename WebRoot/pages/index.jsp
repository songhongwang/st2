<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	This is my JSP page.
	<br> 欢迎
	<br> message:
	<s:property value="message" />
	sex:
	<s:property value="sex" />
	answer
	<s:property value="answer" />
	<br>
<center>
	<s:form action="test_showPost" method="post" theme="simple" j>
		<table>
			<tr>
				<td><s:select
						list="{'Windows','Linux','Java','.net','Pertl','PHP'}"
						name="program" tooltip="select your program" /></td>
			</tr>
			<tr>
				
			</tr>
			<tr>
				<td><s:checkboxlist name="skills1" label="Skills 1"
						tooltip="bulktree" list="{'Java', '.Net', 'RoR', 'PHP' }"
						value="{'Java', '.Net' }" /></td>
			</tr>
			<tr>
				<td><s:checkboxlist name="skills2" label="Skills 2"
						tooltip="bulktree" list="#{1:'Java', 2:'.Net', 3:'RoR', 4:'PHP' }"
						listKey="key" listValue="value" value="{1, 2, 3 }" /></td>
			</tr>
			<tr>
				<td><s:doubleselect label="doubleselect test1" name="menu"
						list="{'fruit','other'}" doubleName="dishes"
						doubleList="top == 'fruit' ? {'apple', 'orange'} : {'monkey', 'chicken'}" />
				</td>
			</tr>
			<tr>
				<td><s:updownselect label="Favourite Countries"
						list="#{'england':'England', 'america':'America', 'germany':'Germany'}"
						name="prioritisedFavouriteCountries" headerKey="-1"
						headerValue="--- Please Order Them Accordingly ---"
						emptyOption="true" /></td>
			</tr>
			<tr>
				<td><s:optiontransferselect
						tooltip="Select Your Favourite Cartoon Characters"
						label="Favourite Cartoons Characters"
						name="leftSideCartoonCharacters" leftTitle="Left Title"
						rightTitle="Right Title" list="{'Popeye', 'He-Man', 'Spiderman'}"
						multiple="true" headerKey="headerKey"
						headerValue="--- Please Select ---" emptyOption="true"
						doubleList="{'Superman', 'Mickey Mouse', 'Donald Duck'}"
						doubleName="rightSideCartoonCharacters"
						doubleHeaderKey="doubleHeaderKey"
						doubleHeaderValue="--- Please Select ---" doubleEmptyOption="true"
						doubleMultiple="true" /></td>

			</tr>

			<tr>

				<td><s:submit ></s:submit></td>

			</tr>

		</table>

	</s:form>
	</center>
</body>
</html>
