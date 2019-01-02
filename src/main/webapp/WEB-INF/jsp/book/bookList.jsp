<%--
  Created by IntelliJ IDEA.
  User: AJG
  Date: 2018/12/27
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/head.jsp"%>
</head>
<body>
<h1>书本查询</h1>
<form action="${ctx}/book/toList" method="post">
    <input type="text" name="bookname">
    <input type="submit" value="查 询">
</form>
<table width="100%" border="1" cellpadding="0" cellspacing="0" >
    <tr>
        <th>书本编号</th>
        <th>书本名称</th>
        <th>书本价格</th>
        <th>书本类型</th>
        <th>书本图片</th>
        <th>操作</th>
    </tr>

    <c:forEach items="${rows}" var="lst">
        <tr>
            <th>${lst.id}</th>
            <th>${lst.bookname}</th>
            <th>${lst.price}</th>
            <th>${lst.booktype}</th>
            <th>
                <c:if test="${empty lst.photo}">
                    图片未下载
                </c:if>
                <c:if test="${not empty lst.photo}">
                    图片已下载
                </c:if>
            </th>

            <th>
                <c:if test="${empty lst.photo}">
                    <a href="${ctx}/bookFile/toBookFile?bookId=${lst.id}">图片上传</a>
                </c:if>
                <c:if test="${not empty lst.photo}">
                    <a href="${ctx}/bookFile/download?fileId=${lst.photo}">图片下载</a>

                </c:if>
            </th>
        </tr>
    </c:forEach>
</table>
${pageBean}
</body>
</html>
