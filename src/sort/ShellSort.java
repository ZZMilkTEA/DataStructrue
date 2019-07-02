package sort;

public class ShellSort extends AbstractSort {
	public void sort(){
        if(sortArray == null || sortArray.length <= 1){
            return;
        }
        //初始化增量
        int gap = 1;
        while (gap * 3 + 1 < sortArray.length) {
            gap = gap * 3 + 1;
        }

        while (gap > 0) {
            for (int i = gap; i < sortArray.length; i++) {
                int tmp = sortArray[i];
                int j = i - gap;
                while (j >= 0 && sortArray[j] > tmp) {  //若当前向前比较的数比基准大，则移位出空位为基准数插入
                    sortArray[j + gap] = sortArray[j];
                    j -= gap;
                }
                sortArray[j + gap] = tmp;           //插入
            }
            gap = (int) Math.floor(gap / 3);
        }
    }
}
