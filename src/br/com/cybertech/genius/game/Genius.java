package br.com.cybertech.genius.game;

/*******************************************************************************
 *
 *                              CYBER GENIUS.
 *
 *   A partir desta classe será possível controlar o fluxo de toda a aplicação.
 * Os métodos aqui disponibilizados controlam o início, do jogo, cria novas
 * jogadas e verifica se o usuário errou ou se chegou na última fase.
 *
 
 * @author Felipe Gil      
 * @author Leandro Medeiros    
 * @author Lidiane Pimenta 
 * @author Thiago Sanches   
 *
 ******************************************************************************/
public class Genius {
    private GeniusMove[] moves;
    private final int maxLevels;
    private int level;

    /**
     * Construtor
     * @param inMaxLevels - Define o nível de dificuldade do jogo
     */
    public Genius(int inMaxLevels) {
        this.maxLevels = inMaxLevels;
        this.start();
    }
    
    /**
     * Iniciar
     * Limpa os movimentos que possam existir e reseta a fase atual do jogo
     */
    final public void start() {
        this.moves = new GeniusMove[this.maxLevels];
        this.level = -1;
    }

    /**
     * Obter Fase Atual
     * @return Fase que o jogador está (inteiro)
     */
    public final int getCurrentLevel() {
        return this.level;
    }

    /**
     * Obter Número da última fase
     * @return dificuldade do jogo
     */
    final public int getMaxLevels() {
        return this.maxLevels;
    }
        
    /**
     * Novo Movimento.
     * Incrementa a fase atual e cria um novo movimento para
     *
     * @return Verdadeiro caso consiga criar um novo movimento e falso caso o
     * usuário tenha atingido a última fase (Vitória).
     */
    public boolean newMove() {
        this.level++;
        
        if (this.level == (this.maxLevels -1)) {
            return false;
        }

        else {
            this.moves[this.level] = new GeniusMove(0);
            return true;
        }
    }
    
    /**
     * Obter Movimento da Fase
     * @param inLevel fase desejada
     * @return movimento correspondente
     */
    public GeniusMove getMoveAt(int inLevel) {
        return this.moves[inLevel];
    }
    
    /**
     * Jogador Perdeu?
     * @param inUserMove Movimento do jogador
     * @param inLevel fase que está sendo testada
     * @return Verdadeiro caso o jogador tenha errado e falso caso tenha
     * acertado.
     */
    public boolean hasLost(GeniusMove inUserMove, int inLevel) {
        if (inLevel > this.level) inLevel = this.level;

        return (this.getMoveAt(inLevel).getId() != inUserMove.getId());
    }
}