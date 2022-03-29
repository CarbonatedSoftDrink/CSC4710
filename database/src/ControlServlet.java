import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
 
/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @author www.codejava.net
 */
public class ControlServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PeopleDAO peopleDAO;
    private UserDAO userDAO;
    private TweetDAO tweetDAO;
    private TransactionDAO transactionDAO;
    public User LoggedIn;
    public String info = "";
    public List followingList;
    private int globalID = 1;
    private int ppNumber = 1012;
    boolean firstTime = true;
    private int viewedTweetID = -1;
 
    public void init() {
        peopleDAO = new PeopleDAO(); 
    	userDAO = new UserDAO();
    	transactionDAO = new TransactionDAO();
        tweetDAO = new TweetDAO();
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("doPost started: 000000000000000000000000000");
        doGet(request, response);
        System.out.println("doPost finished: 11111111111111111111111111");
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("doGet started: 000000000000000000000000000"); 
     
        String action = request.getServletPath();
        System.out.println(action);
        try {
            switch (action) {
            case "/addLike":
                System.out.println("The action is: addLike");
                addLike(request, response);
                break;
            case "/viewTweet2":
                System.out.println("The action is: showTweet2");
                showTweet2(request, response);
                break;
            case "/addComment":
                System.out.println("The action is: postComment");
                postComment(request, response);
                break;
            case "/postTweet":
                System.out.println("The action is: postTweet");
                postTweet(request, response);
                break;
            case "/viewTweet":
                System.out.println("The action is: showTweet");
                showTweet(request, response);
                break;
            case "/unfollowUser":
            	System.out.println("The action is: unfollowUser");
            	unfollowUser(request, response);
            	break;
            case "/followUser":
            	System.out.println("The action is: followUser");
            	followUser(request, response);
            	break;
            case "/followPage":
            	System.out.println("The action is: showFollowPage");
            	showFollowPage(request, response);
            	break;
            case "/sellPPS":
            	System.out.println("The action is: sellCheck");
            	sellCheck(request, response);
            	break;
            case "/sellPage":
            	System.out.println("The action is: showSellPage");
            	showSellPage(request, response);
            	break;
            case "/buyPPS":
            	System.out.println("The action is: buyCheck");
            	buyCheck(request, response);
            	break;
            case "/buyPage":
            	System.out.println("The action is: showBuyPage");
            	showBuyPage(request, response);
            	break;
            case "/activities":
            	System.out.println("The action is: showActivitiesPage");
            	showActivitiesPage(request, response);
            	break;
            case "/verifyLogin":
            	System.out.println("The action is: verifyLogin");
                verifyLogin(request, response);           	
                break;
            case "/rootActivate":
            	System.out.println("The action is: rootActivate");
                rootReset(request, response);           	
                break;
            case "/signout":
            	System.out.println("The action is: signout");
                signOut(request, response);           	
                break;
            case "/insertNewUser":
            	System.out.println("The action is: insertNewUser");
                insertUser(request, response);           	
                break;
            case "/homepage":
            	System.out.println("The action is: homepage");
                showHomePage(request, response);           	
                break;
            case "/mainpage":
            	System.out.println("The action is: mainpage");
                showMainPage(request, response);           	
                break;
            case "/rootpage":
            	System.out.println("The action is: rootpage");
                showRootPage(request, response);           	
                break;
            case "/login":
            	System.out.println("The action is: login");
                showLogin(request, response);           	
                break;
            case "/signup":
            	System.out.println("The action is: signup");
                showSignup(request, response);           	
                break;
            case "/list": 
                System.out.println("The action is: list");
                listPeople(request, response);           	
                break;
            case "/new":
                System.out.println("The action is: new");
                showNewForm(request, response);
                break;
            case "/insert":
                System.out.println("The action is: insert");
            	   insertPeople(request, response);
                break;
            case "/delete":
                System.out.println("The action is: delete");
            	   deletePeople(request, response);
                break;
            case "/edit":
                System.out.println("The action is: edit");
                showEditForm(request, response);
                break;
            case "/update":
                System.out.println("The action is: update");
            	   updatePeople(request, response);
                break;
            default:
                System.out.println("Not sure which action, we will treat it as the list action");
                listPeople(request, response);           	
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        System.out.println("doGet finished: 111111111111111111111111111111111111");
    }

    private void addLike(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        System.out.println("addLike started: 000000000000000000000000000");

        boolean status = tweetDAO.addLike(viewedTweetID, LoggedIn);
        if (status == false) {
            System.out.println("User has already liked this tweet.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/viewTweet2");
            dispatcher.forward(request, response);
            System.out.println("addLike finished: 1111111111111111111111111111");
        }
        else {
            System.out.println("User has liked this tweet!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/viewTweet2");
            dispatcher.forward(request, response);
            System.out.println("addLike finished: 1111111111111111111111111111");
        }
    }

    private void showTweet2(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        System.out.println("showTweet2 started: 000000000000000000000000000");

        //int id = Integer.parseInt(request.getParameter("id"));
        int id;
        //viewedTweetID = id;
        id = viewedTweetID;
        Tweet existingTweet = tweetDAO.getTweet(id);
        int likes = tweetDAO.getLikes(viewedTweetID);
        request.setAttribute("likes", likes);

        List<Tweet> listComments = tweetDAO.listAllComments(id);
        request.setAttribute("listComments", listComments);

        RequestDispatcher dispatcher = request.getRequestDispatcher("ViewTweet.jsp");
        request.setAttribute("tweet", existingTweet);
        dispatcher.forward(request, response); // The forward() method works at server side, and It sends the same request and response objects to another servlet.
        System.out.println("Now you see the ViewTweet page in your browser.");

        System.out.println("showTweet2 finished: 1111111111111111111111111111");
    }

    private void postComment(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
        System.out.println("postComment started: 00000000000000000000000000000000000");
        int id = viewedTweetID;
        String tweetContent = request.getParameter("makeComment");
        String tweetAuthor = LoggedIn.getUsername();
        System.out.println(tweetAuthor);
        if (tweetContent.equals("")) {
            info = "Empty tweet contents, tweet not created.";
            RequestDispatcher dispatcher = request.getRequestDispatcher("/viewTweet2");
            dispatcher.forward(request, response);
        }
        else {
            Tweet newTweet = new Tweet(tweetContent, tweetAuthor);
            tweetDAO.insertComment(newTweet, id);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/viewTweet2");
            dispatcher.forward(request, response);

            System.out.println("postComment finished: 1111111111111111111111111111");

        }

        System.out.println("postComment2 finished: 1111111111111111111111111111");
    }

    private void postTweet(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
        System.out.println("postTweet started: 00000000000000000000000000000000000");
        String tweetContent = request.getParameter("makeTweet");
        String tweetAuthor = LoggedIn.getUsername();
        if (tweetContent.equals("")) {
            info = "Empty tweet contents, tweet not created.";
            RequestDispatcher dispatcher = request.getRequestDispatcher("/homepage");
            dispatcher.forward(request, response);
        }
        else {
            Tweet newTweet = new Tweet(tweetContent, tweetAuthor);
            tweetDAO.insert(newTweet);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/homepage");
            dispatcher.forward(request, response);

            System.out.println("postTweet finished: 1111111111111111111111111111");

        }

        System.out.println("postTweet2 finished: 1111111111111111111111111111");
    }

    private void showTweet(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        System.out.println("showTweet started: 000000000000000000000000000");

        int id = Integer.parseInt(request.getParameter("id"));
        viewedTweetID = id;
        Tweet existingTweet = tweetDAO.getTweet(id);
        int likes = tweetDAO.getLikes(viewedTweetID);
        request.setAttribute("likes", likes);

        List<Tweet> listComments = tweetDAO.listAllComments(id);
        request.setAttribute("listComments", listComments);

        RequestDispatcher dispatcher = request.getRequestDispatcher("ViewTweet.jsp");
        request.setAttribute("tweet", existingTweet);
        dispatcher.forward(request, response); // The forward() method works at server side, and It sends the same request and response objects to another servlet.
        System.out.println("Now you see the ViewTweet page in your browser.");

        System.out.println("showTweet finished: 1111111111111111111111111111");
    }

	private void followUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		userDAO.updateFollowers(Integer.parseInt(request.getParameter("id")), LoggedIn.getId());
		response.sendRedirect("followPage");
	}
	
	private void unfollowUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		userDAO.removeFollowing(LoggedIn.getUsername(), request.getParameter("username"));
		response.sendRedirect("followPage");
	}

	private void showFollowPage(HttpServletRequest request, HttpServletResponse response) 
    		throws SQLException, IOException, ServletException {
		List followeeList = userDAO.getFollowees(LoggedIn);
		List<User> listUsers = userDAO.getAllUsers();
		request.setAttribute("FOLLOWEES", followeeList);
		request.setAttribute("USERS", listUsers);
		 System.out.println("showSellPage started: 00000000000000000000000000000000000");
	     RequestDispatcher dispatcher = request.getRequestDispatcher("FollowPage.jsp");       
	     dispatcher.forward(request, response);
      
         System.out.println("showSellPage finished: 111111111111111111111111111111111111");
	}
    
	private void sellCheck(HttpServletRequest request, HttpServletResponse response) 
    		throws SQLException, IOException, ServletException{
        System.out.println("sellCheck started: 00000000000000000000000000000000000");
        
        float sellAmount;
        float dollarAmount;
        try {
            sellAmount = Integer.parseInt(request.getParameter("toSell"));
        }
        catch (NumberFormatException e){
        	sellAmount = 0;
        }
        
        dollarAmount = sellAmount / 100;
        if (sellAmount > LoggedIn.getPpsbalance()) {
        	info = "You are trying to sell more PPS than you own. Please try a lower value.";
        	System.out.println("Ask the browser to call the sellPage action next automatically");
            response.sendRedirect("sellPage");  //
         
            System.out.println("sellCheck1 finished: 11111111111111111111111111");
        }
        else {
        	userDAO.sellPPS(LoggedIn, sellAmount);
        	info = "Successfully sold " + sellAmount + " PPS!";
        	LoggedIn = userDAO.getUser(LoggedIn.getId()); // refreshes user data
        	System.out.println("Ask the browser to call the sellPage action next automatically");
            response.sendRedirect("sellPage");  //
            System.out.println("sellCheck2 finished: 11111111111111111111111111");
        }
    }
    
    private void showSellPage(HttpServletRequest request, HttpServletResponse response) 
    		throws SQLException, IOException, ServletException{
        System.out.println("showSellPage started: 00000000000000000000000000000000000");
        
        //info = "";
        //request.setAttribute("username", LoggedIn.getUserID());
        request.setAttribute("PPA", LoggedIn.getPpsbalance());
        request.setAttribute("USA", LoggedIn.getBankbalance());
        //request.setAttribute("PPAD", LoggedIn.getPPAddress());
        request.setAttribute("info", info);
        RequestDispatcher dispatcher = request.getRequestDispatcher("SellPage.jsp");       
        dispatcher.forward(request, response);
     
        System.out.println("showSellPage finished: 111111111111111111111111111111111111");
    }
    
    private void buyCheck(HttpServletRequest request, HttpServletResponse response) 
    		throws SQLException, IOException, ServletException{
        System.out.println("buyCheck started: 00000000000000000000000000000000000");
        
        float buyAmount;
        float checkAmount;
        try {
            buyAmount = Integer.parseInt(request.getParameter("toBuy"));
        }
        catch (NumberFormatException e){
        	buyAmount = 0;
        }
        
        checkAmount = buyAmount / 100;
        if (checkAmount > LoggedIn.getBankbalance()) {
        	info = "You do not have enough U.S. Dollar to purchase the specified amount of PPS. Please try a lower value.";
        	System.out.println("Ask the browser to call the buyPage action next automatically");
            response.sendRedirect("buyPage");  //
         
            System.out.println("buyCheck1 finished: 11111111111111111111111111");
        }
        else {
        	userDAO.BuyPPS(LoggedIn, buyAmount);
        	info = "Successfully purchased " + buyAmount +" PPS!";
        	LoggedIn = userDAO.getUser(LoggedIn.getId()); // refreshes user data
        	System.out.println("Ask the browser to call the buyPage action next automatically");
            response.sendRedirect("buyPage");  //
            System.out.println("buyCheck2 finished: 11111111111111111111111111");
        }
        
        
     
        System.out.println("buyCheck3 finished: 111111111111111111111111111111111111");
    }
    
    private void showBuyPage(HttpServletRequest request, HttpServletResponse response) 
    		throws SQLException, IOException, ServletException{
        System.out.println("showBuyPage started: 00000000000000000000000000000000000");
        
        //info = "";
        //request.setAttribute("username", LoggedIn.getUserID());
        request.setAttribute("PPA", LoggedIn.getPpsbalance());
        request.setAttribute("USA", LoggedIn.getBankbalance());
        //request.setAttribute("PPAD", LoggedIn.getPPAddress());
        request.setAttribute("info", info);
        RequestDispatcher dispatcher = request.getRequestDispatcher("BuyPage.jsp");       
        dispatcher.forward(request, response);
     
        System.out.println("showBuyPage finished: 111111111111111111111111111111111111");
    }
    
    private void verifyLogin(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        System.out.println("verifyLogin started: 000000000000000000000000000");
     
        String userid = request.getParameter("username");
        String password = request.getParameter("password");
        User loginAttempt = null;
        System.out.println("userid:" + userid + ", password:" + password);
     
        //User newUser = new User(userid, password, firstname, lastname, age, ppaddress);
        //userDAO.insert(newUser);
        //LoggedIn = newUser;
        
        if (userid.equals("root") && password.equals("pass1234")) {
        	System.out.println("Ask the browser to call the rootpage action next automatically");
            response.sendRedirect("rootpage");  //
         
            System.out.println("verifyLogin finished: 11111111111111111111111111");
        }
        else {
        	loginAttempt = userDAO.verifyUser(userid, password);
        	
        	if (loginAttempt != null) {
        		LoggedIn = loginAttempt;
            	System.out.println("Ask the browser to call the homepage action next automatically");
                response.sendRedirect("homepage");  //
             
                System.out.println("verifyLogin finished: 11111111111111111111111111");
            }
            else {
            	System.out.println("Ask the browser to call the login action next automatically");
            	info = "Login failed. Please try again.";
                response.sendRedirect("login");  //
             
                System.out.println("verifyLogin finished: 11111111111111111111111111");
            }
        }
    }
    
    private void rootReset(HttpServletRequest request, HttpServletResponse response) 
    		throws SQLException, IOException, ServletException{
    	System.out.println("rootReset started: 00000000000000000000000000000000000");
    	
    	userDAO.rootReset();
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("MainPage.jsp");       
        dispatcher.forward(request, response);
        System.out.println("rootReset finished: 00000000000000000000000000000000000");
    }
    
    private void signOut(HttpServletRequest request, HttpServletResponse response) 
    		throws SQLException, IOException, ServletException{
    	System.out.println("signOut started: 00000000000000000000000000000000000");
        
    	LoggedIn = null;
        RequestDispatcher dispatcher = request.getRequestDispatcher("MainPage.jsp");       
        dispatcher.forward(request, response);
        System.out.println("signOut finished: 00000000000000000000000000000000000");
    }
    
    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        System.out.println("insertUser started: 000000000000000000000000000");
     
        //int id = Integer.parseInt(request.getParameter("id"));
        String userid = request.getParameter("username");
        String password = request.getParameter("password");
        String confirm = request.getParameter("confirmPW");
        String firstname = request.getParameter("fname");
        String lastname = request.getParameter("lname");
        String birthday = request.getParameter("age");
        int ppaddress = ppNumber;
        //ppNumber += 1;
        System.out.println("userid:" + userid + ", password:" + password + ", firstname:" + firstname + ", lastname:" + lastname + ", age:" + birthday);
     
        if (password.equals(confirm) == false) {
        	info = "Passwords do not match. Please try again.";
        	System.out.println("Passwords do not match. Ask the browser to call the signup action next automatically");
            response.sendRedirect("signup");  //
         
            System.out.println("insertUser finished: 11111111111111111111111111"); 
        }
        else if(userid.equals("") || password.equals("") || confirm.equals("") || firstname.equals("") || lastname.equals("") || birthday.equals("")) {
        	info = "One or more form fields were missing. Please try again.";
        	System.out.println("One or more form fields are missing. Ask the browser to call the signup action next automatically");
            response.sendRedirect("signup");  //
         
            System.out.println("insertUser finished: 11111111111111111111111111"); 
        }
        else {
        	if (userDAO.checkID(userid) == false) {
        		info = "User ID has already been taken. Please try again.";
            	System.out.println("UserID is not unique. Ask the browser to call the signup action next automatically");
                response.sendRedirect("signup");  //
             
                System.out.println("insertUser finished: 11111111111111111111111111"); 
        	}
        	else {
        		User newUser = new User(userid, password, firstname, lastname, birthday, ppaddress);
                userDAO.insert(newUser);
                LoggedIn = newUser;
                ppNumber += 1;
             
                System.out.println("Ask the browser to call the homepage action next automatically");
                response.sendRedirect("homepage");  //
             
                System.out.println("insertUser finished: 11111111111111111111111111");
        	}
        }
    }
    
    private void showActivitiesPage(HttpServletRequest request, HttpServletResponse response) 
    		throws SQLException, IOException, ServletException{
        System.out.println("showActivitiesPage started: 00000000000000000000000000000000000");
        
        info = "";
        List<Transaction> transactionList = transactionDAO.getTransactions(LoggedIn);
        request.setAttribute("username", LoggedIn.getUsername());
        request.setAttribute("PPA", LoggedIn.getPpsbalance());
        request.setAttribute("USA", LoggedIn.getBankbalance());
        request.setAttribute("PPAD", LoggedIn.getPpaddress());
		request.setAttribute("transactions", transactionList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ActivitiesPage.jsp");       
        dispatcher.forward(request, response);
     
        System.out.println("showActivitiesPage finished: 111111111111111111111111111111111111");
    }
    
    private void showSignup(HttpServletRequest request, HttpServletResponse response) 
    		throws SQLException, IOException, ServletException{
    	System.out.println("showSignup started: 00000000000000000000000000000000000");
    	
    	request.setAttribute("info", info);
        RequestDispatcher dispatcher = request.getRequestDispatcher("SignUpPage.jsp");       
        dispatcher.forward(request, response);
        System.out.println("showSignup finished: 00000000000000000000000000000000000");
    }
    
    private void showLogin(HttpServletRequest request, HttpServletResponse response) 
    		throws SQLException, IOException, ServletException{
    	System.out.println("showLogin started: 00000000000000000000000000000000000");
        
    	request.setAttribute("info", info);
        RequestDispatcher dispatcher = request.getRequestDispatcher("LoginPage.jsp");       
        dispatcher.forward(request, response);
        System.out.println("showLogin finished: 00000000000000000000000000000000000");
    }
    
    private void showRootPage(HttpServletRequest request, HttpServletResponse response)
    		throws SQLException, IOException, ServletException{
        System.out.println("showRootPage started: 00000000000000000000000000000000000");
        
        info = "";
        RequestDispatcher dispatcher = request.getRequestDispatcher("RootHomePage.jsp");       
        dispatcher.forward(request, response);
        System.out.println("showRootPage finished: 00000000000000000000000000000000000");
    }
    
    private void showMainPage(HttpServletRequest request, HttpServletResponse response)
    		throws SQLException, IOException, ServletException{
        System.out.println("showMainPage started: 00000000000000000000000000000000000");
        
        info = "";
        RequestDispatcher dispatcher = request.getRequestDispatcher("MainPage.jsp");       
        dispatcher.forward(request, response);
        System.out.println("showMainPage finished: 00000000000000000000000000000000000");
    }
    
    private void showHomePage(HttpServletRequest request, HttpServletResponse response) 
    		throws SQLException, IOException, ServletException{
        System.out.println("showHomePage started: 00000000000000000000000000000000000");
        
        info = "";
        request.setAttribute("PPA", LoggedIn.getPpsbalance());
        request.setAttribute("USA", LoggedIn.getBankbalance());
        request.setAttribute("username", LoggedIn.getUsername());
        RequestDispatcher dispatcher = request.getRequestDispatcher("HomePage.jsp");       
        dispatcher.forward(request, response);
     
        System.out.println("showHomePage finished: 111111111111111111111111111111111111");
    }
    
    private void listPeople(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        System.out.println("listPeople started: 00000000000000000000000000000000000");

     
        List<People> listPeople = peopleDAO.listAllPeople();
        request.setAttribute("listPeople", listPeople);       
        RequestDispatcher dispatcher = request.getRequestDispatcher("PeopleList.jsp");       
        dispatcher.forward(request, response);
     
        System.out.println("listPeople finished: 111111111111111111111111111111111111");
    }
 
    // to insert a people
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("showNewForm started: 000000000000000000000000000");
     
        RequestDispatcher dispatcher = request.getRequestDispatcher("InsertPeopleForm.jsp");
        dispatcher.forward(request, response);
        System.out.println("The user sees the InsertPeopleForm page now.");
     
        System.out.println("showNewForm finished: 1111111111111111111111111111111");
    }
 
    // to present an update form to update an  existing Student
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        System.out.println("showEditForm started: 000000000000000000000000000");
     
        int id = Integer.parseInt(request.getParameter("id"));
        People existingPeople = peopleDAO.getPeople(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("EditPeopleForm.jsp");
        request.setAttribute("people", existingPeople);
        dispatcher.forward(request, response); // The forward() method works at server side, and It sends the same request and response objects to another servlet.
        System.out.println("Now you see the EditPeopleForm page in your browser.");
     
        System.out.println("showEditForm finished: 1111111111111111111111111111");
    }
 
    // after the data of a people are inserted, this method will be called to insert the new people into the DB
    // 
    private void insertPeople(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        System.out.println("insertPeople started: 000000000000000000000000000");
     
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String status = request.getParameter("status");
        System.out.println("name:" + name + ", address: "+address + ", status:" + status);
     
        People newPeople = new People(name, address, status);
        peopleDAO.insert(newPeople);
     
        System.out.println("Ask the browser to call the list action next automatically");
        response.sendRedirect("list");  //
     
        System.out.println("insertPeople finished: 11111111111111111111111111");   
    }
 
    private void updatePeople(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        System.out.println("updatePeople started: 000000000000000000000000000");
     
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String status = request.getParameter("status");
        System.out.println("name:" + name + ", address: "+address + ", status:" + status);
        
        People people = new People(id,name, address, status);
        peopleDAO.update(people);
        System.out.println("Ask the browser to call the list action next automatically");
        response.sendRedirect("list");
     
        System.out.println("updatePeople finished: 1111111111111111111111111111111");
    }
 
    private void deletePeople(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        System.out.println("deletePeople started: 000000000000000000000000000");
     
        int id = Integer.parseInt(request.getParameter("id"));
        //People people = new People(id);
        peopleDAO.delete(id);
        System.out.println("Ask the browser to call the list action next automatically");
        response.sendRedirect("list"); 
     
        System.out.println("deletePeople finished: 1111111111111111111111111111111");
    }

}
