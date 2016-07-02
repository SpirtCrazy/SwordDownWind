/*����BOSSר��ս������*/
package warFrame;
import basePackage.*;
import dialogPackage.fightDialog;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

import org.omg.CORBA.INTERNAL;

import PersonAll.PersonAll;
import PersonAll.zhenghaotian;

public class fightScence_1 extends JFrame{
	private fightDialog fd;
	private threadChange tc;
	private String blanck = "                        ";
	private int fightHead_x_player = 0;
	private int fightHead_x_boss = LenthAll.WINDOW_WIDTH - 200;
	private int fightHead_y = 0;
	private int fightHead_image_width = 200;
	private int fightHead_image_height = 190;
	private int WIDTH = 80;//��ϢLabel�Ŀ���
	private int HEIGHT = 20;//��ϢLabel�ĸ߶�
    JLabel jl_name = new JLabel();
    JLabel jl_HP = new JLabel();
    JLabel jl_MP = new JLabel();
    JLabel jl_attack = new JLabel();
    
    JLabel jl_name_boss = new JLabel();
    JLabel jl_HP_boss = new JLabel();
    JLabel jl_MP_boss = new JLabel();
    JLabel jl_attack_boss = new JLabel();
    
    JPanel jp;
	public fightScence_1(PersonAll player,PersonAll boss) {
		// TODO Auto-generated constructor stub
		tc = new threadChange(1000);
		setTitle("ս��");  
        Toolkit tool = getToolkit();  
        Dimension dim = tool.getScreenSize();  
        setBounds(0, 0, LenthAll.WINDOW_WIDTH, LenthAll.WINDOW_HEIGHT); 
        this.setLocation((int)(dim.getWidth() - LenthAll.WINDOW_WIDTH) / 2,(int)(dim.getHeight() - LenthAll.WINDOW_HEIGHT) / 2);//���õ�ǰ��������Ļ��������
        this.addWindowListener(new WindowAdapter() {
        	public void windowClosing(WindowEvent event) {
				System.exit(0);
        	}
        });//���ùرճ������
        jp = (JPanel) getContentPane();
        jp.setLayout(null);
        this.setResizable(false);
        //--------------------------------------------------------------------------
        JLabel jl_player_head = player.getHeadPhoto();
        jl_player_head.setBounds(fightHead_x_player, fightHead_y, fightHead_image_width, fightHead_image_height);
        jp.add(jl_player_head);
        JLabel jl_boss_head = boss.getHeadPhoto();
        jl_boss_head = boss.getHeadPhoto();
        jl_boss_head.setBounds(fightHead_x_boss, fightHead_y, fightHead_image_width, fightHead_image_height);
        jp.add(jl_boss_head);
        /*��ȡս�� ��ɫ��ͷ����Ϣ*/
        setInfo(player, boss);
        setInfoLocation();//��ȡ��ɫ��boss��Ϣ����λ��
        
        setVisible(true);
        fd = new fightDialog(player,boss);
        fd.setVisible(false);
        int playerFlag = 1;//�غ��Ƴ���
		int bossFlag = 1;//
		int bossRealAttack = boss.getBaseAttack() + (int)(Math.random()*boss.getBaseAttack()*0.1);//boss�����˺�����
		int playerRealAttack = player.getBaseAttack() + (int)(Math.random()*player.getBaseAttack()*0.1);//��һ����˺�����
		int index =  ((int)(Math.random()*100) % boss.getSkillAll().size());
		int bossSkillAttack = boss.getBaseAttack() + (int)(Math.random()*boss.getBaseAttack()*0.1) + boss.getSkillAll().get(index).DamageValue();
		if(player.getnowHP() > 0 && boss.getnowHP() > 0){
			if(player.getPriority() > boss.getPriority()){
				playerFlag = 0;
				fd.setVisible(true);
			}
			else{
				bossFlag = 0;
				player.subHP(bossRealAttack);
				MyDialog.showMessageDialog(blanck + boss.getname() + "��"+ player.getname() + "�����" + bossRealAttack + "���˺�", "ս����Ϣ", LenthAll.TALK_DIALOG_WIDTH, LenthAll.TALK_DIALOG_HEIGHT);
			}
		}
		while(player.getnowHP() > 0 && boss.getnowHP() > 0){
			setInfo(player, boss);
			jp.updateUI();
			if(!fd.isVisible()){//����ʾ��ʱ������������
				if(playerFlag == 0 && bossFlag == 1){//boss����
					if(Math.random() > boss.probablity()){//ʹ�ü���
						player.subHP(bossSkillAttack);
						MyDialog.showMessageDialog(blanck + boss.getname() + "ʹ����" + boss.getSkillAll().get(index).getSkillname() + "��" + player.getname() + "�����" + bossSkillAttack, "ս��", LenthAll.TALK_DIALOG_WIDTH, LenthAll.TALK_DIALOG_HEIGHT);
						playerFlag = 0;bossFlag = 1;
					}
					else{//��ͨ����
						player.subHP(bossRealAttack);
						MyDialog.showMessageDialog(blanck + boss.getname() + "��" + player.getname() + "�����" + bossRealAttack + "���˺�", "ս����Ϣ", LenthAll.TALK_DIALOG_WIDTH, LenthAll.TALK_DIALOG_HEIGHT);
						playerFlag = 1;bossFlag = 0;
					}
				}
				else if(playerFlag == 1 && bossFlag == 0){//��ҳ���
					fd.show();					
					if(!fd.isVisible()){				
						boss.subHP(playerRealAttack);
						MyDialog.showMessageDialog(blanck + player.getname() + "��"+ boss.getname() + "�����" + playerRealAttack + "���˺�", "ս����Ϣ", LenthAll.TALK_DIALOG_WIDTH, LenthAll.TALK_DIALOG_HEIGHT);
						break;
					}
					playerFlag = 0;bossFlag = 1;
				}
				else{
					System.exit(0);
					MyDialog.showMessageDialog(blanck + "����δԤ�ϴ��󣬳�������ֹ", "����", LenthAll.TALK_DIALOG_WIDTH, LenthAll.TALK_DIALOG_WIDTH);
				}
			}
		}
		if(player.getnowHP() <= 0){
			setInfo(player, boss);
			jp.updateUI();
			MyDialog.showMessageDialog(blanck + "ս��ʧ�ܣ���ɫ����ֵ�½�Ϊ0��������", "ս����Ϣ", LenthAll.TALK_DIALOG_WIDTH, LenthAll.TALK_DIALOG_HEIGHT);
		}
		else{
			setInfo(player, boss);
			jp.updateUI();
			MyDialog.showMessageDialog(blanck + "ս���ɹ������ȷ���˳�ս������", "ս����Ϣ", LenthAll.TALK_DIALOG_WIDTH, LenthAll.TALK_DIALOG_HEIGHT);
		}
	}
	private void setInfo(PersonAll player,PersonAll boss) {
		jl_name.setText("����:" + player.getname());
		jl_HP.setText("HP:"+ player.getnowHP());
		jl_MP.setText("MP:"+ player.getnowMP());
		jl_attack.setText("������:" + player.getBaseAttack());
		jl_name_boss.setText("����:" + boss.getname());
		jl_HP_boss.setText("HP:" + boss.getnowHP());
		jl_MP_boss.setText("MP:" + boss.getnowMP());
		jl_attack_boss.setText("������:" + boss.getBaseAttack());
	}
	
	private void setInfoLocation() {
        jl_name.setBounds(fightHead_image_width / 4, fightHead_image_height + 20, WIDTH, HEIGHT);
        jp.add(jl_name);
        jl_HP.setBounds(fightHead_image_width / 4, fightHead_image_height + 40, WIDTH, HEIGHT);
        jp.add(jl_HP);
        jl_MP.setBounds(fightHead_image_width / 4, fightHead_image_height + 60, WIDTH, HEIGHT);
        jp.add(jl_MP);
        jl_attack.setBounds(fightHead_image_width / 4,fightHead_image_height + 80,WIDTH,HEIGHT);
        jp.add(jl_attack);
        /*���ǵ�ս����Ϣ*/
        
        jl_name_boss.setBounds(LenthAll.WINDOW_WIDTH - fightHead_image_width / 2, fightHead_image_height + 20, WIDTH, HEIGHT);
        jp.add(jl_name_boss);
        jl_HP_boss.setBounds(LenthAll.WINDOW_WIDTH - fightHead_image_width / 2,fightHead_image_height + 40, WIDTH, HEIGHT);
        jp.add(jl_HP_boss);
        jl_MP_boss.setBounds(LenthAll.WINDOW_WIDTH - fightHead_image_width / 2,fightHead_image_height + 60, WIDTH, HEIGHT);
        jp.add(jl_MP_boss);
        jl_attack_boss.setBounds(LenthAll.WINDOW_WIDTH - fightHead_image_width / 2,fightHead_image_height + 80, WIDTH, HEIGHT);
        jp.add(jl_attack_boss);
        /*boss��ս����Ϣ*/
	}
}