package crypto;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. 
 * 
 * The first approach is called the Vigenere Cipher.Vigenere encryption 
 * is a method of encrypting alphabetic text based on the letters of a keyword.
 * 
 * The second approach is Playfair Cipher. It encrypts two letters (a digraph) 
 * at a time instead of just one.
 * 
 * @author Asbley Qiao
 * @version 7/2/25
 */
public class CryptoManager
{
    private static final char LOWER = ' ';
    private static final char UPPER = '_';
    private static final int SIZE = UPPER - LOWER + 1;

    // Checks each char is within bounds
    public static boolean isStringInBounds(String text)
    {
        for (int i = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if (c < LOWER || c > UPPER)
            {
                return false;
            }
        }
        return true;
    }

    // Vigenere encryption
    public static String vigenereEncryption(String plain, String key)
    {
        if (key == null || key.length() == 0)
        {
            return "Key is empty";
        }
        String result = "";
        for (int i = 0; i < plain.length(); i++)
        {
            char p = plain.charAt(i);
            char k = key.charAt(i % key.length());
            int pi = p - LOWER;
            int ki = k - LOWER;
            int ci = (pi + ki) % SIZE;
            result += (char)(ci + LOWER);
        }
        return result;
    }

    // Vigenere decryption
    public static String vigenereDecryption(String cipher, String key)
    {
        if (key == null || key.length() == 0)
        {
            return "Key is empty";
        }
        String result = "";
        for (int i = 0; i < cipher.length(); i++)
        {
            char c = cipher.charAt(i);
            char k = key.charAt(i % key.length());
            int ci = c - LOWER;
            int ki = k - LOWER;
            int pi = (ci - ki + SIZE) % SIZE;
            result += (char)(pi + LOWER);
        }
        return result;
    }

    // Builds a 8x8 table for Playfair
    private static char[][] buildTable(String key)
    {
        String all = "";
        for (int i = 0; i < key.length(); i++)
        {
            char c = key.charAt(i);
            if (all.indexOf(c) < 0)
            {
                all += c;
            }
        }
        for (char c = LOWER; c <= UPPER; c++)
        {
            if (all.indexOf(c) < 0)
            {
                all += c;
            }
        }
        char[][] table = new char[8][8];
        int pos = 0;
        for (int r = 0; r < 8; r++)
        {
            for (int c = 0; c < 8; c++)
            {
                table[r][c] = all.charAt(pos);
                pos++;
            }
        }
        return table;
    }

    private static List<String> makePairs(String text)
    {
        List<String> pairs = new ArrayList<>();
        int i = 0;
        while (i < text.length())
        {
            char a = text.charAt(i);
            char b;
            if (i + 1 < text.length())
            {
                b = text.charAt(i + 1);
                if (b == a)
                {
                    b = 'X';
                }
                else
                {
                    i++;
                }
            }
            else
            {
                b = 'X';
            }
            pairs.add("" + a + b);
            i++;
        }
        return pairs;
    }

    // Playfair encryption
    public static String playfairEncryption(String plain, String key)
    {
        char[][] table = buildTable(key);
        List<String> pairs = makePairs(plain);
        String result = "";
        for (String pr : pairs)
        {
            char a = pr.charAt(0);
            char b = pr.charAt(1);
            int r1 = 0, c1 = 0, r2 = 0, c2 = 0;
            // find positions
            for (int r = 0; r < 8; r++)
            {
                for (int c = 0; c < 8; c++)
                {
                    if (table[r][c] == a)
                    {
                        r1 = r; c1 = c;
                    }
                    if (table[r][c] == b)
                    {
                        r2 = r; c2 = c;
                    }
                }
            }
            if (r1 == r2)
            {
                result += table[r1][(c1 + 1) % 8];
                result += table[r2][(c2 + 1) % 8];
            }
            else if (c1 == c2)
            {
                result += table[(r1 + 1) % 8][c1];
                result += table[(r2 + 1) % 8][c2];
            }
            else
            {
                result += table[r1][c2];
                result += table[r2][c1];
            }
        }
        return result;
    }

    // Playfair decryption
    public static String playfairDecryption(String cipher, String key)
    {
        char[][] table = buildTable(key);
        List<String> pairs = new ArrayList<>();
        for (int i = 0; i < cipher.length(); i += 2)
        {
            pairs.add(cipher.substring(i, i + 2));
        }
        String result = "";
        for (String pr : pairs)
        {
            char a = pr.charAt(0);
            char b = pr.charAt(1);
            int r1 = 0, c1 = 0, r2 = 0, c2 = 0;
            for (int r = 0; r < 8; r++)
            {
                for (int c = 0; c < 8; c++)
                {
                    if (table[r][c] == a)
                    {
                        r1 = r; c1 = c;
                    }
                    if (table[r][c] == b)
                    {
                        r2 = r; c2 = c;
                    }
                }
            }
            if (r1 == r2)
            {
                result += table[r1][(c1 + 7) % 8];
                result += table[r2][(c2 + 7) % 8];
            }
            else if (c1 == c2)
            {
                result += table[(r1 + 7) % 8][c1];
                result += table[(r2 + 7) % 8][c2];
            }
            else
            {
                result += table[r1][c2];
                result += table[r2][c1];
            }
        }
        StringBuilder sb = new StringBuilder(result);
        for (int i = 1; i < sb.length() - 1; i++)
        {
            if (sb.charAt(i) == 'X' && sb.charAt(i - 1) == sb.charAt(i + 1))
            {
                sb.deleteCharAt(i);
                break;
            }
        }
        // Removes filler X
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == 'X')
        {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}

