public class MyDequeQueue<T> {
    private MyArrayDeque<T> deque;

    MyDequeQueue() {
        deque = new MyArrayDeque<>();
    }

    void enqueue(T i) {
        deque.addFirst(i);
    }

    T dequeue() {
        return deque.removeLast();
    }

    T peek() {
        return deque.peekLast();
    }

    boolean isEmpty() {
        return deque.isEmpty();
    }

    int size() {
        return deque.size();
    }
}
