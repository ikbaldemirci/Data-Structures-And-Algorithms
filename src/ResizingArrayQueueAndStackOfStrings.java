import java.util.Queue;
import java.util.Stack;

public class ResizingArrayQueueAndStackOfStrings<T> {

    private T[] data;
    private int N;

    public ResizingArrayQueueAndStackOfStrings(int capacity){
        if(capacity < 1)    capacity=1;
        data = (T[]) new Object[capacity];
    }

    //  Resizing The Array
    public void resize(){
        T[] newArray = (T[]) new Object[data.length * 2];

        for(int i=0; i<data.length; i++) newArray[i] = data[i];
        data = newArray;
    }

    //  Check if array is empty or not ?
    public boolean isEmpty(){return N==0;}

    //  Stack Part
    public void push(T newValue){
        if(N == data.length) resize();
        data[N] = newValue;
        N++;
    }

    public T pop(){
        if(isEmpty()) System.out.println("System is empty");
        N--;
        return data[N];
    }

    public void printStack(){
        for(int i = N-1; i>=0; i--) System.out.println(data[i]);
    }

    //  Queue Part

    public void enqueue(T newValue){
        if(N==data.length) resize();
        data[N] = newValue;
        N++;
    }

    public T dequeue(){
        T newValue = data[0];

        for(int i=0; i<N; i++)  data[i] = data[i+1];
        data[--N] = null;

        return newValue;
    }

    

    public static void main(String[] args) {

        //  Running Stack Part
        ResizingArrayQueueAndStackOfStrings s = new ResizingArrayQueueAndStackOfStrings<>(20);
        s.push(2);
        s.push(3);
        s.pop();
        s.printStack();

        //  Running Queue Part
        ResizingArrayQueueAndStackOfStrings<String> q = new ResizingArrayQueueAndStackOfStrings<String>(20);
        q.enqueue("ikbal");
        q.enqueue("Demirci");
        q.dequeue();

        while(!q.isEmpty()) System.out.println(q.dequeue());
    }
    
}
