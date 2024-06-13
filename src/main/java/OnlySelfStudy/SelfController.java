package OnlySelfStudy;

import javax.servlet.http.HttpServletRequest;

import com.winter.home.Action;

public class SelfController {
	private SelfService selfService;

	public SelfController() {
		this.selfService = new SelfService();
	}

	public void start(HttpServletRequest request) {
		String[] arSt = request.getRequestURI().split("/");
		Action action = new Action();
		if (arSt[2].equals("list")) {

			System.out.println("ㅁㄴㅇ");
		} else if (arSt[2].equals("detail")) {

		} else if (arSt[2].equals("add")) {

		}
	}

}
