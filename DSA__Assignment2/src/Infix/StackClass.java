package Infix;

import java.util.ArrayList;
import java.util.List;

public class StackClass implements StackInterface{
	
	private static final int SIZE_OF_STACK = 100;
	private String[] stack = new String[SIZE_OF_STACK];
	
	//pointing to the latest added element of stack
	private int top = -1;

	@Override
	public void push(String element) throws Exception {
		
		if (top==(SIZE_OF_STACK-1)){
			throw new Exception ("Stack is full");
		}
		top = top+1;
		stack[top] = element;
	}

	@Override
	public String pop() throws Exception {
		
		if (top==-1){
			throw new Exception ("Stack is empty");
		}
		String poppedElement = stack[top];
		top = top-1;
		return poppedElement;
	}
	
	@Override
	public Boolean isEmpty(){
		if (top==-1){
			return true;
		}
		return false;
	}
	
	@Override
	public String peek() throws Exception{
		if (top==-1){
			throw new Exception ("Stack is empty");
		}
		return stack[top];
	}
}
