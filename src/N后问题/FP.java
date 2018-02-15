package N后问题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FP {
	public ArrayList<Integer> result; // 存储结果，result[i]=k 表示第 i+1 排第 k+1 个位置摆个皇后
	int currRow; // 当前记录的结果到了第几行 : 1~n

	FP ResultAfterPutHere(int pos, FP rtn) {
		int row, i;
		FP r;
		for (row = 0; row < currRow; row++) {
			if (currRow - row == pos - result.get(row) // 同摆在了右斜线
					|| currRow - row == -pos +result.get(row) // 同摆在了左斜线
			) // 也就是存在冲突的皇后
			{
				return null; // 那么就返回空
			}
		}
		// 不存在冲突的皇后，在此处摆上一个皇后，返回新的结果
		r = new FP();
		r.result = new ArrayList<>();
		r.currRow = currRow + 1;
		for (i = 0; i <currRow; i++) {// 复制前面的皇后摆放情况
			r.result.add(rtn.result.get(i));
		}
		r.result.add(currRow, pos);// 摆上新的皇后
		return r;
	}

	public static  ArrayList<Integer> diaoyong(int n) {
		ArrayList<Integer> arraylist = new ArrayList<>();
		Queue<FP> list = new LinkedList<>();
		FP rtn, rtnNew;
		for (int i = 0; i < n; i++) {// 把第一排的n种摆法都放进队列
			rtn = new FP();
			rtn.result = new ArrayList<>();
			rtn.result.add(i);
			rtn.currRow = 1;
			list.add(rtn);
		}
		
		// 处理每一种情况，直到找出结果
		while (!list.isEmpty()) {
			int j=0;
			rtn = list.peek(); // 取出排在最前面的家伙
			list.poll();
			for (int i = 0; i <n; i++) {
				if(rtn.result.contains(i)&&j<=rtn.currRow){
					j++;
					continue;	
				}
				rtnNew = rtn.ResultAfterPutHere(i, rtn);
				if (rtnNew != null) {// 不冲突
					if (rtnNew.currRow == n) // 看是否已经摆完了N皇后
					{// 摆完了
						for (i = 0; i < rtnNew.currRow; i++)
							arraylist.add(rtnNew.result.get(i) + 1);
						if(arraylist.size()==n*2){
							
								return arraylist;
							
						}
					}
					// 没有摆完就进队列继续摆
					list.add(rtnNew);
				}
			}
			//rtn = null;
		}
		return arraylist;
	}

}



