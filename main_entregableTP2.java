package ProgramacionIII.entregables.Programacion3EntregableTP2;

import java.util.ArrayList;

public class main_entregableTP2 {
	

	
	public static void main(String[] args) {
		

	
//		// Se construye el árbol de ejemplo utilizando el constructor previamente mencionado en el enunciado del ejercicio
		
		Integer[] valoresIniciales = new Integer[] {10, 5, 12, 2, 1, 3, 8, 6, 11, 25, 22, 30};
		Tree miArbol = new Tree(valoresIniciales);

		System.out.println(miArbol.printPreOrder());
		System.out.println(miArbol.printInOrder());
		System.out.println( miArbol.getMaxElem() );
		System.out.println( miArbol.getHeight() );
		System.out.println( miArbol.getLongestBranch() );
		System.out.println( miArbol.getElementAtLevel(2) );
		System.out.println( miArbol.getFrontera() );

		miArbol.add(23);
		miArbol.add(4);
		miArbol.delete(11);
		miArbol.delete(25);

		System.out.println(miArbol.printPreOrder());
		System.out.println(miArbol.printInOrder());
		System.out.println( miArbol.getMaxElem() );
		System.out.println( miArbol.getHeight() );
		System.out.println( miArbol.getLongestBranch() );
		System.out.println( miArbol.getElementAtLevel(2) );
		System.out.println( miArbol.getFrontera() );

		miArbol.add(65);
		miArbol.delete(8);
		miArbol.delete(10);
		miArbol.add(55);

		System.out.println(miArbol.printPreOrder());
		System.out.println(miArbol.printInOrder());
		System.out.println( miArbol.getMaxElem() );
		System.out.println( miArbol.getHeight() );
		System.out.println( miArbol.getLongestBranch() );
		System.out.println( miArbol.getElementAtLevel(2) );
		System.out.println( miArbol.getFrontera() );
		System.out.print("Diferencia entre hojas adyacentes de derecha a izquierda: ");
		System.out.println(miArbol.differenceBetweenAdjacentSheets());
	}
				

	}


