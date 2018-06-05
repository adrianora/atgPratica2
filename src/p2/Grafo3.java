package p2;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import grafo.Graph;
import grafo.Vertice;
import main.GraphLib;

public class Grafo3 {
	
	GraphLib novo;
	String path = "grafos/grafo3.txt";
	Graph graph;
	
	public Grafo3() {
		
		novo = new GraphLib();
		this.graph = novo.readGraph(path);
	}
	
	@Test
	public void vertexNumber() {
	
		assertEquals(6, novo.getVertexNumber(graph));
	}
	
	@Test
	public void testGetEdgeNumber() {
		
		assertEquals(5, novo.getEdgeNumber(graph));	
	}
	
	@Test
	public void testConnected() {
		
		assertTrue(novo.connected(graph));
		
	}
	
	@Test
	public void testGraphRepresentation() {
		
		String saida1 = "0 1 2 3 4 5 6\n"
				+ "1 0 1 0 0 0 0\n"
				+ "2 1 0 1 0 0 0\n"
				+ "3 0 1 0 1 0 0\n"
				+ "4 0 0 1 0 1 0\n"
				+ "5 0 0 0 1 0 1\n"
				+ "6 0 0 0 0 1 0";	
		
		/*System.out.println(novo.graphRepresentation(graph, "AM"));
		System.out.println('\n');
		System.out.println(saida1); */

		assertTrue(saida1.equals(novo.graphRepresentation(graph, "AM")));
	}
	
	@Test 
	public void testGraphRepresentation2() {
		
		String saida2 = "1 - 2\n"
				+ "2 - 1 3\n"
				+ "3 - 2 4\n"
				+ "4 - 3 5\n"
				+ "5 - 4 6\n"
				+ "6 - 5";
		
		/*	System.out.println(saida2);
		System.out.println('\n');
		System.out.println(novo.graphRepresentation(graph, "AL"));*/

		assertTrue(saida2.equals(novo.graphRepresentation(graph, "AL")));
	}
	
	@Test
	public void testShortestPath() {
		
		String shortestPath = "1 2 3";
		String shortestPath2 = "1 2 3 4";
		
		Vertice v = new Vertice(1);
		Vertice vFinal = new Vertice(3);
		Vertice vFinal2 = new Vertice(4);
		
		assertTrue(shortestPath.equals(graph.shortestPath(v, vFinal)));
		assertTrue(shortestPath2.equals(graph.shortestPath(v, vFinal2)));
	
	}

}
