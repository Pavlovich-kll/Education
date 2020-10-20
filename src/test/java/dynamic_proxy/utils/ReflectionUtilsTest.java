package dynamic_proxy.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReflectionUtilsTest {

    @Test
    void getPrimitiveClass() {
        //(Byte, Short, Integer, Long, Float, Double)
        assertEquals(ReflectionUtils.GetPrimitiveClass(Byte.class), byte.class);
        assertEquals(ReflectionUtils.GetPrimitiveClass(Short.class), short.class);
        assertEquals(ReflectionUtils.GetPrimitiveClass(Integer.class), int.class);
        assertEquals(ReflectionUtils.GetPrimitiveClass(Long.class), long.class);
        assertEquals(ReflectionUtils.GetPrimitiveClass(Float.class), float.class);
        assertEquals(ReflectionUtils.GetPrimitiveClass(Double.class), double.class);
    }
}