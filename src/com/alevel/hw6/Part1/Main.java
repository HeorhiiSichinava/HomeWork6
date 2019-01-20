package com.alevel.hw6.Part1;


import java.io.File;
import java.io.StringReader;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Random;
import java.util.SplittableRandom;

public class Main {
    public static void main(String[] args) {
//        File file = new File("C:\\Users\\HEORHII\\IdeaProjects\\HomeWork6\\Library_words.txt");
        String str = "helloSpace";
        System.out.println("1) random creat words: " + randomCreateWords(str));
        String str2 = "_ABC015cd";
        System.out.println("2) Word identificator: " + chekIdentif(str2));
        String str3 = "Madam, I'm Adam";
        System.out.println("3.v1) This string is a palindrome?: " + palindrome(str3));
        System.out.println("3.v2) This string is a palindrome?: " + palindrome2(str3));
        String str4 = "data 48 call 9 read13 blank0a";
        System.out.println("4) Array numbers: " + Arrays.toString(arrayNumbers(str4)));
        System.out.println("5) Delete repeats symbols: " + arrayIsDeleteSpaceAndRepeatsSymbols(str3));
        String str5 = "Вы вошли в систему под именем, Семен Слепаков. Здраствуйте мой господин.";
        System.out.println("6)" + newString(str5, " Georgiy Sichinava", 1, 2));
        String[] str6 = {"Hello my lord", "world", "space ", "give my your rithen !", "stop please", "standup please mister"};
        System.out.println("7) Print index numbers array maxmimum lengeth: " + indexNumbersMaximumLengthString(str6));
        System.out.println("8) Print mixmal length string: " + maximumLengthString(str6));
        String str7 = "  Hi  my     name Heorhii   Sichynava .   ";
        System.out.println("9) Correct string: " + correctString(str7));
        System.out.println("10) Print count uppercase symbol and lowercase symbol: " + countNumbersLowercaseUppercase(str3));
        String str8 = "  22:00 bang bang.  Stop your television. I";
        System.out.println("11) Count words in string: " + countWords(str8));
//        System.out.println(Integer.valueOf('a') + " - " + Integer.valueOf('z'));
//        System.out.println(Integer.valueOf('A') + " - " + Integer.valueOf('Z'));

    }

    ////////////////////////////////////////
    //1
    public static String randomCreateWords(String str) {
        String word = "";
        int lengthStr = str.length();
        int lengthWord = word.length();
        int countWords = 0;
        int countSymbol = 0;
        int numberSimbolStr = 0;
        Random random = new Random();
        countWords = random.nextInt(10) + 3;
        for (int i = 0; i < countWords; i++) {
            lengthWord = random.nextInt(6) + 2;
            countSymbol = 0;
            while (countSymbol < lengthWord) {
                numberSimbolStr = random.nextInt(lengthStr);
                if (str.charAt(numberSimbolStr) != ' ') {
                    word += str.charAt(numberSimbolStr);
                    countSymbol++;
                }
            }
            word += " ";
        }
        return word;
    }

    ////////////////////////////////////////
    //2
    public static boolean chekIdentif(String str) {
        String[] simbolStr = str.split("");
        String[] alphabetSmallSymbol = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
//        String[] alphabetBigSymbol ={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

//        int numberSimbol=0;
//        System.out.println(numberSimbol=Character.getNumericValue('z'));
        String[] simbol = {"_", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        boolean chek = true;
        int index = 0;
        for (int i = 0; i < alphabetSmallSymbol.length && index < simbolStr.length; i++) {
            chek = simbolStr[index].equalsIgnoreCase(alphabetSmallSymbol[i]);
            if (i < simbol.length && !chek) {
                chek = simbolStr[index].equalsIgnoreCase(simbol[i]);
            }
            if (chek) {
                index++;
                i = -1;
            } else if (!chek && i == alphabetSmallSymbol.length) {
                break;
            }

        }
        return chek;
    }

    ////////////////////////////////////////
    //3.1
    public static boolean palindrome(String str) {
        boolean strPalindrome = false;
        boolean countEnd = false;
        String[] alphabetSmallSymbol = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String[] strSimbol = str.split("");
        String[] palindromStr = {" "};
        int count = 0;
        for (int i = 0; i < palindromStr.length; i++) {
            if (palindromStr.length < 2) {
                for (int j = 0, k = 0; k < strSimbol.length; j++) {
                    if (strSimbol[k].equalsIgnoreCase(alphabetSmallSymbol[j])) {
                        if (countEnd) {
                            palindromStr[count] = alphabetSmallSymbol[j];
                        }
                        count++;
                        k++;
                        j = -1;
                    }
                    if (j == alphabetSmallSymbol.length - 1 && k < strSimbol.length) {
                        j = -1;
                        k++;
                    } else if (strSimbol.length == k && !countEnd) {
                        palindromStr = new String[count];
                        countEnd = true;
                        k = 0;
                        count = 0;
                    } else if (strSimbol.length == k && countEnd) {
                        break;
                    }
                }
            }
            strPalindrome = palindromStr[i].equalsIgnoreCase(palindromStr[count - i - 1]);
//            System.out.println(palindromStr[i]+" "+palindromStr[count-i-1]);
            if (!strPalindrome) {
                break;
            }
        }
        return strPalindrome;
    }

    ////////////////////////////////////////
    //3.2
    public static boolean palindrome2(String str) {
        String alphabet = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
        boolean palindrome = false;
        for (int i = 0, j = str.length() - 1; i < str.length(); i++) {
            if (alphabet.indexOf(str.charAt(i)) >= 0) {
                if (alphabet.indexOf(str.charAt(j)) >= 0) {
                    palindrome = String.valueOf(str.charAt(i)).equalsIgnoreCase(String.valueOf(str.charAt(j)));
//                    System.out.println(str.charAt(i)+" "+i+" = "+str.charAt(j)+" "+j+" "+palindrome);
                    j--;
                    if (!palindrome) {
                        break;
                    }
                } else {
                    j--;
                    i--;
                }
            }
        }
        return palindrome;
    }

    ////////////////////////////////////////
    //4
    public static int[] arrayNumbers(String str) {
        int[] arrayNumbers = {0};
        String numbers = "0123456789";
        int count = 0;
        boolean number = false;
        boolean countEnd = false;
        boolean numberLength = false;
        for (int i = 0; i < str.length(); i++) {
            if (!number) {
                if (countEnd) {
                    arrayNumbers[count] = numbers.indexOf(str.charAt(i)) >= 0 ? Integer.valueOf(str.charAt(i)) - 48 : 0;
                }
                count += numbers.indexOf(str.charAt(i)) >= 0 ? 1 : 0;
                number = numbers.indexOf(str.charAt(i)) >= 0 ? true : false;
            } else if (number) {
                number = numbers.indexOf(str.charAt(i)) >= 0 ? true : false;
                if (number && countEnd) {
                    arrayNumbers[count - 1] = arrayNumbers[count - 1] * 10 + Integer.valueOf(str.charAt(i)) - 48;
                }
            }
            if (!countEnd && i == str.length() - 1) {
                arrayNumbers = new int[count];
                countEnd = true;
                i = -1;
                count = 0;
            }
        }
        return arrayNumbers;
    }

    ////////////////////////////////////////
    //5
    public static String arrayIsDeleteSpaceAndRepeatsSymbols(String str) {
        String newString = "";
        for (int i = 0; i < str.length(); i++) {
            newString += newString.indexOf(String.valueOf(str.charAt(i))) >= 0 || str.charAt(i) == ' ' ? "" : str.charAt(i);
        }
        return newString;
    }

    ////////////////////////////////////////
    //6
    public static String newString(String str, String newSubstring, int numberString, int numberSubstring) {
        String replaceString = "";
        int countNumberString = 1;
        int countNumberSubstring = 1;
        boolean recStr = true;
        boolean pastNewSubstring = false;

        for (int i = 0; i < str.length(); i++) {
            countNumberString += str.charAt(i) == '.' ? 1 : 0;
            countNumberSubstring += str.charAt(i) == ',' ? 1 : 0;
            recStr = countNumberString == numberString && countNumberSubstring == numberSubstring ? false : true;
            if (recStr) {
                replaceString += String.valueOf(str.charAt(i));
            } else if (!recStr && !pastNewSubstring) {
                if (countNumberSubstring == numberSubstring) {
                    replaceString += str.charAt(i) + newSubstring;
                    pastNewSubstring = true;
                }
            }
        }
        return replaceString;
    }

    ////////////////////////////////////////
    //7
    public static String indexNumbersMaximumLengthString(String[] str) {
        String maxLength = "";
        int length = 0;
        for (int i = 0; i < str.length; i++) {
            if (length < str[i].length()) {
                length = str[i].length();
                maxLength = String.valueOf(i);
            } else if (length == str[i].length()) {
                maxLength += "; " + i;
            }
        }
        maxLength += ".";
        return maxLength;
    }

    ////////////////////////////////////////
    //8
    public static String maximumLengthString(String[] str) {
        String maxLength = "";
        for (int i = 0; i < str.length; i++) {
            if (maxLength.length() < str[i].length()) {
                maxLength = String.valueOf(str[i]);
            }
        }
        return maxLength;
    }

    ////////////////////////////////////////
    //9
    public static String correctString(String str) {
        String newString = "";
        String punctuation = ".,;!?:";
        for (int i = str.length() - 1; i > 0; i--) {
            if (str.charAt(i) == ' ') {
                newString = str.charAt(i) == ' ' && newString.equals("")
                        || str.charAt(i) == ' ' && str.charAt(i - 1) == ' '
                        || str.charAt(i) == ' ' && punctuation.indexOf(str.charAt(i + 1)) >= 0
                        ? "" + newString : str.charAt(i) + newString;
            } else newString = str.charAt(i) + newString;
        }
        return newString;
    }

    ////////////////////////////////////////
    //10
    public static String countNumbersLowercaseUppercase(String str) {

        int countLow = 0, countUp = 0;
        for (int i = 0; i < str.length(); i++) {
            countLow += Integer.valueOf(str.charAt(i)) > 96 && Integer.valueOf(str.charAt(i)) < 123 ? 1 : 0;
            countUp += Integer.valueOf(str.charAt(i)) > 64 && Integer.valueOf(str.charAt(i)) < 91 ? 1 : 0;

        }
        return "Lowercase symbols count - " + countLow + " Uppercase symbols count - " + countUp;
    }

    ////////////////////////////////////////
    //11
    public static int countWords(String str) {
        String alphabet = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
        String punctuation = ".,;!?: ";
        boolean words=false;


        int count = 0;
        for (int i = 0; i < str.length()-1; i++) {
            words = alphabet.indexOf(str.charAt(i))>=0 ? true : false;
            char ch=str.charAt(i);
            if (words){
                words = punctuation.indexOf(str.charAt(i+1))>=0 || i==str.length() ? false : true;
                if(!words){
                    count++;
                    words=false;
                }
            }
            if(i==str.length()-2){
                count += alphabet.indexOf(str.charAt(i+1))>=0 ? 1 : 0;
            }
        }
        return count;
    }


}
