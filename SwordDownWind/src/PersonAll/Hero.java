package PersonAll;
import java.awt.event.MouseWheelEvent;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Medicament.medicament;
import Skill.SkillAll;
import Weapon.Weapon;

public class Hero implements PersonAll{
	private static int limitedHP;
	private static int limitedMP;
	private static int nowHP;
	private static int nowMP;
	private static int Level;//���������㷨����̸��
	private static int priority;
	private static int ex;//����
	private static int baseAttack; //���������������ţ��ȼ������Ӷ��ı䡣
	private static int adderAttack;
	private static String name;
	private static HashMap<String, Weapon> prosseWeapon;
	private static HashMap<String, medicament> prosseMedicament;
	private static Vector<SkillAll> prosseSkill;//Ϊ�ﵽ����ѡ��vector
	
	public Hero() {
		// TODO Auto-generated constructor stub
		name = "�ྪ��";
		prosseSkill = new Vector<>();
	}
	public void setlimitedHP(int paraHP) {
		limitedHP = paraHP;						//���ݵȼ��㷨������Ѫ������
	}
	public int getlimitedHP(){
		return limitedHP;
	}
	public void setlimitedMP(int paraMP){
		limitedMP = paraMP;
	}
	public int getlimitedMP() {
		return limitedMP;
	}
	public int getnowHP() {						//��ǰѪ��������set����������add��sub���е���
		return nowHP;
	}
	public int getnowMP() {
		return nowMP;
	}
	public void subHP(int paraHP) {
		if(nowHP - paraHP < 0){
			nowHP = 0;
		}
		else{
			nowHP -= paraHP;	
		}
	}
	public void subMP(int paraMP) {
		if(nowMP - paraMP < 0){
			nowMP = 0;
		}
		else{
			nowMP -= paraMP;	
		}
	}
	public void addHP(int paraHP) {				//����ļ�Ѫ����ʵ�֡�
		int temp = paraHP + nowHP;
		if(temp > limitedHP){
			nowHP = limitedHP;
		}
		else{
			nowHP = temp;
		}
			
	}
	public void addMP(int paraMP) {
		int temp = paraMP + nowMP;
		if(temp > limitedMP){
			nowMP = limitedMP;
		}
		else{
			nowMP = temp;
		}
	}
	public void setBaseAttack(int paraBaseAttack){
		baseAttack = paraBaseAttack;
	}
	public int getBaseAttack() {
		return baseAttack;
	}
	public void adderAttack(int paraAdderAttack) {		//ͨ������������ʹ�ü��ܣ��Ի������������мӳ�
		adderAttack = baseAttack + paraAdderAttack;
	}
	public int getAdderAttack() {
		return adderAttack;
	}
	public void addWeapon(String name,Weapon wp){
		prosseWeapon.put(name, wp);
	}
	public void throwWeapon(String name) {
		prosseWeapon.remove(name);
	}
	public void addMedicament(String name,medicament md) {
		prosseMedicament.put(name, md);
	}
	public void throwMedicament(String name) {
		prosseMedicament.remove(name);
	}
	public void addSkill(SkillAll skill) {//ϰ�ü���
		prosseSkill.add(skill);
	}
	public void throwSkill(String name) {
		prosseSkill.remove(name);
	}
	public String getname() {
		return name;
	}
	public JLabel getHeadPhoto() {
		ImageIcon icon = new ImageIcon("src/imageSource/�ྪ��.jpeg");
		JLabel jl_head = new JLabel(icon);
		return jl_head;
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