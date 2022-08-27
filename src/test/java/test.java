import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class User{
    private Integer id;
    private Integer gender;
    private String name;

    public User(Integer id, Integer gender, String name) {
        this.id = id;
        this.gender = gender;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取该实体类是否重复的依据，依据是一个String, 这里就是姓名+性别
     * @return
     */
    public String getUniqueKey() {
        return this.name + '-' + this.gender;
    }
}

public class test {
    public static void main(String[] args) {
        // 构造测试数据
        ArrayList<User> records = new ArrayList<>();
        for (int i=0; i<20; i++) {
            records.add(new User(i,i%2, String.valueOf(i%3)));
        }
        // 根据性别和姓名作为key  统计重复的数据
        Map<String, List<Integer>> integerListMap = new HashMap<>();

        for (int i=0; i<records.size(); i++) {
            User record = records.get(i);
            String uniqueKey = record.getUniqueKey();
            if(!integerListMap.containsKey(uniqueKey)) {
                integerListMap.put(uniqueKey, new ArrayList<Integer>());
            }
            List<Integer> ids = integerListMap.get(uniqueKey);
            ids.add(record.getId());
        }
    }
}
