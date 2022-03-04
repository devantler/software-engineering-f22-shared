package xtext.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import xtext.services.FactoryLogicLangGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalFactoryLogicLangParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_VARIABLE", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'if'", "'is'", "'then'", "'for each'", "'in'", "'of'", "'that is'", "'not'", "'less than'", "'greater than'"
    };
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=6;
    public static final int RULE_WS=10;
    public static final int RULE_VARIABLE=4;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_INT=7;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalFactoryLogicLangParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalFactoryLogicLangParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalFactoryLogicLangParser.tokenNames; }
    public String getGrammarFileName() { return "InternalFactoryLogicLang.g"; }



     	private FactoryLogicLangGrammarAccess grammarAccess;

        public InternalFactoryLogicLangParser(TokenStream input, FactoryLogicLangGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected FactoryLogicLangGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalFactoryLogicLang.g:65:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalFactoryLogicLang.g:65:46: (iv_ruleModel= ruleModel EOF )
            // InternalFactoryLogicLang.g:66:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalFactoryLogicLang.g:72:1: ruleModel returns [EObject current=null] : ( (lv_declarations_0_0= ruleDeclaration ) )+ ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_declarations_0_0 = null;



        	enterRule();

        try {
            // InternalFactoryLogicLang.g:78:2: ( ( (lv_declarations_0_0= ruleDeclaration ) )+ )
            // InternalFactoryLogicLang.g:79:2: ( (lv_declarations_0_0= ruleDeclaration ) )+
            {
            // InternalFactoryLogicLang.g:79:2: ( (lv_declarations_0_0= ruleDeclaration ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12||LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalFactoryLogicLang.g:80:3: (lv_declarations_0_0= ruleDeclaration )
            	    {
            	    // InternalFactoryLogicLang.g:80:3: (lv_declarations_0_0= ruleDeclaration )
            	    // InternalFactoryLogicLang.g:81:4: lv_declarations_0_0= ruleDeclaration
            	    {

            	    				newCompositeNode(grammarAccess.getModelAccess().getDeclarationsDeclarationParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_declarations_0_0=ruleDeclaration();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getModelRule());
            	    				}
            	    				add(
            	    					current,
            	    					"declarations",
            	    					lv_declarations_0_0,
            	    					"xtext.FactoryLogicLang.Declaration");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleDeclaration"
    // InternalFactoryLogicLang.g:101:1: entryRuleDeclaration returns [EObject current=null] : iv_ruleDeclaration= ruleDeclaration EOF ;
    public final EObject entryRuleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaration = null;


        try {
            // InternalFactoryLogicLang.g:101:52: (iv_ruleDeclaration= ruleDeclaration EOF )
            // InternalFactoryLogicLang.g:102:2: iv_ruleDeclaration= ruleDeclaration EOF
            {
             newCompositeNode(grammarAccess.getDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDeclaration=ruleDeclaration();

            state._fsp--;

             current =iv_ruleDeclaration; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDeclaration"


    // $ANTLR start "ruleDeclaration"
    // InternalFactoryLogicLang.g:108:1: ruleDeclaration returns [EObject current=null] : (this_Conditional_0= ruleConditional | this_Loop_1= ruleLoop ) ;
    public final EObject ruleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_Conditional_0 = null;

        EObject this_Loop_1 = null;



        	enterRule();

        try {
            // InternalFactoryLogicLang.g:114:2: ( (this_Conditional_0= ruleConditional | this_Loop_1= ruleLoop ) )
            // InternalFactoryLogicLang.g:115:2: (this_Conditional_0= ruleConditional | this_Loop_1= ruleLoop )
            {
            // InternalFactoryLogicLang.g:115:2: (this_Conditional_0= ruleConditional | this_Loop_1= ruleLoop )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            else if ( (LA2_0==15) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalFactoryLogicLang.g:116:3: this_Conditional_0= ruleConditional
                    {

                    			newCompositeNode(grammarAccess.getDeclarationAccess().getConditionalParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Conditional_0=ruleConditional();

                    state._fsp--;


                    			current = this_Conditional_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalFactoryLogicLang.g:125:3: this_Loop_1= ruleLoop
                    {

                    			newCompositeNode(grammarAccess.getDeclarationAccess().getLoopParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Loop_1=ruleLoop();

                    state._fsp--;


                    			current = this_Loop_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDeclaration"


    // $ANTLR start "entryRuleConditional"
    // InternalFactoryLogicLang.g:137:1: entryRuleConditional returns [EObject current=null] : iv_ruleConditional= ruleConditional EOF ;
    public final EObject entryRuleConditional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditional = null;


        try {
            // InternalFactoryLogicLang.g:137:52: (iv_ruleConditional= ruleConditional EOF )
            // InternalFactoryLogicLang.g:138:2: iv_ruleConditional= ruleConditional EOF
            {
             newCompositeNode(grammarAccess.getConditionalRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConditional=ruleConditional();

            state._fsp--;

             current =iv_ruleConditional; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConditional"


    // $ANTLR start "ruleConditional"
    // InternalFactoryLogicLang.g:144:1: ruleConditional returns [EObject current=null] : (otherlv_0= 'if' ( (lv_variable_1_0= RULE_VARIABLE ) ) otherlv_2= 'is' ( (lv_operator_3_0= ruleBOOLEAN_OPERATOR ) )? ( (lv_comparison_4_0= RULE_VARIABLE ) ) otherlv_5= 'then' ) ;
    public final EObject ruleConditional() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_variable_1_0=null;
        Token otherlv_2=null;
        Token lv_comparison_4_0=null;
        Token otherlv_5=null;
        Enumerator lv_operator_3_0 = null;



        	enterRule();

        try {
            // InternalFactoryLogicLang.g:150:2: ( (otherlv_0= 'if' ( (lv_variable_1_0= RULE_VARIABLE ) ) otherlv_2= 'is' ( (lv_operator_3_0= ruleBOOLEAN_OPERATOR ) )? ( (lv_comparison_4_0= RULE_VARIABLE ) ) otherlv_5= 'then' ) )
            // InternalFactoryLogicLang.g:151:2: (otherlv_0= 'if' ( (lv_variable_1_0= RULE_VARIABLE ) ) otherlv_2= 'is' ( (lv_operator_3_0= ruleBOOLEAN_OPERATOR ) )? ( (lv_comparison_4_0= RULE_VARIABLE ) ) otherlv_5= 'then' )
            {
            // InternalFactoryLogicLang.g:151:2: (otherlv_0= 'if' ( (lv_variable_1_0= RULE_VARIABLE ) ) otherlv_2= 'is' ( (lv_operator_3_0= ruleBOOLEAN_OPERATOR ) )? ( (lv_comparison_4_0= RULE_VARIABLE ) ) otherlv_5= 'then' )
            // InternalFactoryLogicLang.g:152:3: otherlv_0= 'if' ( (lv_variable_1_0= RULE_VARIABLE ) ) otherlv_2= 'is' ( (lv_operator_3_0= ruleBOOLEAN_OPERATOR ) )? ( (lv_comparison_4_0= RULE_VARIABLE ) ) otherlv_5= 'then'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getConditionalAccess().getIfKeyword_0());
            		
            // InternalFactoryLogicLang.g:156:3: ( (lv_variable_1_0= RULE_VARIABLE ) )
            // InternalFactoryLogicLang.g:157:4: (lv_variable_1_0= RULE_VARIABLE )
            {
            // InternalFactoryLogicLang.g:157:4: (lv_variable_1_0= RULE_VARIABLE )
            // InternalFactoryLogicLang.g:158:5: lv_variable_1_0= RULE_VARIABLE
            {
            lv_variable_1_0=(Token)match(input,RULE_VARIABLE,FOLLOW_5); 

            					newLeafNode(lv_variable_1_0, grammarAccess.getConditionalAccess().getVariableVARIABLETerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConditionalRule());
            					}
            					setWithLastConsumed(
            						current,
            						"variable",
            						lv_variable_1_0,
            						"xtext.FactoryLogicLang.VARIABLE");
            				

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getConditionalAccess().getIsKeyword_2());
            		
            // InternalFactoryLogicLang.g:178:3: ( (lv_operator_3_0= ruleBOOLEAN_OPERATOR ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=19 && LA3_0<=21)) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalFactoryLogicLang.g:179:4: (lv_operator_3_0= ruleBOOLEAN_OPERATOR )
                    {
                    // InternalFactoryLogicLang.g:179:4: (lv_operator_3_0= ruleBOOLEAN_OPERATOR )
                    // InternalFactoryLogicLang.g:180:5: lv_operator_3_0= ruleBOOLEAN_OPERATOR
                    {

                    					newCompositeNode(grammarAccess.getConditionalAccess().getOperatorBOOLEAN_OPERATOREnumRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_4);
                    lv_operator_3_0=ruleBOOLEAN_OPERATOR();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getConditionalRule());
                    					}
                    					set(
                    						current,
                    						"operator",
                    						lv_operator_3_0,
                    						"xtext.FactoryLogicLang.BOOLEAN_OPERATOR");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalFactoryLogicLang.g:197:3: ( (lv_comparison_4_0= RULE_VARIABLE ) )
            // InternalFactoryLogicLang.g:198:4: (lv_comparison_4_0= RULE_VARIABLE )
            {
            // InternalFactoryLogicLang.g:198:4: (lv_comparison_4_0= RULE_VARIABLE )
            // InternalFactoryLogicLang.g:199:5: lv_comparison_4_0= RULE_VARIABLE
            {
            lv_comparison_4_0=(Token)match(input,RULE_VARIABLE,FOLLOW_7); 

            					newLeafNode(lv_comparison_4_0, grammarAccess.getConditionalAccess().getComparisonVARIABLETerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConditionalRule());
            					}
            					setWithLastConsumed(
            						current,
            						"comparison",
            						lv_comparison_4_0,
            						"xtext.FactoryLogicLang.VARIABLE");
            				

            }


            }

            otherlv_5=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getConditionalAccess().getThenKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConditional"


    // $ANTLR start "entryRuleLoop"
    // InternalFactoryLogicLang.g:223:1: entryRuleLoop returns [EObject current=null] : iv_ruleLoop= ruleLoop EOF ;
    public final EObject entryRuleLoop() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoop = null;


        try {
            // InternalFactoryLogicLang.g:223:45: (iv_ruleLoop= ruleLoop EOF )
            // InternalFactoryLogicLang.g:224:2: iv_ruleLoop= ruleLoop EOF
            {
             newCompositeNode(grammarAccess.getLoopRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLoop=ruleLoop();

            state._fsp--;

             current =iv_ruleLoop; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLoop"


    // $ANTLR start "ruleLoop"
    // InternalFactoryLogicLang.g:230:1: ruleLoop returns [EObject current=null] : (otherlv_0= 'for each' ( (lv_loopvar_1_0= RULE_VARIABLE ) ) otherlv_2= 'in' ( (lv_variable_3_0= RULE_VARIABLE ) ) (otherlv_4= 'of' ( (lv_STRING1_5_0= RULE_STRING ) ) )? otherlv_6= 'that is' ( (lv_operator_7_0= ruleBOOLEAN_OPERATOR ) )? ( (lv_comparison_8_0= RULE_VARIABLE ) ) (otherlv_9= 'of' ( (lv_STRING2_10_0= RULE_STRING ) ) )? otherlv_11= 'then' ) ;
    public final EObject ruleLoop() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_loopvar_1_0=null;
        Token otherlv_2=null;
        Token lv_variable_3_0=null;
        Token otherlv_4=null;
        Token lv_STRING1_5_0=null;
        Token otherlv_6=null;
        Token lv_comparison_8_0=null;
        Token otherlv_9=null;
        Token lv_STRING2_10_0=null;
        Token otherlv_11=null;
        Enumerator lv_operator_7_0 = null;



        	enterRule();

        try {
            // InternalFactoryLogicLang.g:236:2: ( (otherlv_0= 'for each' ( (lv_loopvar_1_0= RULE_VARIABLE ) ) otherlv_2= 'in' ( (lv_variable_3_0= RULE_VARIABLE ) ) (otherlv_4= 'of' ( (lv_STRING1_5_0= RULE_STRING ) ) )? otherlv_6= 'that is' ( (lv_operator_7_0= ruleBOOLEAN_OPERATOR ) )? ( (lv_comparison_8_0= RULE_VARIABLE ) ) (otherlv_9= 'of' ( (lv_STRING2_10_0= RULE_STRING ) ) )? otherlv_11= 'then' ) )
            // InternalFactoryLogicLang.g:237:2: (otherlv_0= 'for each' ( (lv_loopvar_1_0= RULE_VARIABLE ) ) otherlv_2= 'in' ( (lv_variable_3_0= RULE_VARIABLE ) ) (otherlv_4= 'of' ( (lv_STRING1_5_0= RULE_STRING ) ) )? otherlv_6= 'that is' ( (lv_operator_7_0= ruleBOOLEAN_OPERATOR ) )? ( (lv_comparison_8_0= RULE_VARIABLE ) ) (otherlv_9= 'of' ( (lv_STRING2_10_0= RULE_STRING ) ) )? otherlv_11= 'then' )
            {
            // InternalFactoryLogicLang.g:237:2: (otherlv_0= 'for each' ( (lv_loopvar_1_0= RULE_VARIABLE ) ) otherlv_2= 'in' ( (lv_variable_3_0= RULE_VARIABLE ) ) (otherlv_4= 'of' ( (lv_STRING1_5_0= RULE_STRING ) ) )? otherlv_6= 'that is' ( (lv_operator_7_0= ruleBOOLEAN_OPERATOR ) )? ( (lv_comparison_8_0= RULE_VARIABLE ) ) (otherlv_9= 'of' ( (lv_STRING2_10_0= RULE_STRING ) ) )? otherlv_11= 'then' )
            // InternalFactoryLogicLang.g:238:3: otherlv_0= 'for each' ( (lv_loopvar_1_0= RULE_VARIABLE ) ) otherlv_2= 'in' ( (lv_variable_3_0= RULE_VARIABLE ) ) (otherlv_4= 'of' ( (lv_STRING1_5_0= RULE_STRING ) ) )? otherlv_6= 'that is' ( (lv_operator_7_0= ruleBOOLEAN_OPERATOR ) )? ( (lv_comparison_8_0= RULE_VARIABLE ) ) (otherlv_9= 'of' ( (lv_STRING2_10_0= RULE_STRING ) ) )? otherlv_11= 'then'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getLoopAccess().getForEachKeyword_0());
            		
            // InternalFactoryLogicLang.g:242:3: ( (lv_loopvar_1_0= RULE_VARIABLE ) )
            // InternalFactoryLogicLang.g:243:4: (lv_loopvar_1_0= RULE_VARIABLE )
            {
            // InternalFactoryLogicLang.g:243:4: (lv_loopvar_1_0= RULE_VARIABLE )
            // InternalFactoryLogicLang.g:244:5: lv_loopvar_1_0= RULE_VARIABLE
            {
            lv_loopvar_1_0=(Token)match(input,RULE_VARIABLE,FOLLOW_8); 

            					newLeafNode(lv_loopvar_1_0, grammarAccess.getLoopAccess().getLoopvarVARIABLETerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLoopRule());
            					}
            					setWithLastConsumed(
            						current,
            						"loopvar",
            						lv_loopvar_1_0,
            						"xtext.FactoryLogicLang.VARIABLE");
            				

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getLoopAccess().getInKeyword_2());
            		
            // InternalFactoryLogicLang.g:264:3: ( (lv_variable_3_0= RULE_VARIABLE ) )
            // InternalFactoryLogicLang.g:265:4: (lv_variable_3_0= RULE_VARIABLE )
            {
            // InternalFactoryLogicLang.g:265:4: (lv_variable_3_0= RULE_VARIABLE )
            // InternalFactoryLogicLang.g:266:5: lv_variable_3_0= RULE_VARIABLE
            {
            lv_variable_3_0=(Token)match(input,RULE_VARIABLE,FOLLOW_9); 

            					newLeafNode(lv_variable_3_0, grammarAccess.getLoopAccess().getVariableVARIABLETerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLoopRule());
            					}
            					setWithLastConsumed(
            						current,
            						"variable",
            						lv_variable_3_0,
            						"xtext.FactoryLogicLang.VARIABLE");
            				

            }


            }

            // InternalFactoryLogicLang.g:282:3: (otherlv_4= 'of' ( (lv_STRING1_5_0= RULE_STRING ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==17) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalFactoryLogicLang.g:283:4: otherlv_4= 'of' ( (lv_STRING1_5_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,17,FOLLOW_10); 

                    				newLeafNode(otherlv_4, grammarAccess.getLoopAccess().getOfKeyword_4_0());
                    			
                    // InternalFactoryLogicLang.g:287:4: ( (lv_STRING1_5_0= RULE_STRING ) )
                    // InternalFactoryLogicLang.g:288:5: (lv_STRING1_5_0= RULE_STRING )
                    {
                    // InternalFactoryLogicLang.g:288:5: (lv_STRING1_5_0= RULE_STRING )
                    // InternalFactoryLogicLang.g:289:6: lv_STRING1_5_0= RULE_STRING
                    {
                    lv_STRING1_5_0=(Token)match(input,RULE_STRING,FOLLOW_11); 

                    						newLeafNode(lv_STRING1_5_0, grammarAccess.getLoopAccess().getSTRING1STRINGTerminalRuleCall_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLoopRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"STRING1",
                    							lv_STRING1_5_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,18,FOLLOW_6); 

            			newLeafNode(otherlv_6, grammarAccess.getLoopAccess().getThatIsKeyword_5());
            		
            // InternalFactoryLogicLang.g:310:3: ( (lv_operator_7_0= ruleBOOLEAN_OPERATOR ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=19 && LA5_0<=21)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalFactoryLogicLang.g:311:4: (lv_operator_7_0= ruleBOOLEAN_OPERATOR )
                    {
                    // InternalFactoryLogicLang.g:311:4: (lv_operator_7_0= ruleBOOLEAN_OPERATOR )
                    // InternalFactoryLogicLang.g:312:5: lv_operator_7_0= ruleBOOLEAN_OPERATOR
                    {

                    					newCompositeNode(grammarAccess.getLoopAccess().getOperatorBOOLEAN_OPERATOREnumRuleCall_6_0());
                    				
                    pushFollow(FOLLOW_4);
                    lv_operator_7_0=ruleBOOLEAN_OPERATOR();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getLoopRule());
                    					}
                    					set(
                    						current,
                    						"operator",
                    						lv_operator_7_0,
                    						"xtext.FactoryLogicLang.BOOLEAN_OPERATOR");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalFactoryLogicLang.g:329:3: ( (lv_comparison_8_0= RULE_VARIABLE ) )
            // InternalFactoryLogicLang.g:330:4: (lv_comparison_8_0= RULE_VARIABLE )
            {
            // InternalFactoryLogicLang.g:330:4: (lv_comparison_8_0= RULE_VARIABLE )
            // InternalFactoryLogicLang.g:331:5: lv_comparison_8_0= RULE_VARIABLE
            {
            lv_comparison_8_0=(Token)match(input,RULE_VARIABLE,FOLLOW_12); 

            					newLeafNode(lv_comparison_8_0, grammarAccess.getLoopAccess().getComparisonVARIABLETerminalRuleCall_7_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLoopRule());
            					}
            					setWithLastConsumed(
            						current,
            						"comparison",
            						lv_comparison_8_0,
            						"xtext.FactoryLogicLang.VARIABLE");
            				

            }


            }

            // InternalFactoryLogicLang.g:347:3: (otherlv_9= 'of' ( (lv_STRING2_10_0= RULE_STRING ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalFactoryLogicLang.g:348:4: otherlv_9= 'of' ( (lv_STRING2_10_0= RULE_STRING ) )
                    {
                    otherlv_9=(Token)match(input,17,FOLLOW_10); 

                    				newLeafNode(otherlv_9, grammarAccess.getLoopAccess().getOfKeyword_8_0());
                    			
                    // InternalFactoryLogicLang.g:352:4: ( (lv_STRING2_10_0= RULE_STRING ) )
                    // InternalFactoryLogicLang.g:353:5: (lv_STRING2_10_0= RULE_STRING )
                    {
                    // InternalFactoryLogicLang.g:353:5: (lv_STRING2_10_0= RULE_STRING )
                    // InternalFactoryLogicLang.g:354:6: lv_STRING2_10_0= RULE_STRING
                    {
                    lv_STRING2_10_0=(Token)match(input,RULE_STRING,FOLLOW_7); 

                    						newLeafNode(lv_STRING2_10_0, grammarAccess.getLoopAccess().getSTRING2STRINGTerminalRuleCall_8_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLoopRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"STRING2",
                    							lv_STRING2_10_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_11, grammarAccess.getLoopAccess().getThenKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLoop"


    // $ANTLR start "ruleBOOLEAN_OPERATOR"
    // InternalFactoryLogicLang.g:379:1: ruleBOOLEAN_OPERATOR returns [Enumerator current=null] : ( (enumLiteral_0= 'not' ) | (enumLiteral_1= 'less than' ) | (enumLiteral_2= 'greater than' ) ) ;
    public final Enumerator ruleBOOLEAN_OPERATOR() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalFactoryLogicLang.g:385:2: ( ( (enumLiteral_0= 'not' ) | (enumLiteral_1= 'less than' ) | (enumLiteral_2= 'greater than' ) ) )
            // InternalFactoryLogicLang.g:386:2: ( (enumLiteral_0= 'not' ) | (enumLiteral_1= 'less than' ) | (enumLiteral_2= 'greater than' ) )
            {
            // InternalFactoryLogicLang.g:386:2: ( (enumLiteral_0= 'not' ) | (enumLiteral_1= 'less than' ) | (enumLiteral_2= 'greater than' ) )
            int alt7=3;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt7=1;
                }
                break;
            case 20:
                {
                alt7=2;
                }
                break;
            case 21:
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalFactoryLogicLang.g:387:3: (enumLiteral_0= 'not' )
                    {
                    // InternalFactoryLogicLang.g:387:3: (enumLiteral_0= 'not' )
                    // InternalFactoryLogicLang.g:388:4: enumLiteral_0= 'not'
                    {
                    enumLiteral_0=(Token)match(input,19,FOLLOW_2); 

                    				current = grammarAccess.getBOOLEAN_OPERATORAccess().getNOTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getBOOLEAN_OPERATORAccess().getNOTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalFactoryLogicLang.g:395:3: (enumLiteral_1= 'less than' )
                    {
                    // InternalFactoryLogicLang.g:395:3: (enumLiteral_1= 'less than' )
                    // InternalFactoryLogicLang.g:396:4: enumLiteral_1= 'less than'
                    {
                    enumLiteral_1=(Token)match(input,20,FOLLOW_2); 

                    				current = grammarAccess.getBOOLEAN_OPERATORAccess().getLESSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getBOOLEAN_OPERATORAccess().getLESSEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalFactoryLogicLang.g:403:3: (enumLiteral_2= 'greater than' )
                    {
                    // InternalFactoryLogicLang.g:403:3: (enumLiteral_2= 'greater than' )
                    // InternalFactoryLogicLang.g:404:4: enumLiteral_2= 'greater than'
                    {
                    enumLiteral_2=(Token)match(input,21,FOLLOW_2); 

                    				current = grammarAccess.getBOOLEAN_OPERATORAccess().getGREATEREnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getBOOLEAN_OPERATORAccess().getGREATEREnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBOOLEAN_OPERATOR"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000009002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000380010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000024000L});

}