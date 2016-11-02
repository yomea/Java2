package java8NewProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("1");
		list.add("1");
		list.add("8");
		list.forEach(System.out :: print);
		System.out.println();
		java.util.stream.Stream<String> stream = list.stream();
		System.out.println("----------------distinct去重----------------------");
		stream.distinct().forEach(System.out :: print);
		System.out.println();
		System.out.println("----------------去重后生成新的list----------------------");
		stream = list.stream();
		List<String> list2 = stream.distinct().collect(Collectors.toList());
		list2.forEach(System.out :: print);
		
				
	}
	
}
