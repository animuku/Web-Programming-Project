import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class LoginServlet extends HttpServlet {

 public void doPost(HttpServletRequest request, 
  HttpServletResponse response) 
  throws ServletException, IOException {

    String uname=request.getParameter("username");
    String pwd=request.getParameter("password");
    res.setContentType("text/html");
    PrintWriter out=res.getWriter();

    if(uname.equals("animuku")&& pwd.equals("Drogbalamp123"))
    {
        response.sendRedirect("target.html");
    }

    else{
        out.println("Invalid username or password");
        RequestDispatcher rs=req.RequestDispatcher("markup.html");
        rs.forward(req,res);
    }


 }
}