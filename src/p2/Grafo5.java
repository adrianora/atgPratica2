package p2;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import grafo.Graph;
import main.GraphLib;

public class Grafo5 {

	
	GraphLib novo;
	String path = "grafos/grafo5.txt";
	Graph graph;
	
	public Grafo5() {
		
		novo = new GraphLib();
		this.graph = novo.readGraph(path);
	}
	
	@Test
	public void vertexNumber() {
	
		assertEquals(3, novo.getVertexNumber(graph));
	}
	
	@Test
	public void testGetEdgeNumber() {
		
		assertEquals(4, novo.getEdgeNumber(graph));	
	}
	
	@Test
	public void testConnected() {
		
		assertTrue(novo.connected(graph));
		
	}
}
