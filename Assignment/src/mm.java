import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class mm {
	
		/**
		 * take input for item quantity
		 *
		 * @param no parameter required
		 * @return the integer value as number of item
		 */
		public static int quantity()throws IOException{
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("Enter Quantity : ");
				return Integer.parseInt(br.readLine());
		}
		
		/**
		 * take input for item name
		 *
		 * @param no parameter required
		 * @return the string value as name of item
		 */
		public static String selectItem()throws IOException{
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				int count = 0;
				String itemname;
				boolean flag ;
				
				System.out.println("Item section");
				System.out.println(String.format("%5s %20s %20s","S.No.", "Name of item", "Price of item"));
				for(HashMap.Entry<String, Integer> entry : ItemRecord.item.entrySet()){
						System.out.println(String.format("%5s %20s %20s",++count,entry.getKey(),entry.getValue()));
				}
				List<String> ListofKeys = new ArrayList<String>(ItemRecord.item.keySet());
				
				do{
						System.out.print("Select Item Using S.No. \nEnter Your Choice : ");
						itemname = ListofKeys.get(Integer.parseInt(br.readLine())-1);
						if(itemname == "-1"){
							flag = true;
							System.out.println("Wrong input try again");
						}
						else
							flag = false;
				}while(flag);
				
			return itemname;
		}
	
		public static void main(String args[]) throws IOException {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
				int temp = 1,select_function;
				
				cc cart = new cc();
				
				while(temp!=0){
						System.out.print("Menu : \n 1) Add item in cart \n 2) Delete item in cart \n 3) Update item in cart \n 4) Show Item In Cart \n 5) Genrate bill \n 6) Exit \n Select your option : ");
						select_function = Integer.parseInt(br.readLine());
						switch(select_function){
						case 1 :
								cart.addItem(selectItem(), quantity()); 
								break;
						case 2 : 
								cart.deleteItem(selectItem()); 
								break;
						case 3 : 
								cart.updateItem(selectItem(), quantity()); 
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
						default:
								System.out.println("Wrong Input..... Try again");
						}
				}
		}
	}


