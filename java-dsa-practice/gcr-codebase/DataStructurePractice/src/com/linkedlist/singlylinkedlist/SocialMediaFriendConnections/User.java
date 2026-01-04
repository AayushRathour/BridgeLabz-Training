package com.linkedlist.singlylinkedlist.SocialMediaFriendConnections;


class User {
 int id, age;
 String name;
 FriendNode friends;
 User next;

//User node for singly linked list
 User(int id, String name, int age) {
     this.id = id;
     this.name = name;
     this.age = age;
     this.friends = null;
     this.next = null;
 }
}
