package br.com.saude.apiautorizador.repository;

import br.com.saude.apiautorizador.dbutil.ConnectionDB;
import br.com.saude.apiautorizador.entity.PlanoSaude;
import br.com.saude.communautorizador.autorize.IListaPlanos;
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
public class ListarPlanos extends UnicastRemoteObject implements IListaPlanos {
    
    public ListarPlanos() throws RemoteException {
        super();
    }
    
    @Override
    public List<PlanoSaude> listarPlanos(String nome) throws RemoteException {
        System.out.println(nome);
        List<PlanoSaude> listaPlano = new ArrayList<>();
        ConnectionDB conn = new ConnectionDB();
        try (CallableStatement cs = conn.getConnection().prepareCall("{call AUTORIZADOR_REGRAS.RET_PLAS(:P_COD_PLAS, :P_NOME_PLAS, :P_PLAS)}")) {
            cs.setString("P_COD_PLAS", "0");
            cs.setString("P_NOME_PLAS", nome);
            cs.registerOutParameter("P_PLAS", OracleTypes.CURSOR);
            cs.execute();
            ResultSet planos = (ResultSet) cs.getObject("P_PLAS");

            while (planos.next()) {
                PlanoSaude planoSaude = new PlanoSaude();
                planoSaude.setCodPlas(Integer.parseInt(planos.getString("COD_PLAS")));
                planoSaude.setCnpjPlas(Integer.parseInt(planos.getString("CNPJ_PLAS")));
                planoSaude.setNomePlas(planos.getString("NOME_PLAS"));

                System.out.println(planoSaude.getNomePlas());
                System.out.println(planoSaude.getCodPlas());
                listaPlano.add(planoSaude);
            }
            conn.desconectaDB();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return listaPlano;
    }
    
}
