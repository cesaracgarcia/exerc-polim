package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product{
	
	private Date manafacturedDate;
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	
	public UsedProduct () {
	}

	public UsedProduct(String name, Double price, Date manafacturedDate) {
		super(name, price);
		this.manafacturedDate = manafacturedDate;
	}

	public Date getManafacturedDate() {
		return manafacturedDate;
	}

	public void setManafacturedDate(Date manafacturedDate) {
		this.manafacturedDate = manafacturedDate;
	}

	@Override
	public String priceTag() {
		return super.getName() + " $ " + String.format("%.2f", super.getPrice()) + "( Manafactured date: " + df.format(manafacturedDate) + ")";
	}
	
}
