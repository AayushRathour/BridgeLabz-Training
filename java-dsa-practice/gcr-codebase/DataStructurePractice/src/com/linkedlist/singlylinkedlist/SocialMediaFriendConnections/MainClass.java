package com.linkedlist.singlylinkedlist.SocialMediaFriendConnections;

public class MainClass {
    public static void main(String[] args) {

        UserList ul = new UserList();

        ul.addUser(1, "Aay", 21);
        ul.addUser(2, "Rathour", 22);
        ul.addUser(3, "Tech", 20);

        ul.addFriend(1, 2);
        ul.addFriend(1, 3);
        ul.addFriend(2, 3);

        ul.showFriends(1);
        ul.mutual(1, 2);

        ul.removeFriend(1, 3);
        ul.showFriends(1);

        ul.countAll();
    }
}
