package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by helen 2018/1/19
 */
@ComponentScan
public class ApplicationSpring {

    public static void main(String[] args) {

        System.out.println("applicationSpring");
        /*//创建打印机对象
        MessagePrinter printer = new MessagePrinter();
        //创建消息服务对象
        MessageService service = new MessageService();
        //设置打印机对象的service属性
        printer.setService(service);
        //打印消息
        printer.printMessage();*/

        //初始化Spring容器
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationSpring.class);
        //从容器中获取MessagePrinter对象
        MessagePrinter printer = context.getBean(MessagePrinter.class);
        //从容器中获取MessageService对象
        //MessageService service = context.getBean(MessageService.class);

       //System.out.println(printer);
        //System.out.println(service);

        //设置打印机对象的service属性
        //printer.setService(service);
        //打印消息
        printer.printMessage();
    }
}
