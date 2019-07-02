package exam.linear;

import java.util.Scanner;

public class JosephCircle {
    public static void  main(String[] args) {
        CircularSinglyLinkedList list = new CircularSinglyLinkedList();
        int totalNumber;
        int outNumber;
        int count = 0;
        Node temp = new Node();
        Scanner scanner = new Scanner(System.in);

        System.out.print("输入猴子总数:");
        totalNumber = scanner.nextInt();
        for (int i = totalNumber; i >= 1; i--){
            list.headInsert(i);
        }
        list.initRear();

        System.out.print("输入数到第几个猴子出圈:");
        outNumber = scanner.nextInt();

        temp = list.getHead();
        while (list.getSize() != 1){
            temp = temp.next;
            if (temp != list.getHead()) count++;
            if (count == outNumber-1) {
                if (temp.next != list.getHead()) {
                    temp.next = temp.next.next;
                    count = 0;
                }
                else {
                    list.getHead().next = list.getHead().next.next;
                    count = 0;
                }
            }
        }

        System.out.println("猴大王："+ list.getHead().next.data);
    }
}
