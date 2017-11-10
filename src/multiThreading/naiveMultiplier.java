package multiThreading;

public class naiveMultiplier extends Multiplier {

	public naiveMultiplier(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}

	public naiveMultiplier(Multiplier obj) {
		// TODO Auto-generated constructor stub
		super(obj);
	}

	@Override
	int[][] multiply() {
		// TODO Auto-generated method stub
		int ans[][] = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				ans[i][j] = multrow(i, j);
			}
		}
		return ans;
	}

}
