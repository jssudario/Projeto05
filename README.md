# Sistema de Rotas e Cidades

**Sistemas de Informação – Estrutura de Dados II**  
**Aluno(a):** Julia Sudário Silva  
**RA:** 007217  

## Descrição
Este projeto implementa um sistema de gerenciamento de cidades e rotas em Java, utilizando um grafo não direcionado para representar conexões entre cidades. O sistema permite listar conexões de uma cidade, verificar caminhos entre cidades, identificar cidades sem conexões, exibir a cidade mais populosa e listar todas as cidades cadastradas. As cidades e rotas são pré-definidas, e o sistema possui um menu interativo com seleção por números.

## Funcionalidades
- Listar conexões de uma cidade, mostrando destino e distância em km
- Verificar se há caminho entre duas cidades
- Listar cidades sem conexões
- Exibir a cidade mais populosa
- Listar todas as cidades cadastradas

## Estruturas de Dados
- `TreeSet`: para armazenar cidades ordenadas por nome
- `HashMap<Cidade, Set<Rota>>`: para o grafo não direcionado
- `HashSet`: para conjuntos de rotas
- `LinkedList`: para busca em largura (BFS)

## Observações
Desenvolvido como parte da disciplina de Estruturas de Dados (SIS-ED2-2025-1). Para algumas partes complexas, como a implementação do algoritmo de busca em largura, utilizei o Grok como ferramenta de apoio para esclarecer conceitos e otimizar a lógica, mantendo a autoria e compreensão do código.

## Como Executar
1. Compile os arquivos Java (`Cidade.java`, `Rota.java`, `MapaCidades.java`, `Main.java`).
2. Execute a classe `Main`.
3. Use o menu interativo para acessar as funcionalidades.
