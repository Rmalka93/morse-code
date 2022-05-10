
public class MorseDecoder {

	private BTree<String> morseDecoder;// tree holder

	public MorseDecoder() {
		// Initialize the tree (organize by high)
		morseDecoder = new BTree<String>();
		
		morseDecoder.addByPath("start", "");

		morseDecoder.addByPath("E", "L");
		morseDecoder.addByPath("T", "R");

		morseDecoder.addByPath("I", "LL");
		morseDecoder.addByPath("A", "LR");
		morseDecoder.addByPath("M", "RR");
		morseDecoder.addByPath("N", "RL");

		morseDecoder.addByPath("S", "LLL");
		morseDecoder.addByPath("U", "LLR");
		morseDecoder.addByPath("W", "LRR");
		morseDecoder.addByPath("R", "LRL");
		morseDecoder.addByPath("D", "RLL");
		morseDecoder.addByPath("K", "RLR");
		morseDecoder.addByPath("O", "RRR");
		morseDecoder.addByPath("G", "RRL");

		morseDecoder.addByPath("H", "LLLL");
		morseDecoder.addByPath("V", "LLLR");
		morseDecoder.addByPath("F", "LLRL");

		morseDecoder.addByPath("L", "LRLL");
		morseDecoder.addByPath("J", "LRRR");
		morseDecoder.addByPath("P", "LRRL");

		morseDecoder.addByPath("Q", "RRLR");
		morseDecoder.addByPath("Z", "RRLL");

		morseDecoder.addByPath("B", "RLLL");
		morseDecoder.addByPath("X", "RLLR");
		morseDecoder.addByPath("C", "RLRL");
		morseDecoder.addByPath("Y", "RLRR");
	}

	public String toString() {
		// call to pre order of tree
		return morseDecoder.pre();
	}
	// convert from mors to English
	public String decode(String str) {
		
		String res = ""; // hold the result
		String stringWithRAndL = "";// string of r and l equivalent to dot and dash
		
		if(str == null)
			return res;
		// check legal string and convert
		for (int i = 0; i < str.length(); i++) {
			if (!(str.charAt(i) == '.') && !(str.charAt(i) == '-')) {
				return "";
			}
			if (str.charAt(i) == '.')
				stringWithRAndL = stringWithRAndL + "L";
			if (str.charAt(i) == '-')
				stringWithRAndL = stringWithRAndL + "R";
		}
		// if path provide a real any char
		if (this.morseDecoder.findByPath(stringWithRAndL) != null)
			res = (String) this.morseDecoder.findByPath(stringWithRAndL);

		return res;

	}

}
