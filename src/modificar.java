import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class modificar {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		Configuration cfg =new Configuration().configure();
		SessionFactory sessionFactory=cfg.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
	
		System.out.println("¿De que tabla quieres borrar, categorias o productos?:  1/2");
		String seleccion = sc.nextLine();
		
		if (seleccion.equals("1")){
		System.out.println("Dime el CodC del registro que deseas modificar: ");
		String codc = sc.nextLine();
		Categorias c =new Categorias();
		c =(Categorias)session.load(Categorias.class, Integer.parseInt(codc));
	
		System.out.println("¿Que valor deseas alterar?:  nombre/descripcion");
		String alterar = sc.nextLine();
		
		if(alterar.equals("nombre")){
		System.out.println("¿Que valor le quieres poner?");
		String valor = sc.nextLine();
		
		c.setNombrec(valor);
		
		System.out.println("Modificación guardada");
		
		}else if(alterar.equals("descripcion")){
		System.out.println("¿Que valor le quieres poner?");
		String valor = sc.nextLine();
			
		c.setDescripcion(valor);
			
		System.out.println("Modificación guardada");	
		} else{
			System.out.println("Debiste seleccionar o 'nombre' o 'descripcion'");
		}
		} else if (seleccion.equals("2")){
			
		System.out.println("Dime el CodP del registro que deseas modificar: ");
		String codp = sc.nextLine();
		Productos p =new Productos();
		p =(Productos)session.load(Productos.class, Integer.parseInt(codp));
		
		System.out.println("¿Que valor deseas alterar?:  nombre/tamano/dosifica/codc");
		String alterar = sc.nextLine();
			
		if(alterar.equals("nombre")){
		System.out.println("¿Que valor le quieres poner?");
		String valor = sc.nextLine();
			
		p.setNombrep(valor);
			
		System.out.println("Modificación guardada");
			
		}else if(alterar.equals("tamano")){
		System.out.println("¿Que valor le quieres poner?");
		String valor = sc.nextLine();
				
		p.setTamano(Integer.parseInt(valor));
				
		System.out.println("Modificación guardada");		
			
			
		}else if(alterar.equals("dosifica")){
			System.out.println("¿Que valor le quieres poner?");
			String valor = sc.nextLine();
					
			p.setDosifica(valor);
					
			System.out.println("Modificación guardada");		
				
				
			} else if(alterar.equals("codc")){
				System.out.println("¿Que valor le quieres poner?");
				String valor = sc.nextLine();
				Categorias c2 =new Categorias();
				c2 =(Categorias)session.load(Categorias.class, Integer.parseInt(valor));
				
				p.setCategorias(c2);
						
				System.out.println("Modificación guardada");		
					
					
				}else {
			System.out.println("Debiste poner 'nombre' o 'tamano' o 'dosifica' o 'codc'");
		}
		
		} else{
			System.out.println("Inserte el 1 o el 2");
		}
		
		tx.commit();
		session.close();
		sc.close();

	}

}
