public class ConcatenateStrings {
    public static void main(String[] args) {
        String[] words = {"Mom", "is", "awesome", "!"};
        StringBuffer sb = new StringBuffer();
        for (String word : words) {
            sb.append(word);
        }
        String result = sb.toString();
        System.out.println("Concatenated string: " + result);
    }
}