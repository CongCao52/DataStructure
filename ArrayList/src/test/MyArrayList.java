package test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.AbstractList;

public class MyArrayList<E> {

		/*
		 * Do not change this initial capacity; it is used by our test cases
		 */
		private static final int INITIAL_CAPACITY = 4;

		/*
		 * These are protected so that test cases can access them. Please do not change
		 * the visibility of these fields!
		 */
		protected E[] data;
		protected int size = 0;

		public MyArrayList() {
			
		data = (E[]) new Object[INITIAL_CAPACITY];
		
		}

		/*
		 * Need to implement this in step 5
		 */
		public MyArrayList(E[] arr) {
			if(arr == null) {
				size = 0;
				data = (E[]) new Object[INITIAL_CAPACITY];
				System.out.print(data==null);
				
			}else {
				
			E[] newData0 = (E[]) new Object[arr.length];
			System.arraycopy(arr, 0, newData0, 0, arr.length);
			data = (E[]) newData0;	
			size = data.length;
			}
			
		}

		public E get(int index) {
			if (index < 0 || index >= size) {
				throw new IndexOutOfBoundsException();
			} else
				
				return data[index];
		}

		private void increaseCapacity() {
			E[] newData = (E[]) new Object[2 * data.length];
			System.arraycopy(data, 0, newData, 0, size);
			data = (E[]) newData;
		}

		/*
		 * This method adds the element to the list. Except for modifying it to use Java
		 * Generics, DO NOT OTHERWISE CHANGE THIS METHOD as it is used in testing your
		 * code.
		 */
		public void add(E value) {
			if (size == data.length) {
				increaseCapacity();
			}
			data[size++] = value;
		}

		public void add(int index, E element) {
			if (index < 0 || index >= size) {
				throw new IndexOutOfBoundsException();
			}
			if (size == data.length) {
				increaseCapacity();
			}
			for (int i = size - 1; i >= index; i--) {
				data[i + 1] = data[i];
			}
			data[index] = element;
			size++;
		}

		public E remove(int index) {
			int count = 0;
			if (index < 0 || index >= size) {
				throw new IndexOutOfBoundsException();
			}
			E target = data[index];
			for (int i = index; i < size - 1; i++) {
				data[i] = data[i + 1];
			}
			size--;
			data[size] = null;
			//decrease capacity
			
			for(int j =0; j<size;j++) {
				if (data[j]!=null) {count++;}
			}
			
			if(count<=0.25*data.length) {
				E[] newData1 = (E[]) new Object[(int) (0.5 * data.length)];
				System.arraycopy(data, 0, newData1, 0, size);
				data = (E[]) newData1;
			}
			
			return target;
		}

		/*
		 * Need to implement this in Step 2.
		 */
		public boolean remove(Object o) {
			if(o ==null) {return false;}
			for(int i=0; i<size; i++) {
				
				if(data[i].equals(o)) {
					int count =0;
					for (int j = i; j < size - 1; j++) {
						data[j] = data[j + 1];
					}
					size--;
					data[size] = null;
					//decrease capacity
					
					for(int k =0; k<size;k++) {
						if (data[k]!=null) {count++;}
					}
					
					if(count<=0.25*data.length) {
						E[] newData1 = (E[]) new Object[(int) (0.5 * data.length)];
						System.arraycopy(data, 0, newData1, 0, size);
						data = (E[]) newData1;
					}
					return true;	
				}		
			}
			return false;
		}
		public void print() {
			for (int i = 0; i < size; i++) {
				System.out.println(i + ": " + data[i]);
			}
		}
		
		public boolean contains(E obj) {
			for (int i = 0; i < size; i++) {
				if (obj == data[i] || (data[i] != null && data[i].equals(obj)))
					return true;
			}
			return false;
		}

		/*
		 * Need to implement this in Step 4
		 */
		public E set(int index, E obj) {
			if(obj ==null) {
				throw new NullPointerException();
			}
			if(index>=size && index<=0) { throw new ArrayIndexOutOfBoundsException(index);}
			E replaced = data[index];
			data[index] = obj;
			return replaced;
		}

		//@Override
		public int size() {
			// TODO Auto-generated method stub
			return size;
		}

	
}
