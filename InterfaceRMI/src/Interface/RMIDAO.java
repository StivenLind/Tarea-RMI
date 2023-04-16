/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author sistemas
 */
public interface RMIDAO extends Remote{
   

    public float sumar(float numero1, float numero2)throws RemoteException;

    public float restar(float numero1, float numero2)throws RemoteException;

    public float multiplicar(float numero1, float numero2)throws RemoteException;

    public float dividir(float numero1, float numero2)throws RemoteException;
    
}
