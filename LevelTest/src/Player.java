
public class Player {

	private String teamName;
	private int number;
	private String name;
	private double battingAverage;

	public Player() {
	}

	public Player(String teamName, int number, String name, double battingAverage) {
		this.teamName = teamName;
		this.number = number;
		this.name = name;
		this.battingAverage = battingAverage;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBattingAverage() {
		return battingAverage;
	}

	public void setBattingAverage(double battingAverage) {
		this.battingAverage = battingAverage;
	}

	@Override
	public String toString() {
		return number + "번 " + name + ", " + battingAverage;
	}

}
