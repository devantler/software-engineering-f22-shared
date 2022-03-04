package xtext.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalFactoryLogicLangLexer extends Lexer {
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

    public InternalFactoryLogicLangLexer() {;} 
    public InternalFactoryLogicLangLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalFactoryLogicLangLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalFactoryLogicLang.g"; }

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLang.g:11:7: ( 'not' )
            // InternalFactoryLogicLang.g:11:9: 'not'
            {
            match("not"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLang.g:12:7: ( 'less than' )
            // InternalFactoryLogicLang.g:12:9: 'less than'
            {
            match("less than"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLang.g:13:7: ( 'greater than' )
            // InternalFactoryLogicLang.g:13:9: 'greater than'
            {
            match("greater than"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLang.g:14:7: ( 'if' )
            // InternalFactoryLogicLang.g:14:9: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLang.g:15:7: ( 'is' )
            // InternalFactoryLogicLang.g:15:9: 'is'
            {
            match("is"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLang.g:16:7: ( 'then' )
            // InternalFactoryLogicLang.g:16:9: 'then'
            {
            match("then"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLang.g:17:7: ( 'for each' )
            // InternalFactoryLogicLang.g:17:9: 'for each'
            {
            match("for each"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLang.g:18:7: ( 'in' )
            // InternalFactoryLogicLang.g:18:9: 'in'
            {
            match("in"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLang.g:19:7: ( 'that is' )
            // InternalFactoryLogicLang.g:19:9: 'that is'
            {
            match("that is"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLang.g:20:7: ( 'of' )
            // InternalFactoryLogicLang.g:20:9: 'of'
            {
            match("of"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "RULE_VARIABLE"
    public final void mRULE_VARIABLE() throws RecognitionException {
        try {
            int _type = RULE_VARIABLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLang.g:913:15: ( ( 'a' .. 'z' | 'A' .. 'Z' )+ )
            // InternalFactoryLogicLang.g:913:17: ( 'a' .. 'z' | 'A' .. 'Z' )+
            {
            // InternalFactoryLogicLang.g:913:17: ( 'a' .. 'z' | 'A' .. 'Z' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='A' && LA1_0<='Z')||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalFactoryLogicLang.g:
            	    {
            	    if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_VARIABLE"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLang.g:915:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalFactoryLogicLang.g:915:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalFactoryLogicLang.g:915:11: ( '^' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='^') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalFactoryLogicLang.g:915:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalFactoryLogicLang.g:915:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalFactoryLogicLang.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLang.g:917:10: ( ( '0' .. '9' )+ )
            // InternalFactoryLogicLang.g:917:12: ( '0' .. '9' )+
            {
            // InternalFactoryLogicLang.g:917:12: ( '0' .. '9' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalFactoryLogicLang.g:917:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLang.g:919:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalFactoryLogicLang.g:919:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalFactoryLogicLang.g:919:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='\"') ) {
                alt7=1;
            }
            else if ( (LA7_0=='\'') ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalFactoryLogicLang.g:919:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalFactoryLogicLang.g:919:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop5:
                    do {
                        int alt5=3;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0=='\\') ) {
                            alt5=1;
                        }
                        else if ( ((LA5_0>='\u0000' && LA5_0<='!')||(LA5_0>='#' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFF')) ) {
                            alt5=2;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalFactoryLogicLang.g:919:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalFactoryLogicLang.g:919:28: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalFactoryLogicLang.g:919:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalFactoryLogicLang.g:919:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop6:
                    do {
                        int alt6=3;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0=='\\') ) {
                            alt6=1;
                        }
                        else if ( ((LA6_0>='\u0000' && LA6_0<='&')||(LA6_0>='(' && LA6_0<='[')||(LA6_0>=']' && LA6_0<='\uFFFF')) ) {
                            alt6=2;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalFactoryLogicLang.g:919:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalFactoryLogicLang.g:919:61: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLang.g:921:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalFactoryLogicLang.g:921:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalFactoryLogicLang.g:921:24: ( options {greedy=false; } : . )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='*') ) {
                    int LA8_1 = input.LA(2);

                    if ( (LA8_1=='/') ) {
                        alt8=2;
                    }
                    else if ( ((LA8_1>='\u0000' && LA8_1<='.')||(LA8_1>='0' && LA8_1<='\uFFFF')) ) {
                        alt8=1;
                    }


                }
                else if ( ((LA8_0>='\u0000' && LA8_0<=')')||(LA8_0>='+' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalFactoryLogicLang.g:921:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLang.g:923:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalFactoryLogicLang.g:923:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalFactoryLogicLang.g:923:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='\u0000' && LA9_0<='\t')||(LA9_0>='\u000B' && LA9_0<='\f')||(LA9_0>='\u000E' && LA9_0<='\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalFactoryLogicLang.g:923:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            // InternalFactoryLogicLang.g:923:40: ( ( '\\r' )? '\\n' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='\n'||LA11_0=='\r') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalFactoryLogicLang.g:923:41: ( '\\r' )? '\\n'
                    {
                    // InternalFactoryLogicLang.g:923:41: ( '\\r' )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0=='\r') ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // InternalFactoryLogicLang.g:923:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLang.g:925:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalFactoryLogicLang.g:925:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalFactoryLogicLang.g:925:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalFactoryLogicLang.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLang.g:927:16: ( . )
            // InternalFactoryLogicLang.g:927:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // InternalFactoryLogicLang.g:1:8: ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | RULE_VARIABLE | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt13=18;
        alt13 = dfa13.predict(input);
        switch (alt13) {
            case 1 :
                // InternalFactoryLogicLang.g:1:10: T__12
                {
                mT__12(); 

                }
                break;
            case 2 :
                // InternalFactoryLogicLang.g:1:16: T__13
                {
                mT__13(); 

                }
                break;
            case 3 :
                // InternalFactoryLogicLang.g:1:22: T__14
                {
                mT__14(); 

                }
                break;
            case 4 :
                // InternalFactoryLogicLang.g:1:28: T__15
                {
                mT__15(); 

                }
                break;
            case 5 :
                // InternalFactoryLogicLang.g:1:34: T__16
                {
                mT__16(); 

                }
                break;
            case 6 :
                // InternalFactoryLogicLang.g:1:40: T__17
                {
                mT__17(); 

                }
                break;
            case 7 :
                // InternalFactoryLogicLang.g:1:46: T__18
                {
                mT__18(); 

                }
                break;
            case 8 :
                // InternalFactoryLogicLang.g:1:52: T__19
                {
                mT__19(); 

                }
                break;
            case 9 :
                // InternalFactoryLogicLang.g:1:58: T__20
                {
                mT__20(); 

                }
                break;
            case 10 :
                // InternalFactoryLogicLang.g:1:64: T__21
                {
                mT__21(); 

                }
                break;
            case 11 :
                // InternalFactoryLogicLang.g:1:70: RULE_VARIABLE
                {
                mRULE_VARIABLE(); 

                }
                break;
            case 12 :
                // InternalFactoryLogicLang.g:1:84: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 13 :
                // InternalFactoryLogicLang.g:1:92: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 14 :
                // InternalFactoryLogicLang.g:1:101: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 15 :
                // InternalFactoryLogicLang.g:1:113: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 16 :
                // InternalFactoryLogicLang.g:1:129: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 17 :
                // InternalFactoryLogicLang.g:1:145: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 18 :
                // InternalFactoryLogicLang.g:1:153: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA13 dfa13 = new DFA13(this);
    static final String DFA13_eotS =
        "\1\uffff\10\22\1\20\2\uffff\3\20\2\uffff\1\22\1\uffff\1\22\1\uffff\2\22\1\45\1\46\1\47\2\22\1\53\5\uffff\1\54\2\22\3\uffff\3\22\2\uffff\2\22\1\64\1\22\2\uffff\1\22\2\uffff\2\22\1\uffff";
    static final String DFA13_eofS =
        "\71\uffff";
    static final String DFA13_minS =
        "\1\0\10\60\1\101\2\uffff\2\0\1\52\2\uffff\1\60\1\uffff\1\60\1\uffff\10\60\5\uffff\3\60\3\uffff\2\60\1\40\2\uffff\1\40\2\60\1\40\2\uffff\1\60\2\uffff\1\60\1\40\1\uffff";
    static final String DFA13_maxS =
        "\1\uffff\11\172\2\uffff\2\uffff\1\57\2\uffff\1\172\1\uffff\1\172\1\uffff\10\172\5\uffff\3\172\3\uffff\3\172\2\uffff\4\172\2\uffff\1\172\2\uffff\2\172\1\uffff";
    static final String DFA13_acceptS =
        "\12\uffff\1\14\1\15\3\uffff\1\21\1\22\1\uffff\1\13\1\uffff\1\14\10\uffff\1\15\1\16\1\17\1\20\1\21\3\uffff\1\4\1\5\1\10\3\uffff\1\12\1\1\4\uffff\1\7\1\2\1\uffff\1\6\1\11\2\uffff\1\3";
    static final String DFA13_specialS =
        "\1\2\13\uffff\1\0\1\1\53\uffff}>";
    static final String[] DFA13_transitionS = {
            "\11\20\2\17\2\20\1\17\22\20\1\17\1\20\1\14\4\20\1\15\7\20\1\16\12\13\7\20\32\10\3\20\1\11\1\12\1\20\5\10\1\6\1\3\1\10\1\4\2\10\1\2\1\10\1\1\1\7\4\10\1\5\6\10\uff85\20",
            "\12\24\7\uffff\32\23\4\uffff\1\24\1\uffff\16\23\1\21\13\23",
            "\12\24\7\uffff\32\23\4\uffff\1\24\1\uffff\4\23\1\25\25\23",
            "\12\24\7\uffff\32\23\4\uffff\1\24\1\uffff\21\23\1\26\10\23",
            "\12\24\7\uffff\32\23\4\uffff\1\24\1\uffff\5\23\1\27\7\23\1\31\4\23\1\30\7\23",
            "\12\24\7\uffff\32\23\4\uffff\1\24\1\uffff\7\23\1\32\22\23",
            "\12\24\7\uffff\32\23\4\uffff\1\24\1\uffff\16\23\1\33\13\23",
            "\12\24\7\uffff\32\23\4\uffff\1\24\1\uffff\5\23\1\34\24\23",
            "\12\24\7\uffff\32\23\4\uffff\1\24\1\uffff\32\23",
            "\32\24\4\uffff\1\24\1\uffff\32\24",
            "",
            "",
            "\0\36",
            "\0\36",
            "\1\37\4\uffff\1\40",
            "",
            "",
            "\12\24\7\uffff\32\23\4\uffff\1\24\1\uffff\23\23\1\42\6\23",
            "",
            "\12\24\7\uffff\32\23\4\uffff\1\24\1\uffff\32\23",
            "",
            "\12\24\7\uffff\32\23\4\uffff\1\24\1\uffff\22\23\1\43\7\23",
            "\12\24\7\uffff\32\23\4\uffff\1\24\1\uffff\4\23\1\44\25\23",
            "\12\24\7\uffff\32\23\4\uffff\1\24\1\uffff\32\23",
            "\12\24\7\uffff\32\23\4\uffff\1\24\1\uffff\32\23",
            "\12\24\7\uffff\32\23\4\uffff\1\24\1\uffff\32\23",
            "\12\24\7\uffff\32\23\4\uffff\1\24\1\uffff\1\51\3\23\1\50\25\23",
            "\12\24\7\uffff\32\23\4\uffff\1\24\1\uffff\21\23\1\52\10\23",
            "\12\24\7\uffff\32\23\4\uffff\1\24\1\uffff\32\23",
            "",
            "",
            "",
            "",
            "",
            "\12\24\7\uffff\32\23\4\uffff\1\24\1\uffff\32\23",
            "\12\24\7\uffff\32\23\4\uffff\1\24\1\uffff\22\23\1\55\7\23",
            "\12\24\7\uffff\32\23\4\uffff\1\24\1\uffff\1\56\31\23",
            "",
            "",
            "",
            "\12\24\7\uffff\32\23\4\uffff\1\24\1\uffff\15\23\1\57\14\23",
            "\12\24\7\uffff\32\23\4\uffff\1\24\1\uffff\23\23\1\60\6\23",
            "\1\61\17\uffff\12\24\7\uffff\32\23\4\uffff\1\24\1\uffff\32\23",
            "",
            "",
            "\1\62\17\uffff\12\24\7\uffff\32\23\4\uffff\1\24\1\uffff\32\23",
            "\12\24\7\uffff\32\23\4\uffff\1\24\1\uffff\23\23\1\63\6\23",
            "\12\24\7\uffff\32\23\4\uffff\1\24\1\uffff\32\23",
            "\1\65\17\uffff\12\24\7\uffff\32\23\4\uffff\1\24\1\uffff\32\23",
            "",
            "",
            "\12\24\7\uffff\32\23\4\uffff\1\24\1\uffff\4\23\1\66\25\23",
            "",
            "",
            "\12\24\7\uffff\32\23\4\uffff\1\24\1\uffff\21\23\1\67\10\23",
            "\1\70\17\uffff\12\24\7\uffff\32\23\4\uffff\1\24\1\uffff\32\23",
            ""
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | RULE_VARIABLE | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA13_12 = input.LA(1);

                        s = -1;
                        if ( ((LA13_12>='\u0000' && LA13_12<='\uFFFF')) ) {s = 30;}

                        else s = 16;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA13_13 = input.LA(1);

                        s = -1;
                        if ( ((LA13_13>='\u0000' && LA13_13<='\uFFFF')) ) {s = 30;}

                        else s = 16;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA13_0 = input.LA(1);

                        s = -1;
                        if ( (LA13_0=='n') ) {s = 1;}

                        else if ( (LA13_0=='l') ) {s = 2;}

                        else if ( (LA13_0=='g') ) {s = 3;}

                        else if ( (LA13_0=='i') ) {s = 4;}

                        else if ( (LA13_0=='t') ) {s = 5;}

                        else if ( (LA13_0=='f') ) {s = 6;}

                        else if ( (LA13_0=='o') ) {s = 7;}

                        else if ( ((LA13_0>='A' && LA13_0<='Z')||(LA13_0>='a' && LA13_0<='e')||LA13_0=='h'||(LA13_0>='j' && LA13_0<='k')||LA13_0=='m'||(LA13_0>='p' && LA13_0<='s')||(LA13_0>='u' && LA13_0<='z')) ) {s = 8;}

                        else if ( (LA13_0=='^') ) {s = 9;}

                        else if ( (LA13_0=='_') ) {s = 10;}

                        else if ( ((LA13_0>='0' && LA13_0<='9')) ) {s = 11;}

                        else if ( (LA13_0=='\"') ) {s = 12;}

                        else if ( (LA13_0=='\'') ) {s = 13;}

                        else if ( (LA13_0=='/') ) {s = 14;}

                        else if ( ((LA13_0>='\t' && LA13_0<='\n')||LA13_0=='\r'||LA13_0==' ') ) {s = 15;}

                        else if ( ((LA13_0>='\u0000' && LA13_0<='\b')||(LA13_0>='\u000B' && LA13_0<='\f')||(LA13_0>='\u000E' && LA13_0<='\u001F')||LA13_0=='!'||(LA13_0>='#' && LA13_0<='&')||(LA13_0>='(' && LA13_0<='.')||(LA13_0>=':' && LA13_0<='@')||(LA13_0>='[' && LA13_0<=']')||LA13_0=='`'||(LA13_0>='{' && LA13_0<='\uFFFF')) ) {s = 16;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 13, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}