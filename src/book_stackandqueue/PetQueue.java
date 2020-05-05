package book_stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class PetQueue {
	public  class Pet{
		private String type;
		public Pet(String type) {
			this.type = type;
		}
		public String getType() {
			return this.type;
		}
	}
	public  class Dog extends Pet{
		public Dog() {
			super("dog");
		}
	}
	public  class Cat extends Pet{
		public Cat() {
			super("cat");
		}
	}
	public  class PetEntry{
		private Pet pet;
		private long index;
		public PetEntry(Pet pet, long index) {
			this.pet = pet;
			this.index = index;
		}
		public long getIndex() {
			return this.index;
		}
		public Pet getPet() {
			return this.pet;
		}
		public String getEntryType() {
			return this.pet.getType();
		}
	}
	public class DogCatQueue{
		private Queue<PetEntry> dogQ;
		private Queue<PetEntry> catQ;
		private long index;
		public DogCatQueue() {
			this.dogQ = new LinkedList<PetEntry>();
			this.catQ = new LinkedList<PetEntry>();
			this.index = 0;
		}
		
		public void add(Pet pet) {
			if(pet.getType().equals("dog")) {
				this.dogQ.add(new PetEntry(pet, this.index++));
			}else if(pet.getType().equals("cat")) {
				this.catQ.add(new PetEntry(pet, this.index++));
			}else {
				throw new RuntimeException("err, not dog or cat");
			}
		}
		public Pet pollAll() {
			if(!this.dogQ.isEmpty() && !this.catQ.isEmpty()) {
				if(this.dogQ.peek().getIndex() < this.catQ.peek().getIndex()) {
					return this.dogQ.poll().getPet();
				}else {
					return this.catQ.poll().getPet();
				}
			}else if(!this.dogQ.isEmpty()) {
				return this.dogQ.poll().getPet();
			}else if(!this.catQ.isEmpty()) {
				return this.catQ.poll().getPet();
			}else {
				throw new RuntimeException("err, queue is empty!");
			}
		}
		public Dog pollDog() {
			if(this.dogQ.isEmpty()) {
				throw new RuntimeException("Dog queue is empty!");
			}
			return (Dog) this.dogQ.poll().getPet();
		}
		public Cat pollCat() {
			if(this.dogQ.isEmpty()) {
				throw new RuntimeException("Cat queue is empty!");
			}
			return (Cat) this.catQ.poll().getPet();
		}
		public boolean isEmpty() {
			return isDogEmpty() && isCatEmpty();
		}
		public boolean isDogEmpty() {
			return this.dogQ.isEmpty();
		}
		public boolean isCatEmpty() {
			return this.catQ.isEmpty();
		}
		
	}
	
}
