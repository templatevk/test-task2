package me.tango;

public class Nodes {

    private Nodes() {

    }

    public static Node[] splitByParityAndReverse(Node<Integer> head) {
        Node<Integer> oddHead = null;
        Node<Integer> oddCurrent = null;
        Node<Integer> evenHead = null;
        Node<Integer> evenCurrent = null;

        while (null != head) {
            if (null != head.getValue()) {
                Node<Integer> next = new Node<>(head.getValue());

                if (head.getValue() % 2 == 0) {
                    if (null == evenHead) {
                        evenCurrent = next;
                        evenHead = evenCurrent;
                    } else {
                        evenCurrent.setNext(next);
                        evenCurrent = next;
                    }
                } else {
                    if (null == oddHead) {
                        oddCurrent = next;
                        oddHead = oddCurrent;
                    } else {
                        oddCurrent.setNext(next);
                        oddCurrent = next;
                    }
                }
            }

            head = head.getNext();
        }

        Node<Integer> reversedOddHead = reverse(oddHead);
        Node<Integer> reversedEvenHead = reverse(evenHead);
        return new Node[] { reversedOddHead, reversedEvenHead};
    }

    public static <T> Node<T> reverse(Node<T> head) {
        if (null == head) {
            return null;
        }

        Node<T> current = head;
        Node<T> previous = null;
        Node<T> next;

        while (null != current) {
            next = current.getNext();

            current.setNext(previous);

            previous = current;
            current = next;
        }
        return previous;
    }

    // TODO testing purposes, remove
    public static void main(String[] args) {
        var result = splitByParityAndReverse(Node.of(1, 2, 3, 4, 5, 6, 7));
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
