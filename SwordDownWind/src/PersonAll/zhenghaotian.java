package PersonAll;

import java.util.HashMap;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Skill.SkillAll;
import Skill.ziqidonglai;

public class zhenghaotian implements PersonAll{
	private static int HP;
	private static int MP;
	private static int baseAttack;
	private static int adderAttack;
	private static String name;
	private static int priority;
	private static Vector<SkillAll> prosseSkill;//���м���
	public zhenghaotian(){
		prosseSkill = new Vector<>();
		HP = 5000;
		MP = 5000;
		baseAttack = 300;
		name = "֣����";
		priority = 500;
		ziqidonglai zqdl = new ziqidonglai();
		prosseSkill.add(zqdl);
	}
	
	public int getHP() {
		return HP;
	}
	
	public int getMP(){
		return MP;
	}

	@Override
	public void subHP(int paraHP) {
		// TODO Auto-generated method stub
		HP -= paraHP;
	}

	@Override
	public void subMP(int paraMP) {
		// TODO Auto-generated method stub
		MP -= paraMP;
	}

	@Override
	public void adderAttack(int paraAdderAttack) {
		// TODO Auto-generated method stub
		adderAttack = baseAttack + paraAdderAttack;
	}

	@Override
	public int getAdderAttack() {
		// TODO Auto-generated method stub
		return adderAttack;
	}

	@Override
	public void addHP(int paraHP) {
		// TODO Auto-generated method stub
		HP += paraHP;
	}

	@Override
	public void addMP(int paraMP) {
		// TODO Auto-generated method stub
		MP += paraMP;
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
		ImageIcon icon = new ImageIcon("src/imageSource/֣��������.jpeg");
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
	public int probablity() {//ʩչ���ܵĸ��ʣ���������ڶ��ι������ٷ�֮��ʹ�øü���
		return -1;
	}
	public Vector<SkillAll> getSkillAll() {
		return prosseSkill;
	}
}