package org.anansy;

public class CalcServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request,
                         javax.servlet.http.HttpServletResponse response)
            throws java.io.IOException {

        int first, second;
        try {
            first = Integer.parseInt(request.getParameter("first"));
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Левый параметр задан некорректно");
        }

        try {
            second = Integer.parseInt(request.getParameter("second"));
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Правый параметр задан некорректно");
        }

        double result = 0;
        String operation = request.getParameter("operation");
        switch (operation){
            case "+":
                result = first + second;
                break;
            case "-":
                result = first - second;
                break;
            case "*":
                result = first * second;
                break;
            case "/":
                if (second == 0) {
                    throw new ArithmeticException("Делить на 0 нельзя");
                }

                result = (double)first / second;
                break;
        }

        String resultOperation = "+".equals(operation) ? "$" : operation;

        response.sendRedirect(String.format(
                "%s/?first=%d&second=%d&operation=%s&result=%.6f",
                request.getContextPath(), first, second, resultOperation, result
                )
        );
    }
}