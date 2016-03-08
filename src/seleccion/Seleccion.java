package seleccion;

import java.util.ArrayList;

public class Seleccion {
  private int contador = 0;
  public ArrayList <Integer> sort (ArrayList <Integer> vector){
    contador = 0;
    for (int i = 0; i < vector.size(); i++){
      int aux = vector.get(i);
      int menor = i;
      for (int j = i+1; j < vector.size(); j++){
        contador ++;
        if (vector.get(j) < vector.get(menor)){
          menor = j;
        }
      }
      vector.set(i, vector.get(menor));
      vector.set(menor, aux);
      
    }
    return vector;
  }
  public int contador (){
    return contador;
  }

}
