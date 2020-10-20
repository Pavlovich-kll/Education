package dynamic_proxy.cache;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//доступ к аннотации во время выполнения программы
@Target(ElementType.METHOD)//аннотация будет использовать тип элемента METHOD
public @interface Cache {
    //дефолтные настройки кэша - запись в файл
    CacheType cacheType() default CacheType.IN_FILE;
    String fileNamePrefix() default "";
    boolean zip() default false;
    Class[] identityBy() default {};
    int listLength() default -1;
}