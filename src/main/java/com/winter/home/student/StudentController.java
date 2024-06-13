
package com.winter.home.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.winter.home.Action;

public class StudentController {
	private StudentService studentService;

	public StudentController() {
		// TODO Auto-generated constructor stub
		this.studentService = new StudentService();
		// 변수를 내부에서 만들기 때문에 StudentContoller가 소멸되면 studentSerive도 같이 소멸됨
	}

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
		// 콘트롤러가 소멸될 때 스튜덴트서빗그의 주소가 외부에 있기에 소멸되지 않음.
	}

	public Action start(HttpServletRequest request) {

		String[] divi = request.getRequestURI().split("/");
		System.out.println(divi[2]);

		// list => 학생 정보 전체 출력
		// detail => 학생 한명 정보 출력
		// add => 학생 한명의 정보 추가
		// delete => 학생 한명 삭제

		Action action = new Action();
		action.setFlag(true);
		String method = request.getMethod();

		if (divi[2].equals("list")) {
			List<StudentDTO> ar = studentService.getStudents();
			request.setAttribute("list", ar);
			action.setPath("/WEB-INF/views/student/list.jsp");
		} else if (divi[2].equals("detail")) {
			String num = request.getParameter("num");
			StudentDTO studentDTO = new StudentDTO();
			studentDTO.setNum(Integer.parseInt(num));
			studentDTO = studentService.getdetail(studentDTO);
			if (studentDTO != null) {
				request.setAttribute("detail", studentDTO);
				action.setPath("/WEB-INF/views/student/detail.jsp");
			} else {
				request.setAttribute("message", "없음");
				action.setPath("/WEB-INF/views/commons/message.jsp");

			}

			action.setPath("/WEB-INF/views/student/detail.jsp");
		} else if (divi[2].equals("add")) {

			if (method.toUpperCase().equals("POST")) {
				System.out.println("학생 등록 데이터를 꺼내야함");
				StudentDTO student = new StudentDTO();

				String name = request.getParameter("name");
				student.setName(name);

				String num = request.getParameter("num");
				student.setNum(Integer.parseInt(num));

				String avg = request.getParameter("avg");
				student.setAvg(Double.parseDouble(avg));

				System.out.println(request.getParameter("ch"));
				System.out.println(request.getParameter("mobile"));
				String[] ch2 = request.getParameterValues("ch2");

				for (String c : ch2) {
					System.out.println(c);
				}
				System.out.println(request.getParameter("content"));

				action.setFlag(false);
				action.setPath("./list");

			} else {
				action.setPath("/WEB-INF/views/student/add.jsp");
			}

		} else if (divi[2].equals("delete")) {

		} else {

		}

		return action;

	}
}
