import java.util.NoSuchElementException;

class MyArrayDeque<T> {
    private Object[] deque;
    private int head;
    private int tail;
    private int size;

    MyArrayDeque() {
        deque = new Object[1];
    }

    public int size() {
        return size;
    }

    boolean isEmpty() {
        return size == 0;
    }

    private void resize(int capacity) {
        Object[] temp = new Object[capacity];
        if (capacity > deque.length) {
            if (tail < head) {
                for (int i = head; i < deque.length; i++) {
                    temp[i] = deque[i];
                }
                for (int i = 0; i <= tail; i++) {
                    temp[i] = deque[i];
                }
            } else {
                for (int i = 0; i < size; i++) {
                    temp[i] = deque[i];
                }
            }
            head = 0;
            tail = deque.length - 1;
            deque = temp;
        } else {
            if (tail < head) {
                for (int i = head; i < size; i++) {
                    temp[i] = deque[i];
                }
                for (int i = 0; i <= tail; i++) {
                    temp[i] = deque[i];
                }
            } else {
                for (int i = 0; i < size; i++) {
                    temp[i] = deque[i];
                }
            }
            head = 0;
            tail = deque.length - 1;
            deque = temp;
        }
    }

    void addFirst(T x) {
        if (size == deque.length) {
            resize(deque.length * 2);
        }
        if (head == 0) {
            head = deque.length - 1;
            deque[head] = x;
        } else
            deque[--head] = x;
        size++;
        if (size == 1) {
            head = tail;
        }
    }


    void addLast(T x) {
        if (size == deque.length) {
            resize(deque.length * 2);
        }
        if (tail == deque.length - 1) {
            tail = 0;
            deque[tail] = x;
        } else
            deque[++tail] = x;
        size++;
        if (size == 1) {
            head = tail;
        }
    }

    T peekFirst() {
        if (isEmpty()) throw new NoSuchElementException("nothing watch");
        return (T) deque[head];
    }

    T peekLast() {
        if (isEmpty()) throw new NoSuchElementException("nothing watch");
        return (T) deque[tail];
    }

    T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("deque is empty");
        }
        if (size == deque.length / 4 && size > 0) {
            resize(deque.length / 2);
        }
        T x = peekFirst();
        if (head == deque.length - 1) {
            head = 0;
        } else
            head++;
        size--;
        return x;
    }

    T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("deque is empty");
        }
        if (size == deque.length / 4 && size > 0) {
            resize(deque.length / 2);
        }
        T x = peekLast();
        if (tail == 0) {
            tail = deque.length - 1;
        } else
            tail--;
        size--;
        return x;
    }
}
