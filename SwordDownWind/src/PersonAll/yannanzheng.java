package PersonAll;

import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Skill.SkillAll;

public class yannanzheng implements PersonAll{
	private static int HP;
	private static int MP;
	private static int baseAttack;
	private static int adderAttack;
	private static String name;
	private static int priority;//优先度，决定谁先出手
	public yannanzheng(){
		baseAttack = 30;
		HP = 500;
		MP = 500;
		name = "燕南征";
		priority = 10;
	}
	public void  subHP(int paraHP) {
		if(HP - paraHP < 0){
			HP = 0;
		}
		else{
			HP -= paraHP;
		}
	}
	public void subMP(int paraMP){
		MP -= paraMP;
	}
	
	public int DamageValue(){
		return baseAttack;
	}
	public void addHP(int paraHP){
		return;
	}
	public void addMP(int paraMP){
		return;
	}
	@Override
	public void adderAttack(int paraAdderAttack) {
		// TODO Auto-generated method stub
		adderAttack = baseAttack + paraAdderAttack;
	}
	public int getAdderAttack(){
		return adderAttack;
	}
	public String getname() {
		return name;
	}
	public int getnowHP() {
		return HP;
	}
	public int getnowMP(){
		return MP;
	}

	public JLabel getHeadPhoto() {
		ImageIcon icon = new ImageIcon("src/imageSource/燕南征人物.png");
		JLabel jl_head = new JLabel(icon);
		return jl_head;
	}
	@Override
	public int getBaseAttack() {
		// TODO Auto-generated method stub
		return baseAttack;
	}
	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return priority;
	}
	@Override
	public Vector<SkillAll> getSkillAll() {
		// TODO Auto-generated method stub
		return null;//燕南征并不存在技能
	}
	@Override
	public int probablity() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getLevel() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getEX() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void addEX(int paraEX) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getUpEx() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setUpEx(int paraEx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setLevel(int paraLevel) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setEx(int paraEx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setPriority(int para) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setNowHP(int paraHP) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setNowMP(int paraMP) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void SkillPointPlus() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void SkillPointSub() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getSkillPoint() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getMoney() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void addMoney(int paraMoney) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void subMoney(int paraMoney) {
		// TODO Auto-generated method stub
		
	}
}
