package services;

import java.util.List;

public class Display {

	public static <T> void showData(List<T> data) 
	{
		for(int i=0; i<data.size();i++) 
		{
			System.out.println(data.get(i));
		}
		
		
	}
	

	public static <T> void showData(T[] data) {
		for(int i=0; i<data.length;i++) {
			System.out.println(data[i]);
		}
		
		
	}
	
	public static <T> void showData(T data) {
			System.out.println(data);
	}
}
