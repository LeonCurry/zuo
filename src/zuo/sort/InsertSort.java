package zuo.sort;

public class InsertSort {
	public static void insertSort(int[] array) {
		if(array.length<2||array==null) {
			return;
		}
		for(int i=1;i<array.length;i++) {
			for(int j=i-1;j>=0&&array[j]>array[j+1];j--) {
				swap(array, j, j+1);
			}
		}
	}
	public static void swap(int[] array, int i, int j) {
		int temp=array[i];
		array[i]=array[j];
		array[j]=temp;
		
//		array[i]=array[i]^array[j];
//		array[j]=array[i]^array[j];
//		array[i]=array[i]^array[j];
	}
}
