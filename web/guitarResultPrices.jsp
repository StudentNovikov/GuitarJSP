<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 02.12.2016
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<% Class.forName("oracle.jdbc.driver.OracleDriver"); %>
<%@page import="guitar.Guitar" %>
<%@ page import="java.util.List" %>
<%@ page import="DAO.GuitarDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String input1 = request.getParameter("lowPrice");
    String input2 = request.getParameter("topPrice");
    // checking if input string is actually a int number
    boolean parsable = true;
    try{
        Double.parseDouble(input1);
        Double.parseDouble(input2);
    }catch(NumberFormatException e){
        parsable = false;
    }

    if (!parsable){ %>
<caption>Введите цифры в формате x.x ,где x - целое число а не просто строчку, например 20 </caption>
    <%} else {
    double lowPrice = Double.parseDouble(input1);
    double topPrice = Double.parseDouble(input2);

    List<Guitar> allGuitars = GuitarDAO.getInstance().getGuitarsWithSpecificPrice(lowPrice,topPrice);
    if (allGuitars.isEmpty()){
    %> <caption>Гитар данной ценовой категории нет</caption> <%
    }
    else {%>


<table border="1">
    <caption>Все гитары из ценовой категории от <%=lowPrice%> до <%=topPrice%></caption>
    <tr><td>id</td>
        <td>Название</td>
        <td>Цвет</td>
        <td>Тип струн</td>
        <td>Бренда</td>
        <td>Цена</td>
    </tr>
    <% for (Guitar g:allGuitars ) {%>
    <tr> <td><%=g.getId()%></td><td><%=g.getName()%></td><td><%=g.getColor()%></td><td><%=g.getStringType()%></td>
        <td><%=g.getGuitarBrand()%></td><td><%=g.getPrice()%></td>
    </tr>
    <%}%>

</table> <%}}%>
<form name="redirectToIndex" action="index.jsp" method="post">
    <input type="submit" name="gotoIndex" value="goBack"/>
</form>

</body>
</html>
