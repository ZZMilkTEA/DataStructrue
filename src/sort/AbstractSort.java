package sort;

import java.io.*;

public abstract class AbstractSort {
	private static int[] originalArray;
	protected int[] sortArray;
	File file=new File("result.txt");
//	FileOutputStream fos=new FileOutputStream(file);
	
	public static int inputNumber() {   //输入数字,同时判断是否为数字
		InputStream is=System.in;
		int value=0;
		int ch=0;
		try {
			while((ch =is.read()) !='\n') {
				if(ch>=48 && ch <= 57) {
					value =10 * value +ch -48;
				}
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		return value;
	}
	
	public static void createArray(int count,int range) {     //配合inputNumber方法来创建指定长度的数组,数组元素随机生成
		originalArray =new int[count];
		for (int i=0;i < originalArray.length;i++) {
			originalArray[i]=(int)(Math.random()*range);
		}
	}
	
	public void initial() {					//传递原始数组的数据到待排序数组
		sortArray =new int[originalArray.length];
		for (int i=0;i < originalArray.length;i++) {
			sortArray[i]=originalArray[i];
		}
	}
	
	public static void showOriginalArray() {		//输出原始数组
		for(int i = 0; i < originalArray.length; i++) {
			System.out.print(originalArray[i]);
			if((i + 1) % 20 == 0) {
				System.out.print("\n");
			}else {
				System.out.print("\t");
			}
		}
	}
	
	public void showArray() {			//输出排序数组，一般排完序（执行过sort方法后）使用
		for(int i = 0; i < sortArray.length; i++) {
			System.out.print(sortArray[i]);
			if((i + 1) % 20 == 0) {
				System.out.print("\n");
			}else {
				System.out.print("\t");
			}
		}
	}
	
	public abstract void sort();		//抽象声明排序方法,具体到各算法实现
}
