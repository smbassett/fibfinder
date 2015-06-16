import java.math.BigInteger;

public class Fibfinder {

	public static void main(String[] args){

// prepare to measure running time:
		long startTime = System.currentTimeMillis();
		long finishTime;
		long runningTime;

// grab arguments
		int target = Integer.parseInt(args[0]);
		String outputType = "n";
		if (args.length > 1) {outputType = args[1];} else {}

// set up memo table
		BigInteger[] memoTable = new BigInteger[target];

// base cases
		memoTable[0] = new BigInteger("1");
		memoTable[1] = new BigInteger("1");

// fill memo table with Fibonacci numbers
		for (int x = 2; x < target; x++){
			memoTable[x] = memoTable[x-1].add(memoTable[x-2]);
		}

// print desired output:
		if (!outputType.equals("n")){
			// if flag is -v, print all Fibonacci numbers up to and including target
			if (outputType.equals("-v")){
				for (int x = 0; x < target; x++){
					System.out.println(x+1 + ": " + memoTable[x]);
				}
			} 
			// print error message if flag is invalid
			else {
				printErrorMsg();
			}
		} 
		// just print target Fibonacci number if there is no second argument
		else {
			System.out.println("Fibonacci #" + target + ": " + memoTable[target-1]);
		}

// calculate running time:
		finishTime = System.currentTimeMillis();
		runningTime = finishTime - startTime;
		System.out.println("Running time: " + runningTime + "ms");
	}


/* 
 * Prints an error message for invalid arguments.
 */
	private static void printErrorMsg(){
		System.out.println("Sorry, there's something wrong with the commands you've given to Fibfinder.");
		System.out.println("Enter something like:");
		System.out.println("java Fibfinder 10 -v     ...for all Fibonacci numbers up to and including the 10th number, or");
		System.out.println("java Fibfinder 10        ...for just the 10th Fibonacci number.");
	}
}