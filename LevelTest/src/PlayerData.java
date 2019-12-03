import java.util.ArrayList;
import java.util.Scanner;

public class PlayerData {

	public ArrayList<ArrayList<Player>> inputData() {
		ArrayList<ArrayList<Player>> teamList = new ArrayList<ArrayList<Player>>();
		for (int teamNum = 1; teamNum < 3; teamNum++) {
			ArrayList<Player> playerList = inputTeamData(teamNum);
			teamList.add(playerList);
		} // End for
		System.out.println("팀 데이터 입력이 완료되었습니다.");
		return teamList;
	} // End method

	private ArrayList<Player> inputTeamData(int teamNum) {
		Scanner sc = new Scanner(System.in);
		System.out.print(teamNum + "팀의 이름을 입력하세요> ");
		String teamName = sc.nextLine();
		ArrayList<Player> playerList = new ArrayList<Player>();
		for (int playerNum = 1; playerNum < 10; playerNum++) { // playerNum < 10
			Player player = inputPlayerData(playerNum);
			player.setNumber(playerNum);
			player.setTeamName(teamName);
			playerList.add(player);
		} // End for
		return playerList;
	} // End method

	private Player inputPlayerData(int playerNum) {
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.print(playerNum + "번 타자 정보 입력> ");
			String playerData = sc.nextLine();
			String[] splitData = playerData.split(", ");
			if (splitData.length != 2) {
				System.out.println("잘못 입력하셨습니다. [이름, 타율] 방식으로 다시 입력해주세요.");
			} else if (checkBattingAverage(splitData[1])) {
				System.out.println("타율을 잘못 입력하셨습니다. 0.100~0.500 사이의 소수점 셋째 자리까지 입력해주세요.");
			} else {
				Player player = new Player();
				player.setName(splitData[0]);
				player.setBattingAverage(Double.parseDouble(splitData[1]));
				return player;
			} // End if
		} // End while
	} // End method

	private boolean checkBattingAverage(String battingAverage) {
		double ba = Double.parseDouble(battingAverage);
		if (battingAverage.length() == 5) {
			if (0.1 < ba && ba < 0.5)
				return false;
		} // End if
		return true;
	} // End method

	public void checkData(ArrayList<ArrayList<Player>> teamList) {
		if (teamList.isEmpty()) {
			System.out.println("데이터를 입력해주세요.");
		} else {
			outputData(teamList);
		} // End if
	} // End method

	private void outputData(ArrayList<ArrayList<Player>> teamList) {
		for (int i = 0; i < teamList.size(); i++) {
			System.out.println(teamList.get(i).get(i).getTeamName() + " 팀 정보");
			for (int j = 0; j < teamList.get(i).size(); j++) {
				System.out.println(teamList.get(i).get(j).toString());
			} // End for
		} // End for
	} // End method

} // End class
