package p2;

import static org.junit.Assert.assertEquals;

import java.text.DecimalFormat;

import org.junit.Test;

import grafo.Graph;
import main.GraphLib;

public class GrafoConectadoSemPeso {
	
	GraphLib novo;
	String path2 = "grafos/grafoSemPeso.txt";
	Graph graph;
	
	public GrafoConectadoSemPeso() {
		
		novo = new GraphLib();
		this.graph= novo.readGraph(path2);
	
	}
	
	@Test
	public void vertexNumber() {
	
		System.out.println(novo.readGraph(path2));
		assertEquals(5, novo.getVertexNumber(graph));
	
	}
	
	@Test
	public void testGetEdgeNumber() {
		
		assertEquals(5, novo.getEdgeNumber(graph));
	}
	
	@Test
	public void testGetMeanEdge() {
		
		Graph grafo2 = novo.readGraph(path2);
		DecimalFormat df = new DecimalFormat("0.#");
		String saida = df.format(novo.getMeanEdge(grafo2));
		System.out.println(saida);
		assertEquals("0", saida);		
	}
	
	@Test
	public void testConnected() {
		
		assertEquals(true, novo.connected(graph));
		
	}
	
	

}
