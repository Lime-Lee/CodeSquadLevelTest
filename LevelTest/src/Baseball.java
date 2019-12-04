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
		int[][] teamScore = { { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 } }; // 각 팀의 회차 점수
		int[][] teamTotCount = { { 0, 0, 0 }, { 0, 0, 0 } }; // 누적 0투구, 1삼진, 2안타
		Count count = new Count();
		for (int inning = 0; inning < 6; inning++) { // 6회까지
			count.setNowInning(inning);
			for (int teamNum = 0; teamNum < 2; teamNum++) { // 초, 말
				count.setNowTeamNum(teamNum);
				if (checkGameOver(teamScore, count)) break;
				teamAttack(teamList, teamScore, teamTotCount, count);
			} // End for
		} // End for
	} // End method

	private boolean checkGameOver(int[][] teamScore, Count count) {
		int[] totScore = { 0, 0 };
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 6; j++) {
				totScore[i] += teamScore[i][j];
			} // End for
		} // End for
		if (count.getNowInning() == 5 && count.getNowTeamNum() == 1 && totScore[0] < totScore[1]) {
			return true;
		} // End if
		return false;
	} // End method

	private void teamAttack(ArrayList<ArrayList<Player>> teamList, int[][] teamScore, int[][] teamTotCount, Count count) {
		Score score = new Score();
		int playerNum = 0;
		while (true) {
			count.setNowPlayerNum(playerNum);
			playerAttack(teamList, teamScore, teamTotCount, count, score);
			if (score.getOut() == 3) { // 아웃이 3회일 때
				break;
			} // End if
			playerNum++;
			if (teamList.get(count.getNowTeamNum()).size() == playerNum) { // 마지막 타자일 때
				playerNum = 0;
			} // End if
		} // End while
	} // End method

	private void playerAttack(ArrayList<ArrayList<Player>> teamList, int[][] teamScore, int[][] teamTotCount, Count count, Score score) {
		Billboard b = new Billboard();
		while (true) {
			int countNum = bat(teamList.get(count.getNowTeamNum()).get(count.getNowPlayerNum()).getBattingAverage());
			count.setNowBatCount(countNum);
			addScore(count, score, teamTotCount);
			checkScore(count, score, teamTotCount);
			if (3 < score.getHit()) // 안타 4 이상
				teamScore[count.getNowTeamNum()][count.getNowInning()] = score.getHit() - 3;
			if (count.getSkipKey() == 0 || (count.getSkipKey() - 1) < count.getNowInning())
				b.output(teamList, teamScore, teamTotCount, count, score);
			if (count.getNowBatCount() == 2 || count.getNowBatCount() == 3) // 안타, 아웃 => 선수 교체
				break;
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

	private void addScore(Count count, Score score, int[][] teamTotCount) {
		if (count.getNowBatCount() == 0) {
			score.setStrike(score.getStrike() + 1);
		} else if (count.getNowBatCount() == 1) {
			score.setBall(score.getBall() + 1);
		} else if (count.getNowBatCount() == 2) {
			score.setHit(score.getHit() + 1);
			teamTotCount[count.getNowTeamNum()][2]++; // 안타
		} else if (count.getNowBatCount() == 3) {
			score.setOut(score.getOut() + 1);
		} // End if
	} // End method

	private void checkScore(Count count, Score score, int[][] teamTotCount) {
		if (score.getStrike() == 3) { // 스트라이크 3 => 아웃 1
			score.setOut(score.getOut() + 1);
			count.setNowBatCount(3);
			teamTotCount[count.getNowTeamNum()][1]++; // 삼진
		} else if (score.getBall() == 4) { // 볼 4 => 안타 1
			score.setHit(score.getHit() + 1);
			count.setNowBatCount(2);
			teamTotCount[count.getNowTeamNum()][2]++; // 안타
		} // End if
		if (count.getNowBatCount() == 2 || count.getNowBatCount() == 3) { // 안타, 아웃 => 초기화
			score.setStrike(0);
			score.setBall(0);
		} // End if
		teamTotCount[count.getNowTeamNum()][0]++; // 투구
	} // End method

} // End class
