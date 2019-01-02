
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/head.jsp"%>
</head>
<body>
<h2><t:message code="label.mag1"/></h2>
<%--<a href="${ctx}/toHome">点我一下</a><br>--%>
<%--<a href="${ctx}/input/a">再点我一下</a><br>--%>
<%--<a href="${ctx}/input/book/addBook">书本新增</a><br>--%>
<%--<a href="${ctx}/input/book/bookList">书本查询</a><br>--%>

<%--${param.message}--%>
<a href="${ctx}/toHome1?str=zh">中文</a>
<a href="${ctx}/toHome1?str=en">English</a>
<br>
<a href="${ctx}/toHome"><t:message code="label.mag2"/></a><br>
<%--<a href="${ctx}/input/a">再点我一下</a><br>--%>
<a href="${ctx}/book/toAdd"><t:message code="label.mag3"/></a><br>
<a href="${ctx}/book/toList"><t:message code="label.mag4"/></a><br>
<a href="${ctx}/book/toList1">查询分页返回JSON格式</a><br>
<a href="${ctx}/book/toList2?id=1">查询单个返回JSON格式</a><br>
</body>
</html>
