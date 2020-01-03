package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by helen 2018/1/19
 */
public class ApplicationSpring {

    public static void main(String[] args) {

        System.out.println("applicationSpring");

        //初始化Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //从容器中获取MessagePrinter对象
        MessagePrinter printer = context.getBean(MessagePrinter.class);
        //打印消息
        printer.printMessage();
    }
}
