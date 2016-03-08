package merge;

import java.util.ArrayList;
import java.util.Random;

import seleccion.Seleccion;

public class Test {

  public static void main(String[] args) {
    ArrayList <Integer> vector = new ArrayList<Integer>();
    Merge ordenarM = new Merge();
    Seleccion ordenarS = new Seleccion();
    Random rm = new Random ();
    for (int i = 0 ; i < 100; i++){
      vector.add(rm.nextInt(2000)-1000);
    }
    System.out.println(vector);
    ArrayList <Integer> vectorA = new ArrayList <Integer> (vector);
    ArrayList <Integer> vectorB = new ArrayList <Integer> (vector);
    
    vectorA = ordenarM.mergesort(vectorA);
    System.out.println(vectorA);
    System.out.println(ordenarM.contador());
    vectorB = ordenarS.sort(vectorB);
    System.out.println(vectorB);
    System.out.println(ordenarS.contador());

  }

}
