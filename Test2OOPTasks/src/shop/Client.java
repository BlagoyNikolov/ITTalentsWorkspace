package shop;

public class Client {
	private Shop shop;
	private double money;
	private int maxItems;
	private ShoppingCart shoppingCart;
	private int currentMaxItems;

	public Shop getShop() {
		return shop;
	}

	public double getMoney() {
		return money;
	}
	
	public void setMoney(double money) {
		this.money = money;
	}
	
	public int getMaxItems() {
		return maxItems;
	}
	
	public void setMaxItems(int maxItems) {
		this.maxItems = maxItems;
	}


	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}
	
	public int getCurrentMaxItems() {
		return currentMaxItems;
	}
	
	public void setCurrentMaxItems(int currentMaxItems) {
		this.currentMaxItems = currentMaxItems;
	}

	public Client(Shop shop, double money, int maxItems, ShoppingCart shoppingCart) {
		this.shop = shop;
		this.money = money;
		this.maxItems = maxItems;
		this.shoppingCart = shoppingCart;
		this.currentMaxItems = maxItems;
	}

	public void addItemBroika(Broika broika, int amount) {
		if (broika != null) {
			if (amount > 0) {
				for (int i = 0; i < amount; i++) {
					if (this.getCurrentMaxItems() > 0) {
						this.getShoppingCart().getProductBroika().add(broika);
						this.setCurrentMaxItems(this.getCurrentMaxItems() - 1);
						System.out.println("Client has added a " + broika.getName());
					}
				}
				for (Product p : this.getShop().getProducts()) {
					if (p.getName().equals(broika.getName()) && this.getMaxItems() >= 0) {
						if (this.getCurrentMaxItems() == 0) {
							((Broika) p).setQuantity(broika.getQuantity() - this.getMaxItems());
						} else {
							((Broika) p).setQuantity(broika.getQuantity() - amount);
						}
					}
				}
				System.out.println("can buy " + this.getCurrentMaxItems() + " more items");
			} else {
				System.out.println("Invalid amount");
			}
		} else {
			System.out.println("Invalid product broika");
		}
	}
	
	public void removeItemBroika(Broika broika, int amount) {
		if (broika != null) {
			if (amount > 0) {
				for (int i = 0; i < amount; i++) {
					if (this.getCurrentMaxItems() > 0 && this.getCurrentMaxItems() < 10) {
						this.getShoppingCart().getProductBroika().remove(broika);
						this.setCurrentMaxItems(this.getCurrentMaxItems() + 1);
						System.out.println("Client has removed a " + broika.getName());
					}
				}
				for (Product p : this.getShop().getProducts()) {
					if (p.getName().equals(broika.getName()) && this.getMaxItems() >= 0) {
						if (this.getCurrentMaxItems() == 10) {
							((Broika) p).setQuantity(broika.getQuantity() + this.getMaxItems());
						} else {
							((Broika) p).setQuantity(broika.getQuantity() + amount);
						}
					}
				}
				System.out.println("can buy " + this.getCurrentMaxItems() + " more items");
			} else {
				System.out.println("Invalid amount");
			}
		} else {
			System.out.println("Invalid product broika");
		}
	}

	public void addItemKilogram(Kilogram kilogram, double kilograms) {
		if (kilogram != null) {
			if (kilograms > 0) {
				if (this.getCurrentMaxItems() > 0) {
					this.getShoppingCart().getProductKilogram().add(kilogram);
					this.setCurrentMaxItems(this.getCurrentMaxItems() - 1);
					System.out.println("Client has added " + kilogram.getName() + " weighing at " + kilograms);
				}
				for (Product p : this.getShop().getProducts()) {
					if (p.getName().equals(kilogram.getName()) && this.getMaxItems() >= 0) {
						if (kilogram.getKilograms() > kilograms) {
							((Kilogram) p).setKilograms(kilogram.getKilograms() - kilograms);
						} else {
							((Kilogram) p).setKilograms(0);
						}
					}
				}
				System.out.println("can buy " + this.getCurrentMaxItems() + " more items");
			} else {
				System.out.println("Invalid amount");
			}
		} else {
			System.out.println("Invalid product broika");
		}
	}

	public void removeItemKilogram(Kilogram kilogram, double kilograms) {
		if (kilogram != null) {
			if (this.getCurrentMaxItems() > 0) {
				this.getShoppingCart().getProductKilogram().remove(kilogram);
				this.setCurrentMaxItems(this.getCurrentMaxItems() + 1);
				System.out.println("Client has removed " + kilogram.getName());
			}
			for (Product p : this.getShop().getProducts()) {
				if (p.getName().equals(kilogram.getName()) && this.getMaxItems() >= 0) {
					((Kilogram) p).setKilograms(kilogram.getKilograms() + kilograms);
				}
			}
			System.out.println("can buy " + this.getCurrentMaxItems() + " more items");
		} else {
			System.out.println("Invalid product broika");
		}
	}

	public void payAll() {
		ShoppingCart sc = this.getShoppingCart();
		double sum = 0;
		for (Broika b : sc.getProductBroika()) {
			sum += b.getPrice();
		}
		for (Kilogram k : sc.getProductKilogram()) {
			sum += k.getPrice() * k.getKilograms();
		}
		if (this.getMoney() >= sum) {
			this.setMoney(this.getMoney() - sum);
			this.getShop().setMoney(this.getShop().getMoney() + sum);
		} else {
			System.out.println("Client has insufficient funds");
		}
	}
}
