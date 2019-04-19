package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateMember
 */
@WebServlet("/member/updateMemberServlet")
public class UpdateMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateMember() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("UpdateMember.java: doGet()");
		//String action = request.getParameter("action");
		//System.out.println("action = " + action);
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("UpdateMember.java: doPost()");
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday");
		String address = request.getParameter("address");
		//String action = request.getParameter("action");
		//System.out.println("action = " + action);
		
		MemberDTO member = new MemberDTO(id, "*", name, birthday, address);
		System.out.println(member.toString());
		
		MemberDAO mDao = new MemberDAO();
		mDao.updateMember(member);
		mDao.close();
		
		String message = "다음과 같이 수정하였습니다.\\n" + member.toString();
		request.setAttribute("message", message);
		request.setAttribute("url", "loginMain.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("alertMsg.jsp");
        rd.forward(request, response);
		//response.sendRedirect("loginMain.jsp");
	}
}
