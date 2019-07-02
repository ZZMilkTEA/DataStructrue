package sort;

public class SortTest {
	public static void main(String[] args) {
		final int SORT_TYPE_NUMBER = 7;

		long[] result_time = new long[SORT_TYPE_NUMBER];

		System.out.print("请输入数据数量:");
		int count= AbstractSort.inputNumber();
		System.out.print("请输入数据范围(0~输入数值):");
		int range= AbstractSort.inputNumber();
		AbstractSort.createArray(count, range);
		long before = 0;
		long after = 0;
		String[] className = new String[SORT_TYPE_NUMBER];
		
		AbstractSort[] sorts = new AbstractSort[SORT_TYPE_NUMBER];
		sorts[0]=new LR_BubbleSort();
		sorts[1]=new HeapSort();
		sorts[2]=new InsertSort();
		sorts[3]=new BinarySort();
		sorts[4]=new ShellSort();
		sorts[5]=new SelectionSort();
		sorts[6]=new FastSort();
		
		for(int i = 0;i < sorts.length; i++) {
			className[i] =  sorts[i].getClass().getSimpleName();
			System.out.println("\n----------------------------------------------\n" +className[i] + '\n');
			sorts[i].initial();
			before = System.currentTimeMillis();
			sorts[i].sort();
			after = System.currentTimeMillis();
			sorts[i].showArray();

			result_time[i]= after-before;

		}
		for(int i = 0;i < sorts.length; i++){
			System.out.println(className[i]+" 耗时:" + result_time[i] + "ms");
		}
	}
}
