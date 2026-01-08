package org.zbr.myprojectSpring.beans.factory.support;

import org.zbr.myprojectSpring.BeansException;
import org.zbr.myprojectSpring.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

// 这里实际管理  BeanDefinition 对象的存取 AbstractAutowireCapableBeanFactory 实际也是继承AbstractBeanFactory
public class DefaultListableBeanFactory  extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    private Map<String,BeanDefinition> beanDefinitionMap = new HashMap<>();
    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName,beanDefinition);
    }

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) throw new BeansException("No bean named '" + beanName + "' is defined");
        return beanDefinition;
    }
}
