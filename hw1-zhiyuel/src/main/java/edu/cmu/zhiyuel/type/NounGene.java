

/* First created by JCasGen Sun Sep 21 17:13:25 EDT 2014 */
package edu.cmu.zhiyuel.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** consider gene as an noun phrase
 * Updated by JCasGen Sun Sep 21 17:27:54 EDT 2014
 * XML source: /Users/zhiyuel/git/hw1-zhiyuel/hw1-zhiyuel/src/main/resources/annotator/AggregateGeneAnnotatorDes.xml
 * @generated */
public class NounGene extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(NounGene.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected NounGene() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public NounGene(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public NounGene(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public NounGene(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: sentenceId

  /** getter for sentenceId - gets 
   * @generated
   * @return value of the feature 
   */
  public String getSentenceId() {
    if (NounGene_Type.featOkTst && ((NounGene_Type)jcasType).casFeat_sentenceId == null)
      jcasType.jcas.throwFeatMissing("sentenceId", "edu.cmu.zhiyuel.type.NounGene");
    return jcasType.ll_cas.ll_getStringValue(addr, ((NounGene_Type)jcasType).casFeatCode_sentenceId);}
    
  /** setter for sentenceId - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setSentenceId(String v) {
    if (NounGene_Type.featOkTst && ((NounGene_Type)jcasType).casFeat_sentenceId == null)
      jcasType.jcas.throwFeatMissing("sentenceId", "edu.cmu.zhiyuel.type.NounGene");
    jcasType.ll_cas.ll_setStringValue(addr, ((NounGene_Type)jcasType).casFeatCode_sentenceId, v);}    
   
    
  //*--------------*
  //* Feature: geneNoun

  /** getter for geneNoun - gets 
   * @generated
   * @return value of the feature 
   */
  public String getGeneNoun() {
    if (NounGene_Type.featOkTst && ((NounGene_Type)jcasType).casFeat_geneNoun == null)
      jcasType.jcas.throwFeatMissing("geneNoun", "edu.cmu.zhiyuel.type.NounGene");
    return jcasType.ll_cas.ll_getStringValue(addr, ((NounGene_Type)jcasType).casFeatCode_geneNoun);}
    
  /** setter for geneNoun - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setGeneNoun(String v) {
    if (NounGene_Type.featOkTst && ((NounGene_Type)jcasType).casFeat_geneNoun == null)
      jcasType.jcas.throwFeatMissing("geneNoun", "edu.cmu.zhiyuel.type.NounGene");
    jcasType.ll_cas.ll_setStringValue(addr, ((NounGene_Type)jcasType).casFeatCode_geneNoun, v);}    
  }

    