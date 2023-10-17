package javaapplication1;

public class Produto {

    private int idp;
    private String nome;
    private int quantidade;
    private double valorUnitario;

    public int getIdp() {
        return idp;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String imprimir() {
        return "Id do Produto: " + idp
                + "\nNome do Produto: " + nome
                + "\nQuantidade: " + quantidade
                + "\nPreço do Produto: " + valorUnitario;
    }

}
