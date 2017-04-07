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
	
}
