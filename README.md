# Programacion3EntregableTP2
Código del ejercicio entregable de la materia programación 3 de TUDAI



Ejercicio Entregable - TP2
Implementar un árbol binario de búsqueda que provea, como mínimo, los métodos detallados en el Ejercicio 7 del práctico 2. Por simplicidad, se puede establecer que el árbol almacena números enteros

En cada método implementado incluir la complejidad temporal de dicho método. Una buena forma de hacerlo sería agregando un comentario previo a la declaración del método. Por ejemplo:



A la interfaz propuesta se le deben agregar dos funcionalidades adicionales:

Extender la salida obtenida por el recorrido pre-orden para incorporar los separadores ("-") que nos permiten entender la estructura correcta del árbol, sin ambigüedades (tema visto en la práctica).
Proveer al árbol de un método constructor que reciba un arreglo de números a insertar en el orden enviado, es decir, por ejemplo: ejecutar new Tree({10, 5, 12, 2, 1, 3, 8, 6, 11, 25, 22, 30}); generará el siguiente árbol.




Utilizando la implementación del árbol, además, se debe resolver el siguiente problema:

Dado un árbol retornar una lista donde cada elemento es el valor de la diferencia entre hojas contiguas del árbol, tomando las hojas de derecha a izquierda. Por ejemplo, para el árbol del caso anterior la lista resultante sería: [8, 11, 5, 3, 2]
Se debe entregar un proyecto/carpeta que contenga:




Todas las clases necesarias para compilar el árbol binario de búsqueda.

Una función o main donde se construya el árbol de ejemplo propuesto en la sección anterior y se realicen las siguientes operaciones:

// Se construye el árbol de ejemplo utilizando el constructor previamente mencionado
int[] valoresIniciales = new int[] {10, 5, 12, 2, 1, 3, 8, 6, 11, 25, 22, 30}
Tree miArbol = new Tree(valoresIniciales)

miArbol.printPreOrder()
System.out.println( miArbol.getMaxElem() );
System.out.println( miArbol.getHeight() );
System.out.println( miArbol.getLongestBranch() );
System.out.println( miArbol.getElementAtLevel(2) );
System.out.println( miArbol.getFrontera() );

miArbol.add(23)
miArbol.add(4)
miArbol.delete(11)
miArbol.delete(25)

miArbol.printPreOrder()
System.out.println( miArbol.getMaxElem() );
System.out.println( miArbol.getHeight() );
System.out.println( miArbol.getLongestBranch() );
System.out.println( miArbol.getElementAtLevel(2) );
System.out.println( miArbol.getFrontera() );

miArbol.add(65)
miArbol.delete(8)
miArbol.delete(10)
miArbol.add(55)

miArbol.printPreOrder()
System.out.println( miArbol.getMaxElem() );
System.out.println( miArbol.getHeight() );
System.out.println( miArbol.getLongestBranch() );
System.out.println( miArbol.getElementAtLevel(2) );
System.out.println( miArbol.getFrontera() );

