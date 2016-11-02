package youth.hong.watermark;

import java.awt.Color;
import java.awt.Font;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface WaterMark {
	
	public static final int X = 300;
	
	public static final int Y = 300;
	
	public static final int FONT_STYLE = Font.BOLD;
	
	public static final Color FONT_COLOR = Color.BLACK;
	
	public static final int FONT_SIZE = 50;
	
	public static final String MARK_TEXT = "Ð»Ð»Ä½¿Î";
	
	public static final String FONT_NAME = "Î¢ÈíÑÅºÚ";
	
	public static final float ALPHA = 0.3f;
	
	public static final String IMAGE_WATER = "blue015.png";
	
	public String watermark(CommonsMultipartFile file, String uploadPath, String realUploadPath);
	
	
}
