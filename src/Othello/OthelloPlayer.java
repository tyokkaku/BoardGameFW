package Othello;

import BoardGame.Board;
import BoardGame.Player;

public class OthelloPlayer extends Player {

    /**
     * プレイヤーのコンストラクタ。
     *
     * @param name      プレイヤーの名前
     * @param pieceType マルかバツかを登録する
     */
    public OthelloPlayer(String name, String pieceType, Board board) {
        super(name, pieceType, board);
    }

    /**
     * プレイする。
     *
     * @param board ボード
     */
    public void play(Board board, Player nextPlayer) {
        // ナビゲーション
        System.out.println(this.name_ + "が" + this.pieceType_ + "でプレイします");

        board.renderBoard();

        boolean result = false;

        for (int i = 0; i < board.boardSideLength; i++) {
            for (int h = 0; h < board.boardSideLength; h++) {
                if (board.canPutPiece(i, h, nextPlayer, this)) {
                    result = true;
                }
            }
        }
        if (result) {
            int putPos[] = AskPutPosition(board, nextPlayer);
            board.putPiece(putPos[X_axis], putPos[Y_axis], this.pieceType_, nextPlayer);
            System.out.println(this.name_ + "が、X軸：" + putPos[X_axis] + ",Y軸：" + putPos[Y_axis] + "に置きました");
        } else {
            boolean nextPlayerJudge = false;

            for (int i = 0; i < board.boardSideLength; i++) {
                for (int h = 0; h < board.boardSideLength; h++) {
                    if (board.canPutPiece(i, h, this, nextPlayer)) {
                        nextPlayerJudge = true;
                    }
                }
            }
            if(nextPlayerJudge) {
                System.out.println(this.name_ + "が、パスをしました");
            } else {
                board.judgeWin(board, this, nextPlayer);
            }
        }
    }
}
