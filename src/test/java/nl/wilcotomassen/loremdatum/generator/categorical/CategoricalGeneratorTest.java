package nl.wilcotomassen.loremdatum.generator.categorical;

import org.testng.annotations.Test;

public class CategoricalGeneratorTest {
	
	@Test
	public void testFoo() {
		
		CategoricalGenerator gen = CategoricalGenerator.builder()
				.naProbability(null)
				.addItem(200, "Foo")
				.addItem(500, "Bar")
				.addItem(300, "Baz")
				.build();
		
		int fooCount = 0, barCount = 0, bazCount = 0;
		for (int i = 0; i < 1000; i++) {
			String value = gen.getNext().toString();
			
			if (value.equals("Foo")) {
				fooCount++;
			} else if (value.equals("Bar")) {
				barCount++;
			} else if (value.equals("Baz")) {
				bazCount++;
			}
			
		}
		
		System.out.println("Foo: " + fooCount + " Bar: " + barCount + " Baz: " + bazCount);
		
	}

}
