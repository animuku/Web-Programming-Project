import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;
public class LoginServlet extends HttpServlet {

 public void doPost(HttpServletRequest req, 
  HttpServletResponse res) 
  throws ServletException, IOException {

    String uname=req.getParameter("username");
    String pwd=req.getParameter("password");
    res.setContentType("text/html");
    PrintWriter out=res.getWriter();

try{
    DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
            "root", "");
    
    Statement st = con.createStatement();
    String str="select username,password from registration where username='"+uname+"'";

    ResultSet rs1=st.executeQuery(str);

    if (!rs1.isBeforeFirst() ) {    
        out.println("No data"); 
    }
    else 
    {
        rs1.next();
        String username=rs1.getString("username");
        String password=rs1.getString("password");

        if(uname.equals(username)&& pwd.equals(password))
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
        
catch(SQLException ex)
{
    out.println(ex);
}

 }
}