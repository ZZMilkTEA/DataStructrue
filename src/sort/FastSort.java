package sort;

public class FastSort extends AbstractSort {

    @Override
    public void sort() {
        quickSort(sortArray, 0, sortArray.length - 1);
    }

    private int[] quickSort(int[] arr, int left, int right) {       //left,right为数组下标
        if (left < right) { //递归终止条件，若不满足说明被分割的是一个“空数组”
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);       //排序上次分割后比上次基准值小的数组
            quickSort(arr, partitionIndex + 1, right);       //排序上次分割后比上次基准值大的数组
        }
        return arr;
    }

    private int partition (int[] arr,int left,int right){       //排序并返回下次分割的上界，该上界为该次基准的位置-1
        int pivot = left;   //选该段数组的第一个值为基准
        int index = pivot + 1;  //index用来分割与基准比较的值（左小右大）
        for (int i = index; i <= right; i++) {
            if (arr[pivot] > arr[i]) {      //比基准小的值将会被移到当前index位置

                swap(arr, i, index);
                index++;                    //移动完后index++，保证index左边都比基准值小
            }
        }
        swap(arr, pivot, index - 1);     //最后将基准与index-1位置的值交换，保证本次排序index-1位置的左边全小于基准值
        return index - 1;
    }

    private void swap(int[] arr, int i, int j) {    //交换数组中两下标所存的值
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
