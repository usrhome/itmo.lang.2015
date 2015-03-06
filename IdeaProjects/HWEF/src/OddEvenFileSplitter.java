import java.io.*;

public class OddEvenFileSplitter implements FileSplitter {


    public static void main(final String[] args) {
        OddEvenFileSplitter odd = new OddEvenFileSplitter();
        SplitConfig config = new SplitConfig() {

            public String getSourceFilePath() {
                File f1 = new File(args[0]);
                return args[0];
            }

            public String getOddLinesFilePath() {
                File f2 = new File(args[1]);
                try {
                    f2.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return args[1];
            }

            public String getEvenLinesFilePath() {
                File f3 = new File(args[2]);
                try {
                    f3.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return args[2];
            }
        };
        odd.splitFile(config);
    }

    public void splitFile(SplitConfig config) {
        try {
            Reader r1 = new FileReader(config.getSourceFilePath());
            Writer w2 = new FileWriter(config.getOddLinesFilePath());
            Writer w3 = new FileWriter(config.getEvenLinesFilePath());
            BufferedReader r = new BufferedReader(r1);
            int i = 0;
            String s = new String();
            s = config.getSourceFilePath();
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
}