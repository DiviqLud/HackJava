package toaster;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.nitido.utils.toaster.Toaster;

public class JToaster {
	public static void main(String[] args) throws IOException, InterruptedException {
		Toaster toasterManager = new Toaster();
		BufferedImage image = ImageIO.read(new File("kuche.jpeg"));
		
		toasterManager.setToasterHeight(600);
		toasterManager.setToasterWidth(900);
		toasterManager.setBackgroundImage(image);
		toasterManager.setDisplayTime(20000);
		toasterManager.showToaster("Take a rest. You've been too long in front of the computer!");
		
	}
}
