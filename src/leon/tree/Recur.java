package leon.tree;

public class Recur {
	//前序遍历
	public void preOrderRecur(Node head) {
		if(head==null) {
			return;
		}
		System.out.println(head.val+" ");
		preOrderRecur(head.left);
		preOrderRecur(head.right);
	}
	
	//中序遍历
	public void inOrderRecur(Node head) {
		if(head==null) {
			return ;
		}
		inOrderRecur(head.left);
		System.out.println(head.val);
		inOrderRecur(head.right);
	}
	//后序遍历
	public void posOrderRecur(Node head) {
		if(head==null) {
			return;
		}
		posOrderRecur(head.left);
		posOrderRecur(head.right);
		System.out.println(head.val);
	}
}
