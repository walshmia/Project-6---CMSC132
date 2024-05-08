package bslt;

/*  Mia Walsh, CMSC132 - 0303 
 * An EmptyBSLT is the singleton class representing empty objects in a tree.
 * The only field an EmptyBSLT has is the static reference to the only 
 * instance of an EmptyBSLT. All methods are used as the base case in
 * traversing a tree.
 * I pledge on my honor that I have not given nor received any unauthorized 
 * assistance on this assignment. */

@SuppressWarnings({"unchecked", "rawtypes"})
public class EmptyBSLT<K extends Comparable<K>, V> implements BSLT<K, V> {
	
	private static EmptyBSLT EMPTY_BSLT = new EmptyBSLT();
	
	private EmptyBSLT() {}

    public static EmptyBSLT getInstance() {
        return EMPTY_BSLT;
    }

    // @return a NonemptyBSLT object to be inserted in the tree
    
    public NonemptyBSLT<K, V> insertKeyWithValue(K newKey, V newValue) {
    	
    	if (newKey!= null && newValue != null) {
    		return new NonemptyBSLT<K, V>(newKey, newValue);
    	}
    	
    	throw new IllegalArgumentException("Illegal argument");
    }

    // @return 0 when an empty BSLT reference is reached
    
    public int sizeOfTree() {
        return 0;
    }

    // @return null if "targetKey" is not in the tree
    
    public V lookupValueForKey(K targetKey) {
    	if (targetKey == null) {
    		throw new IllegalArgumentException("illegal argument");
    	}
        return null;
    }

    // Throws an exception because an empty tree does not have a largest key
    
    public K largestKey() throws EmptyBSLTException {
        throw new EmptyBSLTException();
    }

    // Throws an exception because an empty tree does not have a smallest key
    
    public K smallestKey() throws EmptyBSLTException {
        throw new EmptyBSLTException();
    }

    // @return null if "targetKey" is not present in the tree
    
    public K parent(K targetKey) {
    	if (targetKey == null) {
    		throw new IllegalArgumentException("illegal argument");
    	}
        return null;
    }

    /* @return a reference to the current object if "targetKey" is not 
     * found in the tree */
    
    public BSLT<K, V> removeKeyWithValue(K targetKey) {
    	if (targetKey == null) {
    		throw new IllegalArgumentException("illegal argument");
    	}
        return this;
    }

    public String toString() {
        return "";
    }
    
    public K parent(K targetKey, K parentKey) {
    	return null;
    }

}
