

public class Node<T> {

    T info;
    Node<T> back;
    Node<T> front;

    public Node(T info) {
        this.info = info;
        this.back = null;
        this.front = null;
    }
    public Node<T> getBack() {
        return back;
    }
    public void setFront(Node<T> front) {
        this.front = front;
    }
    public void setBack(Node<T> back) {
        this.back = back;
    }

}