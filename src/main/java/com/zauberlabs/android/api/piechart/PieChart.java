package com.zauberlabs.android.api.piechart;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;

public class PieChart extends View {
//	FrameLayout container;
//	ImageView pie;
	
	private DataAdapter<?> adapter;
	
	LayerDrawable pie;
	
	public PieChart(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}
	public PieChart(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}
	public PieChart(Context context) {
		super(context);
		init();
	}
	
	@Override
    protected void onDraw(Canvas canvas) {
		if(pie==null){
			super.onDraw(canvas);
			return;
		}
		for(int i = 0; i<this.adapter.size();i++){
			Drawable drawable = pie.getDrawable(i);
			drawable.setBounds(PieMath.getCenterBounds(canvas.getWidth(), canvas.getHeight()));
		}
		pie.draw(canvas);
	}
	
	
	private void init(){
		this.refresh();
	}
	
	public void refresh(){
		this.invalidate();
		if(this.adapter==null) return;
		List<PieData> list = new ArrayList<PieData>();		
		float total = buildData(list);
		Drawable[] portions = buildPortions(list, total);
		pie = new LayerDrawable(portions);
	}
	
	private Drawable[] buildPortions(List<PieData> list, float total){
		float sum = 0f;
		Drawable[] portions = new Drawable[list.size()];
		for(int i=0;i<portions.length;i++){
			portions[i] = buildPortion(sum, list.get(i), total);
			sum+=list.get(i).getValue();
		}
		return portions;
	}
	
	private Drawable buildPortion(float init, PieData data, float total){
		float initAngle = PieMath.calculateInitAngle(init, total);
		float angle = PieMath.calculateAngle(data.getValue(),total);
		return PortionFactory.createPiePortion(initAngle, angle, data.getColor());
	}
	
	private float buildData(List<PieData> list){
		float total = 0f;
		for(int i=0;i<this.adapter.size();i++){
			PieData data = new PieData(
					this.adapter.getLabelAt(i), 
					this.adapter.getValueAt(i),
					this.adapter.getColorAt(i));
			total+= data.getValue();
			list.add(data);
		}
		return total;
	}
	
	public void setDataAdapter(DataAdapter<?> adapter){
		this.adapter = adapter;
		this.refresh();
	}
	
	class PieData{
		private final float value;
		private final String label;
		private final int color;
		
		public PieData(String label, float value, int color){
			this.label = label;
			this.value = value;
			this.color = color;
			
		}

		public float getValue() {
			return value;
		}

		public String getLabel() {
			return label;
		}
		
		public int getColor(){
			return this.color;
		}
		
		@Override
		public boolean equals(Object o){
			if(!(o instanceof PieData))return false;
			PieData data = (PieData)o;
			return this.value == data.value && this.label.equals(data.label);
		}
		
		@Override
		public int hashCode(){
			return this.label.hashCode() + Float.valueOf(value).intValue();
		}
	}
}
