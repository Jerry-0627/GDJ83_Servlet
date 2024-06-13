package com.winter.home.weather;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class WeatherDAO {
	// DTO : Data Transfer Object
	// DAO : Data Access Object

	// getWeathers
	// 파일에 날씨정보들을 읽어와서 파싱한 후에 DTO에 담아서 리턴해줌.

	// list
	public List<WeatherDTO> getWeathers() throws Exception {
		ArrayList<WeatherDTO> dtos = new ArrayList<WeatherDTO>();
		File file = new File("C:\\study", "weather.txt");

		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		while (true) {
			String st1 = br.readLine();
			if (st1 == null) {
				break;
			}
			st1 = st1.replace(",", "-");
			StringTokenizer stn = new StringTokenizer(st1, "-");
			while (stn.hasMoreTokens()) {
				WeatherDTO dto = new WeatherDTO();
				dto.setNum(Long.parseLong(stn.nextToken().trim()));

				dto.setCity(stn.nextToken().trim());
				dto.setGion(Double.parseDouble(stn.nextToken().trim()));
				dto.setStatus(stn.nextToken().trim());
				dto.setHumidity(Integer.parseInt(stn.nextToken().trim()));
				dtos.add(dto);
			}

		}
		br.close();
		fr.close();

		return dtos;

	}

	// detail
	public WeatherDTO getDetail(WeatherDTO weatherdto) throws Exception {
		List<WeatherDTO> ar = this.getWeathers();
		WeatherDTO result = null;
		for (WeatherDTO w : ar) {
			if (w.getNum() == weatherdto.getNum()) {
				result = w;
				break;
			}
		}

		return result;
	}

	// add
	public void add(WeatherDTO weatherDTO) throws Exception {
		// 프린트를 했을 떄 도시명-기온-상태-습도 가 나올 수 있도록 테스트 해보기
		List<WeatherDTO> ar = this.getWeathers();

		StringBuffer sb = new StringBuffer();
		sb.append(ar.size() + 1);
		sb.append("-" + weatherDTO.getCity());
		sb.append("-" + weatherDTO.getGion());
		sb.append("-" + weatherDTO.getStatus());
		sb.append("-" + weatherDTO.getHumidity());
		String stg = sb.toString();

		File file = new File("C:\\study", "weather.txt");
		System.out.println(stg);
		FileWriter fr = new FileWriter(file, true);
		fr.write(stg + "\r\n");
		fr.flush();

	}
}
