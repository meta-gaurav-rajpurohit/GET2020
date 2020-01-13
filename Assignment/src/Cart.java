import java.util.HashMap;
public class Cart {
		
		HashMap<Item, Integer> cart;
		
		public Cart(){
			cart = new HashMap<Item, Integer>();
		}
	
		public void addItem(Item item , int quantity){
			if(cart.containsKey(item)){
				cart.put(item,(cart.get(item) + quantity));
			}
			else
				cart.put(item, quantity);
		}
		
		public void updateItem(Item item , int quantity){
			if(cart.containsKey(item)){
				cart.put(item,quantity);
			}
			else
				System.out.println("Item not available in cart. ");
		}
		
		public void deleteItem(Item item){
			if(cart.containsKey(item)){
				cart.remove(item);
			}
			else
				System.out.println("Item not available in cart. ");
		}
		
		public void showCart(){
			System.out.println(String.format("%20s %20s %20s","Name of item","Quantity of item","Price of item"));
			for (HashMap.Entry<Item,Integer> entry : cart.entrySet())  
	            System.out.println(String.format("%20s %20s %20s",entry.getKey().getName(),entry.getValue(),(entry.getValue() * entry.getKey().getPrice())));
		}
		
		public void genrateBill(){
			System.out.println(String.format("%37s","SHOPPING BILL")+"\n==============================================================");
			this.showCart();
			System.out.println("\n==============================================================");

		}
}
