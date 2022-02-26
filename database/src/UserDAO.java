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
    String sql1 = "DROP TABLE IF EXISTS User";
    String sql2 = "DROP TABLE IF EXISTS Tweet";
    String sql3 = "DROP TABLE IF EXISTS Transactions";
    String sql4 = "DROP TABLE IF EXISTS Followers";
    String sql5 = "DROP TABLE IF EXISTS LikedTweets";
    
    String sql6 = "CREATE TABLE IF NOT EXISTS User "
    		+ "	(id int NOT NULL AUTO_INCREMENT, "
    		+ "    UserID varchar(255) UNIQUE, "
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
    
    String sql11 = "insert into User(UserID, FirstName, LastName, Age, PPAddress, PPWallet, DollarWallet) values (\"root\", \"root\", \"root\", 99, 1000, 1000, 0)";
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
        connect_func();
        statement = connect.createStatement();
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
        //statement.executeUpdate(sql11);
    }

    public boolean insert(User user) throws SQLException {
        connect_func();
        String sql = "insert into User(UserID, FirstName, LastName, Age, PPAddress, PPWallet, DollarWallet) values (?, ?, ?, ?, ?, ?, ?)";
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, user.UserID);
        preparedStatement.setString(2, user.FirstName);
        preparedStatement.setString(3, user.LastName);
        preparedStatement.setInt(4, user.Age);
        preparedStatement.setInt(5, user.PPAddress);
        preparedStatement.setInt(6, user.PPWallet);
        preparedStatement.setInt(7, user.DollarWallet);
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
        preparedStatement.setInt(7, user.DollarWallet);
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
