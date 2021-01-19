package textdecorators;

import textdecorators.util.Decorators;
import textdecorators.util.InputDetails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequentWordDecorator extends AbsTextDecorator {
    private AbsTextDecorator atd;
    private InputDetails inputDetails;
    private Map<String, Integer> freq;

    public MostFrequentWordDecorator(AbsTextDecorator atdIn, InputDetails inputDetails) {
        atd = atdIn;
        this.inputDetails = inputDetails;
        this.freq = new HashMap<>();
    }

    /**
     * This method stores frequency of each word in the sentence to a HashMap - freq
     * @param sent : sentences to find frequency of words
     */
    private void generateMapFreq(String[] sent){
       for(int i=0; i<sent.length; i++){
           for(String word: sent[i].split("[ \\t\\r\\n\\f]")){
               word = word.toLowerCase();
               if(freq.containsKey(word)){
                   freq.put(word, freq.get(word)+1);
               }else{
                   freq.put(word, 1);
               }
           }
       }
    }

    /**
     * this method finds the max frequency and stores those words in maxFreqQords list
     * @return : maxFreqWords
     */
    private List<String> getMaxFreqWords(){
        int max = 0;
        List<String> maxFreqWords = new ArrayList<>();

        for(Map.Entry<String, Integer> entry: freq.entrySet()) {
            if(entry.getValue()>=max){
                max = entry.getValue();
            }
        }

        for(Map.Entry<String, Integer> entry: freq.entrySet()) {
            if(entry.getValue()>=max){
                maxFreqWords.add(entry.getKey());
            }
        }
        return maxFreqWords;
    }

    /**
     * This method gets sentences from inputDetails and gets maxFreqWords
     * It loops through all words and prefixes max frequency words with MOST_FREQUENT_ and suffixes with  _MOST_FREQUENT
     * It then delegates call to appropriate decorator
     */
    @Override
    public void processInputDetails() {
        // Decorate input details.
        String[] sent = inputDetails.getSentences();
        generateMapFreq(sent);
        List<String> words = getMaxFreqWords();


        int elementIndex = 0;

        for(int i=0; i<sent.length; i++){
            int j=0;
            for(String curr: sent[i].split("[ \\t\\r\\n\\f]")){

                for(String word: words){

                    if(curr.equalsIgnoreCase(word)){
                        elementIndex = sent[i].indexOf(curr, j );
                        sent[i] = sent[i].substring(0,elementIndex)+Decorators.MOST_FREQUENT_+curr+Decorators._MOST_FREQUENT+sent[i].substring(elementIndex+word.length());
                        j+=Decorators.MOST_FREQUENT_.toString().length()+Decorators._MOST_FREQUENT.toString().length();

                    }
                }
                j+=curr.length()+1;

            }

        }


        // Forward to the next decorator, if any.
        if (null != atd) {
            atd.processInputDetails();
        }
    }
}
