import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class yes {
	public static void main(String[] args) throws Exception {
		InputStream inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies_1.jpg").openStream();
		System.out.println(inputStream);
		BufferedImage imagemOriginal = ImageIO.read(inputStream);
		System.out.println(imagemOriginal);
	}
}
