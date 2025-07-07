import java.util.Objects;

// representa uma cidade com nome, estado e população
public class Cidade implements Comparable<Cidade> {
    private String nome; 
    private String uf; 
    private int populacao; 

    // construtor
    public Cidade(String nome, String uf, int populacao) {
        this.nome = nome;
        this.uf = uf;
        this.populacao = populacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public int getPopulacao() {
        return populacao;
    }

    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }

    // compara cidades por nome para ordenação no treeset
    @Override
    public int compareTo(Cidade outra) {
        return this.nome.compareToIgnoreCase(outra.nome);
    }

    // formata a exibição da cidade
    @Override
    public String toString() {
        return nome + " (" + uf + ", " + populacao + " hab)";
    }

    // retorna apenas o nome da cidade para exibição simplificada
    public String toSimpleString() {
        return nome;
    }

    // verifica se duas cidades são iguais
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cidade cidade = (Cidade) o;
        return nome.equalsIgnoreCase(cidade.nome) && uf.equalsIgnoreCase(cidade.uf);
    }

    // gera código hash para uso em hashmap e hashset
    @Override
    public int hashCode() {
        return Objects.hash(nome.toLowerCase(), uf.toLowerCase());
    }

}