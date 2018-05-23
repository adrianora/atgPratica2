package p2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import grafo.Graph;
import main.GraphLib;

// ESSA CLASSE EH APENAS UMA DEMONSTRACAO DE COMO ITERAR SOBRE O JAR!!!!
public class Suite {

	GraphLib novo;
	String path = "grafos/grafo1.txt";

	public Suite() {
		novo = new GraphLib();
	}

	@Test
	public void vertexNumber() {
		Graph graph = novo.readGraph(path);
		System.out.println(novo.getVertexNumber(graph));
		
		assertEquals(5, novo.getVertexNumber(graph));
	}

}
