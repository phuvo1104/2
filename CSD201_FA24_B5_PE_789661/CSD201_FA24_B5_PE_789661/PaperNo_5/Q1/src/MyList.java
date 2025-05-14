/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList {
  Node head,tail;
  MyList() {head=tail=null;}
  boolean isEmpty() {
    return(head==null);
   }
  void clear() {head=tail=null;}

  void fvisit(Node p, RandomAccessFile f) throws Exception {
    if(p != null) f.writeBytes(p.info + " ");
   }

  void ftraverse(RandomAccessFile f) throws Exception {
    Node p = head;
    while(p!=null) {
       fvisit(p,f); // You will use this statement to write information of the node p to the file
       p=p.next;
      }
    f.writeBytes("\r\n");
   }

  void loadData(int k) { //do not edit this function
    String [] a = Lib.readLineToStrArray("data.txt", k);
    int [] b = Lib.readLineToIntArray("data.txt", k+1);
    int [] c = Lib.readLineToIntArray("data.txt", k+2);
    int n = a.length;
    for(int i=0;i<n;i++) addLast(a[i],b[i],c[i]);
   }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
*/
  void addLast(String xOwner, int xPrice, int xColor) {
    //You should write here appropriate statements to complete this function.
 if (xOwner == null || xOwner.isEmpty()) return; // Ignore empty owner names

    Node newNode = new Node(new Pen(xOwner, xPrice, xColor));

    if (head == null) {
        head = tail = newNode;  // If the list is empty, set head and tail to the new node
    } else {
        tail.next = newNode;  // Append new node to the end
        tail = newNode;  // Update tail reference
    }
}

   

  //You do not need to edit this function. Your task is to complete the addLast function above only.
  void f1() throws Exception {
     clear();
     loadData(1);
     String fname = "f1.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     ftraverse(f);
     f.close();
    }  

//==================================================================
  void f2() throws Exception {
     clear();
     loadData(5);
     String fname = "f2.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     ftraverse(f);
     Pen x, y;
     x = new Pen("X",1,2);
     y = new Pen("Y",3,4);
     //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
 Node yNode = new Node(y);
    yNode.next = head;
    head = yNode;

    // Insert x as second node
    Node xNode = new Node(x);
    xNode.next = head.next;
    head.next = xNode;

 


    //------------------------------------------------------------------------------------
     ftraverse(f);
     f.close();
    }  

//==================================================================
  void f3() throws Exception {
    clear();
    loadData(9);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    ftraverse(f);
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
if (!isEmpty()) {
        Node prev = null, curr = head;
        while (curr != null && curr.info.color >= 6) {
            prev = curr;
            curr = curr.next;
        }
        if (curr != null) { // Found a node to remove
            if (prev == null) { // Removing head
                head = head.next;
            } else {
                prev.next = curr.next;
            }
        }
    }


    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
   }

//==================================================================
  void f4() throws Exception {
    clear();
    loadData(13);
    String fname = "f4.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    ftraverse(f);
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
if (!isEmpty()) {
        Node[] nodes = new Node[5];
        Node curr = head;
        int count = 0;

        // Store first 5 elements in an array
        while (curr != null && count < 5) {
            nodes[count++] = curr;
            curr = curr.next;
        }

        // Sort first 5 elements by color
        Arrays.sort(nodes, 0, count, Comparator.comparingInt(n -> n.info.color));

        // Reconnect sorted nodes
        for (int i = 0; i < count - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }

        // Connect sorted part with the rest of the list
        nodes[count - 1].next = curr;
        head = nodes[0]; // Update head to sorted first node
    }


    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
   }

 }

