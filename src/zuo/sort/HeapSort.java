package zuo.sort;

public class HeapSort {
	public void heapSort(int[] array) {
		if(array==null||array.length<2) {
			return;
		}
		for(int i=0;i<array.length;i++) {
			heapInsert(array, i);
		}
		int size=array.length;
		swap(array, 0, --size);
		while(size>0) {
			heapify(array, 0, size);
			swap(array, 0, --size);
		}
	}
	public void heapInsert(int[] array, int index) {
		while(array[index]>array[(index-1)/2]) {
				swap(array, index, (index-1)/2);
				index=(index-1)/2;
		}
	}
	public void heapify(int[] array, int index, int size) {
		int left = index*2+1;
		while(left<size) {
			int large=array[left+1] > array[left] && (left+1) < size ? left+1 : left;
			large=array[large]>array[index] ? large : index;
			if(index==large) {
				break;
			}
			swap(array, large, index);
			index=large;
			left=index*2+1;
		}
	}
	public void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
}
