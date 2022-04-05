package com.example.prohw1;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicIntegerArray;

@WebServlet (name = "stat", value = "/stat")
public class Stat extends HttpServlet {
    private AtomicIntegerArray qt1 = new AtomicIntegerArray(2);
    private AtomicIntegerArray qt2 = new AtomicIntegerArray(2);

    @Override
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String rqt1 = request.getParameter("qt1");
        String rqt2 = request.getParameter("qt2");

        if (rqt1 != null && rqt2 != null) {
            if (rqt1.equals("a")) {
                qt1.getAndIncrement(0);
            }
            if (rqt1.equals("b")) {
                qt1.getAndIncrement(1);
            }

            if (rqt2.equals("a")) {
                qt2.getAndIncrement(0);
            }
            if (rqt2.equals("b")) {
                qt2.getAndIncrement(1);
            }

            PrintWriter out = response.getWriter();
            out.println("<table border=\"1\">");
            out.println("<tr>");
            out.println("<td>statistics</td>");
            out.println("<td>answer A</td>");
            out.println("<td>answer B</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Question 1</td>");
            out.println("<td>" + qt1.get(0) + "</td>");
            out.println("<td>" + qt1.get(1) + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Question 2</td>");
            out.println("<td>" + qt2.get(0) + "</td>");
            out.println("<td>" + qt2.get(1) + "</td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("<p><a href=\"index.html\">Again</a></p>");
        } else {
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"ua\">");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>error</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<p>You did not specify an answer </p>");
            out.println("<p><a href=\"index.html\">Please try again</a></p>");


            out.println("</body>");
            out.println("</html>");

        }


}
}
