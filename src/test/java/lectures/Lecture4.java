package lectures;


import com.google.common.collect.ImmutableList;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lecture4 {

  @Test
  public void distinct() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);
    numbers.stream().distinct().forEach(System.out::println);
    List<Integer> distinct = numbers.stream().distinct().collect(Collectors.toList());
    Assert.assertEquals(9, distinct.size());
  }

  @Test
  public void distinctWithSet() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);
    Set<Integer> distinctSet = numbers.stream().collect(Collectors.toSet());
    System.out.println(distinctSet);
  }
}
