import java.io.*;
import java.util.*;

public class Assignment3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        if(args.length == 0){
            System.out.println("No file specified!");
            System.exit(0);
        }
        Scanner input = new Scanner(new File(args[0]));
        
        //get frequencies of words in the file ignoring case
        HashMap<String, Integer> wordMap = new HashMap<>();
        while(input.hasNext()){
            String next = input.next().toLowerCase();
            if(",.?!".contains(next.charAt(next.length()-1) + ""))
                next = next.substring(0, next.length() - 1);
            
            if(!wordMap.containsKey(next))
                wordMap.put(next, 1);
            else
                wordMap.put(next, wordMap.get(next) + 1);
        }
        
        //sort the frequencies in descending order
        LinkedList<Map.Entry<String, Integer>> list =
                new LinkedList<>(wordMap.entrySet());
        Collections.sort(list, (Map.Entry<String, Integer> w1,
                Map.Entry<String, Integer> w2) -> {
                    return w2.getValue().compareTo(w1.getValue());
                });
        
        list.forEach(word -> {
            System.out.println(word.getValue() + ":\t" + word.getKey());
        });
    }
    
}
