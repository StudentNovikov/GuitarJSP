<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 02.12.2016
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<% Class.forName("oracle.jdbc.driver.OracleDriver"); %>

<%@page import="guitar.Guitar" %>
<%@ page import="DAO.GuitarDAO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>BrandedGuitars</title>
</head>
<body>
<%
    String brand = request.getParameter("brand");
    List<Guitar> allGuitars = GuitarDAO.getInstance().getGuitarWithBrand(brand);
    if (allGuitars.isEmpty()){
%> <caption>Гитар данного бренда нет</caption> <%
}
else {%>

<table border="1">
    <caption>Все гитары бренда  <%=brand%></caption>
    <tr><td>id</td>
        <td>Название</td>
        <td>Цвет</td>
        <td>Тип струн</td>
        <td>Бренд</td>
        <td>Цена</td>
    </tr>
    <% for (Guitar g:allGuitars ) {%>
    <tr> <td><%=g.getId()%></td><td><%=g.getName()%></td><td><%=g.getColor()%></td><td><%=g.getStringType()%></td>
        <td><%=g.getGuitarBrand()%></td><td><%=g.getPrice()%></td>
    </tr>
    <%}%>

</table> <%}%>
<form name="redirectToIndex" action="index.jsp" method="post">
    <input type="submit" name="gotoIndex" value="goBack"/>
</form>
</body>
</html>
