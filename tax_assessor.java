package JTest;
import java.io.IOException;
import java.util.Scanner;

public class tax_assessor {

	public static void main(String[] args) 
	{
		System.out.print("1:Calculated MPF mandatory contribution based on personal income\n");
		System.out.print("2:Salaries Tax to be paid if separate assessment assumed\n");
		System.out.print("3:Salaries Tax to be paid if joint assessment assumed\n");
		System.out.print("Please select the function: ");
		Scanner	sel	=	new Scanner(System.in);
		int select	=	sel.nextInt();
		if(select == 1) {
			System.out.print("\nPlease enter your Monthly Relevant Income: ");
			Scanner	mr	=	new Scanner(System.in);
			double MRI	=	mr.nextDouble();
			if (MRI >= 0) {
				MPF(MRI);
			}
			else {
				System.out.print("invalid Monthly Relevant Income");
			}
			promptEnterKey();
			main(args);
		}
		else if(select == 2){
			System.out.print("\nPlease enter your Income for the year of assessment: ");
			Scanner	inc	=	new Scanner(System.in);
			double income	=	inc.nextDouble();
			double SA = 132000;
			if (income>=0) {
				double tax = SalariesTax(income,SA);
				System.out.printf("Your Salaries Tax to be paid if separate assessment assumed is HKD " + tax);
			}
			else {
				System.out.print("invalid Income");
			}
			promptEnterKey();
			main(args);
		}
		else if(select == 3) {
			System.out.print("\nPlease enter your Self Income for the year of assessment: ");
			Scanner	self	=	new Scanner(System.in);
			double SEI	=	self.nextDouble();
			System.out.print("\nPlease enter your Spouse Income for the year of assessment: ");
			Scanner	spouse	=	new Scanner(System.in);
			double SPI	=	spouse.nextDouble();
			
			double income = SEI+SPI;
			double SA = 264000;
			
			if (SEI>=0 && SPI>=0) {
				double tax = SalariesTax2(SEI,SPI,SA);
				System.out.printf("Your Salaries Tax to be paid if separate assessment assumed is HKD " + tax);
				double tax2 = SalariesTax(SEI,SA) + SalariesTax(SPI,SA);
				if(tax>=tax2) {
					System.out.print("\nJoint assessment should is recommended");
				}
				else {
					System.out.print("\nJoint assessment should is not recommended");
				}
			}
			else {
				System.out.print("invalid Income");
			}
			promptEnterKey();
			main(args);
		}
		else {
			System.out.print("invalid input");
			promptEnterKey();
			main(args);
		}
		
	}
	
	public static double MPF (double income)
	{
		double MRI = income/12;
		double MPF =0;
		if( MRI<7100 && MRI>=0 ) {
			MPF = 0;
        } 
        else if( MRI<=30000 && MRI>=7100 ) {
        	MPF = MRI*0.05;
        } 
        else {
        	MPF = 1500;
        }
		MPF = MPF*12;
		return MPF;
		
    }
	
	public static double SalariesTax (double income,double SA)
	{
		SA= SA + MPF(income);
		double tax = 0;
		double NCI = income - SA;
		if( NCI<=0 ) {
			tax = 0;
        } 
        else if( NCI<=50000 && NCI>0 ) {
} 
        else if( NCI<=100000 && NCI>50000 ) {
        	tax =  (NCI-50000) * 0.06 + 1000;
        }
        else if( NCI<=150000 && NCI>100000 ) {
        	tax =  (NCI - 100000) * 0.1 + 4000;
        }
        else if( NCI<=200000 && NCI>150000 ) {
        	tax =  (NCI - 150000) * 0.14 + 9000;
        }
        else if( NCI>200000 ) {
        	tax =  (NCI - 200000) * 0.17 + 16000;
        }
        else {
        	System.out.print("invalid income");
        }
		double tax2 = income*0.15;
		if(tax>tax2) {
			tax=tax2;
		}
		return tax;
	}
	
	public static double SalariesTax2 (double income1,double income2,double SA)
	{
		double MPF1 = MPF(income1);
		double MPF2 = MPF(income2);
		SA= SA + MPF1 + MPF2;
		double tax = 0;
		double NCI = income1 + income2 - SA;
		if( NCI<=0 ) {
			tax = 0;
        } 
        else if( NCI<=50000 && NCI>0 ) {
        	tax =  NCI * 0.02;
        } 
        else if( NCI<=100000 && NCI>50000 ) {
        	tax =  (NCI-50000) * 0.06 + 1000;
        }
        else if( NCI<=150000 && NCI>100000 ) {
        	tax =  (NCI - 100000) * 0.1 + 4000;
        }
        else if( NCI<=200000 && NCI>150000 ) {
        	tax =  (NCI - 150000) * 0.14 + 9000;
        }
        else if( NCI>200000 ) {
        	tax =  (NCI - 200000) * 0.17 + 16000;
        }
        else {
        	System.out.print("invalid income");
        }
		double tax2 = (income1+income2-MPF1-MPF2)*0.15;
		if(tax>tax2) {
			tax=tax2;
		}
		return tax;
	}
	
	public static void promptEnterKey(){
	    System.out.println("\n\nPress \"ENTER\" to continue...");
	    try {
	        System.in.read();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

}


