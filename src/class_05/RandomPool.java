package class_05;

import java.util.HashMap;

public class RandomPool {
	public static class Pool<K>{
		private HashMap<K, Integer> keyIndexMap;
		private HashMap<Integer, K> indexKeyMap;
		private int size;
		public Pool(){
			this.keyIndexMap = new HashMap<K, Integer>();
			this.indexKeyMap = new HashMap<Integer, K>();
			size = 0;
		}
		
		public void insert(K key) {
			if(!keyIndexMap.containsKey(key)) {
				this.keyIndexMap.put(key, this.size);
				this.indexKeyMap.put(this.size++, key);
			}
		}
		
		public void delete(K key) {
			int deleteIndex = this.keyIndexMap.get(key);
			int lastIndex = --this.size;
			K lastKey = this.indexKeyMap.get(lastIndex);
			this.keyIndexMap.put(lastKey, deleteIndex);
			this.indexKeyMap.put(deleteIndex , lastKey);
			this.keyIndexMap.remove(key);
			this.indexKeyMap.remove(lastIndex);
		}
		
		public K getRandom() {
			if(size == 0) {
				return null;
			}
			int random = (int) Math.random() * this.size;
			return indexKeyMap.get(random);
		}
	}
}
