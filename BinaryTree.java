package tree_collections;

public class BinaryTree {
	private Node root;
	public Node getRoot(){
		return root;
	}
	//insert a value to a binary tree
	public void insert(int value){		    
		Node node = this.nodeInstance(value);
		Node parent = null;
		if(root==null){
			root = node;
		} else{
			Node x = root;
			while(x!=null){
				parent = x;
				if(node.value<x.value){
					x = x.left;
				} else {
					x = x.right;
				}
			}
			
		if(parent==null){
			root = node;
		}else {
			if(node.value<parent.value){			
				parent.left = node;
			}else {
				parent.right = node;
			}
		}
		}	
	}
	
	//search a certain node in the binary tree
	public Node search(int key){
		return search(root,key);
	}
	
	public Node search(Node x,int keyword){
		if(x == null||keyword == x.value){
			return x;
		}else{
			if(keyword < x.value){
				return search(x.left,keyword);
			}else{
				return search(x.right,keyword);
			}
		}
	}
	
	//find the parent of a certain node
	public Node parent(Node n){
		return parentHelper(root,n);
	}
	
	public Node parentHelper(Node currentRoot,Node n){
		if(currentRoot == null || n == currentRoot){
			return null;
		} else {
			if(currentRoot.left.value == n.value|| currentRoot.right.value == n.value){
				return currentRoot;
			} else{
				if(currentRoot.value<n.value){
					return parentHelper(currentRoot.right,n);
				}else{
					return parentHelper(currentRoot.left,n);
				}
			}
		}
		
	}
	
	//find the successor of a certain node
	public Node tree_successor(Node node){
		Node n = search(node.value);
		if(n.right!=null){
			return tree_minimum(n.right);
		}
		Node parent = parent(n);
		while(parent!=null && n==parent.right){
			n=parent;
			parent=parent(parent);
		}
		return parent;
	}
	
	
	//walk the whole tree in order
	public void inorder_tree_walk(Node bt){	
		if(bt!=null){
			inorder_tree_walk(bt.left);
			System.out.print(bt.value+" ");
			inorder_tree_walk(bt.right);
		}
	}
	
	//find the minimum 
	public Node tree_minimum(Node n){
		while(n!=null){
			if(n.left!=null) {
				n=n.left;
			} else {
				return n;
			}
		}
		return n;
	}
	
	public Node tree_maxmum(Node n){
		while(n!=null){
			if(n.right!=null) {
				n=n.right;
			} else {
				return n;
			}
		}
		return n;
	}
	
	//The following code is quoted from will
	public void display(){
		System.out.println(root.value);
		Node[] nextNodeArr = new Node[2];
		nextNodeArr[0] = root.left;
		nextNodeArr[1] = root.right;
		this.display(nextNodeArr, 2);
	}
	
	public void display(Node[] nodeArr, int floor){
		boolean flag = false;
		Node[] nextNodeArr = new Node[2 << (floor - 1)];
		for(int i = 0; i < nodeArr.length; i++){
			if(nodeArr[i] == null){
				System.out.print("_ ");
				nextNodeArr[2 * i] = null;
				nextNodeArr[2 * i + 1] = null;
			} else {
				System.out.print(nodeArr[i].value);
				if(i == nodeArr.length - 1){
					System.out.println();
				} else {
					System.out.print(" ");
				}
				
				if(nodeArr[i].left != null){
					nextNodeArr[2 * i] = nodeArr[i].left;
					flag = true;
				}
				
				if(nodeArr[i].right != null){
					nextNodeArr[2 * i + 1] = nodeArr[i].right;
					flag = true;
				}
			}
		}
		
		if(flag){
			this.display(nextNodeArr, ++floor);
		}
		
	}
	
	
	private Node nodeInstance(int value){
		return new Node(value);
	}
}
