package com.basic.java.collection.link;

public class Node {

    Object item;
    Node next;

    public Node(Object item) {
        this.item = item;
    }

//    @Override
//    public String toString() {
//        return "Node{" +
//                "item=" + item +
//                ", next=" + next +
//                '}';
//    }


    //[A->B->C]
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node x = this; //x01
        stringBuilder.append("[");
        while (x != null) {
            stringBuilder.append(x.item);
            if (x.next != null) {
                stringBuilder.append(" => ");
            }
            x = x.next;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

}
