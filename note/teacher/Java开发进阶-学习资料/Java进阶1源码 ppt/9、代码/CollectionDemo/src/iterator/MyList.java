package iterator;

/**
 * 容器的接口
 * @author vince
 * @description
 */
public interface MyList {
  void add(Object e);
  Object get(int index);
  Iterator iterator();
  int getSize();
}
