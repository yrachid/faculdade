package LSE;

public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List list = new List();  // create the List container

	      
	      // insert references to objects in list
	      list.insertAtFront( new Integer(4) );
	      //list.print();
	      list.insertAtFront( new Integer(1) );
	      //list.print();
	      list.insertAtBack( new Integer(3) );
	      //list.print();
	      list.insertAtBack( new Integer(2) );
	      list.print();
	     
	      	      
	      if(list.troca_seg_pen())
	    	  list.print();
	      
	      try { 
		         Object removedObject = list.remove_maior_versao2();
		         System.out.println( removedObject.toString() + " removed" );
		         list.print();
		       
		      } // end try block 

		     // catch exception if remove is attempted on an empty List 
		      catch ( EmptyListException emptyListException ) {
		         emptyListException.printStackTrace();
		      }
 
	}
	
}
