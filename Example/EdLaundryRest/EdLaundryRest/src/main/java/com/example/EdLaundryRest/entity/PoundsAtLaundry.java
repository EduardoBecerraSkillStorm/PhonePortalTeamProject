package com.example.EdLaundryRest.entity;

public class PoundsAtLaundry {
	

	private static Integer leftAtLaundry = 0;

	public static Integer getLeftAtLaundry() {
		return leftAtLaundry;
	}

	public static void setLeftAtLaundry(Integer leftAtLaundry) {
		PoundsAtLaundry.leftAtLaundry = leftAtLaundry;
	}

}
