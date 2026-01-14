package org.zbr.myprojectSpring.beans.factory.support;


import org.zbr.myprojectSpring.BeansException;
import org.zbr.myprojectSpring.beans.BeanFactory;
import org.zbr.myprojectSpring.beans.factory.config.BeanDefinition;

//抽象类定义模板方法 继承了 工厂的抽象类 实现了工厂的抽象类
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry  implements BeanFactory {

    @Override
    // 实现BeanFactory获取bean对象,模板方法，只关注能直接获取到bean对象
    public Object getBean(String beanName) throws BeansException {
        return  doGetBean(beanName,null);
    }

    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        return  doGetBean(beanName,args);
    }

    protected  <T> T doGetBean(final String name,final  Object[] args){
        Object bean  =  getSingleton(name);
        if (null != bean){
            return  (T)bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T)creatBean(name,beanDefinition,args);
    }
    // 获取bean管理对象
    protected  abstract BeanDefinition getBeanDefinition(String beanName) throws  BeansException;
    // 创建bean类
    protected  abstract  Object creatBean(String beanName,BeanDefinition beanDefinition,Object[] args) throws  BeansException;

}

