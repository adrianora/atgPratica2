package p2;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import grafo.Graph;
import grafo.Vertice;
import main.GraphLib;

public class GrafoComPeso2 {
	
	GraphLib novo;
	String path = "grafos/grafoComPeso.txt";
	Graph graph;
	
	public GrafoComPeso2() {
		
		novo = new GraphLib();
		this.graph = novo.readGraph(path);
	}
	
	@Test
	public void vertexNumber() {
	
		assertEquals(6, novo.getVertexNumber(graph));
	}
	
	@Test
	public void testGetEdgeNumber() {
		
		assertEquals(8, novo.getEdgeNumber(graph));	
	}
	
	@Test
	public void testGetMeanEdge() {
		
		
		float saida = novo.getMeanEdge(graph);
		Assert.assertEquals(15.375, saida, 0.001);		
	}
	
	@Test
	public void testConnected() {
		
		assertTrue(novo.connected(graph));
		
	}
	
	@Test
	public void testGraphRepresentation() {
		
		String saida1 = "0 0 1 2 3 4 5\n"
				+ "0 0 40 20 0 0 2\n"
				+ "1 40 0 10 0 0 0\n"
				+ "2 20 10 0 10 25 0\n"
				+ "3 0 0 10 0 1 0\n"
				+ "4 0 0 25 1 0 15\n"
				+ "5 2 0 0 0 15 0";	
		
		/*System.out.println(novo.graphRepresentation(graph, "AM"));
		System.out.println('\n');
		System.out.println(saida1); */

		assertTrue(saida1.equals(novo.graphRepresentation(graph, "AM")));
	
	}
	
	@Test 
	public void testGraphRepresentation2() {
		
		String saida2 = "0 - 1(40) 2(20) 5(2)\n"
				+ "1 - 0(40) 2(10)\n"
				+ "2 - 0(20) 1(10) 3(10) 4(25)\n"
				+ "3 - 2(10) 4(1)\n"
				+ "4 - 2(25) 3(1) 5(15)\n"
				+ "5 - 0(2) 4(15)";
		
		/*	System.out.println(saida2);
		System.out.println('\n');
		System.out.println(novo.graphRepresentation(graph, "AL"));*/

		assertTrue(saida2.equals(novo.graphRepresentation(graph, "AL")));
	}
	
	@Test
	public void testBFS() {
		
		String tree = "0 - 0 -\n"
				+ "1 - 1 0\n"
				+ "2 - 1 0\n"
				+ "3 - 2 2\n"
				+ "4 - 2 2\n"
				+ "5 - 1 0";
		
		
	/*	System.out.println(tree);
		System.out.println('\n');
		System.out.println(novo.BFS(graph, 1));*/
		
		//Lança a exception ArrayIndexOutOfBoundsException
		assertTrue(tree.equals(novo.BFS(graph, 1)));
	}
	
	@Test
	public void testDFS() {
		
		String tree2 = "0 - 0 -\n"
				+ "1 - 1 0\n"
				+ "2 - 2 1\n"
				+ "3 - 4 4\n"
				+ "4 - 3 2\n"
				+ "5 - 4 4";
		
		/*System.out.println(tree2);
		System.out.println('\n');
		System.out.println(novo.DFS(graph, 1));*/
		
		//Lança a exception ArrayIndexOutOfBoundsException
		assertTrue(tree2.equals(novo.DFS(graph, 1)));
	}
	
	@Test
	public void testShortestPath() {
		
		String shortestPath = "0 2 1";
		String shortestPath2 = "0 5 4 3";
		
		Vertice v = new Vertice(0);
		Vertice vFinal = new Vertice(1);
		Vertice vFinal2 = new Vertice(3);
		
		assertTrue(shortestPath.equals(graph.shortestPath(v, vFinal)));
		assertTrue(shortestPath2.equals(graph.shortestPath(v, vFinal2)));
	}
	
	@Test
	public void testMFS() {
		
		//Método não implementado
		assertTrue(false);
	}

}
