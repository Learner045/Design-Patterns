package textdecorators.util;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputDetails {

    private String inputFile, outputFile, misspelledFile, keywordFile;
    private String sentences[];
    private FileProcessor processor;
    private List<String> missWords;
    private List<String> keywords;


    /**
     * This constructor takes fileNames and creates instances for keywords and misswords lists
     * @param inputFile : inputfilename
     * @param outputFile : outputfilename
     * @param misspelledFile : misspelled words filename
     * @param keywordFile: keywords filename
     */
    public InputDetails(String inputFile, String outputFile, String misspelledFile, String keywordFile){
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        this.misspelledFile = misspelledFile;
        this.keywordFile = keywordFile;
        missWords = new ArrayList<>();
        keywords = new ArrayList<>();

    }

    /**
     * This is a getter method to return our datastructure array which stores sentences
     * @return
     */
    public String[] getSentences(){return this.sentences;}

    public void setSentences(String[] sentences){
        this.sentences = sentences; //not needed
    }

    public List<String> getKeywords(){ return this.keywords; }
    public List<String> getMissWords(){ return this.missWords; }

    /**
     * This method processes the input and stores data into sentences[]
     * @throws IOException : if file operation fails
     * @throws IllegalArgumentException : if validation fails
     */
    private void createSentences()throws IOException, IllegalArgumentException{
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = processor.poll();
            if (input == null || input.equals("")) break;

            sb.append(input);
        }

        //Data structure to store, retrieve sentences
        sentences = sb.toString().split("\\.");
       // sentences = sb.toString().split("(?<=[a-z])*\\.\\s*");

    }

    /**
     * This method processes the input and stored words into appropriate lists
     * @param words : list to store
     * @throws IOException : if file operation fails
     */
    private void createWordList(List<String> words)throws IOException{
        while(true){
            String input = processor.poll();
            if (input == null || input.equals("")) break;
            words.add(input);
        }

    }

    /**
     * this method delegates call and creates required instance of processor based on file passed as parameter
     * @param fileN : filename
     * @throws IOException : if file operation fails
     */
    public void processData(FileNames fileN )throws IOException {

        switch(fileN){
            case INPUT:   processor = new FileProcessor(inputFile); createSentences(); break;
            case MISS:  processor = new FileProcessor(misspelledFile); createWordList(this.missWords);break;
            case KEYWORDS: processor = new FileProcessor(keywordFile); createWordList(this.keywords); break;
        }

        if(processor!=null)processor.close();


    }

    /**
     * This method prints the result to console and to the output file via results instance
     * @throws IOException : if file operation fails
     */
    public void print()throws IOException{


        FileDisplayInterface results = new Results();

        StringBuilder content = new StringBuilder();

        for(String sent: sentences){
            content.append(sent+".");
        }

       System.out.println(content.toString());


       results.writeToFile(outputFile, content.toString());
       results.closeFileWrite();

    }
}
