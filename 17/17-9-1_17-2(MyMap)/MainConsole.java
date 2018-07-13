package ourck.mainconsole;

import java.util.*;

public class MainConsole {
	
	public static void main(String[] args) {	
		MyMap<String, Integer> map = new MyMap<>();
		map.put("Apple!", 1);
		map.put("PineApple!", 2);
		System.out.println(map);
		map.put("PineApple!", 3); // Put the same key with different value.
		System.out.println(map);
	}
}

class MyMap<K,V> implements Map<K,V> {
	private List<K> keys = new LinkedList<>();
	private List<V> values = new LinkedList<>();
	@Override
	public void clear() {
		keys = new LinkedList<>();
		values = new LinkedList<>();
	}

	@Override
	public boolean containsKey(Object key) {
		return keys.contains(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return values.contains(value);
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		Set<Entry<K, V>> entrys = new HashSet<>();
		Iterator<K> kit = keys.listIterator();
		Iterator<V> vit = values.listIterator();
		while(kit.hasNext()) {
			MyMapEntry<K,V> entry = new MyMapEntry<>(kit.next(), vit.next());
			entrys.add(entry);
		}
		return entrys;
	}

	@Override
	public V get(Object key) {
		if(containsKey(key)) { return values.get(keys.indexOf(key)); }
		else return null;
	}

	@Override
	public boolean isEmpty() {
		return keys.isEmpty() && values.isEmpty();
	}

	@Override
	public Set<K> keySet() {
		return new HashSet<>(keys);
	}

	@Override
	public V put(K key, V value) {
		V oldValue = get(key); // Always return the old one.(?)
		if(!containsKey(key)) {
			keys.add(key);
			values.add(value);
		}
		else {
			values.set(keys.indexOf(key), value); // When the key has already existed.
		}
		return oldValue;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		keys.addAll(m.keySet());
		values.addAll(m.values());
	}

	@Override
	public V remove(Object key) { 
	// TODO ClassCastException
		V oldValue = get(key); // Always return the old one.(?)
		if(containsKey(key)) {
			keys.remove(key);
			values.remove(get(key));
		}
		return oldValue;
	}

	@Override
	public int size() {
		return keys.size(); // All the same!
	}

	@Override
	public Collection<V> values() {
		return values; // As LinkedList
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{ ");
		Iterator<K> kit = keys.listIterator();
		Iterator<V> vit = values.listIterator();
		while(kit.hasNext()) {
			sb.append(kit.next());
			sb.append("=");
			sb.append(vit.next());
			if(kit.hasNext())
				sb.append(", ");
			else
				sb.append(" ");
		}
		sb.append("}");
		return sb.toString();
	}
	
}

class MyMapEntry<K,V> implements Map.Entry<K, V> {
	private K key;
	private V value;
	public MyMapEntry(K key, V val) {
		this.key = key;
		this.value = val;
	}
	
	@Override
	public K getKey() {
		return key;
	}

	@Override
	public V getValue() {
		return value;
	}

	@Override
	public V setValue(V value) {
		this.value = value;
		return this.value;
	}
	
	@Override
	public int hashCode() {
		int hashval = 0;
		if(key != null) {
			hashval += key.hashCode();
			if(value != null) {
				hashval ^= value.hashCode();
			}
		}
		return hashval;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof MyMapEntry)) return false;
		MyMapEntry mme = (MyMapEntry)obj; // Raw type cause warnings.
		if(mme.key != null) {
			if(mme.key.equals(key)) {
				return mme.value == null ? 
						value == null : mme.value.equals(value);	// 1."K1 = K2, V1 = V2?"
			}
			else return false;										// 2."K1 != K2"
		}
		else return key == null;									// 3."K1 = NULL, K2 =  NULL?"
	}
}