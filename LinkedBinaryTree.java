public class LinkedBinaryTree {

private AVLNode root;

LinkedBinaryTree() {
}


public boolean isEmpty() {
return root == null;
}


public int size() {
if (root == null) return 0;
else return count(root, 0);
}

private int count(AVLNode current, int count) {
int size = count;
if(current != null) {
size = count(current.getLeft(), size);
size++;
size = count(current.getRight(),size);
}
return size;
}

public void add(int value) {
root = addRecursive(root, value);
//root = rebalance(root);
}

private AVLNode addRecursive(AVLNode current, int value) {    
if(current == null) {
    
    AVLNode node = new AVLNode(value);
    node.setHeight();
    return node;
}
if(current.getElement() > value) {
    current.setLeft(addRecursive(current.getLeft(), value));}
else if (current.getElement() < value) {
    current.setRight(addRecursive(current.getRight(), value));}
current.setHeight();
return rebalance(current);
}

private void inOrderTraversal(AVLNode current) {
if(current != null) {
inOrderTraversal(current.getLeft());
System.out.print(current.getElement() + " ");
inOrderTraversal(current.getRight());
}
}

public void printInOrder() {
System.out.println("The size of the tree is: " + size());
inOrderTraversal(root);
}


public void remove (int target) {
root = remove(root, target);
}

private AVLNode remove(AVLNode current, int target) {
if(current == null) {
    //current.setHeight();
    return current;}
else if(current.getElement() > target) {current.setLeft(remove(current.getLeft(),target));}
else if(current.getElement() < target) {current.setRight(remove(current.getRight(),target));}
else {
    if(current.getRight() == null) {
        //current.getLeft().setHeight();
        return current.getLeft();}
    else if (current.getLeft() == null) {
        //current.getRight().setHeight();
        return current.getRight();}
    else {
        current.setElement(findMin(current.getRight()));
        current.setRight(remove(current.getRight(),current.getElement()));
}

}
current.setHeight();

return rebalance(current);
}




private int findMin(AVLNode current) {
if(current.getLeft() == null) {return current.getElement();}
else {return findMin(current.getLeft());}
}


public AVLNode find(int target) {
AVLNode returned = find(root, target);
return returned;
}

private AVLNode find(AVLNode current, int target) {
if(current == null) {return null;}
else if(current.getElement() == target) {return current;}
else if(target< current.getElement()) {current = find(current.getLeft(), target);}
else if(target> current.getElement()) {current = find(current.getRight(), target);}
return current;
}

public int balanceFactor(AVLNode current) {
int left = (current.getLeft() == null) ? 0 : current.getLeft().getHeight();  
int right = (current.getRight() == null) ? 0 : current.getRight().getHeight();
return right - left;
}

public AVLNode rebalance(AVLNode current) {
if(current == null) {return current;}
else{
if(balanceFactor(current) < -1) {
if(balanceFactor(current.getLeft())<=0) {current = rightRotate(current);}
else if(balanceFactor(current.getLeft())>0) {
    current.setLeft(leftRotate(current.getLeft()));
    current = rightRotate(current);};
}
else if (balanceFactor(current) > 1) {
if(balanceFactor(current.getRight())>=0) {current = leftRotate(current);}
else if (balanceFactor(current.getRight()) < 0) {
    current.setRight(rightRotate(current.getRight()));
    current = leftRotate(current);}
}}
return current;
}

private AVLNode leftRotate(AVLNode current) {
AVLNode orphan = new AVLNode();
if (current.getRight() != null) {orphan = current.getRight().getLeft();}
AVLNode newParent = current.getRight();
newParent.setLeft(current);
current.setRight(orphan);
current.setHeight();
if(orphan != null) {orphan.setHeight();}
return newParent;
}

private AVLNode rightRotate(AVLNode current) {
AVLNode orphan = new AVLNode();
if(current.getLeft() != null) {orphan = current.getLeft().getRight();}
AVLNode newParent = current.getLeft();
newParent.setRight(current);
current.setLeft(orphan);
current.setHeight();
if(orphan != null) {orphan.setHeight();}
return newParent;
}

}

    
