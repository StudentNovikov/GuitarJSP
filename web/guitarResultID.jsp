<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 02.12.2016
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<% Class.forName("oracle.jdbc.driver.OracleDriver"); %>
<%@page import="java.sql.*" %>
<%@page import="guitar.Guitar" %>
<%@ page import="DAO.GuitarDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>GuitarResultID</title>
</head>
<body>
<%
    String temp = request.getParameter("id");
    int id = Integer.parseInt(temp);
    Guitar myFirstOneGuitar = GuitarDAO.getInstance().getGuitarWithID(id);
%>
<table border="1">
    <caption>Выбранная гитара с id = <%=id%></caption>

    <tr><td>Название</td>
        <td><%=myFirstOneGuitar.getName()%></td>
    </tr>
    <tr><td>Описание</td>
        <td><%=myFirstOneGuitar.getDescription()%></td>
    </tr>
    <tr><td>Цена</td>
        <td><%=myFirstOneGuitar.getPrice()%></td>
    </tr>
    <tr><td>Тип струн</td>
        <td><%=myFirstOneGuitar.getStringType()%></td>
    </tr>

    </table>
<form name="redirectToIndex" action="index.jsp" method="post">
    <input type="submit" name="gotoIndex" value="goBack"/>
</form>
</body>
</html>
