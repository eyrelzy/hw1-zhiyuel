package edu.cmu.zhiyuel.casconsumer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceProcessException;
import org.xml.sax.SAXException;

import edu.cmu.zhiyuel.type.Gene;
import edu.cmu.zhiyuel.type.NounGene;

public class GeneCasConsumer extends CasConsumer_ImplBase {
  private File out = null;

  private BufferedWriter bw = null;
  private int correct=0;
  private int cnt=0;
  private int geneNounCount=0;
  private BufferedReader br = null;
  private HashSet<String> strset;
  private int geneNamesize=0;
  public GeneCasConsumer() {
    // TODO Auto-generated constructor stub

  }

  /**
   * get the configuration parameters from .xml
   * read context from sample.out for further computing precision and recall rate
   * */
  @Override
  public void initialize() {
    String samplefile = (String) getConfigParameterValue("SAMPLE_FILE");
    strset = new HashSet<String>();
    try {
      br = new BufferedReader(new FileReader(samplefile));
      String str = null;
      while ((str = br.readLine()) != null) {
        strset.add(str);
        //System.out.println(str);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    try {
      System.out.println("OUTPUT_FILE:" + (String) getConfigParameterValue("OUTPUT_FILE"));
      out = new File((String) getConfigParameterValue("OUTPUT_FILE"));

      bw = new BufferedWriter(new FileWriter(out));
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
/**
 * @param aCAS 
 * extract the geneTag information from CAS, and write into the file as a specific format
 * */
  @Override
  public void processCas(CAS aCAS) throws ResourceProcessException {
    // TODO Auto-generated method stub
    JCas jcas;
    try {
      jcas = aCAS.getJCas();
    } catch (CASException e) {
      throw new ResourceProcessException(e);
    }

    // retrieve the filename of the input file from the CAS
    FSIterator<Annotation> it = jcas.getAnnotationIndex(Gene.type).iterator();
    System.out.println("Consuming CAS....");
    String geneIdentifier = "";
    String geneName = "";
    int start = 0, end = 0;
    while (it.hasNext()) {
      Gene annotation = (Gene) it.next();
      geneIdentifier = annotation.getSentenceId();
      geneName = annotation.getGeneName();
      start = annotation.getGeneStart();
      end = annotation.getGeneEnd();
      geneNamesize++;
      // write to output file
      try {
        writeIntoFile(geneIdentifier, geneName, start, end);
      } catch (IOException e) {
        throw new ResourceProcessException(e);
      } catch (SAXException e) {
        throw new ResourceProcessException(e);
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    /**
     * The following codes is to test the precision and recall if using standford NLP
     * */
    /*
     
    FSIterator<Annotation> it1 = jcas.getAnnotationIndex(NounGene.type).iterator();
    System.out.println("Consuming CAS22222....");
    geneIdentifier = "";
    geneName = "";
    start = 0;
    end = 0;
    while (it1.hasNext()) {
      geneNounCount++;
      NounGene annotation = (NounGene) it1.next();
      geneIdentifier = annotation.getSentenceId();
      geneName = annotation.getGeneNoun();
      start = annotation.getStart();
      end = annotation.getEnd();
      String phrase=geneIdentifier + "|" + start + " " + end + "|" + geneName;
      //System.out.println(phrase);
      if(strset.contains(phrase)){
        cnt++;
       }
      // write to output file
      try {
        writeIntoFile(geneIdentifier, geneName, start, end);
      } catch (IOException e) {
        throw new ResourceProcessException(e);
      } catch (SAXException e) {
        throw new ResourceProcessException(e);
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    System.out.println("######cnt recall#######"+cnt/strset.size());
    System.out.println("######cnt precision#######"+cnt/geneNounCount);
    * 
     * */
  }

  /**
   * @param geneIdentifier
   *          SentenceID
   * @param geneName
   * @param start
   * @param end
   *          write the information into output file in a specific format.
   * */
  public void writeIntoFile(String geneIdentifier, String geneName, int start, int end)
          throws Exception {
    
    String phrase=geneIdentifier + "|" + start + " " + end + "|" + geneName;
    if(strset.contains(phrase)){
     correct++;
    }
    bw.write(phrase);
    bw.newLine();
    bw.flush();
  }

  /**
   * close the output file, and free the memory.
   * get the evaluation information: precision and recall
   * */
  @Override
  public void destroy() {

    try {
      if (bw != null) {
        System.out.println("########correct###########"+correct);
        System.out.println("#####recall#########"+(double)correct/strset.size());
        System.out.println("#####precision#########"+(double)correct/geneNamesize);
        System.out.println("#####geneName count#########"+geneNamesize);
        bw.close();
        bw = null;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
