package com.yeyu.base.注解;

import java.io.FileNotFoundException;
import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface MyMethodAnnotation{
    public String title() default "";
    public String description() default "";
}

public class 自定义注解 {
    @Override
    @MyMethodAnnotation(title = "toStringMethod", description = "override toString method")
    public String toString() {
        return "Override toString method";
    }

    @Deprecated
    @MyMethodAnnotation(title = "old static method", description = "deprecated old static method")
    public static void oldMethod() {
        System.out.println("old method, don't use it.");
    }

    @SuppressWarnings({"unchecked", "deprecation"})
    @MyMethodAnnotation(title = "test method", description = "suppress warning static method")
    public static void genericsTest(){
        List l = new ArrayList();
        l.add("abc");
        oldMethod();
    }


    public static void main(String[] args) {
        int a = 1997;
        Integer b = 1997;
        Integer c = 1997;
        System.out.println(a == 1997);
        System.out.println(b == c);
//        Arrays.stream(自定义注解.class.getMethods()).forEach((Method method)->{
//            boolean annotationPresent = method.isAnnotationPresent(MyMethodAnnotation.class);
//            if (annotationPresent) {
//                Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
//                Arrays.stream(declaredAnnotations).forEach((Annotation annotation)->{
//                    System.out.println(method+","+annotation);
//                });
//                MyMethodAnnotation myMethodAnnotation = method.getAnnotation(MyMethodAnnotation.class);
//                System.out.println(myMethodAnnotation.title());
//            }
//        });
    }
}
