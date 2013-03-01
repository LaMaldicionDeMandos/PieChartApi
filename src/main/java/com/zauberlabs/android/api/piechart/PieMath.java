package com.zauberlabs.android.api.piechart;

import android.graphics.Rect;

class PieMath {
	public static Rect getCenterBounds(int width, int height){
		int min = Math.min(width, height);
		int left = (width - min)/2;
		int top = (height - min)/2;
		return new Rect(left, top, left + min, top + min);
	}
	
	public static float calculateInitAngle(float init, float total){
		return init/total*360 - 90;
	}
	
	public static float calculateAngle(float value, float total){
		return value/total*360;
	}
}
