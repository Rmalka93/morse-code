public class tster {

	public static void main(String[] args) {
		
		System.out.println("node and tree tests");
		
		BTree<String> tree = new BTree<String>();
		privateTester(!tree.addByPath("2", "L"), 1);
		privateTester(tree.addByPath("1", ""), 2);
		privateTester(tree.addByPath("2", "L"), 3);
		privateTester(tree.getSize() == 2, 4);
		privateTester(tree.addByPath("3", "R"), 5);
		privateTester(tree.addByPath("4", "LL"), 6);
		privateTester(tree.addByPath("5", "LR"), 7);
		privateTester(tree.getSize() == 5, 8);
		privateTester(!tree.addByPath("6", "LRG"), 9);
		privateTester(!tree.addByPath("6", "RRR"), 10);
		privateTester(!(tree.getSize() == 6), 11);
		privateTester((tree.findByPath("RRRR") == null), 12);
		privateTester(!tree.addByPath("7", "L"), 7);
		privateTester((tree.findByPath("LR") == "5"), 13);
		System.out.println(tree.findByPath(null)  );
		privateTester((tree.findByPath("LL") == "4"), 14);
		System.out.println("test number "+ 15 +", manual test:\n"
				+ "check the results according to your chosen format\nmust be printed in the following order:\n"
				+ "1, 2, 4, 5, 3\nprint result: \n" + tree.pre());
		
		System.out.println("\nmorseCode tests:");
		MorseDecoder decoder = new MorseDecoder();
		privateTester(decoder.decode("..-") == "U", 16);
		privateTester(decoder.decode("-.-") == "K", 17);
		System.out.println(decoder.decode("----")   );
		privateTester(decoder.decode("----") == "", 18);
		privateTester(decoder.decode("LRR") == "", 19);
		String word = decoder.decode("-.")+decoder.decode(".-")
		+decoder.decode("-")+decoder.decode(".-")+decoder.decode("-.");
		privateTester(word.equals("NATAN"), 20);
		privateTester(decoder.decode(".-.-") == "", 21);
		privateTester(decoder.decode(".-..") == "L", 22);
		privateTester(decoder.decode(".....") == "", 23);
		privateTester(decoder.decode(".--.-..") == "", 23);
		privateTester(decoder.decode("") == "", 24);
		System.out.println("test number "+ 25 +", manual test:\n"
				+ "check the results according to your chosen format\nmust be printed in the following order:\n"
				+ "start, E, I, S, H, V, U, F, A, R, L, W, P, J, T, N, D, B, X, K, C, Y, M, G, Z, Q, O"
				+ "\nprint result: \n" + decoder.toString());
	}
	public static void privateTester(boolean expression, int testNum) {
		String result = "";
		if (expression)
			result = "test number "+testNum+" has passed";
		else
			result = "test number "+testNum+" HAS FAILED";
		System.out.println(result);
	}
}
