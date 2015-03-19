import java.lang.String;
import java.util.List;

public class Parser
{

   private String host, timestamp, request, reply_code, bytes;

    public void Log(List<String> file)
    {
        System.out.println("\n" + "Parsing strings:");

        for(int i=0; i<file.size(); i++)
        {
            String[] first = file.get(i).split(" - - ");
            host = first[0];
            String[] second = first[1].split(" \"");
            timestamp = second[0];
            first = second[1].split("\"");
            request = first[0];
            second = first[1].split(" ");
            reply_code = second[1];
            bytes = second[2];

            System.out.println("Host: " + host + "  Timestamp: " + timestamp + "  Request: " + request + "  Reply Code: " + reply_code + "  Bytes in the reply: " + bytes);
        }
    }
}
