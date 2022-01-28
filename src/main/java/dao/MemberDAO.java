package dao;

import dto.MemberDTO;

import java.sql.*;

public class MemberDAO {

    public Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            return DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "system", "1234");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean signUp(MemberDTO member) {

        String sql = "INSERT INTO APP_TEST_MEMBER VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = getConnection().prepareStatement(sql)) {
            pstmt.setString(1, member.getId());
            pstmt.setString(2, member.getPw());
            pstmt.setString(3, member.getName());
            pstmt.setDate(4, member.getRegDate());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public MemberDTO login(String id) {

        String sql = "SELECT * FROM APP_TEST_MEMBER WHERE ID = '" + id + "'";
        try (Statement statement = getConnection().createStatement(); ResultSet rs = statement.executeQuery(sql)) {
            rs.next();
            return new MemberDTO(
                    rs.getString("ID"),
                    rs.getString("PW"),
                    rs.getString("NAME"),
                    rs.getDate("regDate"));
        } catch (SQLException e) {
            return null;
        }
    }

    public boolean idCheck(String id) {

        String sql = "SELECT * FROM APP_TEST_MEMBER WHERE ID = '" + id + "'";
        try (Statement statement = getConnection().createStatement(); ResultSet rs = statement.executeQuery(sql)) {
            rs.next();
            String result = rs.getString("ID");
            if (result != null) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
