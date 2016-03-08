package seleccion;

import java.util.ArrayList;
import java.util.Random;

public class Test {

  public static void main(String[] args) {
    ArrayList <Integer> vector = new ArrayList<Integer>();
    Seleccion seleccionsort = new Seleccion();
    Random rm = new Random ();
    for (int i = 0 ; i < 30; i++){
      vector.add(rm.nextInt(100));
    }
    System.out.println(vector);
    vector = seleccionsort.sort(vector);
    System.out.println(vector);
    System.out.println(seleccionsort.contador());
  }
}
