package br.com.saude.testes;

import br.com.saude.apiautorizador.entity.PlanoSaude;
import br.com.saude.apiautorizador.entity.Produto;
import br.com.saude.communautorizador.autorize.IListaPlanos;
import br.com.saude.communautorizador.autorize.IListaProdutos;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Danilo Segura
 */
public class TestesAPI {

    public static void testeProdutoEan() {
        Produto produto;
        try {
            IListaProdutos produtos = (IListaProdutos) Naming.lookup("rmi://localhost:8282/listaProdutos");
            produto = produtos.listarProduto("7896137133000");
            System.out.println("Nome do Produto: " + produto.getNomeProd());
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            System.out.println(ex);
        }
    }

    public static void testeProdutoNome() {
        List<Produto> listaProdutos;

        try {
            IListaProdutos produtos = (IListaProdutos) Naming.lookup("rmi://localhost:8282/listaProdutos");
            listaProdutos = produtos.listarProdutos("aspirina");

            for (Produto produto : listaProdutos) {
                System.out.println("Codigo do Produto: " + produto.getCodProd());
                System.out.println("Nome do Produto:   " + produto.getNomeProd());
                System.out.println("Tipo do Produto:   " + produto.getTpProduto());
            }

        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            System.out.println(ex);
        }
    }
    
    public static void testePlanosNome() {
        List<PlanoSaude> listaPlanos;

        try {
            IListaPlanos planos = (IListaPlanos) Naming.lookup("rmi://localhost:8282/listaPlanos");
            listaPlanos = planos.listarPlanos("sulamerica");

            for (PlanoSaude planoSaude : listaPlanos) {
                System.out.println("Codigo do Plano de Saude: " + planoSaude.getCodPlas());
                System.out.println("Nome do Plano de Saude:   " + planoSaude.getNomePlas());
            }

        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        System.out.println("Produtos por EAN");
        testeProdutoEan();
        System.out.println("");
        System.out.println("Produtos por Nome");
        testeProdutoNome();
        System.out.println("");
        System.out.println("Planos de Saudee");
        testePlanosNome();
    }

}
