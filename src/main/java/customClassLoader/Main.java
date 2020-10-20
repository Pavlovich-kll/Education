package customClassLoader;

import customClassLoader.CustomClassLoader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Собственные загрузчики классов нужны для реализации рефлексии в Java.
 * Используя reflection API, мы сможем прочитать тестовый класс
 * с помощью нашего пользовательского загрузчика классов.
 *
 * Позволяют изолировать различные приложения, запущенные в пределах одной JVM
 *
 * Он изолирует различные веб-приложения, развернутые в контейнере;
 * то есть поведение веб-приложения не будет зависеть от (un)развертывания другого веб-приложения.
 *
 * Каждое веб-приложение видит только свои собственные классы,
 * а не те, которые предоставляются другими приложениями.
 *
 * Помощь в модификации существующего байт-кода
 *
 * переключение между различными реализациями драйверов осуществляется
 * через динамическую загрузку классов
 */

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException,
            NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {

        CustomClassLoader loader = new CustomClassLoader();
        Class<?> c = loader.findClass("customClassLoader.Test");
        Object ob = c.newInstance();//позволяет создать объект указанного класса
        Method md = c.getMethod("show");
        md.invoke(ob);//принимает объект на котором будет вызываться метод
    }
}