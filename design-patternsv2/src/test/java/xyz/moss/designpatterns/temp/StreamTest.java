package xyz.moss.designpatterns.temp;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author zhangshipeng
 * @date 2021/1/19
 */

public class StreamTest {
    @Test
    public void test() {
        int[] ints = IntStream.range(0, 5)
                .peek(System.out::println)
                .sorted()
                .skip(2)
                .limit(100)
                .toArray();
        System.out.println(Arrays.toString(ints));

        List<Integer> collect = IntStream.iterate(0, i -> i + 2).limit(100).boxed().collect(Collectors.toList());
        String collect1 = IntStream.range(0, 3).mapToObj(String::valueOf).collect(Collectors.joining(",", "(", ")"));

        System.out.println(collect1);
        //System.out.println(Arrays.toString(ints1));
        System.out.println(IntStream.range(Integer.MAX_VALUE - 3, Integer.MAX_VALUE).sum());
        System.out.println(IntStream.range(Integer.MAX_VALUE - 10, Integer.MAX_VALUE).count());

        System.out.println(IntStream.range(Integer.MAX_VALUE - 3, Integer.MAX_VALUE).asLongStream().sum());
        System.out.println(IntStream.range(Integer.MAX_VALUE - 3, Integer.MAX_VALUE).boxed().collect(Collectors.averagingDouble(t -> t)));

        String[] strings = java.util.stream.Stream.of("cat", "dog", "elephant", "fox", "rabbit", "duck").toArray(String[]::new);

        Map<String, String> books = new HashMap<>();
        books.put(
                "978-0201633610", "Design patterns : elements of reusable object-oriented software");
        books.put(
                "978-1617291999", "Java 8 in Action: Lambdas, Streams, and functional-style programming");
        books.put("978-0134685991", "Effective Java");

        Optional<String> first = books.entrySet().stream()
                .filter(e -> "Java".equals(e.getValue()))
                .map(Map.Entry::getKey)
                .findFirst();

        int sum = IntStream.range(1, 3).sum();
        System.out.println("-");
        IntStream intStream = IntStream.range(0, 3).filter(value -> value > 1);
        intStream.forEach(System.out::println);
        System.out.println("-");
        IntStream range = IntStream.range(0, 10).filter(i -> i % 2 == 0);
        range.forEach(System.out::println);

        ImmutableList<Integer> collect2 = Optional.of(collect).map(Collection::stream)
                .orElse(java.util.stream.Stream.empty())
                .collect(ImmutableList.toImmutableList());
    }
}
