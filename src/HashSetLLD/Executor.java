package HashSetLLD;

public class Executor {

    public static void main(String[] args){

        Set<Integer> set = new HashSet<Integer>(5,(float)0.75);

        set.add(1);
        set.add(2);
        set.add(3);

        System.out.println(set.contains(1));
        System.out.println(set.contains(4));
        System.out.println(set.size());

        set.remove(1);
        System.out.println(set.size());
        System.out.println(set.contains(1));
    }
}
