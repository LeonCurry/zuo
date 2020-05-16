package book_chapter4_dynamicprogram;

import java.util.Comparator;

public class Envelope {
	public int len;
	public int wid;
	public Envelope(int len, int wid) {
		this.len = len;
		this.wid = wid;
	}
}
class EnvelopeComparator implements Comparator<Envelope>{
	
	@Override
	public int compare(Envelope o1, Envelope o2) {
		return o1.len != o2.len? o1.len - o2.len : o2.wid - o1.wid;		
	}
}
