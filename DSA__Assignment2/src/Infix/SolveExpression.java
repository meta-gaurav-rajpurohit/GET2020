package Infix;

public class SolveExpression {
	
	private String inputExpression;

	private StackClass operatorStack = new StackClass();

	private StackClass operandStack = new StackClass();

	public int evaluateExpression(String inputExpression) throws Exception{
		
		if (inputExpression == null){
			throw new Exception ("Invalid input");
		}
		
		String[] inputArray = inputExpression.split(" ");
		
		for (int iterator = 0 ; iterator < inputArray.length ; iterator++){
			if ("(".equals(inputArray[iterator])){
				operatorStack.push(inputArray[iterator]);
			}
			else if (")".equals(inputArray[iterator])){
				while (!"(".equals(operatorStack.peek())){
					
					operandStack.push(Integer.toString(createBinaryExpression(operatorStack, operandStack)));
				}
				
				operatorStack.pop();
			}	
			
			else if (isOperator(inputArray[iterator])){
				while ((!operatorStack.isEmpty()) && getOperatorPrecedence(inputArray[iterator]) 
				        >= getOperatorPrecedence(operatorStack.peek()) && (!"(".equals(operatorStack.peek())) ){
					operandStack.push(Integer.toString(createBinaryExpression(operatorStack, operandStack)));
				}	
				operatorStack.push(inputArray[iterator]);
			}
			else{
				//pushing operands to stack
				operandStack.push(inputArray[iterator]);
			}	
		}
		
		while (!operatorStack.isEmpty()){
			operandStack.push(Integer.toString(createBinaryExpression(operatorStack, operandStack)));
		}
		return Integer.parseInt(operandStack.pop());
	}
	
	private boolean isOperator(String operator) {
		switch (operator){
		case "+":
		case "-":
		case "*":
		case "/":
		case "%":
		case ">":
		case ">=":
		case "<":
		case "<=":
		case "&&":
		case "||":
		case "==":
		case "!=":
			return true;
		default :
			return false;
		}
	}

	private int getOperatorPrecedence(String operator){
		int operatorPrecedence = 0;
		switch (operator){
		case "*":
		case "/":
		case "%":
			operatorPrecedence = 1;
			break;
		case "+":
		case "-":
			operatorPrecedence = 2;
			break;
		case "==":
		case "!=":
			operatorPrecedence = 3;
			break;
		case ">":
		case "<":
		case ">=":
		case "<=":
			operatorPrecedence = 4;
			break;
		case "&&":
			operatorPrecedence =5;
			break;
		case "||":
			operatorPrecedence = 6;
			break;
		}
		return operatorPrecedence;	
	}
	
	private int createBinaryExpression(StackClass operatorStack, StackClass operandStack) throws Exception{
		if ((operatorStack==null)||(operandStack==null)){
			throw new Exception ("Null stacks");
		}
		
		//calling function to solve the expression 
		return (solveBinaryExpression(operandStack.pop(), operandStack.pop(), operatorStack.pop()));
	}
	
	private int solveBinaryExpression(String operand1, String operand2, String operator) throws Exception {
		int result=0;
		int firstOperand = Integer.parseInt(operand1);
		int secondOperand = Integer.parseInt(operand2);
		switch (operator){
		case "+":
			result = secondOperand+firstOperand;
			break;
		case "-":
			result = secondOperand-firstOperand;
			break;
		case "*":
			result = secondOperand*firstOperand;
			break;
		case "/":
			result = secondOperand/firstOperand;
			break;
		case "%":
			result = secondOperand%firstOperand;
			break;
		case ">":
			if (secondOperand>firstOperand){
				result = 1;
			}
			else{
				result =0;
			}
			break;
		case ">=":
			if (secondOperand>=firstOperand){
				result = 1;
			}
			else{
				result =0;
			}
			break;	
		case "<":
			if (secondOperand<firstOperand){
				result = 1;
			}
			else{
				result =0;
			}
			break;	
		case "<=":
			if (secondOperand<=firstOperand){
				result = 1;
			}
			else{
				result =0;
			}
			break;	
		case "==":
			if (secondOperand==firstOperand){
				result = 1;
			}
			else{
				result =0;
			}
			break;	
		case "!=":
			if (secondOperand!=firstOperand){
				result = 1;
			}
			else{
				result = 0;
			}
			break;	
		case "&&":
			if ((secondOperand==0)||(firstOperand==0)){
				result = 0;
			}
			else{
				result =1;
			}
			break;	
		case "||":
			if ((secondOperand>=1)||(firstOperand<=1)){
				result = 1;
			}
			else{
				result =0;
			}
			break;		
		default :
			throw new Exception ("Invalid operator");
		}
		return result;
	}
}
