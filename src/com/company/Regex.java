package com.company;

import java.util.ArrayList;


public class Regex {
    public static String[] Keywords = new String[] {
            "Byte", "Shortint", "Smallint", "Word", "Integer", "Cardinal", "Uint64", "Int64",
            "Real", "Single", "Double", "String", "var", "program", "begin", "end", "uses",
            "in", "not", "or", "xor", "and", "unit", "interface", "ReadLn", "WriteLn",
            "Read", "Write", "type", "private", "public", "implementation", "class", "array",
            "if", "then", "else", "for","of", "with", "do", "while", "to","function",
            "procedure", "repeat", "until"

    };

    public static ArrayList<TokenDefinition> Tokens = new ArrayList<TokenDefinition>() {
        {

            this.add(new TokenDefinition(TokenKind.Comment,
                    "(?:/\\*[^*]*\\*+(?:[^*/][^*]*\\*+)*/)|(?://.*)"));

            this.add(new TokenDefinition(TokenKind.Identifier,
                    "[a-zA-Z_][a-zA-Z0-9_]*"));


            this.add(new TokenDefinition(TokenKind.Operator,
                    "::|\\.\\*?|->\\*?|\\[|\\]|\\((([a-zA-Z_]*\\))?)|\\)" +
                            "|\\+(\\+|=)?|-[=-]?|~|!=?|&[=&]?|\\*=?|new|delete|sizeof" +
                            "|\\/=?|%=?|<(<=|<|=)?|>(>=|>|=)?|==?|\\^=?" +
                            "|\\|(\\||=)?|\\?|:|,"));


            this.add(new TokenDefinition(TokenKind.Punctuator,
                    "\\{|\\}|;"));


            this.add(new TokenDefinition(TokenKind.CharacterLiteral,
                    "L?\'([^\'\\\\\n]|(\\\\[\'\"\\\\?abfnrtuUxv])|" +
                            "(\\\\[0-7]{1,3})|(\\\\x[0-9a-fA-F]{1,})|" +
                            "(\\\\(u|U)([0-9a-fA-F]{4}){1,2}))*\'"));

            this.add(new TokenDefinition(TokenKind.PreprocessingDirective,
                    "#\\s*(define|undef|if|elif|else|ifndef|endif|line|error|ifdef|pragma|import|include|using)")

            );

            this.add(new TokenDefinition(TokenKind.StringLiteral,
                    "L?\"([^'\\\\\n" +
                            "]|(\\\\['\"\\\\?abfnrtuUxv])|\" +\n" +
                            "(\\\\\\\\[0-7]{1,3})|(\\\\\\\\x[0-9a-fA-F]{1,})|\" +\n" +
                            "(\\\\(u|U)([0-9a-fA-F]{4}){1,2}))*\""));



            this.add(new TokenDefinition(TokenKind.RealDigit,
                    "((((([0-9]+\\.[0-9]*)|([0-9]*\\.[0-9]+))([eE][+-]?[0-9]+)?))|" +
                            "([0-9]+[eE][+-]?[0-9]+))[flFL]?"));

            this.add(new TokenDefinition(TokenKind.IntegerDigit,
                    "((0[0-7]+)|(0[xX][0-9a-bA-F]+)|([0-9]+))(([uU][lL])|([lL][uU])|([uU])|([lL]))?"));


        }
    };

}