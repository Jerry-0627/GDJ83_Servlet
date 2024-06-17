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

//		StringBuffer sb = new StringBuffer();
//		Calendar ca = Calendar.getInstance();
//		sb.append(ca.getTimeInMillis());
//		sb.append("-" + weatherDTO.getCity());
//		sb.append("-" + weatherDTO.getGion());
//		sb.append("-" + weatherDTO.getStatus());
//		sb.append("-" + weatherDTO.getHumidity());
//		String stg = sb.toString();
//
//		File file = new File("C:\\study", "weather.txt");
//		FileWriter fr = new FileWriter(file, true);
//		fr.write(stg + "\r\n");
//		fr.flush();
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

	// delete (매개변수 dto 받아오고)
	public void delete(WeatherDTO weatherDTO) throws Exception {
		// list불러와서
		// 지울려고 하는 num과 일치하는 것을 리스트에서 삭제
		// list를 파일에 다시 저장

		// 리스트를 불러 와서 지우려고 하는 num과 일치하는 것을 list에서 삭제한다.
		// list를 파일에 다시 저장한다.
		List<WeatherDTO> ar = this.getWeathers();
		for (WeatherDTO a : ar) {
			if (a.getNum() == weatherDTO.getNum()) {
				ar.remove(a);
				break;
			}
		}

		File file = new File("c:\\study", "weather.txt");
		FileWriter fr = new FileWriter(file, false);
		int i = 1;
		for (WeatherDTO a : ar) {
			StringBuffer sb = new StringBuffer();
			sb.append(i + "-");
			sb.append(a.getCity() + "-");
			sb.append(a.getGion() + "-");
			sb.append(a.getStatus() + "-");
			sb.append(a.getHumidity());
			String stn = sb.toString();
			fr.write(stn + "\r\n");
			fr.flush();
			i++;
		}
	}

	public void update(WeatherDTO weatherDTO) throws Exception {
		List<WeatherDTO> ar = this.getWeathers();
		// add(Object); 끝에 추가
		// add(index, Object); 삽입
		// set(index. object); 수정
		for (int i = 0; i < ar.size(); i++) {
			if (weatherDTO.getNum() == ar.get(i).getNum()) {
				ar.get(i).setCity(weatherDTO.getCity());
				ar.set(i, weatherDTO);
				break;
			}
		}

		File file = new File("c:\\study\\weather.txt");

		FileWriter fw = new FileWriter(file, false);
		StringBuffer stringBuffer = new StringBuffer();
		for (WeatherDTO dto : ar) {
			stringBuffer.append(dto.getNum());
			stringBuffer.append("-");
			stringBuffer.append(dto.getCity());
			stringBuffer.append("-");
			stringBuffer.append(dto.getGion());
			stringBuffer.append("-");
			stringBuffer.append(dto.getStatus());
			stringBuffer.append("-");
			stringBuffer.append(dto.getHumidity());
			stringBuffer.append("\r\n");
		}
		fw.write(stringBuffer.toString() + "\r\n");
		fw.flush();
		fw.close();
	}
}
