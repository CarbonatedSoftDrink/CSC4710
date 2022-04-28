import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/commonFollowerServlet")
public class CommonFollowerServlet extends HttpServlet {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = -2581737899278951957L;
	private UserDAO userDAO;
 
    public void init() {
    	userDAO = new UserDAO();
    }

	protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
	 String username1 = request.getParameter("user1");
	 String username2 = request.getParameter("user2");
	 System.out.println(username1 + ":" + username2);
	 
	 RequestDispatcher dispatcher = request.getRequestDispatcher("RootHomePage.jsp");
	 
	 List<String> listCommonFollowers = null;
	try {
		listCommonFollowers = userDAO.CommonFollowers(username1, username2);
	} catch (SQLException e) {
		e.printStackTrace();
	}
     request.setAttribute("commonFollowers", listCommonFollowers);
	 
	 dispatcher.forward(request, response);
    }
}