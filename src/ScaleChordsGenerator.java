/*
 * MusicScaleGenerator.java
 * A program for generating a major or minor scale plus the tertian chords constructed 
 *   from that scale, and outputting the results to the console.
 * @author Jack Manges
 */

import java.util.Scanner;

public class ScaleChordsGenerator
{
    private static String[] allKeys = {"C Major","G Major","D Major","A Major","E Major","B Major","A Minor",
    "E Minor","B Minor","F# Minor","C# Minor","G# Minor","F Major","Bb Major","Eb Major","Ab Major",
    "Db Major","D Minor","G Minor","C Minor","F Minor","Bb Minor","F# Major","C# Major","D# Minor",
    "A# Minor","Gb Major","Cb Major","Eb Minor","Ab Minor"};

    public static void main(String[] args)
    {
        System.out.println("\nThis program generates a musical scale and its associated tertian chords" +
                " from an inputted tonic note and mode of scale.\nThis program will not accommodate exotic" +
                " or theoretical keys (such as G# Major), which contain double sharps or double flats." +
                " Only the Major and Minor keys established in the Circle of Fifths are accepted.\n");

        ScaleChordsGenerator generator = new ScaleChordsGenerator();
        String[] userKey;
        Scanner scan = new Scanner(System.in);
        int keyIndex;

        userKey = generator.queryKey(scan);
        while ((keyIndex = generator.validScale(userKey[0], userKey[1])) == -1) {
            userKey = generator.queryKey(scan);
        }
        scan.close();
        
        Scale scale = new Scale(userKey[0], userKey[1], keyIndex);
        scale.generateScale();
        scale.generateChords();
        System.out.println(scale.toString());
    }

    private String[] queryKey(Scanner scan) 
    {    
        System.out.print("Enter the tonic note and scale type (Major or Minor)"+
        " separated by a space (i.e. \"C Major\"): ");
        String line = scan.nextLine();
        String[] tokens = line.split(" ");
        if (tokens.length != 2) {
            tokens = new String[2];
        }

        return tokens;
    }

    private int validScale(String tonic, String quality)
    {           
        int keyIndex;
        for (keyIndex = 0; keyIndex < allKeys.length; keyIndex++) {
            if (allKeys[keyIndex].equalsIgnoreCase(tonic + " " + quality)) {
                return keyIndex;
            }
        }
        // Invalid input
        System.out.println("Invalid input, please try again.\n");
        return -1;
    }
    
}