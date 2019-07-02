package sort;

public class SelectionSort extends AbstractSort {
	public void sort() {
		for(int i = 0; i <sortArray.length - 1; i++) {// 做第i趟排序
            int k = i;
            for(int j = k + 1; j < sortArray.length; j++){// 选最小的记录
                if(sortArray[j] < sortArray[k]){ 
                    k = j; //记下目前找到的最小值所在的位置
                }
            }
            //在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
            if(i != k){  //交换a[i]和a[k]
                int temp = sortArray[i];
                sortArray[i] = sortArray[k];
                sortArray[k] = temp;
            }    
        }
	}
}

