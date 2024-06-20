package servlet;

import java.io.IOException;

import bean.User;
import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String error = "";
		String cmd = "";

		String user_id = request.getParameter("user_id");
		String password = request.getParameter("password");

		//UserDAOのオブジェクト化
		UserDAO userDaoObj = new UserDAO();

		User user = null;
		HttpSession session = null;
		
		try {
			
			user = userDaoObj.selectByUser(user_id, password);

			session = request.getSession();
			
		}catch (IllegalStateException e) {
			error = "DB接続エラーのため、ログインはできません。";
			cmd = "logout";
		} catch (Exception e) {
			error = "予期せぬエラーが発生しました。<br>" + e;
			cmd = "menu";
		} finally {
			if(error.equals("")) {
			if (user.getUser_id() != null) {
				//セッションスコープに登録
				request.setAttribute("user", user);

				//クッキーに入力情報を登録（５日間）
				Cookie userCookie = new Cookie("user_id", user_id);
				userCookie.setMaxAge(60 * 60 * 24 * 5);
				response.addCookie(userCookie);

				Cookie passwordCookie = new Cookie("password", password);
				userCookie.setMaxAge(60 * 60 * 24 * 5);
				response.addCookie(passwordCookie);

				session.setAttribute("user", user);

				//menu.jspにフォワード
				request.getRequestDispatcher("/view/menu.jsp").forward(request, response);

			} else {
				//エラーメッセージの設定
				request.setAttribute("message", "入力データが間違っています!");

				//login.jspにフォワード
				request.getRequestDispatcher("/view/login.jsp").forward(request, response);
			}
			}else {
				request.setAttribute("cmd", cmd);
				request.setAttribute("error", error);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}

	}

}
