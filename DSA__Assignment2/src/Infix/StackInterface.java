package Infix;

public interface StackInterface {
	
	void push(String element) throws Exception;
	
	String pop() throws Exception;

	Boolean isEmpty();
	
	String peek() throws Exception;
}
