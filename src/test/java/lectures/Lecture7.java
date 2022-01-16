package lectures;


import beans.Car;
import mockdata.MockData;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

public class Lecture7 {

  @Test
  public void count() throws Exception {
    long count = MockData.getPeople().stream()
            .filter(person -> person.getGender().equalsIgnoreCase("female"))
            .count();
    System.out.println(count);
  }

  @Test
  public void min() throws Exception {
    double minimalPrice = MockData.getCars().stream()
            .mapToDouble(Car::getPrice)
            .min()
            .orElse(0);
    System.out.println(minimalPrice);
  }

  @Test
  public void max() throws Exception {
    double maximalPrice = MockData.getCars().stream()
            .mapToDouble(Car::getPrice)
            .max()
            .orElse(0);
    System.out.println(maximalPrice);
  }


  @Test
  public void average() throws Exception {
    List<Car> cars = MockData.getCars();
    double averagePrice = cars.stream()
            .mapToDouble(car -> car.getPrice())
            .average()
            .orElse(0);
    System.out.println(averagePrice);

    // if the List is empty
    List<Car> emptyList = new ArrayList<>();
    double averagePriceForIsEmpty = emptyList.stream()
            .mapToDouble(car -> car.getPrice())
            .average()
            .orElse(0);
    System.out.println(averagePriceForIsEmpty);
  }

  @Test
  public void sum() throws Exception {
    double carPrice = MockData.getCars().stream()
            .mapToDouble(Car::getPrice)
            .sum();
    System.out.println(carPrice);

    BigDecimal bigDecimalSum = BigDecimal.valueOf(carPrice);
    System.out.println(bigDecimalSum);



    int[] numbers = {1,2,3,4,5};
    int sum = Arrays.stream(numbers).sum();
    System.out.println(sum);
  }

  @Test
  public void statistics() throws Exception {
    List<Car> cars = MockData.getCars();
    DoubleSummaryStatistics doubleSummaryStatistics = cars.stream()
            .mapToDouble(Car::getPrice)
            .summaryStatistics();
    System.out.println(doubleSummaryStatistics);
    System.out.println(doubleSummaryStatistics.getCount());
    System.out.println(doubleSummaryStatistics.getSum());
    System.out.println(doubleSummaryStatistics.getMax());
    System.out.println(doubleSummaryStatistics.getMin());
    System.out.println(doubleSummaryStatistics.getAverage());


    int[] numbers = {1,2,3,4,5};
    IntSummaryStatistics intSummaryStatistics = Arrays.stream(numbers).summaryStatistics();
    System.out.println(intSummaryStatistics);
  }

}