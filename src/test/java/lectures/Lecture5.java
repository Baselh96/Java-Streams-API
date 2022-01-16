package lectures;



import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import mockdata.MockData;
import org.junit.Test;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lecture5 {

  @Test
  public void understandingFilter() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();
    Predicate<Car> carPredicate = car -> car.getPrice() < 10000;
    List<Car> carFiltered = cars.stream().filter(carPredicate).collect(Collectors.toList());
    System.out.println(carFiltered.size());
  }


  @Test
  public void ourFirstMapping() throws Exception {
    // transform from one data type to another
    List<Person> people = MockData.getPeople();
    List<PersonDTO> personDTOS = people.stream()
            .map(PersonDTO::map) // Weil map als eine Methode in PersonDTO definiert ist
            .collect(Collectors.toList());
    personDTOS.forEach(System.out::println);
  }

  @Test
  public void averageCarPrice() throws Exception {
    // calculate average of car prices
    double average = MockData.getCars()
            .stream()
            .mapToDouble(Car::getPrice)
            .average()
            .orElse(0);
    System.out.println(average);
  }

  @Test
  public void test() throws Exception {

  }
}



