package org.zbr.myprojectSpring;

import org.junit.jupiter.api.Test;
import org.zbr.myprojectSpring.beans.BeanFactory;
import org.zbr.myprojectSpring.beans.UserService;
import org.zbr.myprojectSpring.beans.factory.config.BeanDefinition;
import org.zbr.myprojectSpring.beans.factory.support.DefaultListableBeanFactory;

public class ApiTest {

/*    @Test
    public void test_BeanFactory(){
        // 1.初始化 BeanFactory
        BeanFactory beanFactory = new BeanFactory();

        // 2.注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3.获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }*/

    @Test
    public void test_BeanFactory(){
        // 初始化获取注册表的方法
        DefaultListableBeanFactory beanFactory  = new DefaultListableBeanFactory();
        //注册beanDefinition
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory .registerBeanDefinition("userService", beanDefinition);

        UserService userService_singleton = (UserService) beanFactory.getBean("userService","啊张");
        userService_singleton.queryUserInfo();


    }
}
