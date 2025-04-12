import java.io.*;
public class CompareStringHandlingAndFileReading {
    public static void main(String[] args) {
        String str = "hello";
        int iterations = 1_000_000;

        // Part 1: StringBuilder
        long startBuilder = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(str);
        }
        long endBuilder = System.currentTimeMillis();
        System.out.println("StringBuilder Time: " + (endBuilder - startBuilder) + " ms");

        // Part 2: StringBuffer
        long startBuffer = System.currentTimeMillis();
        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sf.append(str);
        }
        long endBuffer = System.currentTimeMillis();
        System.out.println("StringBuffer Time: " + (endBuffer - startBuffer) + " ms");

        // Part 3: Reading file with FileReader
        try {
            long startFileReader = System.currentTimeMillis();
            BufferedReader br = new BufferedReader(new FileReader("example.txt"));
            int wordCount = countWords(br);
            long endFileReader = System.currentTimeMillis();
            System.out.println("FileReader Word Count: " + wordCount);
            System.out.println("FileReader Time: " + (endFileReader - startFileReader) + " ms");
            br.close();
        } catch (IOException e) {
            System.out.println("Error with FileReader: " + e.getMessage());
        }

        // Part 4: Reading file with InputStreamReader
        try {
            long startInputStreamReader = System.currentTimeMillis();
            InputStreamReader isr = new InputStreamReader(new FileInputStream("example.txt"));
            BufferedReader br = new BufferedReader(isr);
            int wordCount = countWords(br);
            long endInputStreamReader = System.currentTimeMillis();
            System.out.println("InputStreamReader Word Count: " + wordCount);
            System.out.println("InputStreamReader Time: " + (endInputStreamReader - startInputStreamReader) + " ms");
            br.close();
        } catch (IOException e) {
            System.out.println("Error with InputStreamReader: " + e.getMessage());
        }
    }

    public static int countWords(BufferedReader reader) throws IOException {
        int wordCount = 0;
        String line;
        while ((line = reader.readLine()) != null) {
            String[] words = line.trim().split("\\s+");
            wordCount += words.length;
        }
        return wordCount;
    }
}