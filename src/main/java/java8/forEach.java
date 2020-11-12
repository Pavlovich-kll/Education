package java8;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class forEach {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 6, 8, 3, 5, 7);
        list.forEach(nums -> {
            if (nums > 3) {
                System.out.println(nums);
            }
        });

        list.stream()
                .filter(i -> i % 2 == 0)
                .map(i -> i * 2)
                .forEach(System.out::println);

        Random random = new Random();
        random.ints()
                .limit(10)
                .sorted()
                .forEach(System.out::println);

        List<String> names = Arrays.asList("koko", "lonunu", "grabli");
        getNames(names);
    }


    static List<String> getNames(List<String> names) {
        names.stream()
                .filter(n->n.contains("l"))
                .forEach(System.out::println);
        return names;
    }
}