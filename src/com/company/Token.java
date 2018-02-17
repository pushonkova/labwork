package com.company;


public class Token {
    private String tokenValue;

    private TokenKind tokenKind;

    public Token(String _str, TokenKind _tokenKind) {
        tokenValue = _str;
        tokenKind = _tokenKind;
    }

    public String getTokenValue() {
        return tokenValue;
    }

    public TokenKind getTokenKind() {
        return tokenKind;
    }
}
