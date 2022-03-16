package xtext.parser.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalFactoryLogicLangLexer extends Lexer {
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

    public InternalFactoryLogicLangLexer() {;} 
    public InternalFactoryLogicLangLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalFactoryLogicLangLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalFactoryLogicLangLexer.g"; }

    // $ANTLR start "GreaterThan"
    public final void mGreaterThan() throws RecognitionException {
        try {
            int _type = GreaterThan;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:14:13: ( 'greater than' )
            // InternalFactoryLogicLangLexer.g:14:15: 'greater than'
            {
            match("greater than"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GreaterThan"

    // $ANTLR start "LessThan"
    public final void mLessThan() throws RecognitionException {
        try {
            int _type = LessThan;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:16:10: ( 'less than' )
            // InternalFactoryLogicLangLexer.g:16:12: 'less than'
            {
            match("less than"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LessThan"

    // $ANTLR start "Finished"
    public final void mFinished() throws RecognitionException {
        try {
            int _type = Finished;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:18:10: ( 'finished' )
            // InternalFactoryLogicLangLexer.g:18:12: 'finished'
            {
            match("finished"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Finished"

    // $ANTLR start "Position"
    public final void mPosition() throws RecognitionException {
        try {
            int _type = Position;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:20:10: ( 'position' )
            // InternalFactoryLogicLangLexer.g:20:12: 'position'
            {
            match("position"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Position"

    // $ANTLR start "Minutes"
    public final void mMinutes() throws RecognitionException {
        try {
            int _type = Minutes;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:22:9: ( 'minutes' )
            // InternalFactoryLogicLangLexer.g:22:11: 'minutes'
            {
            match("minutes"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Minutes"

    // $ANTLR start "Seconds"
    public final void mSeconds() throws RecognitionException {
        try {
            int _type = Seconds;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:24:9: ( 'seconds' )
            // InternalFactoryLogicLangLexer.g:24:11: 'seconds'
            {
            match("seconds"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Seconds"

    // $ANTLR start "Storage"
    public final void mStorage() throws RecognitionException {
        try {
            int _type = Storage;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:26:9: ( 'storage' )
            // InternalFactoryLogicLangLexer.g:26:11: 'storage'
            {
            match("storage"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Storage"

    // $ANTLR start "Camera"
    public final void mCamera() throws RecognitionException {
        try {
            int _type = Camera;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:28:8: ( 'camera' )
            // InternalFactoryLogicLangLexer.g:28:10: 'camera'
            {
            match("camera"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Camera"

    // $ANTLR start "Create"
    public final void mCreate() throws RecognitionException {
        try {
            int _type = Create;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:30:8: ( 'create' )
            // InternalFactoryLogicLangLexer.g:30:10: 'create'
            {
            match("create"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Create"

    // $ANTLR start "Minute"
    public final void mMinute() throws RecognitionException {
        try {
            int _type = Minute;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:32:8: ( 'minute' )
            // InternalFactoryLogicLangLexer.g:32:10: 'minute'
            {
            match("minute"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Minute"

    // $ANTLR start "Pickup"
    public final void mPickup() throws RecognitionException {
        try {
            int _type = Pickup;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:34:8: ( 'pickup' )
            // InternalFactoryLogicLangLexer.g:34:10: 'pickup'
            {
            match("pickup"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Pickup"

    // $ANTLR start "Second"
    public final void mSecond() throws RecognitionException {
        try {
            int _type = Second;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:36:8: ( 'second' )
            // InternalFactoryLogicLangLexer.g:36:10: 'second'
            {
            match("second"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Second"

    // $ANTLR start "Color"
    public final void mColor() throws RecognitionException {
        try {
            int _type = Color;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:38:7: ( 'color' )
            // InternalFactoryLogicLangLexer.g:38:9: 'color'
            {
            match("color"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Color"

    // $ANTLR start "Crane"
    public final void mCrane() throws RecognitionException {
        try {
            int _type = Crane;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:40:7: ( 'crane' )
            // InternalFactoryLogicLangLexer.g:40:9: 'crane'
            {
            match("crane"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Crane"

    // $ANTLR start "Empty"
    public final void mEmpty() throws RecognitionException {
        try {
            int _type = Empty;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:42:7: ( 'empty' )
            // InternalFactoryLogicLangLexer.g:42:9: 'empty'
            {
            match("empty"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Empty"

    // $ANTLR start "Equal"
    public final void mEqual() throws RecognitionException {
        try {
            int _type = Equal;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:44:7: ( 'equal' )
            // InternalFactoryLogicLangLexer.g:44:9: 'equal'
            {
            match("equal"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Equal"

    // $ANTLR start "Green"
    public final void mGreen() throws RecognitionException {
        try {
            int _type = Green;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:46:7: ( 'green' )
            // InternalFactoryLogicLangLexer.g:46:9: 'green'
            {
            match("green"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Green"

    // $ANTLR start "Hours"
    public final void mHours() throws RecognitionException {
        try {
            int _type = Hours;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:48:7: ( 'hours' )
            // InternalFactoryLogicLangLexer.g:48:9: 'hours'
            {
            match("hours"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Hours"

    // $ANTLR start "Named"
    public final void mNamed() throws RecognitionException {
        try {
            int _type = Named;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:50:7: ( 'named' )
            // InternalFactoryLogicLangLexer.g:50:9: 'named'
            {
            match("named"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Named"

    // $ANTLR start "Slots"
    public final void mSlots() throws RecognitionException {
        try {
            int _type = Slots;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:52:7: ( 'slots' )
            // InternalFactoryLogicLangLexer.g:52:9: 'slots'
            {
            match("slots"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Slots"

    // $ANTLR start "Blue"
    public final void mBlue() throws RecognitionException {
        try {
            int _type = Blue;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:54:6: ( 'blue' )
            // InternalFactoryLogicLangLexer.g:54:8: 'blue'
            {
            match("blue"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Blue"

    // $ANTLR start "Drop"
    public final void mDrop() throws RecognitionException {
        try {
            int _type = Drop;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:56:6: ( 'drop' )
            // InternalFactoryLogicLangLexer.g:56:8: 'drop'
            {
            match("drop"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Drop"

    // $ANTLR start "Each"
    public final void mEach() throws RecognitionException {
        try {
            int _type = Each;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:58:6: ( 'each' )
            // InternalFactoryLogicLangLexer.g:58:8: 'each'
            {
            match("each"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Each"

    // $ANTLR start "Full"
    public final void mFull() throws RecognitionException {
        try {
            int _type = Full;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:60:6: ( 'full' )
            // InternalFactoryLogicLangLexer.g:60:8: 'full'
            {
            match("full"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Full"

    // $ANTLR start "Hour"
    public final void mHour() throws RecognitionException {
        try {
            int _type = Hour;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:62:6: ( 'hour' )
            // InternalFactoryLogicLangLexer.g:62:8: 'hour'
            {
            match("hour"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Hour"

    // $ANTLR start "Into"
    public final void mInto() throws RecognitionException {
        try {
            int _type = Into;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:64:6: ( 'into' )
            // InternalFactoryLogicLangLexer.g:64:8: 'into'
            {
            match("into"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Into"

    // $ANTLR start "Item"
    public final void mItem() throws RecognitionException {
        try {
            int _type = Item;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:66:6: ( 'item' )
            // InternalFactoryLogicLangLexer.g:66:8: 'item'
            {
            match("item"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Item"

    // $ANTLR start "Mark"
    public final void mMark() throws RecognitionException {
        try {
            int _type = Mark;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:68:6: ( 'mark' )
            // InternalFactoryLogicLangLexer.g:68:8: 'mark'
            {
            match("mark"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Mark"

    // $ANTLR start "Move"
    public final void mMove() throws RecognitionException {
        try {
            int _type = Move;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:70:6: ( 'move' )
            // InternalFactoryLogicLangLexer.g:70:8: 'move'
            {
            match("move"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Move"

    // $ANTLR start "Scan"
    public final void mScan() throws RecognitionException {
        try {
            int _type = Scan;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:72:6: ( 'scan' )
            // InternalFactoryLogicLangLexer.g:72:8: 'scan'
            {
            match("scan"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Scan"

    // $ANTLR start "Slot"
    public final void mSlot() throws RecognitionException {
        try {
            int _type = Slot;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:74:6: ( 'slot' )
            // InternalFactoryLogicLangLexer.g:74:8: 'slot'
            {
            match("slot"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Slot"

    // $ANTLR start "That"
    public final void mThat() throws RecognitionException {
        try {
            int _type = That;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:76:6: ( 'that' )
            // InternalFactoryLogicLangLexer.g:76:8: 'that'
            {
            match("that"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "That"

    // $ANTLR start "Then"
    public final void mThen() throws RecognitionException {
        try {
            int _type = Then;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:78:6: ( 'then' )
            // InternalFactoryLogicLangLexer.g:78:8: 'then'
            {
            match("then"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Then"

    // $ANTLR start "With"
    public final void mWith() throws RecognitionException {
        try {
            int _type = With;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:80:6: ( 'with' )
            // InternalFactoryLogicLangLexer.g:80:8: 'with'
            {
            match("with"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "With"

    // $ANTLR start "For"
    public final void mFor() throws RecognitionException {
        try {
            int _type = For;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:82:5: ( 'for' )
            // InternalFactoryLogicLangLexer.g:82:7: 'for'
            {
            match("for"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "For"

    // $ANTLR start "Not"
    public final void mNot() throws RecognitionException {
        try {
            int _type = Not;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:84:5: ( 'not' )
            // InternalFactoryLogicLangLexer.g:84:7: 'not'
            {
            match("not"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Not"

    // $ANTLR start "Red"
    public final void mRed() throws RecognitionException {
        try {
            int _type = Red;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:86:5: ( 'red' )
            // InternalFactoryLogicLangLexer.g:86:7: 'red'
            {
            match("red"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Red"

    // $ANTLR start "As"
    public final void mAs() throws RecognitionException {
        try {
            int _type = As;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:88:4: ( 'as' )
            // InternalFactoryLogicLangLexer.g:88:6: 'as'
            {
            match("as"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "As"

    // $ANTLR start "At"
    public final void mAt() throws RecognitionException {
        try {
            int _type = At;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:90:4: ( 'at' )
            // InternalFactoryLogicLangLexer.g:90:6: 'at'
            {
            match("at"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "At"

    // $ANTLR start "If"
    public final void mIf() throws RecognitionException {
        try {
            int _type = If;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:92:4: ( 'if' )
            // InternalFactoryLogicLangLexer.g:92:6: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "If"

    // $ANTLR start "In"
    public final void mIn() throws RecognitionException {
        try {
            int _type = In;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:94:4: ( 'in' )
            // InternalFactoryLogicLangLexer.g:94:6: 'in'
            {
            match("in"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "In"

    // $ANTLR start "Is"
    public final void mIs() throws RecognitionException {
        try {
            int _type = Is;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:96:4: ( 'is' )
            // InternalFactoryLogicLangLexer.g:96:6: 'is'
            {
            match("is"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Is"

    // $ANTLR start "Of"
    public final void mOf() throws RecognitionException {
        try {
            int _type = Of;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:98:4: ( 'of' )
            // InternalFactoryLogicLangLexer.g:98:6: 'of'
            {
            match("of"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Of"

    // $ANTLR start "To"
    public final void mTo() throws RecognitionException {
        try {
            int _type = To;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:100:4: ( 'to' )
            // InternalFactoryLogicLangLexer.g:100:6: 'to'
            {
            match("to"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "To"

    // $ANTLR start "RULE_BEGIN"
    public final void mRULE_BEGIN() throws RecognitionException {
        try {
            // InternalFactoryLogicLangLexer.g:102:21: ()
            // InternalFactoryLogicLangLexer.g:102:23: 
            {
            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_BEGIN"

    // $ANTLR start "RULE_END"
    public final void mRULE_END() throws RecognitionException {
        try {
            // InternalFactoryLogicLangLexer.g:104:19: ()
            // InternalFactoryLogicLangLexer.g:104:21: 
            {
            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_END"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalFactoryLogicLangLexer.g:106:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalFactoryLogicLangLexer.g:106:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalFactoryLogicLangLexer.g:106:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalFactoryLogicLangLexer.g:106:11: '^'
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

            // InternalFactoryLogicLangLexer.g:106:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalFactoryLogicLangLexer.g:
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
            	    break loop2;
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
            // InternalFactoryLogicLangLexer.g:108:10: ( ( '0' .. '9' )+ )
            // InternalFactoryLogicLangLexer.g:108:12: ( '0' .. '9' )+
            {
            // InternalFactoryLogicLangLexer.g:108:12: ( '0' .. '9' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalFactoryLogicLangLexer.g:108:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
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
            // InternalFactoryLogicLangLexer.g:110:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalFactoryLogicLangLexer.g:110:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalFactoryLogicLangLexer.g:110:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\"') ) {
                alt6=1;
            }
            else if ( (LA6_0=='\'') ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalFactoryLogicLangLexer.g:110:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalFactoryLogicLangLexer.g:110:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop4:
                    do {
                        int alt4=3;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0=='\\') ) {
                            alt4=1;
                        }
                        else if ( ((LA4_0>='\u0000' && LA4_0<='!')||(LA4_0>='#' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFF')) ) {
                            alt4=2;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalFactoryLogicLangLexer.g:110:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalFactoryLogicLangLexer.g:110:28: ~ ( ( '\\\\' | '\"' ) )
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
                    	    break loop4;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalFactoryLogicLangLexer.g:110:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalFactoryLogicLangLexer.g:110:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop5:
                    do {
                        int alt5=3;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0=='\\') ) {
                            alt5=1;
                        }
                        else if ( ((LA5_0>='\u0000' && LA5_0<='&')||(LA5_0>='(' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFF')) ) {
                            alt5=2;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalFactoryLogicLangLexer.g:110:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalFactoryLogicLangLexer.g:110:61: ~ ( ( '\\\\' | '\\'' ) )
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
                    	    break loop5;
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
            // InternalFactoryLogicLangLexer.g:112:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalFactoryLogicLangLexer.g:112:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalFactoryLogicLangLexer.g:112:24: ( options {greedy=false; } : . )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='*') ) {
                    int LA7_1 = input.LA(2);

                    if ( (LA7_1=='/') ) {
                        alt7=2;
                    }
                    else if ( ((LA7_1>='\u0000' && LA7_1<='.')||(LA7_1>='0' && LA7_1<='\uFFFF')) ) {
                        alt7=1;
                    }


                }
                else if ( ((LA7_0>='\u0000' && LA7_0<=')')||(LA7_0>='+' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalFactoryLogicLangLexer.g:112:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop7;
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
            // InternalFactoryLogicLangLexer.g:114:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalFactoryLogicLangLexer.g:114:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalFactoryLogicLangLexer.g:114:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalFactoryLogicLangLexer.g:114:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop8;
                }
            } while (true);

            // InternalFactoryLogicLangLexer.g:114:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalFactoryLogicLangLexer.g:114:41: ( '\\r' )? '\\n'
                    {
                    // InternalFactoryLogicLangLexer.g:114:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalFactoryLogicLangLexer.g:114:41: '\\r'
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
            // InternalFactoryLogicLangLexer.g:116:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalFactoryLogicLangLexer.g:116:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalFactoryLogicLangLexer.g:116:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\t' && LA11_0<='\n')||LA11_0=='\r'||LA11_0==' ') ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalFactoryLogicLangLexer.g:
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
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
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
            // InternalFactoryLogicLangLexer.g:118:16: ( . )
            // InternalFactoryLogicLangLexer.g:118:18: .
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
        // InternalFactoryLogicLangLexer.g:1:8: ( GreaterThan | LessThan | Finished | Position | Minutes | Seconds | Storage | Camera | Create | Minute | Pickup | Second | Color | Crane | Empty | Equal | Green | Hours | Named | Slots | Blue | Drop | Each | Full | Hour | Into | Item | Mark | Move | Scan | Slot | That | Then | With | For | Not | Red | As | At | If | In | Is | Of | To | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=51;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // InternalFactoryLogicLangLexer.g:1:10: GreaterThan
                {
                mGreaterThan(); 

                }
                break;
            case 2 :
                // InternalFactoryLogicLangLexer.g:1:22: LessThan
                {
                mLessThan(); 

                }
                break;
            case 3 :
                // InternalFactoryLogicLangLexer.g:1:31: Finished
                {
                mFinished(); 

                }
                break;
            case 4 :
                // InternalFactoryLogicLangLexer.g:1:40: Position
                {
                mPosition(); 

                }
                break;
            case 5 :
                // InternalFactoryLogicLangLexer.g:1:49: Minutes
                {
                mMinutes(); 

                }
                break;
            case 6 :
                // InternalFactoryLogicLangLexer.g:1:57: Seconds
                {
                mSeconds(); 

                }
                break;
            case 7 :
                // InternalFactoryLogicLangLexer.g:1:65: Storage
                {
                mStorage(); 

                }
                break;
            case 8 :
                // InternalFactoryLogicLangLexer.g:1:73: Camera
                {
                mCamera(); 

                }
                break;
            case 9 :
                // InternalFactoryLogicLangLexer.g:1:80: Create
                {
                mCreate(); 

                }
                break;
            case 10 :
                // InternalFactoryLogicLangLexer.g:1:87: Minute
                {
                mMinute(); 

                }
                break;
            case 11 :
                // InternalFactoryLogicLangLexer.g:1:94: Pickup
                {
                mPickup(); 

                }
                break;
            case 12 :
                // InternalFactoryLogicLangLexer.g:1:101: Second
                {
                mSecond(); 

                }
                break;
            case 13 :
                // InternalFactoryLogicLangLexer.g:1:108: Color
                {
                mColor(); 

                }
                break;
            case 14 :
                // InternalFactoryLogicLangLexer.g:1:114: Crane
                {
                mCrane(); 

                }
                break;
            case 15 :
                // InternalFactoryLogicLangLexer.g:1:120: Empty
                {
                mEmpty(); 

                }
                break;
            case 16 :
                // InternalFactoryLogicLangLexer.g:1:126: Equal
                {
                mEqual(); 

                }
                break;
            case 17 :
                // InternalFactoryLogicLangLexer.g:1:132: Green
                {
                mGreen(); 

                }
                break;
            case 18 :
                // InternalFactoryLogicLangLexer.g:1:138: Hours
                {
                mHours(); 

                }
                break;
            case 19 :
                // InternalFactoryLogicLangLexer.g:1:144: Named
                {
                mNamed(); 

                }
                break;
            case 20 :
                // InternalFactoryLogicLangLexer.g:1:150: Slots
                {
                mSlots(); 

                }
                break;
            case 21 :
                // InternalFactoryLogicLangLexer.g:1:156: Blue
                {
                mBlue(); 

                }
                break;
            case 22 :
                // InternalFactoryLogicLangLexer.g:1:161: Drop
                {
                mDrop(); 

                }
                break;
            case 23 :
                // InternalFactoryLogicLangLexer.g:1:166: Each
                {
                mEach(); 

                }
                break;
            case 24 :
                // InternalFactoryLogicLangLexer.g:1:171: Full
                {
                mFull(); 

                }
                break;
            case 25 :
                // InternalFactoryLogicLangLexer.g:1:176: Hour
                {
                mHour(); 

                }
                break;
            case 26 :
                // InternalFactoryLogicLangLexer.g:1:181: Into
                {
                mInto(); 

                }
                break;
            case 27 :
                // InternalFactoryLogicLangLexer.g:1:186: Item
                {
                mItem(); 

                }
                break;
            case 28 :
                // InternalFactoryLogicLangLexer.g:1:191: Mark
                {
                mMark(); 

                }
                break;
            case 29 :
                // InternalFactoryLogicLangLexer.g:1:196: Move
                {
                mMove(); 

                }
                break;
            case 30 :
                // InternalFactoryLogicLangLexer.g:1:201: Scan
                {
                mScan(); 

                }
                break;
            case 31 :
                // InternalFactoryLogicLangLexer.g:1:206: Slot
                {
                mSlot(); 

                }
                break;
            case 32 :
                // InternalFactoryLogicLangLexer.g:1:211: That
                {
                mThat(); 

                }
                break;
            case 33 :
                // InternalFactoryLogicLangLexer.g:1:216: Then
                {
                mThen(); 

                }
                break;
            case 34 :
                // InternalFactoryLogicLangLexer.g:1:221: With
                {
                mWith(); 

                }
                break;
            case 35 :
                // InternalFactoryLogicLangLexer.g:1:226: For
                {
                mFor(); 

                }
                break;
            case 36 :
                // InternalFactoryLogicLangLexer.g:1:230: Not
                {
                mNot(); 

                }
                break;
            case 37 :
                // InternalFactoryLogicLangLexer.g:1:234: Red
                {
                mRed(); 

                }
                break;
            case 38 :
                // InternalFactoryLogicLangLexer.g:1:238: As
                {
                mAs(); 

                }
                break;
            case 39 :
                // InternalFactoryLogicLangLexer.g:1:241: At
                {
                mAt(); 

                }
                break;
            case 40 :
                // InternalFactoryLogicLangLexer.g:1:244: If
                {
                mIf(); 

                }
                break;
            case 41 :
                // InternalFactoryLogicLangLexer.g:1:247: In
                {
                mIn(); 

                }
                break;
            case 42 :
                // InternalFactoryLogicLangLexer.g:1:250: Is
                {
                mIs(); 

                }
                break;
            case 43 :
                // InternalFactoryLogicLangLexer.g:1:253: Of
                {
                mOf(); 

                }
                break;
            case 44 :
                // InternalFactoryLogicLangLexer.g:1:256: To
                {
                mTo(); 

                }
                break;
            case 45 :
                // InternalFactoryLogicLangLexer.g:1:259: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 46 :
                // InternalFactoryLogicLangLexer.g:1:267: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 47 :
                // InternalFactoryLogicLangLexer.g:1:276: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 48 :
                // InternalFactoryLogicLangLexer.g:1:288: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 49 :
                // InternalFactoryLogicLangLexer.g:1:304: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 50 :
                // InternalFactoryLogicLangLexer.g:1:320: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 51 :
                // InternalFactoryLogicLangLexer.g:1:328: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\22\34\1\32\2\uffff\3\32\2\uffff\1\34\1\uffff\30\34\1\140\1\34\1\142\1\143\1\34\1\146\2\34\1\151\1\152\1\153\5\uffff\4\34\1\161\22\34\1\u0084\3\34\1\uffff\1\34\2\uffff\2\34\1\uffff\1\34\1\u008c\3\uffff\4\34\1\u0091\1\uffff\3\34\1\u0095\1\u0096\2\34\1\u009a\1\u009b\6\34\1\u00a2\1\u00a4\1\34\1\uffff\1\u00a6\1\u00a7\1\u00a8\1\u00a9\1\u00aa\1\u00ab\1\u00ac\1\uffff\1\34\1\u00ae\1\uffff\1\34\1\uffff\3\34\2\uffff\2\34\1\u00b5\2\uffff\2\34\1\u00b8\1\u00b9\1\u00ba\1\u00bb\1\uffff\1\u00bc\1\uffff\1\u00bd\7\uffff\1\34\1\uffff\2\34\1\u00c1\1\u00c3\1\u00c5\1\34\1\uffff\1\u00c7\1\u00c8\6\uffff\3\34\1\uffff\1\u00cc\1\uffff\1\u00cd\1\uffff\1\u00ce\3\uffff\1\u00cf\1\u00d0\5\uffff";
    static final String DFA12_eofS =
        "\u00d1\uffff";
    static final String DFA12_minS =
        "\1\0\1\162\1\145\2\151\1\141\1\143\2\141\1\157\1\141\1\154\1\162\1\146\1\150\1\151\1\145\1\163\1\146\1\101\2\uffff\2\0\1\52\2\uffff\1\145\1\uffff\1\163\1\156\1\154\1\162\1\163\1\143\1\156\1\162\1\166\1\143\2\157\1\141\1\155\1\141\1\154\1\160\1\165\1\143\1\165\1\155\1\164\1\165\1\157\1\60\1\145\2\60\1\141\1\60\1\164\1\144\3\60\5\uffff\1\141\1\163\1\151\1\154\1\60\1\151\1\153\1\165\1\153\1\145\1\157\1\162\1\164\1\156\1\145\1\141\1\156\1\157\1\164\1\141\1\150\1\162\1\145\1\60\1\145\1\160\1\157\1\uffff\1\155\2\uffff\1\164\1\156\1\uffff\1\150\1\60\3\uffff\1\164\1\156\1\40\1\163\1\60\1\uffff\1\164\1\165\1\164\2\60\1\156\1\141\2\60\1\162\1\164\1\145\1\162\1\171\1\154\2\60\1\144\1\uffff\7\60\1\uffff\1\145\1\60\1\uffff\1\150\1\uffff\1\151\1\160\1\145\2\uffff\1\144\1\147\1\60\2\uffff\1\141\1\145\4\60\1\uffff\1\60\1\uffff\1\60\7\uffff\1\162\1\uffff\1\145\1\157\3\60\1\145\1\uffff\2\60\6\uffff\1\40\1\144\1\156\1\uffff\1\60\1\uffff\1\60\1\uffff\1\60\3\uffff\2\60\5\uffff";
    static final String DFA12_maxS =
        "\1\uffff\1\162\1\145\1\165\2\157\1\164\1\162\1\161\2\157\1\154\1\162\1\164\1\157\1\151\1\145\1\164\1\146\1\172\2\uffff\2\uffff\1\57\2\uffff\1\145\1\uffff\1\163\1\156\1\154\1\162\1\163\1\143\1\156\1\162\1\166\1\143\2\157\1\141\1\155\1\145\1\154\1\160\1\165\1\143\1\165\1\155\1\164\1\165\1\157\1\172\1\145\2\172\1\145\1\172\1\164\1\144\3\172\5\uffff\1\145\1\163\1\151\1\154\1\172\1\151\1\153\1\165\1\153\1\145\1\157\1\162\1\164\1\156\1\145\1\141\1\156\1\157\1\164\1\141\1\150\1\162\1\145\1\172\1\145\1\160\1\157\1\uffff\1\155\2\uffff\1\164\1\156\1\uffff\1\150\1\172\3\uffff\1\164\1\156\1\40\1\163\1\172\1\uffff\1\164\1\165\1\164\2\172\1\156\1\141\2\172\1\162\1\164\1\145\1\162\1\171\1\154\2\172\1\144\1\uffff\7\172\1\uffff\1\145\1\172\1\uffff\1\150\1\uffff\1\151\1\160\1\145\2\uffff\1\144\1\147\1\172\2\uffff\1\141\1\145\4\172\1\uffff\1\172\1\uffff\1\172\7\uffff\1\162\1\uffff\1\145\1\157\3\172\1\145\1\uffff\2\172\6\uffff\1\40\1\144\1\156\1\uffff\1\172\1\uffff\1\172\1\uffff\1\172\3\uffff\2\172\5\uffff";
    static final String DFA12_acceptS =
        "\24\uffff\1\55\1\56\3\uffff\1\62\1\63\1\uffff\1\55\43\uffff\1\56\1\57\1\60\1\61\1\62\33\uffff\1\51\1\uffff\1\50\1\52\2\uffff\1\54\2\uffff\1\46\1\47\1\53\5\uffff\1\43\22\uffff\1\44\7\uffff\1\45\2\uffff\1\2\1\uffff\1\30\3\uffff\1\34\1\35\3\uffff\1\37\1\36\6\uffff\1\27\1\uffff\1\31\1\uffff\1\25\1\26\1\32\1\33\1\40\1\41\1\42\1\uffff\1\21\6\uffff\1\24\2\uffff\1\16\1\15\1\17\1\20\1\22\1\23\3\uffff\1\13\1\uffff\1\12\1\uffff\1\14\1\uffff\1\10\1\11\1\1\2\uffff\1\5\1\6\1\7\1\3\1\4";
    static final String DFA12_specialS =
        "\1\1\25\uffff\1\2\1\0\u00b9\uffff}>";
    static final String[] DFA12_transitionS = {
            "\11\32\2\31\2\32\1\31\22\32\1\31\1\32\1\26\4\32\1\27\7\32\1\30\12\25\7\32\32\24\3\32\1\23\1\24\1\32\1\21\1\13\1\7\1\14\1\10\1\3\1\1\1\11\1\15\2\24\1\2\1\5\1\12\1\22\1\4\1\24\1\20\1\6\1\16\2\24\1\17\3\24\uff85\32",
            "\1\33",
            "\1\35",
            "\1\36\5\uffff\1\40\5\uffff\1\37",
            "\1\42\5\uffff\1\41",
            "\1\44\7\uffff\1\43\5\uffff\1\45",
            "\1\51\1\uffff\1\46\6\uffff\1\50\7\uffff\1\47",
            "\1\52\15\uffff\1\54\2\uffff\1\53",
            "\1\57\13\uffff\1\55\3\uffff\1\56",
            "\1\60",
            "\1\61\15\uffff\1\62",
            "\1\63",
            "\1\64",
            "\1\67\7\uffff\1\65\4\uffff\1\70\1\66",
            "\1\71\6\uffff\1\72",
            "\1\73",
            "\1\74",
            "\1\75\1\76",
            "\1\77",
            "\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "",
            "\0\101",
            "\0\101",
            "\1\102\4\uffff\1\103",
            "",
            "",
            "\1\105",
            "",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\114",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\125\3\uffff\1\124",
            "\1\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\23\34\1\137\6\34",
            "\1\141",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\144\3\uffff\1\145",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\147",
            "\1\150",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "",
            "",
            "",
            "",
            "\1\154\3\uffff\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\175",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "",
            "\1\u0088",
            "",
            "",
            "\1\u0089",
            "\1\u008a",
            "",
            "\1\u008b",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "",
            "",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\u0097",
            "\1\u0098",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\22\34\1\u0099\7\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\22\34\1\u00a3\7\34",
            "\1\u00a5",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "\1\u00ad",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "\1\u00af",
            "",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "",
            "",
            "\1\u00b3",
            "\1\u00b4",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "",
            "\1\u00b6",
            "\1\u00b7",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00be",
            "",
            "\1\u00bf",
            "\1\u00c0",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\22\34\1\u00c2\7\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\22\34\1\u00c4\7\34",
            "\1\u00c6",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00c9",
            "\1\u00ca",
            "\1\u00cb",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( GreaterThan | LessThan | Finished | Position | Minutes | Seconds | Storage | Camera | Create | Minute | Pickup | Second | Color | Crane | Empty | Equal | Green | Hours | Named | Slots | Blue | Drop | Each | Full | Hour | Into | Item | Mark | Move | Scan | Slot | That | Then | With | For | Not | Red | As | At | If | In | Is | Of | To | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_23 = input.LA(1);

                        s = -1;
                        if ( ((LA12_23>='\u0000' && LA12_23<='\uFFFF')) ) {s = 65;}

                        else s = 26;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_0 = input.LA(1);

                        s = -1;
                        if ( (LA12_0=='g') ) {s = 1;}

                        else if ( (LA12_0=='l') ) {s = 2;}

                        else if ( (LA12_0=='f') ) {s = 3;}

                        else if ( (LA12_0=='p') ) {s = 4;}

                        else if ( (LA12_0=='m') ) {s = 5;}

                        else if ( (LA12_0=='s') ) {s = 6;}

                        else if ( (LA12_0=='c') ) {s = 7;}

                        else if ( (LA12_0=='e') ) {s = 8;}

                        else if ( (LA12_0=='h') ) {s = 9;}

                        else if ( (LA12_0=='n') ) {s = 10;}

                        else if ( (LA12_0=='b') ) {s = 11;}

                        else if ( (LA12_0=='d') ) {s = 12;}

                        else if ( (LA12_0=='i') ) {s = 13;}

                        else if ( (LA12_0=='t') ) {s = 14;}

                        else if ( (LA12_0=='w') ) {s = 15;}

                        else if ( (LA12_0=='r') ) {s = 16;}

                        else if ( (LA12_0=='a') ) {s = 17;}

                        else if ( (LA12_0=='o') ) {s = 18;}

                        else if ( (LA12_0=='^') ) {s = 19;}

                        else if ( ((LA12_0>='A' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='j' && LA12_0<='k')||LA12_0=='q'||(LA12_0>='u' && LA12_0<='v')||(LA12_0>='x' && LA12_0<='z')) ) {s = 20;}

                        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {s = 21;}

                        else if ( (LA12_0=='\"') ) {s = 22;}

                        else if ( (LA12_0=='\'') ) {s = 23;}

                        else if ( (LA12_0=='/') ) {s = 24;}

                        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {s = 25;}

                        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||(LA12_0>='#' && LA12_0<='&')||(LA12_0>='(' && LA12_0<='.')||(LA12_0>=':' && LA12_0<='@')||(LA12_0>='[' && LA12_0<=']')||LA12_0=='`'||(LA12_0>='{' && LA12_0<='\uFFFF')) ) {s = 26;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA12_22 = input.LA(1);

                        s = -1;
                        if ( ((LA12_22>='\u0000' && LA12_22<='\uFFFF')) ) {s = 65;}

                        else s = 26;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 12, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}