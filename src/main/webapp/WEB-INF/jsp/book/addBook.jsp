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
<h1>书本新增</h1>

<f:form modelAttribute="book" action="${ctx}/book/addBook" method="post">
    书本编号:<f:input path="id"/><f:errors path="id"/><br>
    书本名称: <f:input path="bookname"/><f:errors path="bookname"/> <br>
    书本价格:<f:input path="price"/><f:errors path="price"/><br>
    书本类型:<f:select path="booktype" items="${bType}" itemLabel="bname" itemValue="bvalue" /><br>
    <input type="submit" value="提 交">
</f:form>
</body>
</html>
