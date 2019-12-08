package aaa;

public class Factory {
	public static Animal getInstance(String str) throws Exception{
		
		return (Animal)Class.forName(str).newInstance();
	}
}
