package br.com.client_rmi;

import java.rmi.Naming;
import javax.swing.JOptionPane;
import br.com.calculator.Calculator;



public class CalculatorClient{
    public static void main(String[] args){
        try {
            Calculator calculator = (Calculator) Naming.lookup("//localhost:1021/CalculatorService");
           
            String opcao[] = {"+", "-", "*", "/"};
            int operacao = JOptionPane.showOptionDialog(
                null, 
                "Escolha uma das operacoes", 
                "Tipo Operacao", 
                0, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, 
                opcao, 
                opcao[0]
            );

            System.out.println(operacao);

            String primeiroValor = JOptionPane.showInputDialog(null, "Entre com o primeiro valor");
            String segundoValor = JOptionPane.showInputDialog(null, "Entre com o segundo valor");

            switch(operacao){
                case 0: {
                    //System.out.println(calculator.add(Integer.parseInt(primeiroValor), Integer.parseInt(segundoValor)));
                    JOptionPane.showMessageDialog(null,calculator.add(Integer.parseInt(primeiroValor), Integer.parseInt(segundoValor)));  
                    break;
                }
                case 1: {
                    //System.out.println(calculator.sub(Integer.parseInt(primeiroValor), Integer.parseInt(segundoValor)));
                    JOptionPane.showMessageDialog(null,calculator.sub(Integer.parseInt(primeiroValor), Integer.parseInt(segundoValor)));  
                    break;
                }
                case 2: {
                    //System.out.println(calculator.mul(Integer.parseInt(primeiroValor), Integer.parseInt(segundoValor)));
                    JOptionPane.showMessageDialog(null,calculator.mul(Integer.parseInt(primeiroValor), Integer.parseInt(segundoValor)));  
                    break;
                }
                case 3: {
                    //System.out.println(calculator.div(Integer.parseInt(primeiroValor), Integer.parseInt(segundoValor)));
                    JOptionPane.showMessageDialog(null,calculator.div(Integer.parseInt(primeiroValor), Integer.parseInt(segundoValor)));  
                    break;
                }
                default:
                    System.out.println("Verificar operacao");

            }
           
            //System.out.println(calculator.sub(4, 3));
            //System.out.println(calculator.add(4, 5));
            //System.out.println(calculator.mul(3, 6));
            //System.out.println(calculator.div(9, 3)); 
        } catch (Exception e) {
            System.out.println("Deu ruim no Server  " + e);
        }
    }
}