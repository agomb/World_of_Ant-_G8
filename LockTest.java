
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class of the Lock class.
 *
 * @author  Crouzet G8
 * @version 19/11/2019
 */
public class LockTest
{
    Key aKey;
    Lock aLock;
    
    /**
     * Default constructor for test class LockTest
     */
    public LockTest()
    {
    }

    /**
     * Sets up the different element needed for the different test
     */
    @Before
    public void setUp()
    {
        
        aKey = new Key("testkey");//creation of a id for a key. This key will also be used inside the test
        aLock  = new Lock(aKey); //creation of the lock object for the tests
    }
    @Test
    /**
     * Verify if the lock is locked
     * By default this test should be true
     */
    public void testGetIsLockValid()
    {
        assertEquals(aLock.getIsLocked(),true);
        
    }
    
    @Test
    /**
     * Verify if the lock is unlocked correcly with the key
     * 
     */
    public void testUnlock()
    {
        assertEquals(aLock.unlock(aKey),true);
        
    }
    @Test
    /**
     * Verify if the lock is unlocked correcly
     * 
     */
    public void testAlreadyUnlock()
    {
        aLock.unlock(aKey);
        assertEquals(aLock.unlock(aKey),true);
        
    }
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
