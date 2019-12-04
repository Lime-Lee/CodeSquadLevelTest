import java.util.ArrayList;

public class Baseball {

	public void checkPlay(ArrayList<ArrayList<Player>> teamList) {
		if (teamList.isEmpty()) {
			System.out.println("데이터를 입력해주세요.");
		} else {
			play(teamList);
		} // End if
	} // End method

	private void play(ArrayList<ArrayList<Player>> teamList) {
		int[][] teamScore = { { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 } };
		for (int inning = 0; inning < 6; inning++) { // 6회까지
			for (int teamNum = 0; teamNum < 2; teamNum++) { // 초, 말
				teamAttack(teamList, inning, teamNum, teamScore);
			} // End for
		} // End for
	} // End method

	private void teamAttack(ArrayList<ArrayList<Player>> teamList, int inning, int teamNum, int[][] teamScore) {
		PlayStatus status = new PlayStatus();
		status.setNowInning(inning);
		status.setNowTeamNum(teamNum);
		int playerNum = 0;
		while (true) {
			if (teamList.get(teamNum).size() == playerNum) { // 마지막 타자일 때
				playerNum = 0;
			} // End if
			status.setNowPlayerNum(playerNum);
			status = playerAttack(teamList, status, teamScore);
			if (status.getOut() == 3) { // 아웃이 3회일 때
				break;
			} // End if
			playerNum++;
		} // End while
	} // End method

	private PlayStatus playerAttack(ArrayList<ArrayList<Player>> teamList, PlayStatus status, int[][] teamScore) {
		Billboard b = new Billboard();
		while (true) {
			int countNum = bat(teamList.get(status.getNowTeamNum()).get(status.getNowPlayerNum()).getBattingAverage());
			status.setNowCount(countNum);
			status = addScore(status);
			status = checkScore(status);
			if (3 < status.getHit()) { // 안타 4 이상
				teamScore[status.getNowTeamNum()][status.getNowInning()] = status.getHit() - 3;
			} // End if
			b.output(teamList, status, teamScore);
			if (status.getNowCount() == 2 || status.getNowCount() == 3) { // 안타, 아웃 => 선수 교체
				return status;
			} // End if
		} // End while
	} // End method

	private int bat(double battingAverage) {
		int countNum;
		int randomNum = (int) (Math.random() * 10000) + 1;
		int avg = (int) (battingAverage * 10000);
		int ball = (int) (((1 - battingAverage) / 2 - 0.05) * 10000);
		if (randomNum < 1001) { // 아웃 : 0.1
			countNum = 3;
		} else if (1000 < randomNum && randomNum < (avg + 1001)) { // 안타 : h
			countNum = 2;
		} else if ((avg + 1000) < randomNum && randomNum < ((avg + 1001) + ball)) { // 볼 : ( 1 - h ) / 2 - 0.05
			countNum = 1;
		} else { // 스트라이크
			countNum = 0;
		} // End if
		return countNum;
	} // End method

	private PlayStatus addScore(PlayStatus status) {
		if (status.getNowCount() == 0) {
			status.setStrike(status.getStrike() + 1);
		} else if (status.getNowCount() == 1) {
			status.setBall(status.getBall() + 1);
		} else if (status.getNowCount() == 2) {
			status.setHit(status.getHit() + 1);
		} else if (status.getNowCount() == 3) {
			status.setOut(status.getOut() + 1);
		} // End if
		return status;
	} // End method

	private PlayStatus checkScore(PlayStatus status) {
		if (status.getStrike() == 3) { // 스트라이크 3 => 아웃 1
			status.setOut(status.getOut() + 1);
			status.setNowCount(3);
		} else if (status.getBall() == 4) { // 볼 4 => 안타 1
			status.setHit(status.getHit() + 1);
			status.setNowCount(2);
		} // End if
		if (status.getNowCount() == 2 || status.getNowCount() == 3) { // 안타, 아웃 => 초기화
			status.setStrike(0);
			status.setBall(0);
		} // End if
		return status;
	} // End method

} // End class
