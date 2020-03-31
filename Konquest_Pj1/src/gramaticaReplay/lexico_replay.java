/* The following code was generated by JFlex 1.7.0 */
package gramaticaReplay;

import classes.ErrorLexico;
import java.util.ArrayList;
import java_cup.runtime.Symbol;

/**
 * This class is a scanner generated by
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0 from the specification file
 * <tt>src/gramaticaReplay/lexico_replay.jflex</tt>
 */
public class lexico_replay implements java_cup.runtime.Scanner {

    /**
     * This character denotes the end of file
     */
    public static final int YYEOF = -1;

    /**
     * initial size of the lookahead buffer
     */
    private static final int ZZ_BUFFERSIZE = 16384;

    /**
     * lexical states
     */
    public static final int YYINITIAL = 0;

    /**
     * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
     * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l at the
     * beginning of a line l is of the form l = 2*k, k a non negative integer
     */
    private static final int ZZ_LEXSTATE[] = {
        0, 0
    };

    /**
     * Translates characters to character classes
     */
    private static final String ZZ_CMAP_PACKED
            = "\11\0\1\41\1\41\1\42\1\42\1\42\22\0\1\41\1\0\1\36"
            + "\1\0\1\1\7\0\1\14\1\1\2\0\1\2\11\2\1\15\6\0"
            + "\23\1\1\33\6\1\1\10\1\1\1\11\1\1\1\1\1\1\1\16"
            + "\1\24\1\31\1\22\1\20\1\35\1\25\1\1\1\30\2\1\1\26"
            + "\1\23\1\6\1\7\1\32\1\34\1\5\1\21\1\3\1\4\1\17"
            + "\1\1\1\27\2\1\1\12\1\0\1\13\7\0\1\42\u1f96\0\1\37"
            + "\1\40\12\0\1\42\1\42\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\udfe6\0";

    /**
     * Translates characters to character classes
     */
    private static final char[] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

    /**
     * Translates DFA states to action switch labels.
     */
    private static final int[] ZZ_ACTION = zzUnpackAction();

    private static final String ZZ_ACTION_PACKED_0
            = "\1\0\1\1\1\2\1\3\3\2\1\4\1\5\1\6"
            + "\1\7\1\10\1\11\5\2\1\12\1\13\1\14\1\15"
            + "\31\2\1\16\11\2\1\17\2\2\1\20\2\2\1\21"
            + "\4\2\1\22\1\23\1\24\4\2\1\25\3\2\1\26"
            + "\1\27\2\2\1\30";

    private static int[] zzUnpackAction() {
        int[] result = new int[84];
        int offset = 0;
        offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
        return result;
    }

    private static int zzUnpackAction(String packed, int offset, int[] result) {
        int i = 0;
        /* index in packed string  */
        int j = offset;
        /* index in unpacked array */
        int l = packed.length();
        while (i < l) {
            int count = packed.charAt(i++);
            int value = packed.charAt(i++);
            do {
                result[j++] = value;
            } while (--count > 0);
        }
        return j;
    }

    /**
     * Translates a state to a row index in the transition table
     */
    private static final int[] ZZ_ROWMAP = zzUnpackRowMap();

    private static final String ZZ_ROWMAP_PACKED_0
            = "\0\0\0\43\0\106\0\151\0\214\0\257\0\322\0\106"
            + "\0\106\0\43\0\43\0\43\0\43\0\365\0\u0118\0\u013b"
            + "\0\u015e\0\u0181\0\43\0\43\0\43\0\43\0\u01a4\0\u01c7"
            + "\0\u01ea\0\u020d\0\u0230\0\u0253\0\u0276\0\u0299\0\u02bc\0\u02df"
            + "\0\u0302\0\u0325\0\u0348\0\u036b\0\u038e\0\u03b1\0\u03d4\0\u03f7"
            + "\0\u041a\0\u043d\0\u0460\0\u0483\0\u04a6\0\u04c9\0\u04ec\0\106"
            + "\0\u050f\0\u0532\0\u0555\0\u0578\0\u059b\0\u05be\0\u05e1\0\u0604"
            + "\0\u0627\0\106\0\u064a\0\u066d\0\106\0\u0690\0\u06b3\0\106"
            + "\0\u06d6\0\u06f9\0\u071c\0\u073f\0\106\0\106\0\106\0\u0762"
            + "\0\u0785\0\u07a8\0\u07cb\0\106\0\u07ee\0\u0811\0\u0834\0\106"
            + "\0\106\0\u0857\0\u087a\0\106";

    private static int[] zzUnpackRowMap() {
        int[] result = new int[84];
        int offset = 0;
        offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
        return result;
    }

    public ArrayList<ErrorLexico> ErrorLexico;

    private static int zzUnpackRowMap(String packed, int offset, int[] result) {
        int i = 0;
        /* index in packed string  */
        int j = offset;
        /* index in unpacked array */
        int l = packed.length();
        while (i < l) {
            int high = packed.charAt(i++) << 16;
            result[j++] = high | packed.charAt(i++);
        }
        return j;
    }

    /**
     * The transition table of the DFA
     */
    private static final int[] ZZ_TRANS = zzUnpackTrans();

    private static final String ZZ_TRANS_PACKED_0
            = "\1\2\1\3\1\4\1\5\2\3\1\6\1\7\1\10"
            + "\1\11\1\12\1\13\1\14\1\15\1\16\3\3\1\17"
            + "\2\3\1\20\3\3\1\21\3\3\1\22\1\23\1\24"
            + "\1\25\1\26\45\0\11\3\4\0\20\3\7\0\1\4"
            + "\41\0\3\3\1\27\1\30\4\3\4\0\20\3\6\0"
            + "\3\3\1\31\2\3\1\32\2\3\4\0\1\33\17\3"
            + "\6\0\4\3\1\34\4\3\4\0\20\3\6\0\2\3"
            + "\1\35\6\3\4\0\20\3\6\0\11\3\4\0\1\36"
            + "\1\3\1\37\15\3\6\0\11\3\4\0\1\40\17\3"
            + "\6\0\6\3\1\41\2\3\4\0\20\3\6\0\11\3"
            + "\4\0\1\42\17\3\6\0\4\3\1\43\4\3\4\0"
            + "\20\3\6\0\3\3\1\44\5\3\4\0\20\3\6\0"
            + "\11\3\4\0\5\3\1\45\12\3\6\0\11\3\4\0"
            + "\5\3\1\46\12\3\6\0\11\3\4\0\1\3\1\47"
            + "\16\3\6\0\11\3\4\0\12\3\1\50\5\3\6\0"
            + "\11\3\4\0\1\51\17\3\6\0\2\3\1\52\6\3"
            + "\4\0\20\3\6\0\11\3\4\0\3\3\1\53\14\3"
            + "\6\0\11\3\4\0\10\3\1\54\7\3\6\0\11\3"
            + "\4\0\5\3\1\55\12\3\6\0\11\3\4\0\10\3"
            + "\1\56\7\3\6\0\5\3\1\57\3\3\4\0\20\3"
            + "\6\0\11\3\4\0\2\3\1\60\15\3\6\0\11\3"
            + "\4\0\2\3\1\61\15\3\6\0\11\3\4\0\6\3"
            + "\1\62\11\3\6\0\11\3\4\0\2\3\1\63\15\3"
            + "\6\0\11\3\4\0\7\3\1\64\10\3\6\0\11\3"
            + "\4\0\16\3\1\65\1\3\6\0\6\3\1\66\2\3"
            + "\4\0\20\3\6\0\2\3\1\67\6\3\4\0\20\3"
            + "\6\0\11\3\4\0\1\70\17\3\6\0\11\3\4\0"
            + "\14\3\1\71\3\3\6\0\11\3\4\0\3\3\1\44"
            + "\14\3\6\0\6\3\1\72\2\3\4\0\20\3\6\0"
            + "\4\3\1\73\4\3\4\0\20\3\6\0\4\3\1\74"
            + "\4\3\4\0\20\3\6\0\11\3\4\0\3\3\1\75"
            + "\14\3\6\0\11\3\4\0\2\3\1\76\15\3\6\0"
            + "\3\3\1\77\5\3\4\0\20\3\6\0\11\3\4\0"
            + "\3\3\1\100\14\3\6\0\11\3\4\0\12\3\1\101"
            + "\5\3\6\0\11\3\4\0\11\3\1\102\6\3\6\0"
            + "\11\3\4\0\10\3\1\103\7\3\6\0\6\3\1\104"
            + "\2\3\4\0\20\3\6\0\11\3\4\0\2\3\1\105"
            + "\15\3\6\0\5\3\1\106\3\3\4\0\20\3\6\0"
            + "\11\3\4\0\2\3\1\107\15\3\6\0\5\3\1\110"
            + "\3\3\4\0\20\3\6\0\11\3\4\0\12\3\1\111"
            + "\5\3\6\0\11\3\4\0\2\3\1\112\15\3\6\0"
            + "\11\3\4\0\15\3\1\113\2\3\6\0\6\3\1\114"
            + "\2\3\4\0\20\3\6\0\11\3\4\0\1\115\17\3"
            + "\6\0\2\3\1\116\6\3\4\0\20\3\6\0\3\3"
            + "\1\117\5\3\4\0\20\3\6\0\11\3\4\0\3\3"
            + "\1\120\14\3\6\0\11\3\4\0\2\3\1\121\15\3"
            + "\6\0\4\3\1\122\4\3\4\0\20\3\6\0\5\3"
            + "\1\123\3\3\4\0\20\3\6\0\6\3\1\124\2\3"
            + "\4\0\20\3\5\0";

    private static int[] zzUnpackTrans() {
        int[] result = new int[2205];
        int offset = 0;
        offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
        return result;
    }

    private static int zzUnpackTrans(String packed, int offset, int[] result) {
        int i = 0;
        /* index in packed string  */
        int j = offset;
        /* index in unpacked array */
        int l = packed.length();
        while (i < l) {
            int count = packed.charAt(i++);
            int value = packed.charAt(i++);
            value--;
            do {
                result[j++] = value;
            } while (--count > 0);
        }
        return j;
    }


    /* error codes */
    private static final int ZZ_UNKNOWN_ERROR = 0;
    private static final int ZZ_NO_MATCH = 1;
    private static final int ZZ_PUSHBACK_2BIG = 2;

    /* error messages for the codes above */
    private static final String ZZ_ERROR_MSG[] = {
        "Unknown internal scanner error",
        "Error: could not match input",
        "Error: pushback value was too large"
    };

    /**
     * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
     */
    private static final int[] ZZ_ATTRIBUTE = zzUnpackAttribute();

    private static final String ZZ_ATTRIBUTE_PACKED_0
            = "\1\0\1\11\7\1\4\11\5\1\4\11\76\1";

    private static int[] zzUnpackAttribute() {
        int[] result = new int[84];
        int offset = 0;
        offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
        return result;
    }

    private static int zzUnpackAttribute(String packed, int offset, int[] result) {
        int i = 0;
        /* index in packed string  */
        int j = offset;
        /* index in unpacked array */
        int l = packed.length();
        while (i < l) {
            int count = packed.charAt(i++);
            int value = packed.charAt(i++);
            do {
                result[j++] = value;
            } while (--count > 0);
        }
        return j;
    }

    /**
     * the input device
     */
    private java.io.Reader zzReader;

    /**
     * the current state of the DFA
     */
    private int zzState;

    /**
     * the current lexical state
     */
    private int zzLexicalState = YYINITIAL;

    /**
     * this buffer contains the current text to be matched and is the source of
     * the yytext() string
     */
    private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

    /**
     * the textposition at the last accepting state
     */
    private int zzMarkedPos;

    /**
     * the current text position in the buffer
     */
    private int zzCurrentPos;

    /**
     * startRead marks the beginning of the yytext() string in the buffer
     */
    private int zzStartRead;

    /**
     * endRead marks the last character in the buffer, that has been read from
     * input
     */
    private int zzEndRead;

    /**
     * number of newlines encountered up to the start of the matched text
     */
    private int yyline;

    /**
     * the number of characters up to the start of the matched text
     */
    private int yychar;

    /**
     * the number of characters from the last newline up to the start of the
     * matched text
     */
    private int yycolumn;

    /**
     * zzAtBOL == true iff the scanner is currently at the beginning of a line
     */
    private boolean zzAtBOL = true;

    /**
     * zzAtEOF == true iff the scanner is at the EOF
     */
    private boolean zzAtEOF;

    /**
     * denotes if the user-EOF-code has already been executed
     */
    private boolean zzEOFDone;

    /**
     * The number of occupied positions in zzBuffer beyond zzEndRead. When a
     * lead/high surrogate has been read from the input stream into the final
     * zzBuffer position, this will have a value of 1; otherwise, it will have a
     * value of 0.
     */
    private int zzFinalHighSurrogate = 0;

    /* user code: */
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline + 1, yycolumn + 1, value);
    }

    /**
     * Creates a new scanner
     *
     * @param in the java.io.Reader to read input from.
     */
    public lexico_replay(java.io.Reader in) {
        this.ErrorLexico=new ArrayList();
        this.zzReader = in;
    }

    /**
     * Unpacks the compressed character translation table.
     *
     * @param packed the packed character translation table
     * @return the unpacked character translation table
     */
    private static char[] zzUnpackCMap(String packed) {
        char[] map = new char[0x110000];
        int i = 0;
        /* index in packed string  */
        int j = 0;
        /* index in unpacked array */
        while (i < 162) {
            int count = packed.charAt(i++);
            char value = packed.charAt(i++);
            do {
                map[j++] = value;
            } while (--count > 0);
        }
        return map;
    }

    /**
     * Refills the input buffer.
     *
     * @return      <code>false</code>, iff there was new input.
     *
     * @exception java.io.IOException if any I/O-Error occurs
     */
    private boolean zzRefill() throws java.io.IOException {

        /* first: make room (if you can) */
        if (zzStartRead > 0) {
            zzEndRead += zzFinalHighSurrogate;
            zzFinalHighSurrogate = 0;
            System.arraycopy(zzBuffer, zzStartRead,
                    zzBuffer, 0,
                    zzEndRead - zzStartRead);

            /* translate stored positions */
            zzEndRead -= zzStartRead;
            zzCurrentPos -= zzStartRead;
            zzMarkedPos -= zzStartRead;
            zzStartRead = 0;
        }

        /* is the buffer big enough? */
        if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
            /* if not: blow it up */
            char newBuffer[] = new char[zzBuffer.length * 2];
            System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
            zzBuffer = newBuffer;
            zzEndRead += zzFinalHighSurrogate;
            zzFinalHighSurrogate = 0;
        }

        /* fill the buffer with new input */
        int requested = zzBuffer.length - zzEndRead;
        int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

        /* not supposed to occur according to specification of java.io.Reader */
        if (numRead == 0) {
            throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
        }
        if (numRead > 0) {
            zzEndRead += numRead;
            /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
            if (numRead == requested) {
                if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
                    --zzEndRead;
                    zzFinalHighSurrogate = 1;
                }
            }
            /* potentially more input available */
            return false;
        }

        /* numRead < 0 ==> end of stream */
        return true;
    }

    /**
     * Closes the input stream.
     */
    public final void yyclose() throws java.io.IOException {
        zzAtEOF = true;
        /* indicate end of file */
        zzEndRead = zzStartRead;
        /* invalidate buffer    */

        if (zzReader != null) {
            zzReader.close();
        }
    }

    /**
     * Resets the scanner to read from a new input stream. Does not close the
     * old reader.
     *
     * All internal variables are reset, the old input stream
     * <b>cannot</b> be reused (internal buffer is discarded and lost). Lexical
     * state is set to <tt>ZZ_INITIAL</tt>.
     *
     * Internal scan buffer is resized down to its initial length, if it has
     * grown.
     *
     * @param reader the new input stream
     */
    public final void yyreset(java.io.Reader reader) {
        zzReader = reader;
        zzAtBOL = true;
        zzAtEOF = false;
        zzEOFDone = false;
        zzEndRead = zzStartRead = 0;
        zzCurrentPos = zzMarkedPos = 0;
        zzFinalHighSurrogate = 0;
        yyline = yychar = yycolumn = 0;
        zzLexicalState = YYINITIAL;
        if (zzBuffer.length > ZZ_BUFFERSIZE) {
            zzBuffer = new char[ZZ_BUFFERSIZE];
        }
    }

    /**
     * Returns the current lexical state.
     */
    public final int yystate() {
        return zzLexicalState;
    }

    /**
     * Enters a new lexical state
     *
     * @param newState the new lexical state
     */
    public final void yybegin(int newState) {
        zzLexicalState = newState;
    }

    /**
     * Returns the text matched by the current regular expression.
     */
    public final String yytext() {
        return new String(zzBuffer, zzStartRead, zzMarkedPos - zzStartRead);
    }

    /**
     * Returns the character at position <tt>pos</tt> from the matched text.
     *
     * It is equivalent to yytext().charAt(pos), but faster
     *
     * @param pos the position of the character to fetch. A value from 0 to
     * yylength()-1.
     *
     * @return the character at position pos
     */
    public final char yycharat(int pos) {
        return zzBuffer[zzStartRead + pos];
    }

    /**
     * Returns the length of the matched text region.
     */
    public final int yylength() {
        return zzMarkedPos - zzStartRead;
    }

    /**
     * Reports an error that occured while scanning.
     *
     * In a wellformed scanner (no or only correct usage of yypushback(int) and
     * a match-all fallback rule) this method will only be called with things
     * that "Can't Possibly Happen". If this method is called, something is
     * seriously wrong (e.g. a JFlex bug producing a faulty scanner etc.).
     *
     * Usual syntax/scanner level error handling should be done in error
     * fallback rules.
     *
     * @param errorCode the code of the errormessage to display
     */
    private void zzScanError(int errorCode) {
        String message;
        try {
            message = ZZ_ERROR_MSG[errorCode];
        } catch (ArrayIndexOutOfBoundsException e) {
            message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
        }

        throw new Error(message);
    }

    /**
     * Pushes the specified amount of characters back into the input stream.
     *
     * They will be read again by then next call of the scanning method
     *
     * @param number the number of characters to be read again. This number must
     * not be greater than yylength()!
     */
    public void yypushback(int number) {
        if (number > yylength()) {
            zzScanError(ZZ_PUSHBACK_2BIG);
        }

        zzMarkedPos -= number;
    }

    /**
     * Contains user EOF-code, which will be executed exactly once, when the end
     * of file is reached
     */
    private void zzDoEOF() throws java.io.IOException {
        if (!zzEOFDone) {
            zzEOFDone = true;
            yyclose();
        }
    }

    /**
     * Resumes scanning until the next regular expression is matched, the end of
     * input is encountered or an I/O-Error occurs.
     *
     * @return the next token
     * @exception java.io.IOException if any I/O-Error occurs
     */
    public java_cup.runtime.Symbol next_token() throws java.io.IOException {
        int zzInput;
        int zzAction;

        // cached fields:
        int zzCurrentPosL;
        int zzMarkedPosL;
        int zzEndReadL = zzEndRead;
        char[] zzBufferL = zzBuffer;
        char[] zzCMapL = ZZ_CMAP;

        int[] zzTransL = ZZ_TRANS;
        int[] zzRowMapL = ZZ_ROWMAP;
        int[] zzAttrL = ZZ_ATTRIBUTE;

        while (true) {
            zzMarkedPosL = zzMarkedPos;

            yychar += zzMarkedPosL - zzStartRead;

            boolean zzR = false;
            int zzCh;
            int zzCharCount;
            for (zzCurrentPosL = zzStartRead;
                    zzCurrentPosL < zzMarkedPosL;
                    zzCurrentPosL += zzCharCount) {
                zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
                zzCharCount = Character.charCount(zzCh);
                switch (zzCh) {
                    case '\u000B':  // fall through
                    case '\u000C':  // fall through
                    case '\u0085':  // fall through
                    case '\u2028':  // fall through
                    case '\u2029':
                        yyline++;
                        yycolumn = 0;
                        zzR = false;
                        break;
                    case '\r':
                        yyline++;
                        yycolumn = 0;
                        zzR = true;
                        break;
                    case '\n':
                        if (zzR) {
                            zzR = false;
                        } else {
                            yyline++;
                            yycolumn = 0;
                        }
                        break;
                    default:
                        zzR = false;
                        yycolumn += zzCharCount;
                }
            }

            if (zzR) {
                // peek one character ahead if it is \n (if we have counted one line too much)
                boolean zzPeek;
                if (zzMarkedPosL < zzEndReadL) {
                    zzPeek = zzBufferL[zzMarkedPosL] == '\n';
                } else if (zzAtEOF) {
                    zzPeek = false;
                } else {
                    boolean eof = zzRefill();
                    zzEndReadL = zzEndRead;
                    zzMarkedPosL = zzMarkedPos;
                    zzBufferL = zzBuffer;
                    if (eof) {
                        zzPeek = false;
                    } else {
                        zzPeek = zzBufferL[zzMarkedPosL] == '\n';
                    }
                }
                if (zzPeek) {
                    yyline--;
                }
            }
            zzAction = -1;

            zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

            zzState = ZZ_LEXSTATE[zzLexicalState];

            // set up zzAction for empty match case:
            int zzAttributes = zzAttrL[zzState];
            if ((zzAttributes & 1) == 1) {
                zzAction = zzState;
            }

            zzForAction:
            {
                while (true) {

                    if (zzCurrentPosL < zzEndReadL) {
                        zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
                        zzCurrentPosL += Character.charCount(zzInput);
                    } else if (zzAtEOF) {
                        zzInput = YYEOF;
                        break zzForAction;
                    } else {
                        // store back cached positions
                        zzCurrentPos = zzCurrentPosL;
                        zzMarkedPos = zzMarkedPosL;
                        boolean eof = zzRefill();
                        // get translated positions and possibly new buffer
                        zzCurrentPosL = zzCurrentPos;
                        zzMarkedPosL = zzMarkedPos;
                        zzBufferL = zzBuffer;
                        zzEndReadL = zzEndRead;
                        if (eof) {
                            zzInput = YYEOF;
                            break zzForAction;
                        } else {
                            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
                            zzCurrentPosL += Character.charCount(zzInput);
                        }
                    }
                    int zzNext = zzTransL[zzRowMapL[zzState] + zzCMapL[zzInput]];
                    if (zzNext == -1) {
                        break zzForAction;
                    }
                    zzState = zzNext;

                    zzAttributes = zzAttrL[zzState];
                    if ((zzAttributes & 1) == 1) {
                        zzAction = zzState;
                        zzMarkedPosL = zzCurrentPosL;
                        if ((zzAttributes & 8) == 8) {
                            break zzForAction;
                        }
                    }

                }
            }

            // store back cached position
            zzMarkedPos = zzMarkedPosL;

            if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
                zzAtEOF = true;
                zzDoEOF();
                {
                    return new java_cup.runtime.Symbol(sym.EOF);
                }
            } else {
                switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
                    case 1: {
                        ErrorLexico.add(new ErrorLexico(yytext(), yyline + 1, yycolumn + 1));

                        return symbol(sym.ERROR, new String(yytext()));
                    }
                    // fall through
                    case 25:
                        break;
                    case 2: {
                        return symbol(sym.id, new String(yytext()));
                    }
                    // fall through
                    case 26:
                        break;
                    case 3: {
                        return symbol(sym.num, new String(yytext()));
                    }
                    // fall through
                    case 27:
                        break;
                    case 4: {
                        return symbol(sym.abreCor, new String(yytext()));
                    }
                    // fall through
                    case 28:
                        break;
                    case 5: {
                        return symbol(sym.cierraCor, new String(yytext()));
                    }
                    // fall through
                    case 29:
                        break;
                    case 6: {
                        return symbol(sym.abreLlaves, new String(yytext()));
                    }
                    // fall through
                    case 30:
                        break;
                    case 7: {
                        return symbol(sym.cierraLlaves, new String(yytext()));
                    }
                    // fall through
                    case 31:
                        break;
                    case 8: {
                        return symbol(sym.coma, new String(yytext()));
                    }
                    // fall through
                    case 32:
                        break;
                    case 9: {
                        return symbol(sym.dosPuntos, new String(yytext()));
                    }
                    // fall through
                    case 33:
                        break;
                    case 10: {
                        return symbol(sym.comilla, new String(yytext()));
                    }
                    // fall through
                    case 34:
                        break;
                    case 11: {
                        return symbol(sym.abreComilla, new String(yytext()));
                    }
                    // fall through
                    case 35:
                        break;
                    case 12: {
                        return symbol(sym.cierraComilla, new String(yytext()));
                    }
                    // fall through
                    case 36:
                        break;
                    case 13: {
                    }
                    // fall through
                    case 37:
                        break;
                    case 14: {
                        return symbol(sym.bool, new String(yytext()));
                    }
                    // fall through
                    case 38:
                        break;
                    case 15: {
                        return symbol(sym.turno, new String(yytext()));
                    }
                    // fall through
                    case 39:
                        break;
                    case 16: {
                        return symbol(sym.naves, new String(yytext()));
                    }
                    // fall through
                    case 40:
                        break;
                    case 17: {
                        return symbol(sym.datos, new String(yytext()));
                    }
                    // fall through
                    case 41:
                        break;
                    case 18: {
                        return symbol(sym.nombre, new String(yytext()));
                    }
                    // fall through
                    case 42:
                        break;
                    case 19: {
                        return symbol(sym.origen, new String(yytext()));
                    }
                    // fall through
                    case 43:
                        break;
                    case 20: {
                        return symbol(sym.ataque, new String(yytext()));
                    }
                    // fall through
                    case 44:
                        break;
                    case 21: {
                        return symbol(sym.destino, new String(yytext()));
                    }
                    // fall through
                    case 45:
                        break;
                    case 22: {
                        return symbol(sym.espacio, new String(yytext()));
                    }
                    // fall through
                    case 46:
                        break;
                    case 23: {
                        return symbol(sym.complete, new String(yytext()));
                    }
                    // fall through
                    case 47:
                        break;
                    case 24: {
                        return symbol(sym.numeroTurno, new String(yytext()));
                    }
                    // fall through
                    case 48:
                        break;
                    default:
                        zzScanError(ZZ_NO_MATCH);
                }
            }
        }
    }

    /**
     * Converts an int token code into the name of the token by reflection on
     * the cup symbol class/interface sym
     *
     * This code was contributed by Karl Meissner <meissnersd@yahoo.com>
     */
    private String getTokenName(int token) {
        try {
            java.lang.reflect.Field[] classFields = sym.class.getFields();
            for (int i = 0; i < classFields.length; i++) {
                if (classFields[i].getInt(null) == token) {
                    return classFields[i].getName();
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

        return "UNKNOWN TOKEN";
    }

    /**
     * Same as next_token but also prints the token to standard out for
     * debugging.
     *
     * This code was contributed by Karl Meissner <meissnersd@yahoo.com>
     */
    public java_cup.runtime.Symbol debug_next_token() throws java.io.IOException {
        java_cup.runtime.Symbol s = next_token();
        System.out.println("line:" + (yyline + 1) + " col:" + (yycolumn + 1) + " char:" + yychar + " --" + yytext() + "--" + getTokenName(s.sym) + "--");
        return s;
    }

    /**
     * Runs the scanner on input files.
     *
     * This main method is the debugging routine for the scanner. It prints
     * debugging information about each returned token to System.out until the
     * end of file is reached, or an error occured.
     *
     * @param argv the command line, contains the filenames to run the scanner
     * on.
     */
    public static void main(String argv[]) {
        if (argv.length == 0) {
            System.out.println("Usage : java lexico_replay [ --encoding <name> ] <inputfile(s)>");
        } else {
            int firstFilePos = 0;
            String encodingName = "UTF-8";
            if (argv[0].equals("--encoding")) {
                firstFilePos = 2;
                encodingName = argv[1];
                try {
                    java.nio.charset.Charset.forName(encodingName); // Side-effect: is encodingName valid? 
                } catch (Exception e) {
                    System.out.println("Invalid encoding '" + encodingName + "'");
                    return;
                }
            }
            for (int i = firstFilePos; i < argv.length; i++) {
                lexico_replay scanner = null;
                try {
                    java.io.FileInputStream stream = new java.io.FileInputStream(argv[i]);
                    java.io.Reader reader = new java.io.InputStreamReader(stream, encodingName);
                    scanner = new lexico_replay(reader);
                    while (!scanner.zzAtEOF) {
                        scanner.debug_next_token();
                    }
                } catch (java.io.FileNotFoundException e) {
                    System.out.println("File not found : \"" + argv[i] + "\"");
                } catch (java.io.IOException e) {
                    System.out.println("IO error scanning file \"" + argv[i] + "\"");
                    System.out.println(e);
                } catch (Exception e) {
                    System.out.println("Unexpected exception:");
                    e.printStackTrace();
                }
            }
        }
    }

}
