package com.yeyu.base.Object通用方法;


/**
 * public final native Class<?> getClass()
 *
 * public native int hashCode()
 *
 * public boolean equals(Object obj)
 *
 * protected native Object clone() throws CloneNotSupportedException
 *
 * public String toString()
 *
 * public final native void notify()
 *
 * public final native void notifyAll()
 *
 * public final native void wait(long timeout) throws InterruptedException
 *
 * public final void wait(long timeout, int nanos) throws InterruptedException
 *
 * public final void wait() throws InterruptedException
 *
 * protected void finalize() throws Throwable {}
 */

public class ObjectTest {
    public static void main(String[] args) {
        testEquals2();

        System.out.println(ObjectTest.class.getClass());;
        try {
            int x = 1/0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void testEquals() {
        Object a = null;
        a.equals(null);
    }

    static void testEquals2() {
        Integer x = new Integer(128);
        Integer y = new Integer(128);
        System.out.println(x.equals(y)); // true
        System.out.println(x == y);      // false
    }

    class EqualExample {
        private int x;
        private int y;
        private int z;

        public EqualExample(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            EqualExample that = (EqualExample) o;

            if (x != that.x) return false;
            if (y != that.y) return false;
            return z == that.z;
        }
    }


}
