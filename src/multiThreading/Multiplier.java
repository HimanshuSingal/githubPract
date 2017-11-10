package multiThreading;

import java.util.Random;

public abstract class Multiplier {
	int a[][];
	int b[][];
	int size;
	
	public Multiplier(int a[][],int b[][])
	{
		size=a.length;
		this.a=a;
		this.b=b;
		
	}
	public Multiplier(int n)
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
	public Multiplier(Multiplier obj)
	{
		size=obj.size;
		a=new int[this.size][this.size];
		
		copy(a,obj.a);
		b=new int[this.size][this.size];
		
		copy(b,obj.b);
		
		
	}
	int multrow(int i,int j)
	{
		int ans=0;
		for(int k=0;k<size;k++)
			ans+=a[i][k]*b[k][j];
		return ans;
	}
	void copy(int mat[][],int from[][])
	{
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
				mat[i][j]=from[i][j];
		}
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
	abstract int[][] multiply();
	
}
