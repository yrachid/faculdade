

// class List definition
public class List {
   private Node firstNode;
   private Node lastNode;
   private String name;  // string like "list" used in printing

   // construct empty List with "list" as the name
   public List() { 
      this( "list" ); 
   }  

   // construct an empty List with a name
   public List( String listName ) {
      name = listName;
      firstNode = lastNode = null;
   }
   
  public Node getFirst(){
       return firstNode;
    }
   
   public Node getLast(){
	   return lastNode;
   }

   // insert Object at front of List
   public  void insertAtFront( Object insertItem ) {
      if ( isEmpty() ) // firstNode and lastNode refer to same object
         firstNode = lastNode = new Node( insertItem );

      else // firstNode refers to new node
         firstNode = new Node( insertItem, firstNode );
   }

   // insert Object at end of List
   public  void insertAtBack( Object insertItem ) {
      if ( isEmpty() ) // firstNode and lastNode refer to same Object
         firstNode = lastNode = new Node( insertItem );

      else {// lastNode's nextNode refers to new node
         lastNode.setNext (new Node( insertItem ));
         lastNode = lastNode.getNext();
      }
   }

   // remove first node from List
   public  Object removeFromFront() throws EmptyListException {
      if ( isEmpty() ) // throw exception if List is empty
         throw new EmptyListException( name );

      Object removedItem = firstNode.getData(); // retrieve data being removed

      // update references firstNode and lastNode 
      if ( firstNode == lastNode )
         firstNode = lastNode = null;
      else
         firstNode = firstNode.getNext();

      return removedItem; // return removed node data

   } // end method removeFromFront

   // remove last node from List
   public  Object removeFromBack() throws EmptyListException {
      if ( isEmpty() ) // throw exception if List is empty
         throw new EmptyListException( name );

      Object removedItem = lastNode.getData(); // retrieve data being removed

      // update references firstNode and lastNode
      if ( firstNode == lastNode )
         firstNode = lastNode = null;

      else { // locate new last node
         Node current = firstNode;

         // loop while current node does not refer to lastNode
         while ( current.getNext() != lastNode )
            current = current.getNext();
   
         lastNode = current; // current is new lastNode
         current.setNext(null);
      }

      return removedItem; // return removed node data

   } // end method removeFromBack

   // determine whether list is empty
   public boolean isEmpty() { 
      return firstNode == null; // return true if List is empty
   }

   // output List contents
   public  void print() {
      if ( isEmpty() ) {
         System.out.println( "Empty " + name );
         return;
      }

      System.out.print( "The " + name + " is: " );
      Node current = firstNode;

      // while not at end of list, output current node's data
      while ( current != null ) {
         System.out.print( current.getData().toString() + " " );
         current = current.getNext();
      }

      System.out.println( "\n" );
   }
   
  
} // end class List
