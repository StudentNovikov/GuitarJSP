<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 02.12.2016
  Time: 10:22
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
    <title>GuitarResultID</title>
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

    String temp = request.getParameter("id");
    int id = Integer.parseInt(temp);

    Guitar myFirstOneGuitar = GuitarSELECT.byID(id,connection);

%>
<table border="1">
    <caption>Выбранная гитара с id = <%=id%></caption>

    <tr><td>Название</td>
        <td><%=myFirstOneGuitar.getName()%></td>
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
