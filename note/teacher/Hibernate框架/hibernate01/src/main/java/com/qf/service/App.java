package com.qf.service;

import com.qf.pojo.MyUser;
import com.qf.pojo.YtUser;
import com.qf.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;

import java.sql.Connection;
import java.sql.SQLException;

public class App {

    public void initTable() {
        // 加载配置，初始化
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
    }

    // 插入数据
    public void addUser() {
        // 第一步：加载配置
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        // 第二步：得到工厂
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        // 第三步：得到session
        Session session = sessionFactory.openSession();
        session.doWork(new Work() {
            public void execute(Connection connection) throws SQLException {
                System.out.println("Hibernate底层默认提交事务的方式：" + connection.getAutoCommit());
            }
        });
        // 第四步：开启事务
        Transaction transaction = session.beginTransaction();
        // 第五步：执行动作
        YtUser pojo = new YtUser();
        pojo.setUsername("Java1718全体童鞋3");
        pojo.setPassword("没有密码3");
        session.save(pojo);
        // 添加后得到主键
        System.out.println("确认ID:" + pojo.getId());
        // 第六步：提交事务
        transaction.commit();
        // 第七步：关闭链接
        session.close();
        sessionFactory.close();
    }

    // 主键查询
    public void findById (Long id) {
        Session session = HibernateUtils.openSession();
        YtUser ytUser = session.get(YtUser.class, id);
        System.out.println(ytUser.getUsername() + "\t" + ytUser.getPassword());
        session.close();
    }

    // 更新数据
    public void updateT() {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        // 方式一 如果更新的是部分字段，先得到再更新，不然需要使用 HQL
        // YtUser ytUser = session.get(YtUser.class, 2L);
        // ytUser.setPassword("123456");
        // session.update(ytUser);
        // 方式二
        YtUser pojo = new YtUser();
        pojo.setId(2L);
        pojo.setUsername("222222");
        pojo.setPassword("222222");
        session.update(pojo);

        transaction.commit();
        session.close();
    }

    // 删除数据
    public void delId(Long id) {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        YtUser ytUser = session.get(YtUser.class, id);
        session.delete(ytUser);
        transaction.commit();
        session.close();
    }

    // 插入数据
    public void addMyUser() {
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        MyUser myUser = new MyUser();
        myUser.setUsername("2222");
        myUser.setPassword("不二");
        session.save(myUser);
        transaction.commit();
        session.close();
    }

    public static void main(String[] args ) {
        App app = new App();
        // app.initTable();
        // app.addUser();
        // app.findById(2L);
        // app.updateT();
        // app.delId(2L);
        app.addMyUser();
    }
}
