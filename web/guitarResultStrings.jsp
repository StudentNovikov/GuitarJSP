<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 02.12.2016
  Time: 11:05
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
    <title>GuitarsWithSpecificStrings</title>
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
    ArrayList<guitar> specificStringGuitars;
    String temp = request.getParameter("stringType");
    if (temp.equals("metal"))
    {
        specificStringGuitars = guitarSELECT.metalStrings(connection);
    } else
    {
        specificStringGuitars = guitarSELECT.nylonStrings(connection);
    }


%>
<table border="1">
    <caption>Все гитары</caption>
    <tr><td>id<%=temp%></td>
        <td>Название</td>
        <td>Цвет</td>
        <td>Тип струн</td>
        <td>Номер бренда</td>
        <td>Цена</td>
    </tr>
    <% for (guitar g:specificStringGuitars ) {%>
    <tr> <td><%=g.getId()%></td><td><%=g.getName()%></td><td><%=g.getColor()%></td><td><%=g.getStringType()%></td>
        <td><%=g.getGuitarBrandId()%></td><td><%=g.getPrice()%></td>
    </tr>
    <%}%>

</table>
<form name="redirectToIndex" action="index.jsp" method="post">
    <input type="submit" name="gotoIndex" value="goBack"/>
</form>
</body>
</html>