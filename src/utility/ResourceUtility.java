package utility;

import java.awt.Font;
import java.io.BufferedInputStream;
import java.io.InputStream;

public class ResourceUtility {

	public static Font getFontFromResource(String file) {
		Font font = null;
		try {
			InputStream fontFile = new BufferedInputStream(ResourceUtility.class.getClassLoader().getResourceAsStream("/fonts" + file));
			font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
		} catch (Exception e) {
			e.printStackTrace();
			font = new Font("sans-serif", Font.PLAIN, 24);
		}
		return font;
	}
}
