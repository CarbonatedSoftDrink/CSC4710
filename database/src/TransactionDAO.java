import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

@WebServlet("/TransactionDAO")
public class TransactionDAO {
	private String jdbcDriver = "com.mysql.jdbc.Driver";
    private String dbAddress = "jdbc:mysql://localhost:3306/";
    private String dbName = "twitterbase";
    private String userName = "john";
    private String password = "pass1234";

    private static final long serialVersionUID = 1L;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet result;
    private Connection connect;

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
            //.getConnection(dbAddress + dbName, userName, password); this line gave me an error
            System.out.println(connect);
        }
    }
    
    public TransactionDAO() {

    }
    
	public List<Transaction> getTransactions(User loggedIn) throws SQLException {
		List<Transaction> transactionList = new ArrayList<Transaction>();
		Transaction transaction = null;
        String sql = "SELECT * FROM transactions WHERE fromuser=? OR touser=?";
        connect_func();
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, loggedIn.getUsername());
        preparedStatement.setString(2, loggedIn.getUsername());
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
        	Integer id = resultSet.getInt("transid");
            String fromuser = resultSet.getString("fromuser");
            String touser = resultSet.getString("touser");
            Integer ppsamt = resultSet.getInt("ppsamt");
            Double dollaramt = resultSet.getDouble("dollaramt");
            Timestamp when = resultSet.getTimestamp("when");
            String transtype = resultSet.getString("transtype");
            Double price = resultSet.getDouble("price");
            transaction = new Transaction(id, fromuser, touser, ppsamt, dollaramt, when, transtype, price);
            
            transactionList.add(transaction);
        }
        
        resultSet.close();

        return transactionList;
	}
}
