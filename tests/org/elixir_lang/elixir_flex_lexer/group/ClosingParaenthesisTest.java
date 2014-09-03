package org.elixir_lang.elixir_flex_lexer.group;

import org.elixir_lang.ElixirFlexLexer;
import org.elixir_lang.psi.ElixirTypes;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

import static org.junit.Assert.assertEquals;

/**
 * Created by luke.imhoff on 9/2/14.
 */
public class ClosingParaenthesisTest {
    private ElixirFlexLexer flexLexer;
    private int initialState = ElixirFlexLexer.BODY;

    private void reset(CharSequence charSequence) throws IOException {
        // start of "~x(" to trigger GROUP state with terminator being ')'
        CharSequence fullCharSequence = "~x(" + charSequence;
        flexLexer.reset(fullCharSequence, 0, fullCharSequence.length(), initialState);
        // consume ~
        flexLexer.advance();
        // consume x
        flexLexer.advance();
        // consume (
        flexLexer.advance();
    }

    @Before
    public void setUp() {
        flexLexer = new ElixirFlexLexer((Reader) null);
    }

    @Test
    public void singleQuote() throws IOException {
        reset("'");

        assertEquals(ElixirTypes.SIGIL_FRAGMENT, flexLexer.advance());
        assertEquals(ElixirFlexLexer.GROUP, flexLexer.yystate());
    }

    @Test
    public void doubleQuotes() throws IOException {
        reset("\"");

        assertEquals(ElixirTypes.SIGIL_FRAGMENT, flexLexer.advance());
        assertEquals(ElixirFlexLexer.GROUP, flexLexer.yystate());
    }

    @Test
    public void closingBrace() throws IOException {
        reset("}");

        assertEquals(ElixirTypes.SIGIL_FRAGMENT, flexLexer.advance());
        assertEquals(ElixirFlexLexer.GROUP, flexLexer.yystate());
    }

    @Test
    public void closingBracket() throws IOException {
        reset("]");

        assertEquals(ElixirTypes.SIGIL_FRAGMENT, flexLexer.advance());
        assertEquals(ElixirFlexLexer.GROUP, flexLexer.yystate());
    }

    @Test
    public void closingChrevon() throws IOException {
        reset(">");

        assertEquals(ElixirTypes.SIGIL_FRAGMENT, flexLexer.advance());
        assertEquals(ElixirFlexLexer.GROUP, flexLexer.yystate());
    }

    @Test
    public void closingParenthesis() throws IOException {
        reset(")");

        assertEquals(ElixirTypes.SIGIL_TERMINATOR, flexLexer.advance());
        assertEquals(initialState, flexLexer.yystate());
    }

    @Test
    public void eol() throws IOException {
        reset("\n");

        assertEquals(ElixirTypes.SIGIL_FRAGMENT, flexLexer.advance());
        assertEquals(ElixirFlexLexer.GROUP, flexLexer.yystate());
    }

    @Test
    public void character() throws IOException {
        reset("a");

        assertEquals(ElixirTypes.SIGIL_FRAGMENT, flexLexer.advance());
        assertEquals(ElixirFlexLexer.GROUP, flexLexer.yystate());
    }
}
