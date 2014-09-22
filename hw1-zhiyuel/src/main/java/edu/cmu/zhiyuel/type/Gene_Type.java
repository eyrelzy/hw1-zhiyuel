
/* First created by JCasGen Sat Sep 20 14:39:07 EDT 2014 */
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

/** 
 * Updated by JCasGen Sun Sep 21 17:27:54 EDT 2014
 * @generated */
public class Gene_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Gene_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Gene_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Gene(addr, Gene_Type.this);
  			   Gene_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Gene(addr, Gene_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Gene.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.zhiyuel.type.Gene");
 
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
      jcas.throwFeatMissing("sentenceId", "edu.cmu.zhiyuel.type.Gene");
    return ll_cas.ll_getStringValue(addr, casFeatCode_sentenceId);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setSentenceId(int addr, String v) {
        if (featOkTst && casFeat_sentenceId == null)
      jcas.throwFeatMissing("sentenceId", "edu.cmu.zhiyuel.type.Gene");
    ll_cas.ll_setStringValue(addr, casFeatCode_sentenceId, v);}
    
  
 
  /** @generated */
  final Feature casFeat_geneName;
  /** @generated */
  final int     casFeatCode_geneName;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getGeneName(int addr) {
        if (featOkTst && casFeat_geneName == null)
      jcas.throwFeatMissing("geneName", "edu.cmu.zhiyuel.type.Gene");
    return ll_cas.ll_getStringValue(addr, casFeatCode_geneName);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setGeneName(int addr, String v) {
        if (featOkTst && casFeat_geneName == null)
      jcas.throwFeatMissing("geneName", "edu.cmu.zhiyuel.type.Gene");
    ll_cas.ll_setStringValue(addr, casFeatCode_geneName, v);}
    
  
 
  /** @generated */
  final Feature casFeat_geneStart;
  /** @generated */
  final int     casFeatCode_geneStart;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getGeneStart(int addr) {
        if (featOkTst && casFeat_geneStart == null)
      jcas.throwFeatMissing("geneStart", "edu.cmu.zhiyuel.type.Gene");
    return ll_cas.ll_getIntValue(addr, casFeatCode_geneStart);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setGeneStart(int addr, int v) {
        if (featOkTst && casFeat_geneStart == null)
      jcas.throwFeatMissing("geneStart", "edu.cmu.zhiyuel.type.Gene");
    ll_cas.ll_setIntValue(addr, casFeatCode_geneStart, v);}
    
  
 
  /** @generated */
  final Feature casFeat_geneEnd;
  /** @generated */
  final int     casFeatCode_geneEnd;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getGeneEnd(int addr) {
        if (featOkTst && casFeat_geneEnd == null)
      jcas.throwFeatMissing("geneEnd", "edu.cmu.zhiyuel.type.Gene");
    return ll_cas.ll_getIntValue(addr, casFeatCode_geneEnd);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setGeneEnd(int addr, int v) {
        if (featOkTst && casFeat_geneEnd == null)
      jcas.throwFeatMissing("geneEnd", "edu.cmu.zhiyuel.type.Gene");
    ll_cas.ll_setIntValue(addr, casFeatCode_geneEnd, v);}
    
  
 
  /** @generated */
  final Feature casFeat_conf;
  /** @generated */
  final int     casFeatCode_conf;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public double getConf(int addr) {
        if (featOkTst && casFeat_conf == null)
      jcas.throwFeatMissing("conf", "edu.cmu.zhiyuel.type.Gene");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_conf);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setConf(int addr, double v) {
        if (featOkTst && casFeat_conf == null)
      jcas.throwFeatMissing("conf", "edu.cmu.zhiyuel.type.Gene");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_conf, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public Gene_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_sentenceId = jcas.getRequiredFeatureDE(casType, "sentenceId", "uima.cas.String", featOkTst);
    casFeatCode_sentenceId  = (null == casFeat_sentenceId) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_sentenceId).getCode();

 
    casFeat_geneName = jcas.getRequiredFeatureDE(casType, "geneName", "uima.cas.String", featOkTst);
    casFeatCode_geneName  = (null == casFeat_geneName) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_geneName).getCode();

 
    casFeat_geneStart = jcas.getRequiredFeatureDE(casType, "geneStart", "uima.cas.Integer", featOkTst);
    casFeatCode_geneStart  = (null == casFeat_geneStart) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_geneStart).getCode();

 
    casFeat_geneEnd = jcas.getRequiredFeatureDE(casType, "geneEnd", "uima.cas.Integer", featOkTst);
    casFeatCode_geneEnd  = (null == casFeat_geneEnd) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_geneEnd).getCode();

 
    casFeat_conf = jcas.getRequiredFeatureDE(casType, "conf", "uima.cas.Double", featOkTst);
    casFeatCode_conf  = (null == casFeat_conf) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_conf).getCode();

  }
}



    