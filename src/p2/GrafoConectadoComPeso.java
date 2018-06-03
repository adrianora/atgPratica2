package p2;

import static org.junit.Assert.assertEquals;

import java.text.DecimalFormat;

import org.junit.Test;

import grafo.Graph;
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
}

