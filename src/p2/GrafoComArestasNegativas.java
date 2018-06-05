package p2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.DecimalFormat;

import org.junit.Test;

import grafo.Graph;
import grafo.Vertice;
import main.GraphLib;

public class GrafoComArestasNegativas {

	GraphLib novo;
	String path = "grafos/grafoComArestasNegativas.txt";
	Graph graph;
	
	public GrafoComArestasNegativas() {
		
		novo = new GraphLib();
		this.graph= novo.readGraph(path);
		
	}
	
	@Test
	public void vertexNumber() {
	
		assertEquals(4, novo.getVertexNumber(graph));
	
	}
	
	@Test
	public void testGetEdgeNumber() {
		
		assertEquals(3, novo.getEdgeNumber(graph));
	}
	
	@Test
	public void testGetMeanEdge() {
		
		Graph grafo2 = novo.readGraph(path);
		DecimalFormat df = new DecimalFormat("0.#");
		String saida = df.format(novo.getMeanEdge(grafo2));
		assertEquals("-8", saida, 0);		
	}
	
	@Test
	public void testConnected() {
		
		assertEquals(true, novo.connected(graph));
		
	}
	
	@Test
	public void testGraphRepresentation() {
		
		String saida1 = "0 1 2 4\n"
				+ "1 0 -2 0 0\n"
				+ "2 -2 0 -7 0\n"
				+ "3 0 -7 0 1\n"
				+ "4 0 0 1 0\n";	
		

		//assertTrue(saida1.equals(novo.graphRepresentation(graph, "AM")));
	
	}
	
	@Test 
	public void testGraphRepresentation2() {
		
		String saida2 = "1 - 2(-2)\n"
				+ "2 - 1(-2) 3(-7)\n"
				+ "3 - 2(-7) 4(1)\n"
				+ "4 - 3(1)\n";
		
		
		//assertTrue(saida2.equals(novo.graphRepresentation(graph, "AL")));
	}
	
	@Test
	public void testBFS() {
		
		String tree = "1 - 0 -\n"
				+ "2 - 1 1\n"
				+ "3 - 2 2\n"
				+ "4 - 3 3\n";
		
		//assertTrue(tree.equals(novo.BFS(graph, 1)));
	}
	
	@Test
	public void testDFS() {
		
		String tree2 = "1 - 0 -\n"
				+ "2 - 1 1\n"
				+ "3 - 2 2\n"
				+ "4 - 3 3\n";
		
		
		//assertTrue(tree2.equals(novo.DFS(graph, 1)));
	
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


