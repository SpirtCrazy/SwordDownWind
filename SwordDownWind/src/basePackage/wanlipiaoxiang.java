/*��ʮһ��*/
package basePackage;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.omg.CORBA.PUBLIC_MEMBER;

import Medicament.jinchuanggao;
import Medicament.yuexiancao;
import PersonAll.Hero;
import dialogPackage.ProcessDialog;
import warFrame.monster_fight;

public class wanlipiaoxiang extends JFrame implements ActionListener{
	private static final int fightHead_image_width = 200;
	private static final int fightHead_image_height = 190;
	private static final int WIDTH = 80;
	private static final int HEIGHT = 20;
	private int Person_x,Person_y;
	private Hero player;
	private Vector<JLabel> heroInfo;
	private JPanel jp;
	private JButton Goods,exit;
	private JLabel duty;
	private Vector<JLabel> montain;
	private Vector<JLabel> person;
	private Vector<JLabel> land;
	private int [][]matrix;
	private int [][]monster;
	private Vector<Integer> numVc;
	
	public wanlipiaoxiang(Hero player) {
		// TODO Auto-generated constructor stub
		this.player = player;
		heroInfo = HeroInfo.initInfo();
		land = new Vector<>();
		montain = new Vector<>();
		person = new Vector<>();
		numVc = new Vector<>();
		matrix = new int[LenthAll.COUNT_ROW][LenthAll.COUNT_LATER_COL];
		monster = new int[LenthAll.COUNT_ROW][LenthAll.COUNT_LATER_COL];
		matrix = readTxtFile.readFile("src/MapSource/UpForLevel.txt");
		
		setTitle("�ڶ��£�������ˮ������");
		Toolkit tool = getToolkit();
		Dimension dim = tool.getScreenSize();
		setBounds(0, 0, LenthAll.WINDOW_WIDTH, LenthAll.WINDOW_HEIGHT);
		this.setLocation((int) (dim.getWidth() - LenthAll.WINDOW_WIDTH) / 2,
				(int) (dim.getHeight() - LenthAll.WINDOW_HEIGHT) / 2);// ���õ�ǰ��������Ļ��������
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				System.exit(0);
			}
		});// ���ùرճ������
		jp = (JPanel) getContentPane();
		this.setResizable(false);// �̶����ڴ�С���������������
		jp.setLayout(null);
		setVisible(true);
		/*-------------------------windows create---------------------------------*/
		init(matrix);
		paintMap(matrix, jp);
		initLabel();
		jp.updateUI();
		Goods.addActionListener(this);
		exit.addActionListener(this);
		//player.setLevel(10);
		Monster ms = new Monster();
		monster = ms.monster_distribution(matrix, monster, 20);
		numVc.add(1);numVc.add(2);
		
		
		
		Thread tf_duty = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(player.getLevel() < 10){
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				MyDialog.showMessageDialog("                        ��ϲ����������ɣ�", "��ʾ", LenthAll.TALK_DIALOG_WIDTH, LenthAll.TALK_DIALOG_HEIGHT);
				duty.setText("<html>�������񣺵�����<br/>Ʈ�����ϰ壬��ȡ�й�ĸ�׵���Ϣ��<html>" + "0/1");
			}
		});
		tf_duty.start();
		
		player.setLevel(10);//test
		
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				matrix = MoveLogic.moveStrategy(matrix, e.getKeyCode(), Person_x, Person_y);
				paintMap(matrix, jp);updateInfo();
				monster_fight mf;
				jp.updateUI();

				if(monster[Person_x][Person_y] == 1){
					int randNum = (int )(Math.random() * 100) % numVc.size();
					mf = new monster_fight(new Hero(),new Monster(),numVc,randNum);
					mf.setVisible(true);
					Thread tf_goods = new Thread(new Runnable() {
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							while(mf.isVisible()){
								try {
									Thread.sleep(1);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							String s = ms.getMonsterInfo(randNum)[9];
							if(Math.random() > Double.parseDouble(s) && randNum == 0){
								MyDialog.showMessageDialog("              ��ϲ�����һ�����ɲݣ�", "��ʾ", LenthAll.TALK_DIALOG_WIDTH, LenthAll.TALK_DIALOG_HEIGHT);
								player.addMedicament("���ɲ�", new yuexiancao(), 1);
							}
							else if(Math.random() > Double.parseDouble(s) && randNum == 1){
								MyDialog.showMessageDialog("               ��ϲ�����һ�Ž𴴸�", "��ʾ", LenthAll.TALK_DIALOG_WIDTH, LenthAll.TALK_DIALOG_HEIGHT);
								player.addMedicament("�𴴸�", new jinchuanggao(), 1);
							}
						}
					});
					tf_goods.start();
				}
				if(player.getLevel() >= 10 && Person_y == LenthAll.COUNT_LATER_COL - 1){
					new GetInfoOfMom(player);
					setVisible(false);
				}
			}
		});
	}
	private void initLabel() {
		for(int i = 0;i < heroInfo.size();i++){
			jp.add(heroInfo.get(i));
		}
		duty = new JLabel("<html>��������:��ߵ�<br/>����10��:<html>" + player.getLevel() + "/" + "10");
		exit = new JButton("�˳���Ϸ");
		Goods = new JButton("��Ʒ");
		duty.setBounds(LenthAll.WINDOW_WIDTH - fightHead_image_width + 60, fightHead_image_height + 180, WIDTH + 30, HEIGHT + 60);
		Goods.setBounds(LenthAll.WINDOW_WIDTH - fightHead_image_width + 60, fightHead_image_height + 300, WIDTH + 20, HEIGHT);
		exit.setBounds(LenthAll.WINDOW_WIDTH - fightHead_image_width + 60, fightHead_image_height + 340, WIDTH + 20, HEIGHT);
		jp.add(duty);
		jp.add(exit);
		jp.add(Goods);
		
	}
	
	private void updateInfo(){
		HeroInfo.updateInfo(heroInfo);
		if(player.getLevel() < 10){
			duty.setText("<html>��������:��ߵ�<br/>����10��:<html>" + player.getLevel() + "/" + "10");
		}
		else{
			duty.setText("<html>�������񣺵�����<br/>Ʈ�����ϰ壬��ȡ�й�ĸ�׵���Ϣ��<html>" + "0/1");
		}
	}
	
	private void init(int[][] matrix) {
		ImageIcon Mountain = new ImageIcon("src/imageSource/��ɽ.png");
		ImageIcon Land = new ImageIcon("src/imageSource/�ݵ�.png");
		ImageIcon Person = new ImageIcon("src/imageSource/�ྪ��.jpeg");
		for(int i = 0; i < LenthAll.COUNT_ROW;i++)
			for(int j = 0;j < LenthAll.COUNT_LATER_COL;j++){

				if(matrix[i][j] == MapDeploy.MOUNTAIN_ON){
					JLabel J_Mountain = new JLabel(Mountain);
					montain.add(J_Mountain);
				}
				else if(matrix[i][j] == MapDeploy.GRASSLAND_ON){
					JLabel J_land = new JLabel(Land);
					land.add(J_land);
				}
				else if(matrix[i][j] == MapDeploy.PERSON_STAND){
					JLabel J_Person = new JLabel(Person);
					person.add(J_Person);
				}
			}
	}
	
	private void paintMap(int [][]matrix,JPanel jp){
		int count_land = 0;
		int count_mountain = 0;
		
		for(int i = 0; i < LenthAll.COUNT_ROW;i++){
			for(int j = 0; j < LenthAll.COUNT_LATER_COL;j++){
				switch (matrix[i][j]) {
				case MapDeploy.GRASSLAND_ON:
					land.get(count_land).setBounds(-10 + j*LenthAll.IMAGE_WIDTH, -10 + i*LenthAll.IMAGE_HEIGHT,LenthAll.IMAGE_WIDTH, LenthAll.IMAGE_HEIGHT);
	            	jp.add(land.get(count_land++));
					break;

				case MapDeploy.PERSON_STAND:
					Person_x = i;
					Person_y = j;
					person.get(0).setBounds(-10 + j*LenthAll.IMAGE_WIDTH, -10 + i*LenthAll.IMAGE_HEIGHT,LenthAll.IMAGE_WIDTH, LenthAll.IMAGE_HEIGHT);
	            	jp.add(person.get(0));
					break;

				case MapDeploy.MOUNTAIN_ON:
					montain.get(count_mountain).setBounds(-10 + j*LenthAll.IMAGE_WIDTH, -10 + i*LenthAll.IMAGE_HEIGHT, LenthAll.IMAGE_WIDTH, LenthAll.IMAGE_HEIGHT);
					jp.add(montain.get(count_mountain++));
					break;
				default:
					break;
				}
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("��Ʒ")){
			ProcessDialog pd = new ProcessDialog();
			Thread td = new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					while(pd.isVisible()){
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					Goods.setFocusable(false);
					exit.setFocusable(false);
				}
			});
			td.start();
		}
		else if(e.getActionCommand().equals("�˳���Ϸ")){
			MyDialog.showMessageDialog("            ��¼�ѱ���,���ȷ���˳���Ϸ��������������������", null, LenthAll.TALK_DIALOG_WIDTH, LenthAll.TALK_DIALOG_HEIGHT);
			System.exit(-1);
		}
	}
}