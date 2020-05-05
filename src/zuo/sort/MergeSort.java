package zuo.sort;

public class MergeSort {
	public static void  mergeSort(int[] array) {
		if(array==null||array.length<2) {
			return;
		}
		mergePro(array, 0, array.length-1);
	}
	public static void mergePro(int[] array, int l , int r) {
		if(l==r) {
			return;
		}
		int mid = l + ((r-l)>>1);
		mergePro(array, l, mid);
		mergePro(array, mid+1, r);
		mergeOne(array, l, mid, r);
	}
	public static void mergeOne(int[] array, int l, int mid, int r) {
		int[] help=new int[r-l+1];
		int k=0;
		int p1=l;
		int p2=mid+1;
		while(p1<=mid&&p2<=r) {
			help[k++]=array[p1]<array[p2]?array[p1++]:array[p2++];
		}
		while(p1<=mid) {
			help[k++]=array[p1++];
		}
		while(p2<=r) {
			help[k++]=array[p2++];
		}
		for(int i=0;i<help.length;i++) {
			array[l+i]=help[i];
		}
	}
}
