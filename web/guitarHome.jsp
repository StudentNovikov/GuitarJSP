<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 02.12.2016
  Time: 5:33
  To change this template use File | Settings | File Templates.
--%>
<% Class.forName("oracle.jdbc.driver.OracleDriver"); %>
<%@page import="java.sql.*" %>
<%@page import="workingWithBase.guitarSELECT" %>
<%@page import="guitar.guitar" %>
<%@page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>





<html>
<head>
    <title>Guitar</title>
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
    guitar myFirstOneGuitar = guitarSELECT.byID(2,connection);

%>
<table border="1">
    <caption>моя первая гитарная страница</caption>

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
</body>
</html>
