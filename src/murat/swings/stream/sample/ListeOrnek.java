package murat.swings.stream.sample;

import java.util.ArrayList;
import java.util.List;

public class ListeOrnek {
	public static void main(String[] args) {
		List<Integer> sayilar = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			sayilar.add(i);
		}
		sayilar.stream().mapToInt(n->n).average().ifPresent(System.out::println); //List, collection frame work icerisinde oldugu icin stream'e donusebiliyor.
		//ifPresent(syso), average sonucunu syso'ya girdi olarak gondermeyi sagliyor. Buraya baska bir metot da yazilabilir.
		sayilar.stream().mapToInt(n->n).average().ifPresent((a)->{System.out.println("Ortalama : "+a);});
		sayilar.stream().forEach(System.out::println);
		sayilar.stream().forEach((s)->{System.out.println("2 kati : "+s*2);});
	}
}
