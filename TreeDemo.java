import java.util.Scanner;

class Node{
   int value;
   Node left, right;
   
   public Node(int value){
      this.value = value;
      left = null;
      right = null;
   }

}

class BinarySearchTree{

   Node root;
   
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
   recursive insert method
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
   
   
   
   /*
   pre-order traversal
   */
   public void preOrderTraversal(Node root){
      if(root != null)
      {
         System.out.print(root.value + " ");
         preOrderTraversal(root.left);
         preOrderTraversal(root.right);
      }
   }

   
   
   /*
   in-order traversal
   */
   public void inOrderTraversal(Node root){
      if(root != null)
      {
         inOrderTraversal(root.left);
         System.out.print(root.value + " ");
         inOrderTraversal(root.right);
      }
   }
   
   
   
   /*
   post-order traversal
   */
   public void postOrderTraversal(Node root){
      if(root != null)
      {
         postOrderTraversal(root.left);
         postOrderTraversal(root.right);
         System.out.print(root.value + " ");
      }
   }
   
   
   
   /*
   a method to find the node in the tree
   with a specific value
   */
   public boolean find(Node root, int key){
	  if(root == null)
     {
         return false;
     }
     
     if(root.value == key)
     {
         return true;
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
   
   
   
   /*
   a method to find the node in the tree
   with a smallest key
   */
   public int getMin(Node root){
      Node current = root;
      while(current.left != null)
         current = current.left;
      
      return current.value;
   }
  
  
  
   /*
   a method to find the node in the tree
   with a largest key
   */
   public int getMax(Node root){
	  Node current = root;
      while(current.right != null)
         current = current.right;
      
      return current.value;
   }
   
   
   
   /*
   this method will not compile until getMax
   is implemented
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