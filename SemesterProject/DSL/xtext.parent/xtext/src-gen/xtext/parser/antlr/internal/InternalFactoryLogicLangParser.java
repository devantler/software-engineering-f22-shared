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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "GreaterThan", "LessThan", "Finished", "Position", "Minutes", "Seconds", "Storage", "Camera", "Create", "Minute", "Pickup", "Second", "Color", "Crane", "Empty", "Equal", "Green", "Hours", "Named", "Slots", "Blue", "Drop", "Each", "Full", "Hour", "Into", "Item", "Mark", "Move", "Scan", "Slot", "That", "Then", "With", "For", "Not", "Red", "As", "At", "If", "In", "Is", "Of", "To", "RULE_BEGIN", "RULE_END", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int Each=26;
    public static final int RULE_BEGIN=48;
    public static final int Crane=17;
    public static final int Minutes=8;
    public static final int Full=27;
    public static final int Item=30;
    public static final int LessThan=5;
    public static final int GreaterThan=4;
    public static final int Equal=19;
    public static final int Then=36;
    public static final int Camera=11;
    public static final int To=47;
    public static final int Finished=6;
    public static final int Into=29;
    public static final int RULE_ID=50;
    public static final int Position=7;
    public static final int Hour=28;
    public static final int Color=16;
    public static final int For=38;
    public static final int Drop=25;
    public static final int Not=39;
    public static final int Storage=10;
    public static final int RULE_INT=51;
    public static final int RULE_ML_COMMENT=53;
    public static final int Slot=34;
    public static final int Scan=33;
    public static final int If=43;
    public static final int RULE_END=49;
    public static final int Hours=21;
    public static final int In=44;
    public static final int Mark=31;
    public static final int Is=45;
    public static final int RULE_STRING=52;
    public static final int With=37;
    public static final int RULE_SL_COMMENT=54;
    public static final int Slots=23;
    public static final int Empty=18;
    public static final int As=41;
    public static final int At=42;
    public static final int Minute=13;
    public static final int Move=32;
    public static final int Create=12;
    public static final int EOF=-1;
    public static final int That=35;
    public static final int Named=22;
    public static final int Pickup=14;
    public static final int Blue=24;
    public static final int RULE_WS=55;
    public static final int RULE_ANY_OTHER=56;
    public static final int Red=40;
    public static final int Second=15;
    public static final int Of=46;
    public static final int Seconds=9;
    public static final int Green=20;

    // delegates
    // delegators


        public InternalFactoryLogicLangParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalFactoryLogicLangParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalFactoryLogicLangParser.tokenNames; }
    public String getGrammarFileName() { return "InternalFactoryLogicLangParser.g"; }



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
    // InternalFactoryLogicLangParser.g:58:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalFactoryLogicLangParser.g:58:46: (iv_ruleModel= ruleModel EOF )
            // InternalFactoryLogicLangParser.g:59:2: iv_ruleModel= ruleModel EOF
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
    // InternalFactoryLogicLangParser.g:65:1: ruleModel returns [EObject current=null] : ( (lv_declarations_0_0= ruleDeclaration ) )+ ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_declarations_0_0 = null;



        	enterRule();

        try {
            // InternalFactoryLogicLangParser.g:71:2: ( ( (lv_declarations_0_0= ruleDeclaration ) )+ )
            // InternalFactoryLogicLangParser.g:72:2: ( (lv_declarations_0_0= ruleDeclaration ) )+
            {
            // InternalFactoryLogicLangParser.g:72:2: ( (lv_declarations_0_0= ruleDeclaration ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==Create||LA1_0==For||LA1_0==If||LA1_0==RULE_STRING) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalFactoryLogicLangParser.g:73:3: (lv_declarations_0_0= ruleDeclaration )
            	    {
            	    // InternalFactoryLogicLangParser.g:73:3: (lv_declarations_0_0= ruleDeclaration )
            	    // InternalFactoryLogicLangParser.g:74:4: lv_declarations_0_0= ruleDeclaration
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
    // InternalFactoryLogicLangParser.g:94:1: entryRuleDeclaration returns [EObject current=null] : iv_ruleDeclaration= ruleDeclaration EOF ;
    public final EObject entryRuleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaration = null;


        try {
            // InternalFactoryLogicLangParser.g:94:52: (iv_ruleDeclaration= ruleDeclaration EOF )
            // InternalFactoryLogicLangParser.g:95:2: iv_ruleDeclaration= ruleDeclaration EOF
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
    // InternalFactoryLogicLangParser.g:101:1: ruleDeclaration returns [EObject current=null] : (this_Device_0= ruleDevice | this_Logic_1= ruleLogic ) ;
    public final EObject ruleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_Device_0 = null;

        EObject this_Logic_1 = null;



        	enterRule();

        try {
            // InternalFactoryLogicLangParser.g:107:2: ( (this_Device_0= ruleDevice | this_Logic_1= ruleLogic ) )
            // InternalFactoryLogicLangParser.g:108:2: (this_Device_0= ruleDevice | this_Logic_1= ruleLogic )
            {
            // InternalFactoryLogicLangParser.g:108:2: (this_Device_0= ruleDevice | this_Logic_1= ruleLogic )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==Create) ) {
                alt2=1;
            }
            else if ( (LA2_0==For||LA2_0==If||LA2_0==RULE_STRING) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalFactoryLogicLangParser.g:109:3: this_Device_0= ruleDevice
                    {

                    			newCompositeNode(grammarAccess.getDeclarationAccess().getDeviceParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Device_0=ruleDevice();

                    state._fsp--;


                    			current = this_Device_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalFactoryLogicLangParser.g:118:3: this_Logic_1= ruleLogic
                    {

                    			newCompositeNode(grammarAccess.getDeclarationAccess().getLogicParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Logic_1=ruleLogic();

                    state._fsp--;


                    			current = this_Logic_1;
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


    // $ANTLR start "entryRuleDevice"
    // InternalFactoryLogicLangParser.g:130:1: entryRuleDevice returns [EObject current=null] : iv_ruleDevice= ruleDevice EOF ;
    public final EObject entryRuleDevice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDevice = null;


        try {
            // InternalFactoryLogicLangParser.g:130:47: (iv_ruleDevice= ruleDevice EOF )
            // InternalFactoryLogicLangParser.g:131:2: iv_ruleDevice= ruleDevice EOF
            {
             newCompositeNode(grammarAccess.getDeviceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDevice=ruleDevice();

            state._fsp--;

             current =iv_ruleDevice; 
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
    // $ANTLR end "entryRuleDevice"


    // $ANTLR start "ruleDevice"
    // InternalFactoryLogicLangParser.g:137:1: ruleDevice returns [EObject current=null] : (this_Crane_0= ruleCrane | this_Storage_1= ruleStorage | this_Camera_2= ruleCamera ) ;
    public final EObject ruleDevice() throws RecognitionException {
        EObject current = null;

        EObject this_Crane_0 = null;

        EObject this_Storage_1 = null;

        EObject this_Camera_2 = null;



        	enterRule();

        try {
            // InternalFactoryLogicLangParser.g:143:2: ( (this_Crane_0= ruleCrane | this_Storage_1= ruleStorage | this_Camera_2= ruleCamera ) )
            // InternalFactoryLogicLangParser.g:144:2: (this_Crane_0= ruleCrane | this_Storage_1= ruleStorage | this_Camera_2= ruleCamera )
            {
            // InternalFactoryLogicLangParser.g:144:2: (this_Crane_0= ruleCrane | this_Storage_1= ruleStorage | this_Camera_2= ruleCamera )
            int alt3=3;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==Create) ) {
                switch ( input.LA(2) ) {
                case Crane:
                    {
                    alt3=1;
                    }
                    break;
                case Camera:
                    {
                    alt3=3;
                    }
                    break;
                case Storage:
                    {
                    alt3=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalFactoryLogicLangParser.g:145:3: this_Crane_0= ruleCrane
                    {

                    			newCompositeNode(grammarAccess.getDeviceAccess().getCraneParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Crane_0=ruleCrane();

                    state._fsp--;


                    			current = this_Crane_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalFactoryLogicLangParser.g:154:3: this_Storage_1= ruleStorage
                    {

                    			newCompositeNode(grammarAccess.getDeviceAccess().getStorageParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Storage_1=ruleStorage();

                    state._fsp--;


                    			current = this_Storage_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalFactoryLogicLangParser.g:163:3: this_Camera_2= ruleCamera
                    {

                    			newCompositeNode(grammarAccess.getDeviceAccess().getCameraParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Camera_2=ruleCamera();

                    state._fsp--;


                    			current = this_Camera_2;
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
    // $ANTLR end "ruleDevice"


    // $ANTLR start "entryRuleCrane"
    // InternalFactoryLogicLangParser.g:175:1: entryRuleCrane returns [EObject current=null] : iv_ruleCrane= ruleCrane EOF ;
    public final EObject entryRuleCrane() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCrane = null;


        try {
            // InternalFactoryLogicLangParser.g:175:46: (iv_ruleCrane= ruleCrane EOF )
            // InternalFactoryLogicLangParser.g:176:2: iv_ruleCrane= ruleCrane EOF
            {
             newCompositeNode(grammarAccess.getCraneRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCrane=ruleCrane();

            state._fsp--;

             current =iv_ruleCrane; 
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
    // $ANTLR end "entryRuleCrane"


    // $ANTLR start "ruleCrane"
    // InternalFactoryLogicLangParser.g:182:1: ruleCrane returns [EObject current=null] : (otherlv_0= Create otherlv_1= Crane otherlv_2= Named ( (lv_name_3_0= RULE_STRING ) ) this_BEGIN_4= RULE_BEGIN ( (lv_parameters_5_0= ruleCraneParameter ) )+ this_END_6= RULE_END ) ;
    public final EObject ruleCrane() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token this_BEGIN_4=null;
        Token this_END_6=null;
        EObject lv_parameters_5_0 = null;



        	enterRule();

        try {
            // InternalFactoryLogicLangParser.g:188:2: ( (otherlv_0= Create otherlv_1= Crane otherlv_2= Named ( (lv_name_3_0= RULE_STRING ) ) this_BEGIN_4= RULE_BEGIN ( (lv_parameters_5_0= ruleCraneParameter ) )+ this_END_6= RULE_END ) )
            // InternalFactoryLogicLangParser.g:189:2: (otherlv_0= Create otherlv_1= Crane otherlv_2= Named ( (lv_name_3_0= RULE_STRING ) ) this_BEGIN_4= RULE_BEGIN ( (lv_parameters_5_0= ruleCraneParameter ) )+ this_END_6= RULE_END )
            {
            // InternalFactoryLogicLangParser.g:189:2: (otherlv_0= Create otherlv_1= Crane otherlv_2= Named ( (lv_name_3_0= RULE_STRING ) ) this_BEGIN_4= RULE_BEGIN ( (lv_parameters_5_0= ruleCraneParameter ) )+ this_END_6= RULE_END )
            // InternalFactoryLogicLangParser.g:190:3: otherlv_0= Create otherlv_1= Crane otherlv_2= Named ( (lv_name_3_0= RULE_STRING ) ) this_BEGIN_4= RULE_BEGIN ( (lv_parameters_5_0= ruleCraneParameter ) )+ this_END_6= RULE_END
            {
            otherlv_0=(Token)match(input,Create,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getCraneAccess().getCreateKeyword_0());
            		
            otherlv_1=(Token)match(input,Crane,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getCraneAccess().getCraneKeyword_1());
            		
            otherlv_2=(Token)match(input,Named,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getCraneAccess().getNamedKeyword_2());
            		
            // InternalFactoryLogicLangParser.g:202:3: ( (lv_name_3_0= RULE_STRING ) )
            // InternalFactoryLogicLangParser.g:203:4: (lv_name_3_0= RULE_STRING )
            {
            // InternalFactoryLogicLangParser.g:203:4: (lv_name_3_0= RULE_STRING )
            // InternalFactoryLogicLangParser.g:204:5: lv_name_3_0= RULE_STRING
            {
            lv_name_3_0=(Token)match(input,RULE_STRING,FOLLOW_7); 

            					newLeafNode(lv_name_3_0, grammarAccess.getCraneAccess().getNameSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCraneRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_8); 

            			newLeafNode(this_BEGIN_4, grammarAccess.getCraneAccess().getBEGINTerminalRuleCall_4());
            		
            // InternalFactoryLogicLangParser.g:224:3: ( (lv_parameters_5_0= ruleCraneParameter ) )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==With) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalFactoryLogicLangParser.g:225:4: (lv_parameters_5_0= ruleCraneParameter )
            	    {
            	    // InternalFactoryLogicLangParser.g:225:4: (lv_parameters_5_0= ruleCraneParameter )
            	    // InternalFactoryLogicLangParser.g:226:5: lv_parameters_5_0= ruleCraneParameter
            	    {

            	    					newCompositeNode(grammarAccess.getCraneAccess().getParametersCraneParameterParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_9);
            	    lv_parameters_5_0=ruleCraneParameter();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getCraneRule());
            	    					}
            	    					add(
            	    						current,
            	    						"parameters",
            	    						lv_parameters_5_0,
            	    						"xtext.FactoryLogicLang.CraneParameter");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);

            this_END_6=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_6, grammarAccess.getCraneAccess().getENDTerminalRuleCall_6());
            		

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
    // $ANTLR end "ruleCrane"


    // $ANTLR start "entryRuleCraneParameter"
    // InternalFactoryLogicLangParser.g:251:1: entryRuleCraneParameter returns [EObject current=null] : iv_ruleCraneParameter= ruleCraneParameter EOF ;
    public final EObject entryRuleCraneParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCraneParameter = null;


        try {
            // InternalFactoryLogicLangParser.g:251:55: (iv_ruleCraneParameter= ruleCraneParameter EOF )
            // InternalFactoryLogicLangParser.g:252:2: iv_ruleCraneParameter= ruleCraneParameter EOF
            {
             newCompositeNode(grammarAccess.getCraneParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCraneParameter=ruleCraneParameter();

            state._fsp--;

             current =iv_ruleCraneParameter; 
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
    // $ANTLR end "entryRuleCraneParameter"


    // $ANTLR start "ruleCraneParameter"
    // InternalFactoryLogicLangParser.g:258:1: ruleCraneParameter returns [EObject current=null] : (otherlv_0= With otherlv_1= Position otherlv_2= At ( (lv_degree_3_0= RULE_INT ) ) otherlv_4= Named ( (lv_name_5_0= RULE_STRING ) ) ) ;
    public final EObject ruleCraneParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_degree_3_0=null;
        Token otherlv_4=null;
        Token lv_name_5_0=null;


        	enterRule();

        try {
            // InternalFactoryLogicLangParser.g:264:2: ( (otherlv_0= With otherlv_1= Position otherlv_2= At ( (lv_degree_3_0= RULE_INT ) ) otherlv_4= Named ( (lv_name_5_0= RULE_STRING ) ) ) )
            // InternalFactoryLogicLangParser.g:265:2: (otherlv_0= With otherlv_1= Position otherlv_2= At ( (lv_degree_3_0= RULE_INT ) ) otherlv_4= Named ( (lv_name_5_0= RULE_STRING ) ) )
            {
            // InternalFactoryLogicLangParser.g:265:2: (otherlv_0= With otherlv_1= Position otherlv_2= At ( (lv_degree_3_0= RULE_INT ) ) otherlv_4= Named ( (lv_name_5_0= RULE_STRING ) ) )
            // InternalFactoryLogicLangParser.g:266:3: otherlv_0= With otherlv_1= Position otherlv_2= At ( (lv_degree_3_0= RULE_INT ) ) otherlv_4= Named ( (lv_name_5_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,With,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getCraneParameterAccess().getWithKeyword_0());
            		
            otherlv_1=(Token)match(input,Position,FOLLOW_11); 

            			newLeafNode(otherlv_1, grammarAccess.getCraneParameterAccess().getPositionKeyword_1());
            		
            otherlv_2=(Token)match(input,At,FOLLOW_12); 

            			newLeafNode(otherlv_2, grammarAccess.getCraneParameterAccess().getAtKeyword_2());
            		
            // InternalFactoryLogicLangParser.g:278:3: ( (lv_degree_3_0= RULE_INT ) )
            // InternalFactoryLogicLangParser.g:279:4: (lv_degree_3_0= RULE_INT )
            {
            // InternalFactoryLogicLangParser.g:279:4: (lv_degree_3_0= RULE_INT )
            // InternalFactoryLogicLangParser.g:280:5: lv_degree_3_0= RULE_INT
            {
            lv_degree_3_0=(Token)match(input,RULE_INT,FOLLOW_5); 

            					newLeafNode(lv_degree_3_0, grammarAccess.getCraneParameterAccess().getDegreeINTTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCraneParameterRule());
            					}
            					setWithLastConsumed(
            						current,
            						"degree",
            						lv_degree_3_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_4=(Token)match(input,Named,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getCraneParameterAccess().getNamedKeyword_4());
            		
            // InternalFactoryLogicLangParser.g:300:3: ( (lv_name_5_0= RULE_STRING ) )
            // InternalFactoryLogicLangParser.g:301:4: (lv_name_5_0= RULE_STRING )
            {
            // InternalFactoryLogicLangParser.g:301:4: (lv_name_5_0= RULE_STRING )
            // InternalFactoryLogicLangParser.g:302:5: lv_name_5_0= RULE_STRING
            {
            lv_name_5_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_name_5_0, grammarAccess.getCraneParameterAccess().getNameSTRINGTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCraneParameterRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_5_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


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
    // $ANTLR end "ruleCraneParameter"


    // $ANTLR start "entryRuleStorage"
    // InternalFactoryLogicLangParser.g:322:1: entryRuleStorage returns [EObject current=null] : iv_ruleStorage= ruleStorage EOF ;
    public final EObject entryRuleStorage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStorage = null;


        try {
            // InternalFactoryLogicLangParser.g:322:48: (iv_ruleStorage= ruleStorage EOF )
            // InternalFactoryLogicLangParser.g:323:2: iv_ruleStorage= ruleStorage EOF
            {
             newCompositeNode(grammarAccess.getStorageRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStorage=ruleStorage();

            state._fsp--;

             current =iv_ruleStorage; 
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
    // $ANTLR end "entryRuleStorage"


    // $ANTLR start "ruleStorage"
    // InternalFactoryLogicLangParser.g:329:1: ruleStorage returns [EObject current=null] : (otherlv_0= Create otherlv_1= Storage otherlv_2= Named ( (lv_name_3_0= RULE_STRING ) ) this_BEGIN_4= RULE_BEGIN ( (lv_parameters_5_0= ruleStorageParameter ) )+ this_END_6= RULE_END ) ;
    public final EObject ruleStorage() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token this_BEGIN_4=null;
        Token this_END_6=null;
        EObject lv_parameters_5_0 = null;



        	enterRule();

        try {
            // InternalFactoryLogicLangParser.g:335:2: ( (otherlv_0= Create otherlv_1= Storage otherlv_2= Named ( (lv_name_3_0= RULE_STRING ) ) this_BEGIN_4= RULE_BEGIN ( (lv_parameters_5_0= ruleStorageParameter ) )+ this_END_6= RULE_END ) )
            // InternalFactoryLogicLangParser.g:336:2: (otherlv_0= Create otherlv_1= Storage otherlv_2= Named ( (lv_name_3_0= RULE_STRING ) ) this_BEGIN_4= RULE_BEGIN ( (lv_parameters_5_0= ruleStorageParameter ) )+ this_END_6= RULE_END )
            {
            // InternalFactoryLogicLangParser.g:336:2: (otherlv_0= Create otherlv_1= Storage otherlv_2= Named ( (lv_name_3_0= RULE_STRING ) ) this_BEGIN_4= RULE_BEGIN ( (lv_parameters_5_0= ruleStorageParameter ) )+ this_END_6= RULE_END )
            // InternalFactoryLogicLangParser.g:337:3: otherlv_0= Create otherlv_1= Storage otherlv_2= Named ( (lv_name_3_0= RULE_STRING ) ) this_BEGIN_4= RULE_BEGIN ( (lv_parameters_5_0= ruleStorageParameter ) )+ this_END_6= RULE_END
            {
            otherlv_0=(Token)match(input,Create,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getStorageAccess().getCreateKeyword_0());
            		
            otherlv_1=(Token)match(input,Storage,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getStorageAccess().getStorageKeyword_1());
            		
            otherlv_2=(Token)match(input,Named,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getStorageAccess().getNamedKeyword_2());
            		
            // InternalFactoryLogicLangParser.g:349:3: ( (lv_name_3_0= RULE_STRING ) )
            // InternalFactoryLogicLangParser.g:350:4: (lv_name_3_0= RULE_STRING )
            {
            // InternalFactoryLogicLangParser.g:350:4: (lv_name_3_0= RULE_STRING )
            // InternalFactoryLogicLangParser.g:351:5: lv_name_3_0= RULE_STRING
            {
            lv_name_3_0=(Token)match(input,RULE_STRING,FOLLOW_7); 

            					newLeafNode(lv_name_3_0, grammarAccess.getStorageAccess().getNameSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStorageRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_8); 

            			newLeafNode(this_BEGIN_4, grammarAccess.getStorageAccess().getBEGINTerminalRuleCall_4());
            		
            // InternalFactoryLogicLangParser.g:371:3: ( (lv_parameters_5_0= ruleStorageParameter ) )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==With) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalFactoryLogicLangParser.g:372:4: (lv_parameters_5_0= ruleStorageParameter )
            	    {
            	    // InternalFactoryLogicLangParser.g:372:4: (lv_parameters_5_0= ruleStorageParameter )
            	    // InternalFactoryLogicLangParser.g:373:5: lv_parameters_5_0= ruleStorageParameter
            	    {

            	    					newCompositeNode(grammarAccess.getStorageAccess().getParametersStorageParameterParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_9);
            	    lv_parameters_5_0=ruleStorageParameter();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getStorageRule());
            	    					}
            	    					add(
            	    						current,
            	    						"parameters",
            	    						lv_parameters_5_0,
            	    						"xtext.FactoryLogicLang.StorageParameter");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

            this_END_6=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_6, grammarAccess.getStorageAccess().getENDTerminalRuleCall_6());
            		

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
    // $ANTLR end "ruleStorage"


    // $ANTLR start "entryRuleStorageParameter"
    // InternalFactoryLogicLangParser.g:398:1: entryRuleStorageParameter returns [EObject current=null] : iv_ruleStorageParameter= ruleStorageParameter EOF ;
    public final EObject entryRuleStorageParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStorageParameter = null;


        try {
            // InternalFactoryLogicLangParser.g:398:57: (iv_ruleStorageParameter= ruleStorageParameter EOF )
            // InternalFactoryLogicLangParser.g:399:2: iv_ruleStorageParameter= ruleStorageParameter EOF
            {
             newCompositeNode(grammarAccess.getStorageParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStorageParameter=ruleStorageParameter();

            state._fsp--;

             current =iv_ruleStorageParameter; 
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
    // $ANTLR end "entryRuleStorageParameter"


    // $ANTLR start "ruleStorageParameter"
    // InternalFactoryLogicLangParser.g:405:1: ruleStorageParameter returns [EObject current=null] : (this_StoragePositionParameter_0= ruleStoragePositionParameter | this_StorageSlotParameter_1= ruleStorageSlotParameter ) ;
    public final EObject ruleStorageParameter() throws RecognitionException {
        EObject current = null;

        EObject this_StoragePositionParameter_0 = null;

        EObject this_StorageSlotParameter_1 = null;



        	enterRule();

        try {
            // InternalFactoryLogicLangParser.g:411:2: ( (this_StoragePositionParameter_0= ruleStoragePositionParameter | this_StorageSlotParameter_1= ruleStorageSlotParameter ) )
            // InternalFactoryLogicLangParser.g:412:2: (this_StoragePositionParameter_0= ruleStoragePositionParameter | this_StorageSlotParameter_1= ruleStorageSlotParameter )
            {
            // InternalFactoryLogicLangParser.g:412:2: (this_StoragePositionParameter_0= ruleStoragePositionParameter | this_StorageSlotParameter_1= ruleStorageSlotParameter )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==With) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==RULE_INT) ) {
                    alt6=2;
                }
                else if ( (LA6_1==Position) ) {
                    alt6=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalFactoryLogicLangParser.g:413:3: this_StoragePositionParameter_0= ruleStoragePositionParameter
                    {

                    			newCompositeNode(grammarAccess.getStorageParameterAccess().getStoragePositionParameterParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_StoragePositionParameter_0=ruleStoragePositionParameter();

                    state._fsp--;


                    			current = this_StoragePositionParameter_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalFactoryLogicLangParser.g:422:3: this_StorageSlotParameter_1= ruleStorageSlotParameter
                    {

                    			newCompositeNode(grammarAccess.getStorageParameterAccess().getStorageSlotParameterParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_StorageSlotParameter_1=ruleStorageSlotParameter();

                    state._fsp--;


                    			current = this_StorageSlotParameter_1;
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
    // $ANTLR end "ruleStorageParameter"


    // $ANTLR start "entryRuleStorageSlotParameter"
    // InternalFactoryLogicLangParser.g:434:1: entryRuleStorageSlotParameter returns [EObject current=null] : iv_ruleStorageSlotParameter= ruleStorageSlotParameter EOF ;
    public final EObject entryRuleStorageSlotParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStorageSlotParameter = null;


        try {
            // InternalFactoryLogicLangParser.g:434:61: (iv_ruleStorageSlotParameter= ruleStorageSlotParameter EOF )
            // InternalFactoryLogicLangParser.g:435:2: iv_ruleStorageSlotParameter= ruleStorageSlotParameter EOF
            {
             newCompositeNode(grammarAccess.getStorageSlotParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStorageSlotParameter=ruleStorageSlotParameter();

            state._fsp--;

             current =iv_ruleStorageSlotParameter; 
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
    // $ANTLR end "entryRuleStorageSlotParameter"


    // $ANTLR start "ruleStorageSlotParameter"
    // InternalFactoryLogicLangParser.g:441:1: ruleStorageSlotParameter returns [EObject current=null] : (otherlv_0= With ( (lv_slots_1_0= RULE_INT ) ) otherlv_2= Slots ) ;
    public final EObject ruleStorageSlotParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_slots_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalFactoryLogicLangParser.g:447:2: ( (otherlv_0= With ( (lv_slots_1_0= RULE_INT ) ) otherlv_2= Slots ) )
            // InternalFactoryLogicLangParser.g:448:2: (otherlv_0= With ( (lv_slots_1_0= RULE_INT ) ) otherlv_2= Slots )
            {
            // InternalFactoryLogicLangParser.g:448:2: (otherlv_0= With ( (lv_slots_1_0= RULE_INT ) ) otherlv_2= Slots )
            // InternalFactoryLogicLangParser.g:449:3: otherlv_0= With ( (lv_slots_1_0= RULE_INT ) ) otherlv_2= Slots
            {
            otherlv_0=(Token)match(input,With,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getStorageSlotParameterAccess().getWithKeyword_0());
            		
            // InternalFactoryLogicLangParser.g:453:3: ( (lv_slots_1_0= RULE_INT ) )
            // InternalFactoryLogicLangParser.g:454:4: (lv_slots_1_0= RULE_INT )
            {
            // InternalFactoryLogicLangParser.g:454:4: (lv_slots_1_0= RULE_INT )
            // InternalFactoryLogicLangParser.g:455:5: lv_slots_1_0= RULE_INT
            {
            lv_slots_1_0=(Token)match(input,RULE_INT,FOLLOW_14); 

            					newLeafNode(lv_slots_1_0, grammarAccess.getStorageSlotParameterAccess().getSlotsINTTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStorageSlotParameterRule());
            					}
            					setWithLastConsumed(
            						current,
            						"slots",
            						lv_slots_1_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_2=(Token)match(input,Slots,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getStorageSlotParameterAccess().getSlotsKeyword_2());
            		

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
    // $ANTLR end "ruleStorageSlotParameter"


    // $ANTLR start "entryRuleStoragePositionParameter"
    // InternalFactoryLogicLangParser.g:479:1: entryRuleStoragePositionParameter returns [EObject current=null] : iv_ruleStoragePositionParameter= ruleStoragePositionParameter EOF ;
    public final EObject entryRuleStoragePositionParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStoragePositionParameter = null;


        try {
            // InternalFactoryLogicLangParser.g:479:65: (iv_ruleStoragePositionParameter= ruleStoragePositionParameter EOF )
            // InternalFactoryLogicLangParser.g:480:2: iv_ruleStoragePositionParameter= ruleStoragePositionParameter EOF
            {
             newCompositeNode(grammarAccess.getStoragePositionParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStoragePositionParameter=ruleStoragePositionParameter();

            state._fsp--;

             current =iv_ruleStoragePositionParameter; 
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
    // $ANTLR end "entryRuleStoragePositionParameter"


    // $ANTLR start "ruleStoragePositionParameter"
    // InternalFactoryLogicLangParser.g:486:1: ruleStoragePositionParameter returns [EObject current=null] : (otherlv_0= With otherlv_1= Position otherlv_2= At otherlv_3= Slot ( (lv_slot_4_0= RULE_INT ) ) otherlv_5= Named ( (lv_name_6_0= RULE_STRING ) ) ) ;
    public final EObject ruleStoragePositionParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_slot_4_0=null;
        Token otherlv_5=null;
        Token lv_name_6_0=null;


        	enterRule();

        try {
            // InternalFactoryLogicLangParser.g:492:2: ( (otherlv_0= With otherlv_1= Position otherlv_2= At otherlv_3= Slot ( (lv_slot_4_0= RULE_INT ) ) otherlv_5= Named ( (lv_name_6_0= RULE_STRING ) ) ) )
            // InternalFactoryLogicLangParser.g:493:2: (otherlv_0= With otherlv_1= Position otherlv_2= At otherlv_3= Slot ( (lv_slot_4_0= RULE_INT ) ) otherlv_5= Named ( (lv_name_6_0= RULE_STRING ) ) )
            {
            // InternalFactoryLogicLangParser.g:493:2: (otherlv_0= With otherlv_1= Position otherlv_2= At otherlv_3= Slot ( (lv_slot_4_0= RULE_INT ) ) otherlv_5= Named ( (lv_name_6_0= RULE_STRING ) ) )
            // InternalFactoryLogicLangParser.g:494:3: otherlv_0= With otherlv_1= Position otherlv_2= At otherlv_3= Slot ( (lv_slot_4_0= RULE_INT ) ) otherlv_5= Named ( (lv_name_6_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,With,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getStoragePositionParameterAccess().getWithKeyword_0());
            		
            otherlv_1=(Token)match(input,Position,FOLLOW_11); 

            			newLeafNode(otherlv_1, grammarAccess.getStoragePositionParameterAccess().getPositionKeyword_1());
            		
            otherlv_2=(Token)match(input,At,FOLLOW_15); 

            			newLeafNode(otherlv_2, grammarAccess.getStoragePositionParameterAccess().getAtKeyword_2());
            		
            otherlv_3=(Token)match(input,Slot,FOLLOW_12); 

            			newLeafNode(otherlv_3, grammarAccess.getStoragePositionParameterAccess().getSlotKeyword_3());
            		
            // InternalFactoryLogicLangParser.g:510:3: ( (lv_slot_4_0= RULE_INT ) )
            // InternalFactoryLogicLangParser.g:511:4: (lv_slot_4_0= RULE_INT )
            {
            // InternalFactoryLogicLangParser.g:511:4: (lv_slot_4_0= RULE_INT )
            // InternalFactoryLogicLangParser.g:512:5: lv_slot_4_0= RULE_INT
            {
            lv_slot_4_0=(Token)match(input,RULE_INT,FOLLOW_5); 

            					newLeafNode(lv_slot_4_0, grammarAccess.getStoragePositionParameterAccess().getSlotINTTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStoragePositionParameterRule());
            					}
            					setWithLastConsumed(
            						current,
            						"slot",
            						lv_slot_4_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_5=(Token)match(input,Named,FOLLOW_6); 

            			newLeafNode(otherlv_5, grammarAccess.getStoragePositionParameterAccess().getNamedKeyword_5());
            		
            // InternalFactoryLogicLangParser.g:532:3: ( (lv_name_6_0= RULE_STRING ) )
            // InternalFactoryLogicLangParser.g:533:4: (lv_name_6_0= RULE_STRING )
            {
            // InternalFactoryLogicLangParser.g:533:4: (lv_name_6_0= RULE_STRING )
            // InternalFactoryLogicLangParser.g:534:5: lv_name_6_0= RULE_STRING
            {
            lv_name_6_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_name_6_0, grammarAccess.getStoragePositionParameterAccess().getNameSTRINGTerminalRuleCall_6_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStoragePositionParameterRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_6_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


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
    // $ANTLR end "ruleStoragePositionParameter"


    // $ANTLR start "entryRuleCamera"
    // InternalFactoryLogicLangParser.g:554:1: entryRuleCamera returns [EObject current=null] : iv_ruleCamera= ruleCamera EOF ;
    public final EObject entryRuleCamera() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCamera = null;


        try {
            // InternalFactoryLogicLangParser.g:554:47: (iv_ruleCamera= ruleCamera EOF )
            // InternalFactoryLogicLangParser.g:555:2: iv_ruleCamera= ruleCamera EOF
            {
             newCompositeNode(grammarAccess.getCameraRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCamera=ruleCamera();

            state._fsp--;

             current =iv_ruleCamera; 
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
    // $ANTLR end "entryRuleCamera"


    // $ANTLR start "ruleCamera"
    // InternalFactoryLogicLangParser.g:561:1: ruleCamera returns [EObject current=null] : (otherlv_0= Create otherlv_1= Camera otherlv_2= Named ( (lv_name_3_0= RULE_STRING ) ) this_BEGIN_4= RULE_BEGIN ( (lv_parameters_5_0= ruleCameraParameter ) )+ this_END_6= RULE_END ) ;
    public final EObject ruleCamera() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token this_BEGIN_4=null;
        Token this_END_6=null;
        EObject lv_parameters_5_0 = null;



        	enterRule();

        try {
            // InternalFactoryLogicLangParser.g:567:2: ( (otherlv_0= Create otherlv_1= Camera otherlv_2= Named ( (lv_name_3_0= RULE_STRING ) ) this_BEGIN_4= RULE_BEGIN ( (lv_parameters_5_0= ruleCameraParameter ) )+ this_END_6= RULE_END ) )
            // InternalFactoryLogicLangParser.g:568:2: (otherlv_0= Create otherlv_1= Camera otherlv_2= Named ( (lv_name_3_0= RULE_STRING ) ) this_BEGIN_4= RULE_BEGIN ( (lv_parameters_5_0= ruleCameraParameter ) )+ this_END_6= RULE_END )
            {
            // InternalFactoryLogicLangParser.g:568:2: (otherlv_0= Create otherlv_1= Camera otherlv_2= Named ( (lv_name_3_0= RULE_STRING ) ) this_BEGIN_4= RULE_BEGIN ( (lv_parameters_5_0= ruleCameraParameter ) )+ this_END_6= RULE_END )
            // InternalFactoryLogicLangParser.g:569:3: otherlv_0= Create otherlv_1= Camera otherlv_2= Named ( (lv_name_3_0= RULE_STRING ) ) this_BEGIN_4= RULE_BEGIN ( (lv_parameters_5_0= ruleCameraParameter ) )+ this_END_6= RULE_END
            {
            otherlv_0=(Token)match(input,Create,FOLLOW_16); 

            			newLeafNode(otherlv_0, grammarAccess.getCameraAccess().getCreateKeyword_0());
            		
            otherlv_1=(Token)match(input,Camera,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getCameraAccess().getCameraKeyword_1());
            		
            otherlv_2=(Token)match(input,Named,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getCameraAccess().getNamedKeyword_2());
            		
            // InternalFactoryLogicLangParser.g:581:3: ( (lv_name_3_0= RULE_STRING ) )
            // InternalFactoryLogicLangParser.g:582:4: (lv_name_3_0= RULE_STRING )
            {
            // InternalFactoryLogicLangParser.g:582:4: (lv_name_3_0= RULE_STRING )
            // InternalFactoryLogicLangParser.g:583:5: lv_name_3_0= RULE_STRING
            {
            lv_name_3_0=(Token)match(input,RULE_STRING,FOLLOW_7); 

            					newLeafNode(lv_name_3_0, grammarAccess.getCameraAccess().getNameSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCameraRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_8); 

            			newLeafNode(this_BEGIN_4, grammarAccess.getCameraAccess().getBEGINTerminalRuleCall_4());
            		
            // InternalFactoryLogicLangParser.g:603:3: ( (lv_parameters_5_0= ruleCameraParameter ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==With) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalFactoryLogicLangParser.g:604:4: (lv_parameters_5_0= ruleCameraParameter )
            	    {
            	    // InternalFactoryLogicLangParser.g:604:4: (lv_parameters_5_0= ruleCameraParameter )
            	    // InternalFactoryLogicLangParser.g:605:5: lv_parameters_5_0= ruleCameraParameter
            	    {

            	    					newCompositeNode(grammarAccess.getCameraAccess().getParametersCameraParameterParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_9);
            	    lv_parameters_5_0=ruleCameraParameter();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getCameraRule());
            	    					}
            	    					add(
            	    						current,
            	    						"parameters",
            	    						lv_parameters_5_0,
            	    						"xtext.FactoryLogicLang.CameraParameter");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);

            this_END_6=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_6, grammarAccess.getCameraAccess().getENDTerminalRuleCall_6());
            		

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
    // $ANTLR end "ruleCamera"


    // $ANTLR start "entryRuleCameraParameter"
    // InternalFactoryLogicLangParser.g:630:1: entryRuleCameraParameter returns [EObject current=null] : iv_ruleCameraParameter= ruleCameraParameter EOF ;
    public final EObject entryRuleCameraParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCameraParameter = null;


        try {
            // InternalFactoryLogicLangParser.g:630:56: (iv_ruleCameraParameter= ruleCameraParameter EOF )
            // InternalFactoryLogicLangParser.g:631:2: iv_ruleCameraParameter= ruleCameraParameter EOF
            {
             newCompositeNode(grammarAccess.getCameraParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCameraParameter=ruleCameraParameter();

            state._fsp--;

             current =iv_ruleCameraParameter; 
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
    // $ANTLR end "entryRuleCameraParameter"


    // $ANTLR start "ruleCameraParameter"
    // InternalFactoryLogicLangParser.g:637:1: ruleCameraParameter returns [EObject current=null] : (otherlv_0= With otherlv_1= Color ( (lv_color_2_0= ruleCOLOR ) ) ) ;
    public final EObject ruleCameraParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Enumerator lv_color_2_0 = null;



        	enterRule();

        try {
            // InternalFactoryLogicLangParser.g:643:2: ( (otherlv_0= With otherlv_1= Color ( (lv_color_2_0= ruleCOLOR ) ) ) )
            // InternalFactoryLogicLangParser.g:644:2: (otherlv_0= With otherlv_1= Color ( (lv_color_2_0= ruleCOLOR ) ) )
            {
            // InternalFactoryLogicLangParser.g:644:2: (otherlv_0= With otherlv_1= Color ( (lv_color_2_0= ruleCOLOR ) ) )
            // InternalFactoryLogicLangParser.g:645:3: otherlv_0= With otherlv_1= Color ( (lv_color_2_0= ruleCOLOR ) )
            {
            otherlv_0=(Token)match(input,With,FOLLOW_17); 

            			newLeafNode(otherlv_0, grammarAccess.getCameraParameterAccess().getWithKeyword_0());
            		
            otherlv_1=(Token)match(input,Color,FOLLOW_18); 

            			newLeafNode(otherlv_1, grammarAccess.getCameraParameterAccess().getColorKeyword_1());
            		
            // InternalFactoryLogicLangParser.g:653:3: ( (lv_color_2_0= ruleCOLOR ) )
            // InternalFactoryLogicLangParser.g:654:4: (lv_color_2_0= ruleCOLOR )
            {
            // InternalFactoryLogicLangParser.g:654:4: (lv_color_2_0= ruleCOLOR )
            // InternalFactoryLogicLangParser.g:655:5: lv_color_2_0= ruleCOLOR
            {

            					newCompositeNode(grammarAccess.getCameraParameterAccess().getColorCOLOREnumRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_color_2_0=ruleCOLOR();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCameraParameterRule());
            					}
            					set(
            						current,
            						"color",
            						lv_color_2_0,
            						"xtext.FactoryLogicLang.COLOR");
            					afterParserOrEnumRuleCall();
            				

            }


            }


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
    // $ANTLR end "ruleCameraParameter"


    // $ANTLR start "entryRuleLogic"
    // InternalFactoryLogicLangParser.g:676:1: entryRuleLogic returns [EObject current=null] : iv_ruleLogic= ruleLogic EOF ;
    public final EObject entryRuleLogic() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogic = null;


        try {
            // InternalFactoryLogicLangParser.g:676:46: (iv_ruleLogic= ruleLogic EOF )
            // InternalFactoryLogicLangParser.g:677:2: iv_ruleLogic= ruleLogic EOF
            {
             newCompositeNode(grammarAccess.getLogicRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLogic=ruleLogic();

            state._fsp--;

             current =iv_ruleLogic; 
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
    // $ANTLR end "entryRuleLogic"


    // $ANTLR start "ruleLogic"
    // InternalFactoryLogicLangParser.g:683:1: ruleLogic returns [EObject current=null] : (this_DeviceConditional_0= ruleDeviceConditional | this_NumberConditional_1= ruleNumberConditional | this_VariableConditional_2= ruleVariableConditional | this_Loop_3= ruleLoop | this_Operation_4= ruleOperation ) ;
    public final EObject ruleLogic() throws RecognitionException {
        EObject current = null;

        EObject this_DeviceConditional_0 = null;

        EObject this_NumberConditional_1 = null;

        EObject this_VariableConditional_2 = null;

        EObject this_Loop_3 = null;

        EObject this_Operation_4 = null;



        	enterRule();

        try {
            // InternalFactoryLogicLangParser.g:689:2: ( (this_DeviceConditional_0= ruleDeviceConditional | this_NumberConditional_1= ruleNumberConditional | this_VariableConditional_2= ruleVariableConditional | this_Loop_3= ruleLoop | this_Operation_4= ruleOperation ) )
            // InternalFactoryLogicLangParser.g:690:2: (this_DeviceConditional_0= ruleDeviceConditional | this_NumberConditional_1= ruleNumberConditional | this_VariableConditional_2= ruleVariableConditional | this_Loop_3= ruleLoop | this_Operation_4= ruleOperation )
            {
            // InternalFactoryLogicLangParser.g:690:2: (this_DeviceConditional_0= ruleDeviceConditional | this_NumberConditional_1= ruleNumberConditional | this_VariableConditional_2= ruleVariableConditional | this_Loop_3= ruleLoop | this_Operation_4= ruleOperation )
            int alt8=5;
            switch ( input.LA(1) ) {
            case If:
                {
                switch ( input.LA(2) ) {
                case RULE_ID:
                    {
                    alt8=3;
                    }
                    break;
                case RULE_INT:
                    {
                    alt8=2;
                    }
                    break;
                case RULE_STRING:
                    {
                    alt8=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;
                }

                }
                break;
            case For:
                {
                alt8=4;
                }
                break;
            case RULE_STRING:
                {
                alt8=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalFactoryLogicLangParser.g:691:3: this_DeviceConditional_0= ruleDeviceConditional
                    {

                    			newCompositeNode(grammarAccess.getLogicAccess().getDeviceConditionalParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_DeviceConditional_0=ruleDeviceConditional();

                    state._fsp--;


                    			current = this_DeviceConditional_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalFactoryLogicLangParser.g:700:3: this_NumberConditional_1= ruleNumberConditional
                    {

                    			newCompositeNode(grammarAccess.getLogicAccess().getNumberConditionalParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_NumberConditional_1=ruleNumberConditional();

                    state._fsp--;


                    			current = this_NumberConditional_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalFactoryLogicLangParser.g:709:3: this_VariableConditional_2= ruleVariableConditional
                    {

                    			newCompositeNode(grammarAccess.getLogicAccess().getVariableConditionalParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_VariableConditional_2=ruleVariableConditional();

                    state._fsp--;


                    			current = this_VariableConditional_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalFactoryLogicLangParser.g:718:3: this_Loop_3= ruleLoop
                    {

                    			newCompositeNode(grammarAccess.getLogicAccess().getLoopParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_Loop_3=ruleLoop();

                    state._fsp--;


                    			current = this_Loop_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalFactoryLogicLangParser.g:727:3: this_Operation_4= ruleOperation
                    {

                    			newCompositeNode(grammarAccess.getLogicAccess().getOperationParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_Operation_4=ruleOperation();

                    state._fsp--;


                    			current = this_Operation_4;
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
    // $ANTLR end "ruleLogic"


    // $ANTLR start "entryRuleDeviceConditional"
    // InternalFactoryLogicLangParser.g:739:1: entryRuleDeviceConditional returns [EObject current=null] : iv_ruleDeviceConditional= ruleDeviceConditional EOF ;
    public final EObject entryRuleDeviceConditional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeviceConditional = null;


        try {
            // InternalFactoryLogicLangParser.g:739:58: (iv_ruleDeviceConditional= ruleDeviceConditional EOF )
            // InternalFactoryLogicLangParser.g:740:2: iv_ruleDeviceConditional= ruleDeviceConditional EOF
            {
             newCompositeNode(grammarAccess.getDeviceConditionalRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDeviceConditional=ruleDeviceConditional();

            state._fsp--;

             current =iv_ruleDeviceConditional; 
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
    // $ANTLR end "entryRuleDeviceConditional"


    // $ANTLR start "ruleDeviceConditional"
    // InternalFactoryLogicLangParser.g:746:1: ruleDeviceConditional returns [EObject current=null] : (otherlv_0= If ( (otherlv_1= RULE_STRING ) ) otherlv_2= Is ( (lv_operator_3_0= ruleBOOLEAN_OPERATOR ) )? ( ( (lv_comparison_const_4_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_5_0= ruleCOLOR ) ) | ( (lv_comparison_int_6_0= RULE_INT ) ) ) otherlv_7= Then this_BEGIN_8= RULE_BEGIN ( (lv_logics_9_0= ruleLogic ) )+ this_END_10= RULE_END ) ;
    public final EObject ruleDeviceConditional() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_comparison_int_6_0=null;
        Token otherlv_7=null;
        Token this_BEGIN_8=null;
        Token this_END_10=null;
        Enumerator lv_operator_3_0 = null;

        Enumerator lv_comparison_const_4_0 = null;

        Enumerator lv_comparison_color_5_0 = null;

        EObject lv_logics_9_0 = null;



        	enterRule();

        try {
            // InternalFactoryLogicLangParser.g:752:2: ( (otherlv_0= If ( (otherlv_1= RULE_STRING ) ) otherlv_2= Is ( (lv_operator_3_0= ruleBOOLEAN_OPERATOR ) )? ( ( (lv_comparison_const_4_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_5_0= ruleCOLOR ) ) | ( (lv_comparison_int_6_0= RULE_INT ) ) ) otherlv_7= Then this_BEGIN_8= RULE_BEGIN ( (lv_logics_9_0= ruleLogic ) )+ this_END_10= RULE_END ) )
            // InternalFactoryLogicLangParser.g:753:2: (otherlv_0= If ( (otherlv_1= RULE_STRING ) ) otherlv_2= Is ( (lv_operator_3_0= ruleBOOLEAN_OPERATOR ) )? ( ( (lv_comparison_const_4_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_5_0= ruleCOLOR ) ) | ( (lv_comparison_int_6_0= RULE_INT ) ) ) otherlv_7= Then this_BEGIN_8= RULE_BEGIN ( (lv_logics_9_0= ruleLogic ) )+ this_END_10= RULE_END )
            {
            // InternalFactoryLogicLangParser.g:753:2: (otherlv_0= If ( (otherlv_1= RULE_STRING ) ) otherlv_2= Is ( (lv_operator_3_0= ruleBOOLEAN_OPERATOR ) )? ( ( (lv_comparison_const_4_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_5_0= ruleCOLOR ) ) | ( (lv_comparison_int_6_0= RULE_INT ) ) ) otherlv_7= Then this_BEGIN_8= RULE_BEGIN ( (lv_logics_9_0= ruleLogic ) )+ this_END_10= RULE_END )
            // InternalFactoryLogicLangParser.g:754:3: otherlv_0= If ( (otherlv_1= RULE_STRING ) ) otherlv_2= Is ( (lv_operator_3_0= ruleBOOLEAN_OPERATOR ) )? ( ( (lv_comparison_const_4_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_5_0= ruleCOLOR ) ) | ( (lv_comparison_int_6_0= RULE_INT ) ) ) otherlv_7= Then this_BEGIN_8= RULE_BEGIN ( (lv_logics_9_0= ruleLogic ) )+ this_END_10= RULE_END
            {
            otherlv_0=(Token)match(input,If,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getDeviceConditionalAccess().getIfKeyword_0());
            		
            // InternalFactoryLogicLangParser.g:758:3: ( (otherlv_1= RULE_STRING ) )
            // InternalFactoryLogicLangParser.g:759:4: (otherlv_1= RULE_STRING )
            {
            // InternalFactoryLogicLangParser.g:759:4: (otherlv_1= RULE_STRING )
            // InternalFactoryLogicLangParser.g:760:5: otherlv_1= RULE_STRING
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDeviceConditionalRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_STRING,FOLLOW_19); 

            					newLeafNode(otherlv_1, grammarAccess.getDeviceConditionalAccess().getSourceDeviceCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,Is,FOLLOW_20); 

            			newLeafNode(otherlv_2, grammarAccess.getDeviceConditionalAccess().getIsKeyword_2());
            		
            // InternalFactoryLogicLangParser.g:775:3: ( (lv_operator_3_0= ruleBOOLEAN_OPERATOR ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=GreaterThan && LA9_0<=LessThan)||LA9_0==Not) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalFactoryLogicLangParser.g:776:4: (lv_operator_3_0= ruleBOOLEAN_OPERATOR )
                    {
                    // InternalFactoryLogicLangParser.g:776:4: (lv_operator_3_0= ruleBOOLEAN_OPERATOR )
                    // InternalFactoryLogicLangParser.g:777:5: lv_operator_3_0= ruleBOOLEAN_OPERATOR
                    {

                    					newCompositeNode(grammarAccess.getDeviceConditionalAccess().getOperatorBOOLEAN_OPERATOREnumRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_21);
                    lv_operator_3_0=ruleBOOLEAN_OPERATOR();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getDeviceConditionalRule());
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

            // InternalFactoryLogicLangParser.g:794:3: ( ( (lv_comparison_const_4_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_5_0= ruleCOLOR ) ) | ( (lv_comparison_int_6_0= RULE_INT ) ) )
            int alt10=3;
            switch ( input.LA(1) ) {
            case Finished:
            case Empty:
            case Full:
                {
                alt10=1;
                }
                break;
            case Green:
            case Blue:
            case Red:
                {
                alt10=2;
                }
                break;
            case RULE_INT:
                {
                alt10=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalFactoryLogicLangParser.g:795:4: ( (lv_comparison_const_4_0= ruleCONST_VARIABLES ) )
                    {
                    // InternalFactoryLogicLangParser.g:795:4: ( (lv_comparison_const_4_0= ruleCONST_VARIABLES ) )
                    // InternalFactoryLogicLangParser.g:796:5: (lv_comparison_const_4_0= ruleCONST_VARIABLES )
                    {
                    // InternalFactoryLogicLangParser.g:796:5: (lv_comparison_const_4_0= ruleCONST_VARIABLES )
                    // InternalFactoryLogicLangParser.g:797:6: lv_comparison_const_4_0= ruleCONST_VARIABLES
                    {

                    						newCompositeNode(grammarAccess.getDeviceConditionalAccess().getComparison_constCONST_VARIABLESEnumRuleCall_4_0_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_comparison_const_4_0=ruleCONST_VARIABLES();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDeviceConditionalRule());
                    						}
                    						set(
                    							current,
                    							"comparison_const",
                    							lv_comparison_const_4_0,
                    							"xtext.FactoryLogicLang.CONST_VARIABLES");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalFactoryLogicLangParser.g:815:4: ( (lv_comparison_color_5_0= ruleCOLOR ) )
                    {
                    // InternalFactoryLogicLangParser.g:815:4: ( (lv_comparison_color_5_0= ruleCOLOR ) )
                    // InternalFactoryLogicLangParser.g:816:5: (lv_comparison_color_5_0= ruleCOLOR )
                    {
                    // InternalFactoryLogicLangParser.g:816:5: (lv_comparison_color_5_0= ruleCOLOR )
                    // InternalFactoryLogicLangParser.g:817:6: lv_comparison_color_5_0= ruleCOLOR
                    {

                    						newCompositeNode(grammarAccess.getDeviceConditionalAccess().getComparison_colorCOLOREnumRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_comparison_color_5_0=ruleCOLOR();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDeviceConditionalRule());
                    						}
                    						set(
                    							current,
                    							"comparison_color",
                    							lv_comparison_color_5_0,
                    							"xtext.FactoryLogicLang.COLOR");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalFactoryLogicLangParser.g:835:4: ( (lv_comparison_int_6_0= RULE_INT ) )
                    {
                    // InternalFactoryLogicLangParser.g:835:4: ( (lv_comparison_int_6_0= RULE_INT ) )
                    // InternalFactoryLogicLangParser.g:836:5: (lv_comparison_int_6_0= RULE_INT )
                    {
                    // InternalFactoryLogicLangParser.g:836:5: (lv_comparison_int_6_0= RULE_INT )
                    // InternalFactoryLogicLangParser.g:837:6: lv_comparison_int_6_0= RULE_INT
                    {
                    lv_comparison_int_6_0=(Token)match(input,RULE_INT,FOLLOW_22); 

                    						newLeafNode(lv_comparison_int_6_0, grammarAccess.getDeviceConditionalAccess().getComparison_intINTTerminalRuleCall_4_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDeviceConditionalRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"comparison_int",
                    							lv_comparison_int_6_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,Then,FOLLOW_7); 

            			newLeafNode(otherlv_7, grammarAccess.getDeviceConditionalAccess().getThenKeyword_5());
            		
            this_BEGIN_8=(Token)match(input,RULE_BEGIN,FOLLOW_23); 

            			newLeafNode(this_BEGIN_8, grammarAccess.getDeviceConditionalAccess().getBEGINTerminalRuleCall_6());
            		
            // InternalFactoryLogicLangParser.g:862:3: ( (lv_logics_9_0= ruleLogic ) )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==For||LA11_0==If||LA11_0==RULE_STRING) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalFactoryLogicLangParser.g:863:4: (lv_logics_9_0= ruleLogic )
            	    {
            	    // InternalFactoryLogicLangParser.g:863:4: (lv_logics_9_0= ruleLogic )
            	    // InternalFactoryLogicLangParser.g:864:5: lv_logics_9_0= ruleLogic
            	    {

            	    					newCompositeNode(grammarAccess.getDeviceConditionalAccess().getLogicsLogicParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_23);
            	    lv_logics_9_0=ruleLogic();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDeviceConditionalRule());
            	    					}
            	    					add(
            	    						current,
            	    						"logics",
            	    						lv_logics_9_0,
            	    						"xtext.FactoryLogicLang.Logic");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);

            this_END_10=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_10, grammarAccess.getDeviceConditionalAccess().getENDTerminalRuleCall_8());
            		

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
    // $ANTLR end "ruleDeviceConditional"


    // $ANTLR start "entryRuleVariableConditional"
    // InternalFactoryLogicLangParser.g:889:1: entryRuleVariableConditional returns [EObject current=null] : iv_ruleVariableConditional= ruleVariableConditional EOF ;
    public final EObject entryRuleVariableConditional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableConditional = null;


        try {
            // InternalFactoryLogicLangParser.g:889:60: (iv_ruleVariableConditional= ruleVariableConditional EOF )
            // InternalFactoryLogicLangParser.g:890:2: iv_ruleVariableConditional= ruleVariableConditional EOF
            {
             newCompositeNode(grammarAccess.getVariableConditionalRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariableConditional=ruleVariableConditional();

            state._fsp--;

             current =iv_ruleVariableConditional; 
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
    // $ANTLR end "entryRuleVariableConditional"


    // $ANTLR start "ruleVariableConditional"
    // InternalFactoryLogicLangParser.g:896:1: ruleVariableConditional returns [EObject current=null] : (otherlv_0= If ( (otherlv_1= RULE_ID ) ) otherlv_2= Is ( (lv_operator_3_0= ruleBOOLEAN_OPERATOR ) )? ( ( (lv_comparison_const_4_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_5_0= ruleCOLOR ) ) | ( (lv_comparison_int_6_0= RULE_INT ) ) ) otherlv_7= Then this_BEGIN_8= RULE_BEGIN ( (lv_logics_9_0= ruleLogic ) )+ this_END_10= RULE_END ) ;
    public final EObject ruleVariableConditional() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_comparison_int_6_0=null;
        Token otherlv_7=null;
        Token this_BEGIN_8=null;
        Token this_END_10=null;
        Enumerator lv_operator_3_0 = null;

        Enumerator lv_comparison_const_4_0 = null;

        Enumerator lv_comparison_color_5_0 = null;

        EObject lv_logics_9_0 = null;



        	enterRule();

        try {
            // InternalFactoryLogicLangParser.g:902:2: ( (otherlv_0= If ( (otherlv_1= RULE_ID ) ) otherlv_2= Is ( (lv_operator_3_0= ruleBOOLEAN_OPERATOR ) )? ( ( (lv_comparison_const_4_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_5_0= ruleCOLOR ) ) | ( (lv_comparison_int_6_0= RULE_INT ) ) ) otherlv_7= Then this_BEGIN_8= RULE_BEGIN ( (lv_logics_9_0= ruleLogic ) )+ this_END_10= RULE_END ) )
            // InternalFactoryLogicLangParser.g:903:2: (otherlv_0= If ( (otherlv_1= RULE_ID ) ) otherlv_2= Is ( (lv_operator_3_0= ruleBOOLEAN_OPERATOR ) )? ( ( (lv_comparison_const_4_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_5_0= ruleCOLOR ) ) | ( (lv_comparison_int_6_0= RULE_INT ) ) ) otherlv_7= Then this_BEGIN_8= RULE_BEGIN ( (lv_logics_9_0= ruleLogic ) )+ this_END_10= RULE_END )
            {
            // InternalFactoryLogicLangParser.g:903:2: (otherlv_0= If ( (otherlv_1= RULE_ID ) ) otherlv_2= Is ( (lv_operator_3_0= ruleBOOLEAN_OPERATOR ) )? ( ( (lv_comparison_const_4_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_5_0= ruleCOLOR ) ) | ( (lv_comparison_int_6_0= RULE_INT ) ) ) otherlv_7= Then this_BEGIN_8= RULE_BEGIN ( (lv_logics_9_0= ruleLogic ) )+ this_END_10= RULE_END )
            // InternalFactoryLogicLangParser.g:904:3: otherlv_0= If ( (otherlv_1= RULE_ID ) ) otherlv_2= Is ( (lv_operator_3_0= ruleBOOLEAN_OPERATOR ) )? ( ( (lv_comparison_const_4_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_5_0= ruleCOLOR ) ) | ( (lv_comparison_int_6_0= RULE_INT ) ) ) otherlv_7= Then this_BEGIN_8= RULE_BEGIN ( (lv_logics_9_0= ruleLogic ) )+ this_END_10= RULE_END
            {
            otherlv_0=(Token)match(input,If,FOLLOW_24); 

            			newLeafNode(otherlv_0, grammarAccess.getVariableConditionalAccess().getIfKeyword_0());
            		
            // InternalFactoryLogicLangParser.g:908:3: ( (otherlv_1= RULE_ID ) )
            // InternalFactoryLogicLangParser.g:909:4: (otherlv_1= RULE_ID )
            {
            // InternalFactoryLogicLangParser.g:909:4: (otherlv_1= RULE_ID )
            // InternalFactoryLogicLangParser.g:910:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVariableConditionalRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_19); 

            					newLeafNode(otherlv_1, grammarAccess.getVariableConditionalAccess().getSourceVariableCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,Is,FOLLOW_20); 

            			newLeafNode(otherlv_2, grammarAccess.getVariableConditionalAccess().getIsKeyword_2());
            		
            // InternalFactoryLogicLangParser.g:925:3: ( (lv_operator_3_0= ruleBOOLEAN_OPERATOR ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>=GreaterThan && LA12_0<=LessThan)||LA12_0==Not) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalFactoryLogicLangParser.g:926:4: (lv_operator_3_0= ruleBOOLEAN_OPERATOR )
                    {
                    // InternalFactoryLogicLangParser.g:926:4: (lv_operator_3_0= ruleBOOLEAN_OPERATOR )
                    // InternalFactoryLogicLangParser.g:927:5: lv_operator_3_0= ruleBOOLEAN_OPERATOR
                    {

                    					newCompositeNode(grammarAccess.getVariableConditionalAccess().getOperatorBOOLEAN_OPERATOREnumRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_21);
                    lv_operator_3_0=ruleBOOLEAN_OPERATOR();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getVariableConditionalRule());
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

            // InternalFactoryLogicLangParser.g:944:3: ( ( (lv_comparison_const_4_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_5_0= ruleCOLOR ) ) | ( (lv_comparison_int_6_0= RULE_INT ) ) )
            int alt13=3;
            switch ( input.LA(1) ) {
            case Finished:
            case Empty:
            case Full:
                {
                alt13=1;
                }
                break;
            case Green:
            case Blue:
            case Red:
                {
                alt13=2;
                }
                break;
            case RULE_INT:
                {
                alt13=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalFactoryLogicLangParser.g:945:4: ( (lv_comparison_const_4_0= ruleCONST_VARIABLES ) )
                    {
                    // InternalFactoryLogicLangParser.g:945:4: ( (lv_comparison_const_4_0= ruleCONST_VARIABLES ) )
                    // InternalFactoryLogicLangParser.g:946:5: (lv_comparison_const_4_0= ruleCONST_VARIABLES )
                    {
                    // InternalFactoryLogicLangParser.g:946:5: (lv_comparison_const_4_0= ruleCONST_VARIABLES )
                    // InternalFactoryLogicLangParser.g:947:6: lv_comparison_const_4_0= ruleCONST_VARIABLES
                    {

                    						newCompositeNode(grammarAccess.getVariableConditionalAccess().getComparison_constCONST_VARIABLESEnumRuleCall_4_0_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_comparison_const_4_0=ruleCONST_VARIABLES();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getVariableConditionalRule());
                    						}
                    						set(
                    							current,
                    							"comparison_const",
                    							lv_comparison_const_4_0,
                    							"xtext.FactoryLogicLang.CONST_VARIABLES");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalFactoryLogicLangParser.g:965:4: ( (lv_comparison_color_5_0= ruleCOLOR ) )
                    {
                    // InternalFactoryLogicLangParser.g:965:4: ( (lv_comparison_color_5_0= ruleCOLOR ) )
                    // InternalFactoryLogicLangParser.g:966:5: (lv_comparison_color_5_0= ruleCOLOR )
                    {
                    // InternalFactoryLogicLangParser.g:966:5: (lv_comparison_color_5_0= ruleCOLOR )
                    // InternalFactoryLogicLangParser.g:967:6: lv_comparison_color_5_0= ruleCOLOR
                    {

                    						newCompositeNode(grammarAccess.getVariableConditionalAccess().getComparison_colorCOLOREnumRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_comparison_color_5_0=ruleCOLOR();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getVariableConditionalRule());
                    						}
                    						set(
                    							current,
                    							"comparison_color",
                    							lv_comparison_color_5_0,
                    							"xtext.FactoryLogicLang.COLOR");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalFactoryLogicLangParser.g:985:4: ( (lv_comparison_int_6_0= RULE_INT ) )
                    {
                    // InternalFactoryLogicLangParser.g:985:4: ( (lv_comparison_int_6_0= RULE_INT ) )
                    // InternalFactoryLogicLangParser.g:986:5: (lv_comparison_int_6_0= RULE_INT )
                    {
                    // InternalFactoryLogicLangParser.g:986:5: (lv_comparison_int_6_0= RULE_INT )
                    // InternalFactoryLogicLangParser.g:987:6: lv_comparison_int_6_0= RULE_INT
                    {
                    lv_comparison_int_6_0=(Token)match(input,RULE_INT,FOLLOW_22); 

                    						newLeafNode(lv_comparison_int_6_0, grammarAccess.getVariableConditionalAccess().getComparison_intINTTerminalRuleCall_4_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getVariableConditionalRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"comparison_int",
                    							lv_comparison_int_6_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,Then,FOLLOW_7); 

            			newLeafNode(otherlv_7, grammarAccess.getVariableConditionalAccess().getThenKeyword_5());
            		
            this_BEGIN_8=(Token)match(input,RULE_BEGIN,FOLLOW_23); 

            			newLeafNode(this_BEGIN_8, grammarAccess.getVariableConditionalAccess().getBEGINTerminalRuleCall_6());
            		
            // InternalFactoryLogicLangParser.g:1012:3: ( (lv_logics_9_0= ruleLogic ) )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==For||LA14_0==If||LA14_0==RULE_STRING) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalFactoryLogicLangParser.g:1013:4: (lv_logics_9_0= ruleLogic )
            	    {
            	    // InternalFactoryLogicLangParser.g:1013:4: (lv_logics_9_0= ruleLogic )
            	    // InternalFactoryLogicLangParser.g:1014:5: lv_logics_9_0= ruleLogic
            	    {

            	    					newCompositeNode(grammarAccess.getVariableConditionalAccess().getLogicsLogicParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_23);
            	    lv_logics_9_0=ruleLogic();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getVariableConditionalRule());
            	    					}
            	    					add(
            	    						current,
            	    						"logics",
            	    						lv_logics_9_0,
            	    						"xtext.FactoryLogicLang.Logic");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);

            this_END_10=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_10, grammarAccess.getVariableConditionalAccess().getENDTerminalRuleCall_8());
            		

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
    // $ANTLR end "ruleVariableConditional"


    // $ANTLR start "entryRuleNumberConditional"
    // InternalFactoryLogicLangParser.g:1039:1: entryRuleNumberConditional returns [EObject current=null] : iv_ruleNumberConditional= ruleNumberConditional EOF ;
    public final EObject entryRuleNumberConditional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberConditional = null;


        try {
            // InternalFactoryLogicLangParser.g:1039:58: (iv_ruleNumberConditional= ruleNumberConditional EOF )
            // InternalFactoryLogicLangParser.g:1040:2: iv_ruleNumberConditional= ruleNumberConditional EOF
            {
             newCompositeNode(grammarAccess.getNumberConditionalRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumberConditional=ruleNumberConditional();

            state._fsp--;

             current =iv_ruleNumberConditional; 
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
    // $ANTLR end "entryRuleNumberConditional"


    // $ANTLR start "ruleNumberConditional"
    // InternalFactoryLogicLangParser.g:1046:1: ruleNumberConditional returns [EObject current=null] : (otherlv_0= If ( (lv_source_int_1_0= RULE_INT ) ) otherlv_2= Is ( (lv_operator_3_0= ruleBOOLEAN_OPERATOR ) )? otherlv_4= Equal otherlv_5= To ( ( (lv_comparison_const_6_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_7_0= ruleCOLOR ) ) | ( (lv_comparison_int_8_0= RULE_INT ) ) ) otherlv_9= Then this_BEGIN_10= RULE_BEGIN ( (lv_logics_11_0= ruleLogic ) )+ this_END_12= RULE_END ) ;
    public final EObject ruleNumberConditional() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_source_int_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_comparison_int_8_0=null;
        Token otherlv_9=null;
        Token this_BEGIN_10=null;
        Token this_END_12=null;
        Enumerator lv_operator_3_0 = null;

        Enumerator lv_comparison_const_6_0 = null;

        Enumerator lv_comparison_color_7_0 = null;

        EObject lv_logics_11_0 = null;



        	enterRule();

        try {
            // InternalFactoryLogicLangParser.g:1052:2: ( (otherlv_0= If ( (lv_source_int_1_0= RULE_INT ) ) otherlv_2= Is ( (lv_operator_3_0= ruleBOOLEAN_OPERATOR ) )? otherlv_4= Equal otherlv_5= To ( ( (lv_comparison_const_6_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_7_0= ruleCOLOR ) ) | ( (lv_comparison_int_8_0= RULE_INT ) ) ) otherlv_9= Then this_BEGIN_10= RULE_BEGIN ( (lv_logics_11_0= ruleLogic ) )+ this_END_12= RULE_END ) )
            // InternalFactoryLogicLangParser.g:1053:2: (otherlv_0= If ( (lv_source_int_1_0= RULE_INT ) ) otherlv_2= Is ( (lv_operator_3_0= ruleBOOLEAN_OPERATOR ) )? otherlv_4= Equal otherlv_5= To ( ( (lv_comparison_const_6_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_7_0= ruleCOLOR ) ) | ( (lv_comparison_int_8_0= RULE_INT ) ) ) otherlv_9= Then this_BEGIN_10= RULE_BEGIN ( (lv_logics_11_0= ruleLogic ) )+ this_END_12= RULE_END )
            {
            // InternalFactoryLogicLangParser.g:1053:2: (otherlv_0= If ( (lv_source_int_1_0= RULE_INT ) ) otherlv_2= Is ( (lv_operator_3_0= ruleBOOLEAN_OPERATOR ) )? otherlv_4= Equal otherlv_5= To ( ( (lv_comparison_const_6_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_7_0= ruleCOLOR ) ) | ( (lv_comparison_int_8_0= RULE_INT ) ) ) otherlv_9= Then this_BEGIN_10= RULE_BEGIN ( (lv_logics_11_0= ruleLogic ) )+ this_END_12= RULE_END )
            // InternalFactoryLogicLangParser.g:1054:3: otherlv_0= If ( (lv_source_int_1_0= RULE_INT ) ) otherlv_2= Is ( (lv_operator_3_0= ruleBOOLEAN_OPERATOR ) )? otherlv_4= Equal otherlv_5= To ( ( (lv_comparison_const_6_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_7_0= ruleCOLOR ) ) | ( (lv_comparison_int_8_0= RULE_INT ) ) ) otherlv_9= Then this_BEGIN_10= RULE_BEGIN ( (lv_logics_11_0= ruleLogic ) )+ this_END_12= RULE_END
            {
            otherlv_0=(Token)match(input,If,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getNumberConditionalAccess().getIfKeyword_0());
            		
            // InternalFactoryLogicLangParser.g:1058:3: ( (lv_source_int_1_0= RULE_INT ) )
            // InternalFactoryLogicLangParser.g:1059:4: (lv_source_int_1_0= RULE_INT )
            {
            // InternalFactoryLogicLangParser.g:1059:4: (lv_source_int_1_0= RULE_INT )
            // InternalFactoryLogicLangParser.g:1060:5: lv_source_int_1_0= RULE_INT
            {
            lv_source_int_1_0=(Token)match(input,RULE_INT,FOLLOW_19); 

            					newLeafNode(lv_source_int_1_0, grammarAccess.getNumberConditionalAccess().getSource_intINTTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getNumberConditionalRule());
            					}
            					setWithLastConsumed(
            						current,
            						"source_int",
            						lv_source_int_1_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_2=(Token)match(input,Is,FOLLOW_25); 

            			newLeafNode(otherlv_2, grammarAccess.getNumberConditionalAccess().getIsKeyword_2());
            		
            // InternalFactoryLogicLangParser.g:1080:3: ( (lv_operator_3_0= ruleBOOLEAN_OPERATOR ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=GreaterThan && LA15_0<=LessThan)||LA15_0==Not) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalFactoryLogicLangParser.g:1081:4: (lv_operator_3_0= ruleBOOLEAN_OPERATOR )
                    {
                    // InternalFactoryLogicLangParser.g:1081:4: (lv_operator_3_0= ruleBOOLEAN_OPERATOR )
                    // InternalFactoryLogicLangParser.g:1082:5: lv_operator_3_0= ruleBOOLEAN_OPERATOR
                    {

                    					newCompositeNode(grammarAccess.getNumberConditionalAccess().getOperatorBOOLEAN_OPERATOREnumRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_26);
                    lv_operator_3_0=ruleBOOLEAN_OPERATOR();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getNumberConditionalRule());
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

            otherlv_4=(Token)match(input,Equal,FOLLOW_27); 

            			newLeafNode(otherlv_4, grammarAccess.getNumberConditionalAccess().getEqualKeyword_4());
            		
            otherlv_5=(Token)match(input,To,FOLLOW_21); 

            			newLeafNode(otherlv_5, grammarAccess.getNumberConditionalAccess().getToKeyword_5());
            		
            // InternalFactoryLogicLangParser.g:1107:3: ( ( (lv_comparison_const_6_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_7_0= ruleCOLOR ) ) | ( (lv_comparison_int_8_0= RULE_INT ) ) )
            int alt16=3;
            switch ( input.LA(1) ) {
            case Finished:
            case Empty:
            case Full:
                {
                alt16=1;
                }
                break;
            case Green:
            case Blue:
            case Red:
                {
                alt16=2;
                }
                break;
            case RULE_INT:
                {
                alt16=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalFactoryLogicLangParser.g:1108:4: ( (lv_comparison_const_6_0= ruleCONST_VARIABLES ) )
                    {
                    // InternalFactoryLogicLangParser.g:1108:4: ( (lv_comparison_const_6_0= ruleCONST_VARIABLES ) )
                    // InternalFactoryLogicLangParser.g:1109:5: (lv_comparison_const_6_0= ruleCONST_VARIABLES )
                    {
                    // InternalFactoryLogicLangParser.g:1109:5: (lv_comparison_const_6_0= ruleCONST_VARIABLES )
                    // InternalFactoryLogicLangParser.g:1110:6: lv_comparison_const_6_0= ruleCONST_VARIABLES
                    {

                    						newCompositeNode(grammarAccess.getNumberConditionalAccess().getComparison_constCONST_VARIABLESEnumRuleCall_6_0_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_comparison_const_6_0=ruleCONST_VARIABLES();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getNumberConditionalRule());
                    						}
                    						set(
                    							current,
                    							"comparison_const",
                    							lv_comparison_const_6_0,
                    							"xtext.FactoryLogicLang.CONST_VARIABLES");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalFactoryLogicLangParser.g:1128:4: ( (lv_comparison_color_7_0= ruleCOLOR ) )
                    {
                    // InternalFactoryLogicLangParser.g:1128:4: ( (lv_comparison_color_7_0= ruleCOLOR ) )
                    // InternalFactoryLogicLangParser.g:1129:5: (lv_comparison_color_7_0= ruleCOLOR )
                    {
                    // InternalFactoryLogicLangParser.g:1129:5: (lv_comparison_color_7_0= ruleCOLOR )
                    // InternalFactoryLogicLangParser.g:1130:6: lv_comparison_color_7_0= ruleCOLOR
                    {

                    						newCompositeNode(grammarAccess.getNumberConditionalAccess().getComparison_colorCOLOREnumRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_comparison_color_7_0=ruleCOLOR();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getNumberConditionalRule());
                    						}
                    						set(
                    							current,
                    							"comparison_color",
                    							lv_comparison_color_7_0,
                    							"xtext.FactoryLogicLang.COLOR");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalFactoryLogicLangParser.g:1148:4: ( (lv_comparison_int_8_0= RULE_INT ) )
                    {
                    // InternalFactoryLogicLangParser.g:1148:4: ( (lv_comparison_int_8_0= RULE_INT ) )
                    // InternalFactoryLogicLangParser.g:1149:5: (lv_comparison_int_8_0= RULE_INT )
                    {
                    // InternalFactoryLogicLangParser.g:1149:5: (lv_comparison_int_8_0= RULE_INT )
                    // InternalFactoryLogicLangParser.g:1150:6: lv_comparison_int_8_0= RULE_INT
                    {
                    lv_comparison_int_8_0=(Token)match(input,RULE_INT,FOLLOW_22); 

                    						newLeafNode(lv_comparison_int_8_0, grammarAccess.getNumberConditionalAccess().getComparison_intINTTerminalRuleCall_6_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNumberConditionalRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"comparison_int",
                    							lv_comparison_int_8_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,Then,FOLLOW_7); 

            			newLeafNode(otherlv_9, grammarAccess.getNumberConditionalAccess().getThenKeyword_7());
            		
            this_BEGIN_10=(Token)match(input,RULE_BEGIN,FOLLOW_23); 

            			newLeafNode(this_BEGIN_10, grammarAccess.getNumberConditionalAccess().getBEGINTerminalRuleCall_8());
            		
            // InternalFactoryLogicLangParser.g:1175:3: ( (lv_logics_11_0= ruleLogic ) )+
            int cnt17=0;
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==For||LA17_0==If||LA17_0==RULE_STRING) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalFactoryLogicLangParser.g:1176:4: (lv_logics_11_0= ruleLogic )
            	    {
            	    // InternalFactoryLogicLangParser.g:1176:4: (lv_logics_11_0= ruleLogic )
            	    // InternalFactoryLogicLangParser.g:1177:5: lv_logics_11_0= ruleLogic
            	    {

            	    					newCompositeNode(grammarAccess.getNumberConditionalAccess().getLogicsLogicParserRuleCall_9_0());
            	    				
            	    pushFollow(FOLLOW_23);
            	    lv_logics_11_0=ruleLogic();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getNumberConditionalRule());
            	    					}
            	    					add(
            	    						current,
            	    						"logics",
            	    						lv_logics_11_0,
            	    						"xtext.FactoryLogicLang.Logic");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt17 >= 1 ) break loop17;
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        throw eee;
                }
                cnt17++;
            } while (true);

            this_END_12=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_12, grammarAccess.getNumberConditionalAccess().getENDTerminalRuleCall_10());
            		

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
    // $ANTLR end "ruleNumberConditional"


    // $ANTLR start "entryRuleLoop"
    // InternalFactoryLogicLangParser.g:1202:1: entryRuleLoop returns [EObject current=null] : iv_ruleLoop= ruleLoop EOF ;
    public final EObject entryRuleLoop() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoop = null;


        try {
            // InternalFactoryLogicLangParser.g:1202:45: (iv_ruleLoop= ruleLoop EOF )
            // InternalFactoryLogicLangParser.g:1203:2: iv_ruleLoop= ruleLoop EOF
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
    // InternalFactoryLogicLangParser.g:1209:1: ruleLoop returns [EObject current=null] : (otherlv_0= For ( (lv_variable_1_0= ruleLoopVariable ) ) otherlv_2= In ( (lv_list_3_0= RULE_ID ) ) (otherlv_4= Of ( (otherlv_5= RULE_STRING ) ) )? otherlv_6= That otherlv_7= Is ( (lv_operator_8_0= ruleBOOLEAN_OPERATOR ) )? ( ( (lv_comparison_const_9_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_10_0= ruleCOLOR ) ) | ( (lv_comparison_int_11_0= RULE_INT ) ) ) otherlv_12= Then this_BEGIN_13= RULE_BEGIN ( (lv_logics_14_0= ruleLogic ) )+ this_END_15= RULE_END ) ;
    public final EObject ruleLoop() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_list_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_comparison_int_11_0=null;
        Token otherlv_12=null;
        Token this_BEGIN_13=null;
        Token this_END_15=null;
        EObject lv_variable_1_0 = null;

        Enumerator lv_operator_8_0 = null;

        Enumerator lv_comparison_const_9_0 = null;

        Enumerator lv_comparison_color_10_0 = null;

        EObject lv_logics_14_0 = null;



        	enterRule();

        try {
            // InternalFactoryLogicLangParser.g:1215:2: ( (otherlv_0= For ( (lv_variable_1_0= ruleLoopVariable ) ) otherlv_2= In ( (lv_list_3_0= RULE_ID ) ) (otherlv_4= Of ( (otherlv_5= RULE_STRING ) ) )? otherlv_6= That otherlv_7= Is ( (lv_operator_8_0= ruleBOOLEAN_OPERATOR ) )? ( ( (lv_comparison_const_9_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_10_0= ruleCOLOR ) ) | ( (lv_comparison_int_11_0= RULE_INT ) ) ) otherlv_12= Then this_BEGIN_13= RULE_BEGIN ( (lv_logics_14_0= ruleLogic ) )+ this_END_15= RULE_END ) )
            // InternalFactoryLogicLangParser.g:1216:2: (otherlv_0= For ( (lv_variable_1_0= ruleLoopVariable ) ) otherlv_2= In ( (lv_list_3_0= RULE_ID ) ) (otherlv_4= Of ( (otherlv_5= RULE_STRING ) ) )? otherlv_6= That otherlv_7= Is ( (lv_operator_8_0= ruleBOOLEAN_OPERATOR ) )? ( ( (lv_comparison_const_9_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_10_0= ruleCOLOR ) ) | ( (lv_comparison_int_11_0= RULE_INT ) ) ) otherlv_12= Then this_BEGIN_13= RULE_BEGIN ( (lv_logics_14_0= ruleLogic ) )+ this_END_15= RULE_END )
            {
            // InternalFactoryLogicLangParser.g:1216:2: (otherlv_0= For ( (lv_variable_1_0= ruleLoopVariable ) ) otherlv_2= In ( (lv_list_3_0= RULE_ID ) ) (otherlv_4= Of ( (otherlv_5= RULE_STRING ) ) )? otherlv_6= That otherlv_7= Is ( (lv_operator_8_0= ruleBOOLEAN_OPERATOR ) )? ( ( (lv_comparison_const_9_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_10_0= ruleCOLOR ) ) | ( (lv_comparison_int_11_0= RULE_INT ) ) ) otherlv_12= Then this_BEGIN_13= RULE_BEGIN ( (lv_logics_14_0= ruleLogic ) )+ this_END_15= RULE_END )
            // InternalFactoryLogicLangParser.g:1217:3: otherlv_0= For ( (lv_variable_1_0= ruleLoopVariable ) ) otherlv_2= In ( (lv_list_3_0= RULE_ID ) ) (otherlv_4= Of ( (otherlv_5= RULE_STRING ) ) )? otherlv_6= That otherlv_7= Is ( (lv_operator_8_0= ruleBOOLEAN_OPERATOR ) )? ( ( (lv_comparison_const_9_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_10_0= ruleCOLOR ) ) | ( (lv_comparison_int_11_0= RULE_INT ) ) ) otherlv_12= Then this_BEGIN_13= RULE_BEGIN ( (lv_logics_14_0= ruleLogic ) )+ this_END_15= RULE_END
            {
            otherlv_0=(Token)match(input,For,FOLLOW_28); 

            			newLeafNode(otherlv_0, grammarAccess.getLoopAccess().getForKeyword_0());
            		
            // InternalFactoryLogicLangParser.g:1221:3: ( (lv_variable_1_0= ruleLoopVariable ) )
            // InternalFactoryLogicLangParser.g:1222:4: (lv_variable_1_0= ruleLoopVariable )
            {
            // InternalFactoryLogicLangParser.g:1222:4: (lv_variable_1_0= ruleLoopVariable )
            // InternalFactoryLogicLangParser.g:1223:5: lv_variable_1_0= ruleLoopVariable
            {

            					newCompositeNode(grammarAccess.getLoopAccess().getVariableLoopVariableParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_29);
            lv_variable_1_0=ruleLoopVariable();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLoopRule());
            					}
            					set(
            						current,
            						"variable",
            						lv_variable_1_0,
            						"xtext.FactoryLogicLang.LoopVariable");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,In,FOLLOW_24); 

            			newLeafNode(otherlv_2, grammarAccess.getLoopAccess().getInKeyword_2());
            		
            // InternalFactoryLogicLangParser.g:1244:3: ( (lv_list_3_0= RULE_ID ) )
            // InternalFactoryLogicLangParser.g:1245:4: (lv_list_3_0= RULE_ID )
            {
            // InternalFactoryLogicLangParser.g:1245:4: (lv_list_3_0= RULE_ID )
            // InternalFactoryLogicLangParser.g:1246:5: lv_list_3_0= RULE_ID
            {
            lv_list_3_0=(Token)match(input,RULE_ID,FOLLOW_30); 

            					newLeafNode(lv_list_3_0, grammarAccess.getLoopAccess().getListIDTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLoopRule());
            					}
            					setWithLastConsumed(
            						current,
            						"list",
            						lv_list_3_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalFactoryLogicLangParser.g:1262:3: (otherlv_4= Of ( (otherlv_5= RULE_STRING ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==Of) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalFactoryLogicLangParser.g:1263:4: otherlv_4= Of ( (otherlv_5= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,Of,FOLLOW_6); 

                    				newLeafNode(otherlv_4, grammarAccess.getLoopAccess().getOfKeyword_4_0());
                    			
                    // InternalFactoryLogicLangParser.g:1267:4: ( (otherlv_5= RULE_STRING ) )
                    // InternalFactoryLogicLangParser.g:1268:5: (otherlv_5= RULE_STRING )
                    {
                    // InternalFactoryLogicLangParser.g:1268:5: (otherlv_5= RULE_STRING )
                    // InternalFactoryLogicLangParser.g:1269:6: otherlv_5= RULE_STRING
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLoopRule());
                    						}
                    					
                    otherlv_5=(Token)match(input,RULE_STRING,FOLLOW_31); 

                    						newLeafNode(otherlv_5, grammarAccess.getLoopAccess().getSourceDeviceCrossReference_4_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,That,FOLLOW_19); 

            			newLeafNode(otherlv_6, grammarAccess.getLoopAccess().getThatKeyword_5());
            		
            otherlv_7=(Token)match(input,Is,FOLLOW_20); 

            			newLeafNode(otherlv_7, grammarAccess.getLoopAccess().getIsKeyword_6());
            		
            // InternalFactoryLogicLangParser.g:1289:3: ( (lv_operator_8_0= ruleBOOLEAN_OPERATOR ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=GreaterThan && LA19_0<=LessThan)||LA19_0==Not) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalFactoryLogicLangParser.g:1290:4: (lv_operator_8_0= ruleBOOLEAN_OPERATOR )
                    {
                    // InternalFactoryLogicLangParser.g:1290:4: (lv_operator_8_0= ruleBOOLEAN_OPERATOR )
                    // InternalFactoryLogicLangParser.g:1291:5: lv_operator_8_0= ruleBOOLEAN_OPERATOR
                    {

                    					newCompositeNode(grammarAccess.getLoopAccess().getOperatorBOOLEAN_OPERATOREnumRuleCall_7_0());
                    				
                    pushFollow(FOLLOW_21);
                    lv_operator_8_0=ruleBOOLEAN_OPERATOR();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getLoopRule());
                    					}
                    					set(
                    						current,
                    						"operator",
                    						lv_operator_8_0,
                    						"xtext.FactoryLogicLang.BOOLEAN_OPERATOR");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalFactoryLogicLangParser.g:1308:3: ( ( (lv_comparison_const_9_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_10_0= ruleCOLOR ) ) | ( (lv_comparison_int_11_0= RULE_INT ) ) )
            int alt20=3;
            switch ( input.LA(1) ) {
            case Finished:
            case Empty:
            case Full:
                {
                alt20=1;
                }
                break;
            case Green:
            case Blue:
            case Red:
                {
                alt20=2;
                }
                break;
            case RULE_INT:
                {
                alt20=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // InternalFactoryLogicLangParser.g:1309:4: ( (lv_comparison_const_9_0= ruleCONST_VARIABLES ) )
                    {
                    // InternalFactoryLogicLangParser.g:1309:4: ( (lv_comparison_const_9_0= ruleCONST_VARIABLES ) )
                    // InternalFactoryLogicLangParser.g:1310:5: (lv_comparison_const_9_0= ruleCONST_VARIABLES )
                    {
                    // InternalFactoryLogicLangParser.g:1310:5: (lv_comparison_const_9_0= ruleCONST_VARIABLES )
                    // InternalFactoryLogicLangParser.g:1311:6: lv_comparison_const_9_0= ruleCONST_VARIABLES
                    {

                    						newCompositeNode(grammarAccess.getLoopAccess().getComparison_constCONST_VARIABLESEnumRuleCall_8_0_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_comparison_const_9_0=ruleCONST_VARIABLES();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getLoopRule());
                    						}
                    						set(
                    							current,
                    							"comparison_const",
                    							lv_comparison_const_9_0,
                    							"xtext.FactoryLogicLang.CONST_VARIABLES");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalFactoryLogicLangParser.g:1329:4: ( (lv_comparison_color_10_0= ruleCOLOR ) )
                    {
                    // InternalFactoryLogicLangParser.g:1329:4: ( (lv_comparison_color_10_0= ruleCOLOR ) )
                    // InternalFactoryLogicLangParser.g:1330:5: (lv_comparison_color_10_0= ruleCOLOR )
                    {
                    // InternalFactoryLogicLangParser.g:1330:5: (lv_comparison_color_10_0= ruleCOLOR )
                    // InternalFactoryLogicLangParser.g:1331:6: lv_comparison_color_10_0= ruleCOLOR
                    {

                    						newCompositeNode(grammarAccess.getLoopAccess().getComparison_colorCOLOREnumRuleCall_8_1_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_comparison_color_10_0=ruleCOLOR();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getLoopRule());
                    						}
                    						set(
                    							current,
                    							"comparison_color",
                    							lv_comparison_color_10_0,
                    							"xtext.FactoryLogicLang.COLOR");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalFactoryLogicLangParser.g:1349:4: ( (lv_comparison_int_11_0= RULE_INT ) )
                    {
                    // InternalFactoryLogicLangParser.g:1349:4: ( (lv_comparison_int_11_0= RULE_INT ) )
                    // InternalFactoryLogicLangParser.g:1350:5: (lv_comparison_int_11_0= RULE_INT )
                    {
                    // InternalFactoryLogicLangParser.g:1350:5: (lv_comparison_int_11_0= RULE_INT )
                    // InternalFactoryLogicLangParser.g:1351:6: lv_comparison_int_11_0= RULE_INT
                    {
                    lv_comparison_int_11_0=(Token)match(input,RULE_INT,FOLLOW_22); 

                    						newLeafNode(lv_comparison_int_11_0, grammarAccess.getLoopAccess().getComparison_intINTTerminalRuleCall_8_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLoopRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"comparison_int",
                    							lv_comparison_int_11_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_12=(Token)match(input,Then,FOLLOW_7); 

            			newLeafNode(otherlv_12, grammarAccess.getLoopAccess().getThenKeyword_9());
            		
            this_BEGIN_13=(Token)match(input,RULE_BEGIN,FOLLOW_23); 

            			newLeafNode(this_BEGIN_13, grammarAccess.getLoopAccess().getBEGINTerminalRuleCall_10());
            		
            // InternalFactoryLogicLangParser.g:1376:3: ( (lv_logics_14_0= ruleLogic ) )+
            int cnt21=0;
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==For||LA21_0==If||LA21_0==RULE_STRING) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalFactoryLogicLangParser.g:1377:4: (lv_logics_14_0= ruleLogic )
            	    {
            	    // InternalFactoryLogicLangParser.g:1377:4: (lv_logics_14_0= ruleLogic )
            	    // InternalFactoryLogicLangParser.g:1378:5: lv_logics_14_0= ruleLogic
            	    {

            	    					newCompositeNode(grammarAccess.getLoopAccess().getLogicsLogicParserRuleCall_11_0());
            	    				
            	    pushFollow(FOLLOW_23);
            	    lv_logics_14_0=ruleLogic();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getLoopRule());
            	    					}
            	    					add(
            	    						current,
            	    						"logics",
            	    						lv_logics_14_0,
            	    						"xtext.FactoryLogicLang.Logic");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt21 >= 1 ) break loop21;
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        throw eee;
                }
                cnt21++;
            } while (true);

            this_END_15=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_15, grammarAccess.getLoopAccess().getENDTerminalRuleCall_12());
            		

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


    // $ANTLR start "entryRuleOperation"
    // InternalFactoryLogicLangParser.g:1403:1: entryRuleOperation returns [EObject current=null] : iv_ruleOperation= ruleOperation EOF ;
    public final EObject entryRuleOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation = null;


        try {
            // InternalFactoryLogicLangParser.g:1403:50: (iv_ruleOperation= ruleOperation EOF )
            // InternalFactoryLogicLangParser.g:1404:2: iv_ruleOperation= ruleOperation EOF
            {
             newCompositeNode(grammarAccess.getOperationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOperation=ruleOperation();

            state._fsp--;

             current =iv_ruleOperation; 
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
    // $ANTLR end "entryRuleOperation"


    // $ANTLR start "ruleOperation"
    // InternalFactoryLogicLangParser.g:1410:1: ruleOperation returns [EObject current=null] : (this_StorageMoveEmptySlot_0= ruleStorageMoveEmptySlot | this_StorageMoveSlot_1= ruleStorageMoveSlot | this_StorageMarkSlot_2= ruleStorageMarkSlot | this_StorageMoveVariableSlot_3= ruleStorageMoveVariableSlot | this_CameraScan_4= ruleCameraScan | this_CranePickup_5= ruleCranePickup | this_CraneDrop_6= ruleCraneDrop ) ;
    public final EObject ruleOperation() throws RecognitionException {
        EObject current = null;

        EObject this_StorageMoveEmptySlot_0 = null;

        EObject this_StorageMoveSlot_1 = null;

        EObject this_StorageMarkSlot_2 = null;

        EObject this_StorageMoveVariableSlot_3 = null;

        EObject this_CameraScan_4 = null;

        EObject this_CranePickup_5 = null;

        EObject this_CraneDrop_6 = null;



        	enterRule();

        try {
            // InternalFactoryLogicLangParser.g:1416:2: ( (this_StorageMoveEmptySlot_0= ruleStorageMoveEmptySlot | this_StorageMoveSlot_1= ruleStorageMoveSlot | this_StorageMarkSlot_2= ruleStorageMarkSlot | this_StorageMoveVariableSlot_3= ruleStorageMoveVariableSlot | this_CameraScan_4= ruleCameraScan | this_CranePickup_5= ruleCranePickup | this_CraneDrop_6= ruleCraneDrop ) )
            // InternalFactoryLogicLangParser.g:1417:2: (this_StorageMoveEmptySlot_0= ruleStorageMoveEmptySlot | this_StorageMoveSlot_1= ruleStorageMoveSlot | this_StorageMarkSlot_2= ruleStorageMarkSlot | this_StorageMoveVariableSlot_3= ruleStorageMoveVariableSlot | this_CameraScan_4= ruleCameraScan | this_CranePickup_5= ruleCranePickup | this_CraneDrop_6= ruleCraneDrop )
            {
            // InternalFactoryLogicLangParser.g:1417:2: (this_StorageMoveEmptySlot_0= ruleStorageMoveEmptySlot | this_StorageMoveSlot_1= ruleStorageMoveSlot | this_StorageMarkSlot_2= ruleStorageMarkSlot | this_StorageMoveVariableSlot_3= ruleStorageMoveVariableSlot | this_CameraScan_4= ruleCameraScan | this_CranePickup_5= ruleCranePickup | this_CraneDrop_6= ruleCraneDrop )
            int alt22=7;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // InternalFactoryLogicLangParser.g:1418:3: this_StorageMoveEmptySlot_0= ruleStorageMoveEmptySlot
                    {

                    			newCompositeNode(grammarAccess.getOperationAccess().getStorageMoveEmptySlotParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_StorageMoveEmptySlot_0=ruleStorageMoveEmptySlot();

                    state._fsp--;


                    			current = this_StorageMoveEmptySlot_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalFactoryLogicLangParser.g:1427:3: this_StorageMoveSlot_1= ruleStorageMoveSlot
                    {

                    			newCompositeNode(grammarAccess.getOperationAccess().getStorageMoveSlotParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_StorageMoveSlot_1=ruleStorageMoveSlot();

                    state._fsp--;


                    			current = this_StorageMoveSlot_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalFactoryLogicLangParser.g:1436:3: this_StorageMarkSlot_2= ruleStorageMarkSlot
                    {

                    			newCompositeNode(grammarAccess.getOperationAccess().getStorageMarkSlotParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_StorageMarkSlot_2=ruleStorageMarkSlot();

                    state._fsp--;


                    			current = this_StorageMarkSlot_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalFactoryLogicLangParser.g:1445:3: this_StorageMoveVariableSlot_3= ruleStorageMoveVariableSlot
                    {

                    			newCompositeNode(grammarAccess.getOperationAccess().getStorageMoveVariableSlotParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_StorageMoveVariableSlot_3=ruleStorageMoveVariableSlot();

                    state._fsp--;


                    			current = this_StorageMoveVariableSlot_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalFactoryLogicLangParser.g:1454:3: this_CameraScan_4= ruleCameraScan
                    {

                    			newCompositeNode(grammarAccess.getOperationAccess().getCameraScanParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_CameraScan_4=ruleCameraScan();

                    state._fsp--;


                    			current = this_CameraScan_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalFactoryLogicLangParser.g:1463:3: this_CranePickup_5= ruleCranePickup
                    {

                    			newCompositeNode(grammarAccess.getOperationAccess().getCranePickupParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_CranePickup_5=ruleCranePickup();

                    state._fsp--;


                    			current = this_CranePickup_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalFactoryLogicLangParser.g:1472:3: this_CraneDrop_6= ruleCraneDrop
                    {

                    			newCompositeNode(grammarAccess.getOperationAccess().getCraneDropParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_CraneDrop_6=ruleCraneDrop();

                    state._fsp--;


                    			current = this_CraneDrop_6;
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
    // $ANTLR end "ruleOperation"


    // $ANTLR start "entryRuleStorageMoveEmptySlot"
    // InternalFactoryLogicLangParser.g:1484:1: entryRuleStorageMoveEmptySlot returns [EObject current=null] : iv_ruleStorageMoveEmptySlot= ruleStorageMoveEmptySlot EOF ;
    public final EObject entryRuleStorageMoveEmptySlot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStorageMoveEmptySlot = null;


        try {
            // InternalFactoryLogicLangParser.g:1484:61: (iv_ruleStorageMoveEmptySlot= ruleStorageMoveEmptySlot EOF )
            // InternalFactoryLogicLangParser.g:1485:2: iv_ruleStorageMoveEmptySlot= ruleStorageMoveEmptySlot EOF
            {
             newCompositeNode(grammarAccess.getStorageMoveEmptySlotRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStorageMoveEmptySlot=ruleStorageMoveEmptySlot();

            state._fsp--;

             current =iv_ruleStorageMoveEmptySlot; 
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
    // $ANTLR end "entryRuleStorageMoveEmptySlot"


    // $ANTLR start "ruleStorageMoveEmptySlot"
    // InternalFactoryLogicLangParser.g:1491:1: ruleStorageMoveEmptySlot returns [EObject current=null] : ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= Move otherlv_2= Empty otherlv_3= Slot otherlv_4= To ( (otherlv_5= RULE_STRING ) ) ) ;
    public final EObject ruleStorageMoveEmptySlot() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalFactoryLogicLangParser.g:1497:2: ( ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= Move otherlv_2= Empty otherlv_3= Slot otherlv_4= To ( (otherlv_5= RULE_STRING ) ) ) )
            // InternalFactoryLogicLangParser.g:1498:2: ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= Move otherlv_2= Empty otherlv_3= Slot otherlv_4= To ( (otherlv_5= RULE_STRING ) ) )
            {
            // InternalFactoryLogicLangParser.g:1498:2: ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= Move otherlv_2= Empty otherlv_3= Slot otherlv_4= To ( (otherlv_5= RULE_STRING ) ) )
            // InternalFactoryLogicLangParser.g:1499:3: ( (otherlv_0= RULE_STRING ) ) otherlv_1= Move otherlv_2= Empty otherlv_3= Slot otherlv_4= To ( (otherlv_5= RULE_STRING ) )
            {
            // InternalFactoryLogicLangParser.g:1499:3: ( (otherlv_0= RULE_STRING ) )
            // InternalFactoryLogicLangParser.g:1500:4: (otherlv_0= RULE_STRING )
            {
            // InternalFactoryLogicLangParser.g:1500:4: (otherlv_0= RULE_STRING )
            // InternalFactoryLogicLangParser.g:1501:5: otherlv_0= RULE_STRING
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStorageMoveEmptySlotRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_STRING,FOLLOW_32); 

            					newLeafNode(otherlv_0, grammarAccess.getStorageMoveEmptySlotAccess().getDeviceStorageCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,Move,FOLLOW_33); 

            			newLeafNode(otherlv_1, grammarAccess.getStorageMoveEmptySlotAccess().getMoveKeyword_1());
            		
            otherlv_2=(Token)match(input,Empty,FOLLOW_15); 

            			newLeafNode(otherlv_2, grammarAccess.getStorageMoveEmptySlotAccess().getEmptyKeyword_2());
            		
            otherlv_3=(Token)match(input,Slot,FOLLOW_27); 

            			newLeafNode(otherlv_3, grammarAccess.getStorageMoveEmptySlotAccess().getSlotKeyword_3());
            		
            otherlv_4=(Token)match(input,To,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getStorageMoveEmptySlotAccess().getToKeyword_4());
            		
            // InternalFactoryLogicLangParser.g:1528:3: ( (otherlv_5= RULE_STRING ) )
            // InternalFactoryLogicLangParser.g:1529:4: (otherlv_5= RULE_STRING )
            {
            // InternalFactoryLogicLangParser.g:1529:4: (otherlv_5= RULE_STRING )
            // InternalFactoryLogicLangParser.g:1530:5: otherlv_5= RULE_STRING
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStorageMoveEmptySlotRule());
            					}
            				
            otherlv_5=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(otherlv_5, grammarAccess.getStorageMoveEmptySlotAccess().getDestinationStoragePositionParameterCrossReference_5_0());
            				

            }


            }


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
    // $ANTLR end "ruleStorageMoveEmptySlot"


    // $ANTLR start "entryRuleStorageMoveVariableSlot"
    // InternalFactoryLogicLangParser.g:1545:1: entryRuleStorageMoveVariableSlot returns [EObject current=null] : iv_ruleStorageMoveVariableSlot= ruleStorageMoveVariableSlot EOF ;
    public final EObject entryRuleStorageMoveVariableSlot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStorageMoveVariableSlot = null;


        try {
            // InternalFactoryLogicLangParser.g:1545:64: (iv_ruleStorageMoveVariableSlot= ruleStorageMoveVariableSlot EOF )
            // InternalFactoryLogicLangParser.g:1546:2: iv_ruleStorageMoveVariableSlot= ruleStorageMoveVariableSlot EOF
            {
             newCompositeNode(grammarAccess.getStorageMoveVariableSlotRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStorageMoveVariableSlot=ruleStorageMoveVariableSlot();

            state._fsp--;

             current =iv_ruleStorageMoveVariableSlot; 
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
    // $ANTLR end "entryRuleStorageMoveVariableSlot"


    // $ANTLR start "ruleStorageMoveVariableSlot"
    // InternalFactoryLogicLangParser.g:1552:1: ruleStorageMoveVariableSlot returns [EObject current=null] : ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= Move otherlv_2= Slot otherlv_3= Of ( (otherlv_4= RULE_ID ) ) otherlv_5= To ( (otherlv_6= RULE_STRING ) ) ) ;
    public final EObject ruleStorageMoveVariableSlot() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;


        	enterRule();

        try {
            // InternalFactoryLogicLangParser.g:1558:2: ( ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= Move otherlv_2= Slot otherlv_3= Of ( (otherlv_4= RULE_ID ) ) otherlv_5= To ( (otherlv_6= RULE_STRING ) ) ) )
            // InternalFactoryLogicLangParser.g:1559:2: ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= Move otherlv_2= Slot otherlv_3= Of ( (otherlv_4= RULE_ID ) ) otherlv_5= To ( (otherlv_6= RULE_STRING ) ) )
            {
            // InternalFactoryLogicLangParser.g:1559:2: ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= Move otherlv_2= Slot otherlv_3= Of ( (otherlv_4= RULE_ID ) ) otherlv_5= To ( (otherlv_6= RULE_STRING ) ) )
            // InternalFactoryLogicLangParser.g:1560:3: ( (otherlv_0= RULE_STRING ) ) otherlv_1= Move otherlv_2= Slot otherlv_3= Of ( (otherlv_4= RULE_ID ) ) otherlv_5= To ( (otherlv_6= RULE_STRING ) )
            {
            // InternalFactoryLogicLangParser.g:1560:3: ( (otherlv_0= RULE_STRING ) )
            // InternalFactoryLogicLangParser.g:1561:4: (otherlv_0= RULE_STRING )
            {
            // InternalFactoryLogicLangParser.g:1561:4: (otherlv_0= RULE_STRING )
            // InternalFactoryLogicLangParser.g:1562:5: otherlv_0= RULE_STRING
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStorageMoveVariableSlotRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_STRING,FOLLOW_32); 

            					newLeafNode(otherlv_0, grammarAccess.getStorageMoveVariableSlotAccess().getDeviceStorageCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,Move,FOLLOW_15); 

            			newLeafNode(otherlv_1, grammarAccess.getStorageMoveVariableSlotAccess().getMoveKeyword_1());
            		
            otherlv_2=(Token)match(input,Slot,FOLLOW_34); 

            			newLeafNode(otherlv_2, grammarAccess.getStorageMoveVariableSlotAccess().getSlotKeyword_2());
            		
            otherlv_3=(Token)match(input,Of,FOLLOW_24); 

            			newLeafNode(otherlv_3, grammarAccess.getStorageMoveVariableSlotAccess().getOfKeyword_3());
            		
            // InternalFactoryLogicLangParser.g:1585:3: ( (otherlv_4= RULE_ID ) )
            // InternalFactoryLogicLangParser.g:1586:4: (otherlv_4= RULE_ID )
            {
            // InternalFactoryLogicLangParser.g:1586:4: (otherlv_4= RULE_ID )
            // InternalFactoryLogicLangParser.g:1587:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStorageMoveVariableSlotRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_27); 

            					newLeafNode(otherlv_4, grammarAccess.getStorageMoveVariableSlotAccess().getPositionVariableCrossReference_4_0());
            				

            }


            }

            otherlv_5=(Token)match(input,To,FOLLOW_6); 

            			newLeafNode(otherlv_5, grammarAccess.getStorageMoveVariableSlotAccess().getToKeyword_5());
            		
            // InternalFactoryLogicLangParser.g:1602:3: ( (otherlv_6= RULE_STRING ) )
            // InternalFactoryLogicLangParser.g:1603:4: (otherlv_6= RULE_STRING )
            {
            // InternalFactoryLogicLangParser.g:1603:4: (otherlv_6= RULE_STRING )
            // InternalFactoryLogicLangParser.g:1604:5: otherlv_6= RULE_STRING
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStorageMoveVariableSlotRule());
            					}
            				
            otherlv_6=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(otherlv_6, grammarAccess.getStorageMoveVariableSlotAccess().getDestinationStoragePositionParameterCrossReference_6_0());
            				

            }


            }


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
    // $ANTLR end "ruleStorageMoveVariableSlot"


    // $ANTLR start "entryRuleStorageMoveSlot"
    // InternalFactoryLogicLangParser.g:1619:1: entryRuleStorageMoveSlot returns [EObject current=null] : iv_ruleStorageMoveSlot= ruleStorageMoveSlot EOF ;
    public final EObject entryRuleStorageMoveSlot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStorageMoveSlot = null;


        try {
            // InternalFactoryLogicLangParser.g:1619:56: (iv_ruleStorageMoveSlot= ruleStorageMoveSlot EOF )
            // InternalFactoryLogicLangParser.g:1620:2: iv_ruleStorageMoveSlot= ruleStorageMoveSlot EOF
            {
             newCompositeNode(grammarAccess.getStorageMoveSlotRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStorageMoveSlot=ruleStorageMoveSlot();

            state._fsp--;

             current =iv_ruleStorageMoveSlot; 
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
    // $ANTLR end "entryRuleStorageMoveSlot"


    // $ANTLR start "ruleStorageMoveSlot"
    // InternalFactoryLogicLangParser.g:1626:1: ruleStorageMoveSlot returns [EObject current=null] : ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= Move otherlv_2= Slot otherlv_3= At ( (otherlv_4= RULE_STRING ) ) otherlv_5= To ( (otherlv_6= RULE_STRING ) ) ) ;
    public final EObject ruleStorageMoveSlot() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;


        	enterRule();

        try {
            // InternalFactoryLogicLangParser.g:1632:2: ( ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= Move otherlv_2= Slot otherlv_3= At ( (otherlv_4= RULE_STRING ) ) otherlv_5= To ( (otherlv_6= RULE_STRING ) ) ) )
            // InternalFactoryLogicLangParser.g:1633:2: ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= Move otherlv_2= Slot otherlv_3= At ( (otherlv_4= RULE_STRING ) ) otherlv_5= To ( (otherlv_6= RULE_STRING ) ) )
            {
            // InternalFactoryLogicLangParser.g:1633:2: ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= Move otherlv_2= Slot otherlv_3= At ( (otherlv_4= RULE_STRING ) ) otherlv_5= To ( (otherlv_6= RULE_STRING ) ) )
            // InternalFactoryLogicLangParser.g:1634:3: ( (otherlv_0= RULE_STRING ) ) otherlv_1= Move otherlv_2= Slot otherlv_3= At ( (otherlv_4= RULE_STRING ) ) otherlv_5= To ( (otherlv_6= RULE_STRING ) )
            {
            // InternalFactoryLogicLangParser.g:1634:3: ( (otherlv_0= RULE_STRING ) )
            // InternalFactoryLogicLangParser.g:1635:4: (otherlv_0= RULE_STRING )
            {
            // InternalFactoryLogicLangParser.g:1635:4: (otherlv_0= RULE_STRING )
            // InternalFactoryLogicLangParser.g:1636:5: otherlv_0= RULE_STRING
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStorageMoveSlotRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_STRING,FOLLOW_32); 

            					newLeafNode(otherlv_0, grammarAccess.getStorageMoveSlotAccess().getDeviceStorageCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,Move,FOLLOW_15); 

            			newLeafNode(otherlv_1, grammarAccess.getStorageMoveSlotAccess().getMoveKeyword_1());
            		
            otherlv_2=(Token)match(input,Slot,FOLLOW_11); 

            			newLeafNode(otherlv_2, grammarAccess.getStorageMoveSlotAccess().getSlotKeyword_2());
            		
            otherlv_3=(Token)match(input,At,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getStorageMoveSlotAccess().getAtKeyword_3());
            		
            // InternalFactoryLogicLangParser.g:1659:3: ( (otherlv_4= RULE_STRING ) )
            // InternalFactoryLogicLangParser.g:1660:4: (otherlv_4= RULE_STRING )
            {
            // InternalFactoryLogicLangParser.g:1660:4: (otherlv_4= RULE_STRING )
            // InternalFactoryLogicLangParser.g:1661:5: otherlv_4= RULE_STRING
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStorageMoveSlotRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_STRING,FOLLOW_27); 

            					newLeafNode(otherlv_4, grammarAccess.getStorageMoveSlotAccess().getPositionStoragePositionParameterCrossReference_4_0());
            				

            }


            }

            otherlv_5=(Token)match(input,To,FOLLOW_6); 

            			newLeafNode(otherlv_5, grammarAccess.getStorageMoveSlotAccess().getToKeyword_5());
            		
            // InternalFactoryLogicLangParser.g:1676:3: ( (otherlv_6= RULE_STRING ) )
            // InternalFactoryLogicLangParser.g:1677:4: (otherlv_6= RULE_STRING )
            {
            // InternalFactoryLogicLangParser.g:1677:4: (otherlv_6= RULE_STRING )
            // InternalFactoryLogicLangParser.g:1678:5: otherlv_6= RULE_STRING
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStorageMoveSlotRule());
            					}
            				
            otherlv_6=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(otherlv_6, grammarAccess.getStorageMoveSlotAccess().getDestinationStoragePositionParameterCrossReference_6_0());
            				

            }


            }


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
    // $ANTLR end "ruleStorageMoveSlot"


    // $ANTLR start "entryRuleStorageMarkSlot"
    // InternalFactoryLogicLangParser.g:1693:1: entryRuleStorageMarkSlot returns [EObject current=null] : iv_ruleStorageMarkSlot= ruleStorageMarkSlot EOF ;
    public final EObject entryRuleStorageMarkSlot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStorageMarkSlot = null;


        try {
            // InternalFactoryLogicLangParser.g:1693:56: (iv_ruleStorageMarkSlot= ruleStorageMarkSlot EOF )
            // InternalFactoryLogicLangParser.g:1694:2: iv_ruleStorageMarkSlot= ruleStorageMarkSlot EOF
            {
             newCompositeNode(grammarAccess.getStorageMarkSlotRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStorageMarkSlot=ruleStorageMarkSlot();

            state._fsp--;

             current =iv_ruleStorageMarkSlot; 
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
    // $ANTLR end "entryRuleStorageMarkSlot"


    // $ANTLR start "ruleStorageMarkSlot"
    // InternalFactoryLogicLangParser.g:1700:1: ruleStorageMarkSlot returns [EObject current=null] : ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= Mark otherlv_2= Slot otherlv_3= At ( (otherlv_4= RULE_STRING ) ) otherlv_5= As ( ( (otherlv_6= RULE_ID ) ) | ( (lv_comparison_const_7_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_8_0= ruleCOLOR ) ) | ( (lv_comparison_int_9_0= RULE_INT ) ) ) (otherlv_10= In ( (lv_quantity_11_0= RULE_INT ) ) ( (lv_measure_12_0= ruleTIME ) ) )? ) ;
    public final EObject ruleStorageMarkSlot() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_comparison_int_9_0=null;
        Token otherlv_10=null;
        Token lv_quantity_11_0=null;
        Enumerator lv_comparison_const_7_0 = null;

        Enumerator lv_comparison_color_8_0 = null;

        Enumerator lv_measure_12_0 = null;



        	enterRule();

        try {
            // InternalFactoryLogicLangParser.g:1706:2: ( ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= Mark otherlv_2= Slot otherlv_3= At ( (otherlv_4= RULE_STRING ) ) otherlv_5= As ( ( (otherlv_6= RULE_ID ) ) | ( (lv_comparison_const_7_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_8_0= ruleCOLOR ) ) | ( (lv_comparison_int_9_0= RULE_INT ) ) ) (otherlv_10= In ( (lv_quantity_11_0= RULE_INT ) ) ( (lv_measure_12_0= ruleTIME ) ) )? ) )
            // InternalFactoryLogicLangParser.g:1707:2: ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= Mark otherlv_2= Slot otherlv_3= At ( (otherlv_4= RULE_STRING ) ) otherlv_5= As ( ( (otherlv_6= RULE_ID ) ) | ( (lv_comparison_const_7_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_8_0= ruleCOLOR ) ) | ( (lv_comparison_int_9_0= RULE_INT ) ) ) (otherlv_10= In ( (lv_quantity_11_0= RULE_INT ) ) ( (lv_measure_12_0= ruleTIME ) ) )? )
            {
            // InternalFactoryLogicLangParser.g:1707:2: ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= Mark otherlv_2= Slot otherlv_3= At ( (otherlv_4= RULE_STRING ) ) otherlv_5= As ( ( (otherlv_6= RULE_ID ) ) | ( (lv_comparison_const_7_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_8_0= ruleCOLOR ) ) | ( (lv_comparison_int_9_0= RULE_INT ) ) ) (otherlv_10= In ( (lv_quantity_11_0= RULE_INT ) ) ( (lv_measure_12_0= ruleTIME ) ) )? )
            // InternalFactoryLogicLangParser.g:1708:3: ( (otherlv_0= RULE_STRING ) ) otherlv_1= Mark otherlv_2= Slot otherlv_3= At ( (otherlv_4= RULE_STRING ) ) otherlv_5= As ( ( (otherlv_6= RULE_ID ) ) | ( (lv_comparison_const_7_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_8_0= ruleCOLOR ) ) | ( (lv_comparison_int_9_0= RULE_INT ) ) ) (otherlv_10= In ( (lv_quantity_11_0= RULE_INT ) ) ( (lv_measure_12_0= ruleTIME ) ) )?
            {
            // InternalFactoryLogicLangParser.g:1708:3: ( (otherlv_0= RULE_STRING ) )
            // InternalFactoryLogicLangParser.g:1709:4: (otherlv_0= RULE_STRING )
            {
            // InternalFactoryLogicLangParser.g:1709:4: (otherlv_0= RULE_STRING )
            // InternalFactoryLogicLangParser.g:1710:5: otherlv_0= RULE_STRING
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStorageMarkSlotRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_STRING,FOLLOW_35); 

            					newLeafNode(otherlv_0, grammarAccess.getStorageMarkSlotAccess().getDeviceStorageCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,Mark,FOLLOW_15); 

            			newLeafNode(otherlv_1, grammarAccess.getStorageMarkSlotAccess().getMarkKeyword_1());
            		
            otherlv_2=(Token)match(input,Slot,FOLLOW_11); 

            			newLeafNode(otherlv_2, grammarAccess.getStorageMarkSlotAccess().getSlotKeyword_2());
            		
            otherlv_3=(Token)match(input,At,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getStorageMarkSlotAccess().getAtKeyword_3());
            		
            // InternalFactoryLogicLangParser.g:1733:3: ( (otherlv_4= RULE_STRING ) )
            // InternalFactoryLogicLangParser.g:1734:4: (otherlv_4= RULE_STRING )
            {
            // InternalFactoryLogicLangParser.g:1734:4: (otherlv_4= RULE_STRING )
            // InternalFactoryLogicLangParser.g:1735:5: otherlv_4= RULE_STRING
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStorageMarkSlotRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_STRING,FOLLOW_36); 

            					newLeafNode(otherlv_4, grammarAccess.getStorageMarkSlotAccess().getPositionStoragePositionParameterCrossReference_4_0());
            				

            }


            }

            otherlv_5=(Token)match(input,As,FOLLOW_37); 

            			newLeafNode(otherlv_5, grammarAccess.getStorageMarkSlotAccess().getAsKeyword_5());
            		
            // InternalFactoryLogicLangParser.g:1750:3: ( ( (otherlv_6= RULE_ID ) ) | ( (lv_comparison_const_7_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_8_0= ruleCOLOR ) ) | ( (lv_comparison_int_9_0= RULE_INT ) ) )
            int alt23=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt23=1;
                }
                break;
            case Finished:
            case Empty:
            case Full:
                {
                alt23=2;
                }
                break;
            case Green:
            case Blue:
            case Red:
                {
                alt23=3;
                }
                break;
            case RULE_INT:
                {
                alt23=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // InternalFactoryLogicLangParser.g:1751:4: ( (otherlv_6= RULE_ID ) )
                    {
                    // InternalFactoryLogicLangParser.g:1751:4: ( (otherlv_6= RULE_ID ) )
                    // InternalFactoryLogicLangParser.g:1752:5: (otherlv_6= RULE_ID )
                    {
                    // InternalFactoryLogicLangParser.g:1752:5: (otherlv_6= RULE_ID )
                    // InternalFactoryLogicLangParser.g:1753:6: otherlv_6= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStorageMarkSlotRule());
                    						}
                    					
                    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_38); 

                    						newLeafNode(otherlv_6, grammarAccess.getStorageMarkSlotAccess().getComparison_variableVariableCrossReference_6_0_0());
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalFactoryLogicLangParser.g:1765:4: ( (lv_comparison_const_7_0= ruleCONST_VARIABLES ) )
                    {
                    // InternalFactoryLogicLangParser.g:1765:4: ( (lv_comparison_const_7_0= ruleCONST_VARIABLES ) )
                    // InternalFactoryLogicLangParser.g:1766:5: (lv_comparison_const_7_0= ruleCONST_VARIABLES )
                    {
                    // InternalFactoryLogicLangParser.g:1766:5: (lv_comparison_const_7_0= ruleCONST_VARIABLES )
                    // InternalFactoryLogicLangParser.g:1767:6: lv_comparison_const_7_0= ruleCONST_VARIABLES
                    {

                    						newCompositeNode(grammarAccess.getStorageMarkSlotAccess().getComparison_constCONST_VARIABLESEnumRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_38);
                    lv_comparison_const_7_0=ruleCONST_VARIABLES();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStorageMarkSlotRule());
                    						}
                    						set(
                    							current,
                    							"comparison_const",
                    							lv_comparison_const_7_0,
                    							"xtext.FactoryLogicLang.CONST_VARIABLES");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalFactoryLogicLangParser.g:1785:4: ( (lv_comparison_color_8_0= ruleCOLOR ) )
                    {
                    // InternalFactoryLogicLangParser.g:1785:4: ( (lv_comparison_color_8_0= ruleCOLOR ) )
                    // InternalFactoryLogicLangParser.g:1786:5: (lv_comparison_color_8_0= ruleCOLOR )
                    {
                    // InternalFactoryLogicLangParser.g:1786:5: (lv_comparison_color_8_0= ruleCOLOR )
                    // InternalFactoryLogicLangParser.g:1787:6: lv_comparison_color_8_0= ruleCOLOR
                    {

                    						newCompositeNode(grammarAccess.getStorageMarkSlotAccess().getComparison_colorCOLOREnumRuleCall_6_2_0());
                    					
                    pushFollow(FOLLOW_38);
                    lv_comparison_color_8_0=ruleCOLOR();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStorageMarkSlotRule());
                    						}
                    						set(
                    							current,
                    							"comparison_color",
                    							lv_comparison_color_8_0,
                    							"xtext.FactoryLogicLang.COLOR");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalFactoryLogicLangParser.g:1805:4: ( (lv_comparison_int_9_0= RULE_INT ) )
                    {
                    // InternalFactoryLogicLangParser.g:1805:4: ( (lv_comparison_int_9_0= RULE_INT ) )
                    // InternalFactoryLogicLangParser.g:1806:5: (lv_comparison_int_9_0= RULE_INT )
                    {
                    // InternalFactoryLogicLangParser.g:1806:5: (lv_comparison_int_9_0= RULE_INT )
                    // InternalFactoryLogicLangParser.g:1807:6: lv_comparison_int_9_0= RULE_INT
                    {
                    lv_comparison_int_9_0=(Token)match(input,RULE_INT,FOLLOW_38); 

                    						newLeafNode(lv_comparison_int_9_0, grammarAccess.getStorageMarkSlotAccess().getComparison_intINTTerminalRuleCall_6_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStorageMarkSlotRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"comparison_int",
                    							lv_comparison_int_9_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalFactoryLogicLangParser.g:1824:3: (otherlv_10= In ( (lv_quantity_11_0= RULE_INT ) ) ( (lv_measure_12_0= ruleTIME ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==In) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalFactoryLogicLangParser.g:1825:4: otherlv_10= In ( (lv_quantity_11_0= RULE_INT ) ) ( (lv_measure_12_0= ruleTIME ) )
                    {
                    otherlv_10=(Token)match(input,In,FOLLOW_12); 

                    				newLeafNode(otherlv_10, grammarAccess.getStorageMarkSlotAccess().getInKeyword_7_0());
                    			
                    // InternalFactoryLogicLangParser.g:1829:4: ( (lv_quantity_11_0= RULE_INT ) )
                    // InternalFactoryLogicLangParser.g:1830:5: (lv_quantity_11_0= RULE_INT )
                    {
                    // InternalFactoryLogicLangParser.g:1830:5: (lv_quantity_11_0= RULE_INT )
                    // InternalFactoryLogicLangParser.g:1831:6: lv_quantity_11_0= RULE_INT
                    {
                    lv_quantity_11_0=(Token)match(input,RULE_INT,FOLLOW_39); 

                    						newLeafNode(lv_quantity_11_0, grammarAccess.getStorageMarkSlotAccess().getQuantityINTTerminalRuleCall_7_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStorageMarkSlotRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"quantity",
                    							lv_quantity_11_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }

                    // InternalFactoryLogicLangParser.g:1847:4: ( (lv_measure_12_0= ruleTIME ) )
                    // InternalFactoryLogicLangParser.g:1848:5: (lv_measure_12_0= ruleTIME )
                    {
                    // InternalFactoryLogicLangParser.g:1848:5: (lv_measure_12_0= ruleTIME )
                    // InternalFactoryLogicLangParser.g:1849:6: lv_measure_12_0= ruleTIME
                    {

                    						newCompositeNode(grammarAccess.getStorageMarkSlotAccess().getMeasureTIMEEnumRuleCall_7_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_measure_12_0=ruleTIME();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStorageMarkSlotRule());
                    						}
                    						set(
                    							current,
                    							"measure",
                    							lv_measure_12_0,
                    							"xtext.FactoryLogicLang.TIME");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


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
    // $ANTLR end "ruleStorageMarkSlot"


    // $ANTLR start "entryRuleCameraScan"
    // InternalFactoryLogicLangParser.g:1871:1: entryRuleCameraScan returns [EObject current=null] : iv_ruleCameraScan= ruleCameraScan EOF ;
    public final EObject entryRuleCameraScan() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCameraScan = null;


        try {
            // InternalFactoryLogicLangParser.g:1871:51: (iv_ruleCameraScan= ruleCameraScan EOF )
            // InternalFactoryLogicLangParser.g:1872:2: iv_ruleCameraScan= ruleCameraScan EOF
            {
             newCompositeNode(grammarAccess.getCameraScanRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCameraScan=ruleCameraScan();

            state._fsp--;

             current =iv_ruleCameraScan; 
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
    // $ANTLR end "entryRuleCameraScan"


    // $ANTLR start "ruleCameraScan"
    // InternalFactoryLogicLangParser.g:1878:1: ruleCameraScan returns [EObject current=null] : ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= Scan otherlv_2= Color ( (lv_variable_3_0= ruleGloablVariable ) ) ) ;
    public final EObject ruleCameraScan() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_variable_3_0 = null;



        	enterRule();

        try {
            // InternalFactoryLogicLangParser.g:1884:2: ( ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= Scan otherlv_2= Color ( (lv_variable_3_0= ruleGloablVariable ) ) ) )
            // InternalFactoryLogicLangParser.g:1885:2: ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= Scan otherlv_2= Color ( (lv_variable_3_0= ruleGloablVariable ) ) )
            {
            // InternalFactoryLogicLangParser.g:1885:2: ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= Scan otherlv_2= Color ( (lv_variable_3_0= ruleGloablVariable ) ) )
            // InternalFactoryLogicLangParser.g:1886:3: ( (otherlv_0= RULE_STRING ) ) otherlv_1= Scan otherlv_2= Color ( (lv_variable_3_0= ruleGloablVariable ) )
            {
            // InternalFactoryLogicLangParser.g:1886:3: ( (otherlv_0= RULE_STRING ) )
            // InternalFactoryLogicLangParser.g:1887:4: (otherlv_0= RULE_STRING )
            {
            // InternalFactoryLogicLangParser.g:1887:4: (otherlv_0= RULE_STRING )
            // InternalFactoryLogicLangParser.g:1888:5: otherlv_0= RULE_STRING
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCameraScanRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_STRING,FOLLOW_40); 

            					newLeafNode(otherlv_0, grammarAccess.getCameraScanAccess().getDeviceCameraCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,Scan,FOLLOW_17); 

            			newLeafNode(otherlv_1, grammarAccess.getCameraScanAccess().getScanKeyword_1());
            		
            otherlv_2=(Token)match(input,Color,FOLLOW_41); 

            			newLeafNode(otherlv_2, grammarAccess.getCameraScanAccess().getColorKeyword_2());
            		
            // InternalFactoryLogicLangParser.g:1907:3: ( (lv_variable_3_0= ruleGloablVariable ) )
            // InternalFactoryLogicLangParser.g:1908:4: (lv_variable_3_0= ruleGloablVariable )
            {
            // InternalFactoryLogicLangParser.g:1908:4: (lv_variable_3_0= ruleGloablVariable )
            // InternalFactoryLogicLangParser.g:1909:5: lv_variable_3_0= ruleGloablVariable
            {

            					newCompositeNode(grammarAccess.getCameraScanAccess().getVariableGloablVariableParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_variable_3_0=ruleGloablVariable();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCameraScanRule());
            					}
            					set(
            						current,
            						"variable",
            						lv_variable_3_0,
            						"xtext.FactoryLogicLang.GloablVariable");
            					afterParserOrEnumRuleCall();
            				

            }


            }


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
    // $ANTLR end "ruleCameraScan"


    // $ANTLR start "entryRuleLoopVariable"
    // InternalFactoryLogicLangParser.g:1930:1: entryRuleLoopVariable returns [EObject current=null] : iv_ruleLoopVariable= ruleLoopVariable EOF ;
    public final EObject entryRuleLoopVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoopVariable = null;


        try {
            // InternalFactoryLogicLangParser.g:1930:53: (iv_ruleLoopVariable= ruleLoopVariable EOF )
            // InternalFactoryLogicLangParser.g:1931:2: iv_ruleLoopVariable= ruleLoopVariable EOF
            {
             newCompositeNode(grammarAccess.getLoopVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLoopVariable=ruleLoopVariable();

            state._fsp--;

             current =iv_ruleLoopVariable; 
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
    // $ANTLR end "entryRuleLoopVariable"


    // $ANTLR start "ruleLoopVariable"
    // InternalFactoryLogicLangParser.g:1937:1: ruleLoopVariable returns [EObject current=null] : (otherlv_0= Each ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleLoopVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalFactoryLogicLangParser.g:1943:2: ( (otherlv_0= Each ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalFactoryLogicLangParser.g:1944:2: (otherlv_0= Each ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalFactoryLogicLangParser.g:1944:2: (otherlv_0= Each ( (lv_name_1_0= RULE_ID ) ) )
            // InternalFactoryLogicLangParser.g:1945:3: otherlv_0= Each ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,Each,FOLLOW_24); 

            			newLeafNode(otherlv_0, grammarAccess.getLoopVariableAccess().getEachKeyword_0());
            		
            // InternalFactoryLogicLangParser.g:1949:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalFactoryLogicLangParser.g:1950:4: (lv_name_1_0= RULE_ID )
            {
            // InternalFactoryLogicLangParser.g:1950:4: (lv_name_1_0= RULE_ID )
            // InternalFactoryLogicLangParser.g:1951:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getLoopVariableAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLoopVariableRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


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
    // $ANTLR end "ruleLoopVariable"


    // $ANTLR start "entryRuleGloablVariable"
    // InternalFactoryLogicLangParser.g:1971:1: entryRuleGloablVariable returns [EObject current=null] : iv_ruleGloablVariable= ruleGloablVariable EOF ;
    public final EObject entryRuleGloablVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGloablVariable = null;


        try {
            // InternalFactoryLogicLangParser.g:1971:55: (iv_ruleGloablVariable= ruleGloablVariable EOF )
            // InternalFactoryLogicLangParser.g:1972:2: iv_ruleGloablVariable= ruleGloablVariable EOF
            {
             newCompositeNode(grammarAccess.getGloablVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGloablVariable=ruleGloablVariable();

            state._fsp--;

             current =iv_ruleGloablVariable; 
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
    // $ANTLR end "entryRuleGloablVariable"


    // $ANTLR start "ruleGloablVariable"
    // InternalFactoryLogicLangParser.g:1978:1: ruleGloablVariable returns [EObject current=null] : (otherlv_0= Into ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleGloablVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalFactoryLogicLangParser.g:1984:2: ( (otherlv_0= Into ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalFactoryLogicLangParser.g:1985:2: (otherlv_0= Into ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalFactoryLogicLangParser.g:1985:2: (otherlv_0= Into ( (lv_name_1_0= RULE_ID ) ) )
            // InternalFactoryLogicLangParser.g:1986:3: otherlv_0= Into ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,Into,FOLLOW_24); 

            			newLeafNode(otherlv_0, grammarAccess.getGloablVariableAccess().getIntoKeyword_0());
            		
            // InternalFactoryLogicLangParser.g:1990:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalFactoryLogicLangParser.g:1991:4: (lv_name_1_0= RULE_ID )
            {
            // InternalFactoryLogicLangParser.g:1991:4: (lv_name_1_0= RULE_ID )
            // InternalFactoryLogicLangParser.g:1992:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getGloablVariableAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGloablVariableRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


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
    // $ANTLR end "ruleGloablVariable"


    // $ANTLR start "entryRuleCranePickup"
    // InternalFactoryLogicLangParser.g:2012:1: entryRuleCranePickup returns [EObject current=null] : iv_ruleCranePickup= ruleCranePickup EOF ;
    public final EObject entryRuleCranePickup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCranePickup = null;


        try {
            // InternalFactoryLogicLangParser.g:2012:52: (iv_ruleCranePickup= ruleCranePickup EOF )
            // InternalFactoryLogicLangParser.g:2013:2: iv_ruleCranePickup= ruleCranePickup EOF
            {
             newCompositeNode(grammarAccess.getCranePickupRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCranePickup=ruleCranePickup();

            state._fsp--;

             current =iv_ruleCranePickup; 
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
    // $ANTLR end "entryRuleCranePickup"


    // $ANTLR start "ruleCranePickup"
    // InternalFactoryLogicLangParser.g:2019:1: ruleCranePickup returns [EObject current=null] : ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= Pickup otherlv_2= Item otherlv_3= At ( (otherlv_4= RULE_STRING ) ) ) ;
    public final EObject ruleCranePickup() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalFactoryLogicLangParser.g:2025:2: ( ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= Pickup otherlv_2= Item otherlv_3= At ( (otherlv_4= RULE_STRING ) ) ) )
            // InternalFactoryLogicLangParser.g:2026:2: ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= Pickup otherlv_2= Item otherlv_3= At ( (otherlv_4= RULE_STRING ) ) )
            {
            // InternalFactoryLogicLangParser.g:2026:2: ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= Pickup otherlv_2= Item otherlv_3= At ( (otherlv_4= RULE_STRING ) ) )
            // InternalFactoryLogicLangParser.g:2027:3: ( (otherlv_0= RULE_STRING ) ) otherlv_1= Pickup otherlv_2= Item otherlv_3= At ( (otherlv_4= RULE_STRING ) )
            {
            // InternalFactoryLogicLangParser.g:2027:3: ( (otherlv_0= RULE_STRING ) )
            // InternalFactoryLogicLangParser.g:2028:4: (otherlv_0= RULE_STRING )
            {
            // InternalFactoryLogicLangParser.g:2028:4: (otherlv_0= RULE_STRING )
            // InternalFactoryLogicLangParser.g:2029:5: otherlv_0= RULE_STRING
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCranePickupRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_STRING,FOLLOW_42); 

            					newLeafNode(otherlv_0, grammarAccess.getCranePickupAccess().getDeviceCraneCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,Pickup,FOLLOW_43); 

            			newLeafNode(otherlv_1, grammarAccess.getCranePickupAccess().getPickupKeyword_1());
            		
            otherlv_2=(Token)match(input,Item,FOLLOW_11); 

            			newLeafNode(otherlv_2, grammarAccess.getCranePickupAccess().getItemKeyword_2());
            		
            otherlv_3=(Token)match(input,At,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getCranePickupAccess().getAtKeyword_3());
            		
            // InternalFactoryLogicLangParser.g:2052:3: ( (otherlv_4= RULE_STRING ) )
            // InternalFactoryLogicLangParser.g:2053:4: (otherlv_4= RULE_STRING )
            {
            // InternalFactoryLogicLangParser.g:2053:4: (otherlv_4= RULE_STRING )
            // InternalFactoryLogicLangParser.g:2054:5: otherlv_4= RULE_STRING
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCranePickupRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(otherlv_4, grammarAccess.getCranePickupAccess().getLocationCraneParameterCrossReference_4_0());
            				

            }


            }


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
    // $ANTLR end "ruleCranePickup"


    // $ANTLR start "entryRuleCraneDrop"
    // InternalFactoryLogicLangParser.g:2069:1: entryRuleCraneDrop returns [EObject current=null] : iv_ruleCraneDrop= ruleCraneDrop EOF ;
    public final EObject entryRuleCraneDrop() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCraneDrop = null;


        try {
            // InternalFactoryLogicLangParser.g:2069:50: (iv_ruleCraneDrop= ruleCraneDrop EOF )
            // InternalFactoryLogicLangParser.g:2070:2: iv_ruleCraneDrop= ruleCraneDrop EOF
            {
             newCompositeNode(grammarAccess.getCraneDropRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCraneDrop=ruleCraneDrop();

            state._fsp--;

             current =iv_ruleCraneDrop; 
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
    // $ANTLR end "entryRuleCraneDrop"


    // $ANTLR start "ruleCraneDrop"
    // InternalFactoryLogicLangParser.g:2076:1: ruleCraneDrop returns [EObject current=null] : ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= Drop otherlv_2= Item otherlv_3= At ( (otherlv_4= RULE_STRING ) ) ) ;
    public final EObject ruleCraneDrop() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalFactoryLogicLangParser.g:2082:2: ( ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= Drop otherlv_2= Item otherlv_3= At ( (otherlv_4= RULE_STRING ) ) ) )
            // InternalFactoryLogicLangParser.g:2083:2: ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= Drop otherlv_2= Item otherlv_3= At ( (otherlv_4= RULE_STRING ) ) )
            {
            // InternalFactoryLogicLangParser.g:2083:2: ( ( (otherlv_0= RULE_STRING ) ) otherlv_1= Drop otherlv_2= Item otherlv_3= At ( (otherlv_4= RULE_STRING ) ) )
            // InternalFactoryLogicLangParser.g:2084:3: ( (otherlv_0= RULE_STRING ) ) otherlv_1= Drop otherlv_2= Item otherlv_3= At ( (otherlv_4= RULE_STRING ) )
            {
            // InternalFactoryLogicLangParser.g:2084:3: ( (otherlv_0= RULE_STRING ) )
            // InternalFactoryLogicLangParser.g:2085:4: (otherlv_0= RULE_STRING )
            {
            // InternalFactoryLogicLangParser.g:2085:4: (otherlv_0= RULE_STRING )
            // InternalFactoryLogicLangParser.g:2086:5: otherlv_0= RULE_STRING
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCraneDropRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_STRING,FOLLOW_44); 

            					newLeafNode(otherlv_0, grammarAccess.getCraneDropAccess().getDeviceCraneCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,Drop,FOLLOW_43); 

            			newLeafNode(otherlv_1, grammarAccess.getCraneDropAccess().getDropKeyword_1());
            		
            otherlv_2=(Token)match(input,Item,FOLLOW_11); 

            			newLeafNode(otherlv_2, grammarAccess.getCraneDropAccess().getItemKeyword_2());
            		
            otherlv_3=(Token)match(input,At,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getCraneDropAccess().getAtKeyword_3());
            		
            // InternalFactoryLogicLangParser.g:2109:3: ( (otherlv_4= RULE_STRING ) )
            // InternalFactoryLogicLangParser.g:2110:4: (otherlv_4= RULE_STRING )
            {
            // InternalFactoryLogicLangParser.g:2110:4: (otherlv_4= RULE_STRING )
            // InternalFactoryLogicLangParser.g:2111:5: otherlv_4= RULE_STRING
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCraneDropRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(otherlv_4, grammarAccess.getCraneDropAccess().getLocationCraneParameterCrossReference_4_0());
            				

            }


            }


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
    // $ANTLR end "ruleCraneDrop"


    // $ANTLR start "ruleCOLOR"
    // InternalFactoryLogicLangParser.g:2126:1: ruleCOLOR returns [Enumerator current=null] : ( (enumLiteral_0= Red ) | (enumLiteral_1= Blue ) | (enumLiteral_2= Green ) ) ;
    public final Enumerator ruleCOLOR() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalFactoryLogicLangParser.g:2132:2: ( ( (enumLiteral_0= Red ) | (enumLiteral_1= Blue ) | (enumLiteral_2= Green ) ) )
            // InternalFactoryLogicLangParser.g:2133:2: ( (enumLiteral_0= Red ) | (enumLiteral_1= Blue ) | (enumLiteral_2= Green ) )
            {
            // InternalFactoryLogicLangParser.g:2133:2: ( (enumLiteral_0= Red ) | (enumLiteral_1= Blue ) | (enumLiteral_2= Green ) )
            int alt25=3;
            switch ( input.LA(1) ) {
            case Red:
                {
                alt25=1;
                }
                break;
            case Blue:
                {
                alt25=2;
                }
                break;
            case Green:
                {
                alt25=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // InternalFactoryLogicLangParser.g:2134:3: (enumLiteral_0= Red )
                    {
                    // InternalFactoryLogicLangParser.g:2134:3: (enumLiteral_0= Red )
                    // InternalFactoryLogicLangParser.g:2135:4: enumLiteral_0= Red
                    {
                    enumLiteral_0=(Token)match(input,Red,FOLLOW_2); 

                    				current = grammarAccess.getCOLORAccess().getREDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCOLORAccess().getREDEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalFactoryLogicLangParser.g:2142:3: (enumLiteral_1= Blue )
                    {
                    // InternalFactoryLogicLangParser.g:2142:3: (enumLiteral_1= Blue )
                    // InternalFactoryLogicLangParser.g:2143:4: enumLiteral_1= Blue
                    {
                    enumLiteral_1=(Token)match(input,Blue,FOLLOW_2); 

                    				current = grammarAccess.getCOLORAccess().getBLUEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getCOLORAccess().getBLUEEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalFactoryLogicLangParser.g:2150:3: (enumLiteral_2= Green )
                    {
                    // InternalFactoryLogicLangParser.g:2150:3: (enumLiteral_2= Green )
                    // InternalFactoryLogicLangParser.g:2151:4: enumLiteral_2= Green
                    {
                    enumLiteral_2=(Token)match(input,Green,FOLLOW_2); 

                    				current = grammarAccess.getCOLORAccess().getGREENEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getCOLORAccess().getGREENEnumLiteralDeclaration_2());
                    			

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
    // $ANTLR end "ruleCOLOR"


    // $ANTLR start "ruleCONST_VARIABLES"
    // InternalFactoryLogicLangParser.g:2161:1: ruleCONST_VARIABLES returns [Enumerator current=null] : ( (enumLiteral_0= Full ) | (enumLiteral_1= Finished ) | (enumLiteral_2= Empty ) ) ;
    public final Enumerator ruleCONST_VARIABLES() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalFactoryLogicLangParser.g:2167:2: ( ( (enumLiteral_0= Full ) | (enumLiteral_1= Finished ) | (enumLiteral_2= Empty ) ) )
            // InternalFactoryLogicLangParser.g:2168:2: ( (enumLiteral_0= Full ) | (enumLiteral_1= Finished ) | (enumLiteral_2= Empty ) )
            {
            // InternalFactoryLogicLangParser.g:2168:2: ( (enumLiteral_0= Full ) | (enumLiteral_1= Finished ) | (enumLiteral_2= Empty ) )
            int alt26=3;
            switch ( input.LA(1) ) {
            case Full:
                {
                alt26=1;
                }
                break;
            case Finished:
                {
                alt26=2;
                }
                break;
            case Empty:
                {
                alt26=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // InternalFactoryLogicLangParser.g:2169:3: (enumLiteral_0= Full )
                    {
                    // InternalFactoryLogicLangParser.g:2169:3: (enumLiteral_0= Full )
                    // InternalFactoryLogicLangParser.g:2170:4: enumLiteral_0= Full
                    {
                    enumLiteral_0=(Token)match(input,Full,FOLLOW_2); 

                    				current = grammarAccess.getCONST_VARIABLESAccess().getFULLEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCONST_VARIABLESAccess().getFULLEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalFactoryLogicLangParser.g:2177:3: (enumLiteral_1= Finished )
                    {
                    // InternalFactoryLogicLangParser.g:2177:3: (enumLiteral_1= Finished )
                    // InternalFactoryLogicLangParser.g:2178:4: enumLiteral_1= Finished
                    {
                    enumLiteral_1=(Token)match(input,Finished,FOLLOW_2); 

                    				current = grammarAccess.getCONST_VARIABLESAccess().getFINISHEDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getCONST_VARIABLESAccess().getFINISHEDEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalFactoryLogicLangParser.g:2185:3: (enumLiteral_2= Empty )
                    {
                    // InternalFactoryLogicLangParser.g:2185:3: (enumLiteral_2= Empty )
                    // InternalFactoryLogicLangParser.g:2186:4: enumLiteral_2= Empty
                    {
                    enumLiteral_2=(Token)match(input,Empty,FOLLOW_2); 

                    				current = grammarAccess.getCONST_VARIABLESAccess().getEMPTYEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getCONST_VARIABLESAccess().getEMPTYEnumLiteralDeclaration_2());
                    			

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
    // $ANTLR end "ruleCONST_VARIABLES"


    // $ANTLR start "ruleBOOLEAN_OPERATOR"
    // InternalFactoryLogicLangParser.g:2196:1: ruleBOOLEAN_OPERATOR returns [Enumerator current=null] : ( (enumLiteral_0= Not ) | (enumLiteral_1= LessThan ) | (enumLiteral_2= GreaterThan ) ) ;
    public final Enumerator ruleBOOLEAN_OPERATOR() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalFactoryLogicLangParser.g:2202:2: ( ( (enumLiteral_0= Not ) | (enumLiteral_1= LessThan ) | (enumLiteral_2= GreaterThan ) ) )
            // InternalFactoryLogicLangParser.g:2203:2: ( (enumLiteral_0= Not ) | (enumLiteral_1= LessThan ) | (enumLiteral_2= GreaterThan ) )
            {
            // InternalFactoryLogicLangParser.g:2203:2: ( (enumLiteral_0= Not ) | (enumLiteral_1= LessThan ) | (enumLiteral_2= GreaterThan ) )
            int alt27=3;
            switch ( input.LA(1) ) {
            case Not:
                {
                alt27=1;
                }
                break;
            case LessThan:
                {
                alt27=2;
                }
                break;
            case GreaterThan:
                {
                alt27=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // InternalFactoryLogicLangParser.g:2204:3: (enumLiteral_0= Not )
                    {
                    // InternalFactoryLogicLangParser.g:2204:3: (enumLiteral_0= Not )
                    // InternalFactoryLogicLangParser.g:2205:4: enumLiteral_0= Not
                    {
                    enumLiteral_0=(Token)match(input,Not,FOLLOW_2); 

                    				current = grammarAccess.getBOOLEAN_OPERATORAccess().getNOTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getBOOLEAN_OPERATORAccess().getNOTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalFactoryLogicLangParser.g:2212:3: (enumLiteral_1= LessThan )
                    {
                    // InternalFactoryLogicLangParser.g:2212:3: (enumLiteral_1= LessThan )
                    // InternalFactoryLogicLangParser.g:2213:4: enumLiteral_1= LessThan
                    {
                    enumLiteral_1=(Token)match(input,LessThan,FOLLOW_2); 

                    				current = grammarAccess.getBOOLEAN_OPERATORAccess().getLESSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getBOOLEAN_OPERATORAccess().getLESSEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalFactoryLogicLangParser.g:2220:3: (enumLiteral_2= GreaterThan )
                    {
                    // InternalFactoryLogicLangParser.g:2220:3: (enumLiteral_2= GreaterThan )
                    // InternalFactoryLogicLangParser.g:2221:4: enumLiteral_2= GreaterThan
                    {
                    enumLiteral_2=(Token)match(input,GreaterThan,FOLLOW_2); 

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


    // $ANTLR start "ruleTIME"
    // InternalFactoryLogicLangParser.g:2231:1: ruleTIME returns [Enumerator current=null] : ( (enumLiteral_0= Seconds ) | (enumLiteral_1= Second ) | (enumLiteral_2= Minutes ) | (enumLiteral_3= Minute ) | (enumLiteral_4= Hours ) | (enumLiteral_5= Hour ) ) ;
    public final Enumerator ruleTIME() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;


        	enterRule();

        try {
            // InternalFactoryLogicLangParser.g:2237:2: ( ( (enumLiteral_0= Seconds ) | (enumLiteral_1= Second ) | (enumLiteral_2= Minutes ) | (enumLiteral_3= Minute ) | (enumLiteral_4= Hours ) | (enumLiteral_5= Hour ) ) )
            // InternalFactoryLogicLangParser.g:2238:2: ( (enumLiteral_0= Seconds ) | (enumLiteral_1= Second ) | (enumLiteral_2= Minutes ) | (enumLiteral_3= Minute ) | (enumLiteral_4= Hours ) | (enumLiteral_5= Hour ) )
            {
            // InternalFactoryLogicLangParser.g:2238:2: ( (enumLiteral_0= Seconds ) | (enumLiteral_1= Second ) | (enumLiteral_2= Minutes ) | (enumLiteral_3= Minute ) | (enumLiteral_4= Hours ) | (enumLiteral_5= Hour ) )
            int alt28=6;
            switch ( input.LA(1) ) {
            case Seconds:
                {
                alt28=1;
                }
                break;
            case Second:
                {
                alt28=2;
                }
                break;
            case Minutes:
                {
                alt28=3;
                }
                break;
            case Minute:
                {
                alt28=4;
                }
                break;
            case Hours:
                {
                alt28=5;
                }
                break;
            case Hour:
                {
                alt28=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // InternalFactoryLogicLangParser.g:2239:3: (enumLiteral_0= Seconds )
                    {
                    // InternalFactoryLogicLangParser.g:2239:3: (enumLiteral_0= Seconds )
                    // InternalFactoryLogicLangParser.g:2240:4: enumLiteral_0= Seconds
                    {
                    enumLiteral_0=(Token)match(input,Seconds,FOLLOW_2); 

                    				current = grammarAccess.getTIMEAccess().getSECONDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getTIMEAccess().getSECONDEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalFactoryLogicLangParser.g:2247:3: (enumLiteral_1= Second )
                    {
                    // InternalFactoryLogicLangParser.g:2247:3: (enumLiteral_1= Second )
                    // InternalFactoryLogicLangParser.g:2248:4: enumLiteral_1= Second
                    {
                    enumLiteral_1=(Token)match(input,Second,FOLLOW_2); 

                    				current = grammarAccess.getTIMEAccess().getSECONDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getTIMEAccess().getSECONDEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalFactoryLogicLangParser.g:2255:3: (enumLiteral_2= Minutes )
                    {
                    // InternalFactoryLogicLangParser.g:2255:3: (enumLiteral_2= Minutes )
                    // InternalFactoryLogicLangParser.g:2256:4: enumLiteral_2= Minutes
                    {
                    enumLiteral_2=(Token)match(input,Minutes,FOLLOW_2); 

                    				current = grammarAccess.getTIMEAccess().getMINUTEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getTIMEAccess().getMINUTEEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalFactoryLogicLangParser.g:2263:3: (enumLiteral_3= Minute )
                    {
                    // InternalFactoryLogicLangParser.g:2263:3: (enumLiteral_3= Minute )
                    // InternalFactoryLogicLangParser.g:2264:4: enumLiteral_3= Minute
                    {
                    enumLiteral_3=(Token)match(input,Minute,FOLLOW_2); 

                    				current = grammarAccess.getTIMEAccess().getMINUTEEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getTIMEAccess().getMINUTEEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalFactoryLogicLangParser.g:2271:3: (enumLiteral_4= Hours )
                    {
                    // InternalFactoryLogicLangParser.g:2271:3: (enumLiteral_4= Hours )
                    // InternalFactoryLogicLangParser.g:2272:4: enumLiteral_4= Hours
                    {
                    enumLiteral_4=(Token)match(input,Hours,FOLLOW_2); 

                    				current = grammarAccess.getTIMEAccess().getHOUREnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getTIMEAccess().getHOUREnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalFactoryLogicLangParser.g:2279:3: (enumLiteral_5= Hour )
                    {
                    // InternalFactoryLogicLangParser.g:2279:3: (enumLiteral_5= Hour )
                    // InternalFactoryLogicLangParser.g:2280:4: enumLiteral_5= Hour
                    {
                    enumLiteral_5=(Token)match(input,Hour,FOLLOW_2); 

                    				current = grammarAccess.getTIMEAccess().getHOUREnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getTIMEAccess().getHOUREnumLiteralDeclaration_5());
                    			

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
    // $ANTLR end "ruleTIME"

    // Delegated rules


    protected DFA22 dfa22 = new DFA22(this);
    static final String dfa_1s = "\13\uffff";
    static final String dfa_2s = "\1\64\1\16\1\22\4\uffff\1\52\3\uffff";
    static final String dfa_3s = "\1\64\1\41\1\42\4\uffff\1\56\3\uffff";
    static final String dfa_4s = "\3\uffff\1\3\1\7\1\6\1\5\1\uffff\1\1\1\2\1\4";
    static final String dfa_5s = "\13\uffff}>";
    static final String[] dfa_6s = {
            "\1\1",
            "\1\5\12\uffff\1\4\5\uffff\1\3\1\2\1\6",
            "\1\10\17\uffff\1\7",
            "",
            "",
            "",
            "",
            "\1\11\3\uffff\1\12",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "1417:2: (this_StorageMoveEmptySlot_0= ruleStorageMoveEmptySlot | this_StorageMoveSlot_1= ruleStorageMoveSlot | this_StorageMarkSlot_2= ruleStorageMarkSlot | this_StorageMoveVariableSlot_3= ruleStorageMoveVariableSlot | this_CameraScan_4= ruleCameraScan | this_CranePickup_5= ruleCranePickup | this_CraneDrop_6= ruleCraneDrop )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0010084000001002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0002002000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000010001100000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0008018009140070L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0008010009140040L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0012084000001000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000008000080030L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000400800000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x000C010009140040L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x000000001020A300L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000002000000L});

}