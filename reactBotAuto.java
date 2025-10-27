import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Scanner;

public class reactBotAuto {

    public static void main(String[] args) {
        int time;
        int newTime = 0;
        double numOfMaxOuts;
        int min;
        int max;

        //user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the minimum time: "); //the longest clip is 38 seconds
        min = scanner.nextInt(); 
        System.out.println("Enter the maximum time: "); //changed script to make this any number
        max = scanner.nextInt();
        scanner.close(); 

        
        while(true){
            System.out.println("---"); 

            Random random = new Random();
            time = (random.nextInt(max-min) + min);
            numOfMaxOuts = time / 60;

            try {
                Robot robot = new Robot();

                robot.keyPress(KeyEvent.VK_F7);// press F7
                robot.keyRelease(KeyEvent.VK_F7);// release f7
                System.out.println("Pressed: F7");

                //delay
                System.out.println("Next Press in " + time + " seconds.");
                if (time < 60){ //0
                    robot.delay(time * 1000);
                }else{
                    for (int i = 0;i<numOfMaxOuts;i++){
                        robot.delay(60000);
                        newTime = (time - 60);
                    }

                    robot.delay(newTime * 1000);
                }

            } catch (AWTException e) {
                System.out.println("SOMETHING BROKE REPEAT SOMETHING BROKE");
            }
        }

    }

}