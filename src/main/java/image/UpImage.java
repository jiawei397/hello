package image;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.xerces.impl.dv.util.Base64;

import sun.misc.BASE64Decoder;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 根据前台传递的base64位编码数据，在本地生成图片
 * @author jw
 * @date 2016年9月14日
 */
public class UpImage extends ActionSupport {
	private HttpServletRequest request;
	

	public String execute() throws Exception {
		this.request = ServletActionContext.getRequest();
		String base64StrImgData = request.getParameter("base64StrImgData");
		String imagName = request.getParameter("imagName");
		base64StrImgData = base64StrImgData.split(",")[1];
		System.out.println(imagName + "---------\n" + base64StrImgData);
//		generateImage(base64StrImgData);
		generateImage2(base64StrImgData);
		return SUCCESS;
	}

	// base64字符串转化成图片
	public static boolean generateImage(String imgStr) { // 对字节数组字符串进行Base64解码并生成图片
		if (imgStr == null) // 图像数据为空
			return false;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码
			byte[] b = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			// 生成jpeg图片
			String imgFilePath = "d:/test.jpg";// 新生成的图片
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(b);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean generateImage2(String imgStr) { // 对字节数组字符串进行Base64解码并生成图片
		if (imgStr == null) // 图像数据为空
			return false;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码
			byte[] b = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			// 生成jpeg图片
			 InputStream is = new ByteArrayInputStream(b);  
			    String fileName = UUID.randomUUID().toString();  
			    String imgFilePath =  "d:/" + fileName + ".jpg";// 新生成的图片
			    double ratio = 0.5;  
			    BufferedImage image = ImageIO.read(is); 
			    //设置图片是否缩放 
			    int newWidth = (int) (image.getWidth() * ratio);  
			    int newHeight = (int) (image.getHeight() * ratio);  
			    Image newimage = image.getScaledInstance(newWidth, newHeight,  Image.SCALE_SMOOTH);  
			    BufferedImage tag = new BufferedImage(newWidth, newHeight,  BufferedImage.TYPE_INT_RGB);  
			    Graphics g = tag.getGraphics();  
			    g.drawImage(newimage, 0, 0, null);  
			    g.dispose(); 
			    //使用io将图片写入文件中 
			    ImageIO.write(tag, "jpg", new File(imgFilePath));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
