package basePackage;

import java.util.Vector;

public class Monster {
	private Vector<String> vc;
	public Monster() {
		// TODO Auto-generated constructor stub
		vc = readText.read("src/MapSource/monster_Tabel.txt");
	}
	public String[] getMonsterInfo(int i){
		String s = vc.get(i);//ȡ��ֻ����
		String []sourceBuffer = s.split(" ");
		return sourceBuffer;
	}
	
	public int[][] monster_distribution(int[][] matrix,int[][] monster,int count){       //����ֲ�
		for(int i = 0; i < count;){   //�õ�ͼ������20�������ÿ��ս��������ˢ�²���
			int x = (int )((Math.random() * 100) % LenthAll.COUNT_ROW);
			int y = (int )((Math.random() * 100) % LenthAll.COUNT_LATER_COL);
			if(matrix[x][y] == MapDeploy.GRASSLAND_ON){
				monster[x][y] = 1;//�˴��й���
				i++;
			}
		}
		return monster;
	}
}