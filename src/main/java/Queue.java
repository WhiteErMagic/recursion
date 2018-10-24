public class Queue {
    private LinkedList queue;

    public Queue(){
        queue = new LinkedList();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public void insert(int age){
        queue.insert(age);
    }

    public int delete(){
        return queue.delete();
    }

    public void display(){
        queue.display();
    }

}
