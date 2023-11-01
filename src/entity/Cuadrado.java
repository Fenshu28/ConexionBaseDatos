package entity;

public class Cuadrado extends Figura{

    public Cuadrado(int lado) {
        super(lado);
    }

    @Override
    public double calArea() {
        return getLado() * getLado();
    }
    
}
