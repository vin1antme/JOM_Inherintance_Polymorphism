package jom.com.softserve.s2.task3;

import java.util.*;

public class MyUtils {

    public List<Person> maxDuration(List<Person> people) {

        List<Student> students = new ArrayList<>();
        List<Worker> workers = new ArrayList<>();

        for (Person person : people) {
            if (person != null) {
                if (person.getClass().getName() == Student.class.getName())
                    students.add((Student) person);
                else if (person.getClass().getName() == Worker.class.getName())
                    workers.add((Worker) person);
            }
        }

        if (!students.isEmpty()) {
            int maxStudyDuration = Collections.max(students, new Comparator<Student>() {
                @Override
                public int compare(Student st1, Student st2) {
                    if (st1.getStudyYears() > st2.getStudyYears())
                        return 1;
                    else if (st1.getStudyYears() < st2.getStudyYears())
                        return -1;
                    return 0;
                }
            }).getStudyYears();

            Set<String> uniqueStudentNames = new HashSet<>();
            students.removeIf(s -> s.getStudyYears() != maxStudyDuration);
            students.removeIf(s -> !uniqueStudentNames.add(s.getName()));
        }
        
        if (!workers.isEmpty()) {
            int maxExperienceDuration = Collections.max(workers, new Comparator<Worker>() {
                @Override
                public int compare(Worker st1, Worker st2) {
                    if (st1.getExperienceYears() > st2.getExperienceYears())
                        return 1;
                    else if (st1.getExperienceYears() < st2.getExperienceYears())
                        return -1;
                    return 0;
                }
            }).getExperienceYears();

            Set<String> uniqueWorkerNames = new HashSet<>();
            workers.removeIf(w -> w.getExperienceYears() != maxExperienceDuration);
            workers.removeIf(w -> !uniqueWorkerNames.add(w.getName()));
        }

        List<Person> peopleWithMaxDuration = new ArrayList<>();
        peopleWithMaxDuration.addAll(workers);
        peopleWithMaxDuration.addAll(students);
        return peopleWithMaxDuration;
    }

    public static void main(String[] args) {
        final List<Person> expected = new ArrayList<Person>();

        expected.add((Person) new Worker("Andriy", "Developer", 12));
        expected.add((Person) new Student("Stepan", "College", 4));
        final List<Person> actual = new ArrayList<Person>();

        actual.add((Person) new Worker("Andriy", "Developer", 12));
        actual.add((Person) new Student("Stepan", "College", 4));
        System.out.println(expected.equals(actual));
    }
}