package sort;

public class InsertSort extends AbstractSort {

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		for(int i = 1; i < sortArray.length; i++) {
			insertSort(i);
		}
	}
	private void insertSort(int index) {
		int value = sortArray[index];
		int position = -1;
		for(int i = 0; i < index; i++) {
			if(value < sortArray[i]) {
				position = i;
				break;
			}
		}
		if(position != -1 && position != index) {
			for(int i = index; i > position; i--) {
				sortArray[i] = sortArray[i - 1];
			}
			sortArray[position] = value;
		}
	}
}
