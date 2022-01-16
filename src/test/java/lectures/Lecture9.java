package lectures;


import beans.Car;
import mockdata.MockData;
import org.junit.Test;

import java.util.Arrays;
import java.util.Optional;

public class Lecture9 {

  @Test
  public void reduce() throws Exception {
    Integer[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};

    int sum = Arrays.stream(integers).reduce(0, (a, b) -> a + b);
    int sum2 = Arrays.stream(integers).reduce(0, Integer::sum);
    System.out.println(sum+"..."+sum2);
  }

  @Test
  public void minPriceOfCarsWithReduce() throws Exception {
    Optional<Car> reduce = MockData.getCars().stream().reduce(((car, car2) -> car.getPrice() < car2.getPrice() ? car : car2));
    System.out.println(reduce.get());
  }


}

