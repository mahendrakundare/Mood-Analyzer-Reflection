package com.bridgelabz;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserReflector {

    public static Constructor<?> getConstructor(Class<?>... param) throws MoodAnalysisException {
        try {
            Class<?> moodAnalyserClass = Class.forName("com.bridgelabz.MoodAnalyzer");
            return moodAnalyserClass.getConstructor(param);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException("Class Not Found", MoodAnalysisException.ExceptionType.NO_SUCH_CLASS);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException("Method Not Found", MoodAnalysisException.ExceptionType.NO_SUCH_METHOD);
        }
    }

    public static Object creatMoodAnalyser(Constructor<?> constructor, Object ... message ) throws MoodAnalysisException {
        try {
            return constructor.newInstance(message);
        } catch (IllegalAccessException e) {
            throw new MoodAnalysisException("Method Not Found", MoodAnalysisException.ExceptionType.NO_ACCESS);
        } catch (InstantiationException | InvocationTargetException e) {
            throw new MoodAnalysisException("Method Not Found", MoodAnalysisException.ExceptionType.OBJECT_CREATION_ISSUE);
        }
    }



//    public static MoodAnalyzer creatMoodAnalyser(String message) throws MoodAnalysisException {
//        try {
//            Class<?> moodAnalyserClass = Class.forName("com.bridgelabz.MoodAnal");
//            Constructor moodConstructor = moodAnalyserClass.getConstructor(String.class);
//            Object moodObj = moodConstructor.newInstance(message);
//            return (MoodAnalyzer) moodObj;
//        } catch (ClassNotFoundException e) {
//            throw new MoodAnalysisException("Class Not Found", MoodAnalysisException.ExceptionType.NO_SUCH_CLASS);
//        } catch (NoSuchMethodException e) {
//            throw new MoodAnalysisException("Method Not Found", MoodAnalysisException.ExceptionType.NO_SUCH_METHOD);
//        }  catch (IllegalAccessException e) {
//            throw new MoodAnalysisException("Method Not Found", MoodAnalysisException.ExceptionType.NO_ACCESS);
//        } catch (InstantiationException | InvocationTargetException e) {
//            throw new MoodAnalysisException("Method Not Found", MoodAnalysisException.ExceptionType.OBJECT_CREATION_ISSUE);
//        }
//    }

    public static Object invokeMethod(Object moodAnalyserObject , String methodName ) throws MoodAnalysisException {
        try {
             return moodAnalyserObject.getClass().getMethod(methodName).invoke(moodAnalyserObject);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException("Method Not Found",
                    MoodAnalysisException.ExceptionType.NO_SUCH_METHOD);
        }catch (IllegalAccessException |InvocationTargetException e) {
            throw  new MoodAnalysisException("Maybe issue with data entererd",
                    MoodAnalysisException.ExceptionType.METHOD_INVOCATION_ISSUE);
            }
    }

    public static void setFieldValue(Object myObject, String fieldName, String fieldValue) throws MoodAnalysisException {
        try {
            Field field = myObject.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(myObject,fieldValue);
        } catch (NoSuchFieldException e) {
            throw new MoodAnalysisException("field Not Found",
                    MoodAnalysisException.ExceptionType.NO_SUCH_FIELD);
        } catch (IllegalAccessException e) {
            throw new MoodAnalysisException("may be issue with data",
                    MoodAnalysisException.ExceptionType.NO_ACCESS);
        }
    }


}
