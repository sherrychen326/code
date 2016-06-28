package dynamic_programming;


public class Optimal_BST {
	public static void main(String[] args){
		int[] a = {5,10,5,5,5,10};
		int[] b = {0,15,10,5,10,20};
		int[][] s= OBST(a,b,5); 
		for(int[] arr : s){
			for(int x:arr){
				System.out.print(x+" ");
			}
			System.out.println(" ");
		}
		 Traceback(5,1,5,s,0,'0');  
	}
	
	public static int[][] OBST(int[]a,int[]b,int n){
		//n=3
		int N = n+2;
		int[][] m = new int[N][N];
		int[][] s = new int[N][N];
		int[][] w = new int[N][N];
		
		for(int i=0;i<=n;i++){
			w[i+1][i] = a[i];
			m[i+1][i] = 0;
		}
		
		for(int r=0; r<n; r++){
			//r代表起止下标的差  			    	  
			for(int i=1; i<=n-r; i++){ //i为起始元素下标  
				int j = i+r;//j为终止元素下标  			  
			//构造T[i][j] 填写w[i][j],m[i][j],s[i][j]  //首选i作为根，其左子树为空，右子树为节点  
				w[i][j]=w[i][j-1]+a[j]+b[j];
				m[i][j]=m[i+1][j];
				s[i][j]=i;
		//不选i作为根，设k为其根，则k=i+1，……j  //左子树为节点：i,i+1……k-1,右子树为节点：k+1,k+2,……j  
				for(int k=i+1; k<=j; k++){
					int t = m[i][k-1]+m[k+1][j];
				 	if(t<m[i][j]){
						m[i][j]=t;
						s[i][j]=k;//根节点元素  
				 	}
				} 
				
				m[i][j]+=w[i][j];}
				
			}
		return s;
		}
	
	
	public static void Traceback(int n,int i,int j,int[][] s,int f,char ch){
		int k=s[i][j];
		if(k>0){
			if(f==0){
				System.out.println("Root"+k+"(i,j)"+i+","+j);
			}
			else{
				System.out.println(ch+"of"+f+":"+k+"(i:j)"+i+","+j); 
			}
			int t = k-1;
			if(t>=i && t<=n){//回溯左子树  
				Traceback(n,i,t,s,k,'L');
			}
			t = k+1;
			if(t<=j){ 
				//回溯右子树  
				Traceback(n,t,j,s,k,'R');
			}
		}	
	}
	

}