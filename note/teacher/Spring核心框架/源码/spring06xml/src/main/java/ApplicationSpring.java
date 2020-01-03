import com.qfedu.demo.soundsystem.CompactDisc;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by helen 2018/2/1
 */
public class ApplicationSpring {

    public static void main(String[] args) {
        System.out.println("ApplicationSpring is running......");

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-constructor.xml");
        CompactDisc cd1 = (CompactDisc)context.getBean("compactDisc1");
        CompactDisc cd2 = (CompactDisc)context.getBean("compactDisc2");
        cd1.play();
        cd2.play();
    }
}
