
/**
	代理模式（Proxy）：为其他对象提供一种代理以控制对这个对象的访问。
	代理模式说白了就是“真实对象”的代表，在访问对象时引入一定程度的间接性，
	因为这种间接性可以附加多种用途。

*/
public class Test11{
	public static void main(String[] args){
		Action userAction = new UserAction();
		ActionProxy proxy = new ActionProxy(userAction);
		proxy.doAction();
	}
}

class ActionProxy implements Action{

	private Action target;//被代理的对象

	public ActionProxy(Action target){
		this.target = target;
	}

	//执行操作
	public void doAction(){
		long startTime = System.currentTimeMillis();

		target.doAction();//执行真正的业务


		long endTime = System.currentTimeMillis();
		System.out.println("共耗时："+(endTime-startTime));
	}
}

interface Action{
	public void doAction();
}

class UserAction implements Action{
	public void doAction(){
		for(int i=0;i<100;i++){
			System.out.println("用户开始工作...");
		}

	}
}