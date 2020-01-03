package soundsystem;

import org.springframework.stereotype.Component;

/**
 * Created by helen 2018/1/25
 */
@Component
public class Power {

    public Power() {
        super();
    }

    public void supply(){
        System.out.println("电源供电中......");
    }
}
