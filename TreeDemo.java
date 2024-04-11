import java.util.Scanner;
/**
* A class to be used in BinarySearchTree, representing each node within a binary tree
* @author Jace Marden
*/
class Node{
   int value;
   Node left, right;
   
   /**
   * Construct a new node given an integer value
   * @param value The value given to the node
   */
   public Node(int value){
      this.value = value;
      left = null;
      right = null;
   }

}

/**
* A class to represnt a binary search tree (BST), with adequate functionality to traverse and manipulate
* @author Jace Marden
*/
class BinarySearchTree{

   Node root;
   
   /**
   * A method to insert a value and recursively repair the tree once inserted
   * @param value The value to be inserted into the binary search tree
   * @return The root node of the BST
   */
   public Node insert(int value)
   {
      //base case
      if(root == null){
         root = new Node(value);
         return root;
      }
      
      //recursive step
      if(value < root.value){
         root.left = insert(root.left, value); 
      }else{
         root.right = insert(root.right, value);
      }
      
      return root;
   }
   
   /*
   * A method to insert a value and recursively repair the tree once inserted, but given a root
   * @param root The root of the binary search tree, or the current sub-tree
   * @param value The value to be inserted into the BST
   * @return root The root node of the BST
   */
   public Node insert(Node root, int value){
      //base case
      if(root == null){
         root = new Node(value);
         return root;
      }
      
      //recursive step
      if(value < root.value){
         root.left = insert(root.left, value); 
      }else{
         root.right = insert(root.right, value);
      }
      
      return root;
   }
   
   
   
   /**
   * A method to traverse the binary search tree using preOrder traversal
   * @param root The root of the BST or current sub-tree
   */
   public void preOrderTraversal(Node root){
      if(root != null)
      {
         System.out.print(root.value + " ");
         preOrderTraversal(root.left);
         preOrderTraversal(root.right);
      }
   }

   
   
   /**
   * A method to traverse the binary search tree using inOrder traversal
   * @param root The root of the BST or current sub-tree
   */
   public void inOrderTraversal(Node root){
      if(root != null)
      {
         inOrderTraversal(root.left);
         System.out.print(root.value + " ");
         inOrderTraversal(root.right);
      }
   }
   
   
   
   /**
   * A method to traverse the binary search tree using postOrder traversal
   * @param root The root of the BST or current sub-tree
   */
   public void postOrderTraversal(Node root){
      if(root != null)
      {
         postOrderTraversal(root.left);
         postOrderTraversal(root.right);
         System.out.print(root.value + " ");
      }
   }
   
   
   
   /**
   * A method to find a specific key value within the binary search tree
   * @param root The root of the BST or current sub-tree
   * @param key The value to find within the BST
   * @return found True or False if the key was found
   */
   public boolean find(Node root, int key){
     boolean found = false;
   
	  if(root == null)
     {
         found = false;
         return found;
     }
     
     if(root.value == key)
     {
         found = true;
         return found;
     }
     
     else if (key < root.value)
     {
         return find(root.left, key);
     }
     else
     {
         return find(root.right, key);
     }
               
   }
   
   
   
   /**
   * A method to find the minimum key within the binary search tree
   * @param root The root of the BST or current sub-tree
   * @return current.value An int that is the value of the smallest root in the BST
   */
   public int getMin(Node root){
      Node current = root;
      while(current.left != null)
         current = current.left;
      
      return current.value;
   }
  
  
  
   /**
   * A method to find the maximum key within the binary search tree
   * @param root The root of the BST or current sub-tree
   * @return current.value An int that is the value of the largest root in the BST
   */
   public int getMax(Node root){
	  Node current = root;
      while(current.right != null)
         current = current.right;
      
      return current.value;
   }
   
   
   
   /**
   * A method to remove a node within the binary search tree based on a given key if the node exists
   * @param root The root of the BST or current sub-tree
   * @param key An integer denoting which node to search for and delete from the BST
   * @return The root of the BST
   */
   public Node delete(Node root, int key){
      
      if(root == null){
         return root;
      }else if(key < root.value){
         root.left = delete(root.left, key);
      }else if(key > root.value){
         root.right = delete(root.right, key);
      }else{
         //node has been found
         if(root.left==null && root.right==null){
            //case #1: leaf node
            root = null;
         }else if(root.right == null){
            //case #2 : only left child
            root = root.left;
         }else if(root.left == null){
            //case #2 : only right child
            root = root.right;
         }else{
            //case #3 : 2 children
            root.value = getMax(root.left);
            root.left = delete(root.left, root.value);
         }
      }
      return root;  
   }
   
   
   
}


/**
* A class to demonstrate the functionality of the BinarySearchTree calss
* @author Jace Marden
*/
public class TreeDemo{
   public static void main(String[] args){
      BinarySearchTree t1  = new BinarySearchTree();
      t1.insert(24);
      t1.insert(80);
      t1.insert(18);
      t1.insert(9);
      t1.insert(90);
      t1.insert(22);  
         
      //Demonstrate pre order method   
      System.out.print("\npre-order :   ");
      t1.preOrderTraversal(t1.root);
      System.out.println();
      
      //Demonstrate in order method
      System.out.print("\nin-order :   ");
      t1.inOrderTraversal(t1.root);
      System.out.println();
      
      //Demonstrate post order method
      System.out.print("\npost-order :   ");
      t1.postOrderTraversal(t1.root);
      System.out.println();
      
      //Demonstrate find method
      Scanner temp = new Scanner(System.in);
      System.out.print("\nEnter number to find : ");
      int toFind = temp.nextInt();
      System.out.println(toFind + " is within the tree : " + t1.find(t1.root, toFind));
      
      //Demonstrate delete method
      Scanner temp2 = new Scanner(System.in);
      System.out.print("\nEnter number to delete : ");
      int toDelete = temp2.nextInt();
      System.out.println(toDelete + " is within the tree : " + t1.find(t1.root, toDelete));
      System.out.println("Attempting to delete " + toDelete);
      t1.delete(t1.root, toDelete);
      System.out.println(toDelete + " is within the tree : " + t1.find(t1.root, toDelete));
      
      //Demonstrate getMin and getMax
      try
      { 
         System.out.print("\nMinimum value within the tree : " + t1.getMin(t1.root));
         System.out.print("\nMaximum value within the tree : " + t1.getMax(t1.root));
      } 
      catch (NullPointerException e)
      {
         System.out.println("Tree is empty");
      }
   }  
}