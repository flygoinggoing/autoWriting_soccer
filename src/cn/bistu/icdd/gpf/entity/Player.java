package cn.bistu.icdd.gpf.entity;

public class Player {
	enum Position{
		GOALKEEPER("门将"),BACK("后卫"),MIDFIELD("中场"),FORWARD("前锋"),STRIKER("中锋"),BENCH("替补");
		
		private final String name;
		
		private Position(String name){
			this.name = name;
		}
		
		public String getName(){
			return name;
		}
	}
	// 主客场标志（暂时先不用）
	String team;
	
	// 号码
	int number;
	
	// 位置
	Position posi;
	
	// 球员名
	String name;
	
	// 出场是否替补
	boolean isMain;
	
	// 时间
	Double time;
	
	// 进球
	int goal;
	
	// 助攻
	int assist;
	
	// 威胁球
	int threatBall;
	
	// 射门
	int shoot;
	
	// 射正
	int shootOnTarget;
	
	// 射正率
	double targetRate;
	
	// 犯规
	int foul;
	
	// 被犯
	int beFouled;
	
	// 扑救
	int save;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Position getPosi() {
		return posi;
	}

	public void setPosi(Position posi) {
		this.posi = posi;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isMain() {
		return isMain;
	}

	public void setMain(boolean isMain) {
		this.isMain = isMain;
	}

	public Double getTime() {
		return time;
	}

	public void setTime(Double time) {
		this.time = time;
	}

	public int getGoal() {
		return goal;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}

	public int getAssist() {
		return assist;
	}

	public void setAssist(int assist) {
		this.assist = assist;
	}

	public int getThreatBall() {
		return threatBall;
	}

	public void setThreatBall(int threatBall) {
		this.threatBall = threatBall;
	}

	public int getShoot() {
		return shoot;
	}

	public void setShoot(int shoot) {
		this.shoot = shoot;
	}

	public int getShootOnTarget() {
		return shootOnTarget;
	}

	public void setShootOnTarget(int shootOnTarget) {
		this.shootOnTarget = shootOnTarget;
	}

	public double getTargetRate() {
		return targetRate;
	}

	public void setTargetRate(double targetRate) {
		this.targetRate = targetRate;
	}

	public int getFoul() {
		return foul;
	}

	public void setFoul(int foul) {
		this.foul = foul;
	}

	public int getBeFouled() {
		return beFouled;
	}

	public void setBeFouled(int beFouled) {
		this.beFouled = beFouled;
	}

	public int getSave() {
		return save;
	}

	public void setSave(int save) {
		this.save = save;
	}
	
	
	
}
