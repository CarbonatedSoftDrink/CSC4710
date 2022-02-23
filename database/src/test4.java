/*
 *
 The purpose of exercise 3 is to learn how to execute a CREATE/INSERT/SELECT/UPDATE/DELETE statement in Java over a table located at a local MySQL database server. 
     1) Execute each SQL statement from ch2's slides in Java. You will need to understand how method writeResultSet() works and modify it to display your results correctly. 
     2) Understand the difference between dynamic SQLs and static SQLs. 
 *
 * */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class test4  {
  private static Connection connect = null;
  private static Statement statement = null;
  private static PreparedStatement preparedStatement = null;
  private static ResultSet resultSet = null;



 public static void main(String[] args) {

    String sql1 = "DROP TABLE IF EXISTS Car";
    // 1 create
    String sql2 = "CREATE TABLE IF NOT EXISTS Car " +
                   "(id INTEGER not NULL AUTO_INCREMENT, " +
                   " Name VARCHAR(20), " + 
                   " Color VARCHAR(50), " + 
                   " Status VARCHAR(10), " + 
                   " PRIMARY KEY ( id ))"; 
    String sql3 = "insert into  Car(Name, Color, Status) values (?, ?, ?)"; // 1 insert
    String sql4 = "insert into Car(Name, Color, Status) values (\"Chevy\", \"Blue\", \"New\")"; // 2 insert
    String sql5 = "UPDATE Car set Color=\"Light Blue\" WHERE Name=\"Chevy\""; // 1 update
    String sql6 = "DELETE FROM Car WHERE Name=\"Chevy\""; // 1 delete
    
    String sql7 = "insert into Car(Name, Color, Status) values (\"Toyota\", \"Gray\", \"Used\")"; // 3 insert
    String sql8 = "insert into Car(Name, Color, Status) values (\"Honda\", \"White\", \"New\")"; // 4 insert


    try {
      System.out.println("Select a table and then print out its content.");
      // This will load the MySQL driver, each DB has its own driver
      // Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager
              .getConnection("jdbc:mysql://127.0.0.1:3306/testdb?"
                  + "useSSL=false&user=john&password=pass1234");

        

      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();

      statement.executeUpdate(sql1);
      statement.executeUpdate(sql2);


      preparedStatement = connect
          .prepareStatement(sql3);
      preparedStatement.setString(1, "Chevy");
      preparedStatement.setString(2, "Blue");
      preparedStatement.setString(3, "New");
      preparedStatement.executeUpdate();
      
      statement.executeUpdate(sql4);


      // see the results 
      resultSet = statement.executeQuery("select * from Car"); // 1 select
      writeResultSet(resultSet);

      System.out.println("After the update statement is executed.");
      statement.executeUpdate(sql5);
      // see the results 
      resultSet = statement.executeQuery("select * from Car"); // 2 select
      writeResultSet(resultSet);

      System.out.println("After the delete statement is executed.");
      statement.executeUpdate(sql6);
      // see the results 
      resultSet = statement.executeQuery("select * from Car"); // 3 select
      writeResultSet(resultSet);
      
      statement.executeUpdate(sql7);
      statement.executeUpdate(sql8);
      
      // see the results 
      resultSet = statement.executeQuery("select * from Car"); // 4 select
      writeResultSet(resultSet);
      
      // view name and ID of new cars only
      //resultSet = statement.executeQuery("SELECT Id, Name FROM Car WHERE Status = \"New\""); // 5 select
      //writeResultSet(resultSet);
      
      // view entire entry of new cars only
      System.out.println("Display new cars only:");
      resultSet = statement.executeQuery("SELECT * FROM Car WHERE Status = 'New'"); // 6 select
      writeResultSet(resultSet);
      
      // view used cars only
      System.out.println("Display used cars only:");
      resultSet = statement.executeQuery("SELECT * FROM Car WHERE Status = 'Used'"); // 7 select
      writeResultSet(resultSet);

      
    } catch (Exception e) {
         System.out.println(e);
    } finally {
      close();
    }

  }

  private void writeMetaData(ResultSet resultSet) throws SQLException {
    //   Now get some metadata from the database
    // Result set get the result of the SQL query
    
    System.out.println("The columns in the table are: ");
    
    System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
    for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
      System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
    }
  }

  private static void writeResultSet(ResultSet resultSet) throws SQLException {
    // ResultSet is initially before the first data set
    System.out.println("print result from a table..");
    while (resultSet.next()) {
      // It is possible to get the columns via name
      // also possible to get the columns via the column number
      // which starts at 1
      // e.g. resultSet.getSTring(2);
      Integer id = resultSet.getInt("id");
      String name = resultSet.getString("Name");
      String Color = resultSet.getString("Color");
      String status = resultSet.getString("Status");
      System.out.println("id " + id);
      System.out.println("name: " + name);
      System.out.println("Color: " + Color);
      System.out.println("status: " + status);
      System.out.println("");
    }
  }

  // You need to close the resultSet
  private static void close() {
    try {
      if (resultSet != null) {
        resultSet.close();
      }

      if (statement != null) {
        statement.close();
      }

      if (connect != null) {
        connect.close();
      }
    } catch (Exception e) {

    }
  }
} 
