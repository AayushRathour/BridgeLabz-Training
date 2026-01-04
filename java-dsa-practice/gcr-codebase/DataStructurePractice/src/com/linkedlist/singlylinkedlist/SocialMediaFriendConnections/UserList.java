package com.linkedlist.singlylinkedlist.SocialMediaFriendConnections;

class UserList {

    User head;

    // add user at beginning
    void addUser(int id, String name, int age) {
        User u = new User(id, name, age);
        u.next = head;
        head = u;
    }

    // search by id or name
    User search(int id, String name) {
        User t = head;
        while (t != null) {
            if (t.id == id || t.name.equalsIgnoreCase(name))
                return t;
            t = t.next;
        }
        return null;
    }

    // add friend connection (both sides)
    void addFriend(int id1, int id2) {
        User u1 = search(id1, "");
        User u2 = search(id2, "");
        if (u1 == null || u2 == null) return;

        FriendNode f1 = new FriendNode(id2);
        f1.next = u1.friends;
        u1.friends = f1;

        FriendNode f2 = new FriendNode(id1);
        f2.next = u2.friends;
        u2.friends = f2;
    }

    // remove friend connection
    void removeFriend(int id1, int id2) {
        removeOne(id1, id2);
        removeOne(id2, id1);
    }

    void removeOne(int uid, int fid) {
        User u = search(uid, "");
        if (u == null || u.friends == null) return;

        if (u.friends.fid == fid) {
            u.friends = u.friends.next;
            return;
        }

        FriendNode t = u.friends;
        while (t.next != null && t.next.fid != fid)
            t = t.next;

        if (t.next != null)
            t.next = t.next.next;
    }

    // show friends of one user
    void showFriends(int id) {
        User u = search(id, "");
        if (u == null) return;

        FriendNode f = u.friends;
        while (f != null) {
            System.out.print(f.fid + " ");
            f = f.next;
        }
        System.out.println();
    }

    // mutual friends
    void mutual(int id1, int id2) {
        User u1 = search(id1, "");
        User u2 = search(id2, "");
        if (u1 == null || u2 == null) return;

        FriendNode f1 = u1.friends;
        while (f1 != null) {
            FriendNode f2 = u2.friends;
            while (f2 != null) {
                if (f1.fid == f2.fid)
                    System.out.print(f1.fid + " ");
                f2 = f2.next;
            }
            f1 = f1.next;
        }
        System.out.println();
    }

    // count friends for each user
    void countAll() {
        User u = head;
        while (u != null) {
            int c = 0;
            FriendNode f = u.friends;
            while (f != null) {
                c++;
                f = f.next;
            }
            System.out.println(u.name + " : " + c);
            u = u.next;
        }
    }
}
