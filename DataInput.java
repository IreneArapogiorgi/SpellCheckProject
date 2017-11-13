/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.spellchecker;

/**
 *
 * @author earapogiorgi
 */
public class DataInput {

    public static String[] inputFromUser(String words) {

	words = words.toLowerCase();
	return words.split("[^\\p{L}\\p{N}]+");
    }
    
    public static String[] inputFromTxt() {
	return null;
    }
}
