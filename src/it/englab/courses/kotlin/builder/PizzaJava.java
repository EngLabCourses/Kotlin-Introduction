package it.englab.courses.kotlin.builder;

public class PizzaJava {

    private int size;
    private boolean tomato;
    private boolean mozzarella;
    private boolean ham;
    private boolean sausage;
    private boolean mushrooms;
    private boolean pineapple;

    private PizzaJava(Builder builder) {
        size = builder.size;
        tomato = builder.tomato;
        mozzarella = builder.mozzarella;
        ham = builder.ham;
        sausage = builder.sausage;
        mushrooms = builder.mushrooms;
        pineapple = builder.pineapple;
    }

    public static final class Builder {
        private int size;
        private boolean tomato = false;
        private boolean mozzarella = false;
        private boolean ham = false;
        private boolean sausage = false;
        private boolean mushrooms = false;
        private boolean pineapple = false;

        public Builder(int size) {
            this.size = size;
        }

        public Builder tomato(boolean val) {
            tomato = val;
            return this;
        }

        public Builder mozzarella(boolean val) {
            mozzarella = val;
            return this;
        }

        public Builder ham(boolean val) {
            ham = val;
            return this;
        }

        public Builder sausage(boolean val) {
            sausage = val;
            return this;
        }

        public Builder mushrooms(boolean val) {
            mushrooms = val;
            return this;
        }

        public Builder pineapple(boolean val) {
            pineapple = val;
            return this;
        }

        public PizzaJava build() {
            return new PizzaJava(this);
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isTomato() {
        return tomato;
    }

    public boolean isMozzarella() {
        return mozzarella;
    }

    public boolean isHam() {
        return ham;
    }

    public boolean isSausage() {
        return sausage;
    }

    public boolean isMushrooms() {
        return mushrooms;
    }

    public boolean isPineapple() {
        return pineapple;
    }

    @Override
    public String toString() {
        return "PizzaJava{" +
                "size=" + size +
                ", tomato=" + tomato +
                ", mozzarella=" + mozzarella +
                ", ham=" + ham +
                ", sausage=" + sausage +
                ", mushrooms=" + mushrooms +
                ", pineapple=" + pineapple +
                '}';
    }
}
