package com.vince.test;

import com.vince.framework.BeanFactory;
import com.vince.service.ClothesService;
import org.junit.Test;

public class BeanFactoryTest {

    @Test
    public void getBean(){
        BeanFactory beanFactory = BeanFactory.init();
        ClothesService clothesService = (ClothesService)beanFactory.getBean("clothesService");
        System.out.println(clothesService);
    }
}
