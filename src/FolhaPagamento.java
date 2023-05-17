import java.util.Scanner;

public class FolhaPagamento {
    public static void main(String[] args) {
        Scanner leitorNumeros = new Scanner(System.in);
        Scanner leitorTexto = new Scanner(System.in);
        int quantidade;
        int quantidadeHorasExtras;
        int quantidadeHorasExtrasDomingosEFeriados;
        double valorHora;
        double salario;
        double valorHorasExtras = 0.0;
        double salarioHorasExtras;
        double salarioFinal = 0;
        double salarioHorasExtrasDomingosEFeriados = 0;
        boolean existeHoraDeDomingoEFeriado;

        double valorInss = 0;
        double valorIr = 0;
        double salarioLiquido = 0;




        System.out.println("PetShop FIAP\n\nDigite a quantidade de horas trabalhadas: ");
        quantidade = leitorNumeros.nextInt();
        valorHora = 50;
        salario = valorHora * quantidade;
        System.out.println("Salário Bruto: " + salario);

        System.out.println("PetShop FIAP\n\nDigite a quantidade de horas extras trabalhadas exceto domingos e feriados: ");
        quantidadeHorasExtras = leitorNumeros.nextInt();

        System.out.println("Tem horas extras de domingo ou feriado? (1 - Sim, 2 Não): ");
        existeHoraDeDomingoEFeriado = leitorTexto.next().equals("1");

        if (existeHoraDeDomingoEFeriado) {
            System.out.println("Infome a quantidade de horas extras trabalhadas de domingo e feriado");
            quantidadeHorasExtrasDomingosEFeriados = leitorNumeros.nextInt();
            salarioHorasExtrasDomingosEFeriados = valorHora * 2 * quantidadeHorasExtrasDomingosEFeriados;
        }


        valorHorasExtras = valorHora * 1.5;
        salarioHorasExtras = valorHorasExtras * quantidadeHorasExtras;

        salarioFinal = salario + salarioHorasExtras + salarioHorasExtrasDomingosEFeriados;




        if (salarioFinal <= 1302)  {
            valorInss = salarioFinal / 100 * 7.5;
        } else if (salarioFinal <= 2571.29) {
            valorInss = salarioFinal / 100 * 9;
        } else if (salarioFinal <= 3856.94) {
            valorInss = salarioFinal / 100 * 12;
        } else if (salarioFinal <= 7507.49) {
            valorInss = salarioFinal / 100 * 14;
        } else {
            valorInss = 877.20;
        }





        salarioLiquido = salarioFinal - valorInss;

        if (salarioLiquido > 1903.98 && salarioLiquido < 2826.65) {
            valorIr = (salarioLiquido * 0.075) - 142.8;
        } else if (salarioLiquido < 3751.05 ) {
            valorIr = (salarioLiquido * 0.15) - 354.8;
        } else if (salarioLiquido < 4664.69 ) {
            valorIr = (salarioLiquido * 0.225) - 636.13;
        } else {
            valorIr = (salarioLiquido * 0.275) - 869.36;
        }

        salarioLiquido = salarioLiquido - valorIr;

        System.out.println("Salário Bruto: " + String.format("%.2f",salario) +
            "\nHoras extras: " + String.format("%.2f",salarioHorasExtras) +
            "\nHoras de Domingo e Feriados: " + String.format("%.2f",salarioHorasExtrasDomingosEFeriados) +
            "\nSalário Final: " + String.format("%.2f",salarioFinal) +
            "\nValor INSS: " + String.format("%.2f",valorInss) +
            "\nValor IR: " + String.format("%.2f",valorIr) +
            "\nSalário Líquido: " + String.format("%.2f",salarioLiquido)
        );


    }
}
