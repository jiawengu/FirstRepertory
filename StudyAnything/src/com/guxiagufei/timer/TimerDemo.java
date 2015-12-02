package com.guxiagufei.timer;

import java.util.Date;
import java.util.Timer;

public class TimerDemo {
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new TimerTaskDemo(1), 5000);
//		TimerTaskDemo secondTask = new TimerTaskDemo(2);
//		timer.schedule(secondTask, 1000, 3000);
		Date date = new Date();
		timer.schedule(new TimerTaskDemo(3), new Date(date.getTime() + 10000));
		System.out.println("end");
	}
}
