package com.bergerkiller.bukkit.common;

import java.util.Arrays;

import net.minecraft.server.MathHelper;

public class IntRemainder {
	
	private double contained = 0;
	private int counter = 0;
	private final int[] values;
	public IntRemainder(double initialvalue, int decimals) {
		if (decimals < 1) {
			throw new IllegalArgumentException("Decimal count needs to be higher than 0");
		}
		this.values = new int[10 * decimals];
		this.set(initialvalue);
	}
	
	public void set(double value) {
		this.contained = value;
		//set floor
		int floor = MathHelper.floor(value);
		Arrays.fill(this.values, floor);
		//get remainder (1.2 -> .2)
		floor = (int) ((value - floor) * this.values.length);
		for (int i = 0; i < floor; i++) {
			this.values[i]++;
		}
	}
	
	public int next() {
		counter++;
		if (counter > this.values.length - 1) {
			counter = 0;
		}
		return this.values[counter];
	}
	
	public double get() {
		return this.contained;
	}
	
	public int[] getValues() {
		return this.values;
	}

}
