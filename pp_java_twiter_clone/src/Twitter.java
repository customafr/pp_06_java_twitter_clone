import java.sql.*;

public class Twitter {

    private final String DB = "jdbc:mysql://localhost:3306/Twitter";
    private final String USER = "root";
    private final String PASS = "manaparole";


    // create(insert)
    public void insert(String name, String posts) {
        String inserquery = "INSERT INTO twi (name, posts) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(DB, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(inserquery)) {

            pstmt.setString(1, name);
            pstmt.setString(2, posts);
            pstmt.executeUpdate();

            System.out.println("Data inserted...");

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    //update by name
    public void updatequery(String name, String posts) {
        String updatequery = "UPDATE twi SET posts = ? WHERE name = ?";

        try (Connection conn = DriverManager.getConnection(DB, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(updatequery)) {

            pstmt.setString(1, posts);
            pstmt.setString(2, name);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data updated for user: " + name);
            } else {
                System.out.println("No record found for user: " + name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // update by id
    public void updateById(int id, String posts) {
        String updateQuery = "UPDATE twi SET posts = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DB, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {

            pstmt.setString(1, posts);
            pstmt.setInt(2, id);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data updated for user with ID: " + id);
            } else {
                System.out.println("No record found for ID: " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // delete by id
    public void deletebyid(int id) {
        String deleteQuery = "DELETE from twi WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DB, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(deleteQuery)) {


            pstmt.setInt(1, id);        // delete by id
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data updated for user with ID: " + id);
            } else {
                System.out.println("No record found for ID: " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // delete by posts
    public void deletebyposts(String posts) {
        String deleteQuery = "DELETE from twi WHERE posts = ?";

        try (Connection conn = DriverManager.getConnection(DB, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(deleteQuery)) {


            pstmt.setString(1, posts);        // delete by posts
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data updated for user with posts: ");
            } else {
                System.out.println("No record found for posts: ");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}





