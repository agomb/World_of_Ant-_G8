
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
    int idKey;
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
        
        idKey = 3;//creation of a id for a key. This key will also be used inside the test
        aLock  = new Lock(idKey); //creation of the lock object for the tests
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
     * Verify if the lock is locked
     * By default this test should fail
     */
    public void testGetIsLockInvalid()
    {
        assertEquals(aLock.getIsLocked(),false);
        
    }
    @Test
    /**
     * test if the unlock method change correctly the isLocked attribut
     * the test is true if the method work correctly
     */
    public void testUnlockValid()
    {
        aLock.unlock(idKey);
        assertEquals(aLock.getIsLocked(),false);
        
    }
    @Test
    /**
     * test if the unlock method change correctly the isLocked attribut
     * the test is false if the method work correctly
     */
    public void testUnlockInvalid()
    {
        aLock.unlock(idKey);
        assertEquals(aLock.getIsLocked(),true);
        
    }
    @Test
    /**
     * test if the unlock method return the correct verification
     * the test should be true if the method work correctly
     */
    public void testUnlockReturnValid()
    {
        
        assertEquals(aLock.unlock(idKey),true);
        
    }
    @Test
    /**
     * test if the unlock method return the incorrect verification
     * the test should be fase if the method work correctly
     */
    public void testUnlockReturnInvalid()
    {
        
        assertEquals(aLock.unlock(idKey),false);
        
    }
    @Test
    /**
     * test if the unlock method return the correct verification in the case when the object is already unlocked
     * the test should be true if the method work correctly
     */
    public void testUnlockReturnOpen()
    {
        aLock.unlock(idKey);
        assertEquals(aLock.unlock(idKey),true);
        
    }
    @Test
    /**
     * test if the unlock method return the correct verification in the case when the object is already unlocked 
     * but no keys are given to unlock the object
     * the test should be true if the method work correctly
     */
    public void testUnlockReturnAlreadyOpenWithoutKey()
    {
        aLock.unlock(idKey);
        assertEquals(aLock.unlock(),true);
        
    }
    @Test
    /**
     * test if the unlock method return the correct verification in the case when the object is locked
     * but no keys are given to unlock the object
     * the test should be true if the method work correctly
     */
    public void testUnlockReturnCloseWithoutKey()
    {
        assertEquals(aLock.unlock(),false);
        
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
