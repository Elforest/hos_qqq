package com.qqq.test;

import com.qqq.runnable.Runnable1;

public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable1 rnb1 = new Runnable1();
		Thread th = new Thread(rnb1);
		th.start();
	}
}
