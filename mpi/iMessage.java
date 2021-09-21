import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author EAS - Eduardo Alves da Silva
 *  			 RMI Example - Interface
 * Universidade do Vale do Itajaí - Univali
 * CTTMar - Centro de Ciências Tecnológicas da Terra e do Mar
 * Curso de Ciência da Computação - Sistemas Distribuídos
 */
public interface IMessage extends Remote {
    String escreva(String msg) throws RemoteException;
}