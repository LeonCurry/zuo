package book_stackandqueue;

import java.util.Scanner;
import java.util.Stack;

class Record {
	public int value;
	public int time;
	public Record(int value) {
		this.value = value;
		this.time = 1;
	}
}
public class GetVisibleNum {
	public static int getVisibleNum(int[] arr) {
		if(arr == null || arr.length < 2) {
			return 0;
		}
		//�����ֵλ��
		int maxIndex = 0;
		int size = arr.length;
		for(int i = 0 ; i < size ; i++) {
			maxIndex = arr[i] > arr[maxIndex] ? i : maxIndex;
		}
		//�����ֵλ�÷���ջ��
		Stack<Record> stack = new Stack<Record>();
		stack.push(new  Record(arr[maxIndex]));
		//�����ֵλ�õ���һ��λ�ÿ�ʼ����next�������
		int index = nextIndex(maxIndex, size);
		//�á�С�Ҵ� �ķ�ʽͳ�����пɼ�ɽ���
		int res = 0;
		//�����׶ο�ʼ����index�ٴλص�maxIndex��ʱ��˵��ת��һȦ�������׶ν���
		while(index != maxIndex) {
			//��ǰ����arr[index]Ҫ��ջ���жϻ᲻���ƻ���һά�����ִԶ��������α��
			//����ƻ��ˣ������ε���ջ����¼��������ɽ�������
			while(stack.peek().value < arr[index]) {
				int k = stack.pop().time;
				//������¼Ϊ��X,K�������K==1������2��
				//���K>1,����2*K+C��2��K��
				res += getInternalSum(k) + 2 * k;
			}
			//�������ݼ���ջ�������ջ��һ���ͺϲ��������һ����Ҫ���µķ���ջ��
			if(stack.peek().value == arr[index]) {
				stack.peek().time++;
			}else {
				stack.push(new Record(arr[index]));
			}
			index =  nextIndex(index, size);		
		}
		//����׶ε�һ�׶�
		while(stack.size()>2) {
			int  time = stack.pop().time;
			res += getInternalSum(time) + 2*time;
		}
		//�ڶ��׶Σ�����ײ�M==1�������1*time������Ϊ2*time
		if(stack.size() == 2) {
			int time = stack.pop().time;
			res += getInternalSum(time) +((stack.peek().time ==1) ? time : (2 * time));
		}
		//�����׶�
		res += getInternalSum(stack.pop().time);
		return res;
	}
	
	//���������е�ǰλ��Ϊi���������size-1ʱ���ͻص������0λ�ÿ�ʼ������ֱ��maxIndex
	public static int nextIndex(int i, int size) {
		return i < (size -1) ? (i+1):0;
	}
	//���k==1,����0��k>1,����C(2,K)
	public static int getInternalSum(int k) {
		return k==1 ? 0 : (k*(k - 1) / 2);
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = Integer.valueOf(in.nextLine());
		String[] data = in.nextLine().split(" ");
		int[] arr = new int[num];
		for(int i = 0 ; i < num ; i++) {
			arr[i] = Integer.valueOf(data[i]);
		}
		int result = getVisibleNum(arr);
		System.out.println(result);
	}
}
