package book_chapter4_dynamicprogram;

import java.util.Arrays;

public class EnvelopeClass {
	public static Envelope[] getSortedEnvelopes(int[][] matrix) {
		Envelope[] res = new Envelope[matrix.length];
		for(int i = 0 ; i < res.length; i++) {
			res[i] = new Envelope(matrix[i][0], matrix[i][1]);
		}
		Arrays.sort(res, new EnvelopeComparator());
		return res;
	}
	public static int maxEnvelopes(int[][] matrix) {
		Envelope[] envelopes = getSortedEnvelopes(matrix);
		int[] ends = new int[envelopes.length];
		ends[0] = envelopes[0].wid;
		int l = 0;
		int r = 0;
		int m = 0;
		int right = 0;
		for(int i = 1 ; i < envelopes.length ;i++) {
			r = right;
			l = 0;
			while(l <= r) {
				m = (l+r) /2;		
				if(envelopes[i].wid > ends[m]) {
					l = m + 1;
				}else {
					r = m - 1;
				}
			}
			right = Math.max(right, l);
			ends[i] = envelopes[i].wid;
		}
		return right + 1;
		
	}
}	

