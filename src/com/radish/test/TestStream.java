package com.radish.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Description TestStream
 * @Author Radish
 * @Date 2020-11-11 08:33
 */
public class TestStream {
    public static void main(String[] args) throws Exception {
        /*ArrayList<Integer> list = new ArrayList<>();
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> limit = Stream.iterate(0, (x) -> x + 2).limit(6);
        limit.forEach(System.out::println);
        Stream<Double> limit1 = Stream.generate(Math::random).limit(2);
        limit1.forEach(System.out::println);
        BufferedReader reader = new BufferedReader(new FileReader("F:\\hhh.txt"));
        Stream<String> lines = reader.lines();
        lines.forEach(System.out::println);
        Pattern pattern = Pattern.compile(",");
        Stream<String> splitAsStream = pattern.splitAsStream("a,b,c,d");
        splitAsStream.forEach(System.out::println);
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 16, 7, 8, 9,8, 10);
        Stream<Integer> limit = stream.filter(s -> s > 5)
                .distinct()
                .skip(2)
                .limit(2);
        limit.forEach(System.out::println);*/

        List<String> list = Arrays.asList("a,b,c", "1,2,3");
        Stream<String> s1 = list.stream().map(s -> s.replaceAll(",", ""));
        s1.forEach(System.out::println);
        Stream<String> s3 = list.stream().flatMap(s -> {
            String[] split = s.split(",");
            Stream<String> s2 = Arrays.stream(split);
            return s2;
        });
        s3.forEach(System.out::println);
    }
}
