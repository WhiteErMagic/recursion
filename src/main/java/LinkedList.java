public class LinkedList {
    public Link first;
    public Link last;

    public LinkedList(){
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return (first == null);
    }

    public void insert(int age){
        Link newLink = new Link(age);
        if (this.isEmpty())
            first = newLink;
        else
            last.next = newLink;
        last = newLink;
    }

    public int delete(){
        Link temp = first;
        if (first.next == null)
            last = null;
        first = first.next;
        return temp.age;

    }

    public void display(){
        Link current = first;
        while(current != null){
            current.display();
            current = current.next;
        }
    }

}
