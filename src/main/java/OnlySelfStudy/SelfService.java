package OnlySelfStudy;

import java.util.List;

public class SelfService {
	private SelfDAO selfDAO;

	public SelfService() {
		selfDAO = new SelfDAO();
	}

	public List<SelfDTO> getSelfs() {
		try {
			List<SelfDTO> arSelfDTO = selfDAO.getSelfs();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			List<>
		}
		return selfDTO;
	}
}
