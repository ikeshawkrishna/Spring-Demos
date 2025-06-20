package TryItOut.ComparatorComparable;

import com.sun.jdi.Value;

import java.util.*;

class Person implements Comparable<Person>{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person person) {
//        return Integer.compare(this.age, person.age);
        return this.name.compareTo(person.name);
    }


}

public class ComparatorDemo {

    public static void main(String[] args) {
        List<Person> list = Arrays.asList(
                new Person("Keshaw",23),
                new Person("Krishna",21),
                new Person("Shaw",25)
        );

        Collections.sort(list);
        System.out.println(list);

        list.sort((p1, p2) -> Integer.compare(p1.getAge(),p2.getAge()));
        System.out.println(list);

        list.sort(Comparator.reverseOrder());
        System.out.println(list);

        list.sort(Comparator.comparing(person -> person.getAge()));

    }
}
