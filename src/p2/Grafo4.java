package p2;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import grafo.Graph;
import grafo.Vertice;
import main.GraphLib;

public class Grafo4 {
	
	GraphLib novo;
	String path = "grafos/grafo4.txt";
	Graph graph;
	
	public Grafo4() {
		
		novo = new GraphLib();
		this.graph = novo.readGraph(path);
	}
	
	@Test
	public void vertexNumber() {
	
		assertEquals(3, novo.getVertexNumber(graph));
	}
	
	@Test
	public void testGetEdgeNumber() {
		
		assertEquals(3, novo.getEdgeNumber(graph));	
	}
	
	@Test
	public void testConnected() {
		
		assertTrue(novo.connected(graph));
		
	}
	
	@Test
	public void testGraphRepresentation() {
		
		String saida1 = "0 1 2 3\n"
				+ "1 0 1 1\n"
				+ "2 1 0 1\n"
				+ "3 1 1 0";
		
		/*System.out.println(novo.graphRepresentation(graph, "AM"));
		System.out.println('\n');
		System.out.println(saida1); */

		assertTrue(saida1.equals(novo.graphRepresentation(graph, "AM")));
	}
	
	@Test 
	public void testGraphRepresentation2() {
		
		String saida2 = "1 - 2 3\n"
				+ "2 - 1 3\n"
				+ "3 - 2 1";
		
			System.out.println(saida2);
		System.out.println('\n');
		System.out.println(novo.graphRepresentation(graph, "AL"));

		assertTrue(saida2.equals(novo.graphRepresentation(graph, "AL")));
	}
	
	@Test
	public void testShortestPath() {
		
		String shortestPath = "1 3";
		String shortestPath2 = "1 2";
		
		Vertice v = new Vertice(1);
		Vertice vFinal = new Vertice(3);
		Vertice vFinal2 = new Vertice(2);
		
		assertTrue(shortestPath.equals(graph.shortestPath(v, vFinal)));
		assertTrue(shortestPath2.equals(graph.shortestPath(v, vFinal2)));
	
	}

}
