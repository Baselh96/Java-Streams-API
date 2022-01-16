package lectures;

import beans.Person;
import com.google.common.collect.ImmutableList;
import mockdata.MockData;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Lecture1 {

    // Das ist der imperative Weg zur Lösung
    @Test
    public void imperativeApproach() throws IOException {
        List<Person> people = MockData.getPeople();
        // 1. Find people aged less or equal 18
        // 2. Then change implementation to find first 10 people
        List<Person> resultPeople = new ArrayList<>();
        int count = 0;
        for (Person person : people) {
            if (person.getAge() <= 18) {
                resultPeople.add(person);
                count++;
                if (count >= 10) break;
            }
        }
        resultPeople.forEach(person -> System.out.println(person));
    }

    //Das ist der funktionale Weg zur Lösung
    @Test
    public void declarativeApproachUsingStreams() throws Exception {
        ImmutableList<Person> people = MockData.getPeople();
        List<Person> resultPeople = people.stream().filter(person -> person.getAge() <= 18).limit(10).collect(Collectors.toList());
        // resultPeople.forEach(person -> System.out.println(person));
        resultPeople.forEach(System.out::println);
        //MockData.getPeople().stream().filter(person -> person.getAge() <= 18).limit(10).collect(Collectors.toList()).forEach(System.out::println);
    }
}
