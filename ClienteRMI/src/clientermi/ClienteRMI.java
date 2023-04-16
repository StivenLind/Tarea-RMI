/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clientermi;

/**
 *
 * @author sistemas
 */
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import Interface.RMIDAO;

public class ClienteRMI {
        private static final String IP = "127.0.0.1"; 
	private static final int PUERTO = 7777;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, NotBoundException {
        // TODO code application logic here
       Registry registry = LocateRegistry.getRegistry(IP, PUERTO);
        RMIDAO interfaz = (RMIDAO) registry.lookup("Calculadora"); 
        Scanner sc = new Scanner(System.in);
        int eleccion;
        float numero1, numero2, resultado = 0;
        String menu = "\n\n------------------\n\n[-1] => Salir\n[0] => Sumar\n[1] => Restar\n[2] => Multiplicar\n[3] => Dividir\nElige: ";
        do {
            System.out.println(menu);

            try {
                eleccion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                eleccion = -1;
            }

            if(eleccion != -1){

            	System.out.println("Ingresa el número 1: ");
            	try{
                	numero1 = Float.parseFloat(sc.nextLine());
            	}catch(NumberFormatException e){
            		numero1 = 0;
            	}

            	System.out.println("Ingresa el número 2: ");
            	try{
                	numero2 = Float.parseFloat(sc.nextLine());
            	}catch(NumberFormatException e){
            		numero2 = 0;
            	}
                switch (eleccion) {
	                case 0:
	                    resultado = interfaz.sumar(numero1, numero2);
	                    break;
	                case 1:
	                    resultado = interfaz.restar(numero1, numero2);
	                    break;
	                case 2:
	                    resultado = interfaz.multiplicar(numero1, numero2);
	                    break;
	                case 3:
	                    resultado = interfaz.dividir(numero1, numero2);
	                    break;
	            }

                System.out.println("Resultado => " + String.valueOf(resultado));
                System.out.println("Presiona ENTER para continuar");
                sc.nextLine();
            }
        } while (eleccion != -1);
    }
}