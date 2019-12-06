import models.User;
import dao.UserDao;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

public class App extends HttpServlet{
    private static final long serialVersionUID = 1L;

        public App(){
        }
        //login
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();

        User.setName(userName);
        User.setPassword(password);

        UserDao userDao = new UserDao();

        try
        {
            String userValidate = userDao.authenticateUser(user);

            if(userValidate.equals("Admin_Role"))
            {
                System.out.println("Admin's Home");

                HttpSession session = request.getSession(); //Creating a session
                session.setAttribute("Admin", userName); //setting session attribute
                request.setAttribute("userName", userName);

                request.getRequestDispatcher("/JSP/Admin.jsp").forward(request, response);
            }
            else if(userValidate.equals("Editor_Role"))
            {
                System.out.println("Editor's Home");

                HttpSession session = request.getSession();
                session.setAttribute("Editor", userName);
                request.setAttribute("userName", userName);

                request.getRequestDispatcher("/JSP/Editor.jsp").forward(request, response);
            }
            else if(userValidate.equals("User_Role"))
            {
                System.out.println("User's Home");

                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(10*60);
                session.setAttribute("User", userName);
                request.setAttribute("userName", userName);

                request.getRequestDispatcher("/JSP/User.jsp").forward(request, response);
            }
            else
            {
                System.out.println("Error message = "+userValidate);
                request.setAttribute("errMessage", userValidate);

                request.getRequestDispatcher("/JSP/Login.jsp").forward(request, response);
            }
        }
        catch (IOException e1)
        {
            e1.printStackTrace();
        }
        catch (Exception e2)
        {
            e2.printStackTrace();
        }
    }
    //logging out
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        HttpSession session = request.getSession(false); //Fetch session object

        if(session!=null) //If session is not null
        {
            session.invalidate(); //removes all session attributes bound to the session
            request.setAttribute("errMessage", "You have logged out successfully");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/JSP/Login.jsp");
            requestDispatcher.forward(request, response);
            System.out.println("Logged out");
        }
    }
}
