package sort;

public class sort {
	public static void main(String[] args){
		int[] arr = {5,2,4,7,1,3,2,6};
		//insertionSort(arr);
		quickSort(arr,0,7);
		for(int a:arr){
			System.out.print(a + " ");
		}
	}
	
	public static void insertionSort(int[] arr){
		int len = arr.length;
		for(int j=1;j<len;j++){
			int key = arr[j];
			int i = j-1;
			while(i>=0&&arr[i]>key){
				arr[i+1] = arr[i];
				--i;
			}
			arr[i+1] = key;
		}
	}
	
	public static void merge(int[] arr,int p,int q,int r){
		int n1 = q-p+1;
		int n2 = r-q;
		int[] L= new int[n1+1];
		int[] R = new int[n2+1];
		for(int i=0;i<n1;i++){
			L[i] = arr[p+i];
		}
		for(int j=0;j<n2;j++){
			R[j] = arr[q+j+1];
		}
		L[n1]=100000;
		R[n2]=100000;
		int i=0,j=0;
		for(int k=p;k<=r;k++){
			if(L[i]<=R[j]){
				arr[k]=L[i];
				i=i+1;	
			}else{
				arr[k]=R[j];
				j=j+1;
			}
		}
		
	}
	
	public static void mergeSort(int[] arr,int p,int r){
		if(p<r){
			int q = (p+r)/2;
			mergeSort(arr,p,q);
			mergeSort(arr,q+1,r);
			merge(arr,p,q,r);
		}
	}
	

	public static void quickSort(int[] arr,int p,int r){
		if(p<r){
			int q = partition(arr,p,r);
			quickSort(arr,p,q-1);
			quickSort(arr,q,r);
		}
	}
	
	public static int partition(int[] arr,int p,int r){
		int x = arr[r];
		int i = p-1;
		for(int j=p;j<=r-1;j++){
			if(arr[j]<=x){
				i=i+1;
				exchange(arr,i,j);
			}
		}
		exchange(arr,i+1,r);
		return i+1;
	}
	
	public static void exchange(int[] arr,int i,int j){
		int temp;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
} 
