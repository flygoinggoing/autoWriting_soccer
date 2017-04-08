package cn.bistu.icdd.gpf.passage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import cn.bistu.icdd.gpf.entity.GameData;
import cn.bistu.icdd.gpf.entity.LiveTerm;
import cn.bistu.icdd.gpf.entity.Player;
import cn.bistu.icdd.gpf.paragraph.FirstParagraphGenerator;
import cn.bistu.icdd.gpf.paragraph.LastParagraphGenerator;
import cn.bistu.icdd.gpf.paragraph.SecondParagraphGenerator;
import cn.bistu.icdd.gpf.paragraph.ThirdParagraphGenerator;

/**
 * 文章生成类
 * 思想：
 * 1.将提供的信息读入内存（四个文本），存储格式 ：list
 * 2.把不同文本分发到各个段落生成器中
 * 		①将除直播文本外的其他文本按需分配
 * 		②将直播文本根据 未赛 上半场 中场 下半场 完赛 分为五部分
 * 
 * 	未赛 中场 完赛 ——》FirstParagraphGenerator.java
 * 	未赛 ——》SecondParagraphGenerator.java
 * 	上半场 下半场——》 ThirdParagraphGenerator.java
 * 	away.csv home.csv——》LastParagraphGenerator.java
 * 
 * @author 关鹏飞
 *
 */
public class PassageGenerator {
	// 存直播文本用
	List<LiveTerm> live = new ArrayList<LiveTerm>();
	
	// 存主队用
	List<Player> home = new ArrayList<Player>();
	
	// 存客队用
	List<Player> away = new ArrayList<Player>();
	
	// 存数据用
	GameData data = new GameData();
	
	static int halfTime ; // 记录上半场结束时间
	
	String printPath;  // 文本生成路径
	
	/**
	 * 构造函数
	 * @param path 新闻文本路径
	 * @param printPath 结果输出路径
	 */
	public PassageGenerator(String path, String printPath){
		init(path);
		this.printPath = printPath;
		
		// 创建输出文件
		File printFile = new File(printPath); 
		if (!printFile.exists()) {
			File parent = printFile.getParentFile();
			if (!parent.exists()) {
				parent.mkdirs();
			}
			try {
				printFile.createNewFile();
			} catch (IOException e) {
				System.out.println("创建文件失败");
				e.printStackTrace();
			}
		}
	}

	/**
	 * 将文本读出初始化信息
	 */
	private void init(String rootPath) {
		initLive(rootPath+"/"+"live.csv");
		initTeam(rootPath+"/"+"home.csv", home); // 主队
		initTeam(rootPath+"/"+"away.csv", away); // 客队
		initData(rootPath+"/"+"tec.csv");
		
		//System.out.println(live);
		//System.out.println(home);
		//System.out.println(away);
		//System.out.println(data);
	}
	
	/**
	 * 文章生成的主函数
	 */
	public void autoWriting(){
		BufferedWriter bw = null;
		String  paragraph;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(printPath,true), "utf-8"));
			/********资源分发**********/
			// 考虑是否需要将文本分解为不同的list，只传需要的部分
			// 生成第一段
			FirstParagraphGenerator fpg = new FirstParagraphGenerator(live);
			paragraph = fpg.generator();
			bw.write(paragraph);
			bw.newLine();
			
			// 生成第二段
			SecondParagraphGenerator spg = new SecondParagraphGenerator(live);
			paragraph = spg.generator();
			bw.write(paragraph);
			bw.newLine();
			
			// 生成第三段
			ThirdParagraphGenerator tpg = new ThirdParagraphGenerator(live);
			paragraph = tpg.generator();
			bw.write(paragraph);
			bw.newLine();
			
			// 生成第四段
			LastParagraphGenerator lpg = new LastParagraphGenerator(home, away);
			paragraph = lpg.generator();
			bw.write(paragraph);
			bw.newLine();
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("未找到写出文件");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
					bw = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 初始化直播文本
	 */
	private void initLive(String path){
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(path),"utf-8"));
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] strs = line.split(",");
				
				LiveTerm lt = new LiveTerm();
				// 文本
				lt.setLine(strs[0]);
				
				// 时间
				switch (strs[1]) {
				case "未赛":
					lt.setTime(-2);
					break;
				case "中场":
					lt.setTime(-1);
					break;
				case "完赛":
					lt.setTime(0);
					break;
				default:
					/*
					 *  判断上下半场用   halfTime记录上半场时间,同时记录上半场的结束时间
					 *  上半场 19'
					 *  下半场 9'
					 */
					if (strs[1].contains("上半场")) {
						// System.out.println(strs[1].substring(4, strs[1].indexOf("'")));
						halfTime = Integer.parseInt(strs[1].substring(4, strs[1].indexOf("'")));
						lt.setTime(halfTime);
					} else if (strs[1].contains("下半场")) {
						int secondHalfTime = halfTime + Integer.parseInt(strs[1].substring(4, strs[1].indexOf("'")));
						lt.setTime(secondHalfTime);
					}
				
				}
				
				// 比分
				String[] scoreStr = strs[2].split("-");
				int[] score = {Integer.parseInt(scoreStr[0]),Integer.parseInt(scoreStr[1])};
				lt.setScore(score);
				
				live.add(lt);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("未找到文件，加载直播文本失败");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
					br = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 初始化队伍信息
	 */
	private void initTeam(String path, List<Player> team){
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(path),"utf-8"));
			String line = null;
			boolean flag = true; // 是否是第一行
			// 丢弃第一行（表头）
			while ((line = br.readLine()) != null) {
				if (flag) {
					flag = false;
				} else {
					Player player = new Player();
					String[] strs = line.split(",");
					// 初始化球员信息
					player.setNumber(Integer.parseInt(strs[0]));
					player.setPosi(strs[1]);
					player.setName(strs[2]);
					if ("首发".equals(strs[3])) {
						player.setMain(true);
					} else if ("替补".equals(strs[3])) {
						player.setMain(false);
					}
					player.setTime(Integer.parseInt(strs[4].substring(0, strs[4].indexOf("’"))));
					player.setGoal(Integer.parseInt(strs[5]));
					player.setAssist(Integer.parseInt(strs[6]));
					player.setThreatBall(Integer.parseInt(strs[7]));
					player.setShoot(Integer.parseInt(strs[8]));
					player.setShootOnTarget(Integer.parseInt(strs[9]));
					String str = strs[10];
					if (str.contains("%")) {
						player.setTargetRate(Double.parseDouble(str.substring(0, str.length()-1)));
					} else {
						player.setTargetRate(0);
					}
					player.setFoul(Integer.parseInt(strs[11]));
					player.setBeFouled(Integer.parseInt(strs[12]));
					player.setSave(Integer.parseInt(strs[13]));
					
					team.add(player);
				}
				
				
			}
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("未找到文件，加载队伍信息失败");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
					br = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 初始化比赛数据
	 */
	private void initData(String path){
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(path),"utf-8"));
			String line = null;
			while ((line  = br.readLine()) != null) {
				
				String[] strs = line.split(",");
				// 导入比赛数据
				switch (strs[1]) {
				case "总射门":
					data.setHomeSumShoot(Integer.parseInt(strs[0]));
					data.setAwaySumShoot(Integer.parseInt(strs[2]));
					break;
				case "射正球门":
					data.setHomeShootOnTarget(Integer.parseInt(strs[0]));
					data.setAwayShootOnTarget(Integer.parseInt(strs[2]));
					break;
				case "射门偏出":
					data.setHomeOutTarget(Integer.parseInt(strs[0]));
					data.setAwayOutTarget(Integer.parseInt(strs[2]));
					break;
				case "击中门框":
					data.setHomeShootDoor(Integer.parseInt(strs[0]));
					data.setAwayShootDoor(Integer.parseInt(strs[2]));
					break;
				case "直塞球":
					data.setHomeThroughPass(Integer.parseInt(strs[0]));
					data.setAwayThroughPass(Integer.parseInt(strs[2]));
					break;
				case "越位":
					data.setHomeOffset(Integer.parseInt(strs[0]));
					data.setAwayOffset(Integer.parseInt(strs[2]));
					break;
				case "抢断":
					data.setHomeSteal(Integer.parseInt(strs[0]));
					data.setAwaySteal(Integer.parseInt(strs[2]));
					break;
				case "任意球":
					data.setHomeFreeKick(Integer.parseInt(strs[0]));
					data.setAwayFreeKick(Integer.parseInt(strs[2]));
					break;
				case "犯规":
					data.setHomeFoul(Integer.parseInt(strs[0]));
					data.setAwayFoul(Integer.parseInt(strs[2]));
					break;
				case "角球":
					data.setHomeCornerkick(Integer.parseInt(strs[0]));
					data.setAwayCornerKick(Integer.parseInt(strs[2]));
					break;
				case "界外球":
					data.setHomeOutOfBound(Integer.parseInt(strs[0]));
					data.setAwayOutOfBound(Integer.parseInt(strs[2]));
					break;
				case "超过25码长传":
					data.setHomeExceed25(Integer.parseInt(strs[0]));
					data.setAwayExceed25(Integer.parseInt(strs[2]));
					break;
				case "传球成功率":
					data.setHomeSuccessPass(Double.parseDouble(strs[0].substring(0, strs[0].indexOf("%"))));
					data.setAwaySuccessPass(Double.parseDouble(strs[2].substring(0, strs[2].indexOf("%"))));
					break;
				case "传中成功率":
					data.setHomeSuccessCross(Double.parseDouble(strs[0].substring(0, strs[0].indexOf("%"))));
					data.setAwaySuccessCross(Double.parseDouble(strs[2].substring(0, strs[2].indexOf("%"))));
					break;
				case "抢断成功率":
					data.setHomeSuccessSteal(Double.parseDouble(strs[0].substring(0, strs[0].indexOf("%"))));
					data.setAwaySuccessSteal(Double.parseDouble(strs[2].substring(0, strs[2].indexOf("%"))));
					break;
				case "头球成功率":
					data.setHomeSuccessHead(Double.parseDouble(strs[0].substring(0, strs[0].indexOf("%"))));
					data.setAwaySuccessHead(Double.parseDouble(strs[2].substring(0, strs[2].indexOf("%"))));
					break;
				case "控球率":
					data.setHomeControl(Double.parseDouble(strs[0].substring(0, strs[0].indexOf("%"))));
					data.setAwayControl(Double.parseDouble(strs[2].substring(0, strs[2].indexOf("%"))));
					break;
				default:
					// 丢弃第一行（表头）
					break;
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("未找到文件，加载比赛数据失败");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
					br = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
