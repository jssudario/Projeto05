# sistema de rotas e cidades

## descrição
este projeto implementa um sistema de gerenciamento de cidades e rotas em java, utilizando um grafo não direcionado para representar conexões entre cidades. o sistema permite listar conexões de uma cidade, verificar caminhos entre cidades, identificar cidades sem conexões, exibir a cidade mais populosa e listar todas as cidades cadastradas. as cidades e rotas são pré-definidas, e o sistema possui um menu interativo com seleção por números.

## funcionalidades
- listar conexões de uma cidade, mostrando destino e distância em km
- verificar se há caminho entre duas cidades
- listar cidades sem conexões
- exibir a cidade mais populosa
- listar todas as cidades cadastradas

## estruturas de dados
- `treeset`: para armazenar cidades ordenadas por nome
- `hashmap<cidade, set<rota>>`: para o grafo não direcionado
- `hashset`: para conjuntos de rotas
- `linkedlist`: para busca em largura (bfs)

## observações
desenvolvido como parte da disciplina de estruturas de dados (sis-ed2-2025-1). para algumas partes complexas, como a implementação do algoritmo de busca em largura, utilizei o grok como ferramenta de apoio para esclarecer conceitos e otimizar a lógica, mantendo a autoria e compreensão do código.

## como executar
1. compile os arquivos java (`Cidade.java`, `Rota.java`, `MapaCidades.java`, `Main.java`)
2. execute a classe `Main`
3. use o menu interativo para acessar as funcionalidades

## entrega
um vídeo demonstrando o funcionamento do sistema foi submetido via formulário, conforme instruções do repositório da disciplina ([github](https://github.com/anaves/SIS-ED2-2025-1)).