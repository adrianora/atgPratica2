package p2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import grafo.Graph;
import grafo.Vertice;
import main.GraphLib;

public class GrafoDesconectadoSemPeso {

	GraphLib novo;
	String path = "grafos/grafoDesconectadoSemPeso.txt";

	Graph graph;

	public GrafoDesconectadoSemPeso() {
		novo = new GraphLib();
		graph = novo.readGraph(path);
	}

	@Test
	public void numeroVertices() {
		assertEquals(14, novo.getVertexNumber(graph));
	}

	@Test
	public void numeroArestas() {
		assertEquals(12, novo.getEdgeNumber(graph));
	}

	@Test
	public void pesoMedio() {
		assertEquals(1, novo.getMeanEdge(graph), 0);
	}
	
	@Test
	public void ehConectado() {
		assertEquals(false, novo.connected(graph));
	}
	
	@Test
	public void representacaoAl() {
		String representacaoAl = 	"1 - 2\r\n" + 
								"2 - 1 3\r\n" +
								"3 - 2 4 5 7\r\n" + 
								"4 - 3 6 5\r\n" + 
								"5 - 3 4\r\n" + 
								"6 - 4\r\n" + 
								"7 - 3 8\r\n" + 
								"8 - 7\r\n" + 
								"9 - 14\r\n" + 
								"10 - 11 12\r\n" + 
								"11 - 10\r\n" + 
								"12 - 13 10\r\n" + 
								"13 - 12\r\n" + 
								"14 - 9";

		String[] representacaoSplit = representacaoAl.split(" ");
		String[] originalSplit = novo.graphRepresentation(graph, "AL").split(" ");
		
		assertEquals(representacaoSplit.length, originalSplit.length);

		for (int i = 0; i < originalSplit.length; i++) {
			assertEquals(representacaoSplit[i], originalSplit[i]);
		}
	}
	
	@Test
	public void representacaoAm() {
		String representacaoAm = "0 1 2 3 4 5 6 7 8 9 10 11 12 13 14";
		
		String[] representacaoSplit = representacaoAm.split(" ");
		String[] originalSplit = novo.graphRepresentation(graph, "AM").split(" ");
		
		for (int i = 0; i < representacaoSplit.length; i++) {			
			assertEquals(representacaoSplit[i], originalSplit[i]);
		}
	}
	
	@Test
	public void menorCaminho() {
		Vertice vertice1 = new Vertice(1);
		Vertice vertice2 = new Vertice(8);
		
		String menorCaminho = "1 2 3 7 8";

		String[] menorCaminhoSplit = menorCaminho.split(" ");
		String[] caminhoOriginalSplit = graph.shortestPath(vertice1, vertice2).split(" ");
		
		for (int i = 0; i < caminhoOriginalSplit.length; i++) {
			assertEquals(menorCaminhoSplit[i], caminhoOriginalSplit[i]);
		}
	}
	
	@Test
	public void menorCaminhoDeVerticeDesconectados() {
		Vertice vertice1 = new Vertice(1);
		Vertice vertice2 = new Vertice(14);
		
		assertEquals(null ,graph.shortestPath(vertice1, vertice2));
	}
	
	@Test
	public void dfs() {
		String dfs = 	"1 - 0 -\r\n" + 
						"2 - 1 1\r\n" + 
						"3 - 2 2\r\n" + 
						"4 - 3 3\r\n" + 
						"5 - 4 4\r\n" + 
						"6 - 4 4\r\n" + 
						"7 - 3 3\r\n" + 
						"8 - 4 7";
		
		String[] dfsSplit = dfs.split(" ");
		String[] originalSplit = graph.DFS(1).split(" ");
		
		for (int i = 0; i < dfsSplit.length; i++) {
			assertEquals(dfsSplit[i], originalSplit[i]);
		}
		
	}
	
	@Test
	public void bfs() {
		String bfs = 	"1 - 0 -\r\n" + 
						"2 - 1 1\r\n" + 
						"3 - 2 2\r\n" + 
						"4 - 3 3\r\n" + 
						"5 - 3 3\r\n" + 
						"6 - 4 4\r\n" + 
						"7 - 3 3\r\n" + 
						"8 - 4 7";
		
		String[] bfsSplit = bfs.split(" ");
		String[] originalSplit = graph.BFS(1).split(" ");

		System.out.println(graph.BFS(1));
		
		for (int i = 0; i < bfsSplit.length; i++) {
			assertEquals(bfsSplit[i], originalSplit[i]);
		}

	}
	
	@Test
	public void mst() {
		// o metodo nao foi implementado
		assertEquals(true, false);
	}

}