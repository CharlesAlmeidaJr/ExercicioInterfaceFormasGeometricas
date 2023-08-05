package formas.modelo;

public class Quadrado extends FormaBase{
    private double lado;

    public Quadrado(double lado){
        this.lado = lado;
    }

    @Override
    public double calcularPerimetro() {
        return 4 * lado;
    }

    @Override
    public double calcularArea() {
        return lado * lado;
    }
}
