package dynamic_programming;


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
    public static void findLCS(char[] string ,char[] string2) {  
        int m = string.length;  
        int n = string2.length;  
        int[][] c = new int[m+1][n+1];  
        int[][] b = new int[m+1][n+1];  
        for(int i=0;i<m;i++) {  
            for(int j=0;j<n;j++) {  
                if(string[i]==string2[j]) {  
                    c[i+1][j+1]=c[i][j]+1;  
                    b[i+1][j+1]= '\\';  
                } else {  
                    if(c[i][j+1] >= c[i+1][j]) {  
                        c[i+1][j+1] = c[i][j+1];  
                        b[i+1][j+1]= '|';  
                    } else {  
                        c[i+1][j+1] = c[i+1][j];  
                        b[i+1][j+1]= '-';  
  
                    }  
                }  
            }  
        }  
          
        System.out.println("LCS长度:"+c[m][n]);  
          
        System.out.println("LCS序列:");  
        printLCS(b,string,m,n);  
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
    	 System.out.println("LCS长度:"+cMatrix[len1][len2]);  
         
         System.out.println("LCS序列:");  
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
    
   
}    