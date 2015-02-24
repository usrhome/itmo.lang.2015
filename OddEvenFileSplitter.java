import java.io.*;


public class OddEvenFileSplitter {

    public static void main(String[] args) throws IOException {
        int i = 0;
        String s = new String();
        Reader r1 = new FileReader(getSourceFilePath(args[0] + ".txt"));
        Writer w2 = new FileWriter(getOddLinesFilePath(args[1] + ".txt"));
        Writer w3 = new FileWriter(getEvenLinesFilePath(args[2] + ".txt"));
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
    }
    static String getSourceFilePath(String smine){
        File f1 = new File(smine);
        return smine;
    }

    static String getOddLinesFilePath(String s1mine){
        File f2 = new File(s1mine);
        try {
            f2.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s1mine;
    }
    static String getEvenLinesFilePath(String s2mine) {
        File f3 = new File(s2mine);
        try {
            f3.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s2mine;
    }

}
