package strassen;

public class Test {

  public static void main(String[] args) {
    Strassen mult = new Strassen ();
    int [][] a = {{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};
    int [][] b = {{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};
    int [][] c = mult.strassen (a,b);
    System.out.println(c);
    // TODO Auto-generated method stub

  }

}
