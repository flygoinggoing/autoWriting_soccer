package cn.bistu.icdd.gpf.entity;

public class LiveTerm {

	// 直播文本
	String line;
	
	// 时间  -2：赛前 -1：中场  0：完赛    其他时间按1，2.....
	int time;    
	
	// 比分 0:主队  1：客队
	int[] score = new int[2];  
}
