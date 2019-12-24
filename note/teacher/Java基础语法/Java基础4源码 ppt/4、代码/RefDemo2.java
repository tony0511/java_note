//示例三：String传递
//字符串本身就是一个对象
public class RefDemo2{
  public static void main(String[] args){
    String name = "小飞";
    method(name) ;
    System.out.println("name="+name) ;
  }
  public static void method(String sname){
    sname = "小备";
  }
}
