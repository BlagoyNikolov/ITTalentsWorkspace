package warehouse;

import java.util.ArrayList;

import warehouse.Fruit.FruitType;
import warehouse.Meat.MeatType;
import warehouse.Vegetable.VegetableType;

public abstract class ProductContainer {
	private ArrayList<Product> products;
	
	public ArrayList<Product> getProducts() {
		return products;
	}

	public ProductContainer() {
		this.products = new ArrayList<>();
		this.getProducts().add(new Fruit("Banana", 15, FruitType.Banana));
		this.getProducts().add(new Fruit("Orange", 15, FruitType.Orange));
		this.getProducts().add(new Fruit("Apple", 15, FruitType.Apple));
		this.getProducts().add(new Vegetable("Potato", 15, VegetableType.Potato));
		this.getProducts().add(new Vegetable("Eggplant", 15, VegetableType.Eggplant));
		this.getProducts().add(new Vegetable("Cucumber", 15, VegetableType.Cucumber));
		this.getProducts().add(new Meat("Pork", 15, MeatType.Pork));
		this.getProducts().add(new Meat("Beef", 15, MeatType.Beef));
		this.getProducts().add(new Meat("Chicken", 15, MeatType.Chicken));
	}
}
