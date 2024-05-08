package bslt;

// (c) Larry Herman, 2024.  You are allowed to use this code yourself, but
// not to provide it to anyone else.

public interface BSLT<K extends Comparable<K>, V> {
    public NonemptyBSLT<K, V> insertKeyWithValue(K newKey, V newValue);
    public int sizeOfTree();
    public V lookupValueForKey(K targetKey);
    public K largestKey() throws EmptyBSLTException;
    public K smallestKey() throws EmptyBSLTException;
    public K parent(K targetKey);
    public K parent(K targetKey, K parentKey);
    public BSLT<K, V> removeKeyWithValue(K targetKey);
}
