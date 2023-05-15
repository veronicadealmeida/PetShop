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
        double salarioLiquido = 0;




        System.out.println("PetShop FIAP\n\nDigite a quantidade de horas trabalhadas: ");
        quantidade = leitorNumeros.nextInt();
        valorHora = 18;
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

        System.out.println("Salário Bruto: " + salario +
                "\nHoras extras: " + salarioHorasExtras +
                "\nHoras de Domingo e Feriados: " + salarioHorasExtrasDomingosEFeriados +
                "\nSalário Final: " + salarioFinal +
                "\nValor INSS: " + valorInss +
                "\nSalário Líquido: " + salarioLiquido
        );


    }
}
