package ProgramacionIII.entregables.Programacion3EntregableTP2;

import java.util.ArrayList;

public class Tree {

	private Integer value;
	private Integer[] arreglo;
	private Tree left;
	private Tree right;
//--------------------------------   Tree(Integer value)   --------------------------------------
	//CONSTRUCTOR
/* Carga los valores ingresados ,individualmente, a un árbol binario de búsqueda */
	//Complejidad O(h).Siempre los va ingresando en nivel más alto del árbol.
	public Tree(Integer value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
//------------------------------   Tree(Integer[] arreglo)   --------------------------------------------
	// CONSTRUCTOR
/*Carga los valores dados de un array a un árbol binario de búsqueda.*/
	
	//Complejidad: O(n*h)  con h <= n, donde n es el tamaño del arreglo
	//(equivalente a la cantidad de nodos que integraran el árbol,
	//y h es la altura del árbol. En el peor caso, por cada elemento a insertar del
	//array debe colocarlo como último nodo en la rama de mayor longitud,
	//es decir h pasos hasta llegar al lugar. Este proceso lo repite n veces,
	//por cada elemento a agregar.

	public Tree(Integer[] arreglo) {
		this.left = null;
		this.right = null;
		for (int i = 0; i < arreglo.length; i++) {
			add(arreglo[i]);
		}
	}

//---------------------------------   add(Integer newValue)   -------------------------------------------------

	/*Inserta un elemento en el arbol de búsqueda binaria, colocando los elementos menores
	 a su izquierda y los mayores a la derecha. Recorre los nodos verificando si el valor
	 dado es menor o mayor al actual; según cual sea el lugar (como hijo) correspondiente,
	 si está ocupado repite el procedimiento desde este nodo (hijo), y sino lo inserta.*/
	
	//Complejidad: O(h) donde h es la altura del arbol (la longitud de la rama mas larga)
	//En el peor caso tiene que llegar al nodo de la rama más larga.
	
	public void add(Integer newValue) {
		if (this.value == null)
			this.value = newValue;
		else {
			if (this.value > newValue) {
				if (this.left == null)
					this.left = new Tree(newValue);
				else
					this.left.add(newValue);
			} else if (this.value < newValue) {
				if (this.right == null)
					this.right = new Tree(newValue);
				else
					this.right.add(newValue);
			}
		}
	}

	
//--------------------------------------   getRoot()   -------------------------------------------
	
	// Retorna la raíz del árbol ( el elemento que se encuentra en el nivel cero (0) )
	// Complejidad O(1)
	
	public Integer getRoot() {
		return this.value;
	}
	
	
	//---------------------------------   hasElem(Integer valor)   ---------------------------------	
	
	/*Permite buscar un elemento determinado por parámetro. Retorna si dicho elemento està o no en el árbol */
		
	//Complejidad: O(h) donde h es la altura del árbol (la cantidad de arcos), 
	// en el peor de los casos tiene que recorrer el árbol haste el final.
	
	public boolean hasElem(Integer valor) {

		if (this.isEmpty()) {
			return false;
		} else {
			if (this.value == valor) {
				return true;
			} else if (this.value > valor && this.left != null) {
				return this.left.hasElem(valor);
			} else if (this.value < valor && this.right != null) {
				return this.right.hasElem(valor);
			}
		}
		return false;

	}

	//----------------------------------------   printPreOrder ()   ------------------------------------------------------
	
/*Imprime los elementos en siguiente órden: primero el padre  y luego el/los hijos ( hijo-izquierdo hijo-derecho). */
	
	// Complejidad: O(n) donde n es la cantidad de nodos del arbol
	//En el peor y mejor caso tiene que recorrer todos los nodos para proyectarlos.
	
	public String printPreOrder() {
		String exit = "";

		if (this.isEmpty()) {
			exit = "null";
		} else {

			exit += " " + this.value;
			if (this.left != null)
				exit += this.left.printPreOrder();
			else
				exit += "-";
			if (this.right != null)
				exit += this.right.printPreOrder();
			else
				exit += "- ";

		}
		return exit;
	}

	//----------------------------------------   printPosOrder ()   ------------------------------------------------------
	
	/*Imprime los elementos en siguiente órden: primero el/los hijos ( hijo izquierdo hijo derecho )  y luego el padre. */
	
	// Complejidad: O(n) donde n es la cantidad de nodos del arbol
	//En el peor y mejor caso tiene que recorrer todos los nodos para proyectarlos.
	
	
	public String printPosOrder() {
		String exit = "";

		if (this.isEmpty()) {
			exit = "null";
		} else {
			if (this.left != null)
				exit += this.left.printPosOrder();
			else
				exit += "-";
			if (this.right != null)
				exit += this.right.printPosOrder();
			else
				exit += "-";
			exit += " " + this.value;

		}
		return exit;
	}
	
	//----------------------------------------   printInOrder ()   ------------------------------------------------------
	
/*Imprime los elementos en órden, de menor a mayor */
	
	// Complejidad: O(n) donde n es la cantidad de nodos del arbol
	//En el peor y mejor caso tiene que recorrer todos los nodos para proyectarlos.

	public String printInOrder() {
		String exit = "";

		if (this.isEmpty()) {
			exit = "null";
		} else {
			if (this.left != null)
				exit += this.left.printInOrder();
			else
				exit += "-";
			exit += " " + this.value;
			if (this.right != null)
				exit += this.right.printInOrder();
			else
				exit += "-";
		}
		return exit;
	}

//---------------------------------  isEmpty()   ---------------------------------	
	
		/*Retorna si el árbol posee al menos un nodo (la raiz) o está vacío */
		
		//Complejidad: O(1)
	
	public boolean isEmpty() {
		return this.value == null;
	}
	
//----------------------------------   getHeight()   ------------------------------------------
	
	/*Retorna la altura del arbol, es decir, la cantidad de arcos que tiene la rama más larga.*/
	
	// Complejidad: O(n) donde n es la cantidad de nodos del arbol
	//En el peor y mejor caso tiene que recorrer todos los nodos para saber cuál es la altura.
	
	public int getHeight() {
		int height = 0;
		int maxHeightLeft = -1;
		int maxHeightRight = -1;
		if (this.isEmpty()) {
			return height;
		} else {
			if (this.left != null) {
				height = this.left.getHeight();
				if (height > maxHeightLeft) {
					maxHeightLeft = height;
				}
			}
			if (this.right != null) {
				height = this.right.getHeight();
				if (height > maxHeightRight) {
					maxHeightRight = height;
				}
			}

		}
		if (maxHeightLeft > maxHeightRight) {
			return maxHeightLeft + 1;
		} else
			return maxHeightRight + 1;
	}
	
//---------------------------------------   getMaxElem()   --------------------------------------------------------
	
	/* Retorna el elemento de mayor valor que hay en el árbol */
	
	//Complejidad: O(h) donde h es la altura del arbol (la longitud de la rama mas larga)

	public Integer getMaxElem() {
		Integer maxValue = null;
		if (isEmpty()) {
			return maxValue;
		} else {
			if (this.right != null) {
				maxValue = this.right.getMaxElem();
			} else
				maxValue = this.value;
		}
		return maxValue;
	}

	//-----------------------------------------   getLongestBranch()   ---------------------------------------------------
	
	/*Devuelve una lista con los elementos de la rama mas larga.*/
	
	//Complejidad: O(n) donde n es la cantidad de nodos del árbol
	//Debe recorrer todo el árbol para saber cuál es la rama mas larga.
	
	public ArrayList<Integer> getLongestBranch() {
		ArrayList<Integer> longestBranch = new ArrayList<Integer>();
		ArrayList<Integer> branchLeft = new ArrayList<Integer>();
		ArrayList<Integer> branchRight = new ArrayList<Integer>();
		longestBranch.add(this.value);
		if (this.isEmpty()) {
			return longestBranch;
		} else {
			if (this.left != null) {
				branchLeft = this.left.getLongestBranch();
			}
			if (this.right != null) {
				branchRight = this.right.getLongestBranch();

			}
			if (branchLeft.size() >= branchRight.size())
				longestBranch.addAll(branchLeft);
			else
				longestBranch.addAll(branchRight);
		}

		return longestBranch;

	}
	
//--------------------------------------   getFrontera()   ----------------------------------------------------------
	
	/*Retorna una lista con todos los valores de los nodo hoja */

	//Complejidad: O(n) donde n es la cantidad de nodos del árbol
	//En el peor de los casos y mejor de los casos, debe retornar todas las hojas; debe recorrer todo el árbol.
	
	public ArrayList<Integer> getFrontera() {
		ArrayList<Integer> borderList = new ArrayList<Integer>();
		ArrayList<Integer> borderListLeft = new ArrayList<Integer>();
		ArrayList<Integer> borderListRight = new ArrayList<Integer>();
		if (this.isEmpty()) {
			return borderList;
		} else {
			if (this.left == null && this.right == null)
				borderList.add(this.value);
			if (this.left != null)
				borderListLeft = this.left.getFrontera();
			if (this.right != null)
				borderListRight = this.right.getFrontera();
		}
		borderList.addAll(borderListLeft);
		borderList.addAll(borderListRight);
		return borderList;
	}

	//--------------------------------------------------   getElementAtLevel(int level)   --------------------------------
	
	/* Retorna los valores de todos los nodos que pertenecen a un nivel determinado que se ingresa por parámetro*/
	
	//Complejidad: O(n) donde n es la cantidad de nodos
	//En el peor caso debe ir al último nivel del árbol, 
	//deberá imprimir todas las hojas, lo que implica recorrerlo completamente.
	
	public ArrayList<Integer> getElementAtLevel(int level) {

		ArrayList<Integer> levelList = new ArrayList<Integer>();
		ArrayList<Integer> levelListLeft = new ArrayList<Integer>();
		ArrayList<Integer> levelListRight = new ArrayList<Integer>();

		if (this.isEmpty()) {
			return levelList;
		} else {
			if (level == 0)
				levelList.add(this.value);
			if (this.left != null)
				levelListLeft = this.left.getElementAtLevel(level - 1);
			if (this.right != null) {
				levelListRight = this.right.getElementAtLevel(level - 1);
			}
			levelList.addAll(levelListLeft);
			levelList.addAll(levelListRight);
			return levelList;
		}
	}

	// Retorna si un nodo es Hoja o no
	// Complejidad O (1)
	public boolean isSheet() {
		return (this.left == null && this.right == null);
	}

	//--------------------------------------- delete ( Integer value )   ----------------------------------

	/* Retorna si pudo eliminar un elemento del árbol o no: recorre los nodos del árbol,
	  por izquierda o derecha dependiendo si el valor buscado es menor o mayor al del nodo
	  actual. Si coinciden los valores, se procede a eliminar según cuál sea el caso:
	  si el nodo es hoja, si tiene un hijo, o si el nodo tiene 2 hijos, y a su vez considera
	  el caso de ser la raíz*/
	
	//Complejidad:  O(h) donde h es la altura del árbol (la rama más larga)
	//En el peor caso tiene que ir al último nodo de la rama más larga.
	public boolean delete(Integer value) {
		boolean delete = false;
		Integer tmp = null;
		Integer tmp2 = null;
		if (!this.isEmpty()) {
			if (this.left != null && this.value > value) {// RECORRE EL ARBOL HIJO IZQUIERDO
				if (this.left.value == value) {
					if (this.left.isSheet()) {// borra si es hoja
						this.left = null;
					}

					else if (this.left.right != null && this.left.left == null) {// borra el elemento si tiene un hijo a derecha
						this.left = this.left.right;
					} else if (this.left.right == null && this.left.left != null) {// borra el elemento si tiene un hijo a izquierda
						this.left = this.left.left;
					} else if (this.left.right != null && this.left.left != null) {// borra el elemento si tiene 2 hijos 
						tmp = this.left.left.search_Rightmost_Node_In_Left_SubTree();
						this.left.delete(tmp);
						this.left.value = tmp;
					}
					delete = true;
				} else
					delete = this.left.delete(value);

			} else if (this.right != null && this.value < value) {// RECORRE EL ARBOL HIJO DERECHO
				if (this.right.value == value) {
					if (this.right.isSheet()) {// borra si es hoja
						this.right = null;
					} else if (this.right.right != null && this.right.left == null) {// borra el elemento si tiene un hijo a derecha
						this.right = this.right.right;
					} else if (this.right.right == null && this.right.left != null) {// borra el elemento si tiene un hijo a izquierda
						this.right = this.right.left;
					} else if (this.right.right != null && this.right.left != null) {// borra el elemento si tiene 2 hijos 
						tmp = this.right.left.search_Rightmost_Node_In_Left_SubTree();
						this.right.delete(tmp);
						this.right.value = tmp;
					}
					delete = true;
				} else
					delete = this.right.delete(value);
			} else if (this.value == value) {// BORRA LA RAIZ DEL ARBOL
				if (this.isSheet()) {
					this.value = null;
				} else {
					if (this.left != null) {// borra el elemento raíz si no tiene hijos, o tiene hijo a izquierda
						tmp2 = this.left.search_Rightmost_Node_In_Left_SubTree();
						this.delete(tmp2);
						this.value = tmp2;
					} else if (this.left == null) {// borra el elemento raíz si tiene hijo a derecha
						tmp2 = this.right.left.search_Rightmost_Node_In_Left_SubTree();
						this.delete(tmp2);
						this.value = tmp2;
					}
				}
			}
			delete = true;
		}
		return delete;
	}
	

	//---------------------------------   search_Rightmost_Node_In_Left_SubTree()   -------------------------------------------
	
	/* busca el nodo más a la derecha del sub árbol izquierdo */
	
	//Complegidad O(h) en el peor de los casos tiene que ir hasta el último nodo de la rama más larga
	
	public Integer search_Rightmost_Node_In_Left_SubTree() {
		Integer value = null;
		if (this.right == null) {
			value = this.value;
		}

		else if (this.right != null) {
			value = this.right.search_Rightmost_Node_In_Left_SubTree();
		}
		return value;
	}

}
