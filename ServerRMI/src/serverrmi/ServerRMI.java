/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package serverrmi;

/**
 *
 * @author sistemas
 */

import Interface.RMIDAO; //libreria propia

//librerias que se importan
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import javax.management.remote.rmi.RMIServer;


public class ServerRMI extends UnicastRemoteObject implements RMIDAO{

    public ServerRMI() throws RemoteException{
        super();
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            Registry registro = LocateRegistry.createRegistry(7777);
            registro.rebind("RemotoRMI", new ServerRMI());
            System.out.println("Servidor esta activo");
        }catch(RemoteException ex){
            System.out.println(ex.getMessage());
        }
    }


    @Override
    public float sumar(float numero1, float numero2) {
        return numero1 + numero2; 
     }

    @Override
    public float restar(float numero1, float numero2) {
        return numero1 - numero2; 
    }

    @Override
    public float multiplicar(float numero1, float numero2) throws RemoteException {
        return numero1 * numero2; 
    }

    @Override
    public float dividir(float numero1, float numero2) throws RemoteException {
        return numero1 / numero2; 
    }
    
    
}
