package com.qfedu.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class NotepadTestAutowrited {

    /*@Autowired
    private Notepad notepad1;

    @Autowired
    private Notepad notepad2;*/

    /**
     * scope="singleton"
     * （1）无论我们是否去主动获取或注入bean对象，Spring上下文一加载就会创建bean对象
     * （2）无论注入多少次，拿到的都是同一个对象
     *
     * scope="prototype"
     * （1）Spring上下文加载的时候不会创建bean对象
     * （2）每次注入，都会拿到不同的bean对象
     */
    @Test
    public void test01(){
        //System.out.println(notepad1 == notepad2);
    }
}
