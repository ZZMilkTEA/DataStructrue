package sort;

public class BinarySort extends AbstractSort {

	 public void sort(){
	        for(int i=1; i<sortArray.length; i++){  
	            int tmp = sortArray[i];     
	            int low = 0;  
	            int high = i-1;		//每次排序将tmp插入到本次循环中low与high之间的位置

				// 不断折半，寻找合适的插入位置
	            while(low <= high){  	//low>high时说明已找到正确的待插入位置,为low
	                int mid = (low + high) / 2;  //得到该段中间位置，low-mid都比mid小或等于，mid-high都比mid大

	                if(tmp>sortArray[mid]){  
	                    low = mid + 1;  	//如果待排序的值比mid位置的值大，下次往右边（大于mid位置的值）一半的数组找
	                }else{  
	                    high = mid - 1; 	//反之往左找
	                }  
	            }

				// 依次将待插入位置后面至[待插入的元素位置-1]的元素后移一位，让带插入位置腾空来插入正确的值
	            for(int j=i; j>low ; j--){  
	            	sortArray[j] = sortArray[j-1];  
	            }  

	            sortArray[low] = tmp;    
	        }
	}
}
