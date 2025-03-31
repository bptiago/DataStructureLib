package structures;

public class Node<E> {
    private E element;
    private Node<E> next;
    private Node<E> rear;

    public Node(E element) {
        this.element = element;
        this.next = null;
        this.rear = null;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public void setRear(Node<E> prev) { this.rear = prev; }

    public Node<E> getNext() {
        return next;
    }

    public Node<E> getRear() { return rear; }

    public E getElement() {
        return element;
    }

    public void setElement(E element) { this.element = element; }
}
