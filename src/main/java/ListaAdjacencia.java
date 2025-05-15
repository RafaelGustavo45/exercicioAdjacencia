import java.util.ArrayList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;


public class ListaAdjacencia {

  public ArrayList<String> vertices = new ArrayList<String>();

  public ArrayList<ArrayList> tabela = new ArrayList<ArrayList>();

  public ListaAdjacencia(ArrayList<ArrayList> matrix) {

    /*
     * int tamanho = vertices.size();
     * 
     * for (ArrayList<Integer> linha : matrix){
     * if (linha.size() != tamanho){ // trocar por exception
     * System.out.println("tamanho não corresponde");
     * }
     * }
     */
    this.tabela = matrix;

  }

  public void imprimirTabela() {
    int i = 0;
    System.out.println("Lista de adjacencia");
    System.out.println("{");
    for (ArrayList<Integer> linha : this.tabela) {
      System.out.println(i + ":" + linha);
      i++;
    }
    System.out.println("}");
  }

  public int numeroDeNos() {
    return this.tabela.size();
  }

  public int grauDoNo(int no) {
    ArrayList<Integer> linha = tabela.get(no);
    return linha.size();
  }

  public ArrayList<Integer> VizinhosDoNo(int no) {
    return tabela.get(no);
  }

  public boolean autoLoops() {
    int i = 0;
    for (ArrayList<Integer> linha : this.tabela) {
      // Para cada linha na tabela de adjacência
      for (Integer elemento : linha) {
        // Para cada elemento (vértice adjacente) na linha atual
        if (elemento == i) {
          // Se o elemento (vértice adjacente) for igual ao índice da linha atual (vértice
          // de origem),
          // significa que há um auto-loop. Retornamos true indicando a presença de um
          // auto-loop.
          return true;
        }
      }
      // Incrementamos o índice da linha para verificar o próximo vértice de origem.
      i++;
    }
    // Se percorremos toda a tabela e não encontramos nenhum auto-loop, retornamos
    // false.
    return false;
  }

  public boolean NosDeAcordoComIndice(){
    int indiceElementos = tabela.size()-1;
    for (ArrayList<Integer> linha : this.tabela) {
      // Para cada linha na tabela de adjacência
      for (Integer elemento : linha) {
        // Para cada elemento (vértice adjacente) na linha atual
        if (elemento < indiceElementos) {
          // Se o elemento (vértice adjacente) for igual ao índice da linha atual (vértice
          // de origem),
          // significa que há um auto-loop. Retornamos true indicando a presença de um
          // auto-loop.
          return true;
        }
      }
      // Incrementamos o índice da linha para verificar o próximo vértice de origem.
      
    }
    // Se percorremos toda a tabela e não encontramos nenhum auto-loop, retornamos
    // false.
    return false;
    
  }

  public boolean verificarArestasParalelas(){
    for (ArrayList<Integer> linha : this.tabela) {
      boolean duplicado= temDuplicados(linha);
      if (duplicado==true){
        return true;
      }
    }
    return false;
  }

   

  
  public static boolean temDuplicados(ArrayList<Integer> linha) {
        HashSet<Integer> elementos = new HashSet<Integer>();
        for (int numero : linha) {
            if (!elementos.add(numero)) {
                // Se não conseguiu adicionar, significa que já existe no conjunto
                return true;
            }
        }
        return false;
    }

  public static boolean buscarElemento(ArrayList<Integer> linha, int elem){
    for (int numero: linha){
      if (numero==elem){
        return true;
      }
    }
    return false;
  }
  //verão mais simples
  public boolean isGrafoOrdenado(){
    int indice=0;
    for (ArrayList<Integer> linha: tabela){
      for(int c: linha){
        if (buscar(c,indice)==false){
          return false;
        }
        
      }
      indice++;
    }
    return true;
  }

  public boolean buscar(int indice, int elemento){
    ArrayList<Integer> linha = tabela.get(indice);
    return buscarElemento(linha, elemento);
  }

  public boolean tudoCorreto(){
    ArrayList<Boolean> res = new ArrayList<Boolean>();
    res.add(autoLoops());
    res.add(NosDeAcordoComIndice());
    res.add(verificarArestasParalelas());
    res.add(isGrafoOrdenado());
    ArrayList<Boolean> certo = new ArrayList<Boolean>();
    certo.add(false);
    certo.add(true);
    certo.add(false);
    certo.add(true);
    return mesmosElementos(res,certo);
  }

  public boolean mesmosElementos(ArrayList<Boolean> e, ArrayList<Boolean> v){
    int indice=0;
    for (boolean i: v){
      if (e.get(indice) != i){
        return false;
      }
      indice++;
    }
    return true;
  }


  //ultima questão, fara um loop verificando se cada elemento
  //de uma linha está na linha de seu index
  //criei uma verão mais simples
  /*public boolean isGrafoOrdenado() {
      int numVertices = tabela.size();

      // Verifica se a tabela representa um grafo direcionado
      for (int i = 0; i < numVertices; i++) {
        ArrayList<Integer> linha = tabela.get(i);
          for (Integer vizinho : linha) {
              // Verifica se o vizinho está dentro dos limites válidos dos vértices
              if (vizinho < 0 || vizinho >= numVertices) {
                  System.err.println("Erro: Vértice " + vizinho + " na lista de adjacência de " + i + " é inválido.");
                  return false;
              }
              // Verifica se a aresta (i -> vizinho) é refletida na lista de adjacência do vizinho
              if (!tabela.get(vizinho).contains(i)) {
                  System.err.println("Aviso: Aresta (" + i + " -> " + vizinho + ") não é refletida em " + vizinho + ": " + tabela.get(vizinho));
                  // Se quiser estritamente ordenado (não direcionado), retorne false aqui.
                  // Para a definição dada, apenas um aviso é suficiente para grafos direcionados.
              }
          }
      }

      // Validação principal para grafo "ordenado" conforme a descrição
      for (int i = 0; i < numVertices; i++) {
        ArrayList<Integer> linha = tabela.get(i);
          for (Integer vizinho : linha) {
              // Para cada vizinho 'v' do vértice 'i', verifica se 'i' aparece na lista de adjacência de 'v'
              if (!tabela.get(vizinho).contains(i)) {
                  System.err.println("Erro de ordenação: Vértice " + i + " (índice da linha) não encontrado na lista de adjacência de " + vizinho + " (valor do elemento).");
                  return false; // Não é um grafo ordenado conforme a regra
              }
          }
      }

      return true; // Se todas as verificações passarem, é um grafo ordenado
  } */

  
}