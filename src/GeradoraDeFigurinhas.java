
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
	import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
	
	public void criaFigurinha(InputStream inputStream, String nomeArquivo) throws Exception {
		
		BufferedImage imagemOriginal = ImageIO.read(inputStream);
		
		int altura = imagemOriginal.getHeight();
		int largura = imagemOriginal.getWidth();
		int novaAltura = altura + 200;
		BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
		
		Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
		graphics.drawImage(imagemOriginal, 0, 0, null);
		
		var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
		graphics.setColor(Color.GREEN);
		graphics.setFont(fonte);
		
		graphics.drawString("Topzera", 100, novaAltura - 100);
		
		ImageIO.write(novaImagem, "png", new File(nomeArquivo));
		
	}
	
}
