/*�ڰ˲��֣���Ϸ��ʼ����*/
package basePackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.NonWritableChannelException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameStart extends JFrame implements ActionListener{
	private JButton start;//��ʼ��Ϸ��ť
	private JButton load;//������ť
	private JButton makeAbout;//�������
	private JButton quit;//�˳�
	private threadChange tc;
	private Vector<JLabel> texVc;
	private music musicPlayer;
	ImageIcon black_back = new ImageIcon("src/imageSource/��ɫ.jpg");
	ImageIcon topic_back = new ImageIcon("src/imageSource/�ڲ�.jpg");
	JLabel black = new JLabel(black_back);//Ļǰ�ڲ�
	JLabel topic = new JLabel(topic_back);//���䳤������
	public GameStart(){
		texVc = new Vector<>();
		tc = new threadChange(2000);
        String text = readText.read("src/text/text.txt").get(0);
        for(int i = 0;i < text.length();i++){
        	JLabel jl = new JLabel(text.charAt(i) + "");
        	texVc.add(jl);
        }
        
        start = new JButton("�µ��ó�");
        load = new JButton("�ɵĻ���");
        makeAbout = new JButton("�������");
        quit = new JButton("�˳���Ϸ");
        
		setTitle("");  
        Toolkit tool = getToolkit();  
        Dimension dim = tool.getScreenSize();  
        setBounds(0, 0, LenthAll.WINDOW_WIDTH, LenthAll.WINDOW_HEIGHT); 
        this.setLocation((int)(dim.getWidth() - LenthAll.WINDOW_WIDTH) / 2,(int)(dim.getHeight() - LenthAll.WINDOW_HEIGHT) / 2);//���õ�ǰ��������Ļ��������
        this.addWindowListener(new WindowAdapter() {
        	public void windowClosing(WindowEvent event) {
				System.exit(0);
        	}
        });//���ùرճ������
        JPanel jp = (JPanel) getContentPane();
        this.setResizable(false);//�̶����ڴ�С���������������
		setVisible(true);
        //--------------------------------------------------------------------------
		musicPlayer = new music();//���ֲ���
		printWord(jp);
		jp.setLayout(null);//���������ںڲ���������֮�󣬲�Ȼ��ʾ������
		setbtnInfo(jp);
	}
	
	public void printWord(JPanel jp){
		jp.add(black);
		jp.validate();
		tc.run(1500);
		for(int i = 0;i < texVc.size();i++){
			texVc.get(i).setFont(new Font(null, 0, 30));
			texVc.get(i).setForeground(Color.WHITE);
		}
		
		int count = 0;
		for(; count < 7;count++){
			texVc.get(count).setBounds(300 + count*50, 200, 50, 50);
			black.add(texVc.get(count));
			tc.run(300);
			jp.updateUI();
		}
		tc.run(800);
		int location = 0;
		for(;count < 10;count++){
			texVc.get(count).setBounds(300 + location*50, 250, 50, 50);
			black.add(texVc.get(count));
			tc.run(300);
			jp.updateUI();
			location++;
		}
		tc.run(800);
		for(;count < 13;count++){
			texVc.get(count).setBounds(350 + location*50, 250, 50, 50);
			black.add(texVc.get(count));
			tc.run(300);
			jp.updateUI();
			location++;
		}
        tc.run();
        black.setVisible(false);
        jp.add(topic);
        jp.validate(); 
	}

	private void setbtnInfo(JPanel jp){
		topic.add(start);
		topic.add(load);
		topic.add(makeAbout);
		topic.add(quit);
		start.setBounds(LenthAll.WINDOW_WIDTH / 2 - 50, 350, 100, 30);
		load.setBounds(LenthAll.WINDOW_WIDTH / 2 - 50, 400, 100, 30);
		makeAbout.setBounds(LenthAll.WINDOW_WIDTH / 2 - 50, 450, 100, 30);
		quit.setBounds(LenthAll.WINDOW_WIDTH / 2 - 50, 500, 100, 30);
		start.setVisible(true);
		load.setVisible(true);
		quit.setVisible(true);
		makeAbout.setVisible(true);
		setVisible(true);
		jp.validate();
		start.addActionListener(this);
		load.addActionListener(this);
		makeAbout.addActionListener(this);
		quit.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("�µ��ó�")){
			setVisible(false);
			musicPlayer.Close();
			new newTrip();
		}
		else if(e.getActionCommand().equals("�ɵĻ���")){
			//���л������浵
		}
		else if(e.getActionCommand().equals("�������")){
			//
		}
		else if(e.getActionCommand().equals("�˳���Ϸ")){
			MyDialog.showMessageDialog("                                                   �����˳���Ϸ................", "�˳�", LenthAll.TALK_DIALOG_WIDTH, LenthAll.TALK_DIALOG_HEIGHT);
			System.exit(-1);
		}
	}
}