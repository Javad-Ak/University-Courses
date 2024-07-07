/* Java program to implement basic stack
operations */
class Stack {
	int maxSize;
	int top;
	int a[];

	public boolean isEmpty()
	{
		return (top < 0);
	}
	public Stack(int maxSize)
	{
		top = -1;
        this.maxSize = maxSize;
        a = new int[maxSize];
	}

	public boolean push(int x)
	{
		if (top >= (maxSize - 1)) {
			System.out.println("Stack Overflow");
			return false;
		}
		
        a[++top] = x;
        System.out.println(x + " pushed into stack");
        return true;
		
	}

	public int pop()
	{
		if (top < 0) {
			System.out.println("Stack Underflow");
			return 0;
		}
        int x = a[top--];
        return x;
		
	}

	public int peek()
	{
		if (top < 0) {
			System.out.println("Stack Underflow");
			return 0;
		}
		
        int x = a[top];
        return x;
	}
    public void print(){
        if (this.isEmpty()){
            System.out.println("  empty  ");
            return;
        }
        System.out.println("top ");
        for (int i = top;i>=0;i--){
            System.out.println("| "+a[i]+" |");
        }
        System.out.println("-------");
        
    }
}

// Driver code
class Main {
	public static void main(String args[])
	{
		Stack s = new Stack(10);
		s.push(10);
		s.push(20);
		s.push(30);
		// System.out.println(s.pop() + " Popped from stack");
        s.print();
	}
}
// based on https://www.geeksforgeeks.org/stack-data-structure-introduction-program/