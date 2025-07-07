// representa uma rota com cidade de destino e distância
public class Rota {
    private Cidade destino; // cidade de destino da rota
    private double distancia; // distância em km

    // construtor: inicializa a rota com destino e distância
    public Rota(Cidade destino, double distancia) {
        this.destino = destino;
        this.distancia = distancia;
    }

    public Cidade getDestino() {
        return destino;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDestino(Cidade destino) {
        this.destino = destino;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    // formata a exibição da rota
    @Override
    public String toString() {
        return "Conexão para " + destino.getNome() + ": " + distancia + " km";
    }


}