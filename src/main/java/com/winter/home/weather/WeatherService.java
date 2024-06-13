package com.winter.home.weather;

import java.util.List;

public class WeatherService {

	private WeatherDAO weatherDAO;

	public WeatherService() {
		// 객체는 생성자에서 만들어
		weatherDAO = new WeatherDAO();
	}

	// list
	public List<WeatherDTO> getWeathers() {
		List<WeatherDTO> ar = null;
		try {
			ar = weatherDAO.getWeathers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ar;
	}

	// detail
	public WeatherDTO getDetail(WeatherDTO weatherDTO) { // long num을 받아도 되고 num이 들어가 있는 weatherDTO를 받아도됨.
		// 매개변수 : 외부에서 뭘 받아오는거
		try {
			weatherDTO = weatherDAO.getDetail(weatherDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			weatherDTO = null; // Exception이 발생하면 weatherDTO에 null이 아닌게 반환되서 일부러 null값을 넣어준 것임.
		}
		return weatherDTO;
	}

}
