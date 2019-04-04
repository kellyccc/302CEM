package jtest;

public class MathProvider {
	

	/*
	 *  This is our sample class that we would like to unit test
	 *  To do this we will create a sample functionality in the
	 *  class
	 *  Let the class give us these 3 basic functionalities
	 *  Substract()
	 *  Add()
	 *  Multiply()
	 *  
	 *  Our goal is to have unit tests around these 
	 *  basic functionalities
	 */
		

		public MathProvider(){}

		public int Substract(int firstNumber, int secondNumber)
		{
			return (firstNumber - secondNumber);		
		}

		public int Add(int firstNumber, int secondNumber)
		{
			return (firstNumber + secondNumber);
		}

		public int Multiply(int firstNumber, int secondNumber)
		{
			return (firstNumber * secondNumber);
		}

	
}
