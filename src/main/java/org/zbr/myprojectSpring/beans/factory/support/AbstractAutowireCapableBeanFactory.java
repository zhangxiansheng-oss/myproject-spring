package org.zbr.myprojectSpring.beans.factory.support;

import org.zbr.myprojectSpring.BeansException;
import org.zbr.myprojectSpring.beans.factory.config.BeanDefinition;

//实例化Bean类 从 beanDefinition 变成 bean不能直接从对象map里面取，生成对象 放入对象map
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{
    @Override
    protected Object creatBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {
            bean =   beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException  | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName, bean);
        return bean;
    }

}
