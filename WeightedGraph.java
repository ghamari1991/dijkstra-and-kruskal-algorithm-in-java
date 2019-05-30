public class WeightedGraph {

    private int[][] edges;  // adjacency matrix
    private Object[] labels;

    public WeightedGraph(int n) {
        edges = new int[n][n];
        labels = new Object[n];
    }

    public int size() {
        return labels.length;
    }

    public void setLabel(int vertex, Object label) {
        labels[vertex] = label;
    }

    public Object getLabel(int vertex) {
        return labels[vertex];
    }

    public void addEdge(int source, int target, int w) {
        edges[source][target] = w;
    }

    public boolean isEdge(int source, int target) {
        return edges[source][target] > 0;
    }

    public void removeEdge(int source, int target) {
        edges[source][target] = 0;
    }

    public int getWeight(int source, int target) {
        return edges[source][target];
    }

    public int[] neighbors(int vertex) {
        int count = 0;
        for (int i = 0; i < edges[vertex].length; i++) {
            if (edges[vertex][i] > 0) {
                count++;
            }
        }
        final int[] answer = new int[count];
        count = 0;
        for (int i = 0; i < edges[vertex].length; i++) {
            if (edges[vertex][i] > 0) {
                answer[count++] = i;
            }
        }
        return answer;
    }

    public void print() {
        for (int j = 0; j < edges.length; j++) {
            System.out.print(labels[j] + ": ");
            for (int i = 0; i < edges[j].length; i++) {
                if (edges[j][i] > 0) {
                    System.out.print(labels[i] + ":" + edges[j][i] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        final WeightedGraph t = new WeightedGraph(6);
        t.setLabel(0, "Ilam");
        t.setLabel(1, "KermanShah");
        t.setLabel(2, "Kordastan");
        t.setLabel(3, "Lorestan");
        t.setLabel(4, "Tabriz");
        t.setLabel(5, "Tehran");
        t.addEdge(0, 1, 2);
        t.addEdge(0, 5, 9);
        t.addEdge(1, 2, 8);
        t.addEdge(1, 3, 15);
        t.addEdge(1, 5, 6);
        t.addEdge(2, 3, 1);
        t.addEdge(4, 3, 3);
        t.addEdge(4, 2, 7);
        t.addEdge(5, 4, 3);
       //t.print();
        //************************************************ 
        Edge[] edgs = new Edge[9];
        for (int i = 0; i < 9; i++) {

            edgs[i] = new Edge();
        }
        edgs[0].v1 = 0;
        edgs[0].v2 = 1;
        edgs[0].weight = 2;
        
        edgs[1].v1 = 0;
        edgs[1].v2 = 5;
        edgs[1].weight = 9;
        
        edgs[2].v1 = 1;
        edgs[2].v2 = 2;
        edgs[2].weight = 8;
        
        edgs[3].v1 = 1;
        edgs[3].v2 = 3;
        edgs[3].weight = 15;
        
        edgs[4].v1 = 1;
        edgs[4].v2 = 5;
        edgs[4].weight = 6;
        
        edgs[5].v1 = 2;
        edgs[5].v2 = 3;
        edgs[5].weight = 1;
        
        edgs[6].v1 = 4;
        edgs[6].v2 = 3;
        edgs[6].weight = 3;
        
        edgs[7].v1 = 4;
        edgs[7].v2 = 2;
        edgs[7].weight = 7;
        
        edgs[8].v1 = 5;
        edgs[8].v2 = 4;
        edgs[8].weight = 3;
        int[] set=new int[6];
        for(int i=0;i<6;i++){
        set[i]=i;
        }
        sort(edgs);
        for(int i=0;i<edgs.length;i++)
            System.out.println(  "("+edgs[i].v1+","+edgs[i].v2+") => W :"+edgs[i].weight);
        System.out.println(kruskal_mst(set, edgs, 6));
        
        final int[] pred = Dijkstra.dijkstra(t, 0);
        for (int n = 0; n < 6; n++) {
            Dijkstra.printPath(t, pred, 0, n);
        }
    }
    
public static void sort(Edge []y){
                for (int i=0;i<y.length;i++)
  for (int j=i+1;j<y.length;j++)
   if (y[j].weight<y[i].weight)
    {
     Edge  temp=y[i];
     y[i]=y[j];
     y[j]=temp;

}
}
public static int kruskal_mst(int set[],Edge edge[],int n)
{
 int fe=0;
 int p=0, g=0;
 Edge e;
 while (fe<n-1 && g<edge.length)
 {
  e=edge[g++];
  if (set[e.v1] != set[e.v2])
  {
   p+=e.weight;
      System.out.println("Edge : "+e);
   int k=set[e.v1];
   for (int i=0;i<n;i++)
     if (set[i]==k)
   set[i]=set[e.v2];
   fe++;
   }
  }
 if(fe==n-1) return p;
 else
   return -1;
}
}
