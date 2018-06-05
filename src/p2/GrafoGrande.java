package p2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.DecimalFormat;

import org.junit.Test;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import grafo.Graph;
import grafo.Vertice;
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
	
	@Test
	public void testGraphRepresentation() {
		
		String saida1 = "0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21\n"
				+ "1 0 1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n"
				+ "2 1 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n"
				+ "3 1 1 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n"
				+ "4 0 0 1 0 1 1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n"
				+ "5 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n"
				+ "6 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n"
				+ "7 0 0 0 1 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0\n"
				+ "8 0 0 0 0 0 0 1 0 1 0 0 0 0 0 1 0 0 0 0 0 0\n"
				+ "9 0 0 0 0 0 0 0 1 0 1 0 0 0 1 0 0 0 0 0 0 0\n"
				+ "10 0 0 0 0 0 0 0 0 1 0 1 0 1 0 0 0 0 0 0 0 0\n"
				+ "11 0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0\n"
				+ "12 0 0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0 1\n"
				+ "13 0 0 0 0 0 0 0 0 0 1 0 1 0 1 0 0 0 0 0 0 0\n"
				+ "14 0 0 0 0 0 0 0 0 1 0 0 0 1 0 1 0 0 0 0 0 0\n"
				+ "15 0 0 0 0 0 0 0 1 0 0 0 0 0 1 0 1 0 0 0 0 0\n"
				+ "16 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 1 1 0 0 0\n"
				+ "17 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0\n"
				+ "18 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 1 0 0\n"
				+ "19 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 1 0\n"
				+ "20 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 1\n"
				+ "21 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 1 0";	

		assertTrue(saida1.equals(novo.graphRepresentation(graph, "AM")));
	
	}
	
	@Test 
	public void testGraphRepresentation2() {
		
		String saida2 = "1 - 2(1) 3(1)\n"
				+ "2 - 1(1) 3(1)\n"
				+ "3 - 1(1) 2(1) 4(1)\n"
				+ "4 - 3(1) 6(1) 5(1) 7(1)\n"
				+ "5 - 4(1)\n"
				+ "6 - 4(1)\n"
				+ "7 - 4(1) 8(1)\n"
				+ "8 - 7(1) 9(1) 15(1)\n"
				+ "9 - 8(1) 10(1) 14(1)\n"
				+ "10 - 9(1) 13(1) 11(1)\n"
				+ "11 - 10(1) 12(1)\n"
				+ "12 - 11(1) 13(1) 21(1)\n"
				+ "14 - 9(1) 13(1) 15(1)\n"
				+ "15 - 8(1) 14(1) 16(1)\n"
				+ "16 - 15(1) 18(1) 17(1)\n"
				+ "17 - 16(1)\n"
				+ "18 - 16(1) 19(1)\n"
				+ "19 - 18(1) 20(1)\n"
				+ "20 - 19(1) 21(1)\n"
				+ "21 - 12(1) 20(1)";
		
	
		String grafoTeste = novo.graphRepresentation(graph, "AL");
	
		assertEquals(saida2,grafoTeste);
	}
	
	@Test
	public void testBFS() {
		
		String tree = "1 - 0 -\n"
				+ "1 - 1 0\n"
				+ "2 - 1 1\n"
				+ "3 - 1 1\n"
				+ "4 - 2 3\n"
				+ "5 - 3 4\n"
				+ "6 - 3 4\n"
				+ "7 - 3 4\n"
				+ "8 - 4 7\n"
				+ "9 - 5 8\n"
				+ "10 - 6 9\n"
				+ "11 - 7 10\n"
				+ "12 - 8 13\n"
				+ "13 - 7 10\n"
				+ "14 - 6 9\n"
				+ "15 - 5 8\n"
				+ "16 - 6 15\n"
				+ "17 - 7 16\n"
				+ "18 - 7 16\n"
				+ "19 - 8 18\n"
				+ "20 - 9 19\n"
				+ "21 - 9 12\n";
		
		
		
		String grafoTeste = novo.BFS(graph, 1);
		assertEquals(tree, grafoTeste);
	}
	
	@Test
	public void testDFS() {
		
		String tree2 = "1 - 0 -\n"
				+ "2 - 1 1\n"
				+ "3 - 2 2\n"
				+ "4 - 3 3\n"
				+ "5 - 4 4\n"
				+ "6 - 4 4"
				+ "7 - 4 4\n"
				+ "8 - 5 7\n"
				+ "9 - 6 8\n"
				+ "10 - 7 9\n"
				+ "11 - 10 12\n"
				+ "12 - 9 13\n"
				+ "13 - 8 10\n"
				+ "14 - 16 15\n"
				+ "15 - 15 16\n"
				+ "16 - 14 18"
				+ "17 - 15 16\n"
				+ "18 - 13 19\n"
				+ "19 - 12 20\n"
				+ "20 - 11 21\n"
				+ "21 - 10 12";
		
		
		assertTrue(tree2.equals(novo.DFS(graph, 1)));
	}
	
	@Test
	public void testShortestPath() {
		
		String shortestPath = "1 3 4 7 8 9 14";
		String shortestPath2 = "1 3 4 7 8 9 10 13 12 21";
		
		Vertice v = new Vertice(1);
		Vertice vFinal = new Vertice(14);
		Vertice vFinal2 = new Vertice(21);
		
		assertTrue(shortestPath.equals(graph.shortestPath(v, vFinal)));
		assertTrue(shortestPath2.equals(graph.shortestPath(v, vFinal2)));
	}
	
	@Test
	public void testMFS() {
		
		//Método não foi implementado
		assertTrue(false);
	}

}
