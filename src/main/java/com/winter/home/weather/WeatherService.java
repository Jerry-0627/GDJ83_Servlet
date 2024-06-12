package com.winter.home.weather;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class WeatherService {
	private StringBuffer sb;

	public WeatherService() {
		this.sb = new StringBuffer();
		this.sb.append("서울 , 29.3 - 맑음 - 60");
		this.sb.append("-부산 , 33.6 - 흐림 - 90");
		this.sb.append("-제주 , 26.5 - 눈 - 30");
		this.sb.append("-광주 , 10.6 - 태풍 - 80");
	}

	public List<WeatherDTO> getWeathers() {

		String info = sb.toString().replace(",", "-");
		StringTokenizer st = new StringTokenizer(info, "-");
		ArrayList<WeatherDTO> ar = new ArrayList<WeatherDTO>();
		while (st.hasMoreTokens()) {
			WeatherDTO dto = new WeatherDTO();
			dto.setCity(st.nextToken().trim());
			dto.setGion(Double.parseDouble(st.nextToken().trim()));
			dto.setStatus(st.nextToken().trim());
			dto.setHumidity(Integer.parseInt(st.nextToken().trim()));
			ar.add(dto);
		}

		return ar;
//		ArrayList<WeatherDTO> ar = new ArrayList<WeatherDTO>();
//		String info = sb.toString();
//		info = info.replace(",", "-");
//		String sb = info.substring(0)

	}

}
