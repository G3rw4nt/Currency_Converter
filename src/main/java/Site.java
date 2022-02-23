import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Site {
    private String url;
    private String content;

    public Site(String address) throws Exception {
        url = address;
        content = readUrl();
    }

    public String getUrl() {
        return url;
    }

    public String getContent() {
        return content;
    }

    public String readUrl() throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(this.url);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }
}
