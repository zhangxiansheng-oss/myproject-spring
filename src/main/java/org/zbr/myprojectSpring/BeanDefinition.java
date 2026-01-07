package org.zbr.myprojectSpring;

//定义bean对象
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean(){
        return bean;
    }
}
