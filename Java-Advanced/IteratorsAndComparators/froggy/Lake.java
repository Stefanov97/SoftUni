import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> {
    private List<Integer> numbers;

    public Lake(List<Integer> numbers) {
        this.numbers = numbers;
    }


    public class Frog implements Iterator<Integer> {
        private List<Integer> firstJumped;
        private List<Integer> secondJumped;

        public Frog() {
            this.firstJumped = new ArrayList<>();
            this.secondJumped = new ArrayList<>();
        }

        public void addAll(List<Integer> nums) {
            for (int i = 0; i < nums.size(); i++) {
                if (i % 2 == 0) {
                    firstJumped.add(numbers.get(i));
                } else {
                    secondJumped.add(numbers.get(i));
                }
            }
        }

        public void setFirstJumped(List<Integer> firstJumped) {
            this.firstJumped = firstJumped;
        }

        public void setSecondJumped(List<Integer> secondJumped) {
            this.secondJumped = secondJumped;
        }

        public List<Integer> getFirstJumped() {
            return firstJumped;
        }

        public List<Integer> getSecondJumped() {
            return secondJumped;
        }

        int thisIndex = 0;

        @Override

        public boolean hasNext() {

            return thisIndex < numbers.size();
        }

        @Override
        public Integer next() {
            if (thisIndex % 2 == 0) {
                firstJumped.add(numbers.get(thisIndex));
            } else {
                secondJumped.add(numbers.get(thisIndex));
            }
            return numbers.get(thisIndex++);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < numbers.size();
            }

            @Override
            public Integer next() {
                return numbers.get(index++);
            }
        };
    }
}
