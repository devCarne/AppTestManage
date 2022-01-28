package dao;

import dto.MemberDTO;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class MemberDAOTest {

    MemberDAO dao = new MemberDAO();

    @Test
    void getConnection() {
        assertNotNull(dao.getConnection());
    }

    @Test
    void signUp() {
        assertTrue(dao.signUp(new MemberDTO("ut-login", "1111", "superUser", new Date(System.currentTimeMillis()))));
    }

    @Test
    void login() {
        assertNotNull(dao.login("ut-login"));
    }

    @Test
    void idCheck() {
        assertTrue(dao.idCheck("ut-login"));
    }
}