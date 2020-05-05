package class3;

public class ArrayToStackAndQueue {
	public static class ArrayToStack{
		 private Integer[] arr;
		 private Integer size;
		 public ArrayToStack(int initSize) {
			 if(initSize<0) {
				 throw new IllegalArgumentException("The init size is less than 0");
			 }
			 arr=new Integer[initSize];
			 size=0;
		 }
		 public Integer peek() {
			 if(size==0) {
				 return null;
			 }
			 return arr[size-1];
		 }
		 public void push(int obj) {
			 if(size==arr.length) {
				 throw new ArrayIndexOutOfBoundsException("The queue is full");
			 }
			 arr[size++]=obj;
		 }
		 public int pop() {
			 if(size==0) {
				 throw new ArrayIndexOutOfBoundsException("The queue is empty");
			 }
			 return arr[--size];
		 }
	}
	
	public static class ArrayToQueue{
		private Integer[]	arr;
		private Integer size;
		private Integer start;
		private Integer end;
		
		public ArrayToQueue(int initSize) {
			if(initSize<0) {
				throw new IllegalArgumentException("The init size is less than 0");
			}
			arr=new Integer[initSize];
			size=0;
			start=0;
			end=0;
		}
		public Integer peed() {
			if(size==0) {
				return null;
			}
			return arr[start];
		}
		public void push(int obj) {
			if(size==arr.length) {
				throw new ArrayIndexOutOfBoundsException("The queue is full");
			}
			size++;
			arr[end]=obj;
			end=end==arr.length-1?0:end+1;
		}
		public int poll() {
			if(size==0) {
				throw new ArrayIndexOutOfBoundsException("The queue is empty");
			}
			size--;
			int temp=start;
			start=start==arr.length-1?0:start+1;
			return arr[temp];
		}
	}
}
