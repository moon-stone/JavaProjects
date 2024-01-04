public interface IStatement {
    public void insertDataInTable(String name, int age, double marks);
    public void updateDataById(int id, int marks);
    public void deleteDataById(int id);
    public void showDataInTable();
    public void close();
}
