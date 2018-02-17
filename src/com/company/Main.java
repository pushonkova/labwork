package com.company;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;


public class Main {

    public static String Style (TokenKind type) {
            switch (type){
                case Keyword: return "<b style = \"color:#C61717\" >";
                case Comment: return "<b style = \"color:#1F17C6\" >";
                case Punctuator: return "<b style = \"color:black\" >";
                case Operator: return "<b style = \"color:#ff9900\" >";
                case PreprocessingDirective: return "<b style = \"color:#009933\" >";
                case RealDigit: return "<b style = \"color:black\" >";
                case IntegerDigit: return "<b style = \"color:black\" >";
                case CharacterLiteral: return "<b style = \"color:#004d1a\" >";
                case StringLiteral: return "<b style = \"color:#004d1a\" >";
                case Identifier: return "<b style = \"color:#990099\" >";
                /*case Unknown: return "<b style = \"color:grey\" >"; */
            }
        return "";
    }

    public static void Parse (String input, String output) {
        if (!input.isEmpty()) {
            Parser lexicalParser = new Parser(input);
            ArrayList<Token> result = lexicalParser.getResult();
            TokenKind type= TokenKind.Keyword;
            /*for (Token token : resualt) {
                System.out.println(token.getTokenKind() + " " + token.getTokenValue());
            }*/
            try {
                FileOutputStream outp = new FileOutputStream(output);
                OutputStreamWriter outps = new OutputStreamWriter(outp);
                PrintWriter out = new PrintWriter(outps);
                out.print("<body bgcolor=\"#ffcb85\">");
                for (Token token : result) {
                    if ((type == TokenKind.Punctuator) ||  (type == TokenKind.Comment)) out.print("<br>");
                    out.print(Style(token.getTokenKind()));
                    out.print(token.getTokenValue() + " ");
                    type=token.getTokenKind();
                }

                out.println();
                out.print("</body>");
                out.close();

            }
            catch (Exception e) {
                System.out.print(e);
            }


    }
    }

    public static void main(String[] args) {

        String input = "test2.pas";
        String output = "output.html";

        try {
            Parse(input, output);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            File htmlFile = new File(output);
            Desktop.getDesktop().browse(htmlFile.toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    }




