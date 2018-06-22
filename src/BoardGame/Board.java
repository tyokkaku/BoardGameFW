package BoardGame;

import java.util.ArrayList;

public abstract class Board {

    // ボードのサイズ
    public int boardSideLength;
    public static final int BoardMin = 0;

    // 盤の内外
    public static final String EmptyPoint = "  ";
    public static final String OutsideBoard = "OUT";

    /**
     * ボードを用意する
     */
    protected String[][] board_;

    /**
     * プレイヤーを格納するリスト
     */
    protected ArrayList<Player> players_ = new ArrayList<>();

    /**
     * ボードのコンストラクタ。
     */
    public Board(int boardSideLength) {
        this.boardSideLength = boardSideLength;
    }


    /**
     * 持ち駒を置けるかどうか判定する。(
     *
     * @param x
     * @param y
     */
    public abstract boolean canPutPiece(int x, int y, Player nextPlayer, Player player);

    /**
     * 盤面を初期化し、ゲームを準備する。
     *
     * @param board
     */
    public abstract void prepareGame(Board board);

    /**
     * ゲームを開始する。
     *
     * @param board
     */
    public abstract void startGame(Board board);

    /**
     * 勝利条件を満たしているか判定する。
     *
     * @return 勝利ならtrue
     */
    public abstract boolean judgeWin(Board board, Player player);

    /**
     * 盤面に持ち駒を置く。
     *
     * @param x x軸
     * @param y y軸
     * @return PieceType 駒の種類
     */
    public String putPiece(int x, int y, String PieceType) {
        return board_[y][x] = PieceType;
    }

    /**
     * ボードに置いてある駒の種類を検索する
     *
     * @param x x軸の値
     * @param y y軸の値
     * @return PieceType
     */
    public String getPieceType(int x, int y) {
        if (x < BoardMin || y < BoardMin || x >= boardSideLength || y >= boardSideLength) {
            return OutsideBoard;
        }
        return board_[y][x];
    }

    /**
     * ボードを描画する
     */
    public void renderBoard() {
        System.out.print("     " + 0);
        for (int i = 1; i < boardSideLength; i++) {
            System.out.print("    " + i);
        }
        System.out.println();
        for (int h = 0; h < boardSideLength; h++) {
            System.out.print(h);
            for (int i = 0; i < boardSideLength; i++) {
                System.out.print(" | " + board_[h][i]);
            }
            System.out.println(" | ");
        }
    }

    /**
     * プレイヤーを登録する。
     *
     * @param player1 先手のプレイヤー
     * @param player2 後手のプレイヤー
     */
    public void registerPlayer(Player player1, Player player2) {
        players_.add(player1);
        players_.add(player2);
    }

    /**
     * 勝敗を宣言する。
     *
     * @param player 勝利宣言したプレイヤー
     * @param board  最終結果を表示するボード
     */
    public void declareWin(Player player, Board board) {
        board.renderBoard();
        System.out.println(player.name_ + "の勝利です！");
        players_.remove(players_.indexOf(player));
    }
}
