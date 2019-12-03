import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	public void menu() {
		PlayerData playerData = new PlayerData();
		ArrayList<ArrayList<Player>> teamList = new ArrayList<ArrayList<Player>>();
		Baseball baseball = new Baseball();
		while (true) {
			String menuNum = inputMenu();
			if (menuNum.equals("1")) { // 데이터 입력
				teamList = playerData.inputData();
			} else if (menuNum.equals("2")) { // 데이터 출력
				playerData.checkData(teamList);
			} else if (menuNum.equals("3")) { // 시합 시작
				baseball.checkPlay(teamList);
			} else {
				System.out.println("잘못된 번호를 입력했습니다. 다시 입력해주세요.");
			} // End if
		} // End while
	} // End method

	private String inputMenu() {
		System.out.println("신나는 야구 시합");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 출력");
		System.out.println("3. 시합 시작");
		System.out.print("메뉴 선택 (1 - 3) ");
		Scanner sc = new Scanner(System.in);
		String menuNum = sc.nextLine();
		return menuNum;
	} // End method

} // End class
