import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class InsertarFicheros {

	public static void main(String[] args) {

		Scanner sc = new Scanner (System.in);
		StringBuffer ristra;
		
		try{
		File f = new File ("C:/Users/eriks/Desktop/2º DAM/AED/Ejercicios/proyectohibernate/categorias.txt");	
		RandomAccessFile raf = new RandomAccessFile (f, "rw");
		File f2 = new File ("C:/Users/eriks/Desktop/2º DAM/AED/Ejercicios/proyectohibernate/productos.txt");	
		RandomAccessFile raf2 = new RandomAccessFile (f2, "rw");
		
	
		System.out.println("Inserción de las Categorías...");
		//Primero vamos a insertar en el fichero de categorias
		for (int i = 0; i<4; i++){
		
		System.out.println("Dime un CodC: ");
		String codc = sc.nextLine();
		raf.writeInt(Integer.parseInt(codc));
		
		System.out.println("Dime un nombre: ");
		String nombre = sc.nextLine();
		ristra = new StringBuffer (nombre);
		ristra.setLength(50);
		raf.writeChars(ristra.toString());
		
		System.out.println("Dime la descripción: ");
		String descripcion = sc.nextLine();
		ristra = new StringBuffer (descripcion);
		ristra.setLength(200);
		raf.writeChars(ristra.toString());
		}
		
		
		//INSERCION EN LA TABLA PRODUCTOS
		System.out.println("Inserción guardada");
		System.out.println("Inserción en los productos...");
		
		for (int a = 0; a<4; a++){
		System.out.println("Dime un CodP: ");
		String codp = sc.nextLine();
		raf2.writeInt(Integer.parseInt(codp));
		
		System.out.println("Dime un nombre: ");
		String nombrep = sc.nextLine();
		ristra = new StringBuffer (nombrep);
		ristra.setLength(50);
		raf2.writeChars(ristra.toString());
		
		System.out.println("Dime la altura: ");
		String altura = sc.nextLine();
		raf2.writeInt(Integer.parseInt(altura));
		
		System.out.println("¿Dosifica?: ");
		String dosifica = sc.nextLine();
		ristra = new StringBuffer (dosifica);
		ristra.setLength(2);
		raf2.writeChars(ristra.toString());
		
		System.out.println("Dime un CodC: ");
		String codc2 = sc.nextLine();
		raf2.writeInt(Integer.parseInt(codc2));
		}
		
		raf2.close();
		raf.close();
		System.out.println("Inserción guardada");
		}catch(IOException i){
		}
		
		sc.close();
		
		

	}

}
