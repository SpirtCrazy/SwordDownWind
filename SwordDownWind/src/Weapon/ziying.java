package Weapon;


public class ziying implements Weapon{			//֣����������Ӱ��
	private static int LimitedDuration = 100;
	private static int nowDuration = 100;
	@Override
	public int hurtValue() {
		// TODO Auto-generated method stub
		return 100;
	}

	@Override
	public void LowerDurable(int paraLower) {
		// TODO Auto-generated method stub
		nowDuration = nowDuration - paraLower;
	}

	@Override
	public void repair() {
		// TODO Auto-generated method stub
		nowDuration = LimitedDuration;
	}
	

}
