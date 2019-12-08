package aaa;

public class Test {
	public static void main(String[] args) {
		try {
			Animal dog = Factory.getInstance("aaa.Dog");
			Animal cat = Factory.getInstance("aaa.Cat");
			
			dog.speak();
			cat.speak();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
