package edu.cmu.zhiyuel.annotator;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;

import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.Chunker;
import com.aliasi.chunk.Chunking;
import com.aliasi.chunk.NBestChunker;
import com.aliasi.util.AbstractExternalizable;

import edu.cmu.zhiyuel.type.Gene;
import edu.cmu.zhiyuel.type.Sentence;
import edu.cmu.zhiyuel.util.PosTagNamedEntityRecognizer;

/**
 * @author zhiyuel
 *         <p>
 *         GeneNameAnnotator refers to ne-en-bio-genetag.HmmChunker for gene mention tagging.
 * */
public class GeneNameAnnotator extends JCasAnnotator_ImplBase {
  //private Pattern mSentenceID;

  public GeneNameAnnotator() {
    // TODO Auto-generated constructor stub
  }

  /**
   * Initialize the context, get the configuration parameters. Actually, I didn't use this
   * parameter. We could also use regular express to extract information from metadocument.
   * */
  public void initialize(UimaContext aContext) throws ResourceInitializationException {
    super.initialize(aContext);
    // Get config. parameter valuesSentenceId
    //String[] SentenceIDStrings = (String[]) aContext.getConfigParameterValue("SentenceId");
    // System.out.println("Pattern:"+SentenceIDStrings[0]);
    // compile regular expressions
    //mSentenceID = Pattern.compile(SentenceIDStrings[0]);

  }

  /**
   * @param phrase
   *          given string
   * @return the number of whitespaces in a given string
   *         <p>
   *         get the number of white spaces in a given string, in order to compute the end position
   *         of geneName.
   * */
  private int trimWhiteSpaces(String phrase) {
    int cnt = 0;
    for (int i = 0; i < phrase.length(); i++) {
      if (Character.isWhitespace(phrase.charAt(i))) {
        cnt++;
      }
    }
    return cnt;
  }
/**
 * @param aJCas get the Jcas from type system.
 * <p>The previous annotator SentenceAnnotator has already split up the document into SentenceId and text.
 * In this annotator, we further deal with the text in order to produce geneName.
 * <p>Apply ne-en-bio-genetag.HmmChunker modelfile into geneName tagging.
 * <p>The start-offset is the number of non-whitespace characters in the sentence preceding the first character of the mention, 
 * and the end-offset is the number of non-whitespace characters in the sentence preceding the last character of the mention.
 * @see http://alias-i.com/lingpipe/demos/tutorial/ne/read-me.html
 * */
  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub
    System.out.println("Annotating Gene Name....");
    File modelFile = new File("src/main/resources/ne-en-bio-genetag.HmmChunker");
    NBestChunker chunker = null;
    Chunking chunking;
    Chunk[] Chunkarray;
    try {
      chunker = (NBestChunker) AbstractExternalizable.readObject(modelFile);
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    String sentenceIdentifier = "";
    String sentenceText = "";
    FSIterator<Annotation> it = aJCas.getAnnotationIndex(Sentence.type).iterator();// ?
    while (it.hasNext()) {

      // get sentence annotator from CAS
      Sentence annotation = (Sentence) it.next();
      sentenceIdentifier = annotation.getSentenceId();
      sentenceText = annotation.getText();
      chunking = chunker.chunk(sentenceText);
      // System.out.println("chunking:"+chunking);
      Chunkarray = chunking.chunkSet().toArray(new Chunk[0]);
      // System.out.println("chunk array:"+Arrays.toString(Chunkarray));
      for (int j = 0; j < Chunkarray.length; j++) {
        Gene geneA = new Gene(aJCas);
        geneA.setSentenceId(sentenceIdentifier);
        geneA.setBegin(Chunkarray[j].start());
        geneA.setEnd(Chunkarray[j].end());
        String a=sentenceText.substring(Chunkarray[j].start(), Chunkarray[j].end());
        String b=sentenceText.substring(0,Chunkarray[j].start());
        int ret=trimWhiteSpaces(b);
        int r=trimWhiteSpaces(a);
        //System.out.println(a+"###"+ret);
        geneA.setGeneStart(Chunkarray[j].start()-ret);
        geneA.setGeneEnd(Chunkarray[j].end()
                - 1
                - ret-r);
        geneA.setGeneName(sentenceText.substring(Chunkarray[j].start(), Chunkarray[j].end()));
        // System.out.println("###"
        // +Chunkarray[j].start()+"#####"+Chunkarray[j].end()+"====="+geneA.getGeneName());
        geneA.addToIndexes();
      }
    }
  }

}
