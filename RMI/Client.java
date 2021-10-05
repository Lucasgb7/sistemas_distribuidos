import java.rmi.registry.*;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author EAS - Eduardo Alves da Silva
 *  			 RMI Example - Client
 * Universidade do Vale do Itajaí - Univali
 * EMCT - Escola do Mar, Ciencia e Tecnologia
 * Curso de Computação - Sistemas Distribuídos
 */
public class Client {
    
    static IMessage client = null;
    
    public static void main(String[] args) {
        String hostname = args[0];
	int port = Integer.parseInt(args[1]);
        try {
//            Registry reg = LocateRegistry.getRegistry("192.168.0.14", 8080);
            Registry reg = LocateRegistry.getRegistry(hostname, port);
            client = (IMessage) reg.lookup("teste");

//            client = (IMessage) Naming.lookup("teste");
            String resposta = client.escreva("Oi do cliente");
            System.out.println("Resposta: "+resposta);
        } catch (NotBoundException | RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}package RMI;

public class client {
    
}
