package p2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.DecimalFormat;

import org.junit.Test;

import grafo.Graph;
import grafo.Vertice;
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
	
		assertEquals(5, novo.getVertexNumber(graph));
	
	}
	
	@Test
	public void testGraphRepresentation() {

		String saida1 = "0 1 2 3 4 5\n" 
				+ "1 0 1 0 0 1\n" 
				+ "2 1 0 0 0 1\n" 
				+ "3 0 0 0 0 1\n"
				+ "4 0 0 0 0 1\n" 
				+ "5 1 1 1 1 0\n";

		
		//System.out.println(novo.graphRepresentation(graph, "AM"));
		//System.out.println('\n');
		//System.out.println(saida1);
		
		assertTrue(saida1.equals(novo.graphRepresentation(graph, "AM")));

	}

	@Test
	public void testGraphRepresentation2() {

		String saida2 =   "1 - 2 5\n" 
						+ "2 - 1 5\n" 
						+ "3 - 5\n" 
						+ "4 - 5\n" 
						+ "5 - 1 2 4 3\n";
		
		
		// System.out.println(saida2); System.out.println('\n');
		// System.out.println(novo.graphRepresentation(graph, "AL"));
		

		assertTrue(saida2.equals(novo.graphRepresentation(graph, "AL")));
	}

	
	@Test
	public void testBFS() {

		String tree = "1 - 0 -\n" 
					+ "2 - 1 1\n" 
					+ "3 - 2 5\n" 
					+ "4 - 2 5\n" 
					+ "5 - 1 1\n";

		
		//System.out.println(tree); 
		//System.out.println('\n');
		//System.out.println(novo.BFS(graph, 1));
		 

		// Lança a exception ArrayIndexOutOfBoundsException
		 assertTrue(tree.equals(novo.BFS(graph, 1)));
	}

	@Test
	public void testDFS() {

		String tree2 = "1 - 0 -\n" 
						+ "2 - 1 1\n" 
						+ "3 - 2 5\n" 
						+ "4 - 2 5\n" 
						+ "5 - 1 1\n";

		
		//System.out.println(tree2); System.out.println('\n');
		//System.out.println(novo.DFS(graph, 1));
		 

		// Lança a exception ArrayIndexOutOfBoundsException
		assertTrue(tree2.equals(novo.DFS(graph, 1)));

	}
	
	@Test
	public void testShortestPath() {
 
		String shortestPath = "1 5 4";
		String shortestPath2 = "1 5 3";

		Vertice v = new Vertice(1);
		Vertice vFinal = new Vertice(4);
		Vertice vFinal2 = new Vertice(3);

		assertTrue(shortestPath.equals(graph.shortestPath(v, vFinal)));
		assertTrue(shortestPath2.equals(graph.shortestPath(v, vFinal2)));
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
		assertEquals("0", saida);		
	}
	
	@Test
	public void testConnected() {
		
		assertEquals(true, novo.connected(graph));
		
	}
	
	

}
