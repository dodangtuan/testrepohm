import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

@FunctionalInterface
interface sayable {
    void say();
}

public class Main {
    public static void main(String[] args) {
        /* LAMBDA EXPRESSION*/
        //Sắp xếp một danh sách
//        List<String> ls = Arrays.asList("PHP", "C#", "JAVA", "HTML", "Python");
//        System.out.println(ls);
//        Collections.sort(ls, (o1, o2) -> o1.compareTo(o2));
//        System.out.println(ls);

        /* FUNCTIONAL INTERFACE */

//        Function<Integer, Double> rs = a -> a/2.0;
//        System.out.println(rs.apply(10));

        /* COMSUMER INTERFACE */

//        Consumer<Integer> cs = new Consumer<Integer>() {
//            @Override
//            public void accept(Integer x) {
//                System.out.println("Ban da " + x + " tuoi roi..");
//            }
//        };
//        cs.accept(34);

        /* PREDICATE INTERFACE */

//        Predicate<String> pr = (name) -> {
//            return name.equalsIgnoreCase("hanoi");
//        };
//
//        if(pr.test("Ha Noi")) {
//            System.out.println("Chuoi khop nhau");
//        }else{
//            System.out.println("Chuoi khong khop nhau");
//        }
    }
}
