// import the Random class
import java.util.Random;

public class CustomRandomNumber {
    //declaring a variable based on the random class 
    Random numberChosen = new Random (); //new instance of random

// returns a random number between 1 and maxNumber inclusive
public int getRandomInteger(){
int randomInteger = 0; //initialises the variable
 randomInteger = numberChosen.nextInt(12);

 // filter out zeros
 while(randomInteger == 0){
randomInteger = numberChosen.nextInt(12);
 }
 // return the chosen random number to the main program 
 return randomInteger;
}  



}