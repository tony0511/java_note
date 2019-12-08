package iterator;

/**
 * 容器接口的具体实现类
 * @author vince
 * @description
 */
public class ConcreteAggregate implements MyList{
	private Object[] elements; // 对象数组
	private int size;
	private int index;
	public ConcreteAggregate() {
		elements = new Object[100];
	}
	@Override
	public void add(Object e) {
		elements[index++] = e;
		size++;
	}
	@Override
	public Object get(int index) {
		return elements[index];
	}
	@Override
	public Iterator iterator() {
		return new ConcreteIterator(this);
	}
	@Override
	public int getSize() {
		return size;
	}
}
