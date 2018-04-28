package s1801.lab02.m08;

public class StackTest {

   public static void main( String args[] )  {
      Stack stack = new Stack();  

      // create objects to store in the stack
      Boolean bool = Boolean.TRUE;
      Character character = new Character( '$' );
      Integer integer = new Integer( 34567 );
      String string = "hello";

      // use push method
      stack.push( bool );
      //stack.print();
      stack.push( character );
      //stack.print();
      stack.push( integer );
      //stack.print();
      stack.push( string );
      stack.print();

      // remove items from stack
      try {
         Object removedObject = null;

         while (!stack.isEmpty()) {
            removedObject = stack.pop(); // use pop method
            System.out.println( removedObject.toString() + " popped" );
            stack.print();
         }
      }

      // catch exception if stack is empty when item popped
      catch ( EmptyListException emptyListException ) {
         emptyListException.printStackTrace();
      }
   }
   
} // end class StackInheritanceTest
