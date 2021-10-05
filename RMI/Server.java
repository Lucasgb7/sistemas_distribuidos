package RMI;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author EAS - Eduardo Alves da Silva
 *  			 RMI Example - Server
 * Universidade do Vale do Itajaí - Univali
 * EMCT - Escola do Mar, Ciencia e Tecnologia
 * Computação - Sistemas Distribuídos
 */
public class Server extends UnicastRemoteObject implements IMessage {

    private static int OBJ_COUNTER = 1;
    private int objNum;
    
    Server() throws RemoteException{
        super();
        this.objNum = Server.OBJ_COUNTER++;
    }
    
    @Override
    public String escreva(String msg) throws RemoteException {
        System.out.println("Mensagem recebida no servidor: "+msg);
        return "Resposta do servidor - objeto: "+this.objNum;
    }
    
    public static void main(String args[]) {
        try {
            Registry reg = LocateRegistry.createRegistry(8080);
            reg.bind("teste", new Server());
            
//            Naming.rebind("teste", new Server());
            System.out.println("Servidor UP");
        } catch (Exception ex) {
            System.err.println("Erro: "+ex.getLocalizedMessage());
        }
    }
    
}