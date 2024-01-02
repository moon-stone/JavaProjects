import static java.lang.Class.forName;
import java.sql.*;

public class Main {
    private static final String CLASSNAME_JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "January@2023";
    public static void main(String[] args){
        try {
            Class.forName(CLASSNAME_JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            String selectQuery = "Select * from students";
            showEntriesInTable(statement, selectQuery);
            String updateQuery = String.format("Update students set marks = %f where id = %d", 89.5, 1);
            updateTable(statement, updateQuery);
            showEntriesInTable(statement, selectQuery);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void updateTable(Statement statement, String query){
        try{
            int rowsAffected = statement.executeUpdate(query);
            if(rowsAffected >= 1){
                System.out.println("Table Updated successfully");
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    private static void showEntriesInTable(Statement statement, String query){
        try{
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                double marks = resultSet.getDouble("marks");
                System.out.println("ID:NAME:AGE:MARKS = "+ id+":"+name+":"+age+":"+marks);
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}