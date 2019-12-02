
public class Baseball {

	public Baseball() {
		System.out.println("신나는 야구 게임");
	} // End

	public void play() {

		int[] count = { 0, 0, 0, 0 }; // 스트라이크, 볼, 안타, 아웃

		System.out.println("첫 번째 타자가 타석에 입장했습니다.");

		while (true) {
			int randomNum = (int) (Math.random() * 4);
			count[randomNum]++;
			checkCount(count, randomNum);
			loadMessage(count, randomNum);
			if (count[3] == 3) {
				System.out.println("최종 안타 수 : " + count[2]);
				System.out.println("GAME OVER");
				break;
			} // End if
		} // End while

	} // End play

	private void loadMessage(int[] count, int randomNum) {
		switch (randomNum) {
		case 0:
			System.out.println("스트라이크!");
			break;
		case 1:
			System.out.println("볼!");
			break;
		case 2:
			System.out.println("안타! 다음 타자가 타석에 입장했습니다.");
			break;
		case 3:
			if (count[3] == 3) {
				System.out.println("아웃!");
			} else {
				System.out.println("아웃! 다음 타자가 타석에 입장했습니다.");
			} // End if
			break;
		} // End switch
		System.out.println(count[0] + "S " + count[1] + "B " + count[3] + "O");
	} // End method

	private void checkCount(int[] count, int randomNum) { // 카운트 체크
		if (randomNum == 2 || randomNum == 3) {
			count[0] = 0;
			count[1] = 0;
		} else if (count[0] == 3) { // 스트라이크가 3회 누적 = 1 아웃
			count[0] = 0;
			count[3]++;
		} else if (count[1] == 4) { // 볼 4회 누적 = 1 안타
			count[1] = 0;
			count[2]++;
		} // End if
	} // End method

} // End class
