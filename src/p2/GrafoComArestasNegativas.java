package p2;

import static org.junit.Assert.assertEquals;

import java.text.DecimalFormat;

import org.junit.Test;

import grafo.Graph;
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
}


