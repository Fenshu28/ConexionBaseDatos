package all;

public class Anonima {

    public void incicar() {
        Saludador obj = new Saludador() {
            @Override
            public void saludar() {
                System.out.println("Hola 506");
            }
        };
        obj.saludar();
    }

}

interface Saludador {
    public void saludar();
}
