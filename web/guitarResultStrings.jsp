<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 02.12.2016
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<% Class.forName("oracle.jdbc.driver.OracleDriver"); %>
<%@page import="guitar.Guitar" %>
<%@ page import="java.util.List" %>
<%@ page import="DAO.GuitarDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>GuitarsWithSpecificStrings</title>
</head>
<body>
<%

    List<Guitar> specificStringGuitars;
    String temp = request.getParameter("stringType");
    boolean isMetal;
    if ("metal".equals(temp)){
        isMetal = true;
    } else{
        isMetal = false;
    }

    specificStringGuitars = GuitarDAO.getInstance().getSpecificStringGuitars(isMetal);

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
    <% for (Guitar g:specificStringGuitars ) {%>
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
