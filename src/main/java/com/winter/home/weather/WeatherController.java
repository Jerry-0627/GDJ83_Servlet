package com.winter.home.weather;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.winter.home.Action;

public class WeatherController {
	private WeatherService weatherService;

	public WeatherController() {
		this.weatherService = new WeatherService();
	}

//	public WeatherController(WeatherService weatherservice) {
//		this.weatherService = new WeatherService();
//	}

	public Action start(HttpServletRequest request) {
		String[] divi = request.getRequestURI().split("/");

		Action action = new Action();
		action.setFlag(true);

		if (divi[2].equals("list")) {
			List<WeatherDTO> ar = weatherService.getWeathers();
			request.setAttribute("list", ar);
			action.setPath("/WEB-INF/views/weather/list.jsp");
		} else if (divi[2].equals("detail")) {
			action.setPath("/WEB-INF/views/weather/detail.jsp");
		} else if (divi[2].equals("add")) {
			action.setPath("/WEB-INF/views/weather/add.jsp");
		} else if (divi[2].equals("delete")) {

		} else {

		}

		return action;
	}
	// TODO Auto-generated method stub

}
