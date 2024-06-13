package OnlySelfStudy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SelfDAO {

	public List<SelfDTO> getSelfs() throws Exception {
		ArrayList<SelfDTO> arSelfDTO = new ArrayList<SelfDTO>();
		File file = new File("c:\\study", "self.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		while (true) {
			String stn = br.readLine();
			StringTokenizer st = new StringTokenizer(stn, ",");
			if (stn == null) {
				break;
			}
			while (st.hasMoreTokens()) {
				SelfDTO selfDTO = new SelfDTO();
				selfDTO.setName(st.nextToken().trim());
				selfDTO.setHeight(Integer.parseInt(st.nextToken().trim()));
				selfDTO.setWeight(Double.parseDouble(st.nextToken().trim()));
				arSelfDTO.add(selfDTO);
			}
		}
		return arSelfDTO;
	}

}
