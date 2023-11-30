package entities;
//Classe do departamento do trabalhador
public class Departamento {
    //Declarando Atributo
    private String nome;
    public Departamento(){
    }//Construtor Padrão
    public Departamento(String nome) {
        this.nome = nome;
    }//Construtor com argumentos
    // Metodos para (re)definir os atributos dos objetos
    public void setNome(String nome) {
        this.nome = nome;
    }
    //fim dos metodos setter's

    // Metodos para acessar os atributos dos objetos
    public String getNome() {
        return nome;
    }
    //fim dos metodos getter's

}//fim da classe Departamento
