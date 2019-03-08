import java.util.NoSuchElementException;

class MyArrayStack<T> {
    private int size;
    private Object[] stack;

    MyArrayStack() {
        this.size = 0;
        this.stack = new Object[1];
    }

    public int getSize() {
        return size;
    }

    boolean isEmpty() {
        return size == 0;
    }

    private void resize(int capacity) {
        Object[] temp = new Object[capacity];
        System.arraycopy(stack, 0, temp, 0, size);
        stack = temp;
    }

    void push(T i) {
        if (size == stack.length) {
            resize(2 * stack.length);
        }
        stack[size++] = i;
    }

    T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        T i = peek();
        size--;
        if (size == stack.length / 4 && size > 0) {
            resize(stack.length / 2);
        }
        return i;
    }

    T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("nothing to watch");
        }
        return (T) stack[size - 1];
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = size - 1; i >= 0; i--) {
            builder.append(((T) stack[i]).toString());
        }
        return builder.toString();
    }
}
