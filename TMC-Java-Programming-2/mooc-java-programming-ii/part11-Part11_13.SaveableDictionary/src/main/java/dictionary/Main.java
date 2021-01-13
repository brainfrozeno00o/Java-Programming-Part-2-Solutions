package dictionary;

public class Main {
    public static void main(String[] args) {
        // You can test your dictionary here
//        SaveableDictionary dictionary = new SaveableDictionary("words.txt");
//        System.out.println(dictionary.load());
//        
//        System.out.println(dictionary.translate("banana"));
//        System.out.println(dictionary.translate("monkey"));
//        System.out.println(dictionary.translate("olut"));
//        
//        dictionary.add("banaani", "banana");
//        dictionary.add("ohjelmointi", "programming");
//        
//        dictionary.save();
        
        SaveableDictionary dictionary2 = new SaveableDictionary("words.txt");
        
        System.out.println(dictionary2.load());
        
        System.out.println(dictionary2.translate("programming"));
        System.out.println(dictionary2.translate("banaani"));
        
        dictionary2.delete("ohjelmointi");
        dictionary2.delete("banana");
        dictionary2.delete("hatdog");
        
        System.out.println(dictionary2.translate("banaani"));
        
        dictionary2.save();
    }
}
