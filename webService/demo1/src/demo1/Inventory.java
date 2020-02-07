package demo1;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Inventory {
	
	private String name;
	private int quantity;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "inventory [name=" + name + ", quantity=" + quantity + "]";
	}
	
}
