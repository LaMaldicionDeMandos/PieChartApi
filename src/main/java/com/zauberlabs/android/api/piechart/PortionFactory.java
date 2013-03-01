package com.zauberlabs.android.api.piechart;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.ArcShape;

public class PortionFactory {
	public static Drawable createPiePortion(float initAngle, float angle, int color){
		ShapeDrawable portion = new ShapeDrawable(new ArcShape(initAngle, angle));
		portion.setIntrinsicHeight(1000);
		portion.setIntrinsicWidth(1000);
		portion.getPaint().setColor(color);
		return portion;
	}
}
