<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.currencyfair.ejbs.TradeBean" %> 
<%@ page import="com.currencyfair.pojos.TradeMessage" %> 
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.Context" %>

<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Currency Fair</title>
  </head>
  <body>
    <%! TradeBean tradeBean;%>
    <%
        Context context = null;
        List<TradeMessage> tradeMessages;
        try {
            context = new InitialContext();
            tradeBean = (TradeBean) context.lookup("java:global/Currency/TradeBean");
            tradeMessages = tradeBean.getTrades();
            request.setAttribute("trades", tradeMessages);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    %>
    <h1>List of messages</h1>

    <table BORDER="1" CELLPADDING="3" CELLSPACING="1">
      <tr>
        <th>User Id</th>
        <th>Currency From</th>
        <th>Currency To</th>
        <th>Amount Sell</th>
        <th>Amount By</th>
        <th>Rate</th>
        <th>Time Placed</th>
        <th>Originating Country</th>
      </tr>      
              
      <c:forEach items="${requestScope.trades}" var="message">
        <tr>
          <td>${message.userId}</td>
          <td>${message.currencyFrom}</td>
          <td>${message.currencyTo}</td>
          <td>${message.amountSell}</td>
          <td>${message.amountBy}</td>
          <td>${message.rate}</td>
          <td>${message.timePlaced}</td>
          <td>${message.originatingCountry}</td>
        </tr>
      </c:forEach>
    </table>      
    <br/>
    <a href="index.jsp">Currency Fair</a>   
  </body>
</html>
