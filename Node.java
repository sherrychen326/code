package tree_collections;

public class Node {
	int value;
	Node left;
	Node right;
	Node(int value){
		this.value=value;
	}
	void display(){
		System.out.println(value);
	}
}
