package colasPrueba;

public class ColaGen <T> {
private T Esquina[];
private int Frente;
private int Siguiente;
public ColaGen(int N) {
	Esquina = (T[])new Object[N];
	//posicion inicial de siguiente
	Siguiente= 0;
	//posicion inicial de frente
	Frente= -1;
	
   }
public boolean colallena() {
	if (Siguiente==Esquina.length) {
		return true;
	}else {
		return false;
	}
}
public void encolar(T Num) throws Exception {
	//Si la cola esta vacia
	if(colavacia()) {
		//System.out.println("reset");
		Frente=-1;
		Siguiente=0;
	}
	if(colallena()) {
		throw new ExcepcionColaLlena();
		}
	Esquina[Siguiente]=Num;
	Siguiente++;
	
	//cuando apenas se agrege un numero
	if(Siguiente == 1) {
		Frente=0;
	}
}
public boolean colavacia() {
	if (Frente==Siguiente) {
	
		return true;
	}else if(Frente==-1) {
		return true;
	}else {
		return false;
	}
}
public T sacar() throws ExcepcionColaVacia{
	if(colavacia()) {
		throw new ExcepcionColaVacia();
		}
	T valor=Esquina[Frente];
	Frente++;
	
	return valor;
}}
