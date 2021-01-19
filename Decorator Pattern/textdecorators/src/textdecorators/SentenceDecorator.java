package textdecorators;

import textdecorators.util.Decorators;
import textdecorators.util.InputDetails;

public class SentenceDecorator extends AbsTextDecorator {
    private AbsTextDecorator atd;
    private InputDetails inputDetails;

    public SentenceDecorator(AbsTextDecorator atdIn, InputDetails inputDetails) {
        atd = atdIn;
        this.inputDetails = inputDetails;
    }

    /**
     * This method gets sentences from inputDetails.
     * It appends each sentence with BEGIN_SENTENCE__ and ends the sentence with __END_SENTENCE
     * It then delegates call to appropriate decorator
     */
    @Override
    public void processInputDetails() {
        // Decorate input details.
        String[] sent = inputDetails.getSentences();
        for(int i=0; i<sent.length; i++){
            sent[i] = Decorators.BEGIN_SENTENCE__+sent[i]+Decorators.__END_SENTENCE;
            //System.out.println(sent[i]);
        }

        // Forward to the next decorator, if any.
        if (null != atd) {
            atd.processInputDetails();
        }
    }

   }
