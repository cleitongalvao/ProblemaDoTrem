import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JSlider;


public class Trem extends Thread {
	  private JLabel m_labelVelocidadeDaAnimacao;
	  private JSlider m_deslizeVelocidadeDaAnimacao;
	public Trem() {
		
	    // Label que se posiciona acima do JSlider para Escolha da Velocidade na animação
	    m_labelVelocidadeDaAnimacao = new JLabel("Velocidade da Animação:"); // 21 caracteres
	    m_labelVelocidadeDaAnimacao.setBounds(9, 65,210,20);//setBounds(coluna ,linha , largura, altura)
	    m_labelVelocidadeDaAnimacao.setForeground(Color.white);
	    m_labelVelocidadeDaAnimacao.setFont(new Font("", Font.BOLD, 14));               
	    // JSlider para Selecionar o Intervalo na animação (intervalo esse em Segudos)
	    //m_deslizeVelocidadeDaAnimacao = new JSlider(JSlider.HORIZONTAL, 1, 34, getVelocidadeAnimacao());
	    m_deslizeVelocidadeDaAnimacao.setMajorTickSpacing(3);
	    m_deslizeVelocidadeDaAnimacao.setMinorTickSpacing(1);
	    m_deslizeVelocidadeDaAnimacao.setPaintTicks(true);
	    m_deslizeVelocidadeDaAnimacao.setPaintLabels(true);
	    m_deslizeVelocidadeDaAnimacao.setSnapToTicks(true);
	    //m_deslizeVelocidadeDaAnimacao.addChangeListener(this);    
	    m_deslizeVelocidadeDaAnimacao.setBounds(2, 88, 290,35); //setBounds(coluna, linha, largura, altura) 
	    m_deslizeVelocidadeDaAnimacao.setOpaque(false);
	    m_deslizeVelocidadeDaAnimacao.setBackground( Color.WHITE );
        InterfaceGrafica.somDaMensagem = new ExecutarSom("hedwigsTheme.wav");
        InterfaceGrafica.somDaMensagem.start();   
		// TODO Auto-generated constructor stub
	}
	
	@Override 
	public void run()
	{
	  while(true)
	  {
	    try 
	    {
          //if (Principal.estadoFilosofo == 'P')
          { 
        	  Pensando(1);
        	  //
          }
          //else if (Principal.estadoFilosofo == 'C')
          {
	    	  //	
          }
        } 
	    catch (InterruptedException | FeedbackException ex) 
	    {
	    } //fim try-catch
      }//fim while(true)
    }//fim run
    
	
	private void Pensando(int fil) throws FeedbackException, InterruptedException
	{ 
	//InterfaceGrafica.m_filosofos[fil].setVisible(false);
	//InterfaceGrafica.m_filosofos[fil].setVisible(true);
	  //while (Principal.estadoFilosofo == 'P')
	  { 	
	    //InterfaceGrafica.m_filosofos[fil].setIcon(InterfaceGrafica.m_imagemDoFilosofoPensando[0]);      
	    sleep(100);	
	  }
	}

}
