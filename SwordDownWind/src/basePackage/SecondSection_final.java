/*第七部分，燕南征被击败后的过场动画*/
package basePackage;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import PersonAll.Hero;
import PersonAll.yannanzheng;

public class SecondSection_final extends JFrame{
	private int [][]matrix;
	private Vector<JLabel> Tree;
	private Vector<JLabel> Land;
	private Vector<JLabel> Boss;
	private Vector<JLabel> Person;
	private Vector<JLabel> Person_two;
	private threadChange tc;
	private int boss_x;
	private int boss_y;
	
	public SecondSection_final(Hero player){
		Tree = new Vector<JLabel>();
		Land = new Vector<JLabel>();
		Boss = new Vector<JLabel>();
		Person = new Vector<JLabel>();
		Person_two = new Vector<JLabel>();
		matrix = new int[LenthAll.COUNT_ROW][LenthAll.COUNT_COL];
		matrix = readTxtFile.readFile("src/MapSource/liyunTown_forest_final.txt");
		tc = new threadChange(100);
		setTitle("第一章：云深不知年几许");  
        Toolkit tool = getToolkit();  
        Dimension dim = tool.getScreenSize();  
        setBounds(0, 0, LenthAll.WINDOW_WIDTH, LenthAll.WINDOW_HEIGHT); 
        this.setLocation((int)(dim.getWidth() - LenthAll.WINDOW_WIDTH) / 2,(int)(dim.getHeight() - LenthAll.WINDOW_HEIGHT) / 2);//设置当前窗口在屏幕的正中央
        this.addWindowListener(new WindowAdapter() {
        	public void windowClosing(WindowEvent event) {
				System.exit(0);
        	}
        });//设置关闭程序监听
        JPanel jp = (JPanel) getContentPane();
        this.setResizable(false);//固定窗口大小，不可伸缩，最大化
        /*--------------------以上为窗口创建---------------------------------------*/
        ImageIcon icon = new ImageIcon("src/imageSource/燕南征受伤.jpeg");
        ImageIcon icon1 = new ImageIcon("src/imageSource/郑浩天.jpeg");
        ImageIcon icon2 = new ImageIcon("src/imageSource/澹台湘.jpeg");
        JLabel jback_yannanzheng = new JLabel(icon);
        JLabel jback_zhenghaotian = new JLabel(icon1);
        JLabel jback_tantaixiang = new JLabel(icon2);
        jp.add(jback_yannanzheng);
        setVisible(true);
        MyDialog.showMessageDialog("                         紫气……东来……咳咳，灵霄心法第……九层                                             ", "燕南征",LenthAll.TALK_DIALOG_WIDTH, LenthAll.TALK_DIALOG_HEIGHT);
        MyDialog.showMessageDialog("              你的………心法…………居然已经练就如此………境界             ","燕南征", LenthAll.TALK_DIALOG_WIDTH, LenthAll.TALK_DIALOG_HEIGHT);
        MyDialog.showMessageDialog("                                      你为何……还要留手？                                             ", "燕南征",LenthAll.TALK_DIALOG_WIDTH, LenthAll.TALK_DIALOG_HEIGHT);
        jback_yannanzheng.setVisible(false);
        jp.add(jback_zhenghaotian);
        jp.validate();
        MyDialog.showMessageDialog("              我只要知道《无妄天书》的下落，我不想你死，更不想小师\n         妹伤心。                         ", "郑浩天", LenthAll.TALK_DIALOG_WIDTH, LenthAll.TALK_DIALOG_HEIGHT);
        MyDialog.showMessageDialog("                                      告诉我无妄天书的下落                                             ", "郑浩天", LenthAll.TALK_DIALOG_WIDTH, LenthAll.TALK_DIALOG_HEIGHT);
        jback_zhenghaotian.setVisible(false);
        jback_yannanzheng.setVisible(true);
        MyDialog.showMessageDialog("                二十年前，我已告诉于你，我武功长进并非得益于无妄天\n        书，是有高人相助，如今你依旧不信我。                       ", "燕南征", LenthAll.TALK_DIALOG_WIDTH, LenthAll.TALK_DIALOG_HEIGHT);
        jback_yannanzheng.setVisible(false);
        jp.add(jback_tantaixiang);
        jp.validate();
        jback_tantaixiang.setVisible(true);
        MyDialog.showMessageDialog("                   师兄，多年不见，还是这般面冷心热。                                         ", "澹台湘", LenthAll.TALK_DIALOG_WIDTH, LenthAll.TALK_DIALOG_HEIGHT);
        jback_tantaixiang.setVisible(false);
        jback_zhenghaotian.setVisible(true);
        MyDialog.showMessageDialog("                     小师妹，好久不见。                  ", "郑浩天", LenthAll.TALK_DIALOG_WIDTH, LenthAll.TALK_DIALOG_HEIGHT);
        jback_zhenghaotian.setVisible(false);
        jback_tantaixiang.setVisible(true);
        MyDialog.showMessageDialog("                      是我爹派你来的。                                 ", "澹台湘", LenthAll.TALK_DIALOG_WIDTH, LenthAll.TALK_DIALOG_HEIGHT);
        jback_tantaixiang.setVisible(false);
        jback_zhenghaotian.setVisible(true);
        MyDialog.showMessageDialog("                是，此次前来，除了无妄天书的下落，岛主还交代，务必\n     将小师妹带回灵霄岛。", "郑浩天", LenthAll.TALK_DIALOG_WIDTH, LenthAll.TALK_DIALOG_HEIGHT);
        MyDialog.showMessageDialog("                  (顿了一顿)……岛主，他很想你！", "郑浩天", LenthAll.TALK_DIALOG_WIDTH, LenthAll.TALK_DIALOG_HEIGHT);
        jback_zhenghaotian.setVisible(false);
        jback_tantaixiang.setVisible(true);
        MyDialog.showMessageDialog("            好,我跟你回去，但你必须放了南征，且从此不再踏入小镇半\n     步，更不许伤害小镇里的人。", "澹台湘", LenthAll.TALK_DIALOG_WIDTH, LenthAll.TALK_DIALOG_HEIGHT);
        MyDialog.showMessageDialog("            .........", "燕南征", LenthAll.TALK_DIALOG_WIDTH, LenthAll.TALK_DIALOG_HEIGHT);
        jback_tantaixiang.setVisible(false);
        jback_zhenghaotian.setVisible(true);
        MyDialog.showMessageDialog("                             好，我答应你\n            (没想到在她心里，我尽是这般无情！)", "郑浩天", LenthAll.TALK_DIALOG_WIDTH, LenthAll.TALK_DIALOG_HEIGHT);
        jback_zhenghaotian.setVisible(false);
        jback_tantaixiang.setVisible(true);
        MyDialog.showMessageDialog("                 待我与丈夫嘱托两句，便与你一同回去。", "澹台湘", LenthAll.TALK_DIALOG_WIDTH, LenthAll.TALK_DIALOG_HEIGHT);
        jback_tantaixiang.setVisible(false);
        jback_yannanzheng.setVisible(true);
        MyDialog.showMessageDialog("                              (无言) ", "燕南征", LenthAll.TALK_DIALOG_WIDTH, LenthAll.TALK_DIALOG_HEIGHT);
        jback_yannanzheng.setVisible(false);
        jback_tantaixiang.setVisible(true);
        MyDialog.showMessageDialog("                            清州，万里飘香", "澹台湘", LenthAll.TALK_DIALOG_WIDTH, LenthAll.TALK_DIALOG_HEIGHT);
        jback_tantaixiang.setVisible(false);
        init(matrix);
        paintMap(matrix, jp);
        jp.updateUI();
        MyDialog.showMessageDialog("                                     湘儿…………保重 ", "燕南征", LenthAll.TALK_DIALOG_WIDTH, LenthAll.TALK_DIALOG_HEIGHT);
        move(16, jp);
        MyDialog.showMessageDialog("                                           保重。", "澹台湘", LenthAll.TALK_DIALOG_WIDTH, LenthAll.TALK_DIALOG_HEIGHT);
        move(6, jp);
        tc.run(1000);
        setVisible(false);
        new GameStart();
	}
	
	private void move(int movNum,JPanel jp){
		for(int i = 0; i < movNum;i++){
			tc.run();
        	matrix[boss_x][boss_y - 1] = MapDeploy.GRASSLAND_ON;
        	matrix[boss_x][boss_y++] = MapDeploy.PERSON_TWO_STAND;
			matrix[boss_x][boss_y] = MapDeploy.BOSS_ON;
			paintMap(matrix, jp);
			jp.updateUI();
		}
	}
	
	private void init(int[][] matrix) {
		Boss.clear();
		Tree.clear();
		Person.clear();
		Land.clear();
		Person_two.clear();
		ImageIcon tree = new ImageIcon("src/imageSource/森林.png");
		ImageIcon boss = new ImageIcon("src/imageSource/person.png");
		ImageIcon land = new ImageIcon("src/imageSource/草地.png");
		ImageIcon person = new ImageIcon("src/imageSource/燕南征行.jpg");
		ImageIcon person_two = new ImageIcon("src/imageSource/tantaixiang.png");
		for(int i = 0; i < LenthAll.COUNT_ROW;i++)
			for(int j = 0;j < LenthAll.COUNT_COL;j++){
				if(matrix[i][j] == MapDeploy.BOSS_ON){
					JLabel J_BOOS = new JLabel(boss);
					Boss.add(J_BOOS);
				}
				else if(matrix[i][j] == MapDeploy.TREE_ON){
					JLabel J_TREE = new JLabel(tree);
					Tree.add(J_TREE);
				}
				else if(matrix[i][j] == MapDeploy.PERSON_STAND){
					JLabel J_PERSON = new JLabel(person);
					Person.add(J_PERSON);
				}
				else if(matrix[i][j] == MapDeploy.GRASSLAND_ON){
					JLabel J_LAND = new JLabel(land);
					Land.add(J_LAND);
				}
				else if(matrix[i][j] == MapDeploy.PERSON_TWO_STAND){
					JLabel J_PERSON_TWO = new JLabel(person_two);
					Person_two.add(J_PERSON_TWO);
				}
			}
	}
	
	private void paintMap(int [][]matrix,JPanel jp){
		int count_tree = 0;
		int count_land = 0;
		for(int i = 0; i < LenthAll.COUNT_ROW;i++){
			for(int j = 0; j < LenthAll.COUNT_COL;j++){
				switch (matrix[i][j]) {
				case MapDeploy.BOSS_ON:
					Boss.get(0).setBounds(-10 + j*LenthAll.IMAGE_WIDTH, -10 + i*LenthAll.IMAGE_HEIGHT,LenthAll.IMAGE_WIDTH, LenthAll.IMAGE_HEIGHT);
	            	jp.add(Boss.get(0));
	            	boss_x = i;
	            	boss_y = j;
					break;
				case MapDeploy.GRASSLAND_ON:
					Land.get(count_land).setBounds(-10 + j*LenthAll.IMAGE_WIDTH, -10 + i*LenthAll.IMAGE_HEIGHT,LenthAll.IMAGE_WIDTH, LenthAll.IMAGE_HEIGHT);
	            	jp.add(Land.get(count_land++));
					break;
				case MapDeploy.TREE_ON:
					Tree.get(count_tree).setBounds(-10 + j*LenthAll.IMAGE_WIDTH, -10 + i*LenthAll.IMAGE_HEIGHT,LenthAll.IMAGE_WIDTH, LenthAll.IMAGE_HEIGHT);
	            	jp.add(Tree.get(count_tree++));
	            	break;
				case MapDeploy.PERSON_STAND:
					Person.get(0).setBounds(-10 + j*LenthAll.IMAGE_WIDTH, -10 + i*LenthAll.IMAGE_HEIGHT,LenthAll.IMAGE_WIDTH, LenthAll.IMAGE_HEIGHT);
	            	jp.add(Person.get(0));
					break;
				case MapDeploy.PERSON_TWO_STAND:
					Person_two.get(0).setBounds(-10 + j*LenthAll.IMAGE_WIDTH, -10 + i*LenthAll.IMAGE_HEIGHT, LenthAll.IMAGE_WIDTH, LenthAll.IMAGE_HEIGHT);
					jp.add(Person_two.get(0));
				default:
					break;
				}
			}
		}
	}
}
