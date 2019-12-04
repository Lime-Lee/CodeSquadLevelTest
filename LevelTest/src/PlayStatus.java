
public class PlayStatus {

	private int strike;
	private int ball;
	private int hit;
	private int out;
	private int nowCount;
	private int pitch; // 투구
	private int strikeOut; // 삼진
	private int nowInning;
	private int nowTeamNum;
	private int nowPlayerNum;

	public int getStrike() {
		return strike;
	}

	public void setStrike(int strike) {
		this.strike = strike;
	}

	public int getBall() {
		return ball;
	}

	public void setBall(int ball) {
		this.ball = ball;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getOut() {
		return out;
	}

	public void setOut(int out) {
		this.out = out;
	}

	public int getNowCount() {
		return nowCount;
	}

	public void setNowCount(int nowCount) {
		this.nowCount = nowCount;
	}

	public int getPitch() {
		return pitch;
	}

	public void setPitch(int pitch) {
		this.pitch = pitch;
	}

	public int getStrikeOut() {
		return strikeOut;
	}

	public void setStrikeOut(int strikeOut) {
		this.strikeOut = strikeOut;
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

}
