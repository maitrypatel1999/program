package job.interview.practice.program;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class ProgramApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProgramApplication.class, args);

        ProgramApplication programApplication = new ProgramApplication();

//      Create a list and display elements of the list
//		System.out.println(programApplication.findOddOrEven(8));
//		System.out.println(programApplication.findOddOrEvenWithForLoop(List.of(1,2,3,4,5)));
//		System.out.println(programApplication.findOddOrEvenWithWhileLoop(List.of(1,2,3,4,5)));
//      System.out.println(programApplication.findOddOrEvenWithDoLoop(List.of(1, 2, 3, 4, 5, 6)));
//		System.out.println(programApplication.findOddOrEvenWithForEach(List.of(1,2,3,4,5)));
//      System.out.println(programApplication.findOddOrEvenWithstream(List.of(1,2,3,4,5,6)));
//      System.out.println(programApplication.findOddOrEvenWithstreamNoDups(List.of(1,2,3,2,5, 8,5,1, 4,6)));
//      System.out.println(programApplication.findOddOrEvenWithstreamCount(List.of(1,2,3,2,5,8,5,1, 4,6)));
//      System.out.println(programApplication.findOddOrEvenWithstreamPresent(List.of(1,3,3,3,5,9,5,1,7)));
//      System.out.println(programApplication.findOddOrEvenWithstreamPresentDivisibleby5(List.of(1, 5, 25, 50, 35, 45, 32, 12)));
//      System.out.println(programApplication.findOddOrEvenWithstreamPresentnumDivisibleby5(Stream.of(1, 25, 50, 507, 357, 49, 32, 12)));
//      System.out.println(programApplication.createListsDiffWays());
//      System.out.println(programApplication.createStreamsDiffWays());
//      System.out.println(programApplication.findSumOddOrEvenWithstreamPresentnumDivisibleby5Or7(Stream.of(1, 25, 50, 35, 49, 32, 12)));
        System.out.println(programApplication.findNameStartsWithP(List.of("Patel", "Patil", "Desai")));
    }

    private List<String> findNameStartsWithP(List<String> names) {
        return names.stream().filter(name ->   name.startsWith("P")).collect(Collectors.toList());
    }


    private int findSumOddOrEvenWithstreamPresentnumDivisibleby5Or7(Stream<Integer> integerStream) {
        // sum of number divisible by 5 0r 7
        return integerStream.filter(number -> number % 5 == 0 || number % 7 == 0).mapToInt(Integer::intValue).sum();
    }

    private List<String> createStreamsDiffWays() {
        List<String> list = Stream.of("10", "20", "30").collect(Collectors.toList());
        return list;
    }

    private List createListsDiffWays() {
        List<String> list = new ArrayList<>();
        list.add("10");
        list.add("20");
        return list;
    }

    private boolean findOddOrEvenWithstreamPresentnumDivisibleby5(Stream<Integer> numbers) {
        // number divisible by 5 and 7
        return numbers.anyMatch(number -> number % 5 == 0 && number % 7 == 0);
    }

    private Set findOddOrEvenWithstreamPresentDivisibleby5(List<Integer> numbers) {
        return numbers.stream().filter(number -> number % 5 == 0).collect(Collectors.toCollection(TreeSet::new));
    }

    private boolean findOddOrEvenWithstreamPresent(List<Integer> numbers) {
        //For a given number in Predicate, find out the count of the even number
        //return numbers.stream().noneMatch(number -> number % 2 == 0);
        //return numbers.stream().anyMatch(number -> number % 2 == 0);
        return numbers.stream().allMatch(number -> number % 2 != 0);
    }

    private long findOddOrEvenWithstreamCount(List<Integer> numbers) {
        //For a given number in Predicate, find out the count of the even number
        return numbers.stream().distinct().filter(number -> number % 2 == 0).count();
    }

    private Set findOddOrEvenWithstreamNoDups(List<Integer> numbers) {
        //For a given number in Predicate, find out if the number is odd or even
        return numbers.stream().filter(number -> number % 2 != 0).collect(Collectors.toCollection(TreeSet::new));
    }

    private List findOddOrEvenWithstream(List<Integer> numbers)
    {
        //For a given number in Predicate, find out if the number is odd or even
         return numbers.stream().filter(number -> number % 2 == 0).collect(Collectors.toCollection(ArrayList::new));
//        return numbers.stream().filter(number -> number % 2 == 0).collect(Collectors.toList());

    }

    private List findOddOrEvenWithForEach(List<Integer> numbers)
	{
		List list = new ArrayList();
		for(Integer number:numbers) {
			if (number % 2 != 0)
				list.add(number);
		}
		return list;

	}

    private List findOddOrEvenWithDoLoop(List<Integer> numbers) {
        List list = new ArrayList();
        int i = 0;
        do {
            int number = numbers.get(i);
            if (number % 2 == 0)
                list.add(number);
            i++;
        }
        while (i < numbers.size());
        return list;
    }


    private List findOddOrEvenWithWhileLoop(List<Integer> numbers) {
        List list = new ArrayList();
        int i = 0;
        while (i < numbers.size()) {
            if (numbers.get(i) % 2 == 0)
                list.add(numbers.get(i));
            i++;
        }
        return list;
    }


    private List findOddOrEvenWithForLoop(List<Integer> numbers) {
        List list = new ArrayList();
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 != 0)
                list.add(numbers.get(i));
        }
        return list;
    }


    private String findOddOrEven(int number) {
        if (number % 2 == 0)
            return number + " is even";
        else
            return number + " is odd";

    }


}