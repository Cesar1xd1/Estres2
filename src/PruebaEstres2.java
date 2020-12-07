import java.util.Arrays;
import java.util.Scanner;

interface Correcion{
	Scanner input = new Scanner(System.in);
	
	public static int validacion() {
		int r = 0;
		boolean e = false;
		do {
			try {
				r = input.nextInt();
			} catch (java.util.InputMismatchException h) {
				System.out.println("Ups... Solo numeros porfavor, intenta de nuevo:");
				input.nextLine();
				e=true;
			}
			if (r>0) {
				e=false;
			}else {
				System.out.println("Solo numeros mayores a 0 por favor, intenta de nuevo:");
				e=true;
			}
		}while(e);
		return r;
	}
}



class MetodosDeOrdenamiento2{
	static long tInicio,tFin;
	static int pasadas;
	static int intercambios;
	static int comparaciones;
	
		static public int[] intercalacion(int primero[],int segundo[]) {
			int arrayOrdenado[] = new int[primero.length+segundo.length];
			int i=0,j=0,k=0;
			while(i<primero.length && j<segundo.length) {
				if(primero[i]<segundo[j]) {
					arrayOrdenado[k]=primero[i];
					k++;
					i++;
				}else {
					arrayOrdenado[k]=segundo[j];
					k++;
					j++;
				}
			}
			while(j<segundo.length) {
				arrayOrdenado[k]=segundo[j];
				j++;
				k++;
			}
			while(i<primero.length) {
				arrayOrdenado[k]=segundo[j];
				j++;
				k++;
			}
			
			return arrayOrdenado;
		
	}//Intercalacion
	
	static public int [] ordenamientoMezclaDirecto(int arreglo[]) {
		int i,j,k;
		comparaciones++;
		if(arreglo.length>1) {
			int numElementosIzq=arreglo.length/2;
			int numElmentosDer=arreglo.length-numElementosIzq;
			
			int arregloIzquierdo[]=new int[numElementosIzq];
			int arregloDerecha[]=new int[numElmentosDer];
		
			for(i=0;i<numElementosIzq;i++) {
				arregloIzquierdo[i]=arreglo[i];
				pasadas++;
			}
			
			i=0;
			for(i=numElementosIzq;i<numElementosIzq+numElmentosDer;i++) {
				arregloDerecha[i-numElementosIzq]=arreglo[i];
				pasadas++;
			}
			
			
			
			arregloIzquierdo=ordenamientoMezclaDirecto(arregloIzquierdo);
			arregloDerecha=ordenamientoMezclaDirecto(arregloDerecha);
			i=j=k=0;
			
			while(arregloIzquierdo.length!=j && arregloDerecha.length!=k) {
				comparaciones++;
				if(arregloIzquierdo[j]<arregloDerecha[k]) {
					intercambios++;
					arreglo[i]=arregloIzquierdo[j];
					i++;
					j++;
				}else {
					intercambios++;
					arreglo[i]=arregloDerecha[k];
					i++;
					k++;
				}
				pasadas++;
			}
			
			while(arregloIzquierdo.length!=j) {
				intercambios++;
				arreglo[i]=arregloIzquierdo[j];
				i++;
				j++;
				pasadas++;
			}
		
			while(arregloDerecha.length!=k) {
				intercambios++;
				arreglo[i]=arregloDerecha[k];
				i++;
				k++;
				pasadas++;
			}
		}
		
		return arreglo;
	}
	static public void ordenamientoMezclaDirecto2(int arreglo[]) {
		int i,j,k;
		comparaciones++;
		if(arreglo.length>1) {
			int numElementosIzq=arreglo.length/2;
			int numElmentosDer=arreglo.length-numElementosIzq;
			
			int arregloIzquierdo[]=new int[numElementosIzq];
			int arregloDerecha[]=new int[numElmentosDer];
		
			for(i=0;i<numElementosIzq;i++) {
				arregloIzquierdo[i]=arreglo[i];
				pasadas++;
			}
			
			i=0;
			for(i=numElementosIzq;i<numElementosIzq+numElmentosDer;i++) {
				arregloDerecha[i-numElementosIzq]=arreglo[i];
				pasadas++;
			}
			
			
			
			arregloIzquierdo=ordenamientoMezclaDirecto(arregloIzquierdo);
			arregloDerecha=ordenamientoMezclaDirecto(arregloDerecha);
			i=j=k=0;
			
			while(arregloIzquierdo.length!=j && arregloDerecha.length!=k) {
				comparaciones++;
				if(arregloIzquierdo[j]<arregloDerecha[k]) {
					intercambios++;
					arreglo[i]=arregloIzquierdo[j];
					i++;
					j++;
				}else {
					intercambios++;
					arreglo[i]=arregloDerecha[k];
					i++;
					k++;
				}
				pasadas++;
			}
			
			while(arregloIzquierdo.length!=j) {
				intercambios++;
				arreglo[i]=arregloIzquierdo[j];
				i++;
				j++;
				pasadas++;
			}
		
			while(arregloDerecha.length!=k) {
				intercambios++;
				arreglo[i]=arregloDerecha[k];
				i++;
				k++;
				pasadas++;
			}
		}
		
		
	}
	
	static public void ordenamientoMezclaNatural(int [] numeros) {
		int izquierda =0;
		int izq =0;
		int derecha = numeros.length-1;//Sin el error de nullPointerExepcion
		int der = derecha;
		boolean ordenado = false;
		
		long ini = System.nanoTime();
		do {
			ordenado = true;
			izquierda = 0;
			while(izquierda<derecha) {
				izq =izquierda;
				while(izq < derecha && numeros[izq]<=numeros[izq+1]) {
					izq++;
					pasadas++;
				}
				der = izq +1;
				while(der==derecha-1 || der<derecha && numeros[der]<=numeros[der+1]) {
					der++;
					pasadas++;
				}
				comparaciones++;
				if(der<=derecha) {
					ordenamientoMezclaDirecto2(numeros);
					
					ordenado = false;
				}
				izquierda=izq;
				pasadas++;
			}
			pasadas++;
		}while(!ordenado);
		
		
	
	}
	
	
	static public void aplicarMezclaN(int[] vector) {
		tInicio = 0;
		tFin = 0;
		pasadas=0;
		intercambios=0;
		comparaciones=0;
		tInicio = System.nanoTime();
		ordenamientoMezclaNatural(vector);
		tFin = System.nanoTime();
		System.out.println("Tiempo de ejecucion: " + (tFin-tInicio));
		System.out.println("Numero de Intercambios = " + intercambios);
		System.out.println("Numeor de Comparaciones = " + comparaciones);
		System.out.println("Numero de Pasadas = " + pasadas);
	}

	
	
	
	
	static public void aplicarMezclaD(int[]vector) {
		tInicio = 0;
		tFin = 0;
		tInicio = System.nanoTime();
		ordenamientoMezclaDirecto(vector);
		tFin = System.nanoTime();
		System.out.println("Tiempo de ejecucion: " + (tFin-tInicio));
		System.out.println("Numero de Intercambios = " + intercambios);
		System.out.println("Numeor de Comparaciones = " + comparaciones);
		System.out.println("Numero de Pasadas = " + pasadas);
	}
	static public int[] aplicarIntercalacion(int[] v1,int[]v2) {
		tInicio = 0;
		tFin=0;
		
		tInicio = System.nanoTime();
		v1 = ordenamientoMezclaDirecto(v1);
		v2 = ordenamientoMezclaDirecto(v2);
		int []v = intercalacion(v1, v2);
		tFin = System.nanoTime();
		System.out.println("Tiempo de ejecucion: " + (tFin-tInicio));
		System.out.println("Numero de Intercambios = " + intercambios);
		System.out.println("Numeor de Comparaciones = " + comparaciones);
		System.out.println("Numero de Pasadas = " + pasadas);
		return v;
	}
}




public class PruebaEstres2 {

	public static void main(String[] args) {
		int opcion = 0;
		int ooo;
		MetodosDeOrdenamiento2 m = new MetodosDeOrdenamiento2();
		//Random aleatorio = new Random(System.currentTimeMillis());
		do {
			System.out.println("Digite 1 para usar un vector aleatorio de 1000 datos");
			System.out.println("Digite 2 para usar un vector aleatorio de 10000 datos");
			//System.out.println("Digite 3 para usar un vector aleatorio de 100000 datos"); Tampoco me lo permitio mi pc
			//System.out.println("Digite 1 para usar un vector aleatorio de 1000000 datos"); No me dejo :(
			ooo = Correcion.validacion(); 
		}while(ooo!=1 && ooo!=2 && ooo!=3);
		
		int numeros[] = {2};
		int numerosx[] = {2};
		
		 if(ooo==1) {
			 numeros = new int[1000];
			 numerosx = new int[1000];
			for (int i = 0; i < 1000; i++) {
				numeros[i]=(int)(Math.random()*1000);
				numerosx[i]=(int)(Math.random()*1000);
			}
		}else if(ooo==2) {
			numeros = new int[10000];
			numerosx = new int[10000];
			for (int i = 0; i < 10000; i++) {
				numeros[i]=(int)(Math.random()*1000);
				numerosx[i]=(int)(Math.random()*1000);
			}
		}else if(ooo==3) {
			numeros = new int[100000];
			numerosx = new int[100000];
			for (int i = 0; i < 100000; i++) {
				numeros[i]=(int)(Math.random()*1000);
				numerosx[i]=(int)(Math.random()*1000);
			}
		}
		 
		int n[];
		int n2[];
		do{
			n = numeros.clone();
			n2 = numerosx.clone();
			System.out.println("======================== MENU ========================");
			System.out.println("Digite 1 para usar el metodo de ordenacion Intercalacion");
			System.out.println("Digite 2 para usar el metodo de Ordenamiento Mezcla Directa");
			System.out.println("Digite 3 para usar el metodo de Ordenamiento Mezcla Natural ");
			System.out.println("Digite 4 para ***SALIR***");
			opcion = Correcion.validacion();
			
			switch(opcion) {
			case 1:
				System.out.println("====== MEtodo de Intercalacion =====");
				System.out.println("Vectores desordenados:");
				System.out.println(Arrays.toString(n));
				System.out.println(Arrays.toString(n2));
				System.out.println("=========================================================0");
				int v[]= m.aplicarIntercalacion(n, n2);
				System.out.println("Vector ordenado");
				System.out.println(Arrays.toString(v));
				break;
			case 2:
				System.out.println("==== Metodo de Mezcla Directa =====");
				System.out.println("Vector desordenado:");
				System.out.println(Arrays.toString(n));
				m.aplicarMezclaD(n);
				System.out.println("Vector Ordenado:");
				System.out.println(Arrays.toString(n));
				break;
			case 3:
				System.out.println("====MEtodo de Mezcla Natual======");
				System.out.println("Vector desordenado:");
				System.out.println(Arrays.toString(n));
				m.aplicarMezclaN(n);
				System.out.println("Vector Ordenado:");
				System.out.println(Arrays.toString(n));
				break;
			case 4: 
				System.out.println("Gracias por usar le programa");
			}
			
			
			
		}while(opcion!=4);
		

	}

}
