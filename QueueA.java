import java.util.Scanner;
public class QueueA {
    private static final int max_size=100;
    private int[] arr;
    private int front,rear;
    public QueueA(){
        arr=new int[max_size];
        front=rear=-1;
    }
    public void enqueue(int data){
        if(isFull()){
            System.out.println("Queue is full.");
            return;
        }
        if(isEmpty()){
            System.out.println("Queue is empty.");
            front=rear=0;
        }
        else{
            rear=(rear+1)%max_size;
        }
        arr[rear]=data;
        printqueue();
    }
    public void dequeue(){
        if(isEmpty()){
            System.out.println("queue is empty");
            return;
        }
        if(front==rear){
            front=rear=-1;
        }
        else{
            front=(front+1)%max_size;
        }
        printqueue();
    }
    public int peek(){
        if(isEmpty()){
            System.out.println("queue is empty.");
            return -1;
        }
        return arr[front];
    }
    public boolean isEmpty(){
        return front==-1&&rear==-1;
    }
    public boolean isFull(){
        return (rear+1)%max_size==front;
    }
    public int size(){
        if(isEmpty()){
            return 0;
        }
        else if(front<=rear){
            return rear-front+1;
        }
        else{
            return max_size-front+rear+1;
        }
    }
    public void printqueue(){
        System.out.println("queue");
        if(isEmpty()){
            System.out.println("Empty");
            return;
        }
        int current=front;
        while(current!=rear){
            System.out.print(arr[current]+" ");
            current=(current+1)%max_size;
        }
        System.out.println(arr[rear]);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        QueueA queue=new QueueA();
        while(true){
            System.out.println("Choose an operation.");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Check if queue is empty.");
            System.out.println("5. Check if queue is full");
            System.out.println("6. Get queue size");
            System.out.println("7. Exit");
            int ch=sc.nextInt();
        switch (ch){
            case 1:
                System.out.println("Enter element to enqueue.");
                int ele=sc.nextInt();
                queue.enqueue(ele);
                break;
            case 2:
                queue.dequeue();
                break;
            case 3:
                queue.peek();
                break;
            case 4:
                queue.isEmpty();
                break;
            case 5:
                queue.isFull();
                break;
            case 6:
                System.out.println("Queue size:"+queue.size());
                break;
            case 7:
                System.out.println("Exiting program...");
                System.exit(0);
            default:
                System.out.println("Invalid choice");
        }
        }
    }
}
