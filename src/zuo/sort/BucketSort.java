package zuo.sort;

public class BucketSort {
	public void bucketSort(int[] array) {
		if(array==null||array.length<2) {
			return;
		}
		int max=Integer.MAX_VALUE;
		for(int i=0;i<array.length;i++) {
			max=Math.max(max, array[i]);
		}
		int[] bucket=new int[max+1];
		for(int i=0;i<array.length;i++) {
			bucket[array[i]]++;
		}
		int j=0;
		for(int i=0;i<bucket.length;i++) {
			while(bucket[i]-->0) {
				array[j++]=i;
			}
		}
	}
}
