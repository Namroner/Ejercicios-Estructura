package juegomaterials;

public class JuegoHerramients {

	public static void main(String[] args)  throws SubDesbordamientoMateriales{{
		// TODO Auto-generated method stub
		System.out.println("Hola Bienvenido jugador");	
		//herramientas
		boolean Mesa=false;
		boolean Barco=false;
		boolean Baston=false;
		boolean Cana_p=false;
		boolean Cuerda=false;
		//crear una variable aleatoria para definir los materiales
		
		int Rd=0;//aleatorio/Random
		// SE CREAN LAS CLASES GENERICAS PARA CADA MATERIAL CON SUS CAPACIDADES
		// clase generica HILO
		  Pila<Integer> PH = new Pila<>(4);
		// generica RESINA
		  Pila<Integer> PR = new Pila<>(1);
	    //clase generica MADERA
		  Pila<Integer> PM = new Pila<>(5);
		
		  //Crear una variable para guardar el  material que se produce 
		  int VM=0;
		boolean ResinaC=false;
		//--------------Empieza el juego-----------------
		for(int x=0;x<30;x++) {
			//Definir el tipo de material
			VM=(int)(Math.random()*(2-(-1)));
			
			Rd=(int)(Math.random()*(10)+1);
			System.out.println(VM + "---" +VM);
			//MADERA
			if(VM==0) { 
				  try {
					  PM.apilar(Rd);
					 
					  if((PM.cantidad()==4)&(Mesa==false)) {  
						  Mesa=true;
						  System.out.println("Mesa adquirida");
						  //vaciado
						  PM.vaciar();  
					  }if((PM.cantidad()==2)&(Baston==false)&(Mesa)) {
						  Baston=true;
						  System.out.println("Baston adquirido");
						//vaciado 
						  PM.vaciar(); 
					  }
				  }catch(DesbordamientoMateriales E) {
					  System.out.println(E.getMessage()+" Madera esta completa");
					  if((Barco==false)&(Mesa)&(Baston)&(Cuerda)&(Cana_p)) {
						  Barco=true;
						  System.out.println("Barco adquirido");
						  //Vaciado
						  PM.vaciar();
						  
						  System.exit(0);
					  }
				  }
				  //RESINA
			}if(VM==1) {
				  try {
				 PR.apilar(Rd);
			   }catch(DesbordamientoMateriales E) {
				  System.out.println(E.getMessage()+" Resina esta Completa ");
				 //condicion aquí
			       if(ResinaC==false) {
				    ResinaC=true;
				    //Vaciado
				     PR.vaciar();
				     }
				   }  
			 }//HILO
			  if(VM==2){
				  try {
				  PH.apilar(Rd);
			    }catch(DesbordamientoMateriales E) {
				  System.out.println(E.getMessage()+" Hilo esta completa ");
				  if((Cuerda==false)&(Mesa)&(ResinaC)&(Baston)) { //
					  Cuerda=true;
					  System.out.println("Cuerda adquirida");
					  //vaciado
					  PH.vaciar();
				    }
					 // comparar si se cumple para adquirir la caña
				   if((Cana_p==false)&(Mesa)&(Baston)&(Cuerda)) {
			    	  Cana_p=true;
			    	  System.out.println("Caña de Pescar Adquirida");
				     }
			      }
			    }   
		    }
		
		}

	}
/*1: SI LA PILA MADERA TIENE MAS DE 4 BLOQUES, RETIRE 4 BLOQUES DE LA PILA E IMPRIMA "MESA ADQUIRIDA".
 * 2: SI LA MESA FUE ADQUIRIDAD Y AUN HAY 2 BLOQUES DE MADERA EN SU PILA RETIRE 2 E IMPRIMA"BASTON AQUIRIDO".
 * 3: SI LA MESA FUE ADQUIRIDA, Y HAY (4 HILOS EN SU PILA) Y AL MENOS HAY (1 PORCION DE RESINA) EN SU PILA,RETIRE
 * LOS 4 HILOS Y PORCION DE RESINA DE SUS RESPECTIVAS PILAS E IMPRIMA "CUERDA ADQUIRIDA".
 * 4: SI LA MESA FUE ADQUIRIDA, Y HAY UN BASTON Y UNA CUERDA IMPRIMA "CAÑA DE PESCAR ADQUIRIDA".
 * 5: SI LA MESA FUE ADQUUIRIDA Y AUN QUEDAN (5 BLOQUES DE MADERA) RETIRE LOS 5 BLOQUE DE MADERA DESU PILA E IMPRIMA "BARCO ADQUIRIDO"*/
	
}

