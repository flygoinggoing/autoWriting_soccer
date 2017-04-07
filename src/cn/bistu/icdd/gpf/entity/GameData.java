package cn.bistu.icdd.gpf.entity;

public class GameData {
	// 总射门数
	private int homeSumShoot;
	private int awaySumShoot;
	
	// 射正球门
	private int homeShootOnTarget;
	private int awayShootOnTarget;
	
	// 射门偏出
	private int homeOutTarget;
	private int awayOutTarget;
	
	// 击中门框
	private int homeShootDoor;
	private int awayShootDoor;
	
	// 直塞球
	private int homeThroughPass;
	private int awayThroughPass;
	
	// 越位 
	private int homeOffset;
	private int awayOffset;
	
	// 抢断
	private int homeSteal;
	private int awaySteal;
	
	// 任意球
	private int homeFreeKick;
	private int awayFreeKick;
	
	// 犯规
	private int homeFoul;
	private int awayFoul;
	
	// 角球
	private int homeCornerkick;
	private int awayCornerKick;
	
	// 界外球
	private int homeOutOfBound;
	private int awayOutOfBound;
	
	// 超过25码传球
	private int homeExceed25;
	private int awayExceed25;
	
	// 传球成功率
	private double homeSuccessPass;
	private double awaySuccessPass;
	
	// 传中成功率
	private double homeSuccessCross;
	private double awaySuccessCross;
	
	// 抢断成功率
	private double homeSuccessSteal;
	private double awaySuccessSteal;
	
	// 头球成功率
	private double homeSuccessHead;
	private double awaySuccessHead;
	
	// 控球率
	private double homeControl;
	private double awayControl;
	public int getHomeSumShoot() {
		return homeSumShoot;
	}
	public void setHomeSumShoot(int homeSumShoot) {
		this.homeSumShoot = homeSumShoot;
	}
	public int getAwaySumShoot() {
		return awaySumShoot;
	}
	public void setAwaySumShoot(int awaySumShoot) {
		this.awaySumShoot = awaySumShoot;
	}
	public int getHomeShootOnTarget() {
		return homeShootOnTarget;
	}
	public void setHomeShootOnTarget(int homeShootOnTarget) {
		this.homeShootOnTarget = homeShootOnTarget;
	}
	public int getAwayShootOnTarget() {
		return awayShootOnTarget;
	}
	public void setAwayShootOnTarget(int awayShootOnTarget) {
		this.awayShootOnTarget = awayShootOnTarget;
	}
	public int getHomeOutTarget() {
		return homeOutTarget;
	}
	public void setHomeOutTarget(int homeOutTarget) {
		this.homeOutTarget = homeOutTarget;
	}
	public int getAwayOutTarget() {
		return awayOutTarget;
	}
	public void setAwayOutTarget(int awayOutTarget) {
		this.awayOutTarget = awayOutTarget;
	}
	public int getHomeShootDoor() {
		return homeShootDoor;
	}
	public void setHomeShootDoor(int homeShootDoor) {
		this.homeShootDoor = homeShootDoor;
	}
	public int getAwayShootDoor() {
		return awayShootDoor;
	}
	public void setAwayShootDoor(int awayShootDoor) {
		this.awayShootDoor = awayShootDoor;
	}
	public int getHomeThroughPass() {
		return homeThroughPass;
	}
	public void setHomeThroughPass(int homeThroughPass) {
		this.homeThroughPass = homeThroughPass;
	}
	public int getAwayThroughPass() {
		return awayThroughPass;
	}
	public void setAwayThroughPass(int awayThroughPass) {
		this.awayThroughPass = awayThroughPass;
	}
	public int getHomeOffset() {
		return homeOffset;
	}
	public void setHomeOffset(int homeOffset) {
		this.homeOffset = homeOffset;
	}
	public int getAwayOffset() {
		return awayOffset;
	}
	public void setAwayOffset(int awayOffset) {
		this.awayOffset = awayOffset;
	}
	public int getHomeSteal() {
		return homeSteal;
	}
	public void setHomeSteal(int homeSteal) {
		this.homeSteal = homeSteal;
	}
	public int getAwaySteal() {
		return awaySteal;
	}
	public void setAwaySteal(int awaySteal) {
		this.awaySteal = awaySteal;
	}
	public int getHomeFreeKick() {
		return homeFreeKick;
	}
	public void setHomeFreeKick(int homeFreeKick) {
		this.homeFreeKick = homeFreeKick;
	}
	public int getAwayFreeKick() {
		return awayFreeKick;
	}
	public void setAwayFreeKick(int awayFreeKick) {
		this.awayFreeKick = awayFreeKick;
	}
	public int getHomeFoul() {
		return homeFoul;
	}
	public void setHomeFoul(int homeFoul) {
		this.homeFoul = homeFoul;
	}
	public int getAwayFoul() {
		return awayFoul;
	}
	public void setAwayFoul(int awayFoul) {
		this.awayFoul = awayFoul;
	}
	public int getHomeCornerkick() {
		return homeCornerkick;
	}
	public void setHomeCornerkick(int homeCornerkick) {
		this.homeCornerkick = homeCornerkick;
	}
	public int getAwayCornerKick() {
		return awayCornerKick;
	}
	public void setAwayCornerKick(int awayCornerKick) {
		this.awayCornerKick = awayCornerKick;
	}
	public int getHomeOutOfBound() {
		return homeOutOfBound;
	}
	public void setHomeOutOfBound(int homeOutOfBound) {
		this.homeOutOfBound = homeOutOfBound;
	}
	public int getAwayOutOfBound() {
		return awayOutOfBound;
	}
	public void setAwayOutOfBound(int awayOutOfBound) {
		this.awayOutOfBound = awayOutOfBound;
	}
	public int getHomeExceed25() {
		return homeExceed25;
	}
	public void setHomeExceed25(int homeExceed25) {
		this.homeExceed25 = homeExceed25;
	}
	public int getAwayExceed25() {
		return awayExceed25;
	}
	public void setAwayExceed25(int awayExceed25) {
		this.awayExceed25 = awayExceed25;
	}
	public double getHomeSuccessPass() {
		return homeSuccessPass;
	}
	public void setHomeSuccessPass(double homeSuccessPass) {
		this.homeSuccessPass = homeSuccessPass;
	}
	public double getAwaySuccessPass() {
		return awaySuccessPass;
	}
	public void setAwaySuccessPass(double awaySuccessPass) {
		this.awaySuccessPass = awaySuccessPass;
	}
	public double getHomeSuccessCross() {
		return homeSuccessCross;
	}
	public void setHomeSuccessCross(double homeSuccessCross) {
		this.homeSuccessCross = homeSuccessCross;
	}
	public double getAwaySuccessCross() {
		return awaySuccessCross;
	}
	public void setAwaySuccessCross(double awaySuccessCross) {
		this.awaySuccessCross = awaySuccessCross;
	}
	public double getHomeSuccessSteal() {
		return homeSuccessSteal;
	}
	public void setHomeSuccessSteal(double homeSuccessSteal) {
		this.homeSuccessSteal = homeSuccessSteal;
	}
	public double getAwaySuccessSteal() {
		return awaySuccessSteal;
	}
	public void setAwaySuccessSteal(double awaySuccessSteal) {
		this.awaySuccessSteal = awaySuccessSteal;
	}
	public double getHomeSuccessHead() {
		return homeSuccessHead;
	}
	public void setHomeSuccessHead(double homeSuccessHead) {
		this.homeSuccessHead = homeSuccessHead;
	}
	public double getAwaySuccessHead() {
		return awaySuccessHead;
	}
	public void setAwaySuccessHead(double awaySuccessHead) {
		this.awaySuccessHead = awaySuccessHead;
	}
	public double getHomeControl() {
		return homeControl;
	}
	public void setHomeControl(double homeControl) {
		this.homeControl = homeControl;
	}
	public double getAwayControl() {
		return awayControl;
	}
	public void setAwayControl(double awayControl) {
		this.awayControl = awayControl;
	}
	
	
}
