
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
				int humidity = Integer.parseInt(request.getParameter("humidity"));

				WeatherDTO weatherdto = new WeatherDTO();
				weatherdto.setCity(city);
				weatherdto.setGion(gion);
				weatherdto.setStatus(status);
				weatherdto.setHumidity(humidity);
				weatherService.add(weatherdto);
//forward 방식으로 해결했을 떄,..
//				List<WeatherDTO> ar = weatherService.getWeathers();
//				request.setAttribute("list", ar);
//				action.setPath("/WEB-INF/views/weather/list.jsp");
//				action.setPath("/weather/list"); 절대경로				
//				action.setParth("list") 상대결로(현재 위치를기준으로) ./는 생략 가능.
				action.setFlag(false); // false로 바꿔서 리턴해야 redirect로 내보냄.
				action.setPath("list");
			} else {

				action.setPath("/WEB-INF/views/weather/add.jsp");
				// 갯은 액션에 값을 넣고 이동하기만 하면 끝이다.

			}
		} else if (divi[2].equals("delete")) {
			String num = request.getParameter("num");// 랜선을 타고오는 모든것은 String 타입이다.
			WeatherDTO weatherDTO = new WeatherDTO();
			weatherDTO.setNum(Long.parseLong(num));
			// 누구를 지울지..
			weatherService.delete(weatherDTO);
			action.setFlag(false);
			action.setPath("/weather/list");

		} else if (divi[2].equals("update")) {

			if (method.toUpperCase().equals("POST")) {
				WeatherDTO weatherDTO = new WeatherDTO();
				weatherDTO.setNum(Long.parseLong(request.getParameter("num")));
				String city = request.getParameter("city");
				double gion = Double.parseDouble(request.getParameter("gion"));
				int humidity = Integer.parseInt(request.getParameter("humidity"));
				String status = request.getParameter("status");
				weatherDTO.setCity(city);
				weatherDTO.setGion(gion);
				weatherDTO.setHumidity(humidity);
				weatherDTO.setStatus(status);

				weatherService.update(weatherDTO);

				// 이미 만들어진 기능 호출은 리다이렉트

				action.setFlag(false);// 트루면 포워드 펄스면 리다이렉트
				action.setPath("./list");// 포워드면 jsp경로 리다이렉트면 현재 경로

//forward 방식으로 해결했을 떄,..

			} else {
				WeatherDTO weatherDTO = new WeatherDTO();
				weatherDTO.setNum(Long.parseLong(request.getParameter("num")));
				weatherDTO = weatherService.getDetail(weatherDTO);
				request.setAttribute("dto", weatherDTO);
				action.setPath("/WEB-INF/views/weather/update.jsp");
			}
		}

		return action;
	}
	// TODO Auto-generated method stub

}
