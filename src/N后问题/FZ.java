package N后问题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FZ {
	public int[] q; // 表示第 i+1 排第 q[i] 个位置摆个皇后
	public int currentRow; // 当前记录的结果到了第几行 : 1~n

	FZ ResultAfterPutHere(int col, FZ temp) {
		int row, i;
		FZ fz;
		for (row = 0; row < currentRow; row++) {
			if (col == q[row] || Math.abs(currentRow - row) == Math.abs(col - q[row])) {// 存在冲突的皇后
				return null; // 那么就返回空
			}
		}
		// 不存在冲突的皇后，在此处摆上一个皇后，返回新的结果
		fz = new FZ();
		fz.q = new int[temp.q.length];
		fz.currentRow = currentRow + 1;
		for (i = 0; i < currentRow; i++) {// 复制前面的皇后摆放情况
			fz.q[i] = temp.q[i];
		}
		fz.q[currentRow] = col;// 摆上新的皇后
		return fz;
	}

	ArrayList<Integer> place(int n){
		ArrayList<Integer> als = new ArrayList<>();
		Queue<FZ> queue = new LinkedList<>();
		FZ fz, fzNew;
		for (int i = 0; i < n; i++) {// 把第一排的n种摆法都放进队列
			fz = new FZ();
			fz.q = new int[n];
			fz.q[0] = i;
			fz.currentRow = 1;
			queue.add(fz);
		}
		
		while (!queue.isEmpty()) {// 处理每一种情况，直到找出结果
			fz = queue.peek(); // 取出排在最前面的
			queue.poll();
			for (int i = 0; i < n; i++) {
				fzNew = fz.ResultAfterPutHere(i, fz);
				if (fzNew != null) {// 不冲突
					if (fzNew.currentRow == n){ // 看是否已经摆完了N皇后,如果摆放完毕
						for (i = 0; i < fzNew.currentRow; i++){
							als.add(fzNew.q[i] + 1);
						}
						if(als.size()==2*n){
							return als;
						}
					}else{
						queue.add(fzNew);// 没有摆完就进队列继续摆
					}
				}
			}
			//fz = null;
		}
		return als;
	}
}