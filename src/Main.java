import java.util.List;
import java.util.Scanner;
import java.util.Set;

// classe principal com o menu interativo
public class Main {
    private static MapaCidades mapa = new MapaCidades(); // instancia o mapa de cidades
    private static Scanner scanner = new Scanner(System.in); // lê entradas do usuário

    // método principal > executa o menu em loop
    public static void main(String[] args) {
        while (true) {
            exibirMenu();
            String opcao = scanner.nextLine().trim(); // lê a opção do usuário
            switch (opcao) {
                case "1" -> listarConexoes(); 
                case "2" -> verificarCaminho(); 
                case "3" -> listarCidadesSemConexao(); 
                case "4" -> exibirCidadeMaisPopulosa(); 
                case "5" -> listarTodasCidades(); 
                case "6" -> {
                    System.out.println("Sistema encerrado!");
                    scanner.close(); // fecha o scanner
                    return; // sai do programa
                }
                default -> System.out.println("Opção inválida! Por favor, escolha um número de 1 a 6.");
            }
        }
    }

    // exibe o menu principal com as opções
    private static void exibirMenu() {
        System.out.println("\n* * * SISTEMA DE ROTAS E CIDADES CONECTADAS * * *");
        System.out.println("1 - Listar conexões de uma cidade");
        System.out.println("2 - Verificar caminho entre duas cidades");
        System.out.println("3 - Listar cidades sem conexões");
        System.out.println("4 - Exibir cidade mais populosa");
        System.out.println("5 - Listar todas as cidades cadastradas");
        System.out.println("6 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    // exibe a lista de cidades com números e retorna a cidade escolhida
    private static Cidade selecionarCidade(String mensagem) {
        List<Cidade> cidades = mapa.getCidades(); // obtém lista de cidades
        System.out.println("\n" + mensagem);
        for (int i = 0; i < cidades.size(); i++) {
            System.out.println((i + 1) + ". " + cidades.get(i)); // exibe cidades com números
        }
        System.out.print("Escolha o número da cidade: ");
        try {
            int indice = Integer.parseInt(scanner.nextLine().trim()) - 1; // converte entrada para índice
            if (indice >= 0 && indice < cidades.size()) {
                return cidades.get(indice); // retorna cidade escolhida
            } else {
                System.out.println("\nNúmero inválido! Tente novamente.");
                return null;
            }
        } catch (NumberFormatException e) {
            System.out.println("\nOpção inválida! Digite um número.");
            return null;
        }
    }

    // lista as conexões de uma cidade
    private static void listarConexoes() {
        Cidade cidade = selecionarCidade("Selecione a cidade para listar conexões:");
        if (cidade == null) return; // sai se a cidade é inválida
        Set<Rota> conexoes = mapa.listarConexoes(cidade); // obtém conexões
        if (conexoes.isEmpty()) {
            System.out.println("\nA cidade " + cidade.getNome() + " não possui conexões.");
        } else {
            System.out.println("\nConexões de " + cidade.getNome() + ":");
            for (Rota rota : conexoes) {
                System.out.println(rota); // exibe cada conexão
            }
        }
    }

    // verifica caminho entre cidades
    private static void verificarCaminho() {
        Cidade origem = selecionarCidade("Selecione a cidade de origem:");
        if (origem == null) return; // sai se origem é inválida
        Cidade destino = selecionarCidade("Selecione a cidade de destino:");
        if (destino == null) return; // sai se destino é inválido
        System.out.println(); // linha em branco para legibilidade
        if (origem.equals(destino)) {
            System.out.println("A cidade de origem e destino são iguais.");
            return;
        }
        List<Cidade> caminho = mapa.encontrarCaminho(origem, destino); // encontra caminho
        if (caminho.isEmpty()) {
            System.out.println("\nNenhum caminho encontrado entre " + origem.getNome() + " e " + destino.getNome() + ".");
        } else {
            System.out.println("\nCaminho entre " + origem.getNome() + " e " + destino.getNome() + ":");
            System.out.println(String.join(" -> ", caminho.stream().map(Cidade::toSimpleString).toList()));
        }
    }

    // lista cidades sem nenhuma conexão
    private static void listarCidadesSemConexao() {
        Set<Cidade> semConexao = mapa.listarCidadesSemConexao(); // obtém cidades sem conexões
        if (semConexao.isEmpty()) {
            System.out.println("\nNenhuma cidade sem conexão.");
        } else {
            System.out.println("\nCidades sem conexões:");
            for (Cidade cidade : semConexao) {
                System.out.println(cidade); // exibe cada cidade
            }
        }
    }

    // exibe a cidade mais populosa
    private static void exibirCidadeMaisPopulosa() {
        Cidade maisPopulosa = mapa.cidadeMaisPopulosa(); // obtém cidade mais populosa
        if (maisPopulosa == null) {
            System.out.println("\nNenhuma cidade cadastrada.");
        } else {
            System.out.println("\nCidade mais populosa: " + maisPopulosa);
        }
    }

    // lista todas as cidades cadastradas
    private static void listarTodasCidades() {
        List<Cidade> cidades = mapa.getCidades(); // obtém lista de cidades
        if (cidades.isEmpty()) {
            System.out.println("\nNenhuma cidade cadastrada.");
        } else {
            System.out.println("\nCidades cadastradas:");
            for (int i = 0; i < cidades.size(); i++) {
                System.out.println((i + 1) + ". " + cidades.get(i)); // exibe cidades com números
            }
        }
    }

    public static MapaCidades getMapa() {
        return mapa;
    }

    public static void setMapa(MapaCidades mapa) {
        Main.mapa = mapa;
    }

    public static void setScanner(Scanner scanner) {
        Main.scanner = scanner;
    }
}