package app;

import java.util.Scanner;

import formas.modelo.Circulo;
import formas.modelo.Forma;
import formas.modelo.Quadrado;
import formas.modelo.Triangulo;

public class CalculadoraFormas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Forma forma = null;

        String opcao;

        do{
            System.out.println("Escolha a forma geométrica:\n1 - Círculo\n2 - Quadrado\n3 - Triângulo\n4 - Sair");
            opcao = scanner.next();
            
            try {
                switch(opcao){
                    case "1":
                        System.out.println("Informe a medida do raio do circulo:");
                        forma = new Circulo(scanner.nextDouble());
                    break;

                    case "2":
                        System.out.println("Informe a medida do lado do quadrado:");
                        forma = new Quadrado(scanner.nextDouble());
                    break;

                    case "3":
                        System.out.println("Informe a medida do primeiro lado:");
                        double lado1 = scanner.nextDouble();
                        System.out.println("Informe a medida do segundo lado:");
                        double lado2 = scanner.nextDouble();
                        System.out.println("Informe a medida do terceiro lado:");
                        double lado3 = scanner.nextDouble();
    
                        forma = new Triangulo(lado1, lado2, lado3);

                        if(forma.calcularPerimetro() == 0){
                            forma = null;
                        }
                        
                    break;

                    case "4":
                        System.out.println("Fechando programa");
                        forma = null;
                    break;

                    default:
                        System.out.println("Opção inexistente");
                        forma = null;
                    break;
                }
            } catch (Exception e) {
                System.out.println("Valor inválido");
                forma = null;
            }

            if (forma != null){
                System.out.printf("Perímetro: %.2f" + forma.calcularPerimetro());
                System.out.printf("\nÁrea: %.2f\n" + forma.calcularArea());
            }

        }while(!opcao.equals("4"));
        
        scanner.close();
    }
}
