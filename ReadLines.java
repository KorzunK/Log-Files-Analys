import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Read
{
    public static void readLines(int prLines, int amLines, String fileName)
    {
        List<String> file = new ArrayList();

        try
        {
            BufferedReader r = new BufferedReader(new FileReader(fileName));
            try
            {
                String str;
                int count = 1;
                while ((str = r.readLine()) != null )
                {
                    if(count >= prLines && amLines<=32767)
                    {
                        file.add(str);
                    };

                    if(count == prLines + amLines -1){break;};
                    count++;
                }
            }
            finally
            {
                r.close();
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("The log-file does not exist. " + e);
        }

        catch(IOException e)
        {
            throw new RuntimeException(e);
        }

        for(int i=0; i<file.size(); i++)
        {
            System.out.println(file.get(i));
        }
    }

    public static void main(String[] args)
    {
        int prLines = Integer.parseInt(args[0]);
        int amLines = Integer.parseInt(args[1]);
        String fileName = args[2];
        Read.readLines(prLines, amLines, fileName);
    }
}
