package com.solvd.travelagency.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.*;
import java.util.Arrays;

public class ReflectionUtil {
    private static final Logger LOGGER = LogManager.getLogger(ReflectionUtil.class);

    public static Class getaClass(String className) {
        Class clazz = null;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            LOGGER.error("Exception :" + e);
        }
        return clazz;
    }

    public static void invokeMethod(Class clazz, Object obj, String methodName, String value) {
        Method setName = null;
        try {
            setName = clazz.getDeclaredMethod(methodName, String.class);
            setName.invoke(obj, value);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            LOGGER.error("Exception :" + e);
        }

    }

    public static Object instantiateObject(Class clazz, String value) {
        Constructor constructor = null;
        Object obj = null;
        try {
            constructor = clazz.getConstructor(String.class);
            obj = constructor.newInstance(value);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            LOGGER.error("Exception :" + e);
        }
        return obj;
    }

    public static void printConstructors(Class clazz) {
        LOGGER.debug("Constructors from class ##### " + clazz.getName());
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            StringBuffer buf = new StringBuffer();
            buf.append(Modifier.toString(constructor.getModifiers())).append(" ");
            buf.append(constructor.getName()).append(" ");
            buf.append("(").append(Arrays.stream(constructor.getParameters())
                    .map(parameter -> buf.append(parameter.getParameterizedType().getTypeName() + " " + parameter.getName())).count()).append(")").append(" ");
            LOGGER.debug(buf.toString());
        }
    }

    public static void printFields(Class clazz) {
        LOGGER.debug("Fields from class ##### " + clazz.getName());
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            StringBuffer buf = new StringBuffer();
            buf.append(Modifier.toString(field.getModifiers())).append(" ");
            buf.append(field.getType().getName()).append(" ");
            buf.append(field.getName()).append(" ");
            LOGGER.debug(buf.toString());
        }
    }

    public static void printMethods(Class clazz) {
        LOGGER.debug("Methods from class ##### " + clazz.getName());
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            StringBuffer buf = new StringBuffer();
            buf.append(Modifier.toString(method.getModifiers())).append(" ");
            buf.append(method.getReturnType().getName()).append(" ");
            buf.append(method.getName()).append(" ");
            buf.append("(").append(Arrays.stream(method.getParameters())
                    .map(parameter -> buf.append(parameter.getParameterizedType().getTypeName() + " " + parameter.getName())).count()).append(")").append(" ");
            LOGGER.debug(buf.toString());
        }
    }


}
