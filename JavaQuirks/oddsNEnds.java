public class oddsNEnds {
	public static void main(String[] args) {
		System.out.println("a\nb\nc\n");
		System.out.println("There should be an empty line here ^^");
		System.out.println("I'm a moose");
		System.out.println("You\'re a moose too"); // Dont need to escape single quotes in a string
		char myQuote = '\'';
		System.out.println(0x00);
		System.out.println(0xFF);
		System.out.println(000);
		System.out.println(077);
		System.out.println(0b1000);
		//System.out.println(0b1002); // Unuseful error message.
		//System.out.println(088); // Doesn't work, expecting digits to be 0 to 7
		//final int MY_AGE = 23;
		//MY_AGE++; // Can't change a final variable.
		//System.out.println(MY_AGE);
		double thing1 = -5.5;
		int thing2 = (int) thing1;
		System.out.println(thing2);
		final int DAYS_PER_WEEK = 7;
		double[] maxTemps = new double[DAYS_PER_WEEK];
		int thing3 = 2;
		//int thing4 = ++thing3++; // The postfix happens first, which returns a value. The prefix ++ is expecting a variable not a value, so it gets messed up.
		//System.out.println(thing4);
		String[] stuNames;
		stuNames = new String[10];
		stuNames[0] = new String("Andrew");
		System.out.println(stuNames);
		System.out.println(stuNames[0]);
		final int WEEKS_PER_YEAR = 52;
		double[][] minTemps = new double[DAYS_PER_WEEK][WEEKS_PER_YEAR];
		String thing5 = "hi " + 4;
		System.out.println(thing5);
		String thing6 = 1.000000001 + 2 + " hi";
		System.out.println(thing6);
	}
}