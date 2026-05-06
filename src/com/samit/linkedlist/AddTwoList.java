package com.samit.linkedlist;

class NodeS{
    int data;
    NodeS next;
    NodeS(int d) {
        data = d;
        next = null;
    }
}

public class AddTwoList {
    public NodeS reverse(NodeS head1){
        NodeS prev=null;
        NodeS curr=head1;
        NodeS next;
        while (curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    public NodeS addTwoLists(NodeS head1, NodeS head2) {
        NodeS uHead1=reverse(head1);
        NodeS uHead2=reverse(head2);
        int rem=0;
        NodeS head=null;
        NodeS tail=null;
        int val=0;
        while (uHead1!=null && uHead2!=null){
            val=(uHead1.data+uHead2.data+rem);
            rem=val>9?1:0;
            int data=val<=9?val:(val%10);
            NodeS node=new NodeS(data);
            if (head==null){
                head=node;
                tail=node;
            }else{
                tail.next=node;
                tail=tail.next;
            }
            uHead1=uHead1.next;
            uHead2=uHead2.next;
        }
        while (uHead1!=null){
            val=(uHead1.data+rem);
            rem=val>9?1:0;
            int data=val<=9?val:(val%10);
            NodeS node=new NodeS(data);
            if (head==null){
                head=node;
                tail=node;
            }else{
                tail.next=node;
                tail=tail.next;
            }
            uHead1=uHead1.next;
        }
        while (uHead2!=null){
            val=(uHead2.data+rem);
            rem=val>9?1:0;
            int data=val<=9?val:(val%10);
            NodeS node=new NodeS(data);
            if (head==null){
                head=node;
                tail=node;
            }else{
                tail.next=node;
                tail=tail.next;
            }
            uHead2=uHead2.next;
        }
        return reverse(head);
    }

    void print(NodeS head){
        NodeS temp=head;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }

    public static void main(String[] args) {
        NodeS first=new NodeS(4);
        NodeS second=new NodeS(5);
        first.next=second;
        AddTwoList addTwoLists=new AddTwoList();
        addTwoLists.print(first);

        System.out.println();
        NodeS first1=new NodeS(3);
        NodeS second1=new NodeS(4);
        NodeS third1=new NodeS(5);
        first1.next=second1;
        second1.next=third1;
        addTwoLists.print(first1);

        System.out.println();

        NodeS newHead=addTwoLists.addTwoLists(first,first1);
        addTwoLists.print(newHead);
        System.out.println();
    }
}