package s1801.lab02.m08;

public class Stack {
    List l;

   // construct stack
   public Stack() { 
      l = new List( "stack" ); 
   }

   // add object to stack
   public  void push( Object object ) { 
      l.insertAtFront( object ); 
   }

   // remove object from stack
   public  Object pop() throws EmptyListException { 
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

} // end class Stack

