package multiThreading;
import java.util.LinkedList;
class MultiplicationThread extends Thread
{
	int arr1[][];
	int arr2[][];
	int ans[][];
	int start;
	int end;
	int size;
	public MultiplicationThread(int arr1[][],int arr2[][],int ans[][], int start,int end,int size)
	{
		super();
		this.arr1=arr1;
		this.arr2=arr2;
		this.ans=ans;
		this.start=start;
		this.end=end;
		this.size=size;
	}
	
	int multrow(int i,int j)
	{
		int ans=0;
		for(int k=0;k<size;k++)
			ans+=arr1[i][k]*arr2[k][j];
		return ans;
	}
    public void run()
    {
        try
        {
          for(int i=start;i<=end;i++)
          {
        	  if(i>=size)
        		  break;
        	  for(int j=0;j<size;j++)
        	  {
        		  ans[i][j]=multrow(i,j);
        	  }
          }
        }
        catch (Exception e)
        {
            // Throwing an exception
            System.out.println ("Exception is caught");
        }
    }
}
 


public class threadedMultiplier extends Multiplier {

	public threadedMultiplier(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}

	public threadedMultiplier(Multiplier n) {
		super(n);
		// TODO Auto-generated constructor stub
	}
	@Override
	int[][] multiply() {
		// TODO Auto-generated method stub
		int ans[][]=new int[size][size];
		int threads=4;
		int interval=size/4;
		int start=0;
		LinkedList<Thread> threadCollect=new LinkedList<Thread>();
		
		for(int i=0;i<threads;i++)
		{
			int end=start+interval;
			if(i==threads-1)
				end=size-1;
			
			Thread object = new Thread(new MultiplicationThread(a,b,ans,start,end,size));
			threadCollect.add(object);
			object.start();
			start=end+1;
			if(start>=size)
				break;
		}
		for (Thread thread : threadCollect) {
		    try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return ans;
	}
	

}
