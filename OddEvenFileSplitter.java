import java.io.*;


public class OddEvenFileSplitter {

    public static void main(String[] args) throws IOException {
        int i = 0;
        File f1 = new File(args[0] + ".txt");
        File f2 = new File(args[1] + ".txt");
        File f3 = new File(args[2] + ".txt");
        f2.createNewFile();
        f3.createNewFile();
        String s = new String();
        Reader r1 = new FileReader(f1);
        Writer w2 = new FileWriter(f2);
        Writer w3 = new FileWriter(f3);
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

}
