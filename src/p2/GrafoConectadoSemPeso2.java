package p2;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import grafo.Graph;
import grafo.Vertice;
import main.GraphLib;

public class GrafoConectadoSemPeso2 {
	
	GraphLib novo;
	String path = "grafos/grafoSemPeso2.txt";
	Graph graph;
	
	public GrafoConectadoSemPeso2() {
		
		novo = new GraphLib();
		this.graph= novo.readGraph(path);
	
	}
	
	@Test
	public void vertexNumber() {
	
		assertEquals(8, novo.getVertexNumber(graph));
	
	}
	
	@Test
	public void testGetEdgeNumber() {
		
		assertEquals(10, novo.getEdgeNumber(graph));
	}
	
	@Test
	public void testGetMeanEdge() {
		
		float saida = novo.getMeanEdge(graph);
		assertEquals(0, saida);		
	}
	
	@Test
	public void testConnected() {
		
		assertTrue(novo.connected(graph));
		
	}
	
	@Test
	public void testGraphRepresentation() {
		
		String saida1 = "0 1 2 4 5 7 18 30 99\n"
				+ "1 1 1 0 0 0 0 0 1\n"
				+ "2 1 0 0 1 0 0 0 0\n"
				+ "4 0 0 0 0 0 1 1 0\n"
				+ "5 0 1 0 0 0 0 0 0\n"
				+ "7 0 0 0 0 0 1 1 1\n"
				+ "18 0 0 1 0 1 0 0 0\n"
				+ "30 0 0 1 0 1 0 0 1\n"
				+ "99 1 0 0 0 1 0 1 0";	
		
		/*System.out.println(novo.graphRepresentation(graph, "AM"));
		System.out.println('\n');
		System.out.println(saida1); */

		assertTrue(saida1.equals(novo.graphRepresentation(graph, "AM")));
	
	}
	
	@Test 
	public void testGraphRepresentation2() {
		
		String saida2 = "1 - 1 2 99\n"
				+ "2 - 1 5\n"
				+ "4 - 18 30\n"
				+ "5 - 2\n"
				+ "7 - 18 30 99\n"
				+ "18 - 4 7\n"
				+ "30 - 4 7 99\n"
				+ "99 - 1 7 30\n";
		
		/*	System.out.println(saida2);
		System.out.println('\n');
		System.out.println(novo.graphRepresentation(graph, "AL"));*/

		assertTrue(saida2.equals(novo.graphRepresentation(graph, "AL")));
	}
	
	@Test
	public void testBFS() {
		
		String tree = "1 - 0 -\n"
				+ "2 - 1 1\n"
				+ "4 - 3 30\n"
				+ "5 - 2 2\n"
				+ "7 - 2 99\n"
				+ "18 - 3 7\n"
				+ "30 - 2 99\n"
				+ "99 - 1 1";
		
		
		/*System.out.println(tree);
		System.out.println('\n');
		System.out.println(novo.BFS(graph, 1));*/
		
		assertTrue(tree.equals(novo.BFS(graph, 1)));
	}
	
	@Test
	public void testDFS() {
		
		String tree2 = "1 - 0 -\n"
				+ "2 - 1 1\n"
				+ "4 - 3 30\n"
				+ "5 - 2 2\n"
				+ "7 - 5 18\n"
				+ "18 - 4 4\n"
				+ "30 - 2 99\n"
				+ "99 - 1 1";
		
		/*System.out.println(tree2);
		System.out.println('\n');
		System.out.println(novo.DFS(graph, 1));*/
		
		assertTrue(tree2.equals(novo.DFS(graph, 1)));
	
	}
	
	@Test
	public void testShortestPath() {
		
		String shortestPath = "1 99 30 4";
		String shortestPath2 = "1 99 7";
		
		Vertice v = new Vertice(1);
		Vertice vFinal = new Vertice(4);
		Vertice vFinal2 = new Vertice(7);
		
		assertTrue(shortestPath.equals(graph.shortestPath(v, vFinal)));
		assertTrue(shortestPath2.equals(graph.shortestPath(v, vFinal2)));
	}
	
}
