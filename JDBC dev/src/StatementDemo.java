import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementDemo implements IStatement{
    private final Connection connection;
    private Statement statement;

    public StatementDemo(Connection connection){
        this.connection = connection;
        try {
            this.statement = this.connection.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void insertDataInTable(String name, int age, double marks) {
        String query = String.format(ConstantQueries.insertQuery, name, age, marks);
        updateTable(query);
    }

    @Override
    public void updateDataById(int id, int marks) {
        String query = String.format(ConstantQueries.updateMarksQuery, 89.5, 1);
        updateTable(query);
    }

    @Override
    public void deleteDataById(int id) {
        String query = String.format(ConstantQueries.deleteQueryById, id);
        updateTable(query);
    }

    @Override
    public void showDataInTable() {
        try{
            ResultSet resultSet = statement.executeQuery(ConstantQueries.selectQuery);
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

    @Override
    public void close(){
        try {
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void updateTable(String query){
        try{
            int rowsAffected = statement.executeUpdate(query);
            if(rowsAffected >= 1){
                System.out.println("Table Updated successfully");
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
