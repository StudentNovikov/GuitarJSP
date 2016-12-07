<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 02.12.2016
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<% Class.forName("oracle.jdbc.driver.OracleDriver"); %>
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
    // checking if input string is actually a int number
    boolean parsable = true;
    try{
        Integer.parseInt(temp);
    }catch(NumberFormatException e){
        parsable = false;
    }
    if (!parsable){ %>
       <caption>Введите цифру, а не просто строчку, например 20 </caption>
    <%} else {
    int id = Integer.parseInt(temp);
    Guitar myPickedById= GuitarDAO.getInstance().getGuitarWithID(id);

    if (null == myPickedById.getName()) { %>
    <caption>Гитары с таким id не существует</caption> <% } else {
    %>


<table border="1">
    <caption>Выбранная гитара с id = <%=id%></caption>

    <tr><td>Название</td>
        <td><%=myPickedById.getName()%></td>
    </tr>
    <tr><td>Описание</td>
        <td><%=myPickedById.getDescription()%></td>
    </tr>
    <tr><td>Цена</td>
        <td><%=myPickedById.getPrice()%></td>
    </tr>
    <tr><td>Тип струн</td>
        <td><%=myPickedById.getStringType()%></td>
    </tr>
    <tr><td>Пример работы toString()</td>
        <td><%=myPickedById.toString()%></td>
    </tr>

    </table> <%}}%>
<form name="redirectToIndex" action="index.jsp" method="post">
    <input type="submit" name="gotoIndex" value="goBack"/>
</form>
</body>
</html>
