package com.samit.linkedlist;

class NodeSam{
    int data;
    NodeSam next;
    NodeSam(int data){
        next=null;
        this.data=data;
    }
}

public class LinkedListReverseInGroupsPro {

    public NodeSam reverseInGroups(NodeSam head,int k){
        NodeSam curr=head,next=null,prev=null;
        int count=0;
        while (curr!=null && count<k){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            count++;
        }
        if (next!=null){
            head.next= reverseInGroups(next,k);
        }
        return prev;
    }

    public void printlist(NodeSam head){
        NodeSam curr=head;
        while (curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        NodeSam first=new NodeSam(1);
        NodeSam second=new NodeSam(2);
        NodeSam third=new NodeSam(3);
        NodeSam fourth=new NodeSam(4);
        NodeSam fifth=new NodeSam(5);
        NodeSam sixth=new NodeSam(6);
        NodeSam seventh=new NodeSam(7);
        first.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=fifth;
        fifth.next=sixth;
        sixth.next=seventh;
        LinkedListReverseInGroupsPro list=new LinkedListReverseInGroupsPro();
        list.printlist(first);

        NodeSam reverseList=list.reverseInGroups(first,2);
        list.printlist(reverseList);

    }
}
