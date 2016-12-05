<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 02.12.2016
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<% Class.forName("oracle.jdbc.driver.OracleDriver"); %>
<%@page import="java.sql.*" %>
<%@page import="workingWithBase.GuitarSELECT" %>
<%@page import="guitar.Guitar" %>
<%@page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>GuitarPickedByName</title>
</head>
<body>
<%
    Connection connection = null;
    try {
        connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE", "ALEX","123qwe456asd");
    } catch (SQLException e) {
        e.printStackTrace();
    }

    String name = request.getParameter("guitarName");

    Guitar myPickedByName = GuitarSELECT.byName(name,connection);

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
