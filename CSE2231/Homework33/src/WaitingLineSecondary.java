import java.util.Iterator;

import components.queue.Queue;
import components.queue.Queue2;

/**
 * Waiting Line Method Implementation.
 *
 * @author Tory Yang
 *
 */

/**
 *
 * @author Tory Yang
 *
 * @param <T>
 */
public abstract class WaitingLineSecondary<T> implements WaitingLine<T> {

    @Override
    public boolean equals(Object obj) {
        boolean flag = true;

        if (obj == this) {
            flag = true;
        } else if (obj == null) {
            flag = false;
        } else if (!(obj instanceof WaitingLine<T>)) {
            flag = false;
        } else {

            WaitingLine<T> line = (WaitingLine<T>) obj;
            if (this.length() != line.length()) {
                flag = false;
            }

            Iterator<T> it1 = this.iterator();
            Iterator<?> it2 = line.iterator();

            while (it1.hasNext()) {

                T x1 = it1.next();
                Object x2 = it2.next();

                if (!x1.equals(x2)) {
                    flag = true;
                }
            }
        }
        return flag;
    }

    @Override
    public int hashCode() {
        final int samples = 2;
        final int a = 37;
        final int b = 17;
        int result = 0;
        int n = 0;

        Iterator<T> it = this.iterator();

        while (n < samples && it.hasNext()) {
            T x = it.next();
            result = a * result + b * x.hashCode();
            n++;
        }

        return result;
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder("<");

        Iterator<T> it = this.iterator();

        while (it.hasNext()) {

            result.append(it.next());

            if (it.hasNext()) {
                result.append(",");
            }

        }

        result.append(">");

        return result.toString();
    }

    @Override
    public void add(T x) {
        this.entries.enqueue(this.length, x);
        this.length++;
    }

    @Override
    public T removeFirst() {
        T x = this.entries.dequeue();
        this.length--;
        return x;
    }

    @Override
    public int length() {
        return this.length;
    }

    @Override
    public int position(T entry) {

        int length = this.length();

        int position = 0;

        for (int i = 0; i < length; i++) {

            if (this.front().equals(entry)) {
                position = i;
            }

            this.enqueue(this.dequeue());
        }
        return position;

    }

    @Override
    public boolean contains(T entry) {
        boolean flag = false;
        int i = 0;

        while (i < this.length() && !flag) {

            T x = this.dequeue();
            if (x.equals(entry)) {
                flag = !flag;
            }
            this.entries.enqeue(x);
            i++;

        }
        return flag;
    }

    @Override
    public T remove(int pos) {

        int i = 0;
        Queue<T> temp = new Queue2<T>();

        while (i < pos) {
            T x = this.entries.dequeue();
            temp.enqueue(x);
            i++;
        }

        temp.append(this.entries);
        this.entries.transferFrom(temp);

        this.length--;
        return x;
    }
}
