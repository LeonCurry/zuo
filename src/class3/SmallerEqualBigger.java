package class3;



public class SmallerEqualBigger {
	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}
	
	public static Node listPartition1(Node head, int pivot) {
		if(head==null) {
			return head;
		}
		int i=0;
		Node cur=head;
		while(cur!=null) {
			i++;
			cur=cur.next;
		}
		Node[] nodeArr=new Node[i];
		i=0;
		cur=head;
		for(i=0;i<nodeArr.length;i++) {
			nodeArr[i] = cur;
			cur=cur.next;
		}
		
		arrPartition(nodeArr, pivot);
		for(i=1;i!=nodeArr.length;i++) {
			nodeArr[i-1].next=nodeArr[i];
		}
		nodeArr[i-1].next=null;
		return nodeArr[0];
	}
	
	public static void arrPartition(Node[] arr, int pivot) {
		int small=-1;
		int big=arr.length;
		int index=0;
		while(index!=big) {
			if(arr[index].value<pivot) {
				swap(arr, ++small, index++);
			}else if(arr[index].value==pivot) {
				index++;
			}else {
				swap(arr, --big, index++);
			}
		}
	}
	
	public static void swap(Node[] nodeArr, int a, int b) {
		Node tmp = nodeArr[a];
		nodeArr[a] = nodeArr[b];
		nodeArr[b] = tmp;
	}
	
	public static Node listPartition2(Node head, int pivot) {
		Node sH=null;
		Node sT=null;
		Node eH=null;
		Node eT=null;
		Node bH=null;
		Node bT=null;
		Node next=null;
		while(head!=null) {
			next=head.next;
			if(head.value<pivot) {
				if(sH==null) {
					sH=head;
					sT=head;
				}else {
					sT.next=head;
					sT=head;
				}
			}else if(head.value==pivot) {
				if(eH==null) {
					eH=head;
					eT=head;
				}else {
					eT.next=head;
					eT=head;
				}
			}else {
				if(bH==null) {
					bH=head;
					bT=head;
				}else {
					bT.next=head;
					bT=head;
				}
			}
			head=next;
		}
		if(sT!=null) {
			sT.next=eH;
			eT=eT==null?sT:eT;
		}
		if(eT!=null) {
			eT.next=bH;
		}
		return sH!=null?sH:eH!=null?eH:bH;
	}
}
