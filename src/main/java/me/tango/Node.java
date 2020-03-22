package me.tango;

import java.util.Arrays;
import java.util.Objects;

public class Node<T> {

    private T value;
    private Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public static <T> Node<T> of(T...values) {
        if (null == values || values.length == 0) {
            return null;
        }

        Node<T> head = new Node<>(values[0]);

        Node<T> current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new Node<>(values[i]);
            current = current.next;
        }

        return head;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(value, node.value) &&
                Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, next);
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
