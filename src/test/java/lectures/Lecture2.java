package lectures;

import beans.Person;
import mockdata.MockData;
import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;

public class Lecture2 {

  @Test
  public void range() throws Exception {

    System.out.println("For i:");
    for (int i = 0; i <= 10; i++) {
      System.out.println(i);
    }
    System.out.println("Using range:");
    IntStream.range(0,10).forEach(System.out::println);
    System.out.println("Using rangeClosed:");
    IntStream.rangeClosed(0,10).forEach(System.out::println);
  }

  @Test
  public void rangeIteratingLists() throws Exception {
    List<Person> people = MockData.getPeople();
    IntStream.range(0, people.size()).forEach(index -> System.out.println(people.get(index)));
  }

  @Test
  public void intStreamIterate() throws Exception {
      IntStream.iterate(0, index -> index + 1 )
              .filter(value -> value % 2 == 0)
              .limit(20)
              .forEach(System.out::println);
  }
}
