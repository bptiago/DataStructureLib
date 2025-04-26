package structures;

import java.util.Arrays;
import java.util.Objects;

public class ArrayList<E> {
    private Object[] data;
    private int capacity = 10;
    private int freePos = 0;

    public ArrayList() {
        data = new Object[capacity];
    }

    public ArrayList(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];
    }

    public boolean add(E e) {
        if(isFull()) {
            grow();
        }
        data[freePos] = e;
        freePos++;
        return true;
    }

    public boolean add(int index, E e) {
        checkIndexOutOfBounds(index);
        if(isFull()) grow();

        for (int i = capacity; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;

        freePos++;
        return true;
    }

    public void remove(int index) {
        checkIndexOutOfBounds(index);

        for (int i = index; i < freePos; i++) {
            data[i] = data[i + 1];
        }

        data[freePos - 1] = null;
        freePos--;
    }

    public boolean remove(E e) {
        if(contains(e)) {
            remove(indexOf(e));
            return true;
        }
        return false;
    }

    public boolean set(int index, E e) {
        checkIndexOutOfBounds(index);
        data[index] = e;
        return true;
    }

    public E get(int index) {
        checkIndexOutOfBounds(index);
        return (E) data[index];
    }

    public int indexOf(E e) {
        for (int i = 0; i < capacity; i++) {
            if(data[i] == e) return i;
        }
        return -1;
    }

    public boolean contains(E e) {
        return indexOf(e) >= 0;
    }

    public Object[] toArray() {
        return Arrays.copyOf(data, freePos);
    }

    private void checkIndexOutOfBounds(int index) {
        if(index > capacity || index < 0) {
            throw new IndexOutOfBoundsException("Index:" + index + "Capacity: " + capacity);
        }
    }

    private boolean indexIsAvailable(int index) {
        return data[index] == null;
    }

    private void grow() {
        capacity *= 2;
        data = Arrays.copyOf(data, capacity);
    }

    private boolean isFull() {
        return data[capacity-1] != null;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.stream(data)
                .filter(Objects::nonNull)
                .toArray());
    }
}




