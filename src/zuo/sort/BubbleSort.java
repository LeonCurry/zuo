package zuo.sort;

public class BubbleSort {
	public static void bubbleSort(int[] array) {
		if(array.length<2||array==null) {
			return;
		}
		
		for(int e=array.length-1;e>0;e--) {
			for(int i=0;i<e-1;i++) {
				if(array[i]>array[i+1]) {
					swap(array, i, i+1);
				}
			}
		}
		
	}
	public static void swap(int[] array, int i, int j) {
		int temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}
}
