/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.HashMap;
import java.util.ArrayList;
/**
 *
 * @author john.lingad
 */
public class DictionaryOfManyTranslations {
    private HashMap<String, ArrayList<String>> dictionary;
    
    public DictionaryOfManyTranslations() {
        this.dictionary = new HashMap<>();
    }
    
    public void add(String word, String translation) {
        if (!this.dictionary.containsKey(word)) {
            ArrayList<String> meanings = new ArrayList();
            meanings.add(translation);
            this.dictionary.put(word, meanings);
        } else {
            this.dictionary.get(word).add(translation);
        }
    }
    
    public ArrayList<String> translate(String word) {
        if (this.dictionary.containsKey(word)) {
            return this.dictionary.get(word);
        }
        return new ArrayList<String>();
    }
    
    public void remove(String word) {
        if (this.dictionary.containsKey(word)) {
            this.dictionary.remove(word);
        }
    }
}
