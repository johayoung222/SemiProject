

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;

/**
 * Servlet implementation class MemberdeleteFriendQueue
 */
@WebServlet("/member/deleteFriendQueue")
public class MemberdeleteFriendQueue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberdeleteFriendQueue() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 친구요청을 보낸 사용자의 아이디
		String selectFriend = (String)request.getParameter("selectFriend");
		// 본인의 아이디
		String memberId = (String)request.getParameter("memberId");
		System.out.println("MemberdeleteFriendQueue@selectFriend/memberId : "+selectFriend+"/"+memberId);
		
		// result = new MemberService().
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
