import java.io.*;


public class OddEvenFileSplitter implements FileSplitter.SplitConfig{
    static String s = new String();
    static String s1 = new String();
    static String s2 = new String();
    public static void main(String[] args)  {
        int i = 0;
        s = args[0];
        s1 = args[1];
        s2 = args[2];
        OddEvenFileSplitter odd = new OddEvenFileSplitter();
        try {
            Reader r1 = new FileReader(odd.getSourceFilePath());
            Writer w2 = new FileWriter(odd.getOddLinesFilePath());
            Writer w3 = new FileWriter(odd.getEvenLinesFilePath());
            BufferedReader r = new BufferedReader(r1);
            while ((s = r.readLine()) != null) {
                if ((i % 2) == 0)
                    w2.write(s + "\n");
                else w3.write(s + "\n");
                i++;
            }
            r1.close();
            w2.close();
            w3.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public String getSourceFilePath() {
        File f1 = new File(s + ".txt");
        return s + ".txt";
    }

    public String getOddLinesFilePath() {
        File f2 = new File(s1 + ".txt");
        try {
            f2.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s1 + ".txt";
    }

    public String getEvenLinesFilePath() {
        File f3 = new File(s2 + ".txt");
        try {
            f3.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s2 + ".txt";
    }

}
