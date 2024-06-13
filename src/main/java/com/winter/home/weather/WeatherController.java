
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

		// 메서드 형식을 반환하자.
		String method = request.getMethod().toUpperCase();

		if (divi[2].equals("list")) {
			List<WeatherDTO> ar = weatherService.getWeathers();
			request.setAttribute("list", ar);
			action.setPath("/WEB-INF/views/weather/list.jsp");
		} else if (divi[2].equals("detail")) {
			//
			String num = request.getParameter("num");// 랜선을 타고오는 모든것은 String 타입이다.
			WeatherDTO weatherDTO = new WeatherDTO();
			weatherDTO.setNum(Long.parseLong(num));
			weatherDTO = weatherService.getDetail(weatherDTO);

			if (weatherDTO != null) {
				request.setAttribute("dto", weatherDTO);
				action.setPath("/WEB-INF/views/weather/detail.jsp");
			} else {
				request.setAttribute("message", "정보가 없습니다.");
				action.setPath("/WEB-INF/views/commons/message.jsp");
			}

		} else if (divi[2].equals("add")) {
			if (method.equals("POST")) {
				// 파라미터 : 클라이언트에서 서버로 보내는 데이터
				// 모든 요청은 다 request에 들어감
				String city = request.getParameter("city");
				double gion = Double.parseDouble(request.getParameter("gion"));
				String status = request.getParameter("status");
				System.out.println(request.getParameter("status"));

				int humidity = Integer.parseInt(request.getParameter("humidity"));
				WeatherDTO weatherdto = new WeatherDTO();
				weatherdto.setCity(city);
				weatherdto.setGion(gion);
				weatherdto.setStatus(status);
				weatherdto.setHumidity(humidity);
				weatherService.add(weatherdto);
			} else {
				// 갯은 액션에 값을 넣고 이동하기만 하면 끝이다.

			}
			action.setPath("/WEB-INF/views/weather/add.jsp");
		} else if (divi[2].equals("delete")) {

		} else {

		}

		return action;
	}
	// TODO Auto-generated method stub

}
