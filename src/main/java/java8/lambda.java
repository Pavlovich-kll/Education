package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class lambda {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("2");
        list.add("3");
        list.add("1");

        List<String> sortedList = sort(list);
        sortedList.forEach(letter -> System.out.println(letter));
        //sortedList.forEach(System.out::print);


        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        backToString.apply("123");


        List<Car> cars = Arrays.asList(
                new Car("AA1111BX", 2007),
                new Car("AM1111BE", 2009),
                new Car("AK5555IT", 2010),
                new Car("AI5601CC", 2015),
                new Car("AI3838PP", 2017));

        cars.stream()
                .map(Car::getAge) // преобразовываем Stream машин в Stream номеров
                .filter(a -> a < 2010)
                .forEach(System.out::println);
    }

    public static class Car {
        private String number;
        private int age;

        public Car(String number, int age) {
            this.number = number;
            this.age = age;
        }

        public String getNumber() {
            return number;
        }

        public int getAge() {
            return age;
        }
    }


    static List<String> sort(List<String> list) {
        Collections.sort(list, (a, b) ->
                a.compareTo(b)
        );
        // или list.sort(String::compareTo);
        return list;
    }

}
