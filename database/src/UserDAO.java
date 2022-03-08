import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 * Servlet implementation class Connect
 */
@WebServlet("/UserDAO")
public class UserDAO {
    private static final long serialVersionUID = 1L;
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    // SQL queries //
    String sql0 = "CREATE DATABASE IF NOT EXISTS twitterbase";
    String sql1 = "DROP TABLE IF EXISTS User";
    String sql2 = "DROP TABLE IF EXISTS Tweet";
    String sql3 = "DROP TABLE IF EXISTS Transactions";
    String sql4 = "DROP TABLE IF EXISTS Followers";
    String sql5 = "DROP TABLE IF EXISTS LikedTweets";
    
    String sql6 = "CREATE TABLE IF NOT EXISTS User "
    		+ "	(id int NOT NULL AUTO_INCREMENT, "
    		+ "    UserID varchar(255) UNIQUE, "
    		+ "    Password varchar(255), "
    		+ "    FirstName varchar(255), "
    		+ "    LastName varchar(255), "
    		+ "    Age int, "
    		+ "    PPAddress int UNIQUE, "
    		+ "    PPWallet int, "
    		+ "    DollarWallet int, "
    		+ "    PRIMARY KEY (id))";
    
    String sql7 = "CREATE TABLE IF NOT EXISTS Tweet "
    		+ "	(id int NOT NULL AUTO_INCREMENT, "
    		+ "    TweeterID varchar(255), "
    		+ "    Content varchar(300), "
    		+ "    ParentTweetID int, "
    		+ "    FOREIGN KEY (TweeterID) REFERENCES User(UserID), "
    		+ "	   PRIMARY KEY (id))";
    
    String sql8 = "CREATE TABLE IF NOT EXISTS Transactions "
    		+ "	(id int NOT NULL AUTO_INCREMENT, "
    		+ "    SenderAddress int, "
    		+ "    ReceiverAddress int, "
    		+ "    PPAmount int, "
    		+ "    DollarAmount int, "
    		+ "    FOREIGN KEY (SenderAddress) REFERENCES User(PPAddress), "
    		+ "    FOREIGN KEY (ReceiverAddress) REFERENCES User(PPAddress), "
    		+ "    PRIMARY KEY (id))";
    
    String sql9 = "CREATE TABLE IF NOT EXISTS Followers "
    		+ "	(id int NOT NULL AUTO_INCREMENT, "
    		+ "    UserID varchar(255), "
    		+ "    FollowingUserID varchar(255), "
    		+ "    FOREIGN KEY (UserID) REFERENCES User(UserID), "
    		+ "    FOREIGN KEY (FollowingUserID) REFERENCES User(UserID), "
    		+ "    PRIMARY KEY (id))";
    
    String sql10 = "CREATE TABLE IF NOT EXISTS LikedTweets "
    		+ "	(id int NOT NULL AUTO_INCREMENT, "
    		+ "    UserID varchar(255), "
    		+ "    LikedTweetID int, "
    		+ "    FOREIGN KEY (UserID) REFERENCES User(UserID), "
    		+ "    FOREIGN KEY (LikedTweetID) REFERENCES Tweet(id), "
    		+ "    PRIMARY KEY (id))";
    
    String sql11 = "insert into User(UserID, Password, FirstName, LastName, Age, PPAddress, PPWallet, DollarWallet) values (\"root\", \"pass1234\", \"root\", \"root\", 99, 1000, 1000000000, 1036)";
    ////////////////


    public UserDAO() {

    }

    /**
     * @see HttpServlet#HttpServlet()
     */
    protected void connect_func() throws SQLException {
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connect = (Connection) DriverManager
                    .getConnection("jdbc:mysql://127.0.0.1:3306/twitterbase?"
                            + "useSSL=false&user=john&password=pass1234");
            System.out.println(connect);
        }
    }

    public List<User> listAllUsers() throws SQLException {
        List<User> listUser = new ArrayList<User>();
        String sql = "SELECT * FROM User";
        connect_func();
        statement =  (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String UserID = resultSet.getString("UserID");
            String FirstName = resultSet.getString("FirstName");
            String LastName = resultSet.getString("LastName");
            int Age = resultSet.getInt("Age");
            int PPAddress = resultSet.getInt("PPAddress");
            int PPWallet = resultSet.getInt("PPWallet");
            int DollarWallet = resultSet.getInt("DollarWallet");

            User user = new User(id, UserID, FirstName, LastName, Age, PPAddress, PPWallet, DollarWallet);
            listUser.add(user);
        }
        resultSet.close();
        statement.close();
        disconnect();
        return listUser;
    }

    protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
            connect.close();
        }
    }
    
    public void rootReset() throws SQLException {
    	String sqlTemp;
        connect_func();
        statement = connect.createStatement();
        statement.executeUpdate(sql0);
        statement.executeUpdate(sql5);
        statement.executeUpdate(sql4);
        statement.executeUpdate(sql3);
        statement.executeUpdate(sql2);
        statement.executeUpdate(sql1);
        statement.executeUpdate(sql6);
        statement.executeUpdate(sql7);
        statement.executeUpdate(sql8);
        statement.executeUpdate(sql9);
        statement.executeUpdate(sql10);
        preparedStatement = connect.prepareStatement(sql11);
        preparedStatement.executeUpdate();
        
        // User //
        
        sqlTemp = "insert into User(UserID, Password, FirstName, LastName, Age, PPAddress, PPWallet, DollarWallet) values (\"john@aol.com\", \"apple\", \"john\", \"apple\", 24, 1001, 100, 999)";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into User(UserID, Password, FirstName, LastName, Age, PPAddress, PPWallet, DollarWallet) values (\"gary@mail.com\", \"hidethis\", \"gary\", \"jack\", 19, 1002, 1000, 990)";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into User(UserID, Password, FirstName, LastName, Age, PPAddress, PPWallet, DollarWallet) values (\"coolguy@mail.com\", \"reallycool\", \"cool\", \"guy\", 21, 1003, 0, 1000)";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into User(UserID, Password, FirstName, LastName, Age, PPAddress, PPWallet, DollarWallet) values (\"round@mail.com\", \"nice!\", \"round\", \"person\", 50, 1004, 1500, 975)";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into User(UserID, Password, FirstName, LastName, Age, PPAddress, PPWallet, DollarWallet) values (\"circle@mail.com\", \"oval\", \"circle\", \"circle\", 43, 1005, 500, 1000)";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into User(UserID, Password, FirstName, LastName, Age, PPAddress, PPWallet, DollarWallet) values (\"square@mail.com\", \"sharp\", \"square\", \"rectangle\", 27, 1006, 500, 1000)";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into User(UserID, Password, FirstName, LastName, Age, PPAddress, PPWallet, DollarWallet) values (\"fakemail@mail.com\", \"fakepassword\", \"fakename\", \"fakelastname\", 33, 1007, 0, 1000)";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into User(UserID, Password, FirstName, LastName, Age, PPAddress, PPWallet, DollarWallet) values (\"reporter@mail.com\", \"reportingpassword\", \"anne\", \"reporter\", 28, 1008, 0, 1000)";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into User(UserID, Password, FirstName, LastName, Age, PPAddress, PPWallet, DollarWallet) values (\"spiderman@mail.com\", \"spiders\", \"peter\", \"parker\", 33, 1009, 0, 1000)";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into User(UserID, Password, FirstName, LastName, Age, PPAddress, PPWallet, DollarWallet) values (\"superman@mail.com\", \"krypto\", \"clark\", \"kent\", 39, 1010, 0, 1000)";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        
        // Tweet //
        
        sqlTemp = "insert into Tweet(TweeterID, Content, ParentTweetID) values (\"john@aol.com\", \"Lovely weather that we're having, huh?\", null)";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into Tweet(TweeterID, Content, ParentTweetID) values (\"john@aol.com\", \"That new batman movie was really cool!\", null)";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into Tweet(TweeterID, Content, ParentTweetID) values (\"gary@mail.com\", \"Yeah, the sun was out, and it wasn't too hot!\", 1)";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into Tweet(TweeterID, Content, ParentTweetID) values (\"superman@mail.com\", \"I disagree, I think the superman movie was better!1\", 2)";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into Tweet(TweeterID, Content, ParentTweetID) values (\"spiderman@mail.com\", \"They were both good, but spiderman's was better!\", 4)";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into Tweet(TweeterID, Content, ParentTweetID) values (\"reporter@mail.com\", \"How do I tweet?\", null)";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into Tweet(TweeterID, Content, ParentTweetID) values (\"circle@mail.com\", \"You just did.\", 6)";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into Tweet(TweeterID, Content, ParentTweetID) values (\"square@mail.com\", \"Happy Easter!\", null)";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into Tweet(TweeterID, Content, ParentTweetID) values (\"square@mail.com\", \"Databases are cool... right?\", null)";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into Tweet(TweeterID, Content, ParentTweetID) values (\"gary@mail.com\", \"Yeah!\", 9)";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        
        // Transactions //
        
        sqlTemp = "insert into Transactions(SenderAddress, ReceiverAddress, PPAmount, DollarAmount) values (1000, 1001, 100, -1.00)";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into Transactions(SenderAddress, ReceiverAddress, PPAmount, DollarAmount) values (1001, 1000, -100, 1.00)";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into Transactions(SenderAddress, ReceiverAddress, PPAmount, DollarAmount) values (1000, 1002, 1000, -10.00)";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into Transactions(SenderAddress, ReceiverAddress, PPAmount, DollarAmount) values (1002, 1000, -1000, 10.00)";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into Transactions(SenderAddress, ReceiverAddress, PPAmount, DollarAmount) values (1000, 1004, 2500, -25.00)";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into Transactions(SenderAddress, ReceiverAddress, PPAmount, DollarAmount) values (1004, 1000, -2500, 25.00)";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into Transactions(SenderAddress, ReceiverAddress, PPAmount, DollarAmount) values (1004, 1005, 500, 0.00)";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into Transactions(SenderAddress, ReceiverAddress, PPAmount, DollarAmount) values (1005, 1004, -500, 0.00)";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into Transactions(SenderAddress, ReceiverAddress, PPAmount, DollarAmount) values (1004, 1006, 500, 0.00)";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into Transactions(SenderAddress, ReceiverAddress, PPAmount, DollarAmount) values (1006, 1004, -500, 0.00)";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        
        // LikedTweets //
        
        sqlTemp = "insert into LikedTweets(UserID, LikedTweetID) values (\"gary@mail.com\", 1)";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into LikedTweets(UserID, LikedTweetID) values (\"superman@mail.com\", 6)";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into LikedTweets(UserID, LikedTweetID) values (\"john@aol.com\", 6)";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into LikedTweets(UserID, LikedTweetID) values (\"reporter@mail.com\", 1)";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into LikedTweets(UserID, LikedTweetID) values (\"coolguy@mail.com\", 1)";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into LikedTweets(UserID, LikedTweetID) values (\"square@mail.com\", 8)";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into LikedTweets(UserID, LikedTweetID) values (\"circle@mail.com\", 9)";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into LikedTweets(UserID, LikedTweetID) values (\"gary@mail.com\", 9)";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into LikedTweets(UserID, LikedTweetID) values (\"reporter@mail.com\", 2)";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into LikedTweets(UserID, LikedTweetID) values (\"coolguy@mail.com\", 4)";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        
        // Followers //
        
        sqlTemp = "insert into Followers(UserID, FollowingUserID) values (\"coolguy@mail.com\", \"gary@mail.com\")";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into Followers(UserID, FollowingUserID) values (\"gary@mail.com\", \"john@aol.com\")";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into Followers(UserID, FollowingUserID) values (\"john@aol.com\", \"gary@mail.com\")";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into Followers(UserID, FollowingUserID) values (\"coolguy@mail.com\", \"superman@mail.com\")";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into Followers(UserID, FollowingUserID) values (\"superman@mail.com\", \"spiderman@mail.com\")";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into Followers(UserID, FollowingUserID) values (\"square@mail.com\", \"circle@mail.com\")";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into Followers(UserID, FollowingUserID) values (\"circle@mail.com\", \"square@mail.com\")";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into Followers(UserID, FollowingUserID) values (\"gary@mail.com\", \"reporter@mail.com\")";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into Followers(UserID, FollowingUserID) values (\"john@aol.com\", \"reporter@mail.com\")";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        sqlTemp = "insert into Followers(UserID, FollowingUserID) values (\"spiderman@mail.com\", \"reporter@mail.com\")";
        preparedStatement = connect.prepareStatement(sqlTemp);
        preparedStatement.executeUpdate();
        
        statement.close();
        preparedStatement.close();
        //statement.executeUpdate(sql11);
    }
    
    public User verifyUser(String username, String password) throws SQLException {
    	String loginUser = username;
        String loginPassword = password;
        User verified = null;
        List<User> listUser = new ArrayList<User>();
        String sql = "SELECT * FROM User WHERE userid LIKE '%" + loginUser + "%'";
        
        connect_func();
        statement =  (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String UserID = resultSet.getString("UserID");
            String Password = resultSet.getString("Password");
            String FirstName = resultSet.getString("FirstName");
            String LastName = resultSet.getString("LastName");
            int Age = resultSet.getInt("Age");
            int PPAddress = resultSet.getInt("PPAddress");
            int PPWallet = resultSet.getInt("PPWallet");
            int DollarWallet = resultSet.getInt("DollarWallet");

            User user = new User(id, UserID, Password, FirstName, LastName, Age, PPAddress, PPWallet, DollarWallet);
            listUser.add(user);
        }
        resultSet.close();
        statement.close();
        disconnect();
        
        System.out.println("THIS IS LIST USER USER:" + listUser.get(0).getUserID());
        System.out.println("From form:" + loginUser);
        System.out.println("THIS IS LIST USER PASSWORD:" + listUser.get(0).getPassword());
        System.out.println("From form:" + loginPassword);        
        
        if (listUser.size() > 0) {
        	if (listUser.get(0).getUserID().equals(loginUser) && listUser.get(0).getPassword().equals(loginPassword)) {
        		//verified = true;
        		//verified = listUser.get(0);
        		//return verified;
        		System.out.println("valid user");
        		return listUser.get(0);
        	}
        	System.out.println("falling out");
        }
        else {
        	System.out.println("invalid user");
        	return verified;
        }
        //preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        //preparedStatement.setString(1, user.UserID);
        
//		preparedStatement.executeUpdate();
//        disconnect();
        System.out.println("invalid user 2");
        return verified;
    }
    
    public boolean checkID(String check) throws SQLException {
    	List<User> listUser = new ArrayList<User>();
        String sql = "SELECT * FROM User WHERE userid LIKE '%" + check + "%'";
        
        connect_func();
        statement =  (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String UserID = resultSet.getString("UserID");
            String Password = resultSet.getString("Password");
            String FirstName = resultSet.getString("FirstName");
            String LastName = resultSet.getString("LastName");
            int Age = resultSet.getInt("Age");
            int PPAddress = resultSet.getInt("PPAddress");
            int PPWallet = resultSet.getInt("PPWallet");
            int DollarWallet = resultSet.getInt("DollarWallet");

            User user = new User(id, UserID, Password, FirstName, LastName, Age, PPAddress, PPWallet, DollarWallet);
            listUser.add(user);
        }
        resultSet.close();
        statement.close();
        disconnect();
        if (listUser.size() > 0) {
        	return false;
        }
        else {
        	return true;
        }
    }

    public boolean insert(User user) throws SQLException {
        connect_func();
        List<User> listUser = new ArrayList<User>();
        boolean check = true;
        while (check == true) {
            String sql = "SELECT * FROM User WHERE ppaddress LIKE '%" + user.PPAddress + "%'";
            
            statement =  (Statement) connect.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String UserID = resultSet.getString("UserID");
                String Password = resultSet.getString("Password");
                String FirstName = resultSet.getString("FirstName");
                String LastName = resultSet.getString("LastName");
                int Age = resultSet.getInt("Age");
                int PPAddress = resultSet.getInt("PPAddress");
                int PPWallet = resultSet.getInt("PPWallet");
                int DollarWallet = resultSet.getInt("DollarWallet");

                User checkUser = new User(id, UserID, Password, FirstName, LastName, Age, PPAddress, PPWallet, DollarWallet);
                listUser.add(checkUser);
            }
            resultSet.close();
            statement.close();
            
            if (listUser.size() > 0) {
            	user.PPAddress += 1;
            	listUser.clear();
            }
            else {
            	check = false;
            }
        }
        
        String sql = "insert into User(UserID, Password, FirstName, LastName, Age, PPAddress, PPWallet, DollarWallet) values (?, ?, ?, ?, ?, ?, ?, ?)";
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, user.UserID);
        preparedStatement.setString(2, user.Password);
        preparedStatement.setString(3, user.FirstName);
        preparedStatement.setString(4, user.LastName);
        preparedStatement.setInt(5, user.Age);
        preparedStatement.setInt(6, user.PPAddress);
        preparedStatement.setInt(7, user.PPWallet);
        preparedStatement.setDouble(8, user.DollarWallet);
//		preparedStatement.executeUpdate();

        boolean rowInserted = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
//        disconnect();
        return rowInserted;
    }

    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM User WHERE id = ?";
        connect_func();

        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setInt(1, id);

        boolean rowDeleted = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
//        disconnect();
        return rowDeleted;
    }

    public boolean update(User user) throws SQLException {
        String sql = "update User set UserID=?, FirstName =?, LastName = ?, Age = ?, PPAddress = ?, PPWallet = ?, DollarWallet = ? where id = ?";
        connect_func();

        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, user.UserID);
        preparedStatement.setString(2, user.FirstName);
        preparedStatement.setString(3, user.LastName);
        preparedStatement.setInt(4, user.Age);
        preparedStatement.setInt(5, user.PPAddress);
        preparedStatement.setInt(6, user.PPWallet);
        preparedStatement.setDouble(7, user.DollarWallet);
        preparedStatement.setInt(8, user.id);

        boolean rowUpdated = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
//        disconnect();
        return rowUpdated;
    }

    public User getUser(int id) throws SQLException {
        User user = null;
        String sql = "SELECT * FROM User WHERE id = ?";

        connect_func();

        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            String UserID = resultSet.getString("UserID");
            String FirstName = resultSet.getString("FirstName");
            String LastName = resultSet.getString("LastName");
            int Age = resultSet.getInt("Age");
            int PPAddress = resultSet.getInt("PPAddress");
            int PPWallet = resultSet.getInt("PPWallet");
            int DollarWallet = resultSet.getInt("DollarWallet");

            user = new User(id, UserID, FirstName, LastName, Age, PPAddress, PPWallet, DollarWallet);
        }

        resultSet.close();
        statement.close();

        return user;
    }
}
