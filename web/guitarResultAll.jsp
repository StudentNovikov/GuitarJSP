<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 02.12.2016
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<% Class.forName("oracle.jdbc.driver.OracleDriver"); %>
<%@page import="guitar.Guitar" %>
<%@ page import="java.util.List" %>
<%@ page import="DAO.GuitarDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>GuitarAll</title>
</head>
<body>
<%
    List<Guitar> allGuitars = GuitarDAO.getInstance().getAllGuitars();
%>
<table border="1">
    <caption>Все гитары</caption>
    <tr><td>id</td>
        <td>Название</td>
        <td>Цвет</td>
        <td>Тип струн</td>
        <td>Номер бренда</td>
        <td>Цена</td>
    </tr>
    <% for (Guitar g:allGuitars ) {%>
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
