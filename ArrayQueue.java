
// THIS IS THE ARRAYQUEUE
public class ArrayQueue<T> implements  Queue<T>
{

	protected T[] arr;
	protected int size;
	protected int head;
	protected int tail;
	protected int count;
    
    //constuctor to set the size, the start place of head and tail, the count of the contents and initiate the array
	public ArrayQueue()
	{
		size = 10;
		head = tail = 0;
		count = 0;
		arr = (T[]) new Object[size];
	}

	// to delete a T from the head of the array
	public T dequeue()
	{
		if(empty())
		{
			throw new Exception("Error!");
		}
		T temp = arr[head];
		head = (head+1)%size;
		count--;
		return temp;
	}

	// to add a T to the tail of the array, if the space is not enough, the grow_array will help double the size
	public void enqueue(T item)
	{
		if(count == size)
		{
			grow_array();
		}
		arr[tail] = item;
		tail = (tail+1)%size;
		count++;
	}

	// a boolean to check if the queue is empty
	public boolean empty()
	{
		return count == 0;
	}

	// the function to double the size of the array, and copy the orginal contents to the new array
	public void grow_array()
	{
		T[] newArr = (T[]) new Object[size*2];
		for (int i = 0; i < size; i++)
		{
			newArr[i] = arr[(head+i)%size];
		}
		arr = newArr;
		head = 0;
		tail = size;
		size = size*2;		
		
	}
}