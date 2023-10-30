package packages;

public class Objects {
	private String Name;
	private String Code;
	private Double Price;
	private Double Discount;
	private int Amount;
	
	Objects(String name, String code, double price, double discount, int amount){
		this.Name = name;
		this.Code = code;
		this.Price = price;
		this.Discount = discount;
		this.Amount = amount;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public Double getPrice() {
		return Price;
	}

	public void setPrice(Double price) {
		Price = price;
	}

	public Double getDiscount() {
		return Discount;
	}

	public void setDiscount(Double discount) {
		Discount = discount;
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}

	
}

	