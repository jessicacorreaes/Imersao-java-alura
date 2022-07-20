import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

public class GeradoraDeFigurinhas {

    public void cria(InputStream imputStream, String nomeArquivo) throws Exception {

        //ler a imagem
        //InputStream imputStream = new FileInputStream(new File("entrada/filme.jpg") );
        //InputStream imputStream2 = new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_1.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(imputStream);

        //cria nova imagem em momeria com transparencia e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        //copiar a imagem original pra novo imagem em memoria
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        //configurar fonte
        var fonte = new Font("Arial", Font.BOLD, 80);
        graphics.setColor(Color.white);
        graphics.setFont(fonte);

        //escreve o texto na imagem
        graphics.drawString("Top 250", largura / 4, novaAltura - 100);

        //escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File("saida/" + nomeArquivo));

    }


}
