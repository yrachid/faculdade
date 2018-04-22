

public class Queue {
    List l;

   // construct queue
   public Queue() { 
      l = new List( "queue" ); 
   }
   
    // add object to queue
   public  void enqueue( Object object ) { 
      l.insertAtBack( object ); 
   }

   // remove object from queue
   public  Object dequeue() throws EmptyListException { 
      return l.removeFromFront(); 
   }
   
   // determine whether list is empty
   public  void print() {
       l.print();
   }
   
   // output List contents
   public boolean isEmpty() { 
      return l.isEmpty();
   }
   
   
} // end class Queue

