package com.BrowserBuddyTabHistoryManager;

import java.util.Stack;

public class HistoryManager {
    Stack<WebPageNode> st;
    WebPageNode head;

    public HistoryManager() {
        st = new Stack<>();
        head = null;
    }

    public void openNewTab() {
        if (head != null) st.push(head);

        WebPageNode curr = new WebPageNode("New Tab");
        head = curr;
    }

    public void openaLink(String url) {
        if (head == null) {
            System.out.println("Please create a new tab to open a link");
            return;
        }

        head.next = null;

        WebPageNode curr = new WebPageNode(url);
        curr.prev = head;
        head.next = curr;
        head = curr;
    }

    public void moveForward() {
        if (head == null) {
            System.out.println("Please create a tab to open a link");
            return;
        }
        
        if (head.next == null) {
            System.out.println("No web page to move forward");
            return;
        }

        head = head.next;
        System.out.println("Moved to " + head.url);
    }

    public void moveBack() {
        if (head == null) {
            System.out.println("Please create a tab to open a link");
            return;
        }

        if (head.prev == null) {
            System.out.println("No web page to move backward");
            return;
        }

        head = head.prev;
        System.out.println("Moved to " + head.url);
    }

    public void showHistory() {
        Stack<WebPageNode> temp = new Stack<>();
        int idx = 1;

        if (head != null) {
            System.out.print("Tab " + idx + ": ");
            WebPageNode node = head;

            while (node.prev != null) node = node.prev;

            while (node != null) {
                System.out.print(node.url + " -> ");
                node = node.next;
            }
            idx++;
        }

        while (!st.isEmpty()) {
            WebPageNode pageNode = st.pop();
            temp.push(pageNode);

            System.out.print("Tab " + idx + ": ");

            while (pageNode.prev != null) pageNode = pageNode.prev;

            while (pageNode != null) {
                System.out.print(pageNode.url + " -> ");
                pageNode = pageNode.next;
            }
            idx++;
        }
        while (!temp.isEmpty()) st.push(temp.pop());
    }

    public void open(int idx) {
        if (idx == 1) return;

        if (st.size() <= idx) {
            System.out.println("Enter a valid tab to open!");
            return;
        }

        Stack<WebPageNode> temp = new Stack<>();

        while (idx > 2) {
            temp.push(st.pop());
            idx--;
        }

        WebPageNode newTab = st.pop();

        while (!temp.isEmpty()) {
            st.push(temp.pop());
        }

        st.push(head);
        head = newTab;
    }
}