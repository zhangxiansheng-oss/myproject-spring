package org.zbr.myprojectSpring.beans.factory.support;

import org.zbr.myprojectSpring.BeansException;
import org.zbr.myprojectSpring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

//实例化Bean类 从 beanDefinition 变成 bean不能直接从对象map里面取，生成对象 放入对象map
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{
    private  InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object creatBean(String beanName, BeanDefinition beanDefinition,Object[] args) throws BeansException {
        Object bean = null;
        try {
            bean =    createBeanInstance(beanDefinition, beanName, args);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName, bean);
        return bean;
    }

    private Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructor = null;
        Class beanClass = beanDefinition.getBeanClass();
        Constructor[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor ctor  : declaredConstructors) {
            if (null != args &&  ctor.getParameterTypes().length == args.length){
                constructor = ctor;
                break;
            }
        }
        return  getInstantiationStrategy().instantiate(beanDefinition,beanName,constructor,args);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }

}
