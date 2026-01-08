package org.zbr.myprojectSpring.beans.factory.support;


import org.zbr.myprojectSpring.beans.factory.config.BeanDefinition;

// 向注册表中注册 BeanDefinition
public interface  BeanDefinitionRegistry {

    /**
     * 向注册表中注册 BeanDefinition
     *
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
