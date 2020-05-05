package zuo.sort;


public class QuickSort {
	public void quickSort(int[] array) {
		if(array.length<2||array==null) {
			return;
		}
		quickSort(array, 0, array.length-1);
	}
	public void quickSort(int[] array, int l, int r) {
		if(l<r) {
			swap(array, (int)(Math.random()*(r-l+1)), r);
			int[] p=partition(array, l, r);
			quickSort(array, l, p[0]-1);
			quickSort(array, p[1]+1, r);
		}
		
	}
	public int[] partition(int[] array, int l, int r) {
		int less=l-1;
		int more = r;
		while(l<more) {
			if(array[l]<array[r]) {
				swap(array, ++less, l++);
			}else if(array[l]>array[r]) {
				swap(array, --more, l);
			}else {
				l++;
			}			
		}
		swap(array, more, r);
		return new int[] {less+1, more};
	}
	public void swap(int[] array, int i, int j) {
		int temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}
	
}
