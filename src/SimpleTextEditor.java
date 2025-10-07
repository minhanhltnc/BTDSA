import java.util.*;
public class SimpleTextEditor {
    private StringBuilder text;
    private Stack<Operation> history;
    private static class Operation {
        String type; // "append" hoặc "delete"
        String data; // dữ liệu cần khôi phục

        Operation(String type, String data) {
            this.type = type;
            this.data = data;
        }
    }
    public SimpleTextEditor() {
        text = new StringBuilder();
        history = new Stack<>();
    }
    public void print(int k) {
        if (k > 0 && k <= text.length()) {
            System.out.println(text.charAt(k - 1));
        } else {
            System.out.println("Vị trí không hợp lệ");
        }
    }

    public void append(String w){
        text.append(w);
        history.push(new Operation("append",w));//luu thao tac va chuoi da them
    }
    public void delete(int k) {
        int start = text.length() - k;
        String deleted = text.substring(start);//lay subtring tu start den het
        text.delete(start, text.length());//xoa tu start den truoc vi tri length
        // vi du "abcd", start=2,length=4,se xoa tu a[2]den a[4-1]
        history.push(new Operation("delete", deleted));
    }
    public void undo() {
        if (history.isEmpty()) return;

        Operation last = history.pop();//lay ra thao tac cuoi
        if (last.type.equals("append")) {
            int len = last.data.length();//data la chuoi w vua them vao
            text.delete(text.length() - len, text.length());
        } else if (last.type.equals("delete")) {
            text.append(last.data);//data la chuoi minh vua xoa
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt(); // số lượng thao tác
        sc.nextLine(); // bỏ dòng thừa

        SimpleTextEditor editor = new SimpleTextEditor();

        for (int i = 0; i < Q; i++) {
            String[] parts = sc.nextLine().split(" ");
            // doc 1 dong thao tac va tach thanh mang
            //Vd "1 Wc" thi se tach part[0]="1",part[1]="Wc"
            int type = Integer.parseInt(parts[0]);

            switch (type) {
                case 1:
                    editor.append(parts[1]);
                    break;
                case 2:
                    editor.delete(Integer.parseInt(parts[1]));
                    break;
                case 3:
                    editor.print(Integer.parseInt(parts[1]));
                    break;
                case 4:
                    editor.undo();
                    break;
                default:
                    System.out.println("Thao tác không hợp lệ");
            }
        }
    }








}
