package org.zbr.myprojectSpring.beans.factory.support;


import org.zbr.myprojectSpring.BeansException;
import org.zbr.myprojectSpring.beans.BeanFactory;
import org.zbr.myprojectSpring.beans.factory.config.BeanDefinition;

//抽象类定义模板方法 继承了 工厂的抽象类 实现了工厂的抽象类
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry  implements BeanFactory {

    @Override
    // 实现BeanFactory获取bean对象,模板方法，只关注能直接获取到bean对象
    public Object getBean(String beanName) throws BeansException {
        Object bean  =  getSingleton(beanName);
        if (null != bean){
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return creatBean(beanName,beanDefinition);
    }
   // 获取bean管理对象
    protected  abstract BeanDefinition getBeanDefinition(String beanName) throws  BeansException;
    // 创建bean类
    protected  abstract  Object creatBean(String beanName,BeanDefinition beanDefinition) throws  BeansException;

}

