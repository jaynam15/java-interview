import java.io.*;
import java.util.*;


public class Solution {
    static boolean visited[];
    static LinkedList<Integer>[] adj;
    static int V;
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        V=7;    
        visited=new boolean[V+1];       
        adj=new LinkedList[V+1];
        for(int i=0;i<=V;i++)
        {
            adj[i]=new LinkedList();
        }
        addEdge(1,2);
        addEdge(1,3);
        addEdge(1,5);
        addEdge(4,2);
        addEdge(6,4);
        addEdge(6,5);
        addEdge(2,5);
        
        getDFS();
            
    }
    static void addEdge(int a,int b)
    {
        
       //Creating an edge between a and b
        adj[a].add(b);
        //Creating an edge between b and a
        adj[b].add(a);
    }
    private static void getDFS()
    {
        for(int i=1;i<=V;i++)
        {
            //Call dfs for the unvisited nodes           
            if(!visited[i])
            {
                dfs(i);
            }
        }
        
    }
    
    private static void dfs(int  start) {
        //Mark start vertex as visited
        visited[ start]=true;
        System.out.print( start+" ");
        if(adj[ start].size()>0)
        {
            //get the adjacent vertex of the start node
            Iterator<Integer> itr=adj[ start].iterator();
            while(itr.hasNext())
            {
                int ele=itr.next();
                //mark the adjacent vertex as visited if  unvisited
                if(!visited[ele])
                {
                    //recur for the adjacent vertex
                    dfs(ele);
                }
            }
            
        
        }
    }
}
        

