package DAY10_16OCT;

import java.util.*;
import java.util.stream.*;
public class streamApi {
public static void main(String[] args) {
//	List<Integer> nums =Arrays.asList(1,2,3,4,5,5);
//	
//	List<Integer>res =nums.stream()
//	.filter(n->n%2==0)
//	.map(n->n*n)
//	.collect(Collectors.toList());
//	
//	System.out.println("OG LIST:"+nums);
//	System.out.println("Result:"+res);
//}
//-------------------------------------------------------------------------------------------	
//	
//	
//	
//	
//	List<String>list =List.of("a","b","c");
//	System.out.println("Stream from list");
//	list.stream().forEach(System.out::println);
//	
//	int[]arr = {1,2,3};
//	Arrays.stream(arr).forEach(System.out::println);
//	
//	IntStream.range(1, 5).forEach(System.out::println);
//	
//}
/*
source(where the data comes from) [my list.stream()]
-> Intermediate operations(transform/filter) {.filter(), .map()....}
-> Terminal operation(produce the final result)[.collect(), .count()]

*/


//}
	
	



        //Filter: keep all the items that pass a defined test.

//        List<Integer> nums = List.of(5, 12, 8, 3, 20, 7);
//
//        List<Integer> result = nums.stream()
//                .filter(n -> n >= 7)
//                .collect(Collectors.toList());
//
//        System.out.println(result);
//    }
//}

	 // map: transform each item.
//    List<Integer> nums = List.of(5, 12, 8, 3, 4, 5);
//
//    List<Integer> res = nums.stream()
//            .map(n -> n * 2)
//            .collect(Collectors.toList());
//
//    System.out.println(res);
//}
//}

	

//
//        //sorted
//        List<Integer> nums = List.of(5, 4, 3, 2, 1, 19);
//
//        List<Integer> res = nums.stream()
//                .sorted()
//                .collect(Collectors.toList());
//
//        System.out.println(res);
//    }
//}


//sorted
List<Integer> nums = List.of(5, 4, 3, 2, 1, 19);

List<String> words = List.of("banana", "fig", "apple", "kiwi");

List<String> byLength = words.stream()
        .sorted((a, b) -> a.length() - b.length())
        .collect(Collectors.toList());

List<Integer> res = nums.stream()
        .sorted()
        .collect(Collectors.toList());

System.out.println(res);
System.out.println(byLength);
}
}




