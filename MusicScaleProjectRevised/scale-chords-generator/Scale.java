/*
 * Scale.java
 * A Java class for use in the ScaleChordsGenerator program.
 * @author Jack Manges
 */

public class Scale
{
    private String tonic;
    private String quality;
    private String[] finalPitchList;
    private String[] finalScale = new String[7];
    private String[] sharpPitches = {"C","C#","D","D#","E","F","F#","G","G#","A","A#","B"};
    private String[] flatPitches = {"C","Db","D","Eb","E","F","Gb","G","Ab","A","Bb","B"};
    private String[] extraSharpPitches = {"B#","C#","D","D#","E","E#","F#","G","G#","A","A#","B"};
    private String[] extraFlatPitches = {"C","Db","D","Eb","Fb","F","Gb","G","Ab","A","Bb","Cb"};

    private Chord[] scaleChords = new Chord[7];

    public Scale(String tonicNote, String keyQuality, int keyIndex)
    {  
        /*
         * Assign the pitch array used to generate the scale based on the 
         * index of the user-inputted key in the main method. 
         * The keys in the AllKeys array are organized in such a manner. 
         */
        if (keyIndex < 12) {        
            finalPitchList = sharpPitches;
        } else if (keyIndex < 22) {
            finalPitchList = flatPitches;
        } else if (keyIndex < 26) {
            finalPitchList = extraSharpPitches;
        } else {
            finalPitchList = extraFlatPitches;
        }

        /* Ensures that final output is neatly displayed */ 
        this.tonic = Character.toUpperCase(tonicNote.charAt(0)) + tonicNote.substring(1);      
        this.quality = Character.toUpperCase(keyQuality.charAt(0)) + keyQuality.substring(1); 
    }

    public void generateScale()
    {
        int tonicIndex;
        for (tonicIndex = 0; tonicIndex < finalPitchList.length; tonicIndex++) {                                                          
            if (finalPitchList[tonicIndex].equalsIgnoreCase(tonic)) {
                break;
            }
        }

        /* Indexes through finalPitchList with intervals corresponding to key quality. */
        if (quality.equalsIgnoreCase("Major")) {                                                                                          
            finalScale[0] = finalPitchList[(tonicIndex)];              
            finalScale[1] = finalPitchList[(tonicIndex + 2) % 12];
            finalScale[2] = finalPitchList[(tonicIndex + 4) % 12];
            finalScale[3] = finalPitchList[(tonicIndex + 5) % 12];
            finalScale[4] = finalPitchList[(tonicIndex + 7) % 12];
            finalScale[5] = finalPitchList[(tonicIndex + 9) % 12];
            finalScale[6] = finalPitchList[(tonicIndex + 11) % 12];
        } else if (quality.equalsIgnoreCase("Minor")) {
            finalScale[0] = finalPitchList[(tonicIndex)];
            finalScale[1] = finalPitchList[(tonicIndex + 2) % 12];
            finalScale[2] = finalPitchList[(tonicIndex + 3) % 12];
            finalScale[3] = finalPitchList[(tonicIndex + 5) % 12];
            finalScale[4] = finalPitchList[(tonicIndex + 7) % 12];
            finalScale[5] = finalPitchList[(tonicIndex + 8) % 12];
            finalScale[6] = finalPitchList[(tonicIndex + 10) % 12];
        }

    }

    public void generateChords()
    {   
        if (quality.equalsIgnoreCase("Major")) {
            scaleChords[0] = new Chord(finalScale[0],finalScale[2],finalScale[4],"Major");
            scaleChords[1] = new Chord(finalScale[1],finalScale[3],finalScale[5],"Minor");
            scaleChords[2] = new Chord(finalScale[2],finalScale[4],finalScale[6],"Minor");
            scaleChords[3] = new Chord(finalScale[3],finalScale[5],finalScale[0],"Major");
            scaleChords[4] = new Chord(finalScale[4],finalScale[6],finalScale[1],"Major");
            scaleChords[5] = new Chord(finalScale[5],finalScale[0],finalScale[2],"Minor");
            scaleChords[6] = new Chord(finalScale[6],finalScale[1],finalScale[3],"Diminished");
        } else if (quality.equalsIgnoreCase("Minor")) {
            scaleChords[0] = new Chord(finalScale[0],finalScale[2],finalScale[4],"Minor");
            scaleChords[1] = new Chord(finalScale[1],finalScale[3],finalScale[5],"Diminished");
            scaleChords[2] = new Chord(finalScale[2],finalScale[4],finalScale[6],"Major");
            scaleChords[3] = new Chord(finalScale[3],finalScale[5],finalScale[0],"Minor");
            scaleChords[4] = new Chord(finalScale[4],finalScale[6],finalScale[1],"Minor");
            scaleChords[5] = new Chord(finalScale[5],finalScale[0],finalScale[2],"Major");
            scaleChords[6] = new Chord(finalScale[6],finalScale[1],finalScale[3],"Major");
        }

    }
     
    public String toString()
    {   
        String message = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
        message += "\n" + tonic + " " + quality + " scale: " + finalScale[0] + ", " +
        finalScale[1] + ", " + finalScale[2] + ", " + finalScale[3] + ", " + 
        finalScale[4] + ", " + finalScale[5] + ", " + finalScale[6];
        message += "\n\nChords in scale: \n";
        for (int chord = 0; chord < 7; chord++) {
            message += scaleChords[chord].toString() + "\n";
        }

        return message;
    }

}
