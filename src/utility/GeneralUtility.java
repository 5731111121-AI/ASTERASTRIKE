package utility;

public class GeneralUtility {

	public static int random(int start, int end) {
		if(start > end)
			return random(end, start);
		return (int) (Math.random() * (end - start + 1) + start);
	}
}
