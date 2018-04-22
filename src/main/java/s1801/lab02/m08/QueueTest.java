

public class QueueTest {

   public static void main( String args[] ) {
      Queue queue = new Queue();  

      // create objects to store in queue
      Boolean bool = Boolean.TRUE;
      Character character = new Character( '$' );
      Integer integer = new Integer( 34567 );
      String string = "hello";

      // use enqueue method
      queue.enqueue( bool );
      queue.print();
      queue.enqueue( character );
      queue.print();
      queue.enqueue( integer );
      queue.print();
      queue.enqueue( string );
      queue.print();

      // remove objects from queue
      try {
         Object removedObject = null;

         while (!queue.isEmpty()) {
            removedObject = queue.dequeue(); // use dequeue method
            System.out.println( removedObject.toString() + " dequeued" );
            queue.print();
         }
      }

      // process exception if queue is empty when item removed
      catch ( EmptyListException emptyListException ) {
         emptyListException.printStackTrace();
      }
   }

} // end class QueueTest

