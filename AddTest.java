package JTest;

import static org.junit.Assert.*;



import org.junit.Test;

public class AddTest {

	
	
	@SuppressWarnings("deprecation")
	@Test
	public void jtest() {
		tax_assessor provider;
		
		provider = new tax_assessor(); //tax_assessor.java is tested
		
		
		System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
		
		assertEquals(91140, provider.SalariesTax2(620000,320000,264000),1);
		assertEquals(39460, provider.SalariesTax2(620000,0,264000),1);
		assertEquals(58840, provider.SalariesTax2(620000,120000,264000),1);
		assertEquals(0, provider.SalariesTax2(0,0,264000),1);
		assertEquals(1587599, provider.SalariesTax2(620000, 9999999, 264000),1);
		assertEquals(141800, provider.SalariesTax2(620000, 620000, 264000),1);
		assertEquals(39460, provider.SalariesTax2(0, 620000, 264000),1);
		assertEquals(58840, provider.SalariesTax2(120000, 620000, 264000),1);
		assertEquals(0, provider.SalariesTax2(18000, 99999, 264000),1);
		assertEquals(1497299, provider.SalariesTax2(9999999, 0, 264000),1);
		assertEquals(1497299, provider.SalariesTax2(0, 9999999, 264000),1);

		System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	}

}
