import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StrmamDemo {
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
        })
                .sorted(((o1, o2) -> {
                    return o2.compareTo(o1);
                })).limit(1);
        limit.forEach(l->{System.out.println(l);});
    }








}
/**
 * @auther zzyy
 * @create 2019-02-26 22:24
 *
 * 题目：请按照给出数据，找出同时满足以下条件的用户,也即以下条件全部满足
 *      偶数ID且年龄大于24
 *      且用户名转为大写
 *      且用户名字母倒排序
 *      只输出一个用户名字
 */


