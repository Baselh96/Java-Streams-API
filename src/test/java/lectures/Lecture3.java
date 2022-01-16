package lectures;

import beans.Person;
import com.google.common.collect.ImmutableList;
import mockdata.MockData;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

public class Lecture3 {

  @Test
  public void min() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);
    int min = numbers.stream().min((number1, number2) -> number1 < number2 ? -1 : 1).get();
    System.out.println(min);
    Assert.assertEquals(1, min);
    System.out.println(numbers.stream().min(Comparator.naturalOrder()).get());
  }


  @Test
  public void max() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);
    int max = numbers.stream().max((x1, x2) -> x1 < x2 ? -1 : 1).get();
    Assert.assertEquals(100, max);
    System.out.println(numbers.stream().max(Comparator.naturalOrder()).get());
  }

  @Test
  public void minAgedPeron() throws Exception {
    final List<Person> people = MockData.getPeople();
    Person minAged = people.stream().min( (perso1, person2) -> perso1.getAge() < person2.getAge() ? -1: 1).get();
    System.out.println(minAged);
  }

  @Test
  public void maxAgedPeron() throws Exception {
    final List<Person> people = MockData.getPeople();
    Person maxAged = people.stream().max( (perso1, person2) -> perso1.getAge() < person2.getAge() ? -1: 1).get();
    System.out.println(maxAged);
  }
}
