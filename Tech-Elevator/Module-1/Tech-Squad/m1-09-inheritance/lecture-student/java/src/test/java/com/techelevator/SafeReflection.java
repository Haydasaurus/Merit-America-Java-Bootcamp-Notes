package com.techelevator;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class SafeReflection {

    /**
     * getConstructor wraps Reflection's getConstructor method so that it either returns a PUBLIC
     * constructor with the requested parameter types, or null.
     *
     * @param klass
     * @param parameterTypes
     * @return
     */
    public static Constructor getConstructor(Class<?> klass, Class<?>... parameterTypes) {
        try {
            return klass.getConstructor(parameterTypes);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * getField wraps Reflection's getField method so that it either returns a PUBLIC method
     * of the requested method name, or null.
     *
     * @param klass
     * @param fieldName
     * @return
     */
    public static Field getField(Class<?> klass, String fieldName) {
        try {
            return klass.getField(fieldName);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * getField wraps Reflection's getField method so that it either returns any method
     * of the requested method name, or null.
     *
     * @param klass
     * @param fieldName
     * @return
     */
    public static Field getDeclaredField(Class<?> klass, String fieldName) {
        try {
            return klass.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            return null;
        }
    }

    /**
     * getMethod wraps Reflection's getMethod method so that it either returns a PUBLIC method
     * of the requested method name, or null.
     *
     * @param klass
     * @param methodName
     * @return
     */
    public static Method getMethod(Class<?> klass, String methodName, Class<?>... parameterTypes) {
        try {
            //getMethod returns public methods whether they were declared in class or inherited.
            if (parameterTypes == null) {
                return klass.getMethod(methodName);
            } else {
                Class<?>[] types = new Class[parameterTypes.length];
                for (int i = 0; i < parameterTypes.length; i++) {
                    types[i] = parameterTypes[i];
                }
                return klass.getMethod(methodName, types);
            }
        } catch (Exception e) {
            return null;
        }
    }


    /**
     * Convenience method to check if field has a setter.
     *
     * @param klass
     * @param field
     * @return true if field has setter.
     */
    public static boolean hasSetter(Class<?> klass, String field) {
        Method[] methods = klass.getMethods();
        for (Method method : methods) {
            if(method.getName().equals("set" + field)){
                return true;
            }
        }
        return false;
    }

    /**
     * Convenience method to check if field has a getter.
     *
     * @param klass
     * @param field
     * @return true if field has setter.
     */
    public static boolean hasGetter(Class<?> klass, String field) {
        Method[] methods = klass.getMethods();
        for (Method method : methods) {
            if(method.getName().equals("get" + field)){
                return true;
            }
        }
        return false;
    }

}
