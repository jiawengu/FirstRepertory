package com.guxiagufei.math;

import java.math.BigDecimal;

public class ReserveValidNum {
	public static void main(String[] args) {
		double f1 = 918;
		double f2 = 1650;
		double f3 = f1/f2;
		BigDecimal bd = new BigDecimal(f3);
		double f = bd.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println(f);
	}
	
	public static double getAid(double d, double x){
		double d2 = d/x;
		BigDecimal bd = new BigDecimal(d2);
		return bd.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}
