package org.xtwy.nio.thrift;

import java.util.Map;
import java.util.TreeMap;

/**
 * #author qinghao
 * #date 2019-04-27 12:48
 */
public class HashCodeTest {

    public static void main(String[] args) {
        User user = new User(1,"31321");
        User user2 = new User(2,"31321");

        System.out.println(user);
        System.out.println(user2);


        User user3 = user2;


        user2.key = user.key;
        user2.value = user.value;

        user2 = user;

        System.out.println(user2);

    }


    static class User {
        Integer key ;
        String value;

        public User(Integer key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int hashCode() {

            int keyHash = (key==null ? 0 : key.hashCode());
            int valueHash = (value==null ? 0 : value.hashCode());
            return keyHash ^ valueHash;

        }

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean equals(Object o) {
            if (!(o instanceof User))
                return false;

            User e = (User) o;

            return valEquals(key,e.getKey()) && valEquals(value,e.getValue());
        }
        static final boolean valEquals(Object o1, Object o2) {
            return (o1==null ? o2==null : o1.equals(o2));
        }
    }
}
