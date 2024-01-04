import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StatementFactory {
    private static final String CLASSNAME_JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "January@2023";
    private Connection Connection;
    public IStatement getStatement(StatementType statementType){
        try {
            Class.forName(CLASSNAME_JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            Connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        switch (statementType){
            case StatementType.NORMAL -> {
                return new StatementDemo(Connection);
            }
            case StatementType.PREPARED -> {
                return new PreparedStatementDemo(Connection);
            }
        }
        return null;
    }
}
