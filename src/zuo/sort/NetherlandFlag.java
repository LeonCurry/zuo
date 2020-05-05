package zuo.sort;

public class NetherlandFlag {
	public void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	public int[] partition(int[] array, int l, int r, int target) {
		int less = l-1;
		int more = r+1;
		while(l<more) {
			if(array[l]<target) {
				swap(array, ++less, l++);
			}else if(array[l]>target) {
				swap(array, l, more--);
			}else {
				l++;
			}
		}
		return new int[] {less+1, more-1};
	}
}
