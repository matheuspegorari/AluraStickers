import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;


import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class GeradoraDeFigurinhas {
	
	
	
	public void cria(InputStream input, String nomeArquivo) throws Exception {
		// ler imagem
		//InputStream inputStream = new URL(URL).openStream();
		
		BufferedImage imagemOriginal = ImageIO.read(input);
				
		//cria uma nova imagem em memoria com transparencia e redimensionada.
		
		int largura = imagemOriginal.getWidth();
		int altura = imagemOriginal.getHeight();
		int novaAltura = altura + 200;
		
		BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);		
		
		//copiar a imagem original para a nova imagem. Memoria >> Nova
		Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
		graphics.drawImage(imagemOriginal, 0, 0, null);
		
		//configurar a fonte
		graphics.setColor(Color.YELLOW);
		Font font = new Font(Font.SANS_SERIF,Font.BOLD,64);
		graphics.setFont(font);
		
		//escrever a frase na nova imagem
		
		graphics.drawString("TOPZERA", 0, novaAltura - 100);
		
		
		//escrever a nova imagem em um arquivo
		ImageIO.write(novaImagem, "png", new File("saida/" + nomeArquivo.replace(":", "") + ".png"));
		
	}

}
