package com.zauberlabs.android.api.piechart;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.graphics.Rect;

import com.xtremelabs.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class MathPieChartTest {
	private Rect rect;
	@Before
	public void setUp(){
		rect = new Rect(0,1,4,5);
	}
	
	@Test
	public void testChartSize() {
		Rect res = PieMath.getCenterBounds(4, 6);
		assertEquals(rect.left, res.left);
	}
	
	@Test
	public void testFisrtAngle(){
		assertEquals(String.valueOf(-90f), String.valueOf(PieMath.calculateInitAngle(0f, 100f)));
	}
	
	@Test
	public void testAngle(){
		assertEquals(String.valueOf(10f), String.valueOf(PieMath.calculateAngle(10f, 360f)));
	}
}
