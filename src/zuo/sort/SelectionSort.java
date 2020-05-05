package zuo.sort;

public class SelectionSort {
	public static void selectionSort(int[] array) {
		if(array.length<2||array==null) {
			return;
		}
		for(int i=0;i<array.length-1;i++) {
			int minIndex=i;
			for(int j=i+1;j<array.length;j++) {
				minIndex = array[j] < array[minIndex] ? j : minIndex;
			}
			swap(array, i, minIndex);
		}
	}
	public static void swap(int[] array, int i, int j) {
		int temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}
}
