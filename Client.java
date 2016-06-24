package tree_collections;

public class Client {
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.insert(3);
		binaryTree.insert(2);
		binaryTree.insert(8);
		binaryTree.insert(4);
		binaryTree.display();
		//binaryTree.inorder_tree_walk(binaryTree.getRoot());
		Node node = new Node(8);


		Node sNode = binaryTree.parent(node);
		System.out.println(sNode.value);
		//System.out.println(sNode.value);
//		Node node = binaryTree.search(binaryTree.getRoot(),3);
//		if(node != null){
//			node.display();
//		} else {
//			System.out.println("i can't find it in this biTree!!!");
//		}
	}
}
