

public class AVLNode {
private int data;
private AVLNode left;
private AVLNode right;
private int height;

AVLNode() {}

AVLNode (int data) {
this.data = data;
this.left = null;
this.right = null;
this.height = 0;
}


public int numChildren () {
if (left != null && right != null) {return 2;}
else if (left != null || right != null) {return 1;}
return 0;
}

public void setElement(int data) {
this.data = data;
}

public int getElement() {
return data;
}

public AVLNode getRight() {
return this.right;
}

public void setRight (AVLNode node) {
this.right = node;
}

public AVLNode getLeft() {
return this.left;
}

public void setLeft (AVLNode node) {
this.left = node;
}

public void setHeight() {
this.height = this.getHeight();
}

public int getHeight() {
if(this == null) {return 0;}
int left = (this.left == null) ? 0 : this.left.getHeight();  
int right = (this.right == null) ? 0 : this.right.getHeight();
return Math.max(left, right) + 1;}



}