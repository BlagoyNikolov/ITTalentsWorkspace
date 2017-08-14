package krasi;

public class Dog extends Animal {
	protected Food seekFood() {
        return new DogFood();
    }
	
//	protected DogFood seekFood() {
//	    return new DogFood();
//	}
}
