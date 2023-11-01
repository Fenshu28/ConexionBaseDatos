package entity;

public abstract class Figura {
    private double lado;

    public Figura(double lado) {
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }
    
    public abstract double calArea();
}
