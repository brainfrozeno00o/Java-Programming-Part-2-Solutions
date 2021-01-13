/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.PrintWriter;
import java.io.File;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 *
 * @author john.lingad
 */
public class SaveableDictionary {
    private HashMap<String, String> dict = new HashMap<>();
    private File file;
    
    public SaveableDictionary() {
        this("words.txt");
    }
    
    public SaveableDictionary(String file){
        this.file = new File(file);
    }
    
    public void add(String word1, String word2){
        if(!this.dict.containsKey(word1)) {
            this.dict.put(word1, word2);
        }        
    }
    
    public String translate(String word) {
        if (this.dict.containsKey(word)) {
            return this.dict.get(word);
        } else if (this.dict.containsValue(word)) {
            for (Entry<String, String> entry : this.dict.entrySet()) {
                if (entry.getValue().equals(word)) {
                    return entry.getKey();
                }
            }
        }
        return null;
    }
    
    public void delete(String word){
        if (this.dict.containsKey(word) || this.dict.containsValue(word)) {
            String key = "";
            for(Entry<String, String> entry : this.dict.entrySet()) {
                if (entry.getValue().equals(word) || entry.getKey().equals(word)) {
                    key = entry.getKey();
                }
            }
            this.dict.remove(key);
        }

    }
    
    public boolean load() {
        try {
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] parts = line.split(":");
                this.dict.put(parts[0], parts[1]);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean save() {
        try {
            PrintWriter writer = new PrintWriter(file);
            
            for (Entry<String, String> entry : this.dict.entrySet()) {
                writer.println(entry.getKey() + ":" + entry.getValue());
            }
            
            writer.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }        
    }
}
