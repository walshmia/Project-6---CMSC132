package bslt;

import java.util.Collections;

/*  Mia Walsh, CMSC132 - 0303 
 * The NonemptyBSLT class represents a nonempty object in a binary search tree.
 * A NonemptyBSLT has a generic comparable K called key, a generic V called 
 * value, and a left and right BSLT reference. 
 * I pledge on my honor that I have not given nor received any unauthorized 
 * assistance on this assignment. */

@SuppressWarnings("unchecked")
public class NonemptyBSLT<K extends Comparable<K>, V> implements BSLT<K, V> {
	
	private K key;
	private V value;
	private BSLT<K,V> right, left;
	
	public NonemptyBSLT(K key, V value) {
		
		this.key = key;
		this.value = value;
	
		right = left = EmptyBSLT.getInstance();;
	}

	/* Inserts a new key with the associated value into the tree if it has not
	 * already been added while keeping the binary search property. If the key
	 * has been added, the associated value will be updated with "newValue"
	 * @param newKey The key wanting to be added to the tree
	 * @param newValue The value associated with the key
	 * @return a reference to the current tree */
	
    public NonemptyBSLT<K, V> insertKeyWithValue(K newKey, V newValue) {
    	
        if (newKey != null && newValue != null) {
        	
        	if (newKey.compareTo(key) < 0) { // In left subtree
        		left = left.insertKeyWithValue(newKey, newValue);
        		
        	} else if (newKey.compareTo(key) > 0) { // In right subtree
        		right = right.insertKeyWithValue(newKey, newValue);
        		
        	} else { // Key already added
        		this.value = newValue;
        	}
        	
        	return this;
        }
        
        // Throw exception if either parameter is null
        throw new IllegalArgumentException("Illegal argument");
    }

    /* Calculates the size of the tree by traversing through every object.
     * @return the number of key/value pairs in the tree */
    
    public int sizeOfTree() {
        return 1 + right.sizeOfTree() + left.sizeOfTree();
    }

    /* Returns the value for the associated "targetKey" parameter. If 
     * "targetKey" is null, an exception is thrown. 
     * @param targetKey The key whose value will be returned if found
     * @return the associated value for "targetKey" */
    
    public V lookupValueForKey(K targetKey) {
    	
    	if (targetKey != null) {
    		
    		if (targetKey.compareTo(key) < 0) {
    			return this.left.lookupValueForKey(targetKey);
    			
    		} else if (targetKey.compareTo(key) > 0) {
    			return this.right.lookupValueForKey(targetKey);
    			
    		} else { // targetKey is equal to key
    			return this.value;
    		}
    	}
    	
        throw new IllegalArgumentException("Illegal argument");
    }

    /* The largest key will be the rightmost BSLT object due to the binary
     * search property. An exception is thrown if the tree is empty.
     * @return the largest key in the tree */
    
    public K largestKey() throws EmptyBSLTException {
    	
        try {
        	return this.right.largestKey();
        	
        } catch (EmptyBSLTException e) {
        	return key;
        }
    }

    /* The smallest key will be the leftmost BSLT object due to the binary 
     * search property. An exception is thrown if the tree is empty.
     * @return the smallest key in the tree */
    
    public K smallestKey() throws EmptyBSLTException {
    	
        try {
        	return this.left.smallestKey();
        	
        } catch (EmptyBSLTException e) {
        	return key;
        }
    }

    /* This method traverses through the tree and finds the parent of 
     * "targetKey." An exception is thrown if "targetKey" is null.
     * @param targetKey The key whose parent will be found
     * @return the key of "targetKey's" parent */
    
    public K parent(K targetKey) {
    	
        if (targetKey != null) {
        	return parent(targetKey, null);
        }
        
        throw new IllegalArgumentException("Illegal argument");
    }

    /* Removes the NonemptyBSLT object with key "targetKey" from the tree.
     * An exception is thrown if "targetKey" is null.
     * @param targetKey The key attempting to be deleted
     * @return a reference to the tree after deletion */
    
    public BSLT<K, V> removeKeyWithValue(K targetKey) {
    	
        if (targetKey != null) {
        	
        	if (targetKey.compareTo(key) < 0) {
        		left = left.removeKeyWithValue(targetKey);
        		
        	} else if (targetKey.compareTo(key) > 0) {
        		right = right.removeKeyWithValue(targetKey);
        		
        	} else {
        		
        		try {
        			this.key = left.largestKey();
        			this.value = left.lookupValueForKey(key);
        			left = left.removeKeyWithValue(key);	
        			
        		} catch (EmptyBSLTException e) {
        			// There is no left subtree
        			
        			try {
        				this.key = right.smallestKey();
        			    this.value = right.lookupValueForKey(key);
        			    right = right.removeKeyWithValue(key);
        			    	
        			} catch (EmptyBSLTException f) { 
        				return EmptyBSLT.getInstance();
        			}
        		}
        	}
        	
        	return this;
        }
        
        throw new IllegalArgumentException("Illegal argument");
    }

    public String toString() {
        return left + "" + key + "+" + value + " " + right;
    }
    
    // Helper method
    
    public K parent(K targetKey, K parentKey) {
    	
        if (targetKey.compareTo(key) < 0) {
        	parentKey = key;
        	return left.parent(targetKey, parentKey);
        		
       	} else if (targetKey.compareTo(key) > 0) {
       		parentKey = key;
       		return right.parent(targetKey, parentKey);
        		
       	} else {
       		return parentKey; // Returns null if targetKey is the root
        }
    }
}
