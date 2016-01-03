import java.util.*;
class Node {
      int value;
      Node next = null;
    }
    
class LinkedList {
    Node head;
    public LinkedList(int data) {
        Node n = new Node();
        n.value = data;
        head = n;
    }
    
    public void addNode(int data) {
        Node temp = head;
        while(temp.next!=null) {
            temp = temp.next;
        }
        Node n = new Node();
        n.value = data;
        temp.next = n;
    }
    
    public void delete_node(int position) {
        Node temp = head;
        int count =1;
        if(position == 1) {
            head = head.next;
        }
        else
        {
        while((temp.next!=null)&&(count < position)) {
            temp = temp.next;
            count++;
        }
        if(count == position) {
            if(temp.next.next!=null)
                temp.next = temp.next.next;
            else
                temp.next = null;
        }
        else 
            System.out.println("Position out of bounds");
        }
    }
    
    public void delete_dups() {
        Node head1 = head;
        while(head1!=null) {
            Node ptr = head1;
            while(ptr.next!=null) {
                if(head1.value == ptr.next.value) {
                    ptr.next = ptr.next.next;
                }
                else {
                    ptr = ptr.next;
                }
            }
            head1 = head1.next;
        }
    }
    
    public void delete_dups2() {
        Node head1 = head;
        HashMap map = new HashMap();
        if(head1!=null) {
            Integer it = new Integer(head1.value);
            map.put(it.hashCode(), head1.value);
            while(head1!=null) {
                if(map.containsValue(head1.next.value))
                    head1.next = head1.next.next;
                else {
                    it = new Integer(head1.next.value);
                    map.put(it.hashCode(), head1.next.value);
                }
                head1 = head1.next;
            }
        }
    }
    
    public void printlist() {
        Node temp = head;
        while(temp.next != null) {
            System.out.print(temp.value+" ");
            temp = temp.next;
        }
        System.out.println(temp.value);
    }
}
public class HelloWorld{
     public static void main(String []args){
        LinkedList l = new LinkedList(10);
        //l.printlist();
        l.addNode(20);
        l.addNode(30);
        //l.printlist();
        //l.delete_node(2);
        //l.printlist();
        l.addNode(20);
        l.addNode(40);
        l.addNode(10);
        l.printlist();
        l.delete_dups2();
        l.printlist();
     }
}
