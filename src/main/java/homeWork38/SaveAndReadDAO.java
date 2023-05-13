package homeWork38;

import java.sql.*;
public class SaveAndReadDAO {

    private static final String INSERT_QUERY = "INSERT INTO students (name, age, email) VALUES (?, ?, ?)";
    private static final String SELECT_QUERY = "SELECT * FROM students WHERE id = ?";

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://robot-do-user-1968994-0.b.db.ondigitalocean.com:25060/dotsenko";
        String user = "doadmin";
        String password = "AVNS_I6wlDKjGszZn1wvLr9t";
        return DriverManager.getConnection(url, user, password);
    }

    public void saveStudents(Students students) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(INSERT_QUERY)) {
            statement.setString(1, students.getName());
            statement.setInt(2, students.getAge());
            statement.setString(3, students.getEmail());
            statement.executeUpdate();
        }
    }

    public Students getStudents(int id) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(SELECT_QUERY)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    String email = resultSet.getString("email");
                    return new Students(id, name, age, email);
                }
                return null;
            }
        }
    }

}
