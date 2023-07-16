/*
 * Chord.java
 * A Java class for use in the ScaleChordsGenerator program.
 * @author Jack Manges
 */

public class Chord
{
    private String chordRoot;
    private String chordThird;
    private String chordFifth;
    private String chordQuality;

    public Chord(String rootNote, String third, String fifth, String triadQuality)
    {
        this.chordRoot = rootNote;
        this.chordThird = third;
        this.chordFifth = fifth;
        this.chordQuality = triadQuality;
    }

    public String toString()
    {
        return chordRoot+" "+chordQuality+": "+chordRoot+", "+chordThird+", "+chordFifth;
    }

}