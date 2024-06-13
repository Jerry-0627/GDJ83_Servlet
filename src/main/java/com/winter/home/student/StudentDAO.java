package com.winter.home.student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StudentDAO {

	public List<StudentDTO> getStudent() throws Exception {

		ArrayList<StudentDTO> ar = new ArrayList<StudentDTO>();
		File file = new File("C:\\study", "student.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		while (true) {
			String st = br.readLine();
			if (st == null) {
				break;
			}
			StringTokenizer stn = new StringTokenizer(st, ",");
			while (stn.hasMoreTokens()) {
				StudentDTO studentDTO = new StudentDTO();
				studentDTO.setNum(Integer.parseInt(stn.nextToken().trim()));
				studentDTO.setName(stn.nextToken().trim());
				studentDTO.setKor(Integer.parseInt(stn.nextToken().trim()));
				studentDTO.setEng(Integer.parseInt(stn.nextToken().trim()));
				studentDTO.setMath(Integer.parseInt(stn.nextToken().trim()));
				studentDTO.setToal(Integer.parseInt(stn.nextToken().trim()));
				studentDTO.setAvg(Integer.parseInt(stn.nextToken().trim()));
				ar.add(studentDTO);
			}
		}
		br.close();
		fr.close();

		return ar;
	}

	public StudentDTO getdetail(StudentDTO studentDTO) throws Exception {
		List<StudentDTO> ar = this.getStudent();
		StudentDTO result = null;
		for (StudentDTO s : ar) {
			if (s.getNum() == studentDTO.getNum()) {
				result = s;
				break;
			}
		}
		return result;

	}
}
