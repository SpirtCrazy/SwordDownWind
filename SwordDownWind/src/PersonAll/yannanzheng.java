package PersonAll;

import java.util.HashMap;
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
	private static int priority;//���ȶȣ�����˭�ȳ���
	private static Vector<SkillAll> prosseSkill;
	public yannanzheng(){
		baseAttack = 30;
		HP = 500;
		MP = 500;
		name = "������";
		priority = 30;
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
		ImageIcon icon = new ImageIcon("src/imageSource/����������.png");
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
		return prosseSkill;
	}
	@Override
	public int probablity() {
		// TODO Auto-generated method stub
		return 0;
	}
}