package textdecorators;

import textdecorators.util.Decorators;
import textdecorators.util.InputDetails;

import java.util.List;

public class SpellCheckDecorator extends AbsTextDecorator {
    private AbsTextDecorator atd;
    private InputDetails inputDetails;

    public SpellCheckDecorator(AbsTextDecorator atdIn, InputDetails inputDetails) {
        atd = atdIn;
        this.inputDetails = inputDetails;
    }

    /**
     * Ths method gets sentences from inputDetails and misspelled word list
     * it then goes through each word and prefixes with SPELLCHECK_ and suffixes with _SPELLCHECK for words
     * found in spellcheck list
     * It then delegates call to decorator if not null
     */
    @Override
    public void processInputDetails() {

        String[] sent = inputDetails.getSentences();
        List<String> words = inputDetails.getMissWords();

        for(int i=0; i<sent.length; i++){
            int j=0;
            for(String curr: sent[i].split("[ \\t\\r\\n\\f]")){
                for(String word: words){
                    if(curr.equalsIgnoreCase(word)){
                        sent[i] = sent[i].replace(curr,Decorators.SPELLCHECK_+curr+Decorators._SPELLCHECK);
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
