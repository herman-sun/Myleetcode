import java.util.Scanner;

public class SimpleQueueForReal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        myQueueForReal queue = new myQueueForReal(5);
        while (sc.hasNext()) {
            System.out.println("a  添加数字");
            System.out.println("b  显示队列");
            System.out.println("c  取数据");
            System.out.println("d  看第一个数据");
            switch (sc.next()) {
                case "a":
                    queue.addQueue(sc.nextInt());
                    break;
                case "b":
                    queue.showQueue();
                    break;
                case "c":
                    queue.getHead();
                    break;
                case "d":
                    queue.peek();
                    break;
            }
        }
    }
}

/**
 * 真实队列
 * 双指针
 */
class myQueueForReal{
    private int max_size;//队列值
    private int front;//队列头
    private int rear;//队列尾  队列尾的后面一个位置
    private int[] arr;//队列数组

    public myQueueForReal(int max_size) {
        this.max_size = max_size;
        arr = new int[this.max_size];
        front = 0;
        rear = 0;
    }

    public boolean isFull() {
        if (rear - front == max_size) {
            System.out.println("队列已满");
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        return
        front == rear;
    }

    public void addQueue(int a) {
        int index = rear % max_size;
        if (isFull()) {
            System.out.println("队列已满");
        } else {
            arr[index] = a;
            rear++;
        }
    }

    public int getHead() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        } else {
            int index = front % max_size;
            front++;
            return arr[index];
        }
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，无数据");
        } else {
            for (int i = front; i < rear; i++) {
                System.out.printf("arr[%d]==%d", i % max_size, arr[i % max_size]);
            }
        }
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无头");
        } else {
            return arr[(front - 1) % max_size];
        }
    }

}
