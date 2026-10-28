package com.arti;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class HelloServlet extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        out.println("<html><body><H1> Hello, World</H1></html></body>");
    }
}
      