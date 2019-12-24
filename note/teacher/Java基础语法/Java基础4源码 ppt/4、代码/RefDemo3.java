//示例四：String传递
public class RefDemo3{
  public static void main(String[] args){
    Person p  = new Person();
    method(p) ;
    System.out.println("person name= "+p.name) ;
  }
  public static void method(Person per){
    per.name = "备备";
  }
}
class Person{
  String name = "飞飞";   //省略封装
}

