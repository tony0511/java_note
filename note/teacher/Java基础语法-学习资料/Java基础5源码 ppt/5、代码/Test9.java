
/**
	Object对象
*/
public class Test9{
	public static void main(String[] args){
		Student s = new Student(1,"飞飞",18);
		System.out.println(s);
		Student s2 = new Student(1,"飞飞",18);
		boolean b = s.equals(s2);
		System.out.println("student equals "+b);

		String str1 = new String("备备");
		String str2 = new String("备备");
		System.out.println(str1.equals(str2));

		System.out.println(s.getClass()==s2.getClass());


	}
}

class Student{
	private String name;
	private int sid;
	private int age;
	public Student(){}
	public Student(int sid,String name,int age){
		this.sid = sid;
		this.name = name;
		this.age = age;
	}
	//重写Object类中的toString方法
	public String toString(){
		return "sid="+sid+",name="+name+",age="+age;
	}

	//重写equals方法，来实现两个对象的比较
	public boolean equals(Object obj){
		if(this==obj){
			return true;
		}
		if(obj instanceof Student){
			Student s = (Student)obj;
			if(!this.name.equals(s.name)){
				return false;
			}
			if(this.sid!=s.sid){
				return false;
			}
			if(this.age!=s.age){
				return false;
			}
			return true;
		}
		return false;
	}
}