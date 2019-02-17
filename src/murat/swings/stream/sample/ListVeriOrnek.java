package murat.swings.stream.sample;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class ListVeriOrnek {

	public static void main(String[] args) {
		List<String> liste = Arrays.asList(new String[] {"murat","emel","erol"});
		liste.stream().filter(s->s.startsWith("e")).map(s->s.toUpperCase()).sorted().forEach(System.out::println);
		System.out.println("----------------------------------------------");
		/*String s1 = liste.stream().filter(s->s.startsWith("e")).map(s->s.toUpperCase()).sorted().toString();
		System.out.println();
		System.out.println("----------------------------------------------");*/
		liste.stream().filter(s->
		{System.out.println("filtre : "+s);
		System.out.println("+++++++++++++++++++++++++++++++++++++");
		return s.startsWith("m");
				}).map((s)->{
					System.out.println("map : "+s);
					System.out.println("**********************************");
					return s.toUpperCase();
					}).forEach(s->{System.out.println(s);
					System.out.println("ssssssssssssssssssssssssssssss");
					});
		
		System.out.println("----------------IntStream------------------------------");
		
		IntStream.range(1, 10).filter(new IntPredicate() {
			
			@Override
			public boolean test(int value) {
				return value%2!=0;
			}
		}).forEach(System.out::println);
		
		System.out.println("----------------IntStream------------------------------");

		IntStream.range(1, 10).filter(s->{
			return s%2==0;}).forEach(System.out::println);
		
		System.out.println("----------------IntStream lambda------------------------------");

		IntStream.range(1, 10).filter(i->i%2!=0).average().ifPresent(System.out::println);
		
		System.out.println("----------------IntStream array------------------------------");
		Arrays.stream(IntStream.range(65, 96).toArray()).mapToObj(s->String.valueOf((char)s)).filter(s->s.compareTo("L")>0).findFirst().ifPresent(System.out::println);
	}

}
