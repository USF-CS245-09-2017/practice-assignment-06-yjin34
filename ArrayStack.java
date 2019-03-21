
// This is the ArrayStack
public class ArrayStack<T> implements Stack<T>
{

	protected T[] arr;
	protected int top;
	protected int size;

	// the constuctor to set the size, the start position of top and initiate the array
	ArrayStack()
	{
		size = 10;
		arr = (T[]) new Object[size];
		top = -1;
	}

	// push a item to the top
	public void push(T item)
	{
		if (top == size-1)
		{
			grow_array();
		}
		arr[++top] = item;
	}

	// delete a item from the top
	public T pop()
	{
		if (empty())
		{
			throw new Exception("Error!");
		}
		return arr[top--];
	}

	// return the item at the top
	public T peek()
	{
		if (empty())
		{
			throw new Exception("Error!");
		}

		return arr[top];
	}

	// a boolean to check if the array if empty
	public boolean empty()
	{
		return top == -1;
	}

	// to double the size of the array
	public void grow_array()
	{
		T[] newArr = (T[]) new Object[2*size];
		for (int i = 0; i < size ; i++)
		{
			newArr[i] = arr[i];
		}
		arr = newArr;
		size = size*2;
	}
}