package chapter04;

/**
 * Description: 五子棋小程序
 * Blog:	http://blog.csdn.net/mixi9760
 * CreateDate:	2017/6/12
 *
 * @author 张士鹏
 */
public class Gobang {
    //定义棋盘大小
    private static final int BOARD_SIZE = 15;
    private String[][] board;

    public static void main(String[] args) {
        Gobang gobang = new Gobang();
        gobang.initBoard();
        gobang.printBoard();
    }

    /**
     * 初始化棋盘
     */
    private void initBoard() {
        board = new String[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = "+";
            }
        }
    }

    private void printBoard() {
        for (String[] strings : board) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.print("\n");
        }
    }
}
