package edu.cmu.zhiyuel.annotator;
/**
 * @author zhiyuel
 *         <p>
 *         SentenceAnnotator is to split up the document into SentenceId and text.
 * */
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import edu.cmu.zhiyuel.type.Gene;
import edu.cmu.zhiyuel.type.Sentence;

public class SentenceAnnotator extends JCasAnnotator_ImplBase {

  public SentenceAnnotator() {
    // TODO Auto-generated constructor stub
  }
  /**
   * @param aJCas get the Jcas from type system.
   * <p>The previous collection reader initializes the Jcas. This annotator get the document text form Jcas.
   * The span from start of each line to the first white space is the SentenceID. According to this property, we 
   * split up the original document and update the jcas.
   * @see org.apache.uima.collection.JCasAnnotator_ImplBase#process()
   * */
  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub
    System.out.println("Annotating Sentence...");
    String[] strstext = aJCas.getDocumentText().trim().split("[\\n]");
    for (int i = 0; i < strstext.length; i++) {
      int firstSpace = strstext[i].indexOf(' ');
      // System.out.println(text[i]);
      String sentenceId = strstext[i].substring(0, firstSpace).trim();
      String sentenceText = strstext[i].substring(firstSpace).trim();
      //System.out.println(sentenceText);
      Sentence an = new Sentence(aJCas);
      an.setSentenceId(sentenceId);
      an.setText(sentenceText);
      an.addToIndexes();
      //System.out.println("=======Sentence======="+aJCas.getAnnotationIndex(Sentence.type).iterator().hasNext());
    }
  }
}
