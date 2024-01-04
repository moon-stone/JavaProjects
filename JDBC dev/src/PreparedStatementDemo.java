import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementDemo implements IStatement{
    private Connection connection;
    PreparedStatement preparedStatement;
    public PreparedStatementDemo(Connection connection){
        this.connection = connection;
    }

    @Override
    public void insertDataInTable(String name, int age, double marks) {
        try {
            preparedStatement = connection.prepareStatement(ConstantQueries.insertQueryPreparedStatement);
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2, age);
            preparedStatement.setDouble(3, marks);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateDataById(int id, int marks) {
        try {
            preparedStatement = connection.prepareStatement(ConstantQueries.updateMarksQueryByIdPreparedStatement);
            preparedStatement.setInt(1, marks);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteDataById(int id) {
        try {
            preparedStatement = connection.prepareStatement(ConstantQueries.deleteQueryByIdPreparedStatement);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void showDataInTable() {
        try {
            preparedStatement = connection.prepareStatement(ConstantQueries.selectQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                double marks = resultSet.getDouble("marks");
                System.out.println("ID:NAME:AGE:MARKS = "+ id+":"+name+":"+age+":"+marks);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void close(){
        try {
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
