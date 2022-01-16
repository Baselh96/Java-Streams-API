package lectures;


import beans.Car;
import mockdata.MockData;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lecture8 {

  @Test
  public void simpleGrouping() throws Exception {
    Map<String, List<Car>> collect = MockData.getCars()
            .stream()
            .collect(Collectors.groupingBy(Car::getMake));

    collect.forEach((key, value) -> {
      System.out.println(key);
      value.forEach(System.out::println);
    });

  }

  @Test
  public void groupingAndCounting() throws Exception {
    ArrayList<String> names = Lists
        .newArrayList(
            "John",
            "John",
            "Mariam",
            "Alex",
            "Mohammado",
            "Mohammado",
            "Vincent",
            "Alex",
            "Alex"
        );
    Map<String, Long> counting1 = names.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    counting1.forEach( (name, count) -> System.out.println(name+" -> "+ count));

    Map<String, List<String>> counting2 = names.stream().collect(Collectors.groupingBy(name -> name));
    counting2.forEach( (name, value) -> System.out.println(name+" -> "+ value.size()));
  }

}