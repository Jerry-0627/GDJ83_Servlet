package com.winter.home.weather;

import java.util.List;

public class WeatherService {

	private WeatherDAO weatherDAO;

	public WeatherService() {
		// 객체는 생성자에서 만들어
		weatherDAO = new WeatherDAO();
	}

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

}
