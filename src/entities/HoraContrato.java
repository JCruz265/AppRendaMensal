package entities;

import java.util.Date;

//Classe para a quantidade de horas trabalhadas por contrato
public class HoraContrato {
    //Declarando atributos
    private Date data;
    private Double valorPorHora;
    private Integer horas;

    public HoraContrato() {
    }//Construtor Padrão

    public HoraContrato(Date data, Double valorPorHora, Integer horas) {
        this.data = data;
        this.valorPorHora = valorPorHora;
        this.horas = horas;
    }//Construtor com Argumentos

    // Metodos para (re)definir os atributos dos objetos
    public void setData(Date data) {
        this.data = data;
    }

    public void setValorPorHora(Double valorPorHora) {
        this.valorPorHora = valorPorHora;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }
    //fim dos metodos setter's

    // Metodos para acessar os atributos dos objetos
    public Date getData() {
        return data;
    }

    public Double getValorPorHora() {
        return valorPorHora;
    }

    public Integer getHoras() {
        return horas;
    }
    //fim dos metodos getter's

    //Metodo para total do valor a receber pelas horas trabalhadas
    public double valorTotal() {
        return valorPorHora * horas;
    }//fim do metodo valor total
}//fim da classe Hora dos contratos
