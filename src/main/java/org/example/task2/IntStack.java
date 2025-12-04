package ua.opnu;

/**
 * Стек цілих чисел, реалізований за допомогою масиву.
 * Зовнішній користувач не знає про реалізацію через масив.
 */
public class IntStack {

    private static final int INITIAL_CAPACITY = 10;

    private int[] data;
    private int size; // кількість елементів у стеку

    public IntStack() {
        this.data = new int[INITIAL_CAPACITY];
        this.size = 0;
    }

    /**
     * Додає елемент у стек (на "верх").
     */
    public void push(int value) {
        ensureCapacity();
        data[size] = value;
        size++;
    }

    /**
     * Витягує елемент зі стека.
     * Якщо стек порожній — кидає IllegalStateException
     * (можна обрати іншу політику, але це найпростіший варіант).
     */
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        size--;
        return data[size];
    }

    /**
     * Повертає елемент з вершини, не видаляючи його.
     */
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return data[size - 1];
    }

    /**
     * Повертає true, якщо стек порожній.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Поточний розмір стека (кількість елементів).
     */
    public int size() {
        return size;
    }

    private void ensureCapacity() {
        if (size == data.length) {
            int[] newData = new int[data.length * 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
    }
}
