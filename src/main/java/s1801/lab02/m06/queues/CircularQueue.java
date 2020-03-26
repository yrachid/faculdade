package s1801.lab02.m06.queues;

import s1801.lab02.m06.exceptions.OverflowException;
import s1801.lab02.m06.exceptions.UnderflowException;

public class CircularQueue<T> implements Queue<T> {
    private Object[] fila;

    private int i = -1, f = -1;

    public CircularQueue(int n) {
        fila = new Object[n];
    }

    public boolean isFull() {
        if ((i == 0 && f == fila.length - 1) || (i == f + 1))
            return true;
        else
            return false;
    }

    public boolean isEmpty() {
        if (i == -1)
            return true;
        else
            return false;
    }

    public void enqueue(Object o) throws OverflowException {

        if (isFull())
            throw new OverflowException();
        if (f == fila.length - 1 || f == -1) {
            f = 0;
            fila[f] = o;
            if (i == -1)
                i = 0;
        } else {
            f = f + 1;
            fila[f] = o;
        }
    }

    public T dequeue() throws UnderflowException {
        if (!isEmpty()) {
            Object o = fila[i];
            fila[i] = null;
            if (i == f)
                i = f = -1;
            else if (i == fila.length - 1)
                i = 0;
            else
                i++;
            return (T) o;
        } else
            throw new UnderflowException();

    }

    public void print() {
        if (!isEmpty()) {

            //?????????????????

        }
    }

    public static void main(String args[]) {
        CircularQueue f = new CircularQueue(5);
		/*Teclado t = new Teclado();
		int num;
		
		while((num = t.leInt("Entre com um numero inteiro (0 para finalizar) : ")) != 0){
			try{
				f.enqueue(new Integer(num));
			}
			catch(OverflowException e){
				System.out.println("OVERFLOW");
			}
		}
		
		//Enquanto a fila nao for vazia, esvazia-la mostrando os elementos
		//na ordem em que foram inseeidos
		
		while(!f.isEmpty()){
			try{
				Integer i = (Integer) f.dequeue();
				System.out.println(i.toString());
			}catch (UnderflowException e){
				System.out.println("UNDERFLOW");
			}
		}*/


        try {
            f.enqueue(1);
            f.enqueue(2);
            f.enqueue(3);
            f.enqueue(4);
            f.enqueue(5);
        } catch (OverflowException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            f.dequeue();
            f.dequeue();
            f.dequeue();
            f.dequeue();
        } catch (UnderflowException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            f.enqueue(6);
            f.enqueue(7);
            f.enqueue(8);
            f.enqueue(9);
        } catch (OverflowException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // f.enqueue(10);

		/*try {
			for (int i = 0; i < 5; i++)
				System.out.println(f.dequeue());
		} catch (UnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

        //f.print();

    }
}