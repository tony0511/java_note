package iterator;

/**
 * 迭代器模式
提供一个方法按顺序遍历一个集合内的元素，而又不需要暴露该对象的内部表示。

应用场景
1、访问一个聚合的对象，而不需要暴露对象的内部表示
2、支持对聚合对象的多种遍历
3、对遍历不同的对象，提供统一的接口。

迭代器模式的角色构成
(1)迭代器角色（Iterator）:定义遍历元素所需要的方法，一般来说会有这么三个方法：
	取得下一个元素的方法next()，判断是否遍历结束的方法hasNext()），移出当前对象的方法remove(),
(2)具体迭代器角色（Concrete Iterator）：实现迭代器接口中定义的方法，完成集合的迭代。
(3)容器角色(Aggregate):  一般是一个接口，提供一个iterator()方法，
	例如java中的Collection接口，List接口，Set接口等
(4)具体容器角色（ConcreteAggregate）：就是抽象容器的具体实现类，
	比如List接口的有序列表实现ArrayList，List接口的链表实现LinkList，
	Set接口的哈希列表的实现HashSet等。

 * @author vince
 * @description
 */
public class Test {
	public static void main(String[] args) {
		MyList list = new ConcreteAggregate();
		list.add("刘备");
		list.add("张飞");
		list.add("关羽");
		list.add("曹操");
		list.add("诸葛亮");
		Iterator iter = list.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}
}
