/**
 * This class represents GFA test cases for a CryptoManager object.
 * 
 * @author Huseyin Aygun
 * @version 5/3/2025
 */
package crypto.test;

import crypto.CryptoManager;
import junit.framework.TestCase;

public class CryptoManagerTestStudent extends TestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testIsStringInBounds() {
        assertTrue(CryptoManager.isStringInBounds("MONTGOMERY 2025!"));
        assertFalse(CryptoManager.isStringInBounds("Montgomery 2025!"));
        assertFalse(CryptoManager.isStringInBounds("MONtGOMERY#$%!_-"));
    }

    public void testVigenereEncryptDecrypt() {
        String plain = "HELLO";
        String key   = "KEY";

        String encrypted = CryptoManager.vigenereEncryption(plain, key);
        assertEquals("3*E74", encrypted);

        String decrypted = CryptoManager.vigenereDecryption(encrypted, key);
        assertEquals(plain, decrypted);
    }

    public void testVigenereEmptyKey() {
        assertEquals("Key is empty", CryptoManager.vigenereEncryption("HELLO", ""));
        assertEquals("Key is empty", CryptoManager.vigenereDecryption("HELLO", ""));
    }

    public void testPlayfairEncryptDecrypt() {
        String plain = "HELLO";
        String key   = "KEY";

        String encrypted = CryptoManager.playfairEncryption(plain, key);
        assertEquals("GYG]FT", encrypted);

        String decrypted = CryptoManager.playfairDecryption(encrypted, key);
        assertEquals(plain, decrypted);
    }

    public void testPlayfairSingleLetter() {
        String encrypted = CryptoManager.playfairEncryption("A", "KEY");
        assertEquals(">\\", encrypted);

        String decrypted = CryptoManager.playfairDecryption(encrypted, "KEY");
        assertEquals("A", decrypted);
    }
}



