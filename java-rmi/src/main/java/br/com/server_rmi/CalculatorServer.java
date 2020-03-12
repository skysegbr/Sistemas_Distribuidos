package br.com.server_rmi;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;

import br.com.calculator.Calculator;
import br.com.calculator.CalculatorImpl;


public class CalculatorServer implements Remote {
    public CalculatorServer(){
        try {
            Calculator calculator = new CalculatorImpl();
            LocateRegistry.createRegistry(1021);
            Naming.rebind("//localhost:1021/CalculatorService", calculator);
        } catch (Exception e) {
            System.out.println("Deu ruim!" + e);
        }
    }

    public static void main(String[] args) {
        new CalculatorServer();    
    }
}