import java.io.*;
import java.util.*;
 
class TestClass {
    public static void main(String args[] ) throws Exception {
        // Write your code here
        final long c= 1000003;
        Scan sc = new Scan();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        for(int i=0; i<m; i++){
            ArrayList<Integer> b = new ArrayList<>();
            a.add(b);
        }
        //Arrays.fill(a,100);
        Set<Integer> s = new HashSet<>();
        while(n-->0){
            int l = sc.nextInt()-1;
            int r = sc.nextInt();
            int z = sc.nextInt();
            a.get(l).add(z);
            if(r<m)
                a.get(r).add(-z);
        }
        long p = 1;
        int[] d = new int[k]; 
        int ctr = k; 
        for(int i=0; i<m; i++){
            ArrayList<Integer> b = a.get(i);
            for(int j=0; j<b.size();j++){
                int v = b.get(j);
                if(v>0){
                    if(d[v-1]==0){
                        d[v-1]++;
                        ctr--;
                    }else if(d[v-1]>0){
                        d[v-1]++;
                    }
                }else if(v<0){
                    if(d[-v-1]==1){
                        ctr++;
                        d[-v-1]--;
                    }else
                        d[-v-1]--;
                }
                
            }
            //System.out.println(s);
            p = ((p%c)*((ctr)%c))%c; 
        }
        System.out.println(p);
    }
}
class Scan{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    
    String next() throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }
    
    int nextInt() throws IOException{
        return Integer.parseInt(next());
    }
}

/*
import java.io.*;
import java.util.*; 

class TestClass { public static void main(String args[] ) throws Exception {
	final long c= 1000003;
	Scan sc = new Scan();
	int n = sc.nextInt();
	int m = sc.nextInt();
	int k = sc.nextInt();
	ArrayList<ArrayList<Integer>> a = new ArrayList<>();
	for(int i=0; i<m; i++){
		ArrayList<Integer> b = new ArrayList<>();
		a.add(b);
	}
	//Arrays.fill(a,100);
	Set<Integer> s = new HashSet<>();
	while(n-->0){
	int l = sc.nextInt()-1;
	int r = sc.nextInt();
	int z = sc.nextInt();
	a.get(l).add(z);
	if(r<m)
		a.get(r).add(-z);
	}
	long p = 1;
	int[] d = new int[k];
	int ctr = k;
	for(int i=0; i<m; i++){
		ArrayList<Integer> b = a.get(i);
		for(int j=0; j<b.size();j++){
			int v = b.get(j);
			if(v>0){
				if(d[v-1]==0){
					d[v-1]++;
					ctr--;
				}else if(d[v-1]>0){
					d[v-1]++;
				}
			}else if(v<0){
				if(d[-v-1]==1){
					ctr++;
					d[-v-1]--;
				}else
					d[-v-1]--;
			}	
		}
		//System.out.println(s);
		p = ((p%c)*((ctr)%c))%c; 
	}
	System.out.println(p);
}
}
class Scan{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	
	String next() throws IOException{
		while(st==null||!st.hasMoreTokens()){
			st = new StringTokenizer(br.readLine());
		}        return st.nextToken();
	}
	
	int nextInt() throws IOException{
		return Integer.parseInt(next());
	}
}
*/
