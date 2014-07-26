/* *********************************************************************************
* Autor: Cleiton Galvao Santana
* Inicio: 03-07-2014
* Ultima alteracao: 03-07-2014
* Nome: Cleiton Galvao Santana/200910563
* Funcao: Simular o Funcionamento de trilho com Trens
*********************************************************************************** */
import javax.swing.JFrame;

//import javax.swing.JOptionPane;

//import classes.Fila;
//import classes.ExecutarSom;
/* **/
public class Principal extends JFrame
{
  	
  private static final long serialVersionUID = 1L;
  
  public static InterfaceGrafica frame; 
  /* ***************************************************************
  * Metodo Principal: Metodo Construtor
  *************************************************************** */
  public Principal()
  {    

    //super("Jantar dos Filósofos");
  } // fim do metodo Public
  

  
  /* ***************************************************************
  * Metodo main: metodo necessario para inicializar do sistema
  * Parametros: um array de String
  * Retorno: eh do tipo void, portanto nao contem retorno
  ***************************************************************/ 
  public static void main( String[] args)
  {
	frame = new InterfaceGrafica();// delcara uma variavel chamda "frame" do tipo Principal e cria um novo objeto
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE); //Quando Fechar o Frame Finalizar o sistema
    frame.setSize(1380,800); //Define o Tamanho da Tela    
    frame.setLocationRelativeTo( null );//centraliza a tela, antes de mostrar
    frame.setResizable(false);//não permite o redimensionamento da tela
    frame.setVisible(true); // Visualiza Tela
  } // fim do metodo main
  
  
}//Fim da Classe Principal
