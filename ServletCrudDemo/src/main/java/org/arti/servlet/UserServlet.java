package org.arti.servlet;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.arti.model.User;
import org.arti.service.UserService;

import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    private UserService userService=new UserService();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Integer id=Integer.parseInt(req.getParameter("id"));
        String name=req.getParameter("name");
        String email=req.getParameter("email");
        String mobile=req.getParameter("mobile");
        if( id== null || name == null || email ==null || mobile ==null){
            res.setStatus(400);
            res.setContentType("Application/josn");
            res.getWriter().write(
                "{\n" +
                    "    \"message\":\"Some fields are missing\"\n" +
                    "}"
            );
            return;
        }

        User user = new User(id, name, email, mobile);
        User createdUser = userService.createUser(user);
        res.setStatus(201);
        res.setContentType("Application/josn");
        res.getWriter().write(
                "{\n" +
                        "    \"message\":\"User created successfully\"\n" +
                        "}"
        );

    }
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String isIdParam=req.getParameter("id");
        if(isIdParam ==null){
            List<User> listOfUser=userService.getAllUsers();
            res.setStatus(200);
            res.setContentType("Applicatio/json");
            res.getWriter().write(usersToJson(listOfUser));
            return;
        }
        Integer id=Integer.parseInt(isIdParam);
        User user=userService.getUserById(id);

        if(user ==null){
            res.setStatus(404);
            res.setContentType("Application/josn");

        }
        res.setStatus(200);
        res.setContentType("Application/josn");
        res.getWriter().write(userToJson(user));

    }
    public void doPut(){

    }
    public void doDelete(){

    }

    private String userToJson(User user){
        return "{\n" +
                "    \"id\":"+ user.getId() +",\n" +
                "    \"name\":"+ user.getName()+",\n" +
                "    \"email\":"+ user.getEmail()+",\n" +
                "    \"mobile\":"+ user.getMobile()+"\n" +
                "}";
    }

    private String usersToJson(List<User> users){
        StringBuilder str=new StringBuilder();
        str.append("[");
        for(int i=0;i< users.size();i++){
            str.append(userToJson(users.get(i)));
            if(i<users.size()-1){
                str.append(",");
            }

        }
        str.append("]");
        return str.toString();
    }
}
