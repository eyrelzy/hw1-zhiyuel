package edu.cmu.zhiyuel.collectionreader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.collection.CollectionReader_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Progress;

public class GeneCollectionReader extends CollectionReader_ImplBase {
  private BufferedReader in;

  private int read = 1;

  private String cas = "";

  public GeneCollectionReader() {
    // TODO Auto-generated constructor stub
    System.out.println("starting...");
  }

  /**
   * get the config parameters, and assign the document text into cas. The type of cas is string
   * */
  public void initialize() throws ResourceInitializationException {
    String input = (String) getConfigParameterValue("INPUT_FILE");
    System.out.println("INPUT_FILE:" + input);
    FileReader file;
    System.out.println("Initializing Collection Reader....");
    try {
      file = new FileReader(input);
      in = new BufferedReader(file);
      char chars[] = new char[4096];
      while ((in.read(chars)) != -1) {
        cas += new String(chars);
        chars = new char[4096];
      }
      // System.out.println(cas.length());
      in.close();
      // System.out.println("==============context==============");
      // System.out.println(cas);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * update jcas, add document text cas into jcas.
   * */
  @Override
  public void getNext(CAS aCAS) throws IOException, CollectionException {
    // TODO Auto-generated method stub
    JCas jcas;
    try {
      jcas = aCAS.getJCas();
    } catch (CASException e) {
      throw new CollectionException(e);
    }
    jcas.setDocumentText(cas);
    read = 0;
  }

  @Override
  public boolean hasNext() throws IOException, CollectionException {
    // TODO Auto-generated method stub
    if (read == 1)
      return true;
    return false;
  }

  @Override
  public Progress[] getProgress() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void close() throws IOException {
    // TODO Auto-generated method stub

  }

}
