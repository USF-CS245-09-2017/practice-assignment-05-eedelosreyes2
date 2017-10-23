
public class BSTree {
	private BSTNode root;
	
	
	public void insert(String value) {
		root = insert(value, root);
	}
	
	public BSTNode insert(String value, BSTNode node) {
		if (node == null) {
			return new BSTNode(value);
		} 
		if (node.data.compareTo(value) > 0) {
			node.left = insert(value, node.left);
			return node;
		} else {
			node.right = insert(value, node.right);
			return node;
		}
	}
	
	public boolean find(String value) {
		return find(value, root);
	}
	
	public boolean find(String value, BSTNode node) {
		if (node == null) {
			return false;
		} if (node.data.compareTo(value) == 0) {
			return true;
		} else if (node.data.compareTo(value) > 0) {
			return find(value, node.left);
		} else {
			return find(value, node.right);
		}
	}
	
	public void delete(String value) {
		root = delete(root, value);
	}
	
	public BSTNode delete(BSTNode node, String value) {
		if (node == null) {
			return null;
		} if (node.data.compareTo(value) == 0) {
			if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
			} else {
				if (node.right.left == null) {
					node.data = node.right.data;
					node.right = node.right.right;
					return node;
				} else {
					node.data = removeSmallest(node.right);
					return node;
				}
			}
		} else if (value.compareTo(node.data) > 0) {
			node.left = delete(node.left, value);
		}
		return node; //?
	}
	
	public String removeSmallest(BSTNode node) {
		if (node.left.left == null) {
			String smallest = node.left.data;
			node.left = node.left.right;
			return smallest;
		} else {
			return removeSmallest(node.left);
		}
	}
	
	public String toStringInOrder() {
		StringBuilder sb = new StringBuilder();
		return toStringInOrder(sb, root).deleteCharAt(sb.length() - 1).toString();
	}
	
	public StringBuilder toStringInOrder(StringBuilder sb, BSTNode node) {
		if (node == null) {
			return sb;
		} if (node.left == null && node.right == null) {
			sb.append(node.data + " ");
			return sb;
		} if (node.left == null) {
			sb.append(node.data + " ");
			sb = toStringInOrder(sb, node.right);
			return sb;
		} if (node.right == null) {
			sb = toStringInOrder(sb, node.left);
			sb.append(node.data + " ");
			return sb;
		}
		sb = toStringInOrder(sb, node.left);
		sb.append(node.data + " ");
		sb = toStringInOrder(sb, node.right);
		return sb;
	}
	
	public String toStringPreOrder() {
		StringBuilder sb = new StringBuilder();
		return toStringPreOrder(sb, root).toString();
	}
	
	public StringBuilder toStringPreOrder(StringBuilder sb, BSTNode node) { 
		if (node == null) {
			return sb;
		} if (node.left == null && node.right == null) {
			sb.append(node.data);
			return sb;
		} if (node.left == null) {
			sb.append(node.data + " ");
			sb = toStringPreOrder(sb, node.right);
			return sb;
		} if (node.right == null) {
			sb.append(node.data + " ");
			sb = toStringPreOrder(sb, node.left);
			return sb;
		}
		sb.append(node.data + " ");
		sb = toStringPreOrder(sb, node.left);
		sb.append(" ");
		sb = toStringPreOrder(sb, node.right);
		return sb;
	}
	
	
	public class BSTNode {
		private String data;
		private BSTNode left;
		private BSTNode right;
		
		public BSTNode(String value) {
			data = value;
		}
	}

}
