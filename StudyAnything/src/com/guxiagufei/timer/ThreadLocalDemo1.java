package com.guxiagufei.timer;

public class ThreadLocalDemo1 {
	
	//匿名内部类还能这样用
	private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>(){
		protected Integer initialValue() {
			return 0;
		}
	};
	
	public int getNextNum(){
		seqNum.set(seqNum.get() + 1);
		return seqNum.get();
	}
	
	public static void main(String[] args) {
		ThreadLocalDemo1 tl1 = new ThreadLocalDemo1();
		Test t1 = new Test(tl1);
		Test t2 = new Test(tl1);
		Test t3 = new Test(tl1);
		t1.start();
		t2.start();
		t3.start();
	}
	
	private static class Test extends Thread{
		private ThreadLocalDemo1 tl;
		public Test(ThreadLocalDemo1 tl){
			this.tl = tl;
		}
		@Override
		public void run() {
			for(int i = 0; i < 10; i++){
				System.out.println("Thread[" + Thread.currentThread().getName() + "]--->" + tl.getNextNum());
			}
		}
		
	}
	
	
}
