package merge;

import java.util.ArrayList;

public class Merge {
  private int contador = 0;
  
  public ArrayList<Integer> mergesort (ArrayList<Integer> vector) {
    if (vector.size()>1){
      ArrayList<Integer> vectorA = mergesort (new ArrayList<Integer>(vector.subList(0, (vector.size()/2))));
      ArrayList<Integer> vectorB = mergesort (new ArrayList<Integer>(vector.subList((vector.size()/2),vector.size())));
      vector = merge (vectorA, vectorB);
    }
    return vector;
  }
  private ArrayList<Integer> merge (ArrayList<Integer> vectorA, ArrayList<Integer> vectorB){
    ArrayList<Integer> aux = new ArrayList<Integer>();
    while (!vectorA.isEmpty() && !vectorB.isEmpty()){
      contador++;
      if (vectorA.get(0) < vectorB.get(0)){
        aux.add(vectorA.get(0));
        vectorA.remove(0);
      }
      else{
        if (vectorA.get(0) > vectorB.get(0)){
          aux.add(vectorB.get(0));
          vectorB.remove(0);
        }
        else{
          aux.add(vectorA.get(0));
          vectorA.remove(0);
          aux.add(vectorB.get(0));
          vectorB.remove(0);
          
        }
      }
    }
    if (!vectorB.isEmpty()){
      aux.addAll(vectorB);
    }
    if (!vectorA.isEmpty()){
      aux.addAll(vectorA);
    }
    return aux;
  }
  public int contador (){
    return contador;
  }
}
