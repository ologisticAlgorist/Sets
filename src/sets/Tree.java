package sets;

public class Tree {
	private Object[] nodes;  //member of a tree that isn't a leaf
	private Object[] leaves;   //member of a tree that has no branches going out and a branch coming in
	
	public Tree(Object node, Object[] leaves) {
		// TODO Auto-generated constructor stub
		nodes[0] = node;
		this.leaves = leaves;
	}
	public Tree(Object o){
		nodes = new Object[1];
		nodes[0] = o;
		leaves = new Tree[]{};
	}
	
	public int getSize(){
		return nodes.length+leaves.length;
	}
	/*
	public Object leafAt(int level,int branch){
		return leaves[1].leaves[0].leaves[branch];
	}
	*/
}
