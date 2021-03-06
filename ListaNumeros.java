
/**
 * La clase representa a una lista de 
 * n�meros enteros
 * 
 * @author - Ander Gaona
 * 
 */
import java.util.Arrays;

public class ListaNumeros 
{
    private int[] lista;
    private int pos;

    /**
     * Constructor de la clase ListaNumeros 
     * Crea e inicializa adecuadamente los
     * atributos
     * 
     * @param n el tama�o m�ximo de la lista
     */
    public ListaNumeros(int n) {
        lista = new int[n];
        pos = 0;
    }

    /**
     * A�ade un valor siempre al principio de la lista
     * 
     * @param numero el valor que se a�ade. No se hace nada si la lista est�
     *               completa
     * @return true si se ha podido a�adir, false en otro caso
     */
    public boolean addElemento(int numero) {
        if (estaCompleta()){
            return false;
        }
        else{
            for (int i = pos; i >= 0; i--){
                lista[i + 1] = lista[i];

            }
            lista[0] = numero;
            pos++;
            return true;
        }
    }

    /**
     * devuelve true si la lista est� completa, false en otro caso
     * Hacer sin if
     */
    public boolean estaCompleta() {
        return pos == lista.length;
    }

    /**
     * devuelve true si la lista est� vac�a, false en otro caso. 
     * Hacer sin if
     */
    public boolean estaVacia() {
        return pos == 0;
    }

    /**
     * devuelve el n� de elementos realmente guardados en la lista
     */
    public int getTotalNumeros() {
        return pos;

    }

    /**
     * Vac�a la lista
     */
    public void vaciarLista() {
        pos = 0;
    }

    /**
     * Representaci�n textual de la lista de la forma indicada 
     * (leer enunciado)
     * 
     * Si la lista est� vac�a devuelve ""
     */
    public String toString() {
        String str = "";
        for (int i = 0; i < pos; i++){
            str += String.format("%8d", lista[i]);
        }
        str += "\n";
        for (int i = 0; i < pos; i++){
            str += String.format("%8d", i);
        }
        return str;
    }

    /**
     * Mostrar en pantalla la lista
     */
    public void escribirLista() {
        System.out.println(this.toString());
    }

    /**
     * B�squeda lineal de numero en la lista
     * @param numero el n� a buscar
     * @return un array con las posiciones en las que se ha encontrado
     *  
     */
    public int[] buscarPosicionesDe(int numero) {
        int numeros = 0;
        for (int i = 0; i < pos; i++){
            if (numero == lista[i]){
                numeros++;
            }
        }
        int[] posA = new int[numeros];
        int posN = 0;
        for (int i = 0; i < pos; i++){
            if (numero == lista[i]){
                posA[posN] = i;
                posN++;
            }
        }
        return posA;

    }

    /**
     * Hace una b�squeda binaria del numero indicado devolviendo -1 si no se
     * encuentra o la posici�n en la que aparece
     * 
     * El array original lista no se modifica 
     * Para ello crea previamente una copia
     * de lista y trabaja con la copia
     * 
     * Usa exclusivamente m�todos de la clase Arrays
     * 
     */
    public int buscarBinario(int numero) {
        int [] copia = Arrays.copyOf(lista, pos);
        Arrays.sort(copia);
        return Arrays.binarySearch(copia, numero);
    }

    /**
     * borra el primer elemento de la lista
     */
    public void borrarPrimero() {
        for (int i = 1; i < pos; i++){
            lista[i - 1] = lista[i];

        }
        pos--;
    }

    /**
     *  Invierte cada uno de los grupos de n elementos que hay en lista
     *  
     *  Si el n� de elementos en lista no es divisible entre n los elementos restantes 
     *  quedan igual
     *  
     *  (leer enunciado)
     *  
     */
    public void invertir(int n) {
        int[] copia = new int[n];
        for (int i = -1; i < pos - n; i += n){
            System.arraycopy(lista, i + 1, copia, 0, n);
            for(int j = 0; j < copia.length / 2; j++){ 
                int aux = copia[j];
                copia[j] = copia[copia.length - j - 1];
                copia[copia.length - j - 1] = aux;
            }
            System.arraycopy(copia, 0, lista, i + 1, n);
        }
    }

    /**
     * devuelve un ragged array de 2 dimensiones con tantas filas como valores
     * tenga el atributo lista y rellena el array de la forma indicada
     * (leer enunciado)
     * 
     */
    public int[][] toArray2D() {
        int[][] ragged = new int[pos][];
        for (int i = 0; i < ragged.length; i++){
            ragged[i] = new int[i + 1];
        }
        for (int i = 0; i < ragged.length; i++){
            for(int j = 0; j < ragged[i].length; j++){
                if (j == 0 || j == ragged[i].length - 1){
                    ragged[i][j] = 1;
                }
                else{
                    ragged[i][j] = ragged[i - 1][j - 1] + ragged[i - 1][j];
                }
            }
        }
        return ragged;
    }

    /**
     * Punto de entrada a la aplicaci�n 
     * Contiene c�digo para probar los m�todos de ListaNumeros
     */
    public static void main(String[] args) {
        ListaNumeros lista = new ListaNumeros(20);

        System.out.println("--- addElemento() y toString() -------");
        int[] valores = {21, -5, 6, -7, 21, -17, 21, 15, 22, 21, 77};
        for (int i = 0; i < valores.length; i++) {
            lista.addElemento(valores[i]);
        }
        System.out.println(lista.toString());

        System.out.println("--- buscarPosiciones() -------");
        int numero = 21;
        System.out.println(lista.toString());
        System.out.println("\t" + numero + " aparece en posiciones ");
        // seguir completando

    }
}
