package dynamic_programming;
import java.util.*;

public class eightQueen {
	public static void main(String[] args){
		int row = 0;
		Integer[] columns = new Integer[8];
		ArrayList<Integer[]> results = new ArrayList<Integer[]>();
		placeQueens(row,columns,results);
		
		Iterator<Integer[]> iter = results.iterator();
		while(iter.hasNext()){
			for(Integer i : iter.next()){
				System.out.print(i+" ");
			}
			System.out.println("another method ");
		}
	}
	public static int GRID_SIZE = 8;
	public static void placeQueens(int row,Integer[] columns,ArrayList<Integer[]> results){
		if(row == GRID_SIZE){
			results.add(columns.clone());
		}else{
			for(int col = 0;col < GRID_SIZE;col++){
				if(checkValid(columns,row,col)){
					columns[row] = col;
					placeQueens(row+1,columns,results);
				}
			}
		}
	}
	public static boolean checkValid(Integer[] columns,int row1,int column1){
		for(int row2 = 0;row2 < row1;row2++){
			int column2 = columns[row2];
			//check if rows has a queen in the same column
			if(column1 == column2){
				return false;
			}
			
			int columnDistance = Math.abs(column2 - column1);
			//check if they are in the same diagonal
			int rowDistance = row1 - row2;
			if(columnDistance == rowDistance){
				return false;
			}
		}
		return true;
	}
}
