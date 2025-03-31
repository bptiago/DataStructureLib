package structures;

public class Queue<E> {
    private Node<E> next;
    private Node<E> rear;
    private int length;

    public Queue(Node<E> next, int length) {
        this.next = next;
        this.rear = rear;
        this.length = length;
    }

    public Queue() {
        next = rear = null;
        length = 0;
    }

    public boolean enqueue(E element){
        Node<E> node = new Node<>(element);

        if (rear == null) {
            rear = node;
            next = node;
            this.length++;
            return true;
        } else {
            rear.setNext(node);
            rear = node;
        }

        length++;
        return true;
    }

    public E dequeue(){
        if (isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }
        E element = next.getElement();
        next = next.getNext();

        if (next == null){
            rear = null;
        }
        length--;
        return element;
    }

    public boolean isEmpty(){
        return next == null;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = this.next;
    }

    public Node<E> getRear() {
        return rear;
    }

    public void setRear(Node<E> rear) {
        this.rear = rear;
    }
}
