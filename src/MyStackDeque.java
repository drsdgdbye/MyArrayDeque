import java.util.NoSuchElementException;

public class MyStackDeque<T> {
    MyArrayStack<T> leftStack = new MyArrayStack<>();
    MyArrayStack<T> rightStack = new MyArrayStack<>();
    int size;

    int size() {
        return size();
    }

    boolean isEmpty() {
        return size == 0;
    }

    void addLast(T x) {
        leftStack.push(x);
    }

    void addFirst(T x) {
        rightStack.push(x);
    }

    T removeFirst() {
        if (!leftStack.isEmpty()) {
            leftStack.pop();
        } else {
            MyArrayStack<T> temp = new MyArrayStack<>();
            for (int i = 0; i < rightStack.getSize() / 2; i++) {
                temp.push(rightStack.pop());
            }
            while (!rightStack.isEmpty()) {
                leftStack.push(rightStack.pop());
            }
            while (!temp.isEmpty()) {
                rightStack.push(temp.pop());
            }
        }
        return leftStack.pop();
    }

    T removeLast() {
        if (!rightStack.isEmpty()) {
            rightStack.pop();
        } else {
            MyArrayStack<T> temp = new MyArrayStack<>();
            for (int i = 0; i < leftStack.getSize() / 2; i++) {
                temp.push(leftStack.pop());
            }
            while (!leftStack.isEmpty()) {
                rightStack.push(leftStack.pop());
            }
            while (!temp.isEmpty()) {
                leftStack.push(temp.pop());
            }
        }
        return rightStack.pop();
    }

    T peekFirst() {
        if (leftStack.isEmpty()) {
            throw new NoSuchElementException("nothing watch");
        }
        return leftStack.peek();
    }

    T peekLast() {
        if (rightStack.isEmpty()) {
            throw new NoSuchElementException("nothing watch");
        }
        return rightStack.peek();
    }
}
