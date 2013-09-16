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
	<style type="text/css">
	
		.sp{background-color: gray;}
	</style>
	
	
</head>

<body>
	This is my JSP page.
	<br> book
	-----------------------------------<br>
	<s:merge var="m">
	<s:param value="%{books}"></s:param>
	<s:param value="%{books2}"></s:param>
</s:merge>

<s:iterator value="m" >
	<s:property/>
</s:iterator>
<br>
<s:iterator value="books2" >
	<s:property/>
</s:iterator>

---------------------------------------
	<br>
	=====================================generator====<br>
		<s:generator separator="," val="%{'aaa,ccc,dddd,bbbb'}"   converter="%{myConverter}">
			<s:sort comparator="%{myComparator}">
				<s:iterator status="st">
					<s:if test="%{#st.odd}">
					<span class="sp"><s:property/></span>
					</s:if>
					<s:else>
					<span><s:property/></span>
					</s:else>
					 <br>
				</s:iterator>
			 </s:sort>
		</s:generator>
		---------------------------generator-----------------<br>
		<s:property value="books"/>
	bname= <s:property value="#parameters.bname[0]" /><br>
	<s:select list="%{books2}"></s:select><br>
	-------------------------------------<br>
	<s:set name="myMap" value="#{'key1':'value1','key2':'value2'}" />

	<s:property value="#myMap['key1']" />

	<s:url value="#myMap['key1']" />

	<s:set name="myMap" value="#{'key1':'value1','key2':'value2'}" />

	<s:property value="%{#myMap['key1']}" />

	<s:url value="%{#myMap['key1']}" /><br>
	
		
=========================================<br>
-----------------------------------------------
控制标签中最重要的.它可以用来遍历一个数组、Collection或一个Map，并把这个可遍历对象里的每一个元素依次压入和弹出Value Stack的根栈顶部。<br>
		<s:iterator value="%{books}" var="s">iterator迭代以后会把元素压到valuestack栈中
			<s:property/>
		</s:iterator><br>
		-----------------------------------<br>
<s:merge var="m">
	<s:param value="%{books}"></s:param>
	<s:param value="%{books2}"></s:param>
</s:merge>

<s:iterator value="m">
	<s:property/>
</s:iterator>
===========================<br>
<s:a href="http://www.baidu.com/s?wd=struts2">http://www.baidu.com</s:a>
<s:action name="Author_add">Author动作</s:action>
--------------------------------<br>
<s:debug></s:debug>
------------------------decider---------------------<br>
<s:generator separator="," val="%{'aaaaaa,ccc,ddddd,bbbb'}" var="strs">
	<s:subset decider="%{myDecider}" source="#strs">
	<s:iterator>
		<s:property/><br>
	</s:iterator>
	</s:subset>
</s:generator>
---------------------------------------------<br>
<s:date name="publish" format="yyyy年MM月dd" /><br>
 
<s:date name="publish" nice="true" /><br>
<s:date name="publish" /><br>
</body >
</html>
