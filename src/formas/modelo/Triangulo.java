package formas.modelo;

public class Triangulo extends FormaBase{
    private double lado1, lado2, lado3, base, altura, semiperimetro;
    private String tipo;

    public Triangulo(double lado1, double lado2, double lado3){
        if(calcularSemiperimetro(lado1, lado2, lado3)){
            identificarTriangulo(lado1, lado2, lado3);
        }else{
            this.tipo = "inválido";
        }

        System.out.println("É um triângulo " + tipo);
    }

    private boolean calcularSemiperimetro(double lado1, double lado2, double lado3){
        semiperimetro = (lado1 + lado2 + lado3) / 2;
        return !(semiperimetro <= lado1 || semiperimetro <= lado2 || semiperimetro <= lado3);
    }

    private void identificarTriangulo(double lado1, double lado2, double lado3){
        if(lado1 == lado2 || lado1 == lado3 || lado3 == lado2){
            if(lado1 == lado2 && lado2 == lado3){
                tipo = "equilátero";
                this.lado1 = lado1;
                this.lado2 = lado2;
                this.lado3 = lado3;
            }
            else{
                tipo = "isósceles";

                if(lado1 != lado2 && lado1 != lado3){
                    this.lado1 = lado2;
                    this.lado2 = lado3;
                    this.lado3 = lado1;
                }else if(lado3 != lado2 && lado1 != lado2){
                    this.lado1 = lado1;
                    this.lado2 = lado3;
                    this.lado3 = lado2;
                }else{
                    this.lado1 = lado1;
                    this.lado2 = lado2;
                    this.lado3 = lado3;
                }
            }

            base = this.lado3;

            altura = Math.sqrt((this.lado1 * this.lado1) - ((base/2)*(base/2)));
        
        }else{
            tipo = "escaleno";

            this.lado1 = lado1;
            this.lado2 = lado2;
            this.lado3 = lado3;

            base = this.lado3;

            altura = (2/base)*Math.sqrt(semiperimetro*(semiperimetro-lado1)*(semiperimetro-lado2)*(semiperimetro-lado3));

        }
    }

    @Override
    public double calcularPerimetro() {
        return lado1 + lado2 + lado3;
    }

    @Override
    public double calcularArea() {
        return (base*altura)/2;
    }
}
