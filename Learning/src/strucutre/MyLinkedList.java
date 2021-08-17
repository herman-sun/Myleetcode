package strucutre;

/**
 * 链表demo
 */
public class MyLinkedList {
    public static void main(String[] args) {
        MyNode node1 = new MyNode(1, "a");
        MyNode node2 = new MyNode(2, "b");
        MyNode node3 = new MyNode(3, "c");
        MyNode node4 = new MyNode(4, "d");
        MyLinkedListDemo listDemo = new MyLinkedListDemo();
        listDemo.add(node1);
        listDemo.add(node2);
        listDemo.add(node3);
        listDemo.add(node4);
        listDemo.list();
    }
}

class MyLinkedListDemo{
    public MyNode firstNode = new MyNode(0, "");

    public void add(MyNode node) {
        MyNode myNode = firstNode;
        while (true) {
            if (myNode.next == null) {
                break;
            }
            myNode = myNode.next;
        }
        myNode.next = node;
    }

    public void list() {
        MyNode myNode = firstNode;
        if (myNode == null) {
            System.out.println("链表为空");
            return;
        }

        while (null != myNode.next) {
            myNode = myNode.next;
            System.out.println(myNode);
        }
    }

}

class MyNode {
    public int num;
    public String name;
    public MyNode next;

    public MyNode(int num, String name) {
        this.num = num;
        this.name = name;
    }

    @Override
    public String toString() {
        return "FirstNode{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }
}
