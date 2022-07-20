package com.techelevator;

public class Examples {

	public static void main(String[] args) {

		// declaration statement for a variable named "result" of type boolean
		boolean result;

		System.out.println("****************************");
		System.out.println("*** COMPARISON OPERATORS ***");
		System.out.println("****************************");
		System.out.println();
		/*
		 ==  Equal to
		 !=  Not equal to
		*/
		result = (2 == 2);
		System.out.println("2 == 2 : " + result);
		result = (2 == 3);
		System.out.println("2 == 3 : " + result);
		result = ('a' == 'a');
		System.out.println("'a' == 'a' : " + result);
		result = ('a' == 'b');
		System.out.println("'a' == 'b' : " + result);
		result = (2 != 2);
		System.out.println("2 != 2 : " + result);
		result = (2 != 3);
		System.out.println("2 != 3 : " + result);
		result = ('a' != 'a');
		System.out.println("'a' != 'a' : " + result);
		result = ('a' != 'b');
		System.out.println("'a' != 'b' : " + result);
		System.out.println();

		/*
		 >  Greater than
		 <  Less than
		 >= Greater than or equal to
		 <= Less than or equal to
		*/
		result = (2 > 1);
		System.out.println("2 > 1 : " + result);
		result = (2 < 2);
		System.out.println("2 < 2 : " + result);
		result = (2 < 2);
		System.out.println("2 < 2 : " + result);
		result = (2 <= 3);
		System.out.println("2 <= 3 : " + result);
		result = (5 >= 5);
		System.out.println("5 >= 5 : " + result);
		System.out.println();

		System.out.println("*************************");
		System.out.println("*** LOGICAL OPERATORS ***");
		System.out.println("*************************");
		System.out.println();
		/*
		 &&  AND
		 ||  OR
		 !  NOT
		 ^  XOR  (exclusive OR)
		 */
		result = true && true;
		System.out.println("true && true : " + result);
		result = true && false;
		System.out.println("true && false : " + result);
		result = false && false;
		System.out.println("false && false : " + result);

		result = true || true;
		System.out.println("true || true : " + result);
		result = true || false;
		System.out.println("true || false : " + result);
		result = false || false;
		System.out.println("false || false : " + result);

		result = !true;
		System.out.println("!true : " + result);
		result = !false;
		System.out.println("!false : " + result);

		result = true ^ true;
		System.out.println("true ^ true : " + result);
		result = true ^ false;
		System.out.println("true ^ false : " + result);
		result = false ^ false;
		System.out.println("false ^ false : " + result);
		System.out.println();

		System.out.println("***************************");
		System.out.println("*** BOOLEAN EXPRESSIONS ***");
		System.out.println("***************************");
		System.out.println();

		int value = 100;
		result = (value > 200) || (value < 500);
		System.out.println("(value > 200) || (value < 500) : " + result);

		result = (value > 200) && (value < 500);
		System.out.println("(value > 200) && (value < 500) : " + result);

		result = !(value >= 300);
		System.out.println("!(value >= 300) : " + result);

		System.out.println("*******************************");
		System.out.println("*** SHORT CIRCUIT OPERATORS ***");
		System.out.println("*******************************");
		System.out.println();

		int x = 3;
		int y = 0;
		// result = (y > 0) && (x / y) > 2;  // causes a divide by zero exception to be thrown
		result = (y > 0) && (x / y) > 2;
		System.out.println(result);

		System.out.println("*******************************");
		System.out.println("*** IF STATEMENTS ***");
		System.out.println("*******************************");
		System.out.println();

		//----------------------------------------------------

		System.out.println("*** Basic if statement ***");

		int freezingPointFahrenheit = 32;
		int outsideTempFahrenheit = 80;
		if (outsideTempFahrenheit <= freezingPointFahrenheit) {
			System.out.println("Would you like a nice hot cup of coffee?");
		} else {
			System.out.println("Would you like a cool, refreshing iced mocha?");
		}

		//----------------------------------------------------

		System.out.println("*** if-else statement ***");

		boolean condition1 = true;
		boolean condition2 = true;
		if (condition1) {
			System.out.println("Condition 1 is true!");
		} else if (condition2) {
			System.out.println("Condition 2 is true!");
		} else {
			System.out.println("No conditions are true!");
		}

		//----------------------------------------------------

		System.out.println("*** a boolean variable is valid boolean expression ***");

		boolean isSunny = true;
		if (isSunny) {
			System.out.println("Better wear some sun screen...");
		}

		//----------------------------------------------------

		System.out.println("*** if statements can be used with blocks ***");

		if (outsideTempFahrenheit > freezingPointFahrenheit) {
			System.out.println("Summer time!!!");
		} else {
			System.out.println("Dress in layers");
			System.out.println("Wear gloves");
			System.out.println("Wear hat");
			System.out.println("Wear scarf");
		}

		System.out.println("*******************************");
		System.out.println("*** VARIABLE SCOPE ***");
		System.out.println("*******************************");
		System.out.println();

		int firstVariable = 2;
		if (firstVariable > 0) {
			int secondVariable = firstVariable;
		}
		//int thirdVariable = secondVariable * 2; // this will cause a compile error because secondVariable is not "in scope"
		//int firstVariable = 3;  // this is a compiler error because we already have a variable named firstVariable in this scope
		int secondVariable = 7; // this is allowed because there is no variable named secondVariable in this scope

		boolean burnItDown = shouldBurnDownTheBuilding(14, 20);
	}

	static boolean shouldBurnDownTheBuilding(int numberOfEmployees, int piecesOfCake) {
		if (numberOfEmployees > piecesOfCake) {
			return true;
		} else {
			return false;
		}
	}
}
