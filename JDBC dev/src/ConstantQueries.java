public class ConstantQueries {
    //normal statement queries
    public static final String selectQuery = "Select * from students";
    public static final String updateMarksQuery = "Update students set marks = %f where id = %d";
    public static final String insertQuery = "Insert into students(name, age, marks) values ('%s', %d, %f)";
    public static final String deleteQueryById = "Delete from students where id > %d";
    
    //preparedStatement queries
    public static final String updateMarksQueryByIdPreparedStatement = "Update students set marks = ? where id = ?";
    public static final String insertQueryPreparedStatement = "Insert into students(name, age, marks) values (?, ?, ?)";
    public static final String deleteQueryByIdPreparedStatement = "Delete from students where id > ?";

}
