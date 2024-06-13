package com.winter.home.student;

import java.util.List;

public class StudentService {
	private StudentDAO studentDAO;

	public StudentService() {
		studentDAO = new StudentDAO();
	}

	// list
	public List<StudentDTO> getStudents() {
		List<StudentDTO> ar = null;
		try {
			ar = studentDAO.getStudent();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ar;
	}

	// detail
	public StudentDTO getdetail(StudentDTO studentDTO) {
		try {
			studentDTO = studentDAO.getdetail(studentDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			studentDTO = null;
		}

		return studentDTO;
	}
}
