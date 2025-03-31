# Projeto de Problema de Busca

Este projeto implementa diversos algoritmos de busca estudados na disciplina de Inteligência Artificial do sétimo período do curso de Ciência da Computação. O objetivo é fornecer uma implementação de algoritmos clássicos de busca em grafos, aplicáveis em diversas áreas da computação, como planejamento, roteamento e resolução de problemas de otimização.

## 📂 Estrutura do Projeto

### 📄 Documentação
- **`/Problemas De Busca.pdf`**: Artigo contendo a justificativa dos algoritmos implementados, detalhes sobre a teoria por trás de cada algoritmo e suas aplicações no mundo real.

### 📁 Código-fonte
#### 🔹 `src/main/java/main/algorithm/`
Contém as implementações dos algoritmos de busca:
- **`Bidirectional.java`**: Implementação da busca bidirecional.
- **`BFS.java`**: Implementação da busca em largura (*Breadth-First Search*).
- **`DFS.java`**: Implementação da busca em profundidade (*Depth-First Search*).
- **`IDDFS.java`**: Implementação da busca em profundidade iterativa (*Iterative Deepening Depth-First Search*).
- **`UCS.java`**: Implementação da busca de custo uniforme (*Uniform Cost Search*).
- **`GFS.java`**: Implementação da busca gulosa (*Greedy Best-First Search*).
- **`AStar.java`**: Implementação do algoritmo A* (*A Star*), que combina a busca de custo uniforme com heurísticas.

#### 🔹 `src/main/java/main/entity/`
Contém as entidades principais do projeto:
- **`Node.java`**: Representa um nó no grafo, incluindo seus vizinhos e custos associados.
- **`Neighbor.java`**: Representa um vizinho de um nó no grafo.
- **`Tree.java`**: Representa a estrutura do grafo.

#### 🔹 `src/main/java/main/src/`
Contém classes auxiliares:
- **`ResultAdapter.java`**: Adapta o resultado da busca para um formato utilizável, retornando o caminho encontrado ou um estado sem solução.

#### 🔹 `src/main/java/main/`
Contém a classe principal:
- **`Main.java`**: Classe principal que inicia a aplicação.

## 🚀 Como Utilizar

### ✅ Pré-requisitos
- Java 8 ou superior
- Maven

### ⚙️ Compilação e Execução

1. Clone o repositório:
   ```sh
   git clone https://github.com/SAVANOo/Search-Problem-IA.git
   cd Search-Problem-IA
   ```

2. Compile o projeto usando Maven:
   ```sh
   mvn clean install
   ```

3. Execute a aplicação:
   ```sh
   mvn exec:java -Dexec.mainClass="main.Main"
   ```

### 🖥️ Uso dos Algoritmos
Os algoritmos podem ser utilizados chamando os métodos estáticos das respectivas classes. Exemplo:

```java
Node initial = new Node("oradea");
Node target = new Node("arad");

// Busca Bidirecional
ResultAdapter result = Bidirectional.search(initial, target);

// Busca em Largura
ResultAdapter resultBFS = BFS.search(initial, target);

// Busca em Profundidade
ResultAdapter resultDFS = DFS.search(initial, target);

// Busca A* (A Star)
ResultAdapter resultAStar = AStar.search(initial, target, heuristicMap);

// Busca de Custo Uniforme
ResultAdapter resultUCS = UCS.search(initial, target);

// Busca Gulosa
ResultAdapter resultGFS = GFS.search(initial, target, heuristicMap);
```

## 🧠 Algoritmos Implementados

### 1. **Busca em Largura (BFS)**
A busca em largura explora todos os vizinhos de um nó antes de explorar os vizinhos dos vizinhos. É uma busca não informada que garante encontrar o caminho mais curto em termos de número de arestas em grafos não ponderados.

### 2. **Busca em Profundidade (DFS)**
A busca em profundidade explora o grafo profundamente, visitando um nó e explorando completamente seus filhos antes de voltar e explorar outros caminhos. Pode ser útil para encontrar soluções profundas, mas não garante encontrar o caminho mais curto.

### 3. **Busca Bidirecional**
A busca bidirecional realiza duas buscas simultâneas, uma a partir do nó inicial e outra a partir do nó alvo, até que elas se encontrem no meio. Essa abordagem pode ser mais eficiente em termos de tempo, pois reduz o espaço de busca pela metade.

### 4. **Busca de Custo Uniforme (UCS)**
A busca de custo uniforme é uma variação da busca em largura, mas onde cada transição de nó tem um custo associado. Ela garante encontrar o caminho de menor custo em termos de distância total percorrida.

### 5. **Busca Gulosa (Greedy Best-First Search - GFS)**
A busca gulosa utiliza uma heurística para explorar os nós que parecem promissores, mas não leva em consideração o custo total até o momento. Embora eficiente, ela não garante encontrar a solução ótima.

### 6. **A* (A Star)**
O algoritmo A* combina os conceitos da busca de custo uniforme com uma heurística, permitindo uma busca eficiente e ótima. A* considera o custo até o nó atual e uma estimativa do custo restante até o alvo, o que resulta em uma busca informada mais eficiente.

### 7. **Busca em Profundidade Iterativa (IDDFS)**
A busca em profundidade iterativa combina as vantagens da busca em profundidade com a garantia de que o caminho mais curto será encontrado, realizando buscas sucessivas com limites de profundidade crescente.

## 📜 Licença
Este projeto está licenciado sob a Licença MIT. Consulte o arquivo `LICENSE` para mais detalhes.

