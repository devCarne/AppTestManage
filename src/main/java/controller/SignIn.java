package controller;

import dao.MemberDAO;
import dto.MemberDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/signIn.do")
public class SignIn extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        MemberDAO dao = new MemberDAO();

        MemberDTO member = dao.login(req.getParameter("id"));

        if (member == null) {
            out.println("<script>alert('아이디가 잘못되었습니다.'); history.go(-1)</script>");
        } else if (!member.getPw().equals(req.getParameter("pw"))) {
            out.println("<script>alert('비밀번호가 잘못되었습니다.'); history.go(-1)</script>");
        } else {
            out.println("<script>alert('성공적으로 로그인되었습니다.');");
            HttpSession session = req.getSession();
            session.setAttribute("memberId", member.getId());
            session.setAttribute("memberName", member.getName());
            session.setAttribute("memberRegDate", member.getRegDate());
            resp.sendRedirect("memberMain.jsp");
        }
    }
}
