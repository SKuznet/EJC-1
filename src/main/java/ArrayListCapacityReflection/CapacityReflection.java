package ArrayListCapacityReflection;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class CapacityReflection {

    /**
     * Adds elements into ArrayList and prints its capacity
     *
     * @param args command line arguments
     * @throws Exception one of exceptions thrown
     *                   by {@link #getCapacity} method
     */
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<>(3);

        for (int i = 0; i < 17; i++) {
            list.add(i);
            System.out.format("Size: %2d, Capacity: %2d%n",
                    list.size(), getCapacity(list));
        }
    }

    /**
     * Gets list capacity by setting elementData field
     * accessible using Reflection API
     *
     * @param list list of any type
     * @return int          list capacity
     * @throws Exception it could be one of these:
     *                   NoSuchFieldException, SecurityException,
     *                   IllegalArgumentException, IllegalAccessException
     */
    private static int getCapacity(ArrayList<?> list) throws Exception {
        Field dataField = ArrayList.class.getDeclaredField("elementData");
        dataField.setAccessible(true);
        return ((Object[]) dataField.get(list)).length;
    }
}
