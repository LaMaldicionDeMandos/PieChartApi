package com.zauberlabs.android.api.piechart;

public interface DataAdapter<T> {
	T getItemAt(int position);
	float getValueAt(int position);
	String getLabelAt(int position);
	int getColorAt(int position);
	int size();
}
