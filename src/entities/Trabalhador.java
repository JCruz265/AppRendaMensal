package entities;

import entities_enum.NivelCarreira;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Trabalhador {
    //Declarando Atributos basicos
    private String nome;
    private Double salarioBase;
    //Declarando Atributos dos relacionamentos com outras classes
    private NivelCarreira nivel;
    private Departamento departamento;
    private List<HoraContrato> contratos = new ArrayList<>();
    public Trabalhador(){
    }//Construtor Padrão
    public Trabalhador(String nome, Double salarioBase, NivelCarreira nivel, Departamento departamento) {
        this.nome = nome;
        this.salarioBase = salarioBase;
        this.nivel = nivel;
        this.departamento = departamento;
    }//Construtor com argumentos
    // Metodos para (re)definir os atributos dos objetos

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNivel(NivelCarreira nivel) {
        this.nivel = nivel;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    //fim dos metodos setter's

    // Metodos para acessar os atributos dos objetos

    public String getNome() {
        return nome;
    }

    public NivelCarreira getNivel() {
        return nivel;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public List<HoraContrato> getContratos() {
        return contratos;
    }

    //fim dos metodos getter's

    //Metodo para adicionar contratos a lista
    public void addContrato(HoraContrato contrato){
        contratos.add(contrato);
    }//fim do metodo add

    //Metodo para remover contratos a lista
    public void removeContrato(HoraContrato contrato){
        contratos.remove(contrato);
    }//fim do metodo para remover
    //Metodo para a renda do trabalador
    public double renda(int ano, int mes){
        double soma = salarioBase;
        Calendar cal = Calendar.getInstance();
        for(HoraContrato c : contratos){
            cal.setTime(c.getData());
            int c_ano = cal.get(Calendar.YEAR);
            int c_mes = 1 + cal.get(Calendar.MONTH);
            if(ano == c_ano && mes == c_mes){
                   soma += c.valorTotal();}
                }
        return soma;
    }//fim do metodo renda
    //Matodo do texto informativo da renda
    public String info(String dt) {
        int mes = Integer.parseInt(dt.substring(0,2));
        int ano = Integer.parseInt(dt.substring(3));
        StringBuilder sb = new StringBuilder();
        sb.append("\nNome: ");
        sb.append(getNome());
        sb.append("\nDepartamento: ");
        sb.append(getDepartamento().getNome());
        sb.append("\nRenda em ");
        sb.append(dt);
        sb.append(": R$");
        sb.append(String.format("%.2f",renda(ano,mes)));
        return sb.toString();
    }//fim do metodo info
}//fim da classe trabalhador
