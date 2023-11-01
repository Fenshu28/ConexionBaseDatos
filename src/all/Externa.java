package all;

public class Externa {
    String s = "MIO";
    public void porceso(){
        class Interna{
            public void imprime(){
                System.out.println("Objeto interno "+s);
//                p++;
            }
        }
        Interna in = new Interna();
        in.imprime();
    }
    
    
    public static void main(String[] args) {
        Externa ext = new Externa();
        ext.porceso();
    }
}
