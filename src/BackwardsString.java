public class BackwardsString {
    private String string;
    private MyArrayStack<Character> stack;

    BackwardsString(String s) {
        this.string = s;
        stack = new MyArrayStack<>();
    }

    void makeBackwards() {
        char[] chars = this.string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            stack.push(chars[i]);
        }
        System.out.println(stack);
    }
}
