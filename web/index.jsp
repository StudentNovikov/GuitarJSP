<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 29.11.2016
  Time: 3:16
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
    <title>$Title$</title>
  </head>
  <body>
  <form name="myForm1" action="guitarResultID.jsp" method="post">
    <table>
        <tr><td>Выбрать гитару по id(например, id=2)</td> </tr>
       <tr> <td><input type="text" name="id" value="" size="50"/></td>
      </tr>

      </table>
       <input type="submit" value="guitarID" name="guitarID"/>
  </form>

  <form name="myForm2" action="guitarResultName.jsp" method="post">
      <table>
          <tr><td>Выбрать гитару по названию(например, Hummingbird)</td> </tr>
          <tr> <td><input type="text" name="guitarName" value="" size="50"/></td> </tr>
      </table>
      <input type="submit" value="guitarName" name="guitarName"/>
  </form>

  <form name="myForm3" action="guitarResultAll.jsp" method="post">
      <table>
          <tr><td>Выбрать все гитары</td> </tr>
      </table>
      <input type="submit" value="guitarAll" name="guitarAll"/>
  </form>

  <form name="myForm4" action="guitarResultStrings.jsp" method="post">
      <table>
          <tr><td>Выбрать тип струн</td> </tr>
          <tr> <td><input name="stringType" type="radio" value="metal"> Металлические   </td></tr>
          <tr> <td><input name="stringType" type="radio" value="nylon"> Нейлоновой </td> </tr>
      </table>
      <input type="submit" value="guitarStrings" name="guitarStringType"/>
  </form>

  <form name="myForm5" action="guitarResultPrices.jsp" method="post">
      <table>
          <tr><td>Указать ценовой диапазон(например 200, 1500)</td> </tr>
          <tr> <td><input type="text" name="lowPrice" value="минимальная цена" size="50"/></td> </tr>
          <tr> <td><input type="text" name="topPrice" value="максимальная цена" size="50"/></td> </tr>
      </table>
      <input type="submit" value="guitarPrice" name="guitarPrice"/>
  </form>

  <form name="myForm6" action="guitarResultBrand.jsp" method="post">
      <table>
          <tr><td>Выбрать гитару по бренду(1-5)</td> </tr>
          <tr> <td><input type="text" name="brand" value="" size="50"/></td>
          </tr>
      </table>
      <input type="submit" value="guitarBrand" name="guitarBrand"/>
  </form>
  </body>
</html>
