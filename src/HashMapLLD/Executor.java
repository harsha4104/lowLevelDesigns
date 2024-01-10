package HashMapLLD;

public class Executor {

    public static void main(String[] args){

        Map<Integer, Integer> map = new MapImpl<>(5,0.75);

        map.put(1, 5);
        map.put(2, 6);
        map.put(3, 7);
        map.put(4, 8);
        map.put(5, 6);
        map.put(6, 7);
        map.put(7, 8);

        System.out.println(map.get(1));
        System.out.println(map.size());
        System.out.println(map.get(7));

        map.remove(4);

        System.out.println(map.get(7));
        System.out.println(map.size());
    }
}
