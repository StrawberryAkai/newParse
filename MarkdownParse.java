import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(markdown));

        ArrayList<String> toReturn = new ArrayList<>();
        String text = "";
        String line;      
        while((line = br.readLine())!= null){
            if(!line.isEmpty()){
                text += line;
                if(line != null){
                    text += "\n";
                }
            }
        }
        br.close();
        Matcher m = Pattern.compile("\\((.*?)\\)").matcher(text);

        while(m.find()){
            toReturn.add(m.group(1));
        }

        return toReturn;
    }


    public static void main(String[] args) throws IOException {
	    System.out.println(getLinks("test-file.md"));
    }
}
