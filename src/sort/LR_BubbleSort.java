package sort;

public class LR_BubbleSort extends AbstractSort{
	
		public static void sameTime(int numbers[]) { //一个数字两边同时判断，区间两边同时缩小的方法
			int left=0;
			int right=numbers.length-1;
			int minNumber=0;
			int maxNumber=0;
			int min=0;
			int max=0;
			int a=0;

			for(;left+1<=right;) {
				min=left;
				max=right;
				minNumber=numbers[left];
				maxNumber=numbers[right];   //为防止排序时左右出冲突，故准备了这四个变量
				for (int i=left;i<=right;i++) {
					if(numbers[i]<=minNumber) {min=i;minNumber=numbers[i];}
					else if(numbers[i]>=maxNumber) {max=i;maxNumber=numbers[i];}
				}
				a=numbers[left];numbers[left]=numbers[min];numbers[min]=a;
				a=numbers[right];numbers[right]=numbers[max];numbers[max]=a;
				left++;
				right--;
			}
		}
	
		public static void alternation(int numbers[]) {  //先向右排小，到头再向左排大的方法
			int left=0;
			   int right=numbers.length-1;
			   int minNumber=0;
			   int maxNumber=0;
			   
			   for(;left+1<=right;) {   
				   for(int i=left;i<=right;i++)
					   if (numbers[i]<=numbers[left]) {minNumber=numbers[left];numbers[left]=numbers[i];numbers[i]=minNumber;}
			   left++;  //向右排小
				   for(int i=right;i>=left;i--)
					   if (numbers[i]>=numbers[right]) {maxNumber=numbers[right];numbers[right]=numbers[i];numbers[i]=maxNumber;}
			   right--;  //向左排大
			   }
}
		
		@Override
		public void sort()	{     //这里搬来了先向右排小，到头再向左排大的方法_(:з)∠)_，因为代码总体相对小些
			int left=0;
			   int right=sortArray.length-1;
			   int minNumber=0;
			   int maxNumber=0;
			   
			   for(;left+1<=right;) {   
				   for(int i=left;i<=right;i++)
					   if (sortArray[i]<=sortArray[left]) {
					   	minNumber=sortArray[left];sortArray[left]=sortArray[i];sortArray[i]=minNumber;
					   }
			   left++;  //向右排小
				   for(int i=right;i>=left;i--)
					   if (sortArray[i]>=sortArray[right]) {
					   	maxNumber=sortArray[right];sortArray[right]=sortArray[i];sortArray[i]=maxNumber;
					   }
			   right--;  //向左排大
			   }
		}
	   public static void main(String[] args) {  //测试部分
		   int numbers[]=new int[100];
		   
		   
		   for(int i = 0;i<=numbers.length-1;i++) {
			   numbers[i]=(int) (Math.random()*100);
		   }
		   for(int i = 0;i<=numbers.length-1;i++) {
				  System.out.print(numbers[i]+" ");
			   }	
		   System.out.println();
		   System.out.println();

		   alternation(numbers);
		   
		   
		   for(int i = 0;i<=numbers.length-1;i++) {
			  System.out.print(numbers[i]+" ");
		   }	
		   
	}
}

