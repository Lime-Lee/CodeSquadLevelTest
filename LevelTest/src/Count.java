
public class Count {

	private int nowBatCount; // 현재 친 타구
	private int nowInning; // 현재 회차
	private int nowTeamNum; // 현재 팀 번호 0초 1말
	private int nowPlayerNum; // 현재 타자 번호
	private int skipKey; // 스킵 회차

	public int getNowBatCount() {
		return nowBatCount;
	}

	public void setNowBatCount(int nowBatCount) {
		this.nowBatCount = nowBatCount;
	}

	public int getNowInning() {
		return nowInning;
	}

	public void setNowInning(int nowInning) {
		this.nowInning = nowInning;
	}

	public int getNowTeamNum() {
		return nowTeamNum;
	}

	public void setNowTeamNum(int nowTeamNum) {
		this.nowTeamNum = nowTeamNum;
	}

	public int getNowPlayerNum() {
		return nowPlayerNum;
	}

	public void setNowPlayerNum(int nowPlayerNum) {
		this.nowPlayerNum = nowPlayerNum;
	}

	public int getSkipKey() {
		return skipKey;
	}

	public void setSkipKey(int skipKey) {
		this.skipKey = skipKey;
	}

}
