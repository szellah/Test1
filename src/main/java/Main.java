public class Main {
    public static void main(String[] args) {
        SimpleWzimBoundedQueue<String> q = new SimpleWzimBoundedQueue<String>(4);
        q.add("Siema");
        q.add("Hhej");
        q.add("Hhej");
        q.add("Hhej");
        System.out.println(q.remove());
        q.add("koniec");
    }
}
