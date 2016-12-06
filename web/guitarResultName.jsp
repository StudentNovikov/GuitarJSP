<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 02.12.2016
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<% Class.forName("oracle.jdbc.driver.OracleDriver"); %>
<%@page import="guitar.Guitar" %>
<%@ page import="DAO.GuitarDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>GuitarPickedByName</title>
</head>
<body>
<%
    String name = request.getParameter("guitarName");
    Guitar myPickedByName = GuitarDAO.getInstance().getGuitarWithName(name);
%>

<table border="1">
    <caption>Выбранная гитара с названием = <%=name%></caption>

    <tr><td>Название</td>
        <td><%=myPickedByName.getName()%></td>
    </tr>
    <tr><td>Цена</td>
        <td><%=myPickedByName.getPrice()%></td>
    </tr>
    <tr><td>Тип струн</td>
        <td><%=myPickedByName.getStringType()%></td>
    </tr>
    <tr><td>Цвет</td>
        <td><%=myPickedByName.getColor()%></td>
    </tr>
</table>

<form name="redirectToIndex" action="index.jsp" method="post">
    <input type="submit" name="gotoIndex" value="goBack"/>
</form>
</body>
</html>
