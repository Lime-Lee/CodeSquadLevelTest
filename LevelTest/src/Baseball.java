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
		System.out.println(teamList.get(0).get(0).getTeamName() + " VS " + teamList.get(1).get(0).getTeamName() + "의 시합을 시작합니다.");
		String[] turn = { "초", "말" };
		int[] teamScore = { 0, 0 }; // 1팀, 2팀
		for (int inning = 1; inning < 7; inning++) { // inning < 7
			for (int turnNum = 0; turnNum < 2; turnNum++) {
				System.out.println(inning + "회" + turn[turnNum] + " " + teamList.get(turnNum).get(0).getTeamName() + "의 공격");
				int hitPoint = teamAttack(teamList.get(turnNum));
				teamScore[turnNum] += hitPoint;
			} // End for
		} // End for
		System.out.println("경기 종료");
		System.out.println(teamList.get(0).get(0).getTeamName() + " VS " + teamList.get(1).get(0).getTeamName());
		System.out.println(teamScore[0] + " : " + teamScore[1]);
		System.out.println("Thank you!");
	} // End method

	private int teamAttack(ArrayList<Player> playerList) {
		Score score = new Score();
		int playerNum = 0;
		while (true) {
			if (playerList.size() == playerNum) {
				playerNum = 0;
			} // End if
			score = playerAttack(playerList.get(playerNum), score);
			if (score.getOut() == 3) { // 아웃이 3회일 때
				break;
			} // End if
			playerNum++;
		} // End while
		if (3 < score.getHit())
			return score.getHit() - 3;
		else
			return 0;
	} // End method

	private Score playerAttack(Player player, Score score) {
		System.out.println(player.getNumber() + "번 " + player.getName());
		while (true) {
			score.setNowCount(bat(player.getBattingAverage()));
			score = checkScore(score); // 0스트라이크 1볼 2안타 3아웃
			score = checkCount(score);
			System.out.println(score.getStrike() + "S " + score.getBall() + "B " + score.getOut() + "O");
			if (score.getNowCount() == 2 || score.getNowCount() == 3) {
				return score;
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

	private Score checkScore(Score score) {
		if (score.getNowCount() == 0) {
			System.out.println("스트라이크!");
			score.setStrike(score.getStrike() + 1);
		} else if (score.getNowCount() == 1) {
			System.out.println("볼!");
			score.setBall(score.getBall() + 1);
		} else if (score.getNowCount() == 2) {
			System.out.println("안타!");
			score.setHit(score.getHit() + 1);
		} else if (score.getNowCount() == 3) {
			System.out.println("아웃!");
			score.setOut(score.getOut() + 1);
		} // End if
		return score;
	} // End method

	private Score checkCount(Score score) { // 카운트 체크
		if (score.getStrike() == 3) { // 스트라이크가 3회 누적 = 1 아웃
			score.setOut(score.getOut() + 1);
			score.setNowCount(3);
			System.out.println("아웃!");
		} else if (score.getBall() == 4) { // 볼 4회 누적 = 1 안타
			score.setHit(score.getHit() + 1);
			score.setNowCount(2);
			System.out.println("안타!");
		} // End if
		if (score.getNowCount() == 2 || score.getNowCount() == 3) { // 안타, 아웃일 때 초기화
			score.setStrike(0);
			score.setBall(0);
		} // End if
		return score;
	} // End method

} // End class
