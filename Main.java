import java.util.Scanner;

public class Main {

    static class Link {
        char ch;
        int index;
        Link next;
    }

    static class ListLink {
        Link first;
        int size = 0;

        public void push(char ch, int index) {
            size++;
            Link link = new Link();
            link.index = index;
            link.ch = ch;
            if (first == null) {
                first = link;
            } else {
                link.next = first;
                first = link;
            }
        }

        public Link pop() {
            if (!isEmpty()) {
                Link link = first;
                first = first.next;
                size--;
                return link;
            }
            return null;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }

    public static int checkPrant(String string) {
        ListLink stack = new ListLink();
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            switch (ch) {
                case '(':
                case '[':
                case '{':
                    stack.push(ch, i+1);
                    break;
            }

            switch (ch) {
                case ')':
                    if (!stack.isEmpty()) {
                        Link top = stack.pop();
                        if (top.ch != '(') {
                            return i+1;
                        }
                    } else {
                        return i+1;
                    }
                    break;
                case ']':
                    if (!stack.isEmpty()) {
                        Link top = stack.pop();
                        if (top.ch != '[') {
                            return i+1;
                        }
                    } else {
                        return i+1;
                    }
                    break;
                case '}':
                    if (!stack.isEmpty()) {
                        Link top = stack.pop();
                        if (top.ch != '{') {
                            return i+1;
                        }
                    } else {
                        return i+1;
                    }
                    break;
            }
        }

        if (!stack.isEmpty()) {
            return stack.pop().index;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int index = 0;
        
        if((index = checkPrant(new Scanner(System.in).nextLine())) == 0) {
            System.out.println("Success");
        } else {
            System.out.println(index);
        }
    }
}
