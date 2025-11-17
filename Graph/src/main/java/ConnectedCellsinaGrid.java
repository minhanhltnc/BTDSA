import java.util.Arrays;
import java.util.List;

/** tìm vùng liên kết lớn nhất trong 1 mảng 2 chiều
 * sử dụng cách dfs
 * dfs: chạy để tìm kích thước vùng lớn nhất của 1 ô
 * connectecCell: duyệt mảng để tìm vùng có kích thước lớn nhẩt
 */

public class ConnectedCellsinaGrid {
    public static int connectedCell(List<List<Integer>> matrix){
        int n= matrix.size();
        int m=matrix.get(0).size();
        boolean[][] visited =new boolean[n][m];
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if (matrix.get(i).get(j) == 1 && !visited[i][j]) {
                    int size = dfs(matrix, visited, i, j);
                    max = Math.max(max, size);
                }
            }
        }
        return  max;
    }


    private static int dfs(List<List<Integer>> matrix, boolean[][] visited, int i, int j) {
        int n = matrix.size();
        int m = matrix.get(0).size();

        if (i < 0 || i >= n || j < 0 || j >= m || visited[i][j] || matrix.get(i).get(j) == 0) {
            return 0;
        }
        visited[i][j] = true;
        int size = 1;
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx != 0 || dy != 0) {
                    size += dfs(matrix, visited, i + dx, j + dy);
                }
            }
        }
        return size;
    }
    public static void main(String[] args) {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(1, 1, 0, 0),
                Arrays.asList(0, 1, 1, 0),
                Arrays.asList(0, 0, 1, 0),
                Arrays.asList(1, 0, 0, 0)
        );

        int result = connectedCell(matrix);
        System.out.println("Kích thước vùng lớn nhất là: " + result);
    }


}