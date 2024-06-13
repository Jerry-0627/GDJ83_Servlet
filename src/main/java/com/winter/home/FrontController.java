package com.winter.home;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.winter.home.student.StudentController;
import com.winter.home.weather.WeatherController;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
		System.out.println("실행 됨");
		StudentController sc = new StudentController();
		WeatherController wc = new WeatherController();

		String uri = request.getRequestURI();
		String method = request.getMethod();
		String ad = "";

		if (!uri.equals("/favicon.ico")) {
			// 1. subString
			// String path = uri.substring(1, uri.lastIndexOf("/"));

			// 2. spilit
			String[] ar = uri.split("/");
//			System.out.println(ar[1]);
			Action action = new Action();
			if (uri.equals("/")) {
				action.setFlag(true);
				action.setPath("WEB-INF/views/index.jsp");
			} else if (ar[1].equals("student")) {
				action = sc.start(request);
			} else if (ar[1].equals("weather")) {
				action = wc.start(request);
			}

			// 3. StringTokennizer
			// StringTokenizer st = new StringTokenizer(uri, "/");
			// while(st.hasMoreTokens){
			// System.out.println(st.nexToken());
			// }

//			System.out.println(uri);
//			System.out.println(method);
			if (action.isFlag()) {
				RequestDispatcher view = request.getRequestDispatcher(action.getPath());
				// 여기는 무조건 절대경로로 써야함
				view.forward(request, response);
				// 여기서 벗어나서 그쪽 페이지로 가라
			} else {
				response.sendRedirect(action.getPath());
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response); // 다시 doGet이 호출, 따라서 get으로 오든 post로 오든 get호출
	}

}
