package com.company;

import java.util.regex.Pattern;


public class TokenDefinition {
    private TokenKind tokenKind;
    private Pattern pattern;

    public TokenDefinition(TokenKind _tokenKind, String _pattern) {
        tokenKind = _tokenKind;
        pattern = Pattern.compile(_pattern);
    }

    public TokenKind getTokenKind() {
        return tokenKind;
    }

    public Pattern getPattern() {
        return pattern;
    }

}
