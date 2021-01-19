package textdecorators;

import textdecorators.util.Decorators;
import textdecorators.util.InputDetails;

import java.util.List;

public class KeywordDecorator extends AbsTextDecorator {
    private AbsTextDecorator atd;
    private InputDetails inputDetails;

    public KeywordDecorator(AbsTextDecorator atdIn, InputDetails inputDetails) {
        atd = atdIn;
        this.inputDetails = inputDetails;
    }


    /**
     * This method gets the sentences and keyword list from inputDetails instance.
     * it then searches for the keywords in the sentence and prefixes it with KEYWORD_ and
     * suffixes it with _KEYWORD
     * It delegates call to appropriate decorator
     */
    @Override
    public void processInputDetails() {
        // Decorate input details.
        String[] sent = inputDetails.getSentences();
        List<String> keywords = inputDetails.getKeywords();


        for(int i=0; i<sent.length; i++){
            int j=0;
            for(String curr: sent[i].split("[ \\t\\r\\n\\f]")){
                for(String word: keywords){
                    if(curr.equalsIgnoreCase(word)){
                        sent[i] = sent[i].replace(curr,Decorators.KEYWORD_+curr+Decorators._KEYWORD);
                    }
                }
                j++;
            }
        }

        // Forward to the next decorator, if any.
        if (null != atd) {
            atd.processInputDetails();
        }
    }
}
