import java.util.*;
import java.io.*;

public class main_ {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int temp = 1,select_function;
		
		Item apple = new Item("Apple",10);
		Item book = new Item("Book",50);
		Item toast = new Item("Toast",20);
		Cart cart = new Cart();
		
		while(temp!=0){
			System.out.print("Menu : \n 1) Add item in cart \n 2) Delete item in cart \n 3) Update item in cart \n 4) Show Item In Cart \n 5) Genrate bill \n 6) Exit \n Select your option : ");
			select_function = Integer.parseInt(br.readLine());
			switch(select_function){
			case 1 :
					cart.addItem(apple,3); 
					break;
			case 2 : 
					cart.deleteItem(apple); 
					break;
			case 3 : 
					cart.updateItem(apple,2); 
					break;
			case 4 : 
					cart.showCart(); 
					break;
			case 5 : 
					cart.genrateBill(); 
					temp=0;
					break;
			case 6 : 
					temp=0; 
					break;
			}
		}
	}
}
