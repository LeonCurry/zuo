package leon.tree;

public class Recur {
	//ǰ�����
	public void preOrderRecur(Node head) {
		if(head==null) {
			return;
		}
		System.out.println(head.val+" ");
		preOrderRecur(head.left);
		preOrderRecur(head.right);
	}
	
	//�������
	public void inOrderRecur(Node head) {
		if(head==null) {
			return ;
		}
		inOrderRecur(head.left);
		System.out.println(head.val);
		inOrderRecur(head.right);
	}
	//�������
	public void posOrderRecur(Node head) {
		if(head==null) {
			return;
		}
		posOrderRecur(head.left);
		posOrderRecur(head.right);
		System.out.println(head.val);
	}
}
