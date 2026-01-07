package org.zbr.myprojectSpring;

import java.util.HashMap;
import java.util.Map;

// bean工厂 管理bean
public class BeanFactory {

    private Map<String,BeanDefinition>  beanDefinitionMap = new HashMap<>();

    public Object getBean(String name){
        return beanDefinitionMap.get(name).getBean();
    }

    public  void registerBeanDefinition(String name,BeanDefinition beanDefinition){
        beanDefinitionMap.put(name,beanDefinition);
    }
}
