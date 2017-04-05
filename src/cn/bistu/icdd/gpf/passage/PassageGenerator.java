package cn.bistu.icdd.gpf.passage;

/**
 * 文章生成类
 * 思想：
 * 1.将提供的信息读入内存（四个文本）
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

}
