package sxa190016;

/**
 * @author sxa190016
 * @author bsv180000
 * @version 1.0 Bounded Queue: Short project 2
 * 				Generic Bounded Queue using arrays
 * 				which can be initialized with the capacity
 * 				of the queue.
 */

public class BoundedQueue<T> {
	
	/**
	 * Generic array which stores the values
	 */
	private T[] arr;
	
	/**
	 * Variable which stores the location of the first item in the array.
	 * Items are polled from the front.
	 */
	private int front;
	
	/**
	 * Variable which stores the location of the last item in the array.
	 * Items are offered at the end.
	 */
	private int end;
	
	/**
	 * Variable which stores the current size of the queue.
	 */
	private int size;
	
	/**
	 * Constructor which initializes all the member variables 
	 * and creates a generic array of the required capacity.
	 * 
	 * @param capacity	The full capacity or size of the queue
	 */
	@SuppressWarnings("unchecked")
	public BoundedQueue(int capacity) {
		this.arr = (T[]) new Object[capacity];
		this.front = 0;
		this.end = 0;
		this.size = 0;
		
	}
	
	/**
	 * Stores a generic item x at the end of the array if it is not full.
	 * 
	 * @param x			Contains the value of the item to be stored in the queue
	 * @return			True if operation is successful else False
	 */
	public boolean offer(T x) {
		//Checks if the queue is already full and returns false if it is
		if (this.size == this.arr.length) {
			return false;
		}
		this.arr[this.end] = x;
		//Increment the end variable in a circular fashion
		this.end = (this.end+1)%this.arr.length;
		this.size++;
		return true;
	}
	
	/**
	 * Removes the generic item stored at the front of the queue if not empty.
	 * 
	 * @return			The value of the item at the front if queue is not empty
	 */
	public T poll() {
		//Call the peek function to get the item at the front
		T item = this.peek();
		if (item != null) {
			this.size--;
			//Increment the front variable in a circular fashion
			this.front = (this.front+1)%this.arr.length;
		}
		return item;
	}
	
	/**
	 * Returns the item at the front of the queue, if it is not empty,
	 * without removing it from the queue
	 * 
	 * @return			The value of the item at the front if queue is not empty
	 */
	public T peek() {
		if (this.size == 0) {
			return null;
		}
		T item = this.arr[this.front];
		return item;
	}
	
	/**
	 * Get the current size of the queue
	 * 
	 * @return			The number of items currently in the queue 
	 */
	public int size() {
		return this.size;
	}
	
	/**
	 * Checks if the queue is empty or not
	 * 
	 * @return			True if the queue is empty else False
	 */
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	/**
	 * Clears all the items in the queue.
	 */
	public void clear() {
		this.front = 0;
		this.end = 0;
		this.size = 0;
	}
	
	/**
	 * Fill the generic array with the items in the queue
	 * 
	 * @param a			The array to be filled with the items in the queue
	 */
	public void toArray(T[] a) {
		int start = this.front;
		
		//Save each item from the front to the end in the array "a"
		for(int i=0; i<this.size; i++) {
			a[i] = this.arr[start];
			//Loop over the queue in a circular fashion
			start = (start+1)%this.arr.length;
		}
	}

	/**
	 * main function to test the BoundedQueue class
	 * 
	 * @param args		Arguments to be passed to the main function
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**
		 * An object of the BoundedQueue class
		 */
		BoundedQueue<Integer> bq = new BoundedQueue<Integer>(5);
		
		/**
		 * An integer array to be passed to the toArray method
		 */
		Integer[] result = new Integer[5];
		
		//Insert items in the queue
		System.out.println(bq.offer(1));
		System.out.println(bq.offer(2));
		System.out.println(bq.offer(3));
		
		//Check the size of the queue
		System.out.println(bq.size());
		
		//Check if the queue is empty
		System.out.println(bq.isEmpty());
		
		//Remove the items from the queue
		System.out.println(bq.poll());
		System.out.println(bq.poll());
		System.out.println(bq.poll());
		
		//Check if it is empty
		System.out.println(bq.isEmpty());
		
		//Try to remove still more items
		System.out.println(bq.poll());
		System.out.println(bq.poll());
		System.out.println(bq.poll());
		
		//Check if it is still empty
		System.out.println(bq.isEmpty());
		
		//Insert more items in the queue
		System.out.println(bq.offer(4));
		System.out.println(bq.offer(5));
		System.out.println(bq.offer(6));
		System.out.println(bq.offer(7));
		
		//Check the size of the queue
		System.out.println(bq.size());
		
		//Try to insert 1 more item in the queue
		System.out.println(bq.offer(8));
		
		//Check the size of the queue now
		System.out.println(bq.size());
		
		//Try to insert few more items
		System.out.println(bq.offer(9));
		System.out.println(bq.offer(0));
		
		//Clear the queue
		bq.clear();
		
		//Check the size of the queue now
		System.out.println(bq.size());
		
		//Convert and save the array in an integer array 
		bq.toArray(result);
		
		//Print the array
		for(Integer a : result) {
			System.out.print(a+" ");
		}
		
		//Try some items
		System.out.println(bq.offer(9));
		System.out.println(bq.offer(0));
		
		//Convert and save the array in the integer array 
		bq.toArray(result);
		
		//Print the array
		for(Integer a : result) {
			System.out.print(a+" ");
		}
	}

}
