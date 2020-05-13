import java.util.List;
/**
 * LinkedListDeque
 * @author Jinchen
 */

public class LinkedListDeque<T> {

    public class ListNode<T> {
        ListNode<T> prev;
        T object;
        ListNode<T> next;

        public ListNode(T item){
            this.prev = null;
            this.object = item;
            this.next = null;
        }
    }

    private int size;
    ListNode<T> head;
    ListNode<T> tail;

    public LinkedListDeque() {
        size = 0;
        head = new ListNode<>(null);
        tail = new ListNode<>(null);
        head.next = tail;
        tail.prev = head;
        ;
    }

    public void addFirst(T item) {
        ListNode<T> newNode = new ListNode<>(item);
        newNode.next = head.next;
        newNode.prev = head;
        head.next = newNode;
        newNode.next.prev = newNode;
        size++;
    }

    public void addLast(T item) {
        ListNode<T> newNode = new ListNode<>(item);
        tail.prev.next = newNode;
        newNode.prev = tail.prev;
        newNode.next = tail;
        tail.prev = newNode;
        size++;
    }

    public T get(int index) {
        ListNode<T> curNode = head;
        for (int i = 0; i <= index; i++) {
            curNode = curNode.next;
        }
        return curNode.object;
    }

    public boolean isEmpty() {
        if (size == 0){
            return true;
        } else {
            return false;
        }
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        ListNode<T> toPrint = head.next;
        System.out.println();
        for(int i =0; i < size; i++){
            System.out.print(toPrint.object + " ");
            toPrint = toPrint.next;
        }
    }

    public T removeFirst(){
        ListNode<T> firstToRemove = head.next;
        head.next = head.next.next;
        head.next.prev = head;
        size --;
        return firstToRemove.object;
    }

    public T removeLast(){
        ListNode<T> lastToRemove = tail.prev;
        tail.prev = tail.prev.prev;
        tail.prev.next = tail;
        size --;
        return lastToRemove.object;
    }

    public T getRecursive(int index) {
        if (head.next.object == head.object) {
            return null;
        }

        if (index > size - 1) {
            return null;
        }
        int cnt = 0;
        return getRecursiveHelper(cnt, head, index);

    }

    private T getRecursiveHelper(int cnt, ListNode<T> curNode, int index) {
        if (cnt == index) {
            return curNode.next.object;
        }
        return getRecursiveHelper(cnt + 1, curNode.next, index);
    }

//    public static void main(String[] args) {
//        LinkedListDeque L = new LinkedListDeque();
//        L.addFirst(5);
//        L.addFirst("apple");
//        L.addFirst(12);
//        L.addLast("pineapple");
//        L.printDeque();
//        System.out.println(L.getRecursive(0));
//        System.out.println(L.isEmpty());

//        System.out.println(L.removeLast());


    }



