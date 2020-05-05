package zuo.sort;

public class MaxGap {
	public int maxGap(int[] nums) {
		if(nums==null||nums.length<2) {
			return 0;
		}
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		for(int i=0;i<nums.length;i++) {
			min=Math.min(min, nums[i]);
			max=Math.max(max, nums[i]);
		}
		if(max==min) {
			return 0;
		}
		int len=nums.length;
		int bid = 0;
		int[] maxs=new int[len+1];
		int[] mins=new int[len+1];
		boolean[] hasNum = new boolean[len+1];
		for(int i=0;i<len;i++) {
			bid=bucket(nums[i], len, max, min);
			maxs[bid]=hasNum[i]?Math.max(nums[i], maxs[i]) : nums[i];
			mins[bid]=hasNum[i]?Math.min(nums[i], mins[i]) : nums[i];
			hasNum[i]=true;
		}
		int res=0;
		int lastMax=maxs[0];
		int i=1;
		for( ;i<=len;i++) {
			if(hasNum[i]) {
				res=Math.max(res, mins[i]-lastMax);
				lastMax=maxs[i];
			}
		}
		return res;
	}
	public int bucket(int num, int len, int max, int min) {
		return (int) ((num-min)*len/(max-min));
	}
}
