package all;

public class ExternaAnonimas {
    Operaciones op = new Operaciones(){
      public void imprimir()  {
          System.out.println("imp anonima");
      }
    };
    void proceso(){
        op.imprimir();
    }
}
