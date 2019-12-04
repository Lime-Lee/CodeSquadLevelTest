import java.util.ArrayList;
import java.util.Scanner;

public class Billboard {

	public void output(ArrayList<ArrayList<Player>> teamList, int[][] teamScore, int[][] teamTotCount, Count count, Score score) {
		outputScore(teamList, teamScore);
		outputTeamName(teamList);
		outputPlayerName(teamList, count, score);
		outputTotCount(count, teamTotCount);
		outputText(teamList, count, score);
		skipMessage(count);
	} // End method

	private void outputScore(ArrayList<ArrayList<Player>> teamList, int[][] teamScore) {
		System.out.println("+-----------------------------------+");
		System.out.println("|            1 2 3 4 5 6  | TOT     |");
		for (int teamNum = 0; teamNum < teamList.size(); teamNum++) {
			System.out.print("| ");
			System.out.print(teamList.get(teamNum).get(0).getTeamName() + " ");
			int tot = 0;
			for (int inning = 0; inning < teamScore[teamNum].length; inning++) {
				System.out.print(teamScore[teamNum][inning] + " ");
				tot += teamScore[teamNum][inning];
			} // End for
			System.out.println(" |  " + tot + "     |");
		} // End for
		System.out.println("|                                   |");
	} // End method

	private void outputTeamName(ArrayList<ArrayList<Player>> teamList) {
		System.out.print("|  ");
		System.out.print(teamList.get(0).get(0).getTeamName());
		System.out.print("           ");
		System.out.print(teamList.get(1).get(0).getTeamName());
		System.out.println("  |");
	} // End method

	private void outputPlayerName(ArrayList<ArrayList<Player>> teamList, Count count, Score score) {
		for (int playerNum = 0; playerNum < 9; playerNum++) {
			System.out.print("| ");
			for (int teamNum = 0; teamNum < 2; teamNum++) {
				System.out.print(teamList.get(teamNum).get(playerNum).getNumber());
				System.out.print(". " + teamList.get(0).get(playerNum).getName());
				if (teamNum == 0) {
					firstV(playerNum, count);
					outputCount(playerNum, score);
					lastV(playerNum, count);
				} // End if
			} // End for
			System.out.println(" |");
		} // End for
	} // End method

	private void firstV(int playerNum, Count count) {
		if (playerNum == count.getNowPlayerNum() && count.getNowTeamNum() == 0) {
			System.out.print(" V");
		} else {
			System.out.print("  ");
		} // End if
	} // End method

	private void outputCount(int playerNum, Score score) {
		if ((playerNum + 1) == 3) {
			System.out.print("  S ");
			printX(score.getStrike());
		} else if ((playerNum + 1) == 4) {
			System.out.print("  B ");
			printX(score.getBall());
		} else if ((playerNum + 1) == 5) {
			System.out.print("  O ");
			printX(score.getOut());
		} else {
			System.out.print("           ");
		} // End if
	} // End method

	private void printX(int score) {
		if (0 < score) {
			if (score == 1) {
				System.out.print("X      ");
			} else if (score == 2) {
				System.out.print("X X    ");
			} else if (score == 3) {
				System.out.print("X X X  ");
			} // End if
		} else {
			System.out.print("       ");
		} // End if
	} // End method

	private void lastV(int playerNum, Count count) {
		if (playerNum == count.getNowPlayerNum() && count.getNowTeamNum() == 1) {
			System.out.print("V ");
		} else {
			System.out.print("  ");
		} // End if
	} // End method

	private void outputTotCount(Count count, int[][] teamTotCount) {
		System.out.println("|                                   |");
		String[] word = { "투구: ", "삼진: ", "안타: " };
		for (int i = 0; i < word.length; i++) {
			System.out.print("| ");
			for (int teamNum = 0; teamNum < 2; teamNum++) {
				System.out.print(word[i] + teamTotCount[teamNum][i]);
				if (teamNum == 0) System.out.print("               ");
			} // End for
			System.out.println(" |");
		} // End for
		System.out.println("+-----------------------------------+");
	} // End method

	private void outputText(ArrayList<ArrayList<Player>> teamList, Count count, Score score) {
		String[] word = { "스트라이크!", "볼!", "안타!", "아웃!" };
		System.out.println("");
		System.out.print((count.getNowPlayerNum() + 1) + "번 타자 ");
		System.out.println(teamList.get(count.getNowTeamNum()).get(count.getNowPlayerNum()).getName() + "입니다.");
		System.out.println("");
		System.out.println(word[count.getNowBatCount()]);
		System.out.println(score.getStrike() + "S " + score.getBall() + "B " + score.getOut() + "O");
		System.out.println("");
	} // End method

	private void skipMessage(Count count) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("다음 투구 보기(enter) or 스킵하고 X회말 후 투구 보기(숫자+enter) ?");
			String inputKey = sc.nextLine();
			if (inputKey.length() == 0) {
				break;
			} else if (inputKey.length() == 1 && checkInputKey(inputKey, count)) {
				count.setSkipKey(Integer.parseInt(inputKey));
				break;
			} else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			} // End if
		} // End while
	} // End method

	private boolean checkInputKey(String inputKey, Count count) {
		char ch = inputKey.charAt(0);
		if (Character.isDigit(ch)) {
			int inputNum = Integer.parseInt(inputKey);
			if (0 < inputNum && inputNum < 7 && count.getNowInning() <= inputNum) {
				return true;
			} // End if
		} // End if
		return false;
	} // End method

} // End class
