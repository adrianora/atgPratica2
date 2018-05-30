package p2;

import static org.junit.Assert.assertEquals;

import java.text.DecimalFormat;

import org.junit.Test;

import grafo.Graph;
import main.GraphLib;

// ESSA CLASSE EH APENAS UMA DEMONSTRACAO DE COMO ITERAR SOBRE O JAR!!!!
public class Suite {

	GraphLib novo;
	String path = "grafos/grafo1.txt";
	String path2 = "grafos/grafo2.txt";

	public Suite() {
		novo = new GraphLib();
	}

	@Test
	public void vertexNumber() {
		Graph graph = novo.readGraph(path);
		System.out.println(novo.getVertexNumber(graph));
		
		assertEquals(5, novo.getVertexNumber(graph));
	}
	
//	@Test
//	public void vertexNumber2() {
//		
//		Graph graph2 = novo.readGraph(path2);
//		System.out.println(novo.getVertexNumber(graph2));
//		assertEquals(5, novo.getVertexNumber(graph2));
//	}
	
	@Test
	public void testGetEdgeNumber() {
		
		Graph graph1 = novo.readGraph(path);
		novo.getEdgeNumber(graph1);
		assertEquals(5, novo.getEdgeNumber(graph1));
	}
	
	@Test
	public void testGetMeanEdge() {
		
		Graph grafo2 = novo.readGraph(path);
		DecimalFormat df = new DecimalFormat("0.#");
		String saida = df.format(novo.getMeanEdge(grafo2));
		//falta verificar como é feito esse calculo
		assertEquals("2", saida);		
	}
		
	
	
	

}
