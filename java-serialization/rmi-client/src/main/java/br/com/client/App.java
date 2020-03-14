package br.com.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import br.com.commun.IServiceRemote;
import br.com.commun.Person;
import br.com.commun.Professor;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        try {
            IServiceRemote objPerson = (IServiceRemote) Naming.lookup("rmi//localhost:8282/person");

            Professor professor1 = new Professor();

            professor1.setId(1);
            professor1.setName("Pedro");
            professor1.setTelephone("(12) 1234-5678");
            professor1.setCitie("São Sebastião");

            Professor professor2 = new Professor();

            professor2.setId(1);
            professor2.setName("Bruno");
            professor2.setTelephone("(16) 4321-7656");
            professor2.setCitie("Araraquara");

            // Insert Professor
            objPerson.insert(professor1);
            objPerson.insert(professor2);

            for (Person person : objPerson.listPerson()) {
                System.out.println("ID: " + person.getId());
                System.out.println("Name: " + person.getName());
                System.out.println("Telephone: " + person.getTelephone());
                System.out.println("Citie: " + person.getCitie());
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}
