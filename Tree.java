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
//Complejidad O(h), siendo h la altura del àrbol. En el peor de los casos va a ingresar el valor en el nivel más alto del árbol.
	
	public Tree(Integer value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
	
//------------------------------   Tree(Integer[] arreglo)   --------------------------------------------
	// CONSTRUCTOR
/*Carga los valores dados de un array a un árbol binario de búsqueda.*/
	
	//Complejidad: O(n*h)  siendo n el tamaño del arreglo y h la altura del árbol
	// Para cada elemento del arreglo, en el peor de los casos tiene que recorrer hasta la altura máxima del arbol para insertarlo

	public Tree(Integer[] arreglo) {
		this.left = null;
		this.right = null;
		for (int i = 0; i < arreglo.length; i++) {
			add(arreglo[i]);
		}
	}

//---------------------------------   add(Integer newValue)   -------------------------------------------------

	/*Inserta un nuevo árbol en el árbol de búsqueda binario.*/
	
	//Complejidad: O(h) donde h es la altura del árbol de búsqueda binario (la longitud de la rama mas larga)
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
	
	// Retorna la raíz del árbol en el que se està posicionado.
	// Complejidad O(1)
	
	public Integer getRoot() {
		return this.value;
	}
	
	
	//---------------------------------   hasElem(Integer valor)   ---------------------------------	
	
	/*Permite buscar un elemento determinado por parámetro. Retorna si dicho elemento está  o no en el árbol */
		
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
	
/*Imprime los elementos en siguiente Órden: primero el padre  y luego el/los hijos ( hijo-izquierdo hijo-derecho). */
	
	// Complejidad: O(n) donde n es la cantidad de árboles.
		//Tiene que recorrer todo el árbol para imprimirlo.
	
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
	
	/*Imprime los elementos en siguiente Órden: primero el/los hijos ( hijo izquierdo hijo derecho )  y luego el padre. */
	
	// Complejidad: O(n) donde n es la cantidad de árboles.
	//Tiene que recorrer todo el árbol para imprimirlo.
	
	
	
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
	
/*Imprime los elementos en Órden, de menor a mayor , (hijo izquierdo, raíz, hijo derecho) .*/
	
	// Complejidad: O(n) donde n es la cantidad de árboles.
		//Tiene que recorrer todo el árbol para imprimirlo.

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
	
		/*Retorna false si el árbol posee al menos un nodo (la raiz), o true si el árbol está vacío */
		
		//Complejidad: O(1)
	
	public boolean isEmpty() {
		return this.value == null;
	}
	
//----------------------------------   getHeight()   ------------------------------------------
	
	/*Retorna la altura del arbol, es decir, la cantidad de arcos que tiene la rama más larga.*/
	
	// Complejidad: O(n) donde n es la cantidad de  arboles.
	//En el peor de los casos tiene que recorrer todo el árbol para saber cuál es la altura.
	
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
	// En el peor de los casos debe recorrer la rama más larga.

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
	
	//Complejidad: O(n) donde n es la cantidad de  árboles que contiene el ABB.
	//Tiene que recorrer todo el ABB.
	
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
	
	/*Retorna una lista con todos los valores de los árboles que no tienen hijos ( son hoja )*/

	//Complejidad: O(n) donde n es la cantidad de árboles.
	// Tiene que recorrer todo el ABB.
	
	public ArrayList<Integer> getFrontera() {
		ArrayList<Integer> borderList = new ArrayList<Integer>();
	
		if (this.isEmpty()) {
			return borderList;
		} else {
			if (this.left == null && this.right == null)
				borderList.add(this.value);
			if (this.left != null)
				borderList.addAll(this.left.getFrontera());
			if (this.right != null)
				borderList.addAll(this.right.getFrontera());
		}		
		return borderList;
	}

	//--------------------------------------------------   getElementAtLevel(int level)   --------------------------------
	
	/* Retorna los valores de todos los nodos que pertenecen a un nivel determinado que se ingresa por parámetro*/
	
	//Complejidad: O(n) donde n es la cantidad de árboles que tiene el ABB.
	//En el peor caso debe recorrer todo el ABB. 	
	
	public ArrayList<Integer> getElementAtLevel(int level) {
		ArrayList<Integer> levelList = new ArrayList<Integer>();	

		if (this.isEmpty()) {
			return levelList;
		} else {
			if (level == 0)
				levelList.add(this.value);
			if (this.left != null)
				levelList.addAll(this.left.getElementAtLevel(level - 1));
			if (this.right != null) {
				levelList.addAll(this.right.getElementAtLevel(level - 1));
			}			
			return levelList;
		}
	}
//-------------------------------------------------------  isSheet()   -----------------------------------------------
	
  	// Retorna si un nodo es hoja o no, retorna falso si tiene algun hijo y true si no tiene hijos
	// Complejidad O (1)
	
	public boolean isSheet() {
		return (this.left == null && this.right == null);
	}

	//--------------------------------------- delete ( Integer value )   ----------------------------------

	/* Retorna si pudo eliminar un elemento del árbol o no: recorre el ABB,
	  por izquierda o derecha dependiendo si el valor buscado es menor o mayor a la raiz del árbol en que está posicionado.
	  Si coinciden los valores, se procede a eliminar según cuál sea el caso:
	  si el nodo es hoja, si tiene un hijo, o si el nodo tiene 2 hijos, y a su vez considera
	  el caso de ser la raíz*/
	
	//Complejidad:  O(h) donde h es la altura del árbol (la rama más larga)
	//En el peor caso tiene que ir al último arbol de la rama más larga.
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
					if (this.left != null) {// borra el elemento raíz si no tiene hijos, o tiene hijo a izquierda,
											//esto es porque utilizo el método buscar el nodo más a la derecha del sub-árbol izquierdo.
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
	
	/* busca el árbol más a la derecha del sub árbol izquierdo */
	
	//Complegidad O(h) en el peor de los casos tiene que ir hasta el Último nodo de la rama más larga
	
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
	
	//--------------------------------------------------- differenceBetweenAdjacentSheets()   -----------------------------
	
	/*Retorna una lista con la diferencia entre los valores de dos nodos hoja adyacentes */

	//Complejidad: O(n) donde n es la cantidad de árboles
	// Tiene que recorrer todo el ABB para buscar sus hojas
	
	public ArrayList<Integer> differenceBetweenAdjacentSheets(){
		
		ArrayList<Integer> array = new ArrayList<Integer>();
				
		return this.differenceBetweenAdjacentSheets(array);
	}
	//--------------------------------------------------- differenceBetweenAdjacentSheets (ArrayList<Integer> array)   -----------------------------
	
	/*Retorna una lista con la diferencia entre los valores de dos nodos hoja adyacentes */

	//Complejidad: O(n) donde n es la cantidad de árboles
	// Tiene que recorrer todo el ABB para buscar sus hojas
	
	private ArrayList<Integer> differenceBetweenAdjacentSheets(ArrayList<Integer> array) {// paso por parámetros un arreglo de hojas
		ArrayList<Integer> diferenceList = new ArrayList<Integer>();
		ArrayList<Integer> arraySheet = array;
		
		if (this.isEmpty()) {
			return diferenceList;
		} else {
			if (this.isSheet()) {
				arraySheet.add(0, this.value);
				if (arraySheet.size() >= 2) {
					diferenceList.add(arraySheet.get(1) - arraySheet.get(0));
				}
			}

			if (this.right != null)
				diferenceList.addAll(this.right.differenceBetweenAdjacentSheets(arraySheet));

			if (this.left != null)
				diferenceList.addAll(this.left.differenceBetweenAdjacentSheets(arraySheet));
		}
		
		return diferenceList;
	}

}
