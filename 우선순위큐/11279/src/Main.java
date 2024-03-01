import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception,IOException {
        
        // 변수 설정
        int N, x;

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringBuilder
        StringBuilder sb = new StringBuilder();

        // 변수 입력
        N = Integer.parseInt(br.readLine());
        heap h = new heap();

        while(N-- > 0) {
            x = Integer.parseInt(br.readLine());
            if(x == 0) {
                sb.append(h.remove() + "\n");
            } else {
                h.insert(x);
            }
        }

        System.out.print(sb.toString());
    }   
}

class heap {
    int[] data;
    int size;
    int heapSize;

    heap() {
        this(30);
    }

    heap(int size) {
        this.size = size;
        this.heapSize = 0;
        this.data = new int[size];
    }

    void insert(int value) {
        if(this.heapSize + 1 >= this.size) {
            resize(this.size * 2);
        }
        data[++heapSize] = value;

        for(int index = heapSize; index >= 2 ; index /= 2) {
            int parent = data[index/2];
            if(value > parent) {
                swap(index/2, index);
            } else break;
        }
    }

    int remove() {

        if(isEmpty()) return 0;
        if(heapSize == 1) {
            int returnData = this.data[1];
            this.data[heapSize--] = 0;
            return returnData;
        }

        int toReplace = this.data[heapSize--];
        int returnData = this.data[1];
        this.data[1] = toReplace;

        replace(1);

        if(heapSize < size/2) {
            resize(size/2);
        }

        return returnData;
    }

    void replace(int pIndex) {
        int lIdx = pIndex * 2;
        int rIdx = pIndex * 2 + 1;

        boolean leftOver = lIdx > this.heapSize;
        boolean rightOver = rIdx > this.heapSize;

        if(leftOver) return;
        else if(!leftOver && rightOver) {
            if(this.data[pIndex] < this.data[lIdx]) {
                swap(pIndex, lIdx);
                replace(lIdx);
            } else return;
        } else if(!leftOver && !rightOver) {
            if(this.data[lIdx] > this.data[rIdx]) {
                if(this.data[pIndex] < this.data[lIdx]) {
                    swap(pIndex, lIdx);
                    replace(lIdx);
                } else return;
            } else {
                if(this.data[pIndex] < this.data[rIdx]) {
                    swap(pIndex, rIdx);
                    replace(rIdx);
                } else return;
            }
        }
    }

    void resize(int newSize) {
        int[] newArray = new int[newSize];

        for(int index = 1; index < this.size && index < newSize; index++) {
            newArray[index] = this.data[index];
        }

        this.data = null;
        this.data = newArray;
        this.size = newSize;
    }

    void swap(int pIdx, int cIdx) {
        int temp = this.data[pIdx];
        this.data[pIdx] = this.data[cIdx];
        this.data[cIdx] = temp;
    }

    int size() {
        return this.heapSize;
    }

    boolean isEmpty() {
        return size() == 0;
    }
}

