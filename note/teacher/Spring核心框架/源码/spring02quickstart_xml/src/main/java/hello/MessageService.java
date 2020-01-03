package hello;

/**
 * Created by helen 2018/1/19
 * 打印服务
 */
public class MessageService {

    public MessageService() {
        super();
        System.out.println("MessageService...");
    }

    /**
     * 执行打印功能
     * @return 返回要打印的字符串
     */
    public String getMessage(){
        return "Hello World!";
    }
}
