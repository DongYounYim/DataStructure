import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) {
        Map map = new ArrayMap();
        int lineNumber = 0;

        try {
            BufferedReader in  = new BufferedReader(new FileReader("test"));
            String line = in.readLine();

            while(line != null) {
                lineNumber++;
                StringTokenizer parser = new StringTokenizer(line, " ,:;-.?!");
                while(parser.hasMoreTokens()) {
                    String word = parser.nextToken().toLowerCase();
                    String list = map.get(word);
                    if (list == null) {
                        map.put(word, ""+ lineNumber);
                    } else
                        map.put(word, list + "," + lineNumber);
                }
                System.out.println(lineNumber + "\t" + line);
                line = in.readLine();
            }
            in.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        System.out.println(map);
        System.out.println("lines: " + lineNumber);
        System.out.println("distinct words: " + map.size());
    }
}
