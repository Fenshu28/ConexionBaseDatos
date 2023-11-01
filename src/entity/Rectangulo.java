package entity;

public class Rectangulo extends Figura {
    private double altura;
    
    public Rectangulo(double lado,double altura) {
        super(lado);
        this.altura = altura;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    @Override
    public double calArea() {
        System.out.println(getLado());
        System.out.println(getAltura());
        return getLado() * getAltura();
    }
    
}
