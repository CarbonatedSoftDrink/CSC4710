import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.sql.Date;

public class TweetDAO {
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public TweetDAO() {

    }
	
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
	
	public List<Tweet> listAllTweets() throws SQLException {
        List<Tweet> listTweets = new ArrayList<Tweet>();        
        String sql = "SELECT * FROM Tweets";      
        connect_func();      
        statement =  (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int id = resultSet.getInt("tweetid");
            String content = resultSet.getString("content");
            String author = resultSet.getString("author");
            //String status = resultSet.getString("status");
             
            Tweet tweet = new Tweet(id, content, author);
            listTweets.add(tweet);
        }        
        resultSet.close();
        statement.close();         
        disconnect();        
        Collections.reverse(listTweets);
        return listTweets;
    }
	
	public List<Tweet> listAllComments(int tweetID) throws SQLException {
        List<Tweet> listComments = new ArrayList<Tweet>();        
        String sql = "SELECT * FROM comments WHERE tweetid LIKE " + tweetID + "";      
        connect_func();      
        statement =  (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String content = resultSet.getString("desc");
            String author = resultSet.getString("commentor");
            //String status = resultSet.getString("status");
             
            Tweet tweet = new Tweet(id, content, author);
            listComments.add(tweet);
        }        
        resultSet.close();
        statement.close();         
        disconnect();        
        return listComments;
    }
	
	public boolean insert(Tweet tweet) throws SQLException {
        connect_func();
        
            String sql = "insert into tweets(content, author) values (?, ?)";
            preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
            preparedStatement.setString(1, tweet.getContent());
            preparedStatement.setString(2, tweet.getAuthor());
//    		preparedStatement.executeUpdate();

            boolean rowInserted = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
//            disconnect();
            return rowInserted;
	}
	
	public boolean insertComment(Tweet tweet, int tweetID) throws SQLException {
        	connect_func();
        	long millis = System.currentTimeMillis();  
            Date date = new Date(millis);
            
            java.util.Date dt = new java.util.Date();

            java.text.SimpleDateFormat sdf = 
                 new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            String currentTime = sdf.format(dt);
        
            String sql = "INSERT INTO `comments` (`desc`, `when`, tweetid, commentor) VALUES (?, ?, ?, ?)";
            preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
            preparedStatement.setString(1, tweet.getContent());
            preparedStatement.setString(2, currentTime);
            preparedStatement.setInt(3, tweetID);
            //preparedStatement.setDate(3, null);
            preparedStatement.setString(4, tweet.getAuthor());
//    		preparedStatement.executeUpdate();

            boolean rowInserted = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
//            disconnect();
            return rowInserted;
	}
	
	public int getLikes(int tweetID) throws SQLException{
		int answer = 0;
		String sql = "SELECT * FROM likes WHERE tweetid LIKE " + tweetID + "";      
        connect_func();      
        statement =  (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        
        while (resultSet.next()) {
        	answer += 1;
        }
        resultSet.close();
        statement.close();         
        //disconnect();    
        
        return answer;
	}
	
	public boolean addLike(int tweetID, User user) throws SQLException{
		int answer = 0;
		String username = user.getUsername();
		String sql = "SELECT * FROM likes WHERE tweetid LIKE " + tweetID + " AND userid LIKE '" + username + "'";      
        connect_func();      
        statement =  (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        
        while (resultSet.next()) {
        	answer += 1;
        }
        
        resultSet.close();  
        
        if (answer >= 1) {
        	return false;
        }
        else {
        	sql = "INSERT INTO `likes` (tweetid, userid) VALUES (?, ?)";
            preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
            preparedStatement.setInt(1, tweetID);
            preparedStatement.setString(2, username);
            
            boolean rowInserted = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            //disconnect();
            return rowInserted;
        }
	}
    
    protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }
    
    public Tweet getTweet(int id) throws SQLException {
    	Tweet tweet = null;
        String sql = "SELECT * FROM tweets WHERE tweetid = ?";
         
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setInt(1, id);
         
        ResultSet resultSet = preparedStatement.executeQuery();
         
        if (resultSet.next()) {
            String content = resultSet.getString("content");
            String author = resultSet.getString("author");
            //String status = resultSet.getString("status");
             
            tweet = new Tweet(id, content, author);
        }
         
        resultSet.close();
        statement.close();
         
        return tweet;
    }
    
}
