package DataStructure;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Iterator;

public class RLists {
    private LinkedList<String> l = new LinkedList<>();

    public Type getType() {
        return Type.STRING;
    }

    public int len(){
        return l.size();
    }
    public void lPush(String val) {
        this.l.addFirst(val);
    }

    public void rPush(String val) {
        this.l.addLast(val);
    }

    public String lPop() throws Exception {
        if (this.l.isEmpty()) {
            throw new Exception("(nil)");
        }
        return this.l.removeFirst();
    }

    public String rPop() throws Exception {
        if (this.l.isEmpty()) {
            throw new Exception("(nil)");
        }
        return this.l.removeLast();
    }
    
    public int lRemove(String str){
        Iterator<String> iterator = l.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            if (iterator.next().equals(str)) {
                iterator.remove();
                count++;
            }
        }
        return count;
    }

    public String getValueByIdx(int num) throws Exception {
        if (num >= this.l.size() || num < 0) {
            throw new Exception("(nil)");
        }
        return this.l.get(num);
    }

    public String[] lRange(int left, int right) {
        int size = l.size();

        if (left < 0)
            left = size + left;
        if (right < 0)
            right = size + right;

        left = Math.max(0, left);
        right = Math.min(right, size - 1);

        if (left > right || left >= size) {
            return new String[0]; // return empty array
        }

        String[] result = new String[right - left + 1];
        for (int i = left; i <= right; i++) {
            result[i - left] = l.get(i);
        }
        return result;
    }

    public void lTrim(int start, int end) {
        int size = l.size();
        if (start < 0)
            start = size + start;
        if (end < 0)
            end = size + end;

        start = Math.max(0, start);
        end = Math.min(end, size - 1);

        if (start > end || start >= size) {
            l.clear();
            return;
        }

        for (int i = 0; i < start; i++) {
            l.removeFirst();
        }

        while (l.size() > (end - start + 1)) {
            l.removeLast();
        }
    }

    public void lSet(int index, String value) throws Exception {
        if (index < 0 || index >= l.size()) {
            throw new Exception("ERR index out of range");
        }
        l.set(index, value);
    }
}
