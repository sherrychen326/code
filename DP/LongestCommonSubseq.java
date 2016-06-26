package dynamic_programming;
//find the longest common subsequence of two input strings


public class LongestCommonSubseq {  
    public static void main(String[] args) {  
        char[] string = "abcbdab".toCharArray();  
        char[] string2 = "bdcaba".toCharArray();  
          
        findLCS2(string, string2);  
    }  
    /** 
     *  
     * @param string 
     * @param string2 
     */  

    public static void findLCS1(char[] string1, char[] string2) {  
        int m = string1.length;  
        int n = string2.length;  
        int[][] c = new int[m][n];  
        int max=0;  
        int maxPosX = 0;  
        for(int i=0;i<m;i++) {  
            for(int j=0;j<n;j++) {  
                if(string1[i]==string2[j]) {  
                    if(i==0||j==0) {  
                        c[i][j] = 1;  
                    } else {  
                        c[i][j] = c[i-1][j-1]+1;  
                    }  
                    if(c[i][j]>max) {  
                        max =c[i][j];  
                        maxPosX = i;  
                    }  
                      
                } else {  
                    c[i][j] = 0;  
                }  
            }  
        }  
        System.out.println(max);  
        for(int i = maxPosX-max+1;i<=maxPosX;i++) {  
            System.out.print(string1[i]);  
        }  
    }  
    
             
    
    public static void findLCS2(char[] str1, char[] str2) {
    	int len1 = str1.length;
    	int len2 = str2.length;
    	int[][] cMatrix = new int[len1+1][len2+1];
    	int[][] bMatrix = new int[len1+1][len2+1];
    	//initialize cMatrix and bMatrix

    	for(int i=1;i<=len1;i++){
    		for(int j=1;j<=len2;j++){
    			if(str1[i-1]==str2[j-1]){
    				cMatrix[i][j]=cMatrix[i-1][j-1]+1;
    				bMatrix[i][j]='\\';
    			}else{
    				if(cMatrix[i-1][j]>=cMatrix[i][j-1]){
    					cMatrix[i][j]=cMatrix[i-1][j];
    					bMatrix[i][j]='|';
    				} else if(cMatrix[i][j-1]>cMatrix[i-1][j]){
    					cMatrix[i][j]=cMatrix[i][j-1];
    					bMatrix[i][j]='-';
    				}
    			}
    		}
    	}
    	 System.out.println("LCS length:"+cMatrix[len1][len2]);  
         
         System.out.println("LCS display:");  
         printLCS(bMatrix,str1,len1,len2);
    }
        
    private static void printLCS(int[][] b, char[] string, int i, int j) {  
        if(i==0 || j==0) {  
            return ;  
        }  
          
        if(b[i][j]=='\\') {  
            printLCS(b, string, i-1, j-1);  
            System.out.println(string[i-1]);  
        } else if(b[i][j]=='|'){  
            printLCS(b, string, i-1, j);  
        } else {  
            printLCS(b, string, i, j-1);  
        }  
           
    }
}    
