package cn.bistu.icdd.gpf.entity;

import java.util.Arrays;

public class LiveTerm {

	// 直播文本
	String line;
	
	// 时间  -2：未赛 -1：中场  0：完赛    其他时间按1，2.....
	int time;    
	
	// 比分 0:主队  1：客队
	int[] score = new int[2];

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int[] getScore() {
		return score;
	}

	public void setScore(int[] score) {
		this.score = score;
	}  
	
	@Override
	public String toString() {
		return line + " " + time + "" + Arrays.toString(score) + "\n";
	}
	
}
