public class Item {
	double price;
	public String name;
	
	public Item(String name, double price){
		this.price = price;
		this.name = name;
	}
	
	double getPrice(){
		return price;
	}
	
	String getName(){
		return name;
	}
}
