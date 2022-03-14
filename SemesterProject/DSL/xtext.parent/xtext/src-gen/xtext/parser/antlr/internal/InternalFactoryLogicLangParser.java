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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "GreaterThan", "LessThan", "Finished", "Position", "Minutes", "Seconds", "Storage", "Camera", "Create", "Minute", "Pickup", "Second", "Color", "Crane", "Empty", "Green", "Hours", "Named", "Slots", "Blue", "Drop", "Each", "Full", "Hour", "Into", "Item", "Mark", "Move", "Scan", "Slot", "That", "Then", "With", "For", "Not", "Red", "As", "At", "If", "In", "Is", "Of", "To", "RULE_BEGIN", "RULE_END", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int Each=25;
    public static final int RULE_BEGIN=47;
    public static final int Crane=17;
    public static final int Minutes=8;
    public static final int Full=26;
    public static final int Item=29;
    public static final int LessThan=5;
    public static final int GreaterThan=4;
    public static final int Then=35;
    public static final int Camera=11;
    public static final int To=46;
    public static final int Finished=6;
    public static final int Into=28;
    public static final int RULE_ID=49;
    public static final int Position=7;
    public static final int Hour=27;
    public static final int Color=16;
    public static final int For=37;
    public static final int Drop=24;
    public static final int Not=38;
    public static final int Storage=10;
    public static final int RULE_INT=50;
    public static final int RULE_ML_COMMENT=52;
    public static final int Slot=33;
    public static final int Scan=32;
    public static final int If=42;
    public static final int RULE_END=48;
    public static final int Hours=20;
    public static final int In=43;
    public static final int Mark=30;
    public static final int Is=44;
    public static final int RULE_STRING=51;
    public static final int With=36;
    public static final int RULE_SL_COMMENT=53;
    public static final int Slots=22;
    public static final int Empty=18;
    public static final int As=40;
    public static final int At=41;
    public static final int Minute=13;
    public static final int Move=31;
    public static final int Create=12;
    public static final int EOF=-1;
    public static final int That=34;
    public static final int Named=21;
    public static final int Pickup=14;
    public static final int Blue=23;
    public static final int RULE_WS=54;
    public static final int RULE_ANY_OTHER=55;
    public static final int Red=39;
    public static final int Second=15;
    public static final int Of=45;
    public static final int Seconds=9;
    public static final int Green=19;

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

                if ( (LA1_0==Create||LA1_0==For||LA1_0==If||LA1_0==RULE_ID) ) {
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
            else if ( (LA2_0==For||LA2_0==If||LA2_0==RULE_ID) ) {
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
                case Crane:
                    {
                    alt3=1;
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

                if ( (LA6_1==Position) ) {
                    alt6=1;
                }
                else if ( (LA6_1==RULE_INT) ) {
                    alt6=2;
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
    // InternalFactoryLogicLangParser.g:683:1: ruleLogic returns [EObject current=null] : (this_Conditional_0= ruleConditional | this_Loop_1= ruleLoop | this_Operation_2= ruleOperation ) ;
    public final EObject ruleLogic() throws RecognitionException {
        EObject current = null;

        EObject this_Conditional_0 = null;

        EObject this_Loop_1 = null;

        EObject this_Operation_2 = null;



        	enterRule();

        try {
            // InternalFactoryLogicLangParser.g:689:2: ( (this_Conditional_0= ruleConditional | this_Loop_1= ruleLoop | this_Operation_2= ruleOperation ) )
            // InternalFactoryLogicLangParser.g:690:2: (this_Conditional_0= ruleConditional | this_Loop_1= ruleLoop | this_Operation_2= ruleOperation )
            {
            // InternalFactoryLogicLangParser.g:690:2: (this_Conditional_0= ruleConditional | this_Loop_1= ruleLoop | this_Operation_2= ruleOperation )
            int alt8=3;
            switch ( input.LA(1) ) {
            case If:
                {
                alt8=1;
                }
                break;
            case For:
                {
                alt8=2;
                }
                break;
            case RULE_ID:
                {
                alt8=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalFactoryLogicLangParser.g:691:3: this_Conditional_0= ruleConditional
                    {

                    			newCompositeNode(grammarAccess.getLogicAccess().getConditionalParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Conditional_0=ruleConditional();

                    state._fsp--;


                    			current = this_Conditional_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalFactoryLogicLangParser.g:700:3: this_Loop_1= ruleLoop
                    {

                    			newCompositeNode(grammarAccess.getLogicAccess().getLoopParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Loop_1=ruleLoop();

                    state._fsp--;


                    			current = this_Loop_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalFactoryLogicLangParser.g:709:3: this_Operation_2= ruleOperation
                    {

                    			newCompositeNode(grammarAccess.getLogicAccess().getOperationParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Operation_2=ruleOperation();

                    state._fsp--;


                    			current = this_Operation_2;
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


    // $ANTLR start "entryRuleConditional"
    // InternalFactoryLogicLangParser.g:721:1: entryRuleConditional returns [EObject current=null] : iv_ruleConditional= ruleConditional EOF ;
    public final EObject entryRuleConditional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditional = null;


        try {
            // InternalFactoryLogicLangParser.g:721:52: (iv_ruleConditional= ruleConditional EOF )
            // InternalFactoryLogicLangParser.g:722:2: iv_ruleConditional= ruleConditional EOF
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
    // InternalFactoryLogicLangParser.g:728:1: ruleConditional returns [EObject current=null] : (otherlv_0= If ( (lv_variable_1_0= RULE_ID ) ) (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) )? otherlv_4= Is ( (lv_operator_5_0= ruleBOOLEAN_OPERATOR ) )? ( ( (lv_comparison_const_6_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_7_0= ruleCOLOR ) ) | ( (lv_comparison_int_8_0= RULE_INT ) ) ) otherlv_9= Then this_BEGIN_10= RULE_BEGIN ( (lv_logics_11_0= ruleLogic ) )+ this_END_12= RULE_END ) ;
    public final EObject ruleConditional() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_variable_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_comparison_int_8_0=null;
        Token otherlv_9=null;
        Token this_BEGIN_10=null;
        Token this_END_12=null;
        Enumerator lv_operator_5_0 = null;

        Enumerator lv_comparison_const_6_0 = null;

        Enumerator lv_comparison_color_7_0 = null;

        EObject lv_logics_11_0 = null;



        	enterRule();

        try {
            // InternalFactoryLogicLangParser.g:734:2: ( (otherlv_0= If ( (lv_variable_1_0= RULE_ID ) ) (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) )? otherlv_4= Is ( (lv_operator_5_0= ruleBOOLEAN_OPERATOR ) )? ( ( (lv_comparison_const_6_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_7_0= ruleCOLOR ) ) | ( (lv_comparison_int_8_0= RULE_INT ) ) ) otherlv_9= Then this_BEGIN_10= RULE_BEGIN ( (lv_logics_11_0= ruleLogic ) )+ this_END_12= RULE_END ) )
            // InternalFactoryLogicLangParser.g:735:2: (otherlv_0= If ( (lv_variable_1_0= RULE_ID ) ) (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) )? otherlv_4= Is ( (lv_operator_5_0= ruleBOOLEAN_OPERATOR ) )? ( ( (lv_comparison_const_6_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_7_0= ruleCOLOR ) ) | ( (lv_comparison_int_8_0= RULE_INT ) ) ) otherlv_9= Then this_BEGIN_10= RULE_BEGIN ( (lv_logics_11_0= ruleLogic ) )+ this_END_12= RULE_END )
            {
            // InternalFactoryLogicLangParser.g:735:2: (otherlv_0= If ( (lv_variable_1_0= RULE_ID ) ) (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) )? otherlv_4= Is ( (lv_operator_5_0= ruleBOOLEAN_OPERATOR ) )? ( ( (lv_comparison_const_6_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_7_0= ruleCOLOR ) ) | ( (lv_comparison_int_8_0= RULE_INT ) ) ) otherlv_9= Then this_BEGIN_10= RULE_BEGIN ( (lv_logics_11_0= ruleLogic ) )+ this_END_12= RULE_END )
            // InternalFactoryLogicLangParser.g:736:3: otherlv_0= If ( (lv_variable_1_0= RULE_ID ) ) (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) )? otherlv_4= Is ( (lv_operator_5_0= ruleBOOLEAN_OPERATOR ) )? ( ( (lv_comparison_const_6_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_7_0= ruleCOLOR ) ) | ( (lv_comparison_int_8_0= RULE_INT ) ) ) otherlv_9= Then this_BEGIN_10= RULE_BEGIN ( (lv_logics_11_0= ruleLogic ) )+ this_END_12= RULE_END
            {
            otherlv_0=(Token)match(input,If,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getConditionalAccess().getIfKeyword_0());
            		
            // InternalFactoryLogicLangParser.g:740:3: ( (lv_variable_1_0= RULE_ID ) )
            // InternalFactoryLogicLangParser.g:741:4: (lv_variable_1_0= RULE_ID )
            {
            // InternalFactoryLogicLangParser.g:741:4: (lv_variable_1_0= RULE_ID )
            // InternalFactoryLogicLangParser.g:742:5: lv_variable_1_0= RULE_ID
            {
            lv_variable_1_0=(Token)match(input,RULE_ID,FOLLOW_20); 

            					newLeafNode(lv_variable_1_0, grammarAccess.getConditionalAccess().getVariableIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConditionalRule());
            					}
            					setWithLastConsumed(
            						current,
            						"variable",
            						lv_variable_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalFactoryLogicLangParser.g:758:3: (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==Of) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalFactoryLogicLangParser.g:759:4: otherlv_2= Of ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,Of,FOLLOW_19); 

                    				newLeafNode(otherlv_2, grammarAccess.getConditionalAccess().getOfKeyword_2_0());
                    			
                    // InternalFactoryLogicLangParser.g:763:4: ( (otherlv_3= RULE_ID ) )
                    // InternalFactoryLogicLangParser.g:764:5: (otherlv_3= RULE_ID )
                    {
                    // InternalFactoryLogicLangParser.g:764:5: (otherlv_3= RULE_ID )
                    // InternalFactoryLogicLangParser.g:765:6: otherlv_3= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getConditionalRule());
                    						}
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_21); 

                    						newLeafNode(otherlv_3, grammarAccess.getConditionalAccess().getSourceDeviceCrossReference_2_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,Is,FOLLOW_22); 

            			newLeafNode(otherlv_4, grammarAccess.getConditionalAccess().getIsKeyword_3());
            		
            // InternalFactoryLogicLangParser.g:781:3: ( (lv_operator_5_0= ruleBOOLEAN_OPERATOR ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>=GreaterThan && LA10_0<=LessThan)||LA10_0==Not) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalFactoryLogicLangParser.g:782:4: (lv_operator_5_0= ruleBOOLEAN_OPERATOR )
                    {
                    // InternalFactoryLogicLangParser.g:782:4: (lv_operator_5_0= ruleBOOLEAN_OPERATOR )
                    // InternalFactoryLogicLangParser.g:783:5: lv_operator_5_0= ruleBOOLEAN_OPERATOR
                    {

                    					newCompositeNode(grammarAccess.getConditionalAccess().getOperatorBOOLEAN_OPERATOREnumRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_23);
                    lv_operator_5_0=ruleBOOLEAN_OPERATOR();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getConditionalRule());
                    					}
                    					set(
                    						current,
                    						"operator",
                    						lv_operator_5_0,
                    						"xtext.FactoryLogicLang.BOOLEAN_OPERATOR");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalFactoryLogicLangParser.g:800:3: ( ( (lv_comparison_const_6_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_7_0= ruleCOLOR ) ) | ( (lv_comparison_int_8_0= RULE_INT ) ) )
            int alt11=3;
            switch ( input.LA(1) ) {
            case Finished:
            case Empty:
            case Full:
                {
                alt11=1;
                }
                break;
            case Green:
            case Blue:
            case Red:
                {
                alt11=2;
                }
                break;
            case RULE_INT:
                {
                alt11=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalFactoryLogicLangParser.g:801:4: ( (lv_comparison_const_6_0= ruleCONST_VARIABLES ) )
                    {
                    // InternalFactoryLogicLangParser.g:801:4: ( (lv_comparison_const_6_0= ruleCONST_VARIABLES ) )
                    // InternalFactoryLogicLangParser.g:802:5: (lv_comparison_const_6_0= ruleCONST_VARIABLES )
                    {
                    // InternalFactoryLogicLangParser.g:802:5: (lv_comparison_const_6_0= ruleCONST_VARIABLES )
                    // InternalFactoryLogicLangParser.g:803:6: lv_comparison_const_6_0= ruleCONST_VARIABLES
                    {

                    						newCompositeNode(grammarAccess.getConditionalAccess().getComparison_constCONST_VARIABLESEnumRuleCall_5_0_0());
                    					
                    pushFollow(FOLLOW_24);
                    lv_comparison_const_6_0=ruleCONST_VARIABLES();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getConditionalRule());
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
                    // InternalFactoryLogicLangParser.g:821:4: ( (lv_comparison_color_7_0= ruleCOLOR ) )
                    {
                    // InternalFactoryLogicLangParser.g:821:4: ( (lv_comparison_color_7_0= ruleCOLOR ) )
                    // InternalFactoryLogicLangParser.g:822:5: (lv_comparison_color_7_0= ruleCOLOR )
                    {
                    // InternalFactoryLogicLangParser.g:822:5: (lv_comparison_color_7_0= ruleCOLOR )
                    // InternalFactoryLogicLangParser.g:823:6: lv_comparison_color_7_0= ruleCOLOR
                    {

                    						newCompositeNode(grammarAccess.getConditionalAccess().getComparison_colorCOLOREnumRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_24);
                    lv_comparison_color_7_0=ruleCOLOR();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getConditionalRule());
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
                    // InternalFactoryLogicLangParser.g:841:4: ( (lv_comparison_int_8_0= RULE_INT ) )
                    {
                    // InternalFactoryLogicLangParser.g:841:4: ( (lv_comparison_int_8_0= RULE_INT ) )
                    // InternalFactoryLogicLangParser.g:842:5: (lv_comparison_int_8_0= RULE_INT )
                    {
                    // InternalFactoryLogicLangParser.g:842:5: (lv_comparison_int_8_0= RULE_INT )
                    // InternalFactoryLogicLangParser.g:843:6: lv_comparison_int_8_0= RULE_INT
                    {
                    lv_comparison_int_8_0=(Token)match(input,RULE_INT,FOLLOW_24); 

                    						newLeafNode(lv_comparison_int_8_0, grammarAccess.getConditionalAccess().getComparison_intINTTerminalRuleCall_5_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getConditionalRule());
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

            			newLeafNode(otherlv_9, grammarAccess.getConditionalAccess().getThenKeyword_6());
            		
            this_BEGIN_10=(Token)match(input,RULE_BEGIN,FOLLOW_25); 

            			newLeafNode(this_BEGIN_10, grammarAccess.getConditionalAccess().getBEGINTerminalRuleCall_7());
            		
            // InternalFactoryLogicLangParser.g:868:3: ( (lv_logics_11_0= ruleLogic ) )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==For||LA12_0==If||LA12_0==RULE_ID) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalFactoryLogicLangParser.g:869:4: (lv_logics_11_0= ruleLogic )
            	    {
            	    // InternalFactoryLogicLangParser.g:869:4: (lv_logics_11_0= ruleLogic )
            	    // InternalFactoryLogicLangParser.g:870:5: lv_logics_11_0= ruleLogic
            	    {

            	    					newCompositeNode(grammarAccess.getConditionalAccess().getLogicsLogicParserRuleCall_8_0());
            	    				
            	    pushFollow(FOLLOW_25);
            	    lv_logics_11_0=ruleLogic();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getConditionalRule());
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
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);

            this_END_12=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_12, grammarAccess.getConditionalAccess().getENDTerminalRuleCall_9());
            		

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
    // InternalFactoryLogicLangParser.g:895:1: entryRuleLoop returns [EObject current=null] : iv_ruleLoop= ruleLoop EOF ;
    public final EObject entryRuleLoop() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoop = null;


        try {
            // InternalFactoryLogicLangParser.g:895:45: (iv_ruleLoop= ruleLoop EOF )
            // InternalFactoryLogicLangParser.g:896:2: iv_ruleLoop= ruleLoop EOF
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
    // InternalFactoryLogicLangParser.g:902:1: ruleLoop returns [EObject current=null] : (otherlv_0= For otherlv_1= Each ( (lv_name_2_0= RULE_ID ) ) otherlv_3= In ( (lv_list_4_0= RULE_ID ) ) (otherlv_5= Of ( (otherlv_6= RULE_ID ) ) )? otherlv_7= That otherlv_8= Is ( (lv_operator_9_0= ruleBOOLEAN_OPERATOR ) )? ( ( (lv_comparison_const_10_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_11_0= ruleCOLOR ) ) | ( (lv_comparison_int_12_0= RULE_INT ) ) ) otherlv_13= Then this_BEGIN_14= RULE_BEGIN ( (lv_logics_15_0= ruleLogic ) )+ this_END_16= RULE_END ) ;
    public final EObject ruleLoop() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token lv_list_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token lv_comparison_int_12_0=null;
        Token otherlv_13=null;
        Token this_BEGIN_14=null;
        Token this_END_16=null;
        Enumerator lv_operator_9_0 = null;

        Enumerator lv_comparison_const_10_0 = null;

        Enumerator lv_comparison_color_11_0 = null;

        EObject lv_logics_15_0 = null;



        	enterRule();

        try {
            // InternalFactoryLogicLangParser.g:908:2: ( (otherlv_0= For otherlv_1= Each ( (lv_name_2_0= RULE_ID ) ) otherlv_3= In ( (lv_list_4_0= RULE_ID ) ) (otherlv_5= Of ( (otherlv_6= RULE_ID ) ) )? otherlv_7= That otherlv_8= Is ( (lv_operator_9_0= ruleBOOLEAN_OPERATOR ) )? ( ( (lv_comparison_const_10_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_11_0= ruleCOLOR ) ) | ( (lv_comparison_int_12_0= RULE_INT ) ) ) otherlv_13= Then this_BEGIN_14= RULE_BEGIN ( (lv_logics_15_0= ruleLogic ) )+ this_END_16= RULE_END ) )
            // InternalFactoryLogicLangParser.g:909:2: (otherlv_0= For otherlv_1= Each ( (lv_name_2_0= RULE_ID ) ) otherlv_3= In ( (lv_list_4_0= RULE_ID ) ) (otherlv_5= Of ( (otherlv_6= RULE_ID ) ) )? otherlv_7= That otherlv_8= Is ( (lv_operator_9_0= ruleBOOLEAN_OPERATOR ) )? ( ( (lv_comparison_const_10_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_11_0= ruleCOLOR ) ) | ( (lv_comparison_int_12_0= RULE_INT ) ) ) otherlv_13= Then this_BEGIN_14= RULE_BEGIN ( (lv_logics_15_0= ruleLogic ) )+ this_END_16= RULE_END )
            {
            // InternalFactoryLogicLangParser.g:909:2: (otherlv_0= For otherlv_1= Each ( (lv_name_2_0= RULE_ID ) ) otherlv_3= In ( (lv_list_4_0= RULE_ID ) ) (otherlv_5= Of ( (otherlv_6= RULE_ID ) ) )? otherlv_7= That otherlv_8= Is ( (lv_operator_9_0= ruleBOOLEAN_OPERATOR ) )? ( ( (lv_comparison_const_10_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_11_0= ruleCOLOR ) ) | ( (lv_comparison_int_12_0= RULE_INT ) ) ) otherlv_13= Then this_BEGIN_14= RULE_BEGIN ( (lv_logics_15_0= ruleLogic ) )+ this_END_16= RULE_END )
            // InternalFactoryLogicLangParser.g:910:3: otherlv_0= For otherlv_1= Each ( (lv_name_2_0= RULE_ID ) ) otherlv_3= In ( (lv_list_4_0= RULE_ID ) ) (otherlv_5= Of ( (otherlv_6= RULE_ID ) ) )? otherlv_7= That otherlv_8= Is ( (lv_operator_9_0= ruleBOOLEAN_OPERATOR ) )? ( ( (lv_comparison_const_10_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_11_0= ruleCOLOR ) ) | ( (lv_comparison_int_12_0= RULE_INT ) ) ) otherlv_13= Then this_BEGIN_14= RULE_BEGIN ( (lv_logics_15_0= ruleLogic ) )+ this_END_16= RULE_END
            {
            otherlv_0=(Token)match(input,For,FOLLOW_26); 

            			newLeafNode(otherlv_0, grammarAccess.getLoopAccess().getForKeyword_0());
            		
            otherlv_1=(Token)match(input,Each,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getLoopAccess().getEachKeyword_1());
            		
            // InternalFactoryLogicLangParser.g:918:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalFactoryLogicLangParser.g:919:4: (lv_name_2_0= RULE_ID )
            {
            // InternalFactoryLogicLangParser.g:919:4: (lv_name_2_0= RULE_ID )
            // InternalFactoryLogicLangParser.g:920:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_27); 

            					newLeafNode(lv_name_2_0, grammarAccess.getLoopAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLoopRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,In,FOLLOW_19); 

            			newLeafNode(otherlv_3, grammarAccess.getLoopAccess().getInKeyword_3());
            		
            // InternalFactoryLogicLangParser.g:940:3: ( (lv_list_4_0= RULE_ID ) )
            // InternalFactoryLogicLangParser.g:941:4: (lv_list_4_0= RULE_ID )
            {
            // InternalFactoryLogicLangParser.g:941:4: (lv_list_4_0= RULE_ID )
            // InternalFactoryLogicLangParser.g:942:5: lv_list_4_0= RULE_ID
            {
            lv_list_4_0=(Token)match(input,RULE_ID,FOLLOW_28); 

            					newLeafNode(lv_list_4_0, grammarAccess.getLoopAccess().getListIDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLoopRule());
            					}
            					setWithLastConsumed(
            						current,
            						"list",
            						lv_list_4_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalFactoryLogicLangParser.g:958:3: (otherlv_5= Of ( (otherlv_6= RULE_ID ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==Of) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalFactoryLogicLangParser.g:959:4: otherlv_5= Of ( (otherlv_6= RULE_ID ) )
                    {
                    otherlv_5=(Token)match(input,Of,FOLLOW_19); 

                    				newLeafNode(otherlv_5, grammarAccess.getLoopAccess().getOfKeyword_5_0());
                    			
                    // InternalFactoryLogicLangParser.g:963:4: ( (otherlv_6= RULE_ID ) )
                    // InternalFactoryLogicLangParser.g:964:5: (otherlv_6= RULE_ID )
                    {
                    // InternalFactoryLogicLangParser.g:964:5: (otherlv_6= RULE_ID )
                    // InternalFactoryLogicLangParser.g:965:6: otherlv_6= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLoopRule());
                    						}
                    					
                    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_29); 

                    						newLeafNode(otherlv_6, grammarAccess.getLoopAccess().getSourceDeviceCrossReference_5_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,That,FOLLOW_21); 

            			newLeafNode(otherlv_7, grammarAccess.getLoopAccess().getThatKeyword_6());
            		
            otherlv_8=(Token)match(input,Is,FOLLOW_22); 

            			newLeafNode(otherlv_8, grammarAccess.getLoopAccess().getIsKeyword_7());
            		
            // InternalFactoryLogicLangParser.g:985:3: ( (lv_operator_9_0= ruleBOOLEAN_OPERATOR ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=GreaterThan && LA14_0<=LessThan)||LA14_0==Not) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalFactoryLogicLangParser.g:986:4: (lv_operator_9_0= ruleBOOLEAN_OPERATOR )
                    {
                    // InternalFactoryLogicLangParser.g:986:4: (lv_operator_9_0= ruleBOOLEAN_OPERATOR )
                    // InternalFactoryLogicLangParser.g:987:5: lv_operator_9_0= ruleBOOLEAN_OPERATOR
                    {

                    					newCompositeNode(grammarAccess.getLoopAccess().getOperatorBOOLEAN_OPERATOREnumRuleCall_8_0());
                    				
                    pushFollow(FOLLOW_23);
                    lv_operator_9_0=ruleBOOLEAN_OPERATOR();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getLoopRule());
                    					}
                    					set(
                    						current,
                    						"operator",
                    						lv_operator_9_0,
                    						"xtext.FactoryLogicLang.BOOLEAN_OPERATOR");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalFactoryLogicLangParser.g:1004:3: ( ( (lv_comparison_const_10_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_11_0= ruleCOLOR ) ) | ( (lv_comparison_int_12_0= RULE_INT ) ) )
            int alt15=3;
            switch ( input.LA(1) ) {
            case Finished:
            case Empty:
            case Full:
                {
                alt15=1;
                }
                break;
            case Green:
            case Blue:
            case Red:
                {
                alt15=2;
                }
                break;
            case RULE_INT:
                {
                alt15=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // InternalFactoryLogicLangParser.g:1005:4: ( (lv_comparison_const_10_0= ruleCONST_VARIABLES ) )
                    {
                    // InternalFactoryLogicLangParser.g:1005:4: ( (lv_comparison_const_10_0= ruleCONST_VARIABLES ) )
                    // InternalFactoryLogicLangParser.g:1006:5: (lv_comparison_const_10_0= ruleCONST_VARIABLES )
                    {
                    // InternalFactoryLogicLangParser.g:1006:5: (lv_comparison_const_10_0= ruleCONST_VARIABLES )
                    // InternalFactoryLogicLangParser.g:1007:6: lv_comparison_const_10_0= ruleCONST_VARIABLES
                    {

                    						newCompositeNode(grammarAccess.getLoopAccess().getComparison_constCONST_VARIABLESEnumRuleCall_9_0_0());
                    					
                    pushFollow(FOLLOW_24);
                    lv_comparison_const_10_0=ruleCONST_VARIABLES();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getLoopRule());
                    						}
                    						set(
                    							current,
                    							"comparison_const",
                    							lv_comparison_const_10_0,
                    							"xtext.FactoryLogicLang.CONST_VARIABLES");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalFactoryLogicLangParser.g:1025:4: ( (lv_comparison_color_11_0= ruleCOLOR ) )
                    {
                    // InternalFactoryLogicLangParser.g:1025:4: ( (lv_comparison_color_11_0= ruleCOLOR ) )
                    // InternalFactoryLogicLangParser.g:1026:5: (lv_comparison_color_11_0= ruleCOLOR )
                    {
                    // InternalFactoryLogicLangParser.g:1026:5: (lv_comparison_color_11_0= ruleCOLOR )
                    // InternalFactoryLogicLangParser.g:1027:6: lv_comparison_color_11_0= ruleCOLOR
                    {

                    						newCompositeNode(grammarAccess.getLoopAccess().getComparison_colorCOLOREnumRuleCall_9_1_0());
                    					
                    pushFollow(FOLLOW_24);
                    lv_comparison_color_11_0=ruleCOLOR();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getLoopRule());
                    						}
                    						set(
                    							current,
                    							"comparison_color",
                    							lv_comparison_color_11_0,
                    							"xtext.FactoryLogicLang.COLOR");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalFactoryLogicLangParser.g:1045:4: ( (lv_comparison_int_12_0= RULE_INT ) )
                    {
                    // InternalFactoryLogicLangParser.g:1045:4: ( (lv_comparison_int_12_0= RULE_INT ) )
                    // InternalFactoryLogicLangParser.g:1046:5: (lv_comparison_int_12_0= RULE_INT )
                    {
                    // InternalFactoryLogicLangParser.g:1046:5: (lv_comparison_int_12_0= RULE_INT )
                    // InternalFactoryLogicLangParser.g:1047:6: lv_comparison_int_12_0= RULE_INT
                    {
                    lv_comparison_int_12_0=(Token)match(input,RULE_INT,FOLLOW_24); 

                    						newLeafNode(lv_comparison_int_12_0, grammarAccess.getLoopAccess().getComparison_intINTTerminalRuleCall_9_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLoopRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"comparison_int",
                    							lv_comparison_int_12_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_13=(Token)match(input,Then,FOLLOW_7); 

            			newLeafNode(otherlv_13, grammarAccess.getLoopAccess().getThenKeyword_10());
            		
            this_BEGIN_14=(Token)match(input,RULE_BEGIN,FOLLOW_25); 

            			newLeafNode(this_BEGIN_14, grammarAccess.getLoopAccess().getBEGINTerminalRuleCall_11());
            		
            // InternalFactoryLogicLangParser.g:1072:3: ( (lv_logics_15_0= ruleLogic ) )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==For||LA16_0==If||LA16_0==RULE_ID) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalFactoryLogicLangParser.g:1073:4: (lv_logics_15_0= ruleLogic )
            	    {
            	    // InternalFactoryLogicLangParser.g:1073:4: (lv_logics_15_0= ruleLogic )
            	    // InternalFactoryLogicLangParser.g:1074:5: lv_logics_15_0= ruleLogic
            	    {

            	    					newCompositeNode(grammarAccess.getLoopAccess().getLogicsLogicParserRuleCall_12_0());
            	    				
            	    pushFollow(FOLLOW_25);
            	    lv_logics_15_0=ruleLogic();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getLoopRule());
            	    					}
            	    					add(
            	    						current,
            	    						"logics",
            	    						lv_logics_15_0,
            	    						"xtext.FactoryLogicLang.Logic");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);

            this_END_16=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_16, grammarAccess.getLoopAccess().getENDTerminalRuleCall_13());
            		

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
    // InternalFactoryLogicLangParser.g:1099:1: entryRuleOperation returns [EObject current=null] : iv_ruleOperation= ruleOperation EOF ;
    public final EObject entryRuleOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation = null;


        try {
            // InternalFactoryLogicLangParser.g:1099:50: (iv_ruleOperation= ruleOperation EOF )
            // InternalFactoryLogicLangParser.g:1100:2: iv_ruleOperation= ruleOperation EOF
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
    // InternalFactoryLogicLangParser.g:1106:1: ruleOperation returns [EObject current=null] : (this_StorageMoveEmptySlot_0= ruleStorageMoveEmptySlot | this_StorageMoveSlot_1= ruleStorageMoveSlot | this_StorageMarkSlot_2= ruleStorageMarkSlot | this_CameraScan_3= ruleCameraScan | this_CranePickup_4= ruleCranePickup | this_CraneDrop_5= ruleCraneDrop ) ;
    public final EObject ruleOperation() throws RecognitionException {
        EObject current = null;

        EObject this_StorageMoveEmptySlot_0 = null;

        EObject this_StorageMoveSlot_1 = null;

        EObject this_StorageMarkSlot_2 = null;

        EObject this_CameraScan_3 = null;

        EObject this_CranePickup_4 = null;

        EObject this_CraneDrop_5 = null;



        	enterRule();

        try {
            // InternalFactoryLogicLangParser.g:1112:2: ( (this_StorageMoveEmptySlot_0= ruleStorageMoveEmptySlot | this_StorageMoveSlot_1= ruleStorageMoveSlot | this_StorageMarkSlot_2= ruleStorageMarkSlot | this_CameraScan_3= ruleCameraScan | this_CranePickup_4= ruleCranePickup | this_CraneDrop_5= ruleCraneDrop ) )
            // InternalFactoryLogicLangParser.g:1113:2: (this_StorageMoveEmptySlot_0= ruleStorageMoveEmptySlot | this_StorageMoveSlot_1= ruleStorageMoveSlot | this_StorageMarkSlot_2= ruleStorageMarkSlot | this_CameraScan_3= ruleCameraScan | this_CranePickup_4= ruleCranePickup | this_CraneDrop_5= ruleCraneDrop )
            {
            // InternalFactoryLogicLangParser.g:1113:2: (this_StorageMoveEmptySlot_0= ruleStorageMoveEmptySlot | this_StorageMoveSlot_1= ruleStorageMoveSlot | this_StorageMarkSlot_2= ruleStorageMarkSlot | this_CameraScan_3= ruleCameraScan | this_CranePickup_4= ruleCranePickup | this_CraneDrop_5= ruleCraneDrop )
            int alt17=6;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                switch ( input.LA(2) ) {
                case Move:
                    {
                    int LA17_2 = input.LA(3);

                    if ( (LA17_2==Empty) ) {
                        alt17=1;
                    }
                    else if ( (LA17_2==Slot) ) {
                        alt17=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 2, input);

                        throw nvae;
                    }
                    }
                    break;
                case Drop:
                    {
                    alt17=6;
                    }
                    break;
                case Pickup:
                    {
                    alt17=5;
                    }
                    break;
                case Scan:
                    {
                    alt17=4;
                    }
                    break;
                case Mark:
                    {
                    alt17=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalFactoryLogicLangParser.g:1114:3: this_StorageMoveEmptySlot_0= ruleStorageMoveEmptySlot
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
                    // InternalFactoryLogicLangParser.g:1123:3: this_StorageMoveSlot_1= ruleStorageMoveSlot
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
                    // InternalFactoryLogicLangParser.g:1132:3: this_StorageMarkSlot_2= ruleStorageMarkSlot
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
                    // InternalFactoryLogicLangParser.g:1141:3: this_CameraScan_3= ruleCameraScan
                    {

                    			newCompositeNode(grammarAccess.getOperationAccess().getCameraScanParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_CameraScan_3=ruleCameraScan();

                    state._fsp--;


                    			current = this_CameraScan_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalFactoryLogicLangParser.g:1150:3: this_CranePickup_4= ruleCranePickup
                    {

                    			newCompositeNode(grammarAccess.getOperationAccess().getCranePickupParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_CranePickup_4=ruleCranePickup();

                    state._fsp--;


                    			current = this_CranePickup_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalFactoryLogicLangParser.g:1159:3: this_CraneDrop_5= ruleCraneDrop
                    {

                    			newCompositeNode(grammarAccess.getOperationAccess().getCraneDropParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_CraneDrop_5=ruleCraneDrop();

                    state._fsp--;


                    			current = this_CraneDrop_5;
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
    // InternalFactoryLogicLangParser.g:1171:1: entryRuleStorageMoveEmptySlot returns [EObject current=null] : iv_ruleStorageMoveEmptySlot= ruleStorageMoveEmptySlot EOF ;
    public final EObject entryRuleStorageMoveEmptySlot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStorageMoveEmptySlot = null;


        try {
            // InternalFactoryLogicLangParser.g:1171:61: (iv_ruleStorageMoveEmptySlot= ruleStorageMoveEmptySlot EOF )
            // InternalFactoryLogicLangParser.g:1172:2: iv_ruleStorageMoveEmptySlot= ruleStorageMoveEmptySlot EOF
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
    // InternalFactoryLogicLangParser.g:1178:1: ruleStorageMoveEmptySlot returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= Move otherlv_2= Empty otherlv_3= Slot otherlv_4= To ( (otherlv_5= RULE_ID ) ) ) ;
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
            // InternalFactoryLogicLangParser.g:1184:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= Move otherlv_2= Empty otherlv_3= Slot otherlv_4= To ( (otherlv_5= RULE_ID ) ) ) )
            // InternalFactoryLogicLangParser.g:1185:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= Move otherlv_2= Empty otherlv_3= Slot otherlv_4= To ( (otherlv_5= RULE_ID ) ) )
            {
            // InternalFactoryLogicLangParser.g:1185:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= Move otherlv_2= Empty otherlv_3= Slot otherlv_4= To ( (otherlv_5= RULE_ID ) ) )
            // InternalFactoryLogicLangParser.g:1186:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= Move otherlv_2= Empty otherlv_3= Slot otherlv_4= To ( (otherlv_5= RULE_ID ) )
            {
            // InternalFactoryLogicLangParser.g:1186:3: ( (otherlv_0= RULE_ID ) )
            // InternalFactoryLogicLangParser.g:1187:4: (otherlv_0= RULE_ID )
            {
            // InternalFactoryLogicLangParser.g:1187:4: (otherlv_0= RULE_ID )
            // InternalFactoryLogicLangParser.g:1188:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStorageMoveEmptySlotRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_30); 

            					newLeafNode(otherlv_0, grammarAccess.getStorageMoveEmptySlotAccess().getDeviceStorageCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,Move,FOLLOW_31); 

            			newLeafNode(otherlv_1, grammarAccess.getStorageMoveEmptySlotAccess().getMoveKeyword_1());
            		
            otherlv_2=(Token)match(input,Empty,FOLLOW_15); 

            			newLeafNode(otherlv_2, grammarAccess.getStorageMoveEmptySlotAccess().getEmptyKeyword_2());
            		
            otherlv_3=(Token)match(input,Slot,FOLLOW_32); 

            			newLeafNode(otherlv_3, grammarAccess.getStorageMoveEmptySlotAccess().getSlotKeyword_3());
            		
            otherlv_4=(Token)match(input,To,FOLLOW_19); 

            			newLeafNode(otherlv_4, grammarAccess.getStorageMoveEmptySlotAccess().getToKeyword_4());
            		
            // InternalFactoryLogicLangParser.g:1215:3: ( (otherlv_5= RULE_ID ) )
            // InternalFactoryLogicLangParser.g:1216:4: (otherlv_5= RULE_ID )
            {
            // InternalFactoryLogicLangParser.g:1216:4: (otherlv_5= RULE_ID )
            // InternalFactoryLogicLangParser.g:1217:5: otherlv_5= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStorageMoveEmptySlotRule());
            					}
            				
            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_2); 

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


    // $ANTLR start "entryRuleStorageMoveSlot"
    // InternalFactoryLogicLangParser.g:1232:1: entryRuleStorageMoveSlot returns [EObject current=null] : iv_ruleStorageMoveSlot= ruleStorageMoveSlot EOF ;
    public final EObject entryRuleStorageMoveSlot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStorageMoveSlot = null;


        try {
            // InternalFactoryLogicLangParser.g:1232:56: (iv_ruleStorageMoveSlot= ruleStorageMoveSlot EOF )
            // InternalFactoryLogicLangParser.g:1233:2: iv_ruleStorageMoveSlot= ruleStorageMoveSlot EOF
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
    // InternalFactoryLogicLangParser.g:1239:1: ruleStorageMoveSlot returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= Move otherlv_2= Slot otherlv_3= At ( (otherlv_4= RULE_ID ) ) otherlv_5= To ( (otherlv_6= RULE_ID ) ) ) ;
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
            // InternalFactoryLogicLangParser.g:1245:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= Move otherlv_2= Slot otherlv_3= At ( (otherlv_4= RULE_ID ) ) otherlv_5= To ( (otherlv_6= RULE_ID ) ) ) )
            // InternalFactoryLogicLangParser.g:1246:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= Move otherlv_2= Slot otherlv_3= At ( (otherlv_4= RULE_ID ) ) otherlv_5= To ( (otherlv_6= RULE_ID ) ) )
            {
            // InternalFactoryLogicLangParser.g:1246:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= Move otherlv_2= Slot otherlv_3= At ( (otherlv_4= RULE_ID ) ) otherlv_5= To ( (otherlv_6= RULE_ID ) ) )
            // InternalFactoryLogicLangParser.g:1247:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= Move otherlv_2= Slot otherlv_3= At ( (otherlv_4= RULE_ID ) ) otherlv_5= To ( (otherlv_6= RULE_ID ) )
            {
            // InternalFactoryLogicLangParser.g:1247:3: ( (otherlv_0= RULE_ID ) )
            // InternalFactoryLogicLangParser.g:1248:4: (otherlv_0= RULE_ID )
            {
            // InternalFactoryLogicLangParser.g:1248:4: (otherlv_0= RULE_ID )
            // InternalFactoryLogicLangParser.g:1249:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStorageMoveSlotRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_30); 

            					newLeafNode(otherlv_0, grammarAccess.getStorageMoveSlotAccess().getDeviceStorageCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,Move,FOLLOW_15); 

            			newLeafNode(otherlv_1, grammarAccess.getStorageMoveSlotAccess().getMoveKeyword_1());
            		
            otherlv_2=(Token)match(input,Slot,FOLLOW_11); 

            			newLeafNode(otherlv_2, grammarAccess.getStorageMoveSlotAccess().getSlotKeyword_2());
            		
            otherlv_3=(Token)match(input,At,FOLLOW_19); 

            			newLeafNode(otherlv_3, grammarAccess.getStorageMoveSlotAccess().getAtKeyword_3());
            		
            // InternalFactoryLogicLangParser.g:1272:3: ( (otherlv_4= RULE_ID ) )
            // InternalFactoryLogicLangParser.g:1273:4: (otherlv_4= RULE_ID )
            {
            // InternalFactoryLogicLangParser.g:1273:4: (otherlv_4= RULE_ID )
            // InternalFactoryLogicLangParser.g:1274:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStorageMoveSlotRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_32); 

            					newLeafNode(otherlv_4, grammarAccess.getStorageMoveSlotAccess().getPositionStoragePositionParameterCrossReference_4_0());
            				

            }


            }

            otherlv_5=(Token)match(input,To,FOLLOW_19); 

            			newLeafNode(otherlv_5, grammarAccess.getStorageMoveSlotAccess().getToKeyword_5());
            		
            // InternalFactoryLogicLangParser.g:1289:3: ( (otherlv_6= RULE_ID ) )
            // InternalFactoryLogicLangParser.g:1290:4: (otherlv_6= RULE_ID )
            {
            // InternalFactoryLogicLangParser.g:1290:4: (otherlv_6= RULE_ID )
            // InternalFactoryLogicLangParser.g:1291:5: otherlv_6= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStorageMoveSlotRule());
            					}
            				
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_2); 

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
    // InternalFactoryLogicLangParser.g:1306:1: entryRuleStorageMarkSlot returns [EObject current=null] : iv_ruleStorageMarkSlot= ruleStorageMarkSlot EOF ;
    public final EObject entryRuleStorageMarkSlot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStorageMarkSlot = null;


        try {
            // InternalFactoryLogicLangParser.g:1306:56: (iv_ruleStorageMarkSlot= ruleStorageMarkSlot EOF )
            // InternalFactoryLogicLangParser.g:1307:2: iv_ruleStorageMarkSlot= ruleStorageMarkSlot EOF
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
    // InternalFactoryLogicLangParser.g:1313:1: ruleStorageMarkSlot returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= Mark otherlv_2= Slot otherlv_3= At ( (otherlv_4= RULE_ID ) ) otherlv_5= As ( ( (lv_comparison_const_6_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_7_0= ruleCOLOR ) ) | ( (lv_comparison_int_8_0= RULE_INT ) ) ) (otherlv_9= In ( (lv_quantity_10_0= RULE_INT ) ) ( (lv_measure_11_0= ruleTIME ) ) )? ) ;
    public final EObject ruleStorageMarkSlot() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_comparison_int_8_0=null;
        Token otherlv_9=null;
        Token lv_quantity_10_0=null;
        Enumerator lv_comparison_const_6_0 = null;

        Enumerator lv_comparison_color_7_0 = null;

        Enumerator lv_measure_11_0 = null;



        	enterRule();

        try {
            // InternalFactoryLogicLangParser.g:1319:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= Mark otherlv_2= Slot otherlv_3= At ( (otherlv_4= RULE_ID ) ) otherlv_5= As ( ( (lv_comparison_const_6_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_7_0= ruleCOLOR ) ) | ( (lv_comparison_int_8_0= RULE_INT ) ) ) (otherlv_9= In ( (lv_quantity_10_0= RULE_INT ) ) ( (lv_measure_11_0= ruleTIME ) ) )? ) )
            // InternalFactoryLogicLangParser.g:1320:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= Mark otherlv_2= Slot otherlv_3= At ( (otherlv_4= RULE_ID ) ) otherlv_5= As ( ( (lv_comparison_const_6_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_7_0= ruleCOLOR ) ) | ( (lv_comparison_int_8_0= RULE_INT ) ) ) (otherlv_9= In ( (lv_quantity_10_0= RULE_INT ) ) ( (lv_measure_11_0= ruleTIME ) ) )? )
            {
            // InternalFactoryLogicLangParser.g:1320:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= Mark otherlv_2= Slot otherlv_3= At ( (otherlv_4= RULE_ID ) ) otherlv_5= As ( ( (lv_comparison_const_6_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_7_0= ruleCOLOR ) ) | ( (lv_comparison_int_8_0= RULE_INT ) ) ) (otherlv_9= In ( (lv_quantity_10_0= RULE_INT ) ) ( (lv_measure_11_0= ruleTIME ) ) )? )
            // InternalFactoryLogicLangParser.g:1321:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= Mark otherlv_2= Slot otherlv_3= At ( (otherlv_4= RULE_ID ) ) otherlv_5= As ( ( (lv_comparison_const_6_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_7_0= ruleCOLOR ) ) | ( (lv_comparison_int_8_0= RULE_INT ) ) ) (otherlv_9= In ( (lv_quantity_10_0= RULE_INT ) ) ( (lv_measure_11_0= ruleTIME ) ) )?
            {
            // InternalFactoryLogicLangParser.g:1321:3: ( (otherlv_0= RULE_ID ) )
            // InternalFactoryLogicLangParser.g:1322:4: (otherlv_0= RULE_ID )
            {
            // InternalFactoryLogicLangParser.g:1322:4: (otherlv_0= RULE_ID )
            // InternalFactoryLogicLangParser.g:1323:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStorageMarkSlotRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_33); 

            					newLeafNode(otherlv_0, grammarAccess.getStorageMarkSlotAccess().getDeviceStorageCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,Mark,FOLLOW_15); 

            			newLeafNode(otherlv_1, grammarAccess.getStorageMarkSlotAccess().getMarkKeyword_1());
            		
            otherlv_2=(Token)match(input,Slot,FOLLOW_11); 

            			newLeafNode(otherlv_2, grammarAccess.getStorageMarkSlotAccess().getSlotKeyword_2());
            		
            otherlv_3=(Token)match(input,At,FOLLOW_19); 

            			newLeafNode(otherlv_3, grammarAccess.getStorageMarkSlotAccess().getAtKeyword_3());
            		
            // InternalFactoryLogicLangParser.g:1346:3: ( (otherlv_4= RULE_ID ) )
            // InternalFactoryLogicLangParser.g:1347:4: (otherlv_4= RULE_ID )
            {
            // InternalFactoryLogicLangParser.g:1347:4: (otherlv_4= RULE_ID )
            // InternalFactoryLogicLangParser.g:1348:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStorageMarkSlotRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_34); 

            					newLeafNode(otherlv_4, grammarAccess.getStorageMarkSlotAccess().getPositionStoragePositionParameterCrossReference_4_0());
            				

            }


            }

            otherlv_5=(Token)match(input,As,FOLLOW_23); 

            			newLeafNode(otherlv_5, grammarAccess.getStorageMarkSlotAccess().getAsKeyword_5());
            		
            // InternalFactoryLogicLangParser.g:1363:3: ( ( (lv_comparison_const_6_0= ruleCONST_VARIABLES ) ) | ( (lv_comparison_color_7_0= ruleCOLOR ) ) | ( (lv_comparison_int_8_0= RULE_INT ) ) )
            int alt18=3;
            switch ( input.LA(1) ) {
            case Finished:
            case Empty:
            case Full:
                {
                alt18=1;
                }
                break;
            case Green:
            case Blue:
            case Red:
                {
                alt18=2;
                }
                break;
            case RULE_INT:
                {
                alt18=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalFactoryLogicLangParser.g:1364:4: ( (lv_comparison_const_6_0= ruleCONST_VARIABLES ) )
                    {
                    // InternalFactoryLogicLangParser.g:1364:4: ( (lv_comparison_const_6_0= ruleCONST_VARIABLES ) )
                    // InternalFactoryLogicLangParser.g:1365:5: (lv_comparison_const_6_0= ruleCONST_VARIABLES )
                    {
                    // InternalFactoryLogicLangParser.g:1365:5: (lv_comparison_const_6_0= ruleCONST_VARIABLES )
                    // InternalFactoryLogicLangParser.g:1366:6: lv_comparison_const_6_0= ruleCONST_VARIABLES
                    {

                    						newCompositeNode(grammarAccess.getStorageMarkSlotAccess().getComparison_constCONST_VARIABLESEnumRuleCall_6_0_0());
                    					
                    pushFollow(FOLLOW_35);
                    lv_comparison_const_6_0=ruleCONST_VARIABLES();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStorageMarkSlotRule());
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
                    // InternalFactoryLogicLangParser.g:1384:4: ( (lv_comparison_color_7_0= ruleCOLOR ) )
                    {
                    // InternalFactoryLogicLangParser.g:1384:4: ( (lv_comparison_color_7_0= ruleCOLOR ) )
                    // InternalFactoryLogicLangParser.g:1385:5: (lv_comparison_color_7_0= ruleCOLOR )
                    {
                    // InternalFactoryLogicLangParser.g:1385:5: (lv_comparison_color_7_0= ruleCOLOR )
                    // InternalFactoryLogicLangParser.g:1386:6: lv_comparison_color_7_0= ruleCOLOR
                    {

                    						newCompositeNode(grammarAccess.getStorageMarkSlotAccess().getComparison_colorCOLOREnumRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_35);
                    lv_comparison_color_7_0=ruleCOLOR();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStorageMarkSlotRule());
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
                    // InternalFactoryLogicLangParser.g:1404:4: ( (lv_comparison_int_8_0= RULE_INT ) )
                    {
                    // InternalFactoryLogicLangParser.g:1404:4: ( (lv_comparison_int_8_0= RULE_INT ) )
                    // InternalFactoryLogicLangParser.g:1405:5: (lv_comparison_int_8_0= RULE_INT )
                    {
                    // InternalFactoryLogicLangParser.g:1405:5: (lv_comparison_int_8_0= RULE_INT )
                    // InternalFactoryLogicLangParser.g:1406:6: lv_comparison_int_8_0= RULE_INT
                    {
                    lv_comparison_int_8_0=(Token)match(input,RULE_INT,FOLLOW_35); 

                    						newLeafNode(lv_comparison_int_8_0, grammarAccess.getStorageMarkSlotAccess().getComparison_intINTTerminalRuleCall_6_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStorageMarkSlotRule());
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

            // InternalFactoryLogicLangParser.g:1423:3: (otherlv_9= In ( (lv_quantity_10_0= RULE_INT ) ) ( (lv_measure_11_0= ruleTIME ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==In) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalFactoryLogicLangParser.g:1424:4: otherlv_9= In ( (lv_quantity_10_0= RULE_INT ) ) ( (lv_measure_11_0= ruleTIME ) )
                    {
                    otherlv_9=(Token)match(input,In,FOLLOW_12); 

                    				newLeafNode(otherlv_9, grammarAccess.getStorageMarkSlotAccess().getInKeyword_7_0());
                    			
                    // InternalFactoryLogicLangParser.g:1428:4: ( (lv_quantity_10_0= RULE_INT ) )
                    // InternalFactoryLogicLangParser.g:1429:5: (lv_quantity_10_0= RULE_INT )
                    {
                    // InternalFactoryLogicLangParser.g:1429:5: (lv_quantity_10_0= RULE_INT )
                    // InternalFactoryLogicLangParser.g:1430:6: lv_quantity_10_0= RULE_INT
                    {
                    lv_quantity_10_0=(Token)match(input,RULE_INT,FOLLOW_36); 

                    						newLeafNode(lv_quantity_10_0, grammarAccess.getStorageMarkSlotAccess().getQuantityINTTerminalRuleCall_7_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStorageMarkSlotRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"quantity",
                    							lv_quantity_10_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }

                    // InternalFactoryLogicLangParser.g:1446:4: ( (lv_measure_11_0= ruleTIME ) )
                    // InternalFactoryLogicLangParser.g:1447:5: (lv_measure_11_0= ruleTIME )
                    {
                    // InternalFactoryLogicLangParser.g:1447:5: (lv_measure_11_0= ruleTIME )
                    // InternalFactoryLogicLangParser.g:1448:6: lv_measure_11_0= ruleTIME
                    {

                    						newCompositeNode(grammarAccess.getStorageMarkSlotAccess().getMeasureTIMEEnumRuleCall_7_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_measure_11_0=ruleTIME();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStorageMarkSlotRule());
                    						}
                    						set(
                    							current,
                    							"measure",
                    							lv_measure_11_0,
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
    // InternalFactoryLogicLangParser.g:1470:1: entryRuleCameraScan returns [EObject current=null] : iv_ruleCameraScan= ruleCameraScan EOF ;
    public final EObject entryRuleCameraScan() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCameraScan = null;


        try {
            // InternalFactoryLogicLangParser.g:1470:51: (iv_ruleCameraScan= ruleCameraScan EOF )
            // InternalFactoryLogicLangParser.g:1471:2: iv_ruleCameraScan= ruleCameraScan EOF
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
    // InternalFactoryLogicLangParser.g:1477:1: ruleCameraScan returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= Scan otherlv_2= Color otherlv_3= Into ( (lv_name_4_0= RULE_ID ) ) ) ;
    public final EObject ruleCameraScan() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_name_4_0=null;


        	enterRule();

        try {
            // InternalFactoryLogicLangParser.g:1483:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= Scan otherlv_2= Color otherlv_3= Into ( (lv_name_4_0= RULE_ID ) ) ) )
            // InternalFactoryLogicLangParser.g:1484:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= Scan otherlv_2= Color otherlv_3= Into ( (lv_name_4_0= RULE_ID ) ) )
            {
            // InternalFactoryLogicLangParser.g:1484:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= Scan otherlv_2= Color otherlv_3= Into ( (lv_name_4_0= RULE_ID ) ) )
            // InternalFactoryLogicLangParser.g:1485:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= Scan otherlv_2= Color otherlv_3= Into ( (lv_name_4_0= RULE_ID ) )
            {
            // InternalFactoryLogicLangParser.g:1485:3: ( (otherlv_0= RULE_ID ) )
            // InternalFactoryLogicLangParser.g:1486:4: (otherlv_0= RULE_ID )
            {
            // InternalFactoryLogicLangParser.g:1486:4: (otherlv_0= RULE_ID )
            // InternalFactoryLogicLangParser.g:1487:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCameraScanRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_37); 

            					newLeafNode(otherlv_0, grammarAccess.getCameraScanAccess().getDeviceCameraCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,Scan,FOLLOW_17); 

            			newLeafNode(otherlv_1, grammarAccess.getCameraScanAccess().getScanKeyword_1());
            		
            otherlv_2=(Token)match(input,Color,FOLLOW_38); 

            			newLeafNode(otherlv_2, grammarAccess.getCameraScanAccess().getColorKeyword_2());
            		
            otherlv_3=(Token)match(input,Into,FOLLOW_19); 

            			newLeafNode(otherlv_3, grammarAccess.getCameraScanAccess().getIntoKeyword_3());
            		
            // InternalFactoryLogicLangParser.g:1510:3: ( (lv_name_4_0= RULE_ID ) )
            // InternalFactoryLogicLangParser.g:1511:4: (lv_name_4_0= RULE_ID )
            {
            // InternalFactoryLogicLangParser.g:1511:4: (lv_name_4_0= RULE_ID )
            // InternalFactoryLogicLangParser.g:1512:5: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_4_0, grammarAccess.getCameraScanAccess().getNameIDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCameraScanRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_4_0,
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
    // $ANTLR end "ruleCameraScan"


    // $ANTLR start "entryRuleCranePickup"
    // InternalFactoryLogicLangParser.g:1532:1: entryRuleCranePickup returns [EObject current=null] : iv_ruleCranePickup= ruleCranePickup EOF ;
    public final EObject entryRuleCranePickup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCranePickup = null;


        try {
            // InternalFactoryLogicLangParser.g:1532:52: (iv_ruleCranePickup= ruleCranePickup EOF )
            // InternalFactoryLogicLangParser.g:1533:2: iv_ruleCranePickup= ruleCranePickup EOF
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
    // InternalFactoryLogicLangParser.g:1539:1: ruleCranePickup returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= Pickup otherlv_2= Item otherlv_3= At ( (otherlv_4= RULE_ID ) ) ) ;
    public final EObject ruleCranePickup() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalFactoryLogicLangParser.g:1545:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= Pickup otherlv_2= Item otherlv_3= At ( (otherlv_4= RULE_ID ) ) ) )
            // InternalFactoryLogicLangParser.g:1546:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= Pickup otherlv_2= Item otherlv_3= At ( (otherlv_4= RULE_ID ) ) )
            {
            // InternalFactoryLogicLangParser.g:1546:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= Pickup otherlv_2= Item otherlv_3= At ( (otherlv_4= RULE_ID ) ) )
            // InternalFactoryLogicLangParser.g:1547:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= Pickup otherlv_2= Item otherlv_3= At ( (otherlv_4= RULE_ID ) )
            {
            // InternalFactoryLogicLangParser.g:1547:3: ( (otherlv_0= RULE_ID ) )
            // InternalFactoryLogicLangParser.g:1548:4: (otherlv_0= RULE_ID )
            {
            // InternalFactoryLogicLangParser.g:1548:4: (otherlv_0= RULE_ID )
            // InternalFactoryLogicLangParser.g:1549:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCranePickupRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_39); 

            					newLeafNode(otherlv_0, grammarAccess.getCranePickupAccess().getDeviceCraneCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,Pickup,FOLLOW_40); 

            			newLeafNode(otherlv_1, grammarAccess.getCranePickupAccess().getPickupKeyword_1());
            		
            otherlv_2=(Token)match(input,Item,FOLLOW_11); 

            			newLeafNode(otherlv_2, grammarAccess.getCranePickupAccess().getItemKeyword_2());
            		
            otherlv_3=(Token)match(input,At,FOLLOW_19); 

            			newLeafNode(otherlv_3, grammarAccess.getCranePickupAccess().getAtKeyword_3());
            		
            // InternalFactoryLogicLangParser.g:1572:3: ( (otherlv_4= RULE_ID ) )
            // InternalFactoryLogicLangParser.g:1573:4: (otherlv_4= RULE_ID )
            {
            // InternalFactoryLogicLangParser.g:1573:4: (otherlv_4= RULE_ID )
            // InternalFactoryLogicLangParser.g:1574:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCranePickupRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_2); 

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
    // InternalFactoryLogicLangParser.g:1589:1: entryRuleCraneDrop returns [EObject current=null] : iv_ruleCraneDrop= ruleCraneDrop EOF ;
    public final EObject entryRuleCraneDrop() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCraneDrop = null;


        try {
            // InternalFactoryLogicLangParser.g:1589:50: (iv_ruleCraneDrop= ruleCraneDrop EOF )
            // InternalFactoryLogicLangParser.g:1590:2: iv_ruleCraneDrop= ruleCraneDrop EOF
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
    // InternalFactoryLogicLangParser.g:1596:1: ruleCraneDrop returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= Drop otherlv_2= Item otherlv_3= At ( (otherlv_4= RULE_ID ) ) ) ;
    public final EObject ruleCraneDrop() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalFactoryLogicLangParser.g:1602:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= Drop otherlv_2= Item otherlv_3= At ( (otherlv_4= RULE_ID ) ) ) )
            // InternalFactoryLogicLangParser.g:1603:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= Drop otherlv_2= Item otherlv_3= At ( (otherlv_4= RULE_ID ) ) )
            {
            // InternalFactoryLogicLangParser.g:1603:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= Drop otherlv_2= Item otherlv_3= At ( (otherlv_4= RULE_ID ) ) )
            // InternalFactoryLogicLangParser.g:1604:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= Drop otherlv_2= Item otherlv_3= At ( (otherlv_4= RULE_ID ) )
            {
            // InternalFactoryLogicLangParser.g:1604:3: ( (otherlv_0= RULE_ID ) )
            // InternalFactoryLogicLangParser.g:1605:4: (otherlv_0= RULE_ID )
            {
            // InternalFactoryLogicLangParser.g:1605:4: (otherlv_0= RULE_ID )
            // InternalFactoryLogicLangParser.g:1606:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCraneDropRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_41); 

            					newLeafNode(otherlv_0, grammarAccess.getCraneDropAccess().getDeviceCraneCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,Drop,FOLLOW_40); 

            			newLeafNode(otherlv_1, grammarAccess.getCraneDropAccess().getDropKeyword_1());
            		
            otherlv_2=(Token)match(input,Item,FOLLOW_11); 

            			newLeafNode(otherlv_2, grammarAccess.getCraneDropAccess().getItemKeyword_2());
            		
            otherlv_3=(Token)match(input,At,FOLLOW_19); 

            			newLeafNode(otherlv_3, grammarAccess.getCraneDropAccess().getAtKeyword_3());
            		
            // InternalFactoryLogicLangParser.g:1629:3: ( (otherlv_4= RULE_ID ) )
            // InternalFactoryLogicLangParser.g:1630:4: (otherlv_4= RULE_ID )
            {
            // InternalFactoryLogicLangParser.g:1630:4: (otherlv_4= RULE_ID )
            // InternalFactoryLogicLangParser.g:1631:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCraneDropRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_2); 

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
    // InternalFactoryLogicLangParser.g:1646:1: ruleCOLOR returns [Enumerator current=null] : ( (enumLiteral_0= Red ) | (enumLiteral_1= Blue ) | (enumLiteral_2= Green ) ) ;
    public final Enumerator ruleCOLOR() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalFactoryLogicLangParser.g:1652:2: ( ( (enumLiteral_0= Red ) | (enumLiteral_1= Blue ) | (enumLiteral_2= Green ) ) )
            // InternalFactoryLogicLangParser.g:1653:2: ( (enumLiteral_0= Red ) | (enumLiteral_1= Blue ) | (enumLiteral_2= Green ) )
            {
            // InternalFactoryLogicLangParser.g:1653:2: ( (enumLiteral_0= Red ) | (enumLiteral_1= Blue ) | (enumLiteral_2= Green ) )
            int alt20=3;
            switch ( input.LA(1) ) {
            case Red:
                {
                alt20=1;
                }
                break;
            case Blue:
                {
                alt20=2;
                }
                break;
            case Green:
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
                    // InternalFactoryLogicLangParser.g:1654:3: (enumLiteral_0= Red )
                    {
                    // InternalFactoryLogicLangParser.g:1654:3: (enumLiteral_0= Red )
                    // InternalFactoryLogicLangParser.g:1655:4: enumLiteral_0= Red
                    {
                    enumLiteral_0=(Token)match(input,Red,FOLLOW_2); 

                    				current = grammarAccess.getCOLORAccess().getREDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCOLORAccess().getREDEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalFactoryLogicLangParser.g:1662:3: (enumLiteral_1= Blue )
                    {
                    // InternalFactoryLogicLangParser.g:1662:3: (enumLiteral_1= Blue )
                    // InternalFactoryLogicLangParser.g:1663:4: enumLiteral_1= Blue
                    {
                    enumLiteral_1=(Token)match(input,Blue,FOLLOW_2); 

                    				current = grammarAccess.getCOLORAccess().getBLUEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getCOLORAccess().getBLUEEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalFactoryLogicLangParser.g:1670:3: (enumLiteral_2= Green )
                    {
                    // InternalFactoryLogicLangParser.g:1670:3: (enumLiteral_2= Green )
                    // InternalFactoryLogicLangParser.g:1671:4: enumLiteral_2= Green
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
    // InternalFactoryLogicLangParser.g:1681:1: ruleCONST_VARIABLES returns [Enumerator current=null] : ( (enumLiteral_0= Full ) | (enumLiteral_1= Finished ) | (enumLiteral_2= Empty ) ) ;
    public final Enumerator ruleCONST_VARIABLES() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalFactoryLogicLangParser.g:1687:2: ( ( (enumLiteral_0= Full ) | (enumLiteral_1= Finished ) | (enumLiteral_2= Empty ) ) )
            // InternalFactoryLogicLangParser.g:1688:2: ( (enumLiteral_0= Full ) | (enumLiteral_1= Finished ) | (enumLiteral_2= Empty ) )
            {
            // InternalFactoryLogicLangParser.g:1688:2: ( (enumLiteral_0= Full ) | (enumLiteral_1= Finished ) | (enumLiteral_2= Empty ) )
            int alt21=3;
            switch ( input.LA(1) ) {
            case Full:
                {
                alt21=1;
                }
                break;
            case Finished:
                {
                alt21=2;
                }
                break;
            case Empty:
                {
                alt21=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // InternalFactoryLogicLangParser.g:1689:3: (enumLiteral_0= Full )
                    {
                    // InternalFactoryLogicLangParser.g:1689:3: (enumLiteral_0= Full )
                    // InternalFactoryLogicLangParser.g:1690:4: enumLiteral_0= Full
                    {
                    enumLiteral_0=(Token)match(input,Full,FOLLOW_2); 

                    				current = grammarAccess.getCONST_VARIABLESAccess().getFULLEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCONST_VARIABLESAccess().getFULLEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalFactoryLogicLangParser.g:1697:3: (enumLiteral_1= Finished )
                    {
                    // InternalFactoryLogicLangParser.g:1697:3: (enumLiteral_1= Finished )
                    // InternalFactoryLogicLangParser.g:1698:4: enumLiteral_1= Finished
                    {
                    enumLiteral_1=(Token)match(input,Finished,FOLLOW_2); 

                    				current = grammarAccess.getCONST_VARIABLESAccess().getFINISHEDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getCONST_VARIABLESAccess().getFINISHEDEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalFactoryLogicLangParser.g:1705:3: (enumLiteral_2= Empty )
                    {
                    // InternalFactoryLogicLangParser.g:1705:3: (enumLiteral_2= Empty )
                    // InternalFactoryLogicLangParser.g:1706:4: enumLiteral_2= Empty
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
    // InternalFactoryLogicLangParser.g:1716:1: ruleBOOLEAN_OPERATOR returns [Enumerator current=null] : ( (enumLiteral_0= Not ) | (enumLiteral_1= LessThan ) | (enumLiteral_2= GreaterThan ) ) ;
    public final Enumerator ruleBOOLEAN_OPERATOR() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalFactoryLogicLangParser.g:1722:2: ( ( (enumLiteral_0= Not ) | (enumLiteral_1= LessThan ) | (enumLiteral_2= GreaterThan ) ) )
            // InternalFactoryLogicLangParser.g:1723:2: ( (enumLiteral_0= Not ) | (enumLiteral_1= LessThan ) | (enumLiteral_2= GreaterThan ) )
            {
            // InternalFactoryLogicLangParser.g:1723:2: ( (enumLiteral_0= Not ) | (enumLiteral_1= LessThan ) | (enumLiteral_2= GreaterThan ) )
            int alt22=3;
            switch ( input.LA(1) ) {
            case Not:
                {
                alt22=1;
                }
                break;
            case LessThan:
                {
                alt22=2;
                }
                break;
            case GreaterThan:
                {
                alt22=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // InternalFactoryLogicLangParser.g:1724:3: (enumLiteral_0= Not )
                    {
                    // InternalFactoryLogicLangParser.g:1724:3: (enumLiteral_0= Not )
                    // InternalFactoryLogicLangParser.g:1725:4: enumLiteral_0= Not
                    {
                    enumLiteral_0=(Token)match(input,Not,FOLLOW_2); 

                    				current = grammarAccess.getBOOLEAN_OPERATORAccess().getNOTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getBOOLEAN_OPERATORAccess().getNOTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalFactoryLogicLangParser.g:1732:3: (enumLiteral_1= LessThan )
                    {
                    // InternalFactoryLogicLangParser.g:1732:3: (enumLiteral_1= LessThan )
                    // InternalFactoryLogicLangParser.g:1733:4: enumLiteral_1= LessThan
                    {
                    enumLiteral_1=(Token)match(input,LessThan,FOLLOW_2); 

                    				current = grammarAccess.getBOOLEAN_OPERATORAccess().getLESSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getBOOLEAN_OPERATORAccess().getLESSEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalFactoryLogicLangParser.g:1740:3: (enumLiteral_2= GreaterThan )
                    {
                    // InternalFactoryLogicLangParser.g:1740:3: (enumLiteral_2= GreaterThan )
                    // InternalFactoryLogicLangParser.g:1741:4: enumLiteral_2= GreaterThan
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
    // InternalFactoryLogicLangParser.g:1751:1: ruleTIME returns [Enumerator current=null] : ( (enumLiteral_0= Seconds ) | (enumLiteral_1= Second ) | (enumLiteral_2= Minutes ) | (enumLiteral_3= Minute ) | (enumLiteral_4= Hours ) | (enumLiteral_5= Hour ) ) ;
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
            // InternalFactoryLogicLangParser.g:1757:2: ( ( (enumLiteral_0= Seconds ) | (enumLiteral_1= Second ) | (enumLiteral_2= Minutes ) | (enumLiteral_3= Minute ) | (enumLiteral_4= Hours ) | (enumLiteral_5= Hour ) ) )
            // InternalFactoryLogicLangParser.g:1758:2: ( (enumLiteral_0= Seconds ) | (enumLiteral_1= Second ) | (enumLiteral_2= Minutes ) | (enumLiteral_3= Minute ) | (enumLiteral_4= Hours ) | (enumLiteral_5= Hour ) )
            {
            // InternalFactoryLogicLangParser.g:1758:2: ( (enumLiteral_0= Seconds ) | (enumLiteral_1= Second ) | (enumLiteral_2= Minutes ) | (enumLiteral_3= Minute ) | (enumLiteral_4= Hours ) | (enumLiteral_5= Hour ) )
            int alt23=6;
            switch ( input.LA(1) ) {
            case Seconds:
                {
                alt23=1;
                }
                break;
            case Second:
                {
                alt23=2;
                }
                break;
            case Minutes:
                {
                alt23=3;
                }
                break;
            case Minute:
                {
                alt23=4;
                }
                break;
            case Hours:
                {
                alt23=5;
                }
                break;
            case Hour:
                {
                alt23=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // InternalFactoryLogicLangParser.g:1759:3: (enumLiteral_0= Seconds )
                    {
                    // InternalFactoryLogicLangParser.g:1759:3: (enumLiteral_0= Seconds )
                    // InternalFactoryLogicLangParser.g:1760:4: enumLiteral_0= Seconds
                    {
                    enumLiteral_0=(Token)match(input,Seconds,FOLLOW_2); 

                    				current = grammarAccess.getTIMEAccess().getSECONDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getTIMEAccess().getSECONDEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalFactoryLogicLangParser.g:1767:3: (enumLiteral_1= Second )
                    {
                    // InternalFactoryLogicLangParser.g:1767:3: (enumLiteral_1= Second )
                    // InternalFactoryLogicLangParser.g:1768:4: enumLiteral_1= Second
                    {
                    enumLiteral_1=(Token)match(input,Second,FOLLOW_2); 

                    				current = grammarAccess.getTIMEAccess().getSECONDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getTIMEAccess().getSECONDEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalFactoryLogicLangParser.g:1775:3: (enumLiteral_2= Minutes )
                    {
                    // InternalFactoryLogicLangParser.g:1775:3: (enumLiteral_2= Minutes )
                    // InternalFactoryLogicLangParser.g:1776:4: enumLiteral_2= Minutes
                    {
                    enumLiteral_2=(Token)match(input,Minutes,FOLLOW_2); 

                    				current = grammarAccess.getTIMEAccess().getMINUTEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getTIMEAccess().getMINUTEEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalFactoryLogicLangParser.g:1783:3: (enumLiteral_3= Minute )
                    {
                    // InternalFactoryLogicLangParser.g:1783:3: (enumLiteral_3= Minute )
                    // InternalFactoryLogicLangParser.g:1784:4: enumLiteral_3= Minute
                    {
                    enumLiteral_3=(Token)match(input,Minute,FOLLOW_2); 

                    				current = grammarAccess.getTIMEAccess().getMINUTEEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getTIMEAccess().getMINUTEEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalFactoryLogicLangParser.g:1791:3: (enumLiteral_4= Hours )
                    {
                    // InternalFactoryLogicLangParser.g:1791:3: (enumLiteral_4= Hours )
                    // InternalFactoryLogicLangParser.g:1792:4: enumLiteral_4= Hours
                    {
                    enumLiteral_4=(Token)match(input,Hours,FOLLOW_2); 

                    				current = grammarAccess.getTIMEAccess().getHOUREnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getTIMEAccess().getHOUREnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalFactoryLogicLangParser.g:1799:3: (enumLiteral_5= Hour )
                    {
                    // InternalFactoryLogicLangParser.g:1799:3: (enumLiteral_5= Hour )
                    // InternalFactoryLogicLangParser.g:1800:4: enumLiteral_5= Hour
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


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0002042000001002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0001001000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000008000880000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000300000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x000400C0048C0070L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x00040080048C0040L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0003042000001000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000200400000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x000000000810A300L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000001000000L});

}