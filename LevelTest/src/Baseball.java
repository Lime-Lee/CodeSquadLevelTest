
public class Baseball {

	public Baseball() {
		System.out.println("�ų��� �߱� ����");
	} // End

	public void play() {

		int[] count = { 0, 0, 0, 0 }; // ��Ʈ����ũ, ��, ��Ÿ, �ƿ�

		System.out.println("ù ��° Ÿ�ڰ� Ÿ���� �����߽��ϴ�.");

		while (true) {
			int randomNum = (int) (Math.random() * 4);
			count[randomNum]++;
			checkCount(count, randomNum);
			loadMessage(count, randomNum);
			if (count[3] == 3) {
				System.out.println("���� ��Ÿ �� : " + count[2]);
				System.out.println("GAME OVER");
				break;
			} // End if
		} // End while

	} // End play

	private void loadMessage(int[] count, int randomNum) {
		switch (randomNum) {
		case 0:
			System.out.println("��Ʈ����ũ!");
			break;
		case 1:
			System.out.println("��!");
			break;
		case 2:
			System.out.println("��Ÿ! ���� Ÿ�ڰ� Ÿ���� �����߽��ϴ�.");
			break;
		case 3:
			if (count[3] == 3) {
				System.out.println("�ƿ�!");
			} else {
				System.out.println("�ƿ�! ���� Ÿ�ڰ� Ÿ���� �����߽��ϴ�.");
			} // End if
			break;
		} // End switch
		System.out.println(count[0] + "S " + count[1] + "B " + count[3] + "O");
	} // End method

	private void checkCount(int[] count, int randomNum) { // ī��Ʈ üũ
		if (randomNum == 2 || randomNum == 3) {
			count[0] = 0;
			count[1] = 0;
		} else if (count[0] == 3) { // ��Ʈ����ũ�� 3ȸ ���� = 1 �ƿ�
			count[0] = 0;
			count[3]++;
		} else if (count[1] == 4) { // �� 4ȸ ���� = 1 ��Ÿ
			count[1] = 0;
			count[2]++;
		} // End if
	} // End method

} // End class
