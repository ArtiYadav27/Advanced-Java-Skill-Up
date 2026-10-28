package com.arti.sample;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/LifeCycleServlet")
public class LifeCycleServlet extends HttpServlet{
    private String output; //immutable thread safe

    @Override
    public void init() throws ServletException{
        output= "advance java concept from init to service  method";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        res.setContentType("text/html");
        try(PrintWriter out=res.getWriter()){
            out.println(output); //thread safe
        }
    }

    @Override
    public void destroy(){
        System.out.println("Servlet destroyed");
    }
}
