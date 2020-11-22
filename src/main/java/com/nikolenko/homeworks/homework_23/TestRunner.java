package com.nikolenko.homeworks.homework_23;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
Usage:
TestRunner testFileName [packageName]
 */

public class TestRunner {
    static private String testClassName;
    static private boolean result;

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No input data \nUsage: \n TestRunner testFileName [packageName]");
            testClassName = null;
            return;
        }
        if (args.length == 1) {
            String[] dirs = Thread.currentThread().getStackTrace()[1].getClassName().split("\\.");
            StringBuilder thisPackage = new StringBuilder();
            for (int i = 0; i < dirs.length - 1; i++) {
                thisPackage.append(dirs[i]).append('.');
            }
            thisPackage.append(args[0]);
            testClassName = thisPackage.toString();
        }
        if (args.length > 1) {
            testClassName = args[1] + '.' + args[0];
        }
        Class<?> cl = null;
        try {
            cl = Class.forName(testClassName);
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }
        Object testInstance = null;
        if(cl == null){
            result = false;
            return;
        }
        try {
            testInstance = cl.newInstance();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        Method[] method = cl.getMethods();
        for (Method md : method) {
            if (md.isAnnotationPresent(MyBeforeAll.class)) {
                try {
                    md.invoke(null);
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
        }
        for (Method md : method) {
            if (md.isAnnotationPresent(MyTest.class)) {
                try {
                    md.invoke(testInstance);
                } catch (InvocationTargetException ite) {
                    result = false;
                    System.out.println("******* " + md.getName() + " not passed" + " *******");
                    continue;
                } catch (Exception e) {
                    result = false;
                    System.out.println("------- " + md.getName() + "internal error happened" + " ------");
                    return;
                }
                result = true;
                System.out.println("\u2714 " + md.getName() + " passed");
            }
        }
    }

    //Just for testing purposes
    static String getTestClassName() {
        return testClassName;
    }
    static boolean getresult() {
        return result;
    }
}
