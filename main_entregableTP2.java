package ProgramacionIII.entregables.Programacion3EntregableTP2;

import java.sql.Array;

public class main_entregableTP2 {
	
//	Ejercicio 1.
//	Implemente un algoritmo recursivo que determine si un arreglo de tamaño N está ordenado.
	
	
//	1. ¿Qué complejidad O tiene? (La complejidad en el peor caso) O(n)
	
	
//	2. ¿Trae algún problema hacerlo recursivo? ¿Cuál? 
	//Respuesta: es más complicado, es mejor hacerlo iterativo
	
	
//	3. ¿Qué cambiaría si la estructura fuera una lista en lugar de un arreglo?
		// No cambiaria nada seria el mismo caso

	public static double factorial(int n) {
		if (n>1)
		return (n * factorial (n-1));
		else
		return 1;
		}
	
private static Integer[] arreglo = {15,5,2,1,3,14,20,13,22,17,12,30,34,33};//2 hijos
private static Integer[] arreglo2 = {15,5,2,1,3,14,13,12};	//hijos a izquierda
private static Integer[] arreglo3 = {15,20,22,17,30,34,33};// hijos a derecha
	
	private static boolean estaOrdenado(Integer[] arr, int posicion) {
		boolean ordenado = true;
		if (posicion < arr.length-1) {
			if (arr[posicion]<arr[posicion+1])
				ordenado = estaOrdenado(arr, posicion+1);
			else ordenado = false;
				
		}
		return ordenado;
			
		}
		
	public static boolean estaOrdenado(Integer[] arr) {
		return estaOrdenado(arr, 0);
		
	}
//-------------------------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------------------------
	
//	Ejercicio 2.
//	Implemente un algoritmo recursivo para buscar un elemento en una lista simple.
//	Implemente, además, un algoritmo recursivo para buscar un elemento en un arreglo ordenado
//	ascendentemente [1 2 3 …].
//	1. ¿Qué complejidad O tienen estos algoritmos?
//	2. ¿En qué afecta la estructura a estos algoritmos?
//	3. ¿Cambia algo que la estructura esté ordenada?
	
//-------------------------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------------------------
	
	public static void main(String[] args) {
		
//	//	System.out.println(estaOrdenado(arreglo));   
		Tree arbol = new Tree(arreglo);		
//		
		System.out.println(arbol.printPreOrder());
		System.out.println(arbol.printPosOrder());
		System.out.println(arbol.printInOrder());
//		System.out.println(arbol.getRoot());
//		System.out.println(arbol.getHeight());
//		System.out.println(arbol.getMaxElem());
//		System.out.println(arbol.getLongestBranch());
//		System.out.println(arbol.getFrontera());
//		System.out.println(arbol.getElemAtLevel(3));
//		System.out.println(arbol.delete(1));
//		System.out.println(arbol.delete(13));
//		System.out.println(arbol.printInOrder());
		System.out.println(arbol.delete(15));
		System.out.println(arbol.printPreOrder());
		
		
//-------------------------------------------------------------------------------------------------------------------------
	
//		// Se construye el árbol de ejemplo utilizando el constructor previamente mencionado
//		Integer[] valoresIniciales = new Integer[] {10, 5, 12, 2, 1, 3, 8, 6, 11, 25, 22, 30};
//		Tree miArbol = new Tree(valoresIniciales);
//
//		System.out.println(miArbol.printPreOrder());
//		System.out.println( miArbol.getMaxElem() );
//		System.out.println( miArbol.getHeight() );
//		System.out.println( miArbol.getLongestBranch() );
//		System.out.println( miArbol.getElementAtLevel(2) );
//		System.out.println( miArbol.getFrontera() );
//
//		miArbol.add(23);
//		miArbol.add(4);
//		miArbol.delete(11);
//		miArbol.delete(25);
//
//		System.out.println(miArbol.printPreOrder());
//		System.out.println( miArbol.getMaxElem() );
//		System.out.println( miArbol.getHeight() );
//		System.out.println( miArbol.getLongestBranch() );
//		System.out.println( miArbol.getElementAtLevel(2) );
//		System.out.println( miArbol.getFrontera() );
//
//		miArbol.add(65);
//		miArbol.delete(8);
//		miArbol.delete(10);
//		miArbol.add(55);
//
//		miArbol.printPreOrder();
//		System.out.println( miArbol.getMaxElem() );
//		System.out.println( miArbol.getHeight() );
//		System.out.println( miArbol.getLongestBranch() );
//		System.out.println( miArbol.getElementAtLevel(2) );
//		System.out.println( miArbol.getFrontera() );
	}
				

	}


