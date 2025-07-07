import java.util.*;

// gerencia o grafo de cidades e rotas
public class MapaCidades {
    private HashMap<Cidade, Set<Rota>> grafo; // grafo não direcionado: cidade -> conjunto de rotas
    private TreeSet<Cidade> cidades; // cidades ordenadas por nome

    // construtor: inicializa o grafo e o conjunto de cidades
    public MapaCidades() {
        grafo = new HashMap<>();
        cidades = new TreeSet<>();
        inicializarCidadesERotas(); // inicializa cidades e rotas pré-definidas
    }

    // inicializa as cidades e rotas pré-definidas
    private void inicializarCidadesERotas() {
        // cria as cidades com nome, uf e população
        Cidade c1 = new Cidade("São Sebastião do Paraíso", "MG", 70000);
        Cidade c2 = new Cidade("Itamogi", "MG", 10700);
        Cidade c3 = new Cidade("Monte Santo de Minas", "MG", 20800);
        Cidade c4 = new Cidade("São Tomás de Aquino", "MG", 6740);
        Cidade c5 = new Cidade("Carrancas", "MG", 5000);

        // adiciona cidades ao treeset (para ordenação)
        cidades.add(c1);
        cidades.add(c2);
        cidades.add(c3);
        cidades.add(c4);
        cidades.add(c5);

        // inicializa conjuntos de rotas para cada cidade no hashmap
        grafo.put(c1, new HashSet<>());
        grafo.put(c2, new HashSet<>());
        grafo.put(c3, new HashSet<>());
        grafo.put(c4, new HashSet<>());
        grafo.put(c5, new HashSet<>());

        // define rotas pré-definidas (grafo não direcionado)
        grafo.get(c1).add(new Rota(c2, 50.0)); // são sebastião do paraíso -> itamogi
        grafo.get(c2).add(new Rota(c1, 50.0)); // itamogi -> são sebastião do paraíso
        grafo.get(c2).add(new Rota(c4, 30.0)); // itamogi -> são tomás de aquino
        grafo.get(c4).add(new Rota(c2, 30.0)); // são tomás de aquino -> itamogi
        grafo.get(c4).add(new Rota(c3, 25.0)); // são tomás de aquino -> monte santo de minas
        grafo.get(c3).add(new Rota(c4, 25.0)); // monte santo de minas -> são tomás de aquino
        // carrancas (c5) não tem conexões
    }

    // retorna as conexões de uma cidade
    public Set<Rota> listarConexoes(Cidade cidade) {
        if (!cidades.contains(cidade)) {
            throw new IllegalArgumentException("Cidade não cadastrada.");
        }
        return grafo.get(cidade); // retorna o conjunto de rotas
    }

    // verifica se há caminho entre duas cidades usando busca em largura (bfs)
    public boolean existeCaminho(Cidade origem, Cidade destino) {
        if (!cidades.contains(origem) || !cidades.contains(destino)) {
            return false; // retorna false se uma das cidades não existe
        }
        Set<Cidade> visitados = new HashSet<>(); // cidades já visitadas
        Queue<Cidade> fila = new LinkedList<>(); // fila para bfs
        fila.add(origem);
        visitados.add(origem);

        while (!fila.isEmpty()) {
            Cidade atual = fila.poll(); // pega a próxima cidade
            if (atual.equals(destino)) {
                return true; // encontrou o destino
            }
            for (Rota rota : grafo.get(atual)) {
                Cidade proxima = rota.getDestino();
                if (!visitados.contains(proxima)) {
                    visitados.add(proxima);
                    fila.add(proxima); // adiciona cidade não visitada à fila
                }
            }
        }
        return false; // não encontrou caminho
    }

    // retorna cidades sem nenhuma conexão
    public Set<Cidade> listarCidadesSemConexao() {
        Set<Cidade> semConexao = new TreeSet<>(); // conjunto ordenado
        for (Cidade cidade : cidades) {
            if (grafo.get(cidade).isEmpty()) {
                semConexao.add(cidade); // adiciona cidade sem rotas
            }
        }
        return semConexao;
    }

    // encontra a cidade com maior população
    public Cidade cidadeMaisPopulosa() {
        Cidade maisPopulosa = null;
        int maxPopulacao = -1;
        for (Cidade cidade : cidades) {
            if (cidade.getPopulacao() > maxPopulacao) {
                maxPopulacao = cidade.getPopulacao();
                maisPopulosa = cidade; // atualiza a cidade mais populosa
            }
        }
        return maisPopulosa;
    }

    // encontra um caminho entre duas cidades usando bfs
    public List<Cidade> encontrarCaminho(Cidade origem, Cidade destino) {
        if (!cidades.contains(origem) || !cidades.contains(destino)) {
            return new ArrayList<>(); // retorna lista vazia se cidades não existem
        }

        Map<Cidade, Cidade> predecessores = new HashMap<>(); // armazena predecessores
        Set<Cidade> visitados = new HashSet<>(); // cidades visitadas
        Queue<Cidade> fila = new LinkedList<>(); // fila para bfs
        fila.add(origem);
        visitados.add(origem);

        while (!fila.isEmpty()) {
            Cidade atual = fila.poll();
            if (atual.equals(destino)) {
                break; // encontrou o destino
            }
            for (Rota rota : grafo.get(atual)) {
                Cidade proxima = rota.getDestino();
                if (!visitados.contains(proxima)) {
                    visitados.add(proxima);
                    fila.add(proxima);
                    predecessores.put(proxima, atual); // registra predecessor
                }
            }
        }

        // reconstrói o caminho do destino até a origem
        List<Cidade> caminho = new ArrayList<>();
        Cidade atual = destino;
        while (atual != null) {
            caminho.add(atual);
            atual = predecessores.get(atual);
        }
        Collections.reverse(caminho); // inverte para ordem correta
        return caminho.isEmpty() || !caminho.get(0).equals(origem) ? new ArrayList<>() : caminho;
    }

    // retorna todas as cidades cadastradas
    public List<Cidade> getCidades() {
        return new ArrayList<>(cidades); // retorna cópia da lista de cidades
    }

    // setters
    public HashMap<Cidade, Set<Rota>> getGrafo() {
        return grafo;
    }

    public void setGrafo(HashMap<Cidade, Set<Rota>> grafo) {
        this.grafo = grafo;
    }

    public void setCidades(TreeSet<Cidade> cidades) {
        this.cidades = cidades;
    }
}