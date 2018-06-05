package p2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import grafo.Graph;
import grafo.Vertice;
import main.GraphLib;

public class GrafoDesconexoComPesosNegativos {

	GraphLib novo;
	String path = "grafos/grafoDesconexComPesosNegativos.txt";
	Graph graph;
	
	public GrafoDesconexoComPesosNegativos() {
		
		novo = new GraphLib();
		this.graph = novo.readGraph(path);
	}
	
	@Test
	public void vertexNumber() {
	
		assertEquals(9, novo.getVertexNumber(graph));
	}
	
	@Test
	public void testGetEdgeNumber() {
		
		assertEquals(9, novo.getEdgeNumber(graph));	
	}
	
	@Test
	public void testGetMeanEdge() {
		
		float saida = novo.getMeanEdge(graph);
		Assert.assertEquals(108.4, saida, 0.1);		
	}
	
	@Test
	public void testConnected() {
		
		assertFalse(novo.connected(graph));
	}
	
	@Test
	public void testGraphRepresentation() {
		
		String saida1 = "0 1 2 3 4 5 6 7 8 9\n"
				+ "1 0 20 -10 0 0 0 0 0 0\n"
				+ "2 20 0 0 -0.1 3.5 0 0 0 0\n"
				+ "3 -10 0 0 0 0 97 0 0 0\n"
				+ "4 0 -0.1 0 0 0 0 0 0 4\n"
				+ "5 0 3.5 0 0 0 0 0 0 -2\n"
				+ "6 0 0 97 0 0 -25 0 0 0\n"
				+ "7 0 0 0 0 0 0 0 -4 0\n"
				+ "8 0 0 0 0 0 0 -4 0 0\n"
				+ "9 0 0 0 4 -2 0 0 0 0\n";	
		
		/*System.out.println(novo.graphRepresentation(graph, "AM"));
		System.out.println('\n');
		System.out.println(saida1);*/

		assertTrue(saida1.equals(novo.graphRepresentation(graph, "AM")));
	}
	
	@Test 
	public void testGraphRepresentation2() {
		
		String saida2 = "1 - 2(20) 3(-10)\n"
				+ "2 - 1 (20) 4(-0.1) 5(3.5)\n"
				+ "3 - 1(-10) 6(97)\n"
				+ "4 - 2(-0.1) 9(4)\n"
				+ "5 - 2(3.5) 9(-2)\n"
				+ "6 - 3(-10) 6(97)\n"
				+ "7 - 8(-4)\n"
				+ "8 - 7(-4)\n"
				+ "9 - 4(4) 5(-2)";
		
		/*	System.out.println(saida2);
		System.out.println('\n');
		System.out.println(novo.graphRepresentation(graph, "AL"));*/

		assertTrue(saida2.equals(novo.graphRepresentation(graph, "AL")));
	}
	
	@Test
	public void testBFS() {
		
		String tree = "1 - 0 -\n"
				+ "2 - 1 1\n"
				+ "3 - 1 1\n"
				+ "4 - 2 2\n"
				+ "5 - 2 2\n"
				+ "6 - 2 3\n"
				+ "9 - 3 4";
		
		
		/*System.out.println(tree);
		System.out.println('\n');
		System.out.println(novo.BFS(graph, 1));*/

		assertTrue(tree.equals(novo.BFS(graph, 1)));
	}
	
	@Test
	public void testDFS() {
		
		String tree2 = "1 - 0 -\n"
				+ "2 - 1 1\n"
				+ "3 - 1 1\n"
				+ "4 - 3 2\n"
				+ "5 - 4 9\n"
				+ "6 - 2 3\n"
				+ "9 - 3 4";
		
		/*System.out.println(tree2);
		System.out.println('\n');
		System.out.println(novo.DFS(graph, 1));*/
		
		assertTrue(tree2.equals(novo.DFS(graph, 1)));
	}
	
	// A biblioteca entra em loop infinito
	@Test
	public void testShortestPath() {
		
		String shortestPath = "1 2 5 9";
		String shortestPath2 = "1 3 6";
		
		Vertice v = new Vertice(1);
		Vertice vFinal = new Vertice(9);
		Vertice vFinal2 = new Vertice(6);
		
	//	assertTrue(shortestPath.equals(graph.shortestPath(v, vFinal)));
	//	assertTrue(shortestPath2.equals(graph.shortestPath(v, vFinal2)));
		assertTrue(false);
	}
	
}