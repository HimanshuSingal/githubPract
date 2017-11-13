package multiThreading;

import java.util.Random;

public  class Addition {
	int a[][];
	int b[][];
	int size;
	public Addition(int n)
	{
		if(n<=0)
		{
			throw new IllegalArgumentException("Size can't be negative or zero");
		}
		 
		size=n;
		
		a=new int[this.size][this.size];
		
		initMatrix(a);
		b=new int[this.size][this.size];
		
		initMatrix(b);
		
		
	}
	
	
	void initMatrix(int mat[][])
	{
		Random r=new Random();
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				
				mat[i][j]=r.nextInt(5);
			}
		}
	
	}
	void display(int mat[][])
	{
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}
	void showMatrix()
	{
		System.out.println("Matrix 1");
		display(a);
		
		System.out.println("Matrix 2");
		display(b);
		
	}
	int[][] addition()
	{
		// TODO Auto-generated method stub
		int ans[][] = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				ans[i][j] = a[i][j]+b[i][j];
			}
		}
		return ans;

	}
	public static void main(String args[])
	{
		Addition obj=new Addition(4);
		obj.showMatrix();
		System.out.println("Answer");
		obj.display(obj.addition());
		
	}
	
}

