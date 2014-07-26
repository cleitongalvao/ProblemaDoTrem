/****************************************************************
* Autor: Cleiton Galvão Santana
* Matricula: 200910563
* Inicio: 06/06/2014
* Ultima alteracao: 16/06/2014
* Nome: Jantar dos Filosofos
* Funcao: utiliza o algoritmo jantar dos filosofos para simular o 
*          funcionamento de um jantar com filosofos em uma mesa.
* Versao: V0
****************************************************************/
import javax.swing.JOptionPane;

public class FeedbackException extends Exception {
  /*************
   * excecao de consumo e producao - quando o buffer estiver cheio ou vazio
   * @param mensagem 
   **************/
  public FeedbackException(String mensagem){
    JOptionPane.showConfirmDialog(null, mensagem, "FeedBack", -1);
  }//fim construtor
}//fim FeedbackException
