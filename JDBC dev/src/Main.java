public class Main {
    public static void main(String[] args){
        StatementFactory statementFactory = new StatementFactory();
        IStatement statement = statementFactory.getStatement(StatementType.NORMAL);
        statement.insertDataInTable("Aman", 20, 60);
        statement.showDataInTable();
        statement.updateDataById(2, 65);
        statement.showDataInTable();
        statement.deleteDataById(1);
        statement.showDataInTable();
        statement.close();

        IStatement preparedStatement = statementFactory.getStatement(StatementType.PREPARED);
        preparedStatement.insertDataInTable("Abhay", 22, 63);
        preparedStatement.showDataInTable();
        preparedStatement.updateDataById(2, 80);
        preparedStatement.showDataInTable();
        preparedStatement.deleteDataById(2);
        preparedStatement.showDataInTable();
        preparedStatement.close();

    }
}