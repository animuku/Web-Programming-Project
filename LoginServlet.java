import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class LoginServlet extends HttpServlet {

 public void doPost(HttpServletRequest req, 
  HttpServletResponse res) 
  throws ServletException, IOException {

    String uname=req.getParameter("username");
    String pwd=req.getParameter("password");
    res.setContentType("text/html");
    PrintWriter out=res.getWriter();

    if(uname.equals("animuku")&& pwd.equals("Drogbalamp123"))
    {
        res.sendRedirect("src/home.html");
    }

    else{
        out.println("Invalid username or password");
        RequestDispatcher rs=req.getRequestDispatcher("src/markup.html");
        rs.forward(req,res);
    }


 }
}