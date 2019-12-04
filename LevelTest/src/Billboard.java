import java.util.ArrayList;

public class Billboard {

	
//	+------------------------------------+
//	|            1 2 3 4 5 6  | TOT      | 
//	| Mouse      0 0 1 1 0 0  |  2       | 
//	| Cats       0 0 2 0 0 0  |  2       |
//	|                                    |
//	|  Mouse                      Cats   |
//	| 1. 윤지수               1. 김고양  |
//	| 2. 김정정               2. 이고양  |
//	| 3. 정호영     S X       3. 박고양  |
//	| 4. 나두성     B X X X   4.   ...   |
//	| 5. 김두정     O X X                |
//	| 5. 김세정                    ...   |
//	| 6. 김네정 V                        |
//	| 7. 김오정                    ...   |
//	| 8. 김육정                          |
//	| 9. 김칠정                    ...   |
//	|                                    |
//	| 투구: 31                     ...   |
//	| 삼진: 2                            |
//	| 안타: 8                            |
//	+------------------------------------+
	
	
	public void output(ArrayList<ArrayList<Player>> teamList, PlayStatus status, int[][] teamScore) {
		outputScore(teamList, teamScore);
		outputTeamName(teamList);
		// outputPlayerName(teamList);
	} // End method

	private void outputScore(ArrayList<ArrayList<Player>> teamList, int[][] teamScore) {
		System.out.println("+--------------------------------+");
		System.out.println("|        1 2 3 4 5 6  | TOT      |");
		for (int teamNum = 0; teamNum < teamList.size(); teamNum++) {
			System.out.print("| ");
			System.out.print(teamList.get(teamNum).get(0).getTeamName() + " ");
			int tot = 0;
			for (int inning = 0; inning < teamScore[teamNum].length; inning++) {
				System.out.print(teamScore[teamNum][inning] + " ");
				tot += teamScore[teamNum][inning];
			} // End for
			System.out.println(" |  " + tot + "      |");
		} // End for
		System.out.println("|                                |");
	} // End method

	private void outputTeamName(ArrayList<ArrayList<Player>> teamList) {
		System.out.print("|  ");
		System.out.print(teamList.get(0).get(0).getTeamName());
		System.out.print("                  ");
		System.out.print(teamList.get(1).get(0).getTeamName());
		System.out.println("  |");
	} // End method
	
	
	
	// 초기 빌보드는 1회로 기본값이 세팅 => 출력 기본값
	// => if 그냥 엔터 -> ++ 해서 다음 회차
	// => if 숫자 엔터 -> 그 회로 스킵 후 출력

//	System.out.println(
//	teamList.get(0).get(0).getTeamName() + " VS " + teamList.get(1).get(0).getTeamName() + "의 시합을 시작합니다.");
//String[] turn = { "초", "말" };
//int[][] teamPlayStatus = { { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 } }; // 1팀, 2팀
//	System.out.println(
//			inning + "회" + turn[turnNum] + " " + teamList.get(turnNum).get(0).getTeamName() + "의 공격");
//	teamPlayStatus[teamNum][inning] += hitPoint;
//System.out.println("경기 종료");
//System.out.println(teamList.get(0).get(0).getTeamName() + " VS " + teamList.get(1).get(0).getTeamName());
//System.out.println(teamPlayStatus[0] + " : " + teamPlayStatus[1]);
//System.out.println("Thank you!");
//billboard.output(teamPlayStatus);

//	private void outputPlayStatus(ArrayList<ArrayList<Player>> teamList, PlayStatus PlayStatus) {
//		System.out.println("+------------------------------------+");
//		System.out.println("|            1 2 3 4 5 6  | TOT      |");
//		System.out.println("| " + teamList.get(0).get(0).getTeamName() + " 0 0 1 1 0 0  |  2       |");
//		System.out.println("|                                    |");
//	} // End method
//
//	public void outputTeamPlayStatus() {
//		System.out.println("|  Mouse                      Cats   |");
//		System.out.println("| 1. 윤지수               1. 김고양  |");
//		System.out.println();
//	} // End method

} // End class
