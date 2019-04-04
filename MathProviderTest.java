package jtest;

import static org.junit.Assert.*;

import org.junit.Test;

public class MathProviderTest {
	

		
	@Test
	public void test() {
		 MathProvider provider;
	
		 provider = new MathProvider();


			
		System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
			
		assertEquals(40, provider.Add(10, 30));
		assertEquals(60, provider.Add(30, 30));
		System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
			
				
	}

}
