

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--<%@include file="/common/head.jsp"%>--%>
</head>
<body>
${bookId}
${param.bookId}
<form action="${ctx}/bookFile/upload" method="post" enctype="multipart/form-data">
    <input type="hidden" name="bookId" value="${bookId}">
    <input type="file" name="img">
    <%--<input type="file" name="img">--%>
    <input type="submit" value="提 交">
</form>
</body>
</html>