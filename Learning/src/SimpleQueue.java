public class SimpleQueue {

    public static void main(String[] args) {

    }
}

/**
 * 伪队列
 */
class myQueue{
    private int max_size;//队列值
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//队列数组

    public myQueue(int max_size) {
        this.max_size = max_size;
        arr = new int[this.max_size];
        front = -1;
        rear = -1;
    }

    public boolean isFull() {
        if (rear == max_size - 1) {
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
        if (isFull()) {
            System.out.println("队列已满");
        } else {
            rear++;
            arr[rear] = a;
        }
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        } else {
            front++;
            return arr[front];
        }
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，无数据");
        } else {
            for (int i = 0; i < arr.length; i++) {
                System.out.printf("arr[%d]==%d", i, arr[i]);
            }
        }
    }

    public int getHead() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无头");
        } else {
            return arr[front + 1];
        }
    }

}
