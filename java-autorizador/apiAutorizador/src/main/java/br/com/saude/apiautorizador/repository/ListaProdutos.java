package br.com.saude.apiautorizador.repository;

import br.com.saude.apiautorizador.dbutil.ConnectionDB;
import br.com.saude.apiautorizador.entity.Produto;
import br.com.saude.communautorizador.autorize.IListaProdutos;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Danilo Segura
 */
public class ListaProdutos extends UnicastRemoteObject implements IListaProdutos {

    public ListaProdutos() throws RemoteException {
        super();
    }

    @Override
    public Produto listarProduto(String ean) throws RemoteException {
        Produto produto = new Produto();
        ConnectionDB conn = new ConnectionDB();
        try (CallableStatement cs = conn.getConnection().prepareCall("{call AUTORIZADOR_REGRAS.RET_PRODUTOS(:P_EAN, :P_NOME_PRODUTO,:P_PRODUTOS)}")) {
            cs.setString("P_EAN", ean);
            cs.setString("P_NOME_PRODUTO", "NULL");
            cs.registerOutParameter("P_PRODUTOS", OracleTypes.CURSOR);
            cs.execute();
            ResultSet produtos = (ResultSet) cs.getObject("P_PRODUTOS");

            while (produtos.next()) {
                produto.setCodProd(Integer.parseInt(produtos.getString("COD_PROD")));
                produto.setNomeProd(produtos.getString("NOME_PROD"));
                produto.setTpProduto(Integer.parseInt(produtos.getString("TP_PRODUTO")));
            }
            conn.desconectaDB();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println(produto.getCodProd());
        System.out.println(produto.getNomeProd());
        System.out.println(produto.getTpProduto());
        return produto;
    }

    @Override
    public List<Produto> listarProdutos(String nome) throws RemoteException {
        
        List<Produto> listaProduto = new ArrayList<>();
        ConnectionDB conn = new ConnectionDB();
        try (CallableStatement cs = conn.getConnection().prepareCall("{call AUTORIZADOR_REGRAS.RET_PRODUTOS(:P_EAN, :P_NOME_PRODUTO,:P_PRODUTOS)}")) {
            cs.setString("P_EAN", "0");
            cs.setString("P_NOME_PRODUTO", nome);
            cs.registerOutParameter("P_PRODUTOS", OracleTypes.CURSOR);
            cs.execute();
            ResultSet produtos = (ResultSet) cs.getObject("P_PRODUTOS");

            while (produtos.next()) {
                Produto produto = new Produto();
                produto.setCodProd(Integer.parseInt(produtos.getString("COD_PROD")));
                produto.setNomeProd(produtos.getString("NOME_PROD"));
                produto.setTpProduto(Integer.parseInt(produtos.getString("TP_PRODUTO")));
                System.out.println(produto.getCodProd());
                System.out.println(produto.getNomeProd());
                System.out.println(produto.getTpProduto());
                listaProduto.add(produto);
            }
            conn.desconectaDB();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

       
        return listaProduto;
    }
}
