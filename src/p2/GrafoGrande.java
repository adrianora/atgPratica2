package p2;

import static org.junit.Assert.assertEquals;

import java.text.DecimalFormat;

import org.junit.Test;

import grafo.Graph;
import main.GraphLib;

public class GrafoGrande {

	GraphLib novo;
	String path2 = "grafos/grafoGrande.txt";
	Graph graph;

	public GrafoGrande() {

		novo = new GraphLib();
		this.graph = novo.readGraph(path2);

	}

	@Test
	public void vertexNumber() {

		assertEquals(21, novo.getVertexNumber(graph));

	}

	@Test
	public void testGetEdgeNumber() {

		assertEquals(25, novo.getEdgeNumber(graph));
	}

	@Test
	public void testGetMeanEdge() {

		DecimalFormat df = new DecimalFormat("0.#");
		String saida = df.format(novo.getMeanEdge(graph));
		assertEquals("1", saida);
	}

	@Test
	public void testConnected() {

		assertEquals(true, novo.connected(graph));

	}

}
