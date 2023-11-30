package App;

import entities.Departamento;
import entities.HoraContrato;
import entities.Trabalhador;
import entities_enum.NivelCarreira;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        //Metodo para entrada e saida padrão USA
        Locale.setDefault(Locale.US);
        //instanciação do Metodo de entrada
        Scanner sc = new Scanner(System.in);
        //instanciação do Metodo para formatação de data
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //Obtendo dados
        System.out.print("Qual o nome do Departamento: ");
        String nomeDepartamento = sc.next();
        System.out.println("Informe os dados do trabalhador:");
        System.out.print("Nome: ");
        sc.nextLine();
        String nome = sc.nextLine();
        System.out.println("Digite o número correspondente ao nivel da carreira\n" +
                "1 - JUNIOR - " +
                "2 - MEDIO - " +
                "3 - SENIOR");
        int n = sc.nextInt();
        String nivel = (n == 1)? "JUNIOR": (n == 2)? "MEDIO": "SENIOR";
        System.out.print("Salario Base: ");
        double sb = sc.nextDouble();
       //instanciação do objeto trabalhador
        Trabalhador trabalhador = new Trabalhador(nome,sb,NivelCarreira.valueOf(nivel), new Departamento(nomeDepartamento));
        //obtenção dos dados dos contratos
        System.out.println("Quantos contratos serão para este trabalhador?");
        int m = sc.nextInt();
        //adicionar os contratos a lista
        for(int i =0; i < m; i++){
            System.out.println("Informe os dados do "+ (i+1)+"º contrato:");
            System.out.print("Data(DD/MM/YYYY): ");
            Date dataContrato = sdf.parse(sc.next());
            System.out.print("Valor por hora: ");
            double valor = sc.nextDouble();
            System.out.print("Duração(horas): ");
            int hora = sc.nextInt();
            trabalhador.addContrato(new HoraContrato(dataContrato,valor,hora));
        }
        //Dados para informar a renda do trabalhador
        System.out.print("Informe o mês e o ano para o calculo da renda(MM/YYYY): ");
        System.out.print(trabalhador.info(sc.next()));
        sc.close();//fim do metodo de entrada
    }// fim do metodo principal
}//fim do programa
