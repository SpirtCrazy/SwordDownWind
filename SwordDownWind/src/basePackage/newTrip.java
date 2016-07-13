/*�µĿ�ʼ���ھŲ���*/
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

import PersonAll.Hero;
import PersonAll.PersonAll;
import warFrame.monster_fight;

public class newTrip extends JFrame implements ActionListener{
	private int Person_x;
	private int Person_y;
	private Hero player;
	private static final int fightHead_x = LenthAll.WINDOW_WIDTH - 200;
	private static final int fightHead_y = 0;
	private static final int fightHead_image_width = 200;
	private static final int fightHead_image_height = 190;
	private static final int WIDTH = 80;
	private static final int HEIGHT = 20;
	private JButton Goods;
	private JButton exit;
	private JLabel name;
	private JLabel level;
	private JLabel ex;
	private JLabel HP;
	private JLabel MP;
	private JLabel attack;
	private JLabel duty;
	private Vector<JLabel> tree;
	private Vector<JLabel> land;
	private Vector<JLabel> montain;
	private Vector<JLabel> sea;
	private Vector<JLabel> hourse;
	private Vector<JLabel> person;
	private int [][]matrix;
	private int [][]monster;
	private int count_duty = 0;//�����������������
	
	public newTrip(){
		tree = new Vector<>();
		land = new Vector<>();
		montain = new Vector<>();
		sea = new Vector<>();
		hourse = new Vector<>();
		person = new Vector<>();
		matrix = new int[LenthAll.COUNT_ROW][LenthAll.COUNT_LATER_COL];
		monster = new int[LenthAll.COUNT_ROW][LenthAll.COUNT_LATER_COL];
		matrix = readTxtFile.readFile("src/MapSource/wolongMap.txt");
		player = new Hero();
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
		JPanel jp = (JPanel) getContentPane();
		this.setResizable(false);// �̶����ڴ�С���������������
		setVisible(true);
		//------------------------------------------------------------
		ImageIcon icon = new ImageIcon("src/imageSource/reunit.jpeg");//������Ƭ
		ImageIcon icon_1 = new ImageIcon("src/imageSource/����.jpg");//�����ڵ���Ƭ
		ImageIcon icon_2 = new ImageIcon("src/imageSource/������.jpg");//�����ӷ���
		ImageIcon icon_3 = new ImageIcon("src/imageSource/ս��.jpg");//����ս��
		ImageIcon icon_4 = new ImageIcon("src/imageSource/����Ʈ��.jpg");//����Ʈ���¥
		ImageIcon icon_photo = new ImageIcon("src/imageSource/�ྪ��ͷ��.jpeg");
		
		JLabel hero = new JLabel(icon);
		JLabel inHome = new JLabel(icon_1);
		JLabel wolongHome = new JLabel(icon_2);
		JLabel war_furen = new JLabel(icon_3);
		JLabel wanlipiaoxiang = new JLabel(icon_4);
		JLabel yanjinghan = new JLabel(icon_photo);
		
		jp.add(hero);
		jp.validate();
		MyDialog.showMessageDialog("                       ���ס��������������� ", "�ྪ��", LenthAll.TALK_DIALOG_WIDTH, LenthAll.TALK_DIALOG_HEIGHT);
		hero.setVisible(false);
		jp.add(inHome);
		jp.validate();
		MyDialog.showMessageDialog("              ����������������������������ԭ�������Ρ�������", "�ྪ��", LenthAll.TALK_DIALOG_WIDTH, LenthAll.TALK_DIALOG_HEIGHT);
		inHome.setVisible(false);
		jp.add(war_furen);
		jp.validate();
		MyDialog.showMessageDialog("         ����ǰ����������뿪������ȴ����;�����������������\n    ��������������Σ��֮�У�", "����", LenthAll.TALK_DIALOG_WIDTH, LenthAll.TALK_DIALOG_HEIGHT);
		war_furen.setVisible(false);
		jp.add(wanlipiaoxiang);
		MyDialog.showMessageDialog("        ���Ƕ���һ��ǰ������Ʈ�㣬ȴ���˾������⣬�����������ҵ�\n    ���壬�ŵ�ż��ʦ��-�����ӣ�", "����", LenthAll.TALK_DIALOG_WIDTH, LenthAll.TALK_DIALOG_HEIGHT);
		MyDialog.showMessageDialog("        �����ʦ����ĸ���䣬ʦ��ȴ�����ԣ�Ҫ������ϰ��ʮ�꣬���\n    ��ȥѰ�Ҵ𰸡�", "����", LenthAll.TALK_DIALOG_WIDTH, LenthAll.TALK_DIALOG_HEIGHT);
		wanlipiaoxiang.setVisible(false);
		jp.add(wolongHome);
		jp.validate();
		MyDialog.showMessageDialog("        �����Ƽ���������ˮ�����������������ӵĵ�������ͷ��ʦ��δ\n    ������һ��һʽ����ȴ���������������ӵ�һ�������������\n    ��ǿ׳���ѷ�ͬ���˿ɱȡ�", "����", LenthAll.TALK_DIALOG_WIDTH, LenthAll.TALK_DIALOG_HEIGHT);
		wolongHome.setVisible(false);
		inHome.setVisible(true);
		jp.validate();
		MyDialog.showMessageDialog("                         ͽ������������ͽ������С�ӻ���˯����", "һ������", LenthAll.TALK_DIALOG_WIDTH, LenthAll.TALK_DIALOG_HEIGHT);
		MyDialog.showMessageDialog("                         ��!(���Ŷ���)    ��С����ôһ������", "������", LenthAll.TALK_DIALOG_WIDTH, LenthAll.TALK_DIALOG_HEIGHT);
		MyDialog.showMessageDialog("                        û�£�ʦ�����μ������˶���", "�ྪ��", LenthAll.TALK_DIALOG_WIDTH, LenthAll.TALK_DIALOG_HEIGHT);
		MyDialog.showMessageDialog("              ���ж��£�����ǿ��,���˶���,��ȥ�ּ���Ұ�ã������\n       �����Ƕ�δ�����ˣ�", "������",LenthAll.TALK_DIALOG_WIDTH,LenthAll.TALK_DIALOG_HEIGHT);
		MyDialog.showMessageDialog("                     ...........", "�ྪ��", LenthAll.TALK_DIALOG_WIDTH, LenthAll.TALK_DIALOG_HEIGHT);
		inHome.setVisible(false);
		jp.setLayout(null);
		
		init(matrix);
		paintMap(matrix, jp);
		yanjinghan.setBounds(fightHead_x + 10, fightHead_y, fightHead_image_width, fightHead_image_height);
		jp.add(yanjinghan);
		initLabel(jp);
		jp.updateUI();
		
		Monster ms = new Monster();//������Ϣ��
		monster = ms.monster_distribution(matrix, monster, 20);//�ڸõ�ͼ�Ŀ���������20������
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e){
				matrix = MoveLogic.moveStrategy(matrix, e.getKeyCode(), Person_x, Person_y);
				paintMap(matrix, jp);
				jp.updateUI();
				if(monster[Person_x][Person_y] == 1){
					setVisible(false);
					new monster_fight();
				}
			}
		});
	}
	

	
	private void initLabel(JPanel jp){
		name = new JLabel("������" + player.getname());
		level = new JLabel("�ȼ���" + player.getLevel());
		HP = new JLabel("HP��" + player.getnowHP() + "//" + player.getlimitedHP());
		MP = new JLabel("MP��" + player.getnowMP() + "//" + player.getlimitedMP());
		attack = new JLabel("��������" + player.getBaseAttack());
		ex = new JLabel("���飺" + player.getEX());
		duty = new JLabel("<html>��������:������<br/>�Ӹ���Ϊʦ���������⣺<html>" + count_duty + "/" + "10");
		exit = new JButton("�˳���Ϸ");
		Goods = new JButton("��Ʒ");
		name.setBounds(LenthAll.WINDOW_WIDTH - fightHead_image_width + 60, fightHead_image_height + 20, WIDTH, HEIGHT);
		level.setBounds(LenthAll.WINDOW_WIDTH - fightHead_image_width + 60,fightHead_image_height + 40, WIDTH, HEIGHT);
		ex.setBounds(LenthAll.WINDOW_WIDTH - fightHead_image_width + 60, fightHead_image_height + 60, WIDTH,HEIGHT);
		HP.setBounds(LenthAll.WINDOW_WIDTH - fightHead_image_width + 60, fightHead_image_height + 100, WIDTH, HEIGHT);
		MP.setBounds(LenthAll.WINDOW_WIDTH - fightHead_image_width + 60, fightHead_image_height + 120, WIDTH, HEIGHT);
		attack.setBounds(LenthAll.WINDOW_WIDTH - fightHead_image_width + 60, fightHead_image_height + 140, WIDTH, HEIGHT);
		duty.setBounds(LenthAll.WINDOW_WIDTH - fightHead_image_width + 60, fightHead_image_height + 180, WIDTH + 30, HEIGHT + 40);
		Goods.setBounds(LenthAll.WINDOW_WIDTH - fightHead_image_width + 60, fightHead_image_height + 260, WIDTH + 20, HEIGHT);
		exit.setBounds(LenthAll.WINDOW_WIDTH - fightHead_image_width + 60, fightHead_image_height + 300, WIDTH + 20, HEIGHT);
		Goods.addActionListener(this);
		exit.addActionListener(this);
		jp.add(level);
		jp.add(ex);
		jp.add(name);
		jp.add(HP);
		jp.add(MP);
		jp.add(attack);
		jp.add(duty);
		jp.add(exit);
		jp.add(Goods);
	}
	
	private void updataInfo(){
		name.setText("������" + player.getname());
		level.setText("�ȼ���" + player.getLevel());
		HP.setText("HP��" + player.getnowHP() + "//" + player.getlimitedHP());
		MP.setText("MP��" + player.getnowMP() + "//" + player.getlimitedMP());
		attack.setText("��������" + player.getBaseAttack());
		ex.setText("���飺" + player.getEX());
		duty.setText("<html>��������:������<br/>�Ӹ���Ϊʦ���������⣺<html>" + count_duty + "/" + "10");
	}
	
	private void init(int[][] matrix) {
		ImageIcon Tree = new ImageIcon("src/imageSource/ɭ��.png");
		ImageIcon Mountain = new ImageIcon("src/imageSource/��ɽ.png");
		ImageIcon Land = new ImageIcon("src/imageSource/�ݵ�.png");
		ImageIcon Person = new ImageIcon("src/imageSource/�ྪ��.jpeg");
		ImageIcon Sea = new ImageIcon("src/imageSource/����.png");
		ImageIcon Hourse = new ImageIcon("src/imageSource/house_1.jpg");
		for(int i = 0; i < LenthAll.COUNT_ROW;i++)
			for(int j = 0;j < LenthAll.COUNT_LATER_COL;j++){
				if(matrix[i][j] == MapDeploy.TREE_ON){
					JLabel J_Tree = new JLabel(Tree);
					tree.add(J_Tree);
				}
				else if(matrix[i][j] == MapDeploy.MOUNTAIN_ON){
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
				else if(matrix[i][j] == MapDeploy.SEA_ON){
					JLabel J_SEA = new JLabel(Sea);
					sea.add(J_SEA);
				}
				else if(matrix[i][j] == MapDeploy.HOUSE_ON){
					JLabel J_HOURSE = new JLabel(Hourse);
					hourse.add(J_HOURSE);
				}
			}
	}
	
	private void paintMap(int [][]matrix,JPanel jp){
		int count_tree = 0;
		int count_land = 0;
		int count_sea = 0;
		int count_mountain = 0;
		
		for(int i = 0; i < LenthAll.COUNT_ROW;i++){
			for(int j = 0; j < LenthAll.COUNT_LATER_COL;j++){
				switch (matrix[i][j]) {
				case MapDeploy.TREE_ON:
					tree.get(count_tree).setBounds(-10 + j*LenthAll.IMAGE_WIDTH, -10 + i*LenthAll.IMAGE_HEIGHT,LenthAll.IMAGE_WIDTH, LenthAll.IMAGE_HEIGHT);
	            	jp.add(tree.get(count_tree++));
					break;
				case MapDeploy.GRASSLAND_ON:
					land.get(count_land).setBounds(-10 + j*LenthAll.IMAGE_WIDTH, -10 + i*LenthAll.IMAGE_HEIGHT,LenthAll.IMAGE_WIDTH, LenthAll.IMAGE_HEIGHT);
	            	jp.add(land.get(count_land++));
					break;
				case MapDeploy.SEA_ON:
					sea.get(count_sea).setBounds(-10 + j*LenthAll.IMAGE_WIDTH, -10 + i*LenthAll.IMAGE_HEIGHT,LenthAll.IMAGE_WIDTH, LenthAll.IMAGE_HEIGHT);
	            	jp.add(sea.get(count_sea++));
	            	break;
				case MapDeploy.PERSON_STAND:
					Person_x = i;
					Person_y = j;
					person.get(0).setBounds(-10 + j*LenthAll.IMAGE_WIDTH, -10 + i*LenthAll.IMAGE_HEIGHT,LenthAll.IMAGE_WIDTH, LenthAll.IMAGE_HEIGHT);
	            	jp.add(person.get(0));
					break;
				case MapDeploy.HOUSE_ON:
					hourse.get(0).setBounds(-10 + j*LenthAll.IMAGE_WIDTH, -10 + i*LenthAll.IMAGE_HEIGHT,LenthAll.IMAGE_WIDTH, LenthAll.IMAGE_HEIGHT);
	            	jp.add(hourse.get(0));
					break;
				case MapDeploy.MOUNTAIN_ON:
					montain.get(count_mountain).setBounds(-10 + j*LenthAll.IMAGE_WIDTH, -10 + i*LenthAll.IMAGE_HEIGHT, LenthAll.IMAGE_WIDTH, LenthAll.IMAGE_HEIGHT);
					jp.add(montain.get(count_mountain++));
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
			
		}
		else if(e.getActionCommand().equals("�˳���Ϸ")){
			MyDialog.showMessageDialog("            ��¼�ѱ���,���ȷ���˳���Ϸ��������������������", null, LenthAll.TALK_DIALOG_WIDTH, LenthAll.TALK_DIALOG_HEIGHT);
			System.exit(-1);
		}
	}
}