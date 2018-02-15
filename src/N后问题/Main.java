package N∫ÛŒ Ã‚;

import java.util.ArrayList;

public class Main {
	public static void main(String args[]){
		HZ a=new HZ(6);
		//HP b=new HP.nQueen(6);
		FZ fz =new FZ();
		ArrayList<Integer> list1=a.queen(1);
		//ArrayList<Integer> list2=b.backtrack(1);
		ArrayList<Integer> list3=FP.diaoyong(6);
		ArrayList<Integer> list4=fz.place(6);
		System.out.println(list1);
		System.out.println(new HP().nQueen(6));
		System.out.println(list3);
		System.out.println(list4);
	}
}
