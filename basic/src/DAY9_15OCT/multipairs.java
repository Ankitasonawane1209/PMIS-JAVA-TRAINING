
package DAY9_15OCT;

//class Pair<K, V> {
//    private K key;
//    private V value;
//
//    Pair(K key, V value) {
//        this.key = key;
//        this.value = value;
//    }
//
//    K getKey() {
//        return key;
//    }
//
//    V getValue() {
//        return value;
//    }
//}
//
//public class multipairs {
//    public static void main(String[] args) {
//
//        Pair<String, Integer> p = new Pair<>("Age", 25);
//
//        String k = p.getKey();
//        Integer v = p.getValue();
//
//        System.out.println(k + ":" + v);
//    }
//}



//code without generies




class Pair {
    private Object key;
    private Object value;

    Pair(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    Object getKey() {
        return key;
    }

    Object getValue() {
        return value;
    }
}

class multipairs {
    public static void main(String[] args) {

        Pair p = new Pair("age", 25);

        String K = (String) p.getKey();
        Integer V = (Integer) p.getValue();

        System.out.println(K+ ":" + V);
    }
}
