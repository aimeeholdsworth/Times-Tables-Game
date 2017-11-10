import java.util.Scanner; //allows users entered data to be stored
import java.util.Random; // allows random numbers to be generated and stored
import java.util.concurrent.ThreadLocalRandom; // allows a random number to be generated within a certain range

public class VersionThree{
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
        System.out.println("Hello, what's your name?\n");
        userName = userInput.next();
        System.out.println(" Welcome to the multiplication test " +userName);
        //play again string
        String playAgain = "y";//initialises this variable and sets it to y. Allows the code to see if the user wants to play the game again, later on
        String feedback = "y";//initialises the variable and sets it to y. This allows the user to later decide if they want feedback
        
        //game loop
        while(playAgain.equalsIgnoreCase("y")){
            
            questions=1; //restarts the game at question one and no scores
            correct=0;//initialises the tally of correct answers - set to zero with each run of the game
            incorrect=0;//initialises the tally of incorrect answers - set to zero with each run of the game
            
            
            System.out.println("Hi, " + userName + " would you like additional feedback on your incorrect answers? y/n");//prints the message asking the user to decide if they want feedback
            feedback = userInput.next();//allows the user to enter their answer - this is then stored in feedback. The user can enter a decision becasue this is an instance of the scanner 
            
       
           
        
                do{ //asks the user 10 questions - go through this loop
                    //whislt the number of questions asked is less than or equal to 10
                    
                    System.out.println("You are on question "+questions + "\n"); //prints and shows user the question number
                    
                    /* 
                   
                   NEW CODE FOR VERSION THREE BELOW 
                   THIS SECTION LINKS TO THE EXTERNAL CLASS TO CREATE A RANDOM NUMBER
                   
                   
                   */
                    CustomRandomNumber numberOne = new CustomRandomNumber(); //creates a new instance of the CustomRandomNumber external class, so that it can be used to generate a random number
                    CustomRandomNumber numberTwo = new CustomRandomNumber();//creates a new instance of the CustomRandomNumber external class, so that it can be used to generate a random number
                    
                    randomOne = numberOne.getRandomInteger(); //sets the variable. Uses the numberOne instance to link to external class, and the method GetRandomInteger to generate a random number between 1-12
                    randomTwo = numberTwo.getRandomInteger();//sets the variable. Uses the numberOne instance to link to external class, and the method GetRandomInteger to generate a random number between 1-12
                    
                    product = randomOne * randomTwo; //works out and stores the product of the numbers
                    
                    System.out.println(randomOne + "x" + randomTwo + "\n"); //prints out the timestable question
                    userAnswer = userInput.nextInt(); //stores users answer
                    
                    if(userAnswer == product){ //if the users answer is the same as the product (therefore its right)
                        System.out.println("Well done," + userName + " that's correct \n");//print a well done message
                        correct++; //add one to the correct scores tallie
                    }
                    
                    else if (feedback.equalsIgnoreCase("y")){//if they dont get the right answer, print sorry message and correct answer
                        System.out.println("Sorry, " + userName + ".That's wrong. The correct answer was " + product + "\n");
                        incorrect++; //add one to the incorrect scores tallie
                    }
                    
                    else{//this option is for when the user doesn't want feedback. Nothing is printed instead the game moves onto the next question
                        incorrect++;//updates the incorrect tally by adding one to it
                    }
                    
                    questions++; //keeps adding one to the number of questions asked
                     //this is applied to all option of the if statement
                 
                }while (questions<=10);//end do while
                  
                System.out.println("Well done, " + userName + " you've finished the test.\n");
                
                if (correct==10){ //if loop to decide what feedback is printed, depending on the user score.
                    //this option for if the user scores 10/10
                    System.out.println("Excellent. You gave 10 correct answers! - Well done "+ userName);
                }
                
                else if(correct==9){ //this option for if the user scores 9/10
                    System.out.println(userName+ ". You gave 9 correct answers - Very good");
                }
                
                else if(correct<=8 && correct>=5 ){//this option for if the user scores between 5 and 8 (inclusive)
                    System.out.println(userName + " You gave " + correct + " correct answers - Good");
                    
                }
                
                else if(correct<=4 && correct>=1 ){//this option for if the user scores between 1 and 4 (inclusive)
                    System.out.println(userName + " You only gave " + correct + " correct answers. \n Please revise your times tables!");
                    
                }
                
                else{//this option for if the user scores 0. There is no need to create another else if option as there is only one option left (scoring nothing)
                    System.out.println(userName + " , you gave no correct answers - see me!");
                }
                
                float percentage;//sets a new variable which is of type float
                percentage = ((float) correct /(correct+incorrect));//formula to work out the percentage the user scored
                percentage = percentage *100;//converts it to a percentage
                
                
                System.out.println("You got " + incorrect + " wrong answers. \n"); //a helpful line that prints how many incorrect answers the user got
                System.out.println("You got " +percentage + "% on this test \n"); //prints the precnetage scored on the test  
            
            
            
              //ask user to play again?
              System.out.println("Do you want to play again? (y/n)");
              playAgain = userInput.next();     // allows the user to enter their decision
              //if the decision is yes - the game goes back to the start of the while loop - this loop will only run as long as playAgain = y
              // this is why playAgain is set to y at the start - to allow the game to run
        
            
           
            
                   
        };// end while loop 
        
        System.out.println("");//print blank line
          //if the user doesn't choose to play again
          //if the user doesn't choose to play again - print this line - the while loop has ended becuase the user didn't choose y
            System.out.println("Thank you for playing! Goodbye.");
      
    }//end main
}//end class