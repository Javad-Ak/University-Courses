import java.util.Stack;
public class LinkedList{
    private Node head;
    public LinkedList(){
       head=null;
    }
    public void add(int k){
        Node nodeToAdd= new Node(k);
        if(head==null){
            head = nodeToAdd;
            return ;
        }
        Node current = head;
        while (current.next!=null){
            current=current.next;
        }
        current.next=nodeToAdd;
        return;
    }
    public void print(){
        if (head==null){
            System.out.println();
            return;
        }
        Node current=head;
        while(current!=null){
            System.out.print(current.val+" -> ");
            current=current.next;
        }
        System.out.println("|null|");
        return;
    }
    public void reverse(){
        if(head ==null)return;
        Stack<Node> stack = new Stack<>();
        Node current = this.head;
        while (current!=null){
            stack.push(current);
            current=current.next;
        }
        this.head = (Node) stack.pop();
        current=this.head;
        while (!stack.isEmpty()){
            Node top = (Node) stack.pop();
            current.next=top;
            current=top;
        }
        current.next=null;
    }
}

class Node{
    int val;
    Node next;
    public Node(int k){
        val=k;
        next=null;
    }
}
