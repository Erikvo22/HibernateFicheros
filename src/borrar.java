import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class borrar {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		Configuration cfg =new Configuration().configure();
		SessionFactory sessionFactory=cfg.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		System.out.println("¿Donde desea borrar, en categorias o productos?: 1/2");
		String seleccion = sc.nextLine();
		
		if (seleccion.equals("1")){
		System.out.println("Dime el CodC que deseas borrar: ");
		String codc = sc.nextLine();
		Categorias c =new Categorias();
		c =(Categorias)session.load(Categorias.class, Integer.parseInt(codc));
		
		session.delete(c);
		System.out.println("Registro eliminado");
		
		
		
		}else if (seleccion.equals("2")){
		System.out.println("Dime el CodP que deseas borrar: ");
		String codp = sc.nextLine();
		Productos p =new Productos();
		p =(Productos)session.load(Productos.class, Integer.parseInt(codp));
		
		session.delete(p);
		System.out.println("Registro eliminado");
		
		
		} else {
			System.out.println("Inserte el 1 o el 2");
		}
		
		tx.commit();
		session.close();
	
		
		try {
		File f = new File ("C:/Users/eriks/Desktop/2º DAM/AED/Ejercicios/proyectohibernate/categorias.txt");	
		RandomAccessFile raf = new RandomAccessFile (f, "r");
			
		File f2 = new File ("C:/Users/eriks/Desktop/2º DAM/AED/Ejercicios/proyectohibernate/productos.txt");	
		RandomAccessFile raf2 = new RandomAccessFile (f2, "r");	
		
		
		
		
		
		raf.close();
		raf2.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
		sc.close();
	}

}
