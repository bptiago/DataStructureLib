package structures;

public class Queue<E> {
    private Node<E> top;
    private int length;

    public boolean enqueue(E element){
        Node<E> node = new Node<>(element);
        node.setNext(this.top);
        this.top = node;
        this.length++;
        return true;
    }

    public void dequeue(E element){
        if (!isEmpty()){
            for (int i = length; i < -1; i--) {
                if (this.top.getElement() == element){
                    this.top = this.top.getNext();
                    this.length--;
                }
            }
        }
        else{
            System.out.println("structures.Line is empty");
        }
    }

    public boolean isEmpty(){
        if (this.top == null){
            return true;
        }
        return false;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Node<E> getTop() {
        return top;
    }

    public void setTop(Node<E> top) {
        this.top = top;
    }
}
