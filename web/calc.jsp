<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Кулькулятор</title>
  </head>
  <body>

  <%!
    String get(javax.servlet.http.HttpServletRequest request, String parameterName) {
      return request.getParameter(parameterName) == null ? "" : request.getParameter(parameterName);
    }

    String convert(String source, String from, String to) {
      if (source.equals(from)) return to;
      return source;
    }
  %>

  <form action="${pageContext.request.contextPath}/calc.jsp" method="post">

    <%@ page errorPage="error.jsp" %>

    <label>
      <input type="text" size="40" name="first" value="<%= get(request, "first")%>">
    </label>

    <button type="submit" name="operation" value="+">+</button>
    <button type="submit" name="operation" value="-">-</button>
    <button type="submit" name="operation" value="*">*</button>
    <button type="submit" name="operation" value="/">/</button>


    <label>
      <input type="text" size="40" name="second" value="<%= get(request, "second")%>">
    </label>

    <br>

    <label>
      <input name="result" readonly size="40" type="text" value="
        <%= "".equals(get(request, "result"))
          ? ""
          : get(request, "first") + convert(get(request, "operation"), "$", "+") + get(request, "second") + "=" + get(request, "result")
        %>
      ">
    </label>
  </form>
  </body>
</html>
