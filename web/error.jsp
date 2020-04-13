<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Кулькулятор</title>
  </head>
  <body>

  <%@ page isErrorPage="true" %>

  В процессе вычисления возникла ошибка:<br>
  <%= exception == null ? "Неизвестная ошибка" : exception.getMessage() %> <br>

  <br>
  <a href="${pageContext.request.contextPath}/">Вернуться к калькулятору</a>

  </body>
</html>
