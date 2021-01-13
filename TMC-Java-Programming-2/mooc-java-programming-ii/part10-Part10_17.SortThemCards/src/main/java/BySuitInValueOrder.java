
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author john.lingad
 */
public class BySuitInValueOrder implements Comparator<Card>{ 
    
    public int compare(Card card1, Card card2){
        if (card1.getSuit().compareTo(card2.getSuit()) == 0){
            return card1.getValue() - card2.getValue();
        } else {
            return card1.getSuit().compareTo(card2.getSuit());
        }
    }
}
