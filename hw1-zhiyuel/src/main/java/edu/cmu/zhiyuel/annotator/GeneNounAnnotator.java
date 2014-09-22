package edu.cmu.zhiyuel.annotator;

import java.util.Map;
/**
 * try to use part of speech to improve the precision, but fail.
 * the posTagNER slip up many gene names into nouns.
 * 
 * 
 * */
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import edu.cmu.zhiyuel.type.Gene;
import edu.cmu.zhiyuel.type.NounGene;
import edu.cmu.zhiyuel.util.PosTagNamedEntityRecognizer;

public class GeneNounAnnotator extends JCasAnnotator_ImplBase {

  public GeneNounAnnotator() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public void process(JCas aCAS) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub
    System.out.println("============");
    JCas jcas = (JCas) aCAS;
    
    String sentenceIdentifier = "";
    String geneText = "";
    System.out.println("Annotating Noun Genes");
    PosTagNamedEntityRecognizer Tagger = null;
    try {
      Tagger = new PosTagNamedEntityRecognizer();
    } catch (ResourceInitializationException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();//报错在这里！
    }
//    CSVToHashMap genes = new CSVToHashMap();
    

    // retrieve the filename of the input file from the CAS
    FSIterator it = jcas.getAnnotationIndex(Gene.type).iterator();
    //int count=0;
    while (it.hasNext()) {

      Gene annotation = (Gene) it.next();
      sentenceIdentifier = annotation.getSentenceId();
      geneText = annotation.getGeneName();
      Map<Integer, Integer> occurences = Tagger.getGeneSpans(geneText);
      int begin;
      int end;
      String gene;
      for (Map.Entry<Integer, Integer> entry : occurences.entrySet())
      {
          begin = entry.getKey();
          end = entry.getValue();
          gene = geneText.substring(begin, end);
          //System.out.println("!!!!gene:"+begin+","+end+","+gene);
          begin = annotation.getGeneStart()+begin - countWhiteSpaces(geneText.substring(0,begin)) ;
          end = begin + gene.length() - countWhiteSpaces(gene) - 1;
          
//          if(genes.findGene(gene) == true ){
            NounGene ann = new NounGene(jcas);
            ann.setBegin(begin);
            ann.setEnd(end);
            ann.setSentenceId(sentenceIdentifier);
            ann.setGeneNoun(gene);
            ann.addToIndexes();
            //count++;
//          }
      }
    } 
    //System.out.println("###count#####"+count);
  }
  private int countWhiteSpaces(String phrase){
    int countBlank = 0;
    for(int i=0; i<phrase.length(); i++) {
      if(Character.isWhitespace(phrase.charAt(i))) {
          countBlank++;
      }
  }
    return countBlank;
  }

 
}
