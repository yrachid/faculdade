package s1801.lab02.m06.stacks;

import s1801.lab02.m06.exceptions.OverflowException;
import s1801.lab02.m06.exceptions.UnderflowException;

public class Stack {
	private Object s[];

	private int top = -1;

	public Stack(int size) {
		s = new Object[size];
	}

	public boolean isEmpty() {
		if (top == -1)
			return true;
		return false;
	}

	public boolean isFull() {
		if (top == s.length - 1)
			return true;
		return false;
	}

	public void push(Object obj) throws OverflowException {
		if (!isFull()) {
			s[++top] = obj;
		} else
			throw new OverflowException();
	}

	public Object pop() throws UnderflowException {
		if (!isEmpty()) {
			Object o = s[top];
			s[top] = null;
			top--;
			return o;
		} else
			throw new UnderflowException();

	}

	public static void main(String args[]) {
		Stack s = new Stack(5);
		try {
			s.pop();
		} catch (UnderflowException e) {
			System.out.println(e.toString());
		}
		try {
			s.push("1");
			s.push("2");
			s.push("3");
			s.push("4");
			s.push("5");
		} catch (OverflowException e) {
			System.out.println(e.toString());
		}
		try {
			s.pop();
			s.pop();
		} catch (UnderflowException e) {
			System.out.println(e.toString());
		}
		try {
			s.push("6");
		} catch (OverflowException e) {
			System.out.println(e.toString());
		}
		try {
			s.pop();
			s.pop();
			s.pop();
			s.pop();
			s.pop();
		} catch (UnderflowException e) {
			System.out.println(e.toString());
		}
	}

}
