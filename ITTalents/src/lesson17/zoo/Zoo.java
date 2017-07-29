package lesson17.zoo;

import java.beans.FeatureDescriptor;

public class Zoo {

	private Animal[] animals;
	private int freePlaces;
	
	public Zoo() {
		this.animals = new Animal[10];
		this.freePlaces = animals.length;
	}
	
	void addAnimal(Animal a){
		if(freePlaces <= 0 ){
			System.out.println("yok mqsto");
			return;
		}
		animals[animals.length-freePlaces--] = a;
	}

	void feedThemAll(){
		for (int i = 0; i < animals.length; i++) {
			if(animals[i] != null){
				animals[i].feed();
			}
		}
	}
	
	void makeEclipseHappen(){
		System.out.println("The sun is blocked!");
		for (int i = 0; i < animals.length; i++) {
			if(animals[i] != null){
				animals[i].reactToSunBlock();
			}
		}
	}
}
