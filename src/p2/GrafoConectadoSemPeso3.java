package p2;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import grafo.Graph;
import grafo.Vertice;
import main.GraphLib;

public class GrafoConectadoSemPeso3 {

	GraphLib novo;
	String path = "grafos/grafo2.txt";
	Graph graph;

	public GrafoConectadoSemPeso3() {

		novo = new GraphLib();
		this.graph = novo.readGraph(path);

	}

	@Test
	public void vertexNumber() {

		assertEquals(11, novo.getVertexNumber(graph));

	}

	@Test
	public void testGetEdgeNumber() {

		assertEquals(17, novo.getEdgeNumber(graph));
	}

	@Test
	public void testGetMeanEdge() {

		float saida = novo.getMeanEdge(graph);
		assertEquals(1, saida);

	}

	@Test
	public void testConnected() {

		assertTrue(novo.connected(graph));

	}

	@Test
	public void testGraphRepresentation() {

		String saida1 = "0 0 1 2 3 4 5 6 7 8 9 10\n" 
				+ "0 0 0 1 1 0 0 0 0 0 0 0\n" 
				+ "1 0 0 1 0 1 0 0 0 1 0 0\n" 
				+ "2 1 1 0 1 0 0 0 0 1 0 0\n"
				+ "3 1 0 1 0 0 0 0 0 1 0 0\n" 
				+ "4 0 1 0 0 0 1 0 1 0 1 1\n" 
				+ "5 0 0 0 0 1 0 1 0 0 1 0\n" 
				+ "6 0 0 0 0 0 1 0 0 0 1 0\n"
				+ "7 0 0 0 0 1 0 0 0 0 0 1\n"
				+ "8 0 1 1 1 0 0 0 0 0 0 1\n"
				+ "9 0 0 0 0 1 1 1 0 0 0 0\n"
				+ "10 0 0 0 0 1 0 0 1 1 0 0\n";

		
		/*System.out.println(novo.graphRepresentation(graph, "AM"));
		System.out.println('\n');
		System.out.println(saida1);
		*/
		assertTrue(saida1.equals(novo.graphRepresentation(graph, "AM")));

	}

	@Test
	public void testGraphRepresentation2() {

		String saida2 = "0 - 2(1) 3(1)\n" 
						+ "1 - 2(1) 4(1) 8(1)\n" 
						+ "2 - 0(1) 1(1) 3(1) 8(1)\n" 
						+ "3 - 0(1) 2(1) 8(1)\n" 
						+ "4 - 1(1) 5(1) 7(1) 9(1) 10(1)\n" 
						+ "5 - 4(1) 6(1) 9(1)\n"
						+ "6 - 5(1) 9(1)\n" 
						+ "7 - 4(1) 10(1)\n"
						+"8 - 1(1) 2(1) 3(1) 10(1)\n"
						+"9 - 4(1) 5(1) 6(1)\n"
						+"10 - 4(1) 7(1) 8(1)";
		
		
		// System.out.println(saida2); System.out.println('\n');
		// System.out.println(novo.graphRepresentation(graph, "AL"));
		

		assertTrue(saida2.equals(novo.graphRepresentation(graph, "AL")));
	}

	@Test
	public void testBFS() {

		String tree = "1 - 0 -\n" 
					+ "2 - 1 1\n" 
					+ "4 - 3 30\n" 
					+ "5 - 2 2\n" 
					+ "7 - 2 99\n" 
					+ "18 - 3 7\n"
					+ "30 - 2 99\n" 
					+ "99 - 1 1";

		
		// System.out.println(tree); 
		// System.out.println('\n');
		// System.out.println(novo.BFS(graph, 1));
		 

		// Lança a exception ArrayIndexOutOfBoundsException
		 assertTrue(tree.equals(novo.BFS(graph, 1)));
	}

	@Test
	public void testDFS() {

		String tree2 = "1 - 0 -\n" 
						+ "2 - 1 1\n" 
						+ "4 - 3 30\n" 
						+ "5 - 2 2\n" 
						+ "7 - 5 18\n" 
						+ "18 - 4 4\n"
						+ "30 - 2 99\n" 
						+ "99 - 1 1";

		
		// System.out.println(tree2); System.out.println('\n');
		// System.out.println(novo.DFS(graph, 1));
		 

		// Lança a exception ArrayIndexOutOfBoundsException
		assertTrue(tree2.equals(novo.DFS(graph, 1)));

	}

	@Test
	public void testShortestPath() {

		String shortestPath = "0 2 1 4 5 6";
		String shortestPath2 = "0 2 1 4 7";

		Vertice v = new Vertice(0);
		Vertice vFinal = new Vertice(6);
		Vertice vFinal2 = new Vertice(7);

		assertTrue(shortestPath.equals(graph.shortestPath(v, vFinal)));
		assertTrue(shortestPath2.equals(graph.shortestPath(v, vFinal2)));
	}

	@Test
	public void testMFS() {

		// Método não implementado
		// assertTrue(false);
	}

}
