package com.guxiagufei.timer;

import java.util.TimerTask;

public class TimerTaskDemo extends TimerTask{

	private int id;
	public TimerTaskDemo(int id) {
		super();
		this.id = id;
	}
	@Override
	public void run() {
		System.out.println("线程"+ id +": 正在执行。。。");
	}
	
}
