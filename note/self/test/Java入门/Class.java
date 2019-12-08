public class Class {
  public static void main (String[] args) {
    test();
  }
  public static void test () {
    Horse h = null; // 声明一个类的变量（除了八种基本数据类型外都是引用数据类型）
    h = new Horse(); // 创建一个类的实例对象
    h.name = "赤兔马";
    h.setAge(6);
    h.run();
    System.out.println(h.getAge());
  }
}

class Horse {
  String name;
  private int age; // 私有的属性和方法只能在本类中访问
  public void run () {
    System.out.println("我的名字叫" + name + "，我" + age + "岁了");
  }

  // getter / setter 方法
  public void setAge(int age) { // 暴露一个修改私有属性的方法
    this.age = age;
  }
  public int getAge() { // 暴露一个获取私有属性的方法
    return this.age;
  }
}
