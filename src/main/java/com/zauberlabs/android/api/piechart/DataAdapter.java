package com.zauberlabs.android.api.piechart;

public interface DataAdapter<T> {
	
	/**
	 * Return the original object by the index
	 * @param position 
	 * @return  
	 */
	T getItemAt(int position);
	
	/**
	 * Return the value to calculate the pieArea relative to the item with the "position" index
	 * @param position
	 * @return 
	 */
	float getValueAt(int position);
	
	/**
	 * Return the label to show relative to the item with the "position" index
	 * @param position
	 * @return 
	 */
	String getLabelAt(int position);
	
	/**
	 * Return the color to show relative to the item with the "position" index
	 * @param position
	 * @return
	 */
	int getColorAt(int position);
	
	/**
	 * Total items count to show
	 * @return
	 */
	int size();
}
