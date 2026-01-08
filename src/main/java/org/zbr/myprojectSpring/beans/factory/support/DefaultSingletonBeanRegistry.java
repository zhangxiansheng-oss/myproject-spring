package org.zbr.myprojectSpring.beans.factory.support;

import org.zbr.myprojectSpring.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

//这个类比较简单主要是定义了一个获取单例对象的接口。
public class DefaultSingletonBeanRegistry  implements SingletonBeanRegistry {

    private Map<String,Object> singletonObjects = new HashMap<>();

    @Override
    // 继承获取SingletonBeanRegistry中bean的抽象方法
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected  void addSingleton(String beanName,Object singletonObject){
        singletonObjects.put(beanName,singletonObject);
    }
}
