package basePackage;

import java.util.Vector;

public class Monster {
	private Vector<String> vc;
	public Monster() {
		// TODO Auto-generated constructor stub
		vc = readText.read("src/MapSource/monster_Tabel.txt");
	}
	public String[] getMonsterInfo(int i){
		String s = vc.get(i);//取哪只怪物
		String []sourceBuffer = s.split(" ");
		return sourceBuffer;
	}
	
	public int[][] monster_distribution(int[][] matrix,int[][] monster,int count){       //怪物分布
		for(int i = 0; i < count;){   //该地图，部署20个怪物，且每次战斗后，重新刷新部署
			int x = (int )((Math.random() * 100) % LenthAll.COUNT_ROW);
			int y = (int )((Math.random() * 100) % LenthAll.COUNT_LATER_COL);
			if(matrix[x][y] == MapDeploy.GRASSLAND_ON){
				monster[x][y] = 1;//此处有怪物
				i++;
			}
		}
		return monster;
	}
	
	public int[][] mosnter_clear(int[][] matrix){ // clear the monster in the map
		for(int i = 0; i < LenthAll.COUNT_ROW;i++){
			for(int j = 0;j < LenthAll.COUNT_LATER_COL;j++){
				matrix[i][j] = 0;
			}
		}
		return matrix;
	}
}
