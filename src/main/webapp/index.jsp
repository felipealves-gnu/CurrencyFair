<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Currency Fair</title>
    <script type="text/javascript" src="js/libs/jquery/jquery.min.js"></script>
    <script type="text/javascript">
     function send() {
        var tradeMessage = {
            userId: $("#userId").val(),
            currencyFrom: $("#currencyFrom").val(),
            currencyTo: $("#currencyTo").val(),
            amountSell: $("#amountSell").val(),
            amountBy: $("#amountBy").val(),
            rate: $("#rate").val(),
            timePlaced: $("#timePlaced").val(),
            originatingCountry: $("#originatingCountry").val()
        };
      $.ajax({
            beforeSend: function(){
              var user = $.trim($('#userId').val());
              var amountSell = $.trim($('#amountSell').val());
              var amountBy = $.trim($('#amountBy').val());
              var rate = $.trim($('#rate').val());
              var timePlaced = $.trim($('#timePlaced').val());
              var country = $.trim($('#originatingCountry').val());
              
              if (user === '' || amountSell === '' || amountBy === '' || rate === '' || timePlaced === '' || country === '') {
                  alert('There is one or more fields empty.');''
                  return false;
              }
            },
            url: "<%=request.getContextPath()%>/resources/trades/send",
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(tradeMessage)
      });
    }

    </script>
  </head>
  <body>
    <h1>Currency Fair!</h1>
    
    <div id="response">
      <pre></pre>
    </div>
    
    <div id="notification-bar">
      <pre></pre>
    </div>
    
    
    <form id="my-form">
      User Id: <input type="text" id="userId" />
      <br/>
      <br/>
      Currency From: <select id="currencyFrom">
        <option value="EUR">EUR</option>
        <option value="GBP">GBP</option>
      </select>
      <br/>
      <br/>
      Currency To: <select id="currencyTo" >
        <option value="EUR">EUR</option>
        <option value="GBP">GBP</option>
      </select>
      <br/>
      <br/>
      Amount Sell: <input type="text" id="amountSell" />
      <br/>
      <br/>
      Amount By: <input type="text" id="amountBy" />
      <br/>
      <br/>
      Rate: <input type="text" id="rate" />
      <br/>
      <br/>
      TimePlaced: <input type="text" id="timePlaced" />
      <br/>
      <br/>
      Originating Country: <input type="text" id="originatingCountry" />
      <br/>
      <br/>
      <button type="submit" onclick="send();"> Submit </button>
      <a href="tradesList.jsp">List of messages</a>   
    </form>

  </body>
</html>
