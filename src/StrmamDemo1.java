import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StrmamDemo1 {


    public static void main(String[] args) {
        User u1 = new User(11,"a",23);
        User u2 = new User(12,"b",24);
        User u3 = new User(13,"c",22);
        User u4 = new User(14,"d",28);
        User u5 = new User(16,"e",26);
        List<User> list = Arrays.asList(u1,u2,u3,u4,u5);
        Stream<String> limit = list.stream().filter(u -> {
            return u.getId() % 2 == 0;
        }).filter(u -> {
            return u.getAge() > 24;
        }).map(u -> {
            return u.getUserName().toUpperCase();
        }).sorted(((o1, o2) -> {
            return o2.compareTo(o1);
        }))
                .limit(1);
        limit.forEach(u->{System.out.println(u);});
    }
}
