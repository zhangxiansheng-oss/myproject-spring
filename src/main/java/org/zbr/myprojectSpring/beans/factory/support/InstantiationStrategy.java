package org.zbr.myprojectSpring.beans.factory.support;



import org.zbr.myprojectSpring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

//定义实例化策略接口
public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args);
}
