
package javaapplication32;

import java.util.LinkedList;
import java.util.Scanner;
import static javax.management.Query.value;

public class Node {
        float coefficient;
        int exponent;
        Node link;
        
     public static Node insert(Node head, float co, int ex) {
    Node newP = new Node();
    newP. coefficient = co;
    newP.exponent = ex;
    newP.link = null;
    if (head == null || ex > head.exponent) {
        newP.link = head;
        head = newP;
    } else {
         Node temp = head;
        while (temp.link != null && temp.link.exponent > ex) {
            temp = temp.link;
        }
        newP.link = temp.link;
        temp.link = newP;
    }
    return head;
}
     
  public static Node create(Node head){
     
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of terms :");
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
             System.out.println("Enter the coefficient for the term"+ (i+1));
            float coefficient=sc.nextFloat();
             System.out.println("Enter the exponent for the term"+ (i+1));
            int exponent=sc.nextInt();
              head= insert( head, coefficient, exponent);
          }
       
        return head;
       
    }
   
public static void print(Node head){
    if(head==null)
        System.out.println("Enter the polynomial");
    
    else{
        Node temp=head;
        while (temp!=null){
             System.out.print((temp.coefficient)+"x"+"^"+(temp.exponent));
             temp=temp.link;
             if(temp!=null)
              System.out.print("+");   
             
             else
              System.out.println(); 
        }
    }
}
public static void Addition(Node head1,Node head2){
    Node p1= head1;
    Node p2= head2;
    Node head3=null;
    while(p1!=null&&p2!=null){
        if(p1.exponent==p2.exponent){
            head3=insert( head3, p1.coefficient+p2.coefficient, p1.exponent);
            p1=p1.link;
            p2=p2.link;
        }
        else if(p1.exponent>p2.exponent){
            head3=insert( head3, p1.coefficient, p1.exponent);
            p1=p1.link;
        }
         else if(p1.exponent<p2.exponent){
            head3=insert( head3, p2.coefficient, p2.exponent);
            p2=p2.link;
        }
    }
     while(p1!=null){
       head3=insert( head3, p1.coefficient, p1.exponent);
            p1=p1.link;
     }
      while(p2!=null){
       head3=insert( head3, p2.coefficient, p2.exponent);
            p2=p2.link;
     }
       System.out.print("the addition of two polynomial:");
      print(head3);
      System.out.print("The value of addition two polynomial:");
      Scanner sc=new Scanner(System.in);
      System.out.print("enter value of x:");
      double x=sc.nextDouble();
      evaluate(head3,x);
     
}

public static void subtraction(Node head1,Node head2){
    Node p1= head1;
    Node p2= head2;
    Node head3=null;
    while(p1!=null&&p2!=null){
        if(p1.exponent==p2.exponent){
            head3=insert( head3, p1.coefficient-p2.coefficient, p1.exponent);
            p1=p1.link;
            p2=p2.link;
        }
        else if(p1.exponent>p2.exponent){
            head3=insert( head3, p1.coefficient, p1.exponent);
            p1=p1.link;
        }
         else if(p1.exponent<p2.exponent){
            head3=insert( head3, -p2.coefficient, p2.exponent);
            p2=p2.link;
        }
    }
     while(p1!=null){
       head3=insert( head3, p1.coefficient, p1.exponent);
            p1=p1.link;
     }
      while(p2!=null){
       head3=insert( head3,- p2.coefficient, p2.exponent);
            p2=p2.link;
     }
       System.out.print("the subtraction of two polynomial:");
      print(head3);
     System.out.print("The value of subtraction two polynomial:");
     Scanner sc=new Scanner(System.in);
     System.out.print("enter value of x:");
     double x=sc.nextDouble();
     evaluate(head3,x);
     
}

public static void multiplication(Node head1,Node head2){
    Node p1= head1;
    Node p2= head2;
    Node head3=null;
    if(head1==null ||head2==null){
      System.out.print("zero polynomial");
      return;
    }
    while(p1!=null){
        while(p2!=null){
             head3=insert( head3, p1.coefficient*p2.coefficient, p1.exponent+p2.exponent);
              p2=p2.link;
        }
       p1=p1.link;
       p2=head2;   
     }
    System.out.print("the multiplication of two polynomial:");
    print(head3);
    System.out.print("the evaluate of two multiplication polynomial:");
    Scanner sc=new Scanner(System.in);
    System.out.print("enter value of x:");
    double x=sc.nextDouble();
     evaluate(head3,x);
    
     
}
public static void evaluate(Node head,double target){
        Node p=head;
      double result=0;
        while (p!=null){
       result+=p.coefficient*(Math.pow(target, p.exponent));
          p = p.link;
          }
          System.out.println("the value of polynomail is"+result);   
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
       Node head = null ;
       Node head1 = null;
       Node head2 = null;
       Node head3 = null;
       System.out.println("Enter the polynomial");
       System.out.println("Enter the first polynomial");
       head1=create(head1);
         System.out.println("Enter the second polynomial");
         head2=create(head2);
         Addition(head1,head2);
         subtraction(head1,head2);
         multiplication(head1,head2);
    }
            }

