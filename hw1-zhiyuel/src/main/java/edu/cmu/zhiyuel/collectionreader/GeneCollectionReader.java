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
//this flag make UIMA read only document and stop after that.
  private int readflag = 1;
  private String cas = "";

  public GeneCollectionReader() {
    // TODO Auto-generated constructor stub
    System.out.println("starting Collection Reader...");
  }

  /**
   * get the config parameters, and assign the document text into cas. The type of cas is string
   * */
  public void initialize() throws ResourceInitializationException {
    StringBuffer sb=new StringBuffer();
    String input = (String) getConfigParameterValue("INPUT_FILE");
    System.out.println("INPUT_FILE:" + input);
    FileReader file;
    System.out.println("Initializing Collection Reader....");
    try{
      in=new BufferedReader(new FileReader(input));
      String strs=null;
      while((strs=in.readLine())!=null){
        sb.append(strs+"\n");
      }
      
    }catch(Exception e){
      e.printStackTrace();
    }
//    System.out.println(sb.toString());
//    System.out.println("=======================");
    cas=sb.toString();
    //below method reads every 4096 characters from the file.
    /*
     try {
      file = new FileReader(input);
      in = new BufferedReader(file);
      char chars[] = new char[4096];
      //read 4096 characters from file
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
    }*/
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
    readflag = 0;//read only document and stop here
  }

  @Override
  public boolean hasNext() throws IOException, CollectionException {
    // TODO Auto-generated method stub
    if (readflag == 1)
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
