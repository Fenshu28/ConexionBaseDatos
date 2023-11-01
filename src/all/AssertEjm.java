/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package all;

/**
 *
 * @author labtecweb08
 */
public class AssertEjm {

    static void procesa(int num) {
        assert (num > 0) : num + " - No es positivo.";
    }

    public static void main(String[] args) {
        try {
            int x = -4;
            procesa(x);
            System.out.println("Hola pase la aserción");
        } catch (Error e) {
            System.out.println(e.getMessage());
        }
    }
}
