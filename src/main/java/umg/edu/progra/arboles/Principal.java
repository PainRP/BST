package umg.edu.progra.arboles;

/**
 * Clase principal que demuestra el uso del Arbol Binario de Busqueda (BST)
 * implementado manualmente, sin usar librerias como java.util.
 *
 * Ejecucion sugerida:
 *   1. mvn compile
 *   2. mvn exec:java -Dexec.mainClass="umg.edu.progra.arboles.Principal"
 *
 * @author Walter Cordova
 */
public class Principal {

    public static void main(String[] args) {

        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();

        /*
         * Insertamos estos valores para formar el siguiente BST:
         *
         *               50
         *              /  \
         *            30    70
         *           /  \   / \
         *          20  40 60  80
         *         /
         *        10
         */
        int[] valores = { 50, 30, 70, 20, 40, 60, 80, 10 };
        for (int v : valores) {
            arbol.insertar(v);
        }

        System.out.println("===== Arbol Binario de Busqueda =====");
        System.out.println("Tamanio (campo): " + arbol.tamanio());
        System.out.println("Tamanio (recursivo): " + arbol.contarNodos());
        System.out.println("Altura:  " + arbol.altura());
        System.out.println("Minimo:  " + arbol.minimo());
        System.out.println("Maximo:  " + arbol.maximo());
        System.out.println("Hojas:   " + arbol.contarHojas());


        System.out.println("\n--- Representacion visual (rotada 90 grados) ---");
        arbol.imprimirArbol();

        System.out.println("\n--- Recorridos ---");
        System.out.print("InOrden    (ascendente): ");
        arbol.inOrden();

        System.out.print("PreOrden   (raiz primero): ");
        arbol.preOrden();

        System.out.print("PostOrden  (raiz al final): ");
        arbol.postOrden();

        System.out.print("Por niveles (BFS):         ");
        arbol.recorridoPorNiveles();

        System.out.println("\n--- Busquedas ---");
        System.out.println("Contiene 40? " + arbol.contiene(40));
        System.out.println("Contiene 99? " + arbol.contiene(99));

        System.out.println("\n--- Eliminacion ---");
        System.out.println("Eliminando 20 (nodo con 1 hijo)...");
        arbol.eliminar(20);
        System.out.print("InOrden tras eliminar 20: ");
        arbol.inOrden();

        System.out.println("Eliminando 30 (nodo con 2 hijos)...");
        arbol.eliminar(30);
        System.out.print("InOrden tras eliminar 30: ");
        arbol.inOrden();

        System.out.println("Eliminando 50 (raiz)...");
        arbol.eliminar(50);
        System.out.print("InOrden tras eliminar la raiz: ");
        arbol.inOrden();

        System.out.println("\n--- Estado final ---");
        arbol.imprimirArbol();
        System.out.println("Tamanio final (campo): " + arbol.tamanio());
        System.out.println("Tamanio final (recursivo): " + arbol.contarNodos());
        System.out.println("Altura final:  " + arbol.altura());

        System.out.println("\n=== Pruebas de Tarea ===");

        // Problema 2: esBalanceado
        System.out.println("\n--- Problema 2: ¿Esta balanceado? ---");
        System.out.println("Arbol actual esta balanceado? " + arbol.esBalanceado());

        System.out.println("Creando arbol desbalanceado (insertando 1, 2, 3, 4, 5)...");
        ArbolBinarioBusqueda arbolDesbalanceado = new ArbolBinarioBusqueda();
        for (int i = 1; i <= 5; i++) {
            arbolDesbalanceado.insertar(i);
        }
        System.out.println("Arbol desbalanceado esta balanceado? " + arbolDesbalanceado.esBalanceado());

        // Problema 3: esBSTValido
        System.out.println("\n--- Problema 3: Validar que sea un BST ---");
        System.out.println("Arbol original (actual) es BST valido? " + arbol.esBSTValido());

        System.out.println("Creando un arbol roto manualmente...");
        ArbolBinarioBusqueda arbolRoto = new ArbolBinarioBusqueda();
        arbolRoto.insertar(50);
        arbolRoto.insertar(30);
        arbolRoto.insertar(70);
        // Romper la propiedad de BST: colocar un 100 como hijo derecho del 30
        arbolRoto.getRaiz().izquierdo.derecho = new Nodo(100);
        System.out.println("Arbol roto es BST valido? " + arbolRoto.esBSTValido());

        // Problema 4: LCA (Ancestro Comun Mas Bajo)
        System.out.println("\n--- Problema 4: Ancestro Comun Mas Bajo (LCA) ---");
        ArbolBinarioBusqueda arbolLCA = new ArbolBinarioBusqueda();
        int[] valoresLCA = { 50, 30, 70, 20, 40, 60, 80, 10 };
        for (int v : valoresLCA) {
            arbolLCA.insertar(v);
        }
        System.out.println("LCA(10, 40) = " + arbolLCA.ancestroComunMasBajo(10, 40) + " (Esperado: 30)");
        System.out.println("LCA(10, 80) = " + arbolLCA.ancestroComunMasBajo(10, 80) + " (Esperado: 50)");
        System.out.println("LCA(60, 80) = " + arbolLCA.ancestroComunMasBajo(60, 80) + " (Esperado: 70)");
        try {
            System.out.println("LCA(10, 99) = " + arbolLCA.ancestroComunMasBajo(10, 99));
        } catch (IllegalArgumentException e) {
            System.out.println("LCA(10, 99) lanzo excepcion correctamente: " + e.getMessage());
        }

        // Problema 5: invertir
        System.out.println("\n--- Problema 5: Espejo del arbol (Inversion) ---");
        System.out.println("Arbol original antes de invertir:");
        arbolLCA.imprimirArbol();
        System.out.print("InOrden antes: ");
        arbolLCA.inOrden();

        System.out.println("Invirtiendo el arbol...");
        arbolLCA.invertir();

        System.out.println("Arbol despues de invertir:");
        arbolLCA.imprimirArbol();
        System.out.print("InOrden despues (deberia estar invertido): ");
        arbolLCA.inOrden();

        System.out.println("\nRe-invirtiendo para restaurar el BST...");
        arbolLCA.invertir();

        System.out.println("\n=== Ejercicios Extra ===");

        // E1: k-esimo menor
        System.out.println("\n--- E1: k-esimo menor ---");
        System.out.println("1er menor: " + arbolLCA.kEsimoMenor(1) + " (Esperado: 10)");
        System.out.println("3er menor: " + arbolLCA.kEsimoMenor(3) + " (Esperado: 30)");
        System.out.println("8vo menor: " + arbolLCA.kEsimoMenor(8) + " (Esperado: 80)");

        // E2: Imprimir rango ordenado
        System.out.println("\n--- E2: Imprimir rango ordenado ---");
        System.out.print("Rango [25, 65]: ");
        arbolLCA.imprimirRangoOrdenado(25, 65); // Esperado: 30 40 50 60
        System.out.print("Rango [10, 80]: ");
        arbolLCA.imprimirRangoOrdenado(10, 80); // Esperado: 10 20 30 40 50 60 70 80

        // E3: Diametro
        System.out.println("\n--- E3: Diametro del arbol ---");
        System.out.println("Diametro del arbol original: " + arbolLCA.diametro() + " (Esperado: 5 aristas)");

        // E4: Construir BST desde args
        if (args.length > 0) {
            System.out.println("\n--- E4: Construyendo BST desde argumentos de consola ---");
            ArbolBinarioBusqueda arbolArgs = new ArbolBinarioBusqueda();
            for (String arg : args) {
                try {
                    int v = Integer.parseInt(arg);
                    arbolArgs.insertar(v);
                } catch (NumberFormatException e) {
                    System.out.println("Argumento ignorado (no es entero): " + arg);
                }
            }
            System.out.println("Arbol construido desde consola:");
            arbolArgs.imprimirArbol();
            System.out.print("Recorrido InOrden: ");
            arbolArgs.inOrden();
            System.out.println("Esta balanceado? " + arbolArgs.esBalanceado());
            System.out.println("Es BST valido? " + arbolArgs.esBSTValido());
        }






        /*
         * Ejercicios
         *
         *  1. Implementar un metodo que devuelva la cantidad TOTAL de nodos
         *     usando recursividad (sin usar el campo 'tamanio').
         *  2. Implementar un metodo 'esBalanceado()' que indique si el arbol
         *     esta balanceado (diferencia de alturas <= 1 en cada nodo).
         *  3. Implementar 'esBSTValido()' que verifique que el arbol cumple
         *     la propiedad de BST recorriendo los nodos.
         *  4. Implementar un metodo para encontrar el ancestro comun mas
         *     bajo (LCA) entre dos valores.
         *  5. Implementar la inversion del arbol (espejo).
         */
    }
}
