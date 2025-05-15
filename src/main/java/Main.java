import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

//vá na linha 50 para avaliar a atividade professor

public class Main {
  public static void main(String[] args) {
    ArrayList<Integer> linha1 = new ArrayList<Integer>();
    linha1.add(1);

    ArrayList<Integer> linha2 = new ArrayList<Integer>();
    linha2.add(1);
    linha2.add(2);
    linha2.add(5);
    linha2.add(4);

    ArrayList<Integer> linha3 = new ArrayList<Integer>();

    ArrayList<Integer> linha4 = new ArrayList<Integer>();
    linha4.add(5);
    linha4.add(2);
    linha4.add(1);

    ArrayList<Integer> linha5 = new ArrayList<Integer>();
    linha5.add(1);
    linha5.add(2);
    linha5.add(4);

    ArrayList<ArrayList> table = new ArrayList<ArrayList>();

    table.add(linha1);
    table.add(linha2);
    table.add(linha3);
    table.add(linha4);
    table.add(linha5);

    ListaAdjacencia LA = new ListaAdjacencia(table);

    LA.imprimirTabela();

    System.out.println("numeros de nós: " + LA.numeroDeNos());

    System.out.println("grau do nó 1: " + LA.grauDoNo(1));

    System.out.println("vizinhos do nó 1: " + LA.VizinhosDoNo(1));
    //o de cima era aquela atividade não avaliativa, abaixo
    //está o trabalho
    System.out.println("----- para o trabalho avaliativo ----");

    ArrayList<Integer> linhaA = new ArrayList<Integer>();
    linhaA.add(1);
    linhaA.add(2);
    linhaA.add(3);

    ArrayList<Integer> linhaB = new ArrayList<Integer>();

    linhaB.add(0);
    linhaB.add(2);

    ArrayList<Integer> linhaC = new ArrayList<Integer>();

    linhaC.add(0);
    linhaC.add(1);

    ArrayList<Integer> linhaD = new ArrayList<Integer>();
    linhaD.add(0);
    linhaD.add(4);

    ArrayList<Integer> linhaE = new ArrayList<Integer>();
    linhaE.add(3);
  

    ArrayList<ArrayList> tableA = new ArrayList<ArrayList>();

    tableA.add(linhaA);
    tableA.add(linhaB);
    tableA.add(linhaC);
    tableA.add(linhaD);
    tableA.add(linhaE);

    ListaAdjacencia L = new ListaAdjacencia(tableA);

    L.imprimirTabela();

    System.out.println("há auto-loops?: "+ L.autoLoops());

    System.out.println("os nos correspondem ao indice?: "+ L.NosDeAcordoComIndice());

    System.out.println("possui arestas paralelas?: "+ L.verificarArestasParalelas());

    System.out.println("a tabela está ordenada?: "+ L.isGrafoOrdenado());

    System.out.println("tudo certo?: "+ L.tudoCorreto());

    
  }
}
