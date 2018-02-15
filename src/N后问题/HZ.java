package N后问题;

import java.util.ArrayList;


public class HZ {
	int n;
	int[] x;//当前的解
	long sum;

	public HZ(int n){
		this.n=n;
		x=new int[n+1];
		sum=0;
	}
	public boolean place(int k){
		for(int j=1;j<k;j++){
			if((Math.abs(j-k))==(Math.abs(x[j]-x[k]))||x[j]==x[k]) 
				return false;
		}
		return true;
	}
	public ArrayList<Integer> arrayList=new ArrayList<Integer>();
	public ArrayList<Integer> queen(int t){
		if(t>n){
			sum++;
			for(int i=1;i<=n;i++){
				arrayList.add(x[i]);
			}
		}else{
			for(int i=1;i<=n;i++){
				x[t]=i;
				if(sum==2){
					return arrayList;
				}
				if(place(t))  
					queen(t+1);			
			}
		}
		return arrayList;
	}
}

