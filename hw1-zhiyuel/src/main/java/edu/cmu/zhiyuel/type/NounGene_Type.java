
/* First created by JCasGen Sun Sep 21 17:13:25 EDT 2014 */
package edu.cmu.zhiyuel.type;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** consider gene as an noun phrase
 * Updated by JCasGen Sun Sep 21 17:27:54 EDT 2014
 * @generated */
public class NounGene_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (NounGene_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = NounGene_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new NounGene(addr, NounGene_Type.this);
  			   NounGene_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new NounGene(addr, NounGene_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = NounGene.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.zhiyuel.type.NounGene");
 
  /** @generated */
  final Feature casFeat_sentenceId;
  /** @generated */
  final int     casFeatCode_sentenceId;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getSentenceId(int addr) {
        if (featOkTst && casFeat_sentenceId == null)
      jcas.throwFeatMissing("sentenceId", "edu.cmu.zhiyuel.type.NounGene");
    return ll_cas.ll_getStringValue(addr, casFeatCode_sentenceId);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setSentenceId(int addr, String v) {
        if (featOkTst && casFeat_sentenceId == null)
      jcas.throwFeatMissing("sentenceId", "edu.cmu.zhiyuel.type.NounGene");
    ll_cas.ll_setStringValue(addr, casFeatCode_sentenceId, v);}
    
  
 
  /** @generated */
  final Feature casFeat_geneNoun;
  /** @generated */
  final int     casFeatCode_geneNoun;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getGeneNoun(int addr) {
        if (featOkTst && casFeat_geneNoun == null)
      jcas.throwFeatMissing("geneNoun", "edu.cmu.zhiyuel.type.NounGene");
    return ll_cas.ll_getStringValue(addr, casFeatCode_geneNoun);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setGeneNoun(int addr, String v) {
        if (featOkTst && casFeat_geneNoun == null)
      jcas.throwFeatMissing("geneNoun", "edu.cmu.zhiyuel.type.NounGene");
    ll_cas.ll_setStringValue(addr, casFeatCode_geneNoun, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public NounGene_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_sentenceId = jcas.getRequiredFeatureDE(casType, "sentenceId", "uima.cas.String", featOkTst);
    casFeatCode_sentenceId  = (null == casFeat_sentenceId) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_sentenceId).getCode();

 
    casFeat_geneNoun = jcas.getRequiredFeatureDE(casType, "geneNoun", "uima.cas.String", featOkTst);
    casFeatCode_geneNoun  = (null == casFeat_geneNoun) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_geneNoun).getCode();

  }
}



    