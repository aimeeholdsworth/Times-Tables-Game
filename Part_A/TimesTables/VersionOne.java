import java.util.Scanner; //allows users entered data to be stored
import java.util.Random; // allows random numbers to be generated and stored
import java.util.concurrent.ThreadLocalRandom; // allows a random number to be generated within a certain range

public class VersionOne{
    public static void main(String [] args){
        Random randomNumber = new Random(); // creates a variable to hold the random number
        Scanner userInput = new Scanner(System.in); // creates a variable to hold the user input
        
        int randomOne=0; //initalise the first number that will be used to multpily together
        int randomTwo = 0; //initalise the second number that will be used to multpily together
        int questions = 1; //the number of questions that will be asked/go through
        int product = 0; //the result of the two numbers times together
        int userAnswer = 0; //what the user enters
        int correct = 0; //the number of correct answers by the user
        int incorrect = 0; //the number of incorrect answers entered by the user
        
        String userName; //creates a variable to store the user name
        System.out.println("Hello, what's your name?"); //prints this line
        userName = userInput.next(); // allows the user to enter their name - they type it in and it is stored in user name
        System.out.println("Welcome to the multiplication test " +userName);//prints a welcome message that is personalised and includes their name
        //play again string
        String playAgain = "y"; //initialises this variable and sets it to y. Allows the code to see if the user wants to play the game again, later on
        
        
        //game loop
        while(playAgain.equalsIgnoreCase("y")){ //later when the user decided whether to play again they can enter Y or y
            
            questions=1; //restarts the game at question one and no scores
            correct=0; //initialises the tally of correct answers - set to zero with each run of the game
            incorrect=0; //initialises the tally of incorrect answers - set to zero with each run of the game
            
       
           
        
                do{ //asks the user 10 questions - go through this loop
                    //whislt the number of questions asked is less than or equal to 10
                    System.out.println("You are on question "+questions + "\n"); //prints and shows user the question number
                    
                    randomOne = ThreadLocalRandom.current().nextInt(2,12+1); //generates a random number between 0 and 12
                    randomTwo = ThreadLocalRandom.current().nextInt(2,12+1); //nextInt is normally exclusive of the top value, so add 1 to make it inclusive
                    product = randomOne * randomTwo; //works out and stores the product of the numbers
                    
                    System.out.println(randomOne + "x" + randomTwo + "\n"); //prints out the timestable question
                    userAnswer = userInput.nextInt(); //stores users answer
                    
                    if(userAnswer == product){ //if the users answer is the same as the product (therefore its right)
                        
                        correct++; //add one to the correct scores tallie
                    }
                    
                    else{//if they dont get the right answer, print sorry message and correct answer
                        
                        incorrect++; //add one to the incorrect scores tallie
                    }
                    
                    questions++; //keeps adding one to the number of questions asked
                    //this is applied to all option of the if statement
                    
                 
                }while (questions<=10);//end do while - end of questions. The questions will stop being asked once the variable questions reaches 10
                //This is due to the do while loop - saying carry on asking questions whilst the number of questions is less than or equal to 10
                  
                System.out.println("Well done, " + userName + " you've finished the test.\n");
                //prints a friendly end of game message
                //prints the user's score at the end, by using the variables correct and incorrect, that have been incremented during the game
                System.out.println(userName + ", you got " + correct + " correct answers. \n");
                
                System.out.println(userName + ", you got " + incorrect + " wrong answers. \n");
                
                float percentage; //sets a new variable which is of type float
                percentage = ((float) correct /(correct+incorrect));//formula to work out the percentage the user scored
                percentage = percentage *100;//converts it to a percentage
                
                System.out.println("You got " +percentage + "% on this test \n");  //prints the users score in a percentage
            
            
            
              //ask user to play again?
              System.out.println("Do you want to play again? (y/n)");
              playAgain = userInput.next(); // allows the user to enter their decision
              //if the decision is yes - the game goes back to the start of the while loop - this loop will only run as long as playAgain = y
              // this is why playAgain is set to y at the start - to allow the game to run
        
            
           
            
                   
        };// end while loop 
        
        System.out.println("");//print blank line
          //if the user doesn't choose to play again - print this line - the while loop has ended becuase the user didn't choose y
            System.out.println("Thank you for playing! Goodbye.");
            
            System.exit(0); //end
            
      
    }//end main
}//end class