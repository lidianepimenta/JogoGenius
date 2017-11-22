package br.com.cybertech.genius.game;

/*******************************************************************************
 *
 *                          MOVIMENTO DO GENIUS.
 *
 *   Esta classe representa um movimento do jogo, atraves da qual será possível
 * saber qual o índice do botão que será aceso, qual sua cor e qual o som será
 * reproduzido.
 *
 
 * @author Felipe Gil      
 * @author Leandro Medeiros    
 * @author Lidiane Pimenta 
 * @author Thiago Sanches  
 *
 ******************************************************************************/

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import sun.audio.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class GeniusMove {
    final public static int TYPE_GREEN  = 1;
    final public static int TYPE_RED    = 2;
    final public static int TYPE_YELLOW = 3;
    final public static int TYPE_BLUE   = 4;

    private final int id;
    
    /**
     * Construtor.
     *   Ao construir um novo movimento, é gerado aleatóriamente um id de tipo.
     * É a partir deste tipo que se define a cor e o som do movimento.
     * @param typeId
     */
    public GeniusMove(int typeId) {
        if (typeId < 1 || typeId > 4)
            this.id = (int)((Math.random() * 4) + 1);
        else
            this.id = typeId;
    }
    
    /**
     * Getter
     * @return ID do tipo de movimento
     */
    public int getId() {
        return this.id;
    }
    
    /**
     * Obter Imagem
     * @param fileName - Nome do arquivo no disco
     * @return Ícone
     */
    public static ImageIcon getImage(String fileName) {
        ImageIcon image = null;

        fileName = ".//images//" + fileName + ".png";
        
        try
        {
            image = new ImageIcon(ImageIO.read( new File(fileName)));
        } catch (IOException ex) {
            //tratar
        }

        return image;
    }
    
    /**
     * Obter Cor "Acessa"
     * @return Imagem correspondente ao movimento quando ativo
     */
    public ImageIcon getOnImage() {
        return GeniusMove.getImage(this.getId() + "_on");
    }
    
    /**
     * Obter Cor "Apagada"
     * @return Imagem correspondente ao movimento quando desativado
     */
    public ImageIcon getOffImage() {
        return GeniusMove.getImage(this.getId() + "_off");
    }
    
    /**
     * Reproduz som correspondente ao tipo do movimento.
     */
    public void playSound() {
        GeniusMove.playSound(this.getId() + "");
    }

    public static void playSound(final int moveType) {
        GeniusMove.playSound(String.valueOf(moveType));
    }
    
    public static void playSound(final String fileName) {
        InputStream in;
        try {
            in = new FileInputStream(".//sounds//" + fileName + ".wav");

            try {
                AudioPlayer.player.start(new AudioStream(in));
            } catch (IOException ex) {
                Logger.getLogger(GeniusMove.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GeniusMove.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}