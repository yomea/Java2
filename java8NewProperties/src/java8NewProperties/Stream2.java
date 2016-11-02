package java8NewProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream2 {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("java");
		list.add("ORACLE");
		list.add("jsp");
		list.add("JQuery");
		list.add("javaScript");
		Stream<String> stream = list.stream();
		//list = stream.distinct().map((x)->x.toLowerCase()).filter((x)->x.contains("a")).collect(Collectors.toList());
		list = stream.distinct().filter((x)->x.contains("a")||x.contains("A")).collect(Collectors.toList());
		//list.forEach((x)->System.out.println(x));		
		list.forEach(System.out :: println);
	}
	
}
