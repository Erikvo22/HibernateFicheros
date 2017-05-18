import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



public class leerFicheroyInsertarBD {

	public static void main(String[] args) {
		
		String mostrar = "";
		String nombrep = "", descripcion = "", nombrec = "", dosificacion ="";
		int codc = 0, codp = 0, codc2= 0, altura= 0;
		
		Categorias c = new Categorias();
		Categorias c2 = new Categorias();
		Productos p = new Productos();
		
		try {
		File f = new File ("C:/Users/eriks/Desktop/2º DAM/AED/Ejercicios/proyectohibernate/categorias.txt");	
		RandomAccessFile raf = new RandomAccessFile (f, "r");
		
		File f2 = new File ("C:/Users/eriks/Desktop/2º DAM/AED/Ejercicios/proyectohibernate/productos.txt");	
		RandomAccessFile raf2 = new RandomAccessFile (f2, "r");
		
		
		//Lectura del fichero Categorias e Insercion en la BD
		long tamano = raf.length();
		int pos = 0;
		int pos2 = 0;
		
		while(tamano > 504*pos){
			
			SessionFactory sesion=SessionFactoryUtil.getSessionFactory();
			Session session = sesion.openSession();
			Transaction tx=session.beginTransaction();
			
		System.out.println("Lectura de Categorias.txt");
			raf.seek(504*pos);
			mostrar = mostrar + "CodC:";
			codc = raf.readInt();
			mostrar = mostrar + codc;
			mostrar = mostrar + "\n";
			mostrar = mostrar + "Nombre: ";
			for(int i=0;i<50;i++){
				nombrec = nombrec + raf.readChar();
			}
			mostrar = mostrar + nombrec + "\n";
			mostrar = mostrar + "Descripcion:";
			for(int i=0;i<200;i++){
			descripcion = descripcion + raf.readChar();
			}	
			mostrar = mostrar + descripcion + "\n";
			
			pos=pos+1;
			System.out.println(mostrar);
			
			c.setCodc(codc);
			c.setNombrec(nombrec);
			c.setDescripcion(descripcion);
			session.save(c);
			
			mostrar = "";
			nombrec = "";
			descripcion = "";
			codc = 0;
			
			//Lectura del fichero Productos e Insercion en la BD
			
			System.out.println("Lectura del fichero Productos.txt");
			
				raf2.seek(116*pos2);
				mostrar = mostrar + "CodP:";
				codp = raf2.readInt();
				mostrar = mostrar + codp;
				mostrar = mostrar + "\n";
				mostrar = mostrar + "Nombre: ";
				for(int i=0;i<50;i++){
					nombrep = nombrep + raf2.readChar();
				}
				mostrar = mostrar + nombrep + "\n";
				mostrar = mostrar + "Tamaño:" ;
				altura = raf2.readInt();
				mostrar = mostrar + altura;
				mostrar = mostrar + "\n";
				mostrar = mostrar + "Dosificacion: ";
				for(int i=0;i<2;i++){
					dosificacion = dosificacion + raf2.readChar();
				}
				mostrar = mostrar + dosificacion + "\n";
				mostrar = mostrar + "CodC:" ;
				codc2 = raf2.readInt();
				mostrar = mostrar + codc2;
				mostrar = mostrar + "\n";
				
				pos2=pos2+1;
				System.out.println(mostrar);
				
				p.setCodp(codp);
				p.setNombrep(nombrep);
				p.setTamano(altura);
				p.setDosifica(dosificacion);
				c2=(Categorias)session.load(Categorias.class, codc2);
				p.setCategorias(c2);
				session.save(p);
				
				tx.commit();
				session.close();
				
				mostrar ="";
				nombrep = "";
				dosificacion = "";
				codp = 0; codc2 = 0; altura = 0;
		
		}
		
		raf.close();
		raf2.close();
	

		
	} catch (FileNotFoundException e) {
			e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
}
