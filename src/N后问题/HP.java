package N后问题;

import java.util.ArrayList;

import java.util.ArrayList;

class HP{
	 ArrayList<Integer>arry=new ArrayList<>();
     int n; //皇后个数
     int x[];//当前解空间
     long sum;//当前已找到的可行方案数
 boolean Place(int k)//位置检查，满足约束则返回true，否则返回false
 {
     for(int j=1;j<k;j++)//检查k个皇后不同列和不同斜线的约束语句
         if((Math.abs(k-j)==Math.abs(x[j]-x[k])))
             return false;
     return true;
 }
 void swap(int t,int i,int x[])
 {
     int k;
     k=x[t];
     x[t]=x[i];
     x[i]=k;
 }
 
ArrayList<Integer> Backtrack(int t)
 {
     if(t>n)
     {
         for(int i=1;i<=n;i++)//方案数加1前，先打印符合要求的排列组合
             arry.add(x[i]);
         sum++;//搜索至叶结点，即讨论完最后一个皇后的位置，得到一个新的不受攻击放置方案，可行方案数加 1
     }
     else
         for(int i=t;i<=n;i++)//控制分支数目，每次都要减一，初始值从t开始而非1
         {
             swap(t,i,x);//交换位置，得到一种新的排列————轮岗ing
             if(sum==2){
            	 return arry;
             }
             if(Place(t))//检查放置位置是否满足约束条件
                 Backtrack(t+1);//深度优先搜索可行子树
             swap(t,i,x);//调回原位置（初始排列组合）———— 众神归位
         }
	return arry;
 }
ArrayList<Integer> nQueen(int n)
 {
     HP X=new HP();//定义并初始化X的信息
     X.n = n;
     X.sum = 0;
     int p[] = new int [n+1];
     for(int i=1;i<=n;i++)
         p[i] = i;//给x[i]赋初值，必须是其排列的一种
     X.x = p;
     return X.Backtrack(1);
 }
 }


