package s1801.lab02.m06.lists;

public class SequentialList {
    
    private Object list[];
    private int last=-1;
    
    public SequentialList (int size){
        list = new Object[size];
    }    
 
    /* Retorna o elemento na posição especificada.  */
    public Object get (int index){
        if (index<0 || index>last) return null;
        else return list[index];
    }
    
    /* Retorna true se o elemento foi inserido no final da lista, false caso contrário. */
    public boolean add (Object o) {
        if (isFull()) return false;
        last++;
        list[last]=o;
        return true;
    }
    
    /* Retorna true se o elemento foi inserido na lista, false caso contrário.
     * Insere o elemento na posição especificada */
    public boolean add (Object o, int pos) {
    	if (isFull()) return false;
        for (int i=last+1; i>pos; i--) {
            list[i]=list[i-1];
        }
        last++;
        list[pos]=o;
        return true;
    }
    
    /* Remove o elemento na posição especificada */ 
    public Object remove (int index) {
    	if (isEmpty()) return null;
    	else if (index<0 || index>last) {
            System.out.println ("Indice nao existente!");
            return null;
        }
        Object o = list[index];
        int numberofElements = last - index ;
        if (numberofElements > 0) {
            System.arraycopy(list, index + 1, list, index, numberofElements);
        }
        list[last] = null; /* to let gc do its work */
        last--;
        return o;
    }
 
    /* Verifica se a lista está vazia: não tel elementos */
    public boolean isEmpty (){
        if (last==-1) return true;
        else return false;
     }
     
    /* Verifica se a lista está cheia: todas as posições da array interna ocupadas */
    public boolean isFull (){
        if (last==list.length-1) return true;
        else return false;
     }

     public int getSize() {
        return last+1;
     }
     
    public static void main (String args[]) {
        SequentialList l = new SequentialList(5);
        l.add("1");
        l.add("2");
        l.add("3");
        l.add("4");
        l.add("5");
        l.add("6");
        l.add("6");
        l.add("2");
        System.out.println();
        for (int i=0; i<l.getSize(); i++) System.out.print (l.get(i)+" - ");
        l.remove(2);
        System.out.println();
        for (int i=0; i<l.getSize(); i++) System.out.print (l.get(i)+" - ");
        l.add("7");
        l.add("10", 3);
        System.out.println();
        for (int i=0; i<l.getSize(); i++) System.out.print (l.get(i)+" - ");   
    }
}
