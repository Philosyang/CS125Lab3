import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
    public static void main(String[] unused) {
        System.out.println(wordCount("prince"));
    }

    public static int wordCount(String targetWord) {
        targetWord = targetWord.toLowerCase();
        String givenArticle = urlToString("http://erdani.com/tdpl/hamlet.txt");
        givenArticle = givenArticle.toLowerCase();
        int times = 0;
        int lastIndex = 0;
        int anotherIndex = 0;
        while (givenArticle.indexOf(targetWord, lastIndex) != -1) {
            lastIndex = givenArticle.indexOf(targetWord);
            times++;
        }
        return times;
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
}
