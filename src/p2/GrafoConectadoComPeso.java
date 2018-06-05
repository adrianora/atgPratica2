package p2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.DecimalFormat;

import org.junit.Test;

import grafo.Graph;
import grafo.Vertice;
import main.GraphLib;

// ESSA CLASSE EH APENAS UMA DEMONSTRACAO DE COMO ITERAR SOBRE O JAR!!!!
public class GrafoConectadoComPeso {

	GraphLib novo;
	String path = "grafos/grafo1.txt";
	Graph graph;
	
	public GrafoConectadoComPeso() {
		
		novo = new GraphLib();
		this.graph = novo.readGraph(path);
	}

	@Test
	public void vertexNumber() {
	
		assertEquals(5, novo.getVertexNumber(graph));
	
	}
		
	@Test
	public void testGetEdgeNumber() {
		
		assertEquals(5, novo.getEdgeNumber(graph));
	}
	
	@Test
	public void testGetMeanEdge() {
		
		DecimalFormat df = new DecimalFormat("0.#");
		String saida = df.format(novo.getMeanEdge(graph));
		assertEquals("1.72", saida);		
	}
	
	@Test
	public void testConnected() {
		
		assertEquals(true, novo.connected(graph));
		
	}
	
	@Test
	public void testGraphRepresentation() {
		
		String saida1 = "0 1 2 3 4 5\n"
				+ "1 0 0,1 0 0 1\n"
				+ "2 0,1 0 0 0 0,2\n"
				+ "3 0 0 0 0 5\n"
				+ "4 0 0 0 0 2\n"
				+ "5 1 0,2 5 2 0\n";
		
		//System.out.println(novo.graphRepresentation(graph, "AM"));
		//System.out.println('\n');
		//System.out.println(saida1); 

		assertTrue(saida1.equals(novo.graphRepresentation(graph, "AM")));
	
	}
	
	@Test 
	public void testGraphRepresentation2() {
		
		String saida2 = "1 - 2(0,1) 5(1)\n"
				+ "2 - 1(0,1) 5(0,2)\n"
				+ "3 - 5(5)\n"
				+ "4 - 5(2)\n"
				+ "5 - 1(1) 2(0,2) 4(2) 3(5)\n";
		
		//System.out.println(saida2);
		//System.out.println('\n');
		//System.out.println(novo.graphRepresentation(graph, "AL"));

		assertTrue(saida2.equals(novo.graphRepresentation(graph, "AL")));
	}
	
	@Test
	public void testBFS() {
		
		String tree = "1 - 0 -\n"
				+ "2 - 1 1\n"
				+ "3 - 2 5\n"
				+ "4 - 2 5\n"
				+ "5 - 1 1\n";
		
		
		/*System.out.println(tree);
		System.out.println('\n');
		System.out.println(novo.BFS(graph, 1));*/
		
		assertTrue(tree.equals(novo.BFS(graph, 1)));
	}
	
	@Test
	public void testDFS() {
		
		String tree2 = "1 - 0 -\n"
				+ "2 - 1 1\n"
				+ "3 - 3 5\n"
				+ "4 - 3 5\n"
				+ "5 - 2 2\n";
		
		/*System.out.println(tree2);
		System.out.println('\n');
		System.out.println(novo.DFS(graph, 1));*/
		
		assertTrue(tree2.equals(novo.DFS(graph, 1)));
	}
	
	@Test
	public void testShortestPath() {
		
		String shortestPath = "1 5 4";
		String shortestPath2 = "1 5 3";
		
		Vertice v = new Vertice(1);
		Vertice vFinal = new Vertice(4);
		Vertice vFinal2 = new Vertice(3);
		
		assertTrue(shortestPath.equals(graph.shortestPath(v, vFinal)));
		assertTrue(shortestPath2.equals(graph.shortestPath(v, vFinal2)));
	}
}

