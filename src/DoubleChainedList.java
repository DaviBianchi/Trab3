
import java.util.Objects;

public class DoubleChainedList<T> {

    int size;
    int innersize;
    Node<T> down;
    Node<T> top;
    public DoubleChainedList(int innersize) {
        this.innersize = innersize;
    }
    public void add(T value) {
        if (!(isFull()) == true) {
            Node<T> no = new Node(value);
            if (isEmpty() == true) {
                this.down = no;
                this.top = no;
                this.size++;
            } else {
                no.setBack(top);
                this.top.setFront(no);
                this.top = no;
                this.size++;
            }
        } else {
            System.out.println("|| FULL?" + isFull());
        }

    }
    public Node<T> getNode(int pos) throws IllegalArgumentException {
        if (!(pos < this.size)) {
            throw new IllegalArgumentException("INVALID Command, try again");
        }
        Node<T> getPos;
        pos = Objects.checkIndex(pos, this.size);

        if (pos < size / 2) {
            getPos = down;
            for (int i = 0; i < pos; i++) {
                getPos = getPos.front;

            }
        } else {
            getPos = this.top;
            for (int i = size; i > pos; i--) {
                getPos = getPos.back;
            }
        }

        return getPos;
    }
    public T get(int pos) {
        Node<T> node = getNode(pos);

        return node.info;
    }
    private T remove(Node<T> no) {
        T value = no.info;

        Node<T> back = no.back;
        Node<T> dront = no.front;

        if (back == null) {
            no.back = null;
            no.front = null;
            down = dront;
        } else if (dront == null) {

            no.back = null;
            no.front = null;
            top = back;
        } else {
            dront.back = back;
            back.front = dront;
            no.back = null;
            no.front = null;

        }

        size--;
        return value;
    }
    public T remove(int pos) {
        if (isEmpty()) {
            throw new IllegalArgumentException("Impossível remover dessa lista, pois ela está vazia");
        } else {
            Node<T> no = getNode(pos);
            return remove(no);
        }
    }
    @Override
    public String toString() {
        String str = "(" + size + ") ";
        Node local = down;
        while (local != null) {
            str += local.info + "  ";
            local = local.front;
        }
        return str;
    }
    public int getSize() {
        return this.size;
    }
    public void cleanList() {
        this.top = null;
        this.down = null;
        this.size = 0;
    }
    public boolean isEmpty() {
        return this.size == 0;
    }
    public boolean isFull() {
        return this.innersize == size;
    }

}
