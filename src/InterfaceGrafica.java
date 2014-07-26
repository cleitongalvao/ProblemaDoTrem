/* *********************************************************************************
* Autor: Cleiton Galvao Santana
* Inicio: 06-06-2014
* Ultima alteracao: 18-06-2014
* Nome: Cleiton Galvao Santana/200910563
* Funcao: Simular o Funcionamento do Algoritmo dos Filosofos
*********************************************************************************** */
import javax.sound.sampled.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
//import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Font;
import java.awt.Color;
//import java.awt.Graphics;
// Necessario para a parte de Codificacoes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

@SuppressWarnings("serial")
public class InterfaceGrafica extends JFrame implements ActionListener, ChangeListener
{
  private static int m_velocidadeAnimacao; // Velocidade da Animacao
    
  // JLabel para Imagem de
  // Fundo do sistema 
  private JLabel m_labelFundo;
  private ImageIcon m_imagemDoFundo;
  private ImageIcon m_imagemDoPlayer;
  
  private boolean m_flagPlayStop;//true para Play e false para Stop
  
  // JLabel para armazenar as  Imagens dos Computadores e  Seus Respectivos Titulos 
  //public static JLabel m_prato;//
  public static JLabel m_labelHarryCabecaEFaixa;
  public static JLabel [] m_pista, m_cruzamento;
  public static JLabel [] m_comQuemEstaOGarfo;
 
  // JButton para Visualizar/Minimizar o Painel de configurações
  private JButton m_botaoParaControlarVisibilidadeDoPainelDeConfiguracoes, m_testaThread, m_testaThread2; 
                                  
  public static Icon [] m_imagemDaPista, m_imagemDoCruzamento; 
  
  private JPanel m_painelConfiguracoesGerais; 
  
  //CheckBox para ativar/desativar som ao receber uma nova mensagem 
  public static JCheckBox m_checkboxExecutarSomAoReceberMensagem;
  
  // JTextField contendo o valor escolhido em uma barra deslizante. esse valor ira ser usado
  //  para controlar a velocidade da animacao
  private JSlider m_deslizeVelocidadeDaAnimacao;
  
  // declara uma variavel do tipo ExecutarSom(classe responsavel pela execução dos sons do sitema)
  public static ExecutarSom somDaMensagem; 
  
  public static Trem t1;
  
  public static JButton trocaMusica;
  
  /* ***************************************************************
  * Metodo Principal: Metodo Construtor
  *************************************************************** */
  public InterfaceGrafica()
  {  
	super("Trem do Maroto");
    setLayout( null );
    this.setIconImage(new ImageIcon(getClass().getResource("/imagens/iconeHogWarts.png")).getImage()); //Seleciona a imagem de ícone da aplicação
	somDaMensagem = new ExecutarSom( "musicas/hedwigsTheme.wav");
	somDaMensagem.start();
	
	m_flagPlayStop = true;
	m_imagemDoPlayer = new ImageIcon(getClass().getResource( "/imagens/musica/iconeBotao.png" ));
	trocaMusica = new JButton();
	trocaMusica.setBounds(1310,20,50,50);
	trocaMusica.addActionListener(this);
	add(trocaMusica);
	trocaMusica.setIcon(m_imagemDoPlayer);
	
	

    //Inicializando Variaveis com Valores padrões de inicio
    m_velocidadeAnimacao = 6; // Velocidade da animação por padrão é 7
    
    
    //Vetor de cinco posições, do tipo Label, para colocar as imagens dos filosofos
    m_pista = new JLabel[8];  
    m_cruzamento = new JLabel[8];
    
    //t1 = new Trem();
    //t1.start();   
    m_imagemDoFundo = new ImageIcon(getClass().getResource( "/imagens/MapaDoMaroto.png" ));
    m_labelFundo = new JLabel();
    m_labelFundo.setIcon(m_imagemDoFundo);
    add(m_labelFundo);	
    m_labelFundo.setBounds(0,-15,1380,800);//setBounds(coluna ,linha , largura, altura)
    
  } // fim do metodo Public
  
  public void Adicionar(JLabel label)
  {
	 add(label);
  }
  
  
  /* todos o metodos Get e Set das variaveis utilizadas em outras classes
   * 
   */
  
  public void setVelocidadeAnimacao(int velocidadeAnimacao)
  {
      m_velocidadeAnimacao = velocidadeAnimacao;
  }
  
  public static int getVelocidadeAnimacao()
  {
     return m_velocidadeAnimacao;
  }
  
  /* ***************************************************************
  * Metodo actionPerfomed: metodo responsavel pelas acoes de clique
  *                        seja nos botoes ou em outros componentes
  * Parametros: um variavel "e" do tipo ActionEvent
  * Retorno: eh do tipo void, portanto nao contem retorno
  *************************************************************** */
  public void actionPerformed(ActionEvent e)
  {
    if (e.getSource() == trocaMusica)
    {
    	//System.out.println("Entrou aqui");
    	if (m_flagPlayStop){
        	somDaMensagem.interrupt();
        	m_flagPlayStop = false;
    	}
    	else
    	{
        	somDaMensagem = new ExecutarSom( "musicas/hedwigsTheme.wav");
        	somDaMensagem.start();
        	m_flagPlayStop = true;
    	}
    	
    }
    else
	if ( e.getSource()== m_pista ) //Botao que da inicio a escrita de mensagem no Computador1
    {
      JOptionPane.showInternalMessageDialog(null, "Filosofo0", "Filoso[i]", 0);      
    } //Fim do If (e.getSource()== m_mensagemComputador1)	

    else if (e.getSource() == m_botaoParaControlarVisibilidadeDoPainelDeConfiguracoes)
    {
      if (m_botaoParaControlarVisibilidadeDoPainelDeConfiguracoes.getText().equals("Configurações"))
      {
        m_painelConfiguracoesGerais.setBounds(0,483,900,216);//setBounds(coluna ,linha , largura, altura)      
        m_botaoParaControlarVisibilidadeDoPainelDeConfiguracoes.setText("Minimizar");
      }// fim do if      
      else if (m_botaoParaControlarVisibilidadeDoPainelDeConfiguracoes.getText().equals("Minimizar" ))
      {
        m_painelConfiguracoesGerais.setBounds(0,658,900,216);//setBounds(coluna ,linha , largura, altura)       
        m_botaoParaControlarVisibilidadeDoPainelDeConfiguracoes.setText("Configurações");
      } // fim do else if           
    } // fim do else
    
    else if (e.getSource() == m_testaThread)
    {

    }
    
    else if (e.getSource() == m_testaThread2){

    }
        
  }//Fim do Metodo actionPerformed


  /* *********************************************************************************** 
  * Metodo stateChanged: Aguarda alguma alteração no estado de determinado componente
  * Parametros: um Objeto do tipo ChangeEvent
  * Retorno: void
  ************************************************************************************ */
  public void stateChanged(ChangeEvent e) 
  {
    JSlider sliderParaComparacao = (JSlider) e.getSource();
    if(!sliderParaComparacao.getValueIsAdjusting())
      m_velocidadeAnimacao = sliderParaComparacao.getValue();      
  }//Fim do Metodo stateChanged
  
}