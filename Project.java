/**
 * @file Project.java
 * @description Programim harflerinin yeri degismis kelimelerden olusan bir
 * stringi duzgun kelimelerden olusan bir stringe gore duzenleyip yeni bir
 * stringe atıyor. Ayrica yeni stringdeki her bir kelimenin yeni stringde
 * kacar defa tekrarlandigini yaziyor.
 * @assignment 1.Odev
 * @date 02/12/2021
 * @author Ahmed Muaz Atik - ahmedmuaz.atik@stu.fsm.edu.tr
 */
package project;

public class Project {

    public static String subString(String text, int firstLetter, int lastLetter) {       //bir stringin belirli bir araligini kesip bos bir stringe atiyor.
        String splittedString = "";
        char lettersOfTheString;
        
        for (int i = firstLetter; i <= lastLetter; i++) {                                //hangi araligi alacagi for dongusuyle belirleniyor.
            lettersOfTheString = text.charAt(i);
            splittedString += lettersOfTheString;
        }
        return splittedString;                                                           
    }

    public static int numOfBlanks(String text) {                                         //stringde kac kelime oldugunu hesapliyor.
        int numberOfBlanks = 1;   
        char blanksOfTheString;

        for (int i = 0; i < text.length(); i++) {                                        //for dongusuyle bosluk sayisini hesapliyor, 1 ekleyip kelime sayisini buluyor.
            blanksOfTheString = text.charAt(i);

            if (blanksOfTheString == ' ') {
                numberOfBlanks++;
            }
        }

        return numberOfBlanks;                                                           
    }

    public static String rotateLeft(String text, int n) {                                //stringi n degeri kadar sola kaydiriyor.
        String rotatedString = "";

        String doubleString = text + text;                                               //yanyana iki string yazilinca tum varyasyonlar ortaya cikiyor.

        String newSplittedString;
                
        for (int i = 0; i <= n; i++) {                                                   
            newSplittedString = subString(doubleString, i, text.length() + i - 1);

            rotatedString = newSplittedString;
        }

        return rotatedString;                                                            
    }

    public static String lowerCase(String text) {                                        //strindeki tum kelimelerde bulunan buyuk harfleri kucuk harfe donusturuyor.
        String lowerCasedString = "";
        char lettersOfTheString;

        for (int i = 0; i < text.length(); i++) {                                        //ASCII Table'ye gore buyuk harfe 32 eklenip kucuk harfe donusturuluyor.
            lettersOfTheString = text.charAt(i);

            if (lettersOfTheString >= 65 && lettersOfTheString <= 90) {
                lowerCasedString += (char) (lettersOfTheString + 32);
            } else {
                lowerCasedString += lettersOfTheString;
            }
        }

        return lowerCasedString;                                                        

    }

    public static String[] assignStringIntoArray(String text) {                          //stringi bosluk sayisina gore ayirip bos bir arraye atiyor.

        String[] stringIntoArray = new String[numOfBlanks(text)];
        String newString = "";
        char lettersOfTheString;

        int queue = 0;

        for (int i = 0; i < text.length(); i++) {                                        //eger harf bosluga esitse bosluga kadar olan kisim arraye ataniyor.
            lettersOfTheString = text.charAt(i);

            if (lettersOfTheString != ' ') {
                newString += lettersOfTheString;
            } else {
                stringIntoArray[queue] = newString;
                queue++;
                newString = "";
            }

        }
        stringIntoArray[queue] = newString;                                              //cumlenin sonunda bosluk olmadigindan dolayi sondaki kelime arrayin son indexine atiliyor.

        return stringIntoArray;                                                          
    }

    public static String correctText(String dictionary[], String randomText[]) {         //randomText'i dictionary'de bulunan kelimelere gore rotate ettirip düzenliyor.
        String correctText = "";

        Boolean isTarget;                                                                

        for (int i = 0; i < randomText.length; i++) {                                    
            isTarget = false;
            for (int j = 0; j < dictionary.length; j++) {
                if (isTarget == false) {
                    for (int k = 1; k <= randomText[i].length(); k++) {                  
                        if (lowerCase(randomText[i]).equals(lowerCase(dictionary[j]))) { 
                            correctText += randomText[i] + " ";
                            isTarget = true;
                            break;
                        } else {
                            randomText[i] = rotateLeft(randomText[i], 1);                //arrayden alinan kelimeyi her esitsizlikte 1 hane sola kaydiriyor.
                            isTarget = false;
                        }
                    }
                } else {
                    break;
                }
            }
        }

        return correctText;                                                              

    }

    public static void repeatNumOfWords(String[] text) {                                 //stringin tum indexlerini gezip her bir kelimenin kacar defa tekrarlandigini print ediyor.
        int repeatsArr[] = new int[text.length];

        for (int i = 0; i < repeatsArr.length; i++) {
            for (int j = 0; j < repeatsArr.length; j++) {
                if (lowerCase(text[i]).equals(lowerCase(text[j]))) {                     //"The","the" karmasasini onlemek icin kucuk harfle donusturulmus halleri kiyaslaniyor.
                    repeatsArr[i]++;
                }
            }
        }
        for (int i = 1; i <= repeatsArr.length - 1; i++) {                               
            System.out.print(repeatsArr[i] + " ");
            if (i % 50 == 0) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {

        String dictionary = "1901 1964 arkansas army beaver corps engineers harvey harveys hope it lake missouri monte ne oklahoma ozark river rogers row rows states the two us united white william a after almost and area as at be boat buildings by can community completely concrete created death due earliest east edge examples financial former from health hills his hotels in is its lake largest levels log mainly managed management mid-1930s multi-story normal not of off on one only open operated owned part planned property ramp referred remainder remaining resort seen serves severely shortly sold state still structure style submerged success that the theorist time to tower town valley vandalized was were world writer";

        String randomText = "onteM Ne si a merfor health esortr and nedplan unitycomm in het sU atest fo rkansasA nope omfr 9011 to the d-1930smi It asw owned nda by liamWil eHop arveyH a ncialfina ttheoris dan riterw ni eth kOzar llshi fo the iteWh iverR leyval east of sRoger no the edge of averBe eLak woT of sit hotels Missouri Row nda maOklaho Row ewer eth estlarg log ngsbuildi in eth rldwo at the etim and aOklahom tower si neo fo het rliestea xamplese of a storymulti- ncreteco restructu The ortres was otn a alfinanci uccesss edu ni rtpa ot entmanagem ylest dan yshortl eraft ish thdea the typroper swa dsol ffo heT remainder fo het esortr and town asw stalmo ompletelyc mergedsub rafte erBeav Lake was atedcre in 1964 heT erelysev zedvandali Oklahoma wRo werto is het yonl emainingr ructurest atth anc eb seen at alnorm kela lsleve heT area on eth edge of averBe Lake llsti erredref ot sa Monte eN edown and gedmana by het tedUni States yArm orpsC of sEngineer esserv nlymai as a tboa ampr";

        System.out.println("1) Hedef Metin (düzeltilmiş): " + correctText(assignStringIntoArray(dictionary), assignStringIntoArray(randomText)));

        System.out.println();
        
        System.out.println("2) Kelime Tekrarları: ");

        repeatNumOfWords(assignStringIntoArray(correctText(assignStringIntoArray(dictionary), assignStringIntoArray(randomText))));

        System.out.println();

    }
}
