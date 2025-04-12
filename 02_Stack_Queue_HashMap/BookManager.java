import java.util.*;
class Book{
    int bookId;
    String title;
    String author;
    public Book(int bookId,String title,String author){
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }
    public void display(){
        System.out.println("Book Id : "+bookId);
        System.out.println("Book Title : "+title);
        System.out.println("Book author : "+author);
    }
}
public class BookManager{
    public static void main(String[] args){
        HashMap<Integer,Book> bookMap = new HashMap<>();
        bookMap.put(102,new Book(102,"Children's Omni Bus","Ruskin Bond"));
        bookMap.put(110,new Book(110,"Swami and Friends","Narayanan"));
        Book[] bookarray = bookMap.values().toArray(new Book[0]);
        for(int i =0;i<bookarray.length - 1;i++){
            for(int j = 0; j<bookarray.length-i-1;j++){
                if(bookarray[j].author.compareTo(bookarray[j+1].author)>0){
                    Book temp = bookarray[j];
                    bookarray[j] = bookarray[j+1];
                    bookarray[j+1] = temp;
                }
            }
        }
        System.out.println("Book Sorted : ");
        for(Book book : bookarray){
            book.display();
        }
        boolean found = false;
        int searchId = 102;
        System.out.println("Search id is : "+searchId);
        for(Map.Entry<Integer,Book> entry : bookMap.entrySet()){
            if(entry.getKey() == searchId){
                entry.getValue().display();
                found = true;
            }
        }
        if(found != true){
            System.out.println("Book not found");
        }
        else {
            System.out.println("Book found");
        }
    }
}