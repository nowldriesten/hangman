import java.util.Scanner;
import java.util.ArrayList;

public class hangman {

    static public void guess(String word, int life){

        char[] filler= new char[word.length()];
        int i=0;
        while(i<word.length()){
            filler[i]='-';
            if(word.charAt(i)==' '){
                filler[i]=' ';

            }
            i++;
        }
        System.out.println(filler);
        System.out.println(" Levens over = " + life);

        Scanner s=new Scanner(System.in); //leest text

        ArrayList<Character> l=new ArrayList<Character>();

        while(life>0){
            char x=s.next().charAt(0); //user input

            if(l.contains(x)){
                System.out.println("Al gebruikt");
                        continue;
            }

            l.add(x);

            if(word.contains(x+"")){
                for (int y=0;y<word.length();y++) {
                    if(word.charAt (y)==x) {
                        filler[y]=x;
                    }
                }
            }
            else{
                life--;
            }
            if(word.equals(String.valueOf(filler))){
                System.out.println(filler);
                System.out.println("Je hebt gewonnen!");
                break;
            }


            System.out.println(filler);
            System.out.println(" Levens over " + life);
        }

        if(life==0) {
            System.out.println("Verloren!");
        }
    }

    public static void main (String[] args)  {

        String word="galgje";
        int life=5;
        guess(word,life);
    }

}
