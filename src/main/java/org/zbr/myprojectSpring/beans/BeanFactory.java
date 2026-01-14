package org.zbr.myprojectSpring.beans;

import org.zbr.myprojectSpring.BeansException;
import org.zbr.myprojectSpring.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

// 定义管理对象的接口工厂
public interface  BeanFactory {

  Object getBean(String beanName) throws BeansException;

  Object getBean(String beanName, Object... args) throws BeansException;
}
