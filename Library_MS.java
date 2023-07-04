/*
Library Management System
Author: Emran Alam
Data: 4, jully, 2023
it's created for store your Library data. like books, issueData, returnBooks, allBooks.
Don't forget to use it.
*/

package com.emranCoder;

import java.util.Scanner;

class Library {
    private final String[] books;
    private int no_of_book = 0;
    private boolean is = true;
    private boolean active = false;
    Scanner sc = new Scanner(System.in);

    Library() {
        this.books = new String[100];
        no_of_book = 0;
        start();
    }

    public void start() {
        if (!this.active) {
            while (is) {
                uerInterFace();
            }
        }
    }

    public String takeInput() {
        System.out.print("Enter the book name: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private void activeSubPage() {
        System.out.print("To go Back enter 0: ");
        int x = sc.nextByte();
        if (x == 0) {
            this.active = true;
        } else {
            makeYourChoose(x);
        }
    }

    public void uerInterFace() {
        System.out.println("Welcome to emranCoder Library: ");
        System.out.println("==============================");
        System.out.println("1. Add Book.");
        System.out.println("2. All Books.");
        System.out.println("3. Issue Book.");
        System.out.println("4. Return Book.");
        System.out.println("5. About the library.");
        System.out.println("6. Exit.");
        System.out.print("Choose your option: ");
        int option = sc.nextByte();
        makeYourChoose(option);
    }

    private boolean makeYourChoose(int option) {
        switch (option) {
            case 1 -> {
                addBook(takeInput());
            }
            case 2 -> {
                allBooks();
            }
            case 3 -> {
                issueBook(takeInput());
            }
            case 4 -> {
                returnBook(takeInput());
            }
            case 5 -> {
                aboutUS();
            }
            case 6 -> {
                is = false;
            }
        }
        activeSubPage();
        return false;
    }


    public void addBook(String book) {
        this.books[no_of_book++] = book;
        System.out.println("\"" + book + "\" Has been added!");
    }

    public void returnBook(String book) {
        addBook(book);
    }

    public void issueBook(String book) {
        for (int i = 0; i < this.books.length; i++) {
            if (this.books[i].equals(book)) {
                System.out.println("The book is issued!");
                this.books[i] = null;
                return;
            }
        }
        System.out.println("Sorry, Book not found!");
    }

    public void allBooks() {
        System.out.println("Available Books are: ");
        System.out.println("--------------------");
        for (String book : this.books) {
            if (book == null) continue;
            System.out.println("-> " + book);
        }

    }

    private void aboutUS() {
        System.out.println("Library management system created by emranCoder.\nA little touch of java world. There used class, constructor, methods.");
    }

}


public class Library_MS {
    public static void main(String[] args) {
        Library mainLibrary = new Library();
    }
}
