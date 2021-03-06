package com.company;

import java.nio.charset.MalformedInputException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.*;


public class Parser {
    private String text;

    private Path path;

    private ArrayList<Token> tokens;

    private int currentPosition;

    public Parser(String _path) {
        path = Paths.get(_path);
        tokens = new ArrayList<Token>();
        currentPosition = 0;
    }

    public Parser () {
        tokens = new ArrayList<Token>();
        currentPosition = 0;
    }

    public ArrayList<Token> getResult() {
        readFile();
        parse();
        return tokens;
    }

    public void readFile() {
        try {
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            StringBuilder stringBuilder = new StringBuilder();

            for (String line : lines) {
                stringBuilder.append(line);
                stringBuilder.append(System.getProperty("line.separator"));
            }

            text = stringBuilder.toString().trim();

        } catch (NoSuchFileException e) {
        }
        catch (MalformedInputException ex) {
            System.out.println("Wrong file type");
        }
        catch (Exception exc) {
            System.out.println(exc.toString());
        }
    }

    private boolean isInBounds() {
        return currentPosition < text.length();
    }

    private void skipSpaces() {
        while (this.isInBounds() &&
                Character.isWhitespace(text.charAt(currentPosition))) {
            ++currentPosition;
        }
    }

    public void parse() {
        while (this.isInBounds()) {
            this.skipSpaces();

            if (!this.isInBounds()) {
                break;
            }

            Token token = this.identificationToken();

            if (token == null) {
                int endWord = currentPosition;
                while (endWord < text.length()
                        &&!Character.isWhitespace(text.charAt(endWord))) {
                    ++endWord;
                }
                String tokenValue = this.text.substring(this.currentPosition,
                        endWord);

                token = new Token(tokenValue, TokenKind.Unknown);

                this.currentPosition += tokenValue.length();
            }

            this.tokens.add(token);
        }
    }



    public Token identificationToken()
    {
        for (TokenDefinition definition : Regex.Tokens)
        {
            String matchString = this.text.substring(this.currentPosition);

            Matcher matcher = definition.getPattern().matcher(
                    matchString);

            if (!matcher.lookingAt())
            {
                continue;
            }

            TokenKind tokenKind = definition.getTokenKind();

            String tokenValue = matchString.substring(0, matcher.end()).trim();

            if (tokenKind == TokenKind.Identifier && Arrays.asList(Regex.Keywords).contains(tokenValue))
            {
                tokenKind = TokenKind.Keyword;
            }

            Token token = new Token(tokenValue, tokenKind);

            this.currentPosition += tokenValue.length();

            return token;
        }

        return null;
    }

    public void setText (String text) {
        this.text=text;
    }

    public String getText () { return this.text; }

    public void setPath (String path) {
        this.path = Paths.get(path);
    }

    public ArrayList getTokens () {return this.tokens; }

    public String readFileIntoString (String path) {
        this.setPath(path);
        this.readFile();
        return this.getText();
    }
}
