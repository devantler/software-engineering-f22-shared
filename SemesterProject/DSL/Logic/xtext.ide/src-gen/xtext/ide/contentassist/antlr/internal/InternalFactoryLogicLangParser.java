package xtext.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import xtext.services.FactoryLogicLangGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalFactoryLogicLangParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_VARIABLE", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'not'", "'less than'", "'greater than'", "'if'", "'is'", "'then'", "'for each'", "'in'", "'that is'", "'of'"
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

    	public void setGrammarAccess(FactoryLogicLangGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleModel"
    // InternalFactoryLogicLang.g:53:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalFactoryLogicLang.g:54:1: ( ruleModel EOF )
            // InternalFactoryLogicLang.g:55:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalFactoryLogicLang.g:62:1: ruleModel : ( ( ( rule__Model__DeclarationsAssignment ) ) ( ( rule__Model__DeclarationsAssignment )* ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:66:2: ( ( ( ( rule__Model__DeclarationsAssignment ) ) ( ( rule__Model__DeclarationsAssignment )* ) ) )
            // InternalFactoryLogicLang.g:67:2: ( ( ( rule__Model__DeclarationsAssignment ) ) ( ( rule__Model__DeclarationsAssignment )* ) )
            {
            // InternalFactoryLogicLang.g:67:2: ( ( ( rule__Model__DeclarationsAssignment ) ) ( ( rule__Model__DeclarationsAssignment )* ) )
            // InternalFactoryLogicLang.g:68:3: ( ( rule__Model__DeclarationsAssignment ) ) ( ( rule__Model__DeclarationsAssignment )* )
            {
            // InternalFactoryLogicLang.g:68:3: ( ( rule__Model__DeclarationsAssignment ) )
            // InternalFactoryLogicLang.g:69:4: ( rule__Model__DeclarationsAssignment )
            {
             before(grammarAccess.getModelAccess().getDeclarationsAssignment()); 
            // InternalFactoryLogicLang.g:70:4: ( rule__Model__DeclarationsAssignment )
            // InternalFactoryLogicLang.g:70:5: rule__Model__DeclarationsAssignment
            {
            pushFollow(FOLLOW_3);
            rule__Model__DeclarationsAssignment();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getDeclarationsAssignment()); 

            }

            // InternalFactoryLogicLang.g:73:3: ( ( rule__Model__DeclarationsAssignment )* )
            // InternalFactoryLogicLang.g:74:4: ( rule__Model__DeclarationsAssignment )*
            {
             before(grammarAccess.getModelAccess().getDeclarationsAssignment()); 
            // InternalFactoryLogicLang.g:75:4: ( rule__Model__DeclarationsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==15||LA1_0==18) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalFactoryLogicLang.g:75:5: rule__Model__DeclarationsAssignment
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__Model__DeclarationsAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getDeclarationsAssignment()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleDeclaration"
    // InternalFactoryLogicLang.g:85:1: entryRuleDeclaration : ruleDeclaration EOF ;
    public final void entryRuleDeclaration() throws RecognitionException {
        try {
            // InternalFactoryLogicLang.g:86:1: ( ruleDeclaration EOF )
            // InternalFactoryLogicLang.g:87:1: ruleDeclaration EOF
            {
             before(grammarAccess.getDeclarationRule()); 
            pushFollow(FOLLOW_1);
            ruleDeclaration();

            state._fsp--;

             after(grammarAccess.getDeclarationRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDeclaration"


    // $ANTLR start "ruleDeclaration"
    // InternalFactoryLogicLang.g:94:1: ruleDeclaration : ( ( rule__Declaration__Alternatives ) ) ;
    public final void ruleDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:98:2: ( ( ( rule__Declaration__Alternatives ) ) )
            // InternalFactoryLogicLang.g:99:2: ( ( rule__Declaration__Alternatives ) )
            {
            // InternalFactoryLogicLang.g:99:2: ( ( rule__Declaration__Alternatives ) )
            // InternalFactoryLogicLang.g:100:3: ( rule__Declaration__Alternatives )
            {
             before(grammarAccess.getDeclarationAccess().getAlternatives()); 
            // InternalFactoryLogicLang.g:101:3: ( rule__Declaration__Alternatives )
            // InternalFactoryLogicLang.g:101:4: rule__Declaration__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Declaration__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getDeclarationAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDeclaration"


    // $ANTLR start "entryRuleConditional"
    // InternalFactoryLogicLang.g:110:1: entryRuleConditional : ruleConditional EOF ;
    public final void entryRuleConditional() throws RecognitionException {
        try {
            // InternalFactoryLogicLang.g:111:1: ( ruleConditional EOF )
            // InternalFactoryLogicLang.g:112:1: ruleConditional EOF
            {
             before(grammarAccess.getConditionalRule()); 
            pushFollow(FOLLOW_1);
            ruleConditional();

            state._fsp--;

             after(grammarAccess.getConditionalRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConditional"


    // $ANTLR start "ruleConditional"
    // InternalFactoryLogicLang.g:119:1: ruleConditional : ( ( rule__Conditional__Group__0 ) ) ;
    public final void ruleConditional() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:123:2: ( ( ( rule__Conditional__Group__0 ) ) )
            // InternalFactoryLogicLang.g:124:2: ( ( rule__Conditional__Group__0 ) )
            {
            // InternalFactoryLogicLang.g:124:2: ( ( rule__Conditional__Group__0 ) )
            // InternalFactoryLogicLang.g:125:3: ( rule__Conditional__Group__0 )
            {
             before(grammarAccess.getConditionalAccess().getGroup()); 
            // InternalFactoryLogicLang.g:126:3: ( rule__Conditional__Group__0 )
            // InternalFactoryLogicLang.g:126:4: rule__Conditional__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Conditional__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConditionalAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConditional"


    // $ANTLR start "entryRuleLoop"
    // InternalFactoryLogicLang.g:135:1: entryRuleLoop : ruleLoop EOF ;
    public final void entryRuleLoop() throws RecognitionException {
        try {
            // InternalFactoryLogicLang.g:136:1: ( ruleLoop EOF )
            // InternalFactoryLogicLang.g:137:1: ruleLoop EOF
            {
             before(grammarAccess.getLoopRule()); 
            pushFollow(FOLLOW_1);
            ruleLoop();

            state._fsp--;

             after(grammarAccess.getLoopRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLoop"


    // $ANTLR start "ruleLoop"
    // InternalFactoryLogicLang.g:144:1: ruleLoop : ( ( rule__Loop__Group__0 ) ) ;
    public final void ruleLoop() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:148:2: ( ( ( rule__Loop__Group__0 ) ) )
            // InternalFactoryLogicLang.g:149:2: ( ( rule__Loop__Group__0 ) )
            {
            // InternalFactoryLogicLang.g:149:2: ( ( rule__Loop__Group__0 ) )
            // InternalFactoryLogicLang.g:150:3: ( rule__Loop__Group__0 )
            {
             before(grammarAccess.getLoopAccess().getGroup()); 
            // InternalFactoryLogicLang.g:151:3: ( rule__Loop__Group__0 )
            // InternalFactoryLogicLang.g:151:4: rule__Loop__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Loop__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLoopAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLoop"


    // $ANTLR start "ruleBOOLEAN_OPERATOR"
    // InternalFactoryLogicLang.g:160:1: ruleBOOLEAN_OPERATOR : ( ( rule__BOOLEAN_OPERATOR__Alternatives ) ) ;
    public final void ruleBOOLEAN_OPERATOR() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:164:1: ( ( ( rule__BOOLEAN_OPERATOR__Alternatives ) ) )
            // InternalFactoryLogicLang.g:165:2: ( ( rule__BOOLEAN_OPERATOR__Alternatives ) )
            {
            // InternalFactoryLogicLang.g:165:2: ( ( rule__BOOLEAN_OPERATOR__Alternatives ) )
            // InternalFactoryLogicLang.g:166:3: ( rule__BOOLEAN_OPERATOR__Alternatives )
            {
             before(grammarAccess.getBOOLEAN_OPERATORAccess().getAlternatives()); 
            // InternalFactoryLogicLang.g:167:3: ( rule__BOOLEAN_OPERATOR__Alternatives )
            // InternalFactoryLogicLang.g:167:4: rule__BOOLEAN_OPERATOR__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__BOOLEAN_OPERATOR__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getBOOLEAN_OPERATORAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBOOLEAN_OPERATOR"


    // $ANTLR start "rule__Declaration__Alternatives"
    // InternalFactoryLogicLang.g:175:1: rule__Declaration__Alternatives : ( ( ruleConditional ) | ( ruleLoop ) );
    public final void rule__Declaration__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:179:1: ( ( ruleConditional ) | ( ruleLoop ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==15) ) {
                alt2=1;
            }
            else if ( (LA2_0==18) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalFactoryLogicLang.g:180:2: ( ruleConditional )
                    {
                    // InternalFactoryLogicLang.g:180:2: ( ruleConditional )
                    // InternalFactoryLogicLang.g:181:3: ruleConditional
                    {
                     before(grammarAccess.getDeclarationAccess().getConditionalParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleConditional();

                    state._fsp--;

                     after(grammarAccess.getDeclarationAccess().getConditionalParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalFactoryLogicLang.g:186:2: ( ruleLoop )
                    {
                    // InternalFactoryLogicLang.g:186:2: ( ruleLoop )
                    // InternalFactoryLogicLang.g:187:3: ruleLoop
                    {
                     before(grammarAccess.getDeclarationAccess().getLoopParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleLoop();

                    state._fsp--;

                     after(grammarAccess.getDeclarationAccess().getLoopParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declaration__Alternatives"


    // $ANTLR start "rule__BOOLEAN_OPERATOR__Alternatives"
    // InternalFactoryLogicLang.g:196:1: rule__BOOLEAN_OPERATOR__Alternatives : ( ( ( 'not' ) ) | ( ( 'less than' ) ) | ( ( 'greater than' ) ) );
    public final void rule__BOOLEAN_OPERATOR__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:200:1: ( ( ( 'not' ) ) | ( ( 'less than' ) ) | ( ( 'greater than' ) ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt3=1;
                }
                break;
            case 13:
                {
                alt3=2;
                }
                break;
            case 14:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalFactoryLogicLang.g:201:2: ( ( 'not' ) )
                    {
                    // InternalFactoryLogicLang.g:201:2: ( ( 'not' ) )
                    // InternalFactoryLogicLang.g:202:3: ( 'not' )
                    {
                     before(grammarAccess.getBOOLEAN_OPERATORAccess().getNOTEnumLiteralDeclaration_0()); 
                    // InternalFactoryLogicLang.g:203:3: ( 'not' )
                    // InternalFactoryLogicLang.g:203:4: 'not'
                    {
                    match(input,12,FOLLOW_2); 

                    }

                     after(grammarAccess.getBOOLEAN_OPERATORAccess().getNOTEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalFactoryLogicLang.g:207:2: ( ( 'less than' ) )
                    {
                    // InternalFactoryLogicLang.g:207:2: ( ( 'less than' ) )
                    // InternalFactoryLogicLang.g:208:3: ( 'less than' )
                    {
                     before(grammarAccess.getBOOLEAN_OPERATORAccess().getLESSEnumLiteralDeclaration_1()); 
                    // InternalFactoryLogicLang.g:209:3: ( 'less than' )
                    // InternalFactoryLogicLang.g:209:4: 'less than'
                    {
                    match(input,13,FOLLOW_2); 

                    }

                     after(grammarAccess.getBOOLEAN_OPERATORAccess().getLESSEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalFactoryLogicLang.g:213:2: ( ( 'greater than' ) )
                    {
                    // InternalFactoryLogicLang.g:213:2: ( ( 'greater than' ) )
                    // InternalFactoryLogicLang.g:214:3: ( 'greater than' )
                    {
                     before(grammarAccess.getBOOLEAN_OPERATORAccess().getGREATEREnumLiteralDeclaration_2()); 
                    // InternalFactoryLogicLang.g:215:3: ( 'greater than' )
                    // InternalFactoryLogicLang.g:215:4: 'greater than'
                    {
                    match(input,14,FOLLOW_2); 

                    }

                     after(grammarAccess.getBOOLEAN_OPERATORAccess().getGREATEREnumLiteralDeclaration_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BOOLEAN_OPERATOR__Alternatives"


    // $ANTLR start "rule__Conditional__Group__0"
    // InternalFactoryLogicLang.g:223:1: rule__Conditional__Group__0 : rule__Conditional__Group__0__Impl rule__Conditional__Group__1 ;
    public final void rule__Conditional__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:227:1: ( rule__Conditional__Group__0__Impl rule__Conditional__Group__1 )
            // InternalFactoryLogicLang.g:228:2: rule__Conditional__Group__0__Impl rule__Conditional__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Conditional__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Conditional__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conditional__Group__0"


    // $ANTLR start "rule__Conditional__Group__0__Impl"
    // InternalFactoryLogicLang.g:235:1: rule__Conditional__Group__0__Impl : ( 'if' ) ;
    public final void rule__Conditional__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:239:1: ( ( 'if' ) )
            // InternalFactoryLogicLang.g:240:1: ( 'if' )
            {
            // InternalFactoryLogicLang.g:240:1: ( 'if' )
            // InternalFactoryLogicLang.g:241:2: 'if'
            {
             before(grammarAccess.getConditionalAccess().getIfKeyword_0()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getConditionalAccess().getIfKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conditional__Group__0__Impl"


    // $ANTLR start "rule__Conditional__Group__1"
    // InternalFactoryLogicLang.g:250:1: rule__Conditional__Group__1 : rule__Conditional__Group__1__Impl rule__Conditional__Group__2 ;
    public final void rule__Conditional__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:254:1: ( rule__Conditional__Group__1__Impl rule__Conditional__Group__2 )
            // InternalFactoryLogicLang.g:255:2: rule__Conditional__Group__1__Impl rule__Conditional__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Conditional__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Conditional__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conditional__Group__1"


    // $ANTLR start "rule__Conditional__Group__1__Impl"
    // InternalFactoryLogicLang.g:262:1: rule__Conditional__Group__1__Impl : ( ( rule__Conditional__VariableAssignment_1 ) ) ;
    public final void rule__Conditional__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:266:1: ( ( ( rule__Conditional__VariableAssignment_1 ) ) )
            // InternalFactoryLogicLang.g:267:1: ( ( rule__Conditional__VariableAssignment_1 ) )
            {
            // InternalFactoryLogicLang.g:267:1: ( ( rule__Conditional__VariableAssignment_1 ) )
            // InternalFactoryLogicLang.g:268:2: ( rule__Conditional__VariableAssignment_1 )
            {
             before(grammarAccess.getConditionalAccess().getVariableAssignment_1()); 
            // InternalFactoryLogicLang.g:269:2: ( rule__Conditional__VariableAssignment_1 )
            // InternalFactoryLogicLang.g:269:3: rule__Conditional__VariableAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Conditional__VariableAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getConditionalAccess().getVariableAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conditional__Group__1__Impl"


    // $ANTLR start "rule__Conditional__Group__2"
    // InternalFactoryLogicLang.g:277:1: rule__Conditional__Group__2 : rule__Conditional__Group__2__Impl rule__Conditional__Group__3 ;
    public final void rule__Conditional__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:281:1: ( rule__Conditional__Group__2__Impl rule__Conditional__Group__3 )
            // InternalFactoryLogicLang.g:282:2: rule__Conditional__Group__2__Impl rule__Conditional__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__Conditional__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Conditional__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conditional__Group__2"


    // $ANTLR start "rule__Conditional__Group__2__Impl"
    // InternalFactoryLogicLang.g:289:1: rule__Conditional__Group__2__Impl : ( 'is' ) ;
    public final void rule__Conditional__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:293:1: ( ( 'is' ) )
            // InternalFactoryLogicLang.g:294:1: ( 'is' )
            {
            // InternalFactoryLogicLang.g:294:1: ( 'is' )
            // InternalFactoryLogicLang.g:295:2: 'is'
            {
             before(grammarAccess.getConditionalAccess().getIsKeyword_2()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getConditionalAccess().getIsKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conditional__Group__2__Impl"


    // $ANTLR start "rule__Conditional__Group__3"
    // InternalFactoryLogicLang.g:304:1: rule__Conditional__Group__3 : rule__Conditional__Group__3__Impl rule__Conditional__Group__4 ;
    public final void rule__Conditional__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:308:1: ( rule__Conditional__Group__3__Impl rule__Conditional__Group__4 )
            // InternalFactoryLogicLang.g:309:2: rule__Conditional__Group__3__Impl rule__Conditional__Group__4
            {
            pushFollow(FOLLOW_6);
            rule__Conditional__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Conditional__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conditional__Group__3"


    // $ANTLR start "rule__Conditional__Group__3__Impl"
    // InternalFactoryLogicLang.g:316:1: rule__Conditional__Group__3__Impl : ( ( rule__Conditional__OperatorAssignment_3 )? ) ;
    public final void rule__Conditional__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:320:1: ( ( ( rule__Conditional__OperatorAssignment_3 )? ) )
            // InternalFactoryLogicLang.g:321:1: ( ( rule__Conditional__OperatorAssignment_3 )? )
            {
            // InternalFactoryLogicLang.g:321:1: ( ( rule__Conditional__OperatorAssignment_3 )? )
            // InternalFactoryLogicLang.g:322:2: ( rule__Conditional__OperatorAssignment_3 )?
            {
             before(grammarAccess.getConditionalAccess().getOperatorAssignment_3()); 
            // InternalFactoryLogicLang.g:323:2: ( rule__Conditional__OperatorAssignment_3 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=12 && LA4_0<=14)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalFactoryLogicLang.g:323:3: rule__Conditional__OperatorAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__Conditional__OperatorAssignment_3();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getConditionalAccess().getOperatorAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conditional__Group__3__Impl"


    // $ANTLR start "rule__Conditional__Group__4"
    // InternalFactoryLogicLang.g:331:1: rule__Conditional__Group__4 : rule__Conditional__Group__4__Impl rule__Conditional__Group__5 ;
    public final void rule__Conditional__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:335:1: ( rule__Conditional__Group__4__Impl rule__Conditional__Group__5 )
            // InternalFactoryLogicLang.g:336:2: rule__Conditional__Group__4__Impl rule__Conditional__Group__5
            {
            pushFollow(FOLLOW_7);
            rule__Conditional__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Conditional__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conditional__Group__4"


    // $ANTLR start "rule__Conditional__Group__4__Impl"
    // InternalFactoryLogicLang.g:343:1: rule__Conditional__Group__4__Impl : ( ( rule__Conditional__ComparisonAssignment_4 ) ) ;
    public final void rule__Conditional__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:347:1: ( ( ( rule__Conditional__ComparisonAssignment_4 ) ) )
            // InternalFactoryLogicLang.g:348:1: ( ( rule__Conditional__ComparisonAssignment_4 ) )
            {
            // InternalFactoryLogicLang.g:348:1: ( ( rule__Conditional__ComparisonAssignment_4 ) )
            // InternalFactoryLogicLang.g:349:2: ( rule__Conditional__ComparisonAssignment_4 )
            {
             before(grammarAccess.getConditionalAccess().getComparisonAssignment_4()); 
            // InternalFactoryLogicLang.g:350:2: ( rule__Conditional__ComparisonAssignment_4 )
            // InternalFactoryLogicLang.g:350:3: rule__Conditional__ComparisonAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Conditional__ComparisonAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getConditionalAccess().getComparisonAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conditional__Group__4__Impl"


    // $ANTLR start "rule__Conditional__Group__5"
    // InternalFactoryLogicLang.g:358:1: rule__Conditional__Group__5 : rule__Conditional__Group__5__Impl ;
    public final void rule__Conditional__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:362:1: ( rule__Conditional__Group__5__Impl )
            // InternalFactoryLogicLang.g:363:2: rule__Conditional__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Conditional__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conditional__Group__5"


    // $ANTLR start "rule__Conditional__Group__5__Impl"
    // InternalFactoryLogicLang.g:369:1: rule__Conditional__Group__5__Impl : ( 'then' ) ;
    public final void rule__Conditional__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:373:1: ( ( 'then' ) )
            // InternalFactoryLogicLang.g:374:1: ( 'then' )
            {
            // InternalFactoryLogicLang.g:374:1: ( 'then' )
            // InternalFactoryLogicLang.g:375:2: 'then'
            {
             before(grammarAccess.getConditionalAccess().getThenKeyword_5()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getConditionalAccess().getThenKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conditional__Group__5__Impl"


    // $ANTLR start "rule__Loop__Group__0"
    // InternalFactoryLogicLang.g:385:1: rule__Loop__Group__0 : rule__Loop__Group__0__Impl rule__Loop__Group__1 ;
    public final void rule__Loop__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:389:1: ( rule__Loop__Group__0__Impl rule__Loop__Group__1 )
            // InternalFactoryLogicLang.g:390:2: rule__Loop__Group__0__Impl rule__Loop__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Loop__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Loop__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group__0"


    // $ANTLR start "rule__Loop__Group__0__Impl"
    // InternalFactoryLogicLang.g:397:1: rule__Loop__Group__0__Impl : ( 'for each' ) ;
    public final void rule__Loop__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:401:1: ( ( 'for each' ) )
            // InternalFactoryLogicLang.g:402:1: ( 'for each' )
            {
            // InternalFactoryLogicLang.g:402:1: ( 'for each' )
            // InternalFactoryLogicLang.g:403:2: 'for each'
            {
             before(grammarAccess.getLoopAccess().getForEachKeyword_0()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getLoopAccess().getForEachKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group__0__Impl"


    // $ANTLR start "rule__Loop__Group__1"
    // InternalFactoryLogicLang.g:412:1: rule__Loop__Group__1 : rule__Loop__Group__1__Impl rule__Loop__Group__2 ;
    public final void rule__Loop__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:416:1: ( rule__Loop__Group__1__Impl rule__Loop__Group__2 )
            // InternalFactoryLogicLang.g:417:2: rule__Loop__Group__1__Impl rule__Loop__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__Loop__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Loop__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group__1"


    // $ANTLR start "rule__Loop__Group__1__Impl"
    // InternalFactoryLogicLang.g:424:1: rule__Loop__Group__1__Impl : ( ( rule__Loop__LoopvarAssignment_1 ) ) ;
    public final void rule__Loop__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:428:1: ( ( ( rule__Loop__LoopvarAssignment_1 ) ) )
            // InternalFactoryLogicLang.g:429:1: ( ( rule__Loop__LoopvarAssignment_1 ) )
            {
            // InternalFactoryLogicLang.g:429:1: ( ( rule__Loop__LoopvarAssignment_1 ) )
            // InternalFactoryLogicLang.g:430:2: ( rule__Loop__LoopvarAssignment_1 )
            {
             before(grammarAccess.getLoopAccess().getLoopvarAssignment_1()); 
            // InternalFactoryLogicLang.g:431:2: ( rule__Loop__LoopvarAssignment_1 )
            // InternalFactoryLogicLang.g:431:3: rule__Loop__LoopvarAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Loop__LoopvarAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getLoopAccess().getLoopvarAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group__1__Impl"


    // $ANTLR start "rule__Loop__Group__2"
    // InternalFactoryLogicLang.g:439:1: rule__Loop__Group__2 : rule__Loop__Group__2__Impl rule__Loop__Group__3 ;
    public final void rule__Loop__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:443:1: ( rule__Loop__Group__2__Impl rule__Loop__Group__3 )
            // InternalFactoryLogicLang.g:444:2: rule__Loop__Group__2__Impl rule__Loop__Group__3
            {
            pushFollow(FOLLOW_4);
            rule__Loop__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Loop__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group__2"


    // $ANTLR start "rule__Loop__Group__2__Impl"
    // InternalFactoryLogicLang.g:451:1: rule__Loop__Group__2__Impl : ( 'in' ) ;
    public final void rule__Loop__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:455:1: ( ( 'in' ) )
            // InternalFactoryLogicLang.g:456:1: ( 'in' )
            {
            // InternalFactoryLogicLang.g:456:1: ( 'in' )
            // InternalFactoryLogicLang.g:457:2: 'in'
            {
             before(grammarAccess.getLoopAccess().getInKeyword_2()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getLoopAccess().getInKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group__2__Impl"


    // $ANTLR start "rule__Loop__Group__3"
    // InternalFactoryLogicLang.g:466:1: rule__Loop__Group__3 : rule__Loop__Group__3__Impl rule__Loop__Group__4 ;
    public final void rule__Loop__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:470:1: ( rule__Loop__Group__3__Impl rule__Loop__Group__4 )
            // InternalFactoryLogicLang.g:471:2: rule__Loop__Group__3__Impl rule__Loop__Group__4
            {
            pushFollow(FOLLOW_9);
            rule__Loop__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Loop__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group__3"


    // $ANTLR start "rule__Loop__Group__3__Impl"
    // InternalFactoryLogicLang.g:478:1: rule__Loop__Group__3__Impl : ( ( rule__Loop__VariableAssignment_3 ) ) ;
    public final void rule__Loop__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:482:1: ( ( ( rule__Loop__VariableAssignment_3 ) ) )
            // InternalFactoryLogicLang.g:483:1: ( ( rule__Loop__VariableAssignment_3 ) )
            {
            // InternalFactoryLogicLang.g:483:1: ( ( rule__Loop__VariableAssignment_3 ) )
            // InternalFactoryLogicLang.g:484:2: ( rule__Loop__VariableAssignment_3 )
            {
             before(grammarAccess.getLoopAccess().getVariableAssignment_3()); 
            // InternalFactoryLogicLang.g:485:2: ( rule__Loop__VariableAssignment_3 )
            // InternalFactoryLogicLang.g:485:3: rule__Loop__VariableAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Loop__VariableAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getLoopAccess().getVariableAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group__3__Impl"


    // $ANTLR start "rule__Loop__Group__4"
    // InternalFactoryLogicLang.g:493:1: rule__Loop__Group__4 : rule__Loop__Group__4__Impl rule__Loop__Group__5 ;
    public final void rule__Loop__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:497:1: ( rule__Loop__Group__4__Impl rule__Loop__Group__5 )
            // InternalFactoryLogicLang.g:498:2: rule__Loop__Group__4__Impl rule__Loop__Group__5
            {
            pushFollow(FOLLOW_9);
            rule__Loop__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Loop__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group__4"


    // $ANTLR start "rule__Loop__Group__4__Impl"
    // InternalFactoryLogicLang.g:505:1: rule__Loop__Group__4__Impl : ( ( rule__Loop__Group_4__0 )? ) ;
    public final void rule__Loop__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:509:1: ( ( ( rule__Loop__Group_4__0 )? ) )
            // InternalFactoryLogicLang.g:510:1: ( ( rule__Loop__Group_4__0 )? )
            {
            // InternalFactoryLogicLang.g:510:1: ( ( rule__Loop__Group_4__0 )? )
            // InternalFactoryLogicLang.g:511:2: ( rule__Loop__Group_4__0 )?
            {
             before(grammarAccess.getLoopAccess().getGroup_4()); 
            // InternalFactoryLogicLang.g:512:2: ( rule__Loop__Group_4__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==21) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalFactoryLogicLang.g:512:3: rule__Loop__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Loop__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getLoopAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group__4__Impl"


    // $ANTLR start "rule__Loop__Group__5"
    // InternalFactoryLogicLang.g:520:1: rule__Loop__Group__5 : rule__Loop__Group__5__Impl rule__Loop__Group__6 ;
    public final void rule__Loop__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:524:1: ( rule__Loop__Group__5__Impl rule__Loop__Group__6 )
            // InternalFactoryLogicLang.g:525:2: rule__Loop__Group__5__Impl rule__Loop__Group__6
            {
            pushFollow(FOLLOW_6);
            rule__Loop__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Loop__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group__5"


    // $ANTLR start "rule__Loop__Group__5__Impl"
    // InternalFactoryLogicLang.g:532:1: rule__Loop__Group__5__Impl : ( 'that is' ) ;
    public final void rule__Loop__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:536:1: ( ( 'that is' ) )
            // InternalFactoryLogicLang.g:537:1: ( 'that is' )
            {
            // InternalFactoryLogicLang.g:537:1: ( 'that is' )
            // InternalFactoryLogicLang.g:538:2: 'that is'
            {
             before(grammarAccess.getLoopAccess().getThatIsKeyword_5()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getLoopAccess().getThatIsKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group__5__Impl"


    // $ANTLR start "rule__Loop__Group__6"
    // InternalFactoryLogicLang.g:547:1: rule__Loop__Group__6 : rule__Loop__Group__6__Impl rule__Loop__Group__7 ;
    public final void rule__Loop__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:551:1: ( rule__Loop__Group__6__Impl rule__Loop__Group__7 )
            // InternalFactoryLogicLang.g:552:2: rule__Loop__Group__6__Impl rule__Loop__Group__7
            {
            pushFollow(FOLLOW_6);
            rule__Loop__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Loop__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group__6"


    // $ANTLR start "rule__Loop__Group__6__Impl"
    // InternalFactoryLogicLang.g:559:1: rule__Loop__Group__6__Impl : ( ( rule__Loop__OperatorAssignment_6 )? ) ;
    public final void rule__Loop__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:563:1: ( ( ( rule__Loop__OperatorAssignment_6 )? ) )
            // InternalFactoryLogicLang.g:564:1: ( ( rule__Loop__OperatorAssignment_6 )? )
            {
            // InternalFactoryLogicLang.g:564:1: ( ( rule__Loop__OperatorAssignment_6 )? )
            // InternalFactoryLogicLang.g:565:2: ( rule__Loop__OperatorAssignment_6 )?
            {
             before(grammarAccess.getLoopAccess().getOperatorAssignment_6()); 
            // InternalFactoryLogicLang.g:566:2: ( rule__Loop__OperatorAssignment_6 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=12 && LA6_0<=14)) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalFactoryLogicLang.g:566:3: rule__Loop__OperatorAssignment_6
                    {
                    pushFollow(FOLLOW_2);
                    rule__Loop__OperatorAssignment_6();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getLoopAccess().getOperatorAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group__6__Impl"


    // $ANTLR start "rule__Loop__Group__7"
    // InternalFactoryLogicLang.g:574:1: rule__Loop__Group__7 : rule__Loop__Group__7__Impl rule__Loop__Group__8 ;
    public final void rule__Loop__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:578:1: ( rule__Loop__Group__7__Impl rule__Loop__Group__8 )
            // InternalFactoryLogicLang.g:579:2: rule__Loop__Group__7__Impl rule__Loop__Group__8
            {
            pushFollow(FOLLOW_10);
            rule__Loop__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Loop__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group__7"


    // $ANTLR start "rule__Loop__Group__7__Impl"
    // InternalFactoryLogicLang.g:586:1: rule__Loop__Group__7__Impl : ( ( rule__Loop__ComparisonAssignment_7 ) ) ;
    public final void rule__Loop__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:590:1: ( ( ( rule__Loop__ComparisonAssignment_7 ) ) )
            // InternalFactoryLogicLang.g:591:1: ( ( rule__Loop__ComparisonAssignment_7 ) )
            {
            // InternalFactoryLogicLang.g:591:1: ( ( rule__Loop__ComparisonAssignment_7 ) )
            // InternalFactoryLogicLang.g:592:2: ( rule__Loop__ComparisonAssignment_7 )
            {
             before(grammarAccess.getLoopAccess().getComparisonAssignment_7()); 
            // InternalFactoryLogicLang.g:593:2: ( rule__Loop__ComparisonAssignment_7 )
            // InternalFactoryLogicLang.g:593:3: rule__Loop__ComparisonAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__Loop__ComparisonAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getLoopAccess().getComparisonAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group__7__Impl"


    // $ANTLR start "rule__Loop__Group__8"
    // InternalFactoryLogicLang.g:601:1: rule__Loop__Group__8 : rule__Loop__Group__8__Impl rule__Loop__Group__9 ;
    public final void rule__Loop__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:605:1: ( rule__Loop__Group__8__Impl rule__Loop__Group__9 )
            // InternalFactoryLogicLang.g:606:2: rule__Loop__Group__8__Impl rule__Loop__Group__9
            {
            pushFollow(FOLLOW_10);
            rule__Loop__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Loop__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group__8"


    // $ANTLR start "rule__Loop__Group__8__Impl"
    // InternalFactoryLogicLang.g:613:1: rule__Loop__Group__8__Impl : ( ( rule__Loop__Group_8__0 )? ) ;
    public final void rule__Loop__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:617:1: ( ( ( rule__Loop__Group_8__0 )? ) )
            // InternalFactoryLogicLang.g:618:1: ( ( rule__Loop__Group_8__0 )? )
            {
            // InternalFactoryLogicLang.g:618:1: ( ( rule__Loop__Group_8__0 )? )
            // InternalFactoryLogicLang.g:619:2: ( rule__Loop__Group_8__0 )?
            {
             before(grammarAccess.getLoopAccess().getGroup_8()); 
            // InternalFactoryLogicLang.g:620:2: ( rule__Loop__Group_8__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==21) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalFactoryLogicLang.g:620:3: rule__Loop__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Loop__Group_8__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getLoopAccess().getGroup_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group__8__Impl"


    // $ANTLR start "rule__Loop__Group__9"
    // InternalFactoryLogicLang.g:628:1: rule__Loop__Group__9 : rule__Loop__Group__9__Impl ;
    public final void rule__Loop__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:632:1: ( rule__Loop__Group__9__Impl )
            // InternalFactoryLogicLang.g:633:2: rule__Loop__Group__9__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Loop__Group__9__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group__9"


    // $ANTLR start "rule__Loop__Group__9__Impl"
    // InternalFactoryLogicLang.g:639:1: rule__Loop__Group__9__Impl : ( 'then' ) ;
    public final void rule__Loop__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:643:1: ( ( 'then' ) )
            // InternalFactoryLogicLang.g:644:1: ( 'then' )
            {
            // InternalFactoryLogicLang.g:644:1: ( 'then' )
            // InternalFactoryLogicLang.g:645:2: 'then'
            {
             before(grammarAccess.getLoopAccess().getThenKeyword_9()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getLoopAccess().getThenKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group__9__Impl"


    // $ANTLR start "rule__Loop__Group_4__0"
    // InternalFactoryLogicLang.g:655:1: rule__Loop__Group_4__0 : rule__Loop__Group_4__0__Impl rule__Loop__Group_4__1 ;
    public final void rule__Loop__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:659:1: ( rule__Loop__Group_4__0__Impl rule__Loop__Group_4__1 )
            // InternalFactoryLogicLang.g:660:2: rule__Loop__Group_4__0__Impl rule__Loop__Group_4__1
            {
            pushFollow(FOLLOW_11);
            rule__Loop__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Loop__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group_4__0"


    // $ANTLR start "rule__Loop__Group_4__0__Impl"
    // InternalFactoryLogicLang.g:667:1: rule__Loop__Group_4__0__Impl : ( 'of' ) ;
    public final void rule__Loop__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:671:1: ( ( 'of' ) )
            // InternalFactoryLogicLang.g:672:1: ( 'of' )
            {
            // InternalFactoryLogicLang.g:672:1: ( 'of' )
            // InternalFactoryLogicLang.g:673:2: 'of'
            {
             before(grammarAccess.getLoopAccess().getOfKeyword_4_0()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getLoopAccess().getOfKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group_4__0__Impl"


    // $ANTLR start "rule__Loop__Group_4__1"
    // InternalFactoryLogicLang.g:682:1: rule__Loop__Group_4__1 : rule__Loop__Group_4__1__Impl ;
    public final void rule__Loop__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:686:1: ( rule__Loop__Group_4__1__Impl )
            // InternalFactoryLogicLang.g:687:2: rule__Loop__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Loop__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group_4__1"


    // $ANTLR start "rule__Loop__Group_4__1__Impl"
    // InternalFactoryLogicLang.g:693:1: rule__Loop__Group_4__1__Impl : ( ( rule__Loop__STRING1Assignment_4_1 ) ) ;
    public final void rule__Loop__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:697:1: ( ( ( rule__Loop__STRING1Assignment_4_1 ) ) )
            // InternalFactoryLogicLang.g:698:1: ( ( rule__Loop__STRING1Assignment_4_1 ) )
            {
            // InternalFactoryLogicLang.g:698:1: ( ( rule__Loop__STRING1Assignment_4_1 ) )
            // InternalFactoryLogicLang.g:699:2: ( rule__Loop__STRING1Assignment_4_1 )
            {
             before(grammarAccess.getLoopAccess().getSTRING1Assignment_4_1()); 
            // InternalFactoryLogicLang.g:700:2: ( rule__Loop__STRING1Assignment_4_1 )
            // InternalFactoryLogicLang.g:700:3: rule__Loop__STRING1Assignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__Loop__STRING1Assignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getLoopAccess().getSTRING1Assignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group_4__1__Impl"


    // $ANTLR start "rule__Loop__Group_8__0"
    // InternalFactoryLogicLang.g:709:1: rule__Loop__Group_8__0 : rule__Loop__Group_8__0__Impl rule__Loop__Group_8__1 ;
    public final void rule__Loop__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:713:1: ( rule__Loop__Group_8__0__Impl rule__Loop__Group_8__1 )
            // InternalFactoryLogicLang.g:714:2: rule__Loop__Group_8__0__Impl rule__Loop__Group_8__1
            {
            pushFollow(FOLLOW_11);
            rule__Loop__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Loop__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group_8__0"


    // $ANTLR start "rule__Loop__Group_8__0__Impl"
    // InternalFactoryLogicLang.g:721:1: rule__Loop__Group_8__0__Impl : ( 'of' ) ;
    public final void rule__Loop__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:725:1: ( ( 'of' ) )
            // InternalFactoryLogicLang.g:726:1: ( 'of' )
            {
            // InternalFactoryLogicLang.g:726:1: ( 'of' )
            // InternalFactoryLogicLang.g:727:2: 'of'
            {
             before(grammarAccess.getLoopAccess().getOfKeyword_8_0()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getLoopAccess().getOfKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group_8__0__Impl"


    // $ANTLR start "rule__Loop__Group_8__1"
    // InternalFactoryLogicLang.g:736:1: rule__Loop__Group_8__1 : rule__Loop__Group_8__1__Impl ;
    public final void rule__Loop__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:740:1: ( rule__Loop__Group_8__1__Impl )
            // InternalFactoryLogicLang.g:741:2: rule__Loop__Group_8__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Loop__Group_8__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group_8__1"


    // $ANTLR start "rule__Loop__Group_8__1__Impl"
    // InternalFactoryLogicLang.g:747:1: rule__Loop__Group_8__1__Impl : ( ( rule__Loop__STRING2Assignment_8_1 ) ) ;
    public final void rule__Loop__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:751:1: ( ( ( rule__Loop__STRING2Assignment_8_1 ) ) )
            // InternalFactoryLogicLang.g:752:1: ( ( rule__Loop__STRING2Assignment_8_1 ) )
            {
            // InternalFactoryLogicLang.g:752:1: ( ( rule__Loop__STRING2Assignment_8_1 ) )
            // InternalFactoryLogicLang.g:753:2: ( rule__Loop__STRING2Assignment_8_1 )
            {
             before(grammarAccess.getLoopAccess().getSTRING2Assignment_8_1()); 
            // InternalFactoryLogicLang.g:754:2: ( rule__Loop__STRING2Assignment_8_1 )
            // InternalFactoryLogicLang.g:754:3: rule__Loop__STRING2Assignment_8_1
            {
            pushFollow(FOLLOW_2);
            rule__Loop__STRING2Assignment_8_1();

            state._fsp--;


            }

             after(grammarAccess.getLoopAccess().getSTRING2Assignment_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group_8__1__Impl"


    // $ANTLR start "rule__Model__DeclarationsAssignment"
    // InternalFactoryLogicLang.g:763:1: rule__Model__DeclarationsAssignment : ( ruleDeclaration ) ;
    public final void rule__Model__DeclarationsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:767:1: ( ( ruleDeclaration ) )
            // InternalFactoryLogicLang.g:768:2: ( ruleDeclaration )
            {
            // InternalFactoryLogicLang.g:768:2: ( ruleDeclaration )
            // InternalFactoryLogicLang.g:769:3: ruleDeclaration
            {
             before(grammarAccess.getModelAccess().getDeclarationsDeclarationParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleDeclaration();

            state._fsp--;

             after(grammarAccess.getModelAccess().getDeclarationsDeclarationParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__DeclarationsAssignment"


    // $ANTLR start "rule__Conditional__VariableAssignment_1"
    // InternalFactoryLogicLang.g:778:1: rule__Conditional__VariableAssignment_1 : ( RULE_VARIABLE ) ;
    public final void rule__Conditional__VariableAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:782:1: ( ( RULE_VARIABLE ) )
            // InternalFactoryLogicLang.g:783:2: ( RULE_VARIABLE )
            {
            // InternalFactoryLogicLang.g:783:2: ( RULE_VARIABLE )
            // InternalFactoryLogicLang.g:784:3: RULE_VARIABLE
            {
             before(grammarAccess.getConditionalAccess().getVariableVARIABLETerminalRuleCall_1_0()); 
            match(input,RULE_VARIABLE,FOLLOW_2); 
             after(grammarAccess.getConditionalAccess().getVariableVARIABLETerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conditional__VariableAssignment_1"


    // $ANTLR start "rule__Conditional__OperatorAssignment_3"
    // InternalFactoryLogicLang.g:793:1: rule__Conditional__OperatorAssignment_3 : ( ruleBOOLEAN_OPERATOR ) ;
    public final void rule__Conditional__OperatorAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:797:1: ( ( ruleBOOLEAN_OPERATOR ) )
            // InternalFactoryLogicLang.g:798:2: ( ruleBOOLEAN_OPERATOR )
            {
            // InternalFactoryLogicLang.g:798:2: ( ruleBOOLEAN_OPERATOR )
            // InternalFactoryLogicLang.g:799:3: ruleBOOLEAN_OPERATOR
            {
             before(grammarAccess.getConditionalAccess().getOperatorBOOLEAN_OPERATOREnumRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleBOOLEAN_OPERATOR();

            state._fsp--;

             after(grammarAccess.getConditionalAccess().getOperatorBOOLEAN_OPERATOREnumRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conditional__OperatorAssignment_3"


    // $ANTLR start "rule__Conditional__ComparisonAssignment_4"
    // InternalFactoryLogicLang.g:808:1: rule__Conditional__ComparisonAssignment_4 : ( RULE_VARIABLE ) ;
    public final void rule__Conditional__ComparisonAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:812:1: ( ( RULE_VARIABLE ) )
            // InternalFactoryLogicLang.g:813:2: ( RULE_VARIABLE )
            {
            // InternalFactoryLogicLang.g:813:2: ( RULE_VARIABLE )
            // InternalFactoryLogicLang.g:814:3: RULE_VARIABLE
            {
             before(grammarAccess.getConditionalAccess().getComparisonVARIABLETerminalRuleCall_4_0()); 
            match(input,RULE_VARIABLE,FOLLOW_2); 
             after(grammarAccess.getConditionalAccess().getComparisonVARIABLETerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conditional__ComparisonAssignment_4"


    // $ANTLR start "rule__Loop__LoopvarAssignment_1"
    // InternalFactoryLogicLang.g:823:1: rule__Loop__LoopvarAssignment_1 : ( RULE_VARIABLE ) ;
    public final void rule__Loop__LoopvarAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:827:1: ( ( RULE_VARIABLE ) )
            // InternalFactoryLogicLang.g:828:2: ( RULE_VARIABLE )
            {
            // InternalFactoryLogicLang.g:828:2: ( RULE_VARIABLE )
            // InternalFactoryLogicLang.g:829:3: RULE_VARIABLE
            {
             before(grammarAccess.getLoopAccess().getLoopvarVARIABLETerminalRuleCall_1_0()); 
            match(input,RULE_VARIABLE,FOLLOW_2); 
             after(grammarAccess.getLoopAccess().getLoopvarVARIABLETerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__LoopvarAssignment_1"


    // $ANTLR start "rule__Loop__VariableAssignment_3"
    // InternalFactoryLogicLang.g:838:1: rule__Loop__VariableAssignment_3 : ( RULE_VARIABLE ) ;
    public final void rule__Loop__VariableAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:842:1: ( ( RULE_VARIABLE ) )
            // InternalFactoryLogicLang.g:843:2: ( RULE_VARIABLE )
            {
            // InternalFactoryLogicLang.g:843:2: ( RULE_VARIABLE )
            // InternalFactoryLogicLang.g:844:3: RULE_VARIABLE
            {
             before(grammarAccess.getLoopAccess().getVariableVARIABLETerminalRuleCall_3_0()); 
            match(input,RULE_VARIABLE,FOLLOW_2); 
             after(grammarAccess.getLoopAccess().getVariableVARIABLETerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__VariableAssignment_3"


    // $ANTLR start "rule__Loop__STRING1Assignment_4_1"
    // InternalFactoryLogicLang.g:853:1: rule__Loop__STRING1Assignment_4_1 : ( RULE_STRING ) ;
    public final void rule__Loop__STRING1Assignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:857:1: ( ( RULE_STRING ) )
            // InternalFactoryLogicLang.g:858:2: ( RULE_STRING )
            {
            // InternalFactoryLogicLang.g:858:2: ( RULE_STRING )
            // InternalFactoryLogicLang.g:859:3: RULE_STRING
            {
             before(grammarAccess.getLoopAccess().getSTRING1STRINGTerminalRuleCall_4_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getLoopAccess().getSTRING1STRINGTerminalRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__STRING1Assignment_4_1"


    // $ANTLR start "rule__Loop__OperatorAssignment_6"
    // InternalFactoryLogicLang.g:868:1: rule__Loop__OperatorAssignment_6 : ( ruleBOOLEAN_OPERATOR ) ;
    public final void rule__Loop__OperatorAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:872:1: ( ( ruleBOOLEAN_OPERATOR ) )
            // InternalFactoryLogicLang.g:873:2: ( ruleBOOLEAN_OPERATOR )
            {
            // InternalFactoryLogicLang.g:873:2: ( ruleBOOLEAN_OPERATOR )
            // InternalFactoryLogicLang.g:874:3: ruleBOOLEAN_OPERATOR
            {
             before(grammarAccess.getLoopAccess().getOperatorBOOLEAN_OPERATOREnumRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleBOOLEAN_OPERATOR();

            state._fsp--;

             after(grammarAccess.getLoopAccess().getOperatorBOOLEAN_OPERATOREnumRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__OperatorAssignment_6"


    // $ANTLR start "rule__Loop__ComparisonAssignment_7"
    // InternalFactoryLogicLang.g:883:1: rule__Loop__ComparisonAssignment_7 : ( RULE_VARIABLE ) ;
    public final void rule__Loop__ComparisonAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:887:1: ( ( RULE_VARIABLE ) )
            // InternalFactoryLogicLang.g:888:2: ( RULE_VARIABLE )
            {
            // InternalFactoryLogicLang.g:888:2: ( RULE_VARIABLE )
            // InternalFactoryLogicLang.g:889:3: RULE_VARIABLE
            {
             before(grammarAccess.getLoopAccess().getComparisonVARIABLETerminalRuleCall_7_0()); 
            match(input,RULE_VARIABLE,FOLLOW_2); 
             after(grammarAccess.getLoopAccess().getComparisonVARIABLETerminalRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__ComparisonAssignment_7"


    // $ANTLR start "rule__Loop__STRING2Assignment_8_1"
    // InternalFactoryLogicLang.g:898:1: rule__Loop__STRING2Assignment_8_1 : ( RULE_STRING ) ;
    public final void rule__Loop__STRING2Assignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalFactoryLogicLang.g:902:1: ( ( RULE_STRING ) )
            // InternalFactoryLogicLang.g:903:2: ( RULE_STRING )
            {
            // InternalFactoryLogicLang.g:903:2: ( RULE_STRING )
            // InternalFactoryLogicLang.g:904:3: RULE_STRING
            {
             before(grammarAccess.getLoopAccess().getSTRING2STRINGTerminalRuleCall_8_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getLoopAccess().getSTRING2STRINGTerminalRuleCall_8_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__STRING2Assignment_8_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000048002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000007010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000220000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000020L});

}