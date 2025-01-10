    package org.example.entities;
    import lombok.Getter;
    import lombok.Setter;

    import java.io.Serializable;
    @Getter
    @Setter
    public class Counter implements Serializable {
        private int count;

        public Counter() {
            count = 0;
        }

        public int getCount() {
            return count;
        }

        public void increment() {
            count++;
        }
    }
