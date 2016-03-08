package strassen;

public class Strassen {
  private int [][] suma (int [] [] a, int [] [] b){
    int [][] aux = new int [a.length][a.length];
    for (int i = 0; i < a.length; i++){
      for (int j = 0; j < a.length; j++){
        aux [i][j] = a [i][j] + b [j] [j];
      }
    }
    return aux;
  }

  private int [][] resta (int [] [] a, int [] [] b){
    int [][] aux = new int [a.length][a.length];
    for (int i = 0; i < a.length; i++){
      for (int j = 0; j < a.length; j++){
        aux [i][j] = a [i][j] - b [j] [j];
      }
    }
    return aux;
  }

  private int [][] divide (int [] [] matriz, int i, int j){
    int m = matriz.length/2;
    int [][] aux = new int [matriz.length/2][matriz.length/2];
    if (i == 1 && j == 1){
      for (int k = 0; k < m; k++){
        for ( int l = 0; l < m; l++){
          aux [k][l] = matriz [k][l];
        }
      }

    }
    if (i == 1 && j == 2){
      for (int k = 0; k < m; k++){
        for ( int l = m; l < 2*m; l++){
          aux [k][l-m] = matriz [k][l];
        }
      }

    }
    if (i == 2 && j == 1){
      for (int k = m; k < 2*m; k++){
        for ( int l = 0; l < m; l++){
          aux [k-m][l] = matriz [k][l];
        }
      }

    }
    if (i == 2 && j == 2){
      for (int k = m; k < 2*m; k++){
        for ( int l = m; l < 2*m; l++){
          aux [k-m][l-m] = matriz [k][l];
        }
      }
    }
    return aux;
  }
  
  private int [][] componer (int [][] v11, int [][] v12, int [][] v21, int [][] v22 ){
    int [][] aux = new int [v11.length*2][v11.length*2];
    int m = v11.length;
    for (int i = 0; i < 2*m; i++){
      for (int j = 0; j < 2*m; j++){
        if (i<m && j<m){
          aux [i][j] = v11[i][j];
        }
        if (i<m && j>=m){
          aux [i][j] = v12[i][j-m];
        }
        if (i>=m && j<m){
          aux [i][j] = v21[i-m][j];
        }
        if (i>=m && j>=m){
          aux [i][j] = v22[i-m][j-m];
        }
      }
    }
    
    return aux;
  }

  public int [][] strassen (int [] [] a, int [] [] b){
    if (a.length == 1){
      int [] [] aux = new int [1] [1];
      aux [0] [0] = a[0][0] * b[0][0];
      return aux; 
    }
    else{
      int [][] a11 = divide (a, 1, 1);
      int [][] a12 = divide (a, 1, 2);
      int [][] a21 = divide (a, 2, 1);
      int [][] a22 = divide (a, 2, 2);
      int [][] b11 = divide (b, 1, 1);
      int [][] b12 = divide (b, 1, 2);
      int [][] b21 = divide (b, 2, 1);
      int [][] b22 = divide (b, 2, 2);
      int [][] p1 = strassen (a11, resta(b12,b22));
      int [][] p2 = strassen (suma(a11, a12), b22);
      int [][] p3 = strassen (suma(a21, a22), b11);
      int [][] p4 = strassen (a22, resta(b21,b11));
      int [][] p5 = strassen (suma(a11, a22), suma(b11, b22));
      int [][] p6 = strassen (resta(a12, a22), suma(b21, b22));
      int [][] p7 = strassen (resta(a11, a21), suma(b11, b12));
      int [][] c11 = resta(suma(p5,p4), suma(p2,p6));
      int [][] c12 = suma(p1, p2);
      int [][] c21 = suma(p3, p4);
      int [][] c22 = resta(suma(p1,p5), suma(p3,p7));
      int [][] c = componer(c11, c12, c21, c22);
      return c;
    }
  }
}
