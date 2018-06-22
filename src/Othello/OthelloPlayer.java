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
        super(name,pieceType,board);
    }

    /**
     * プレイする。
     *
     * @param board ボード
     */
    public void play(Board board, Player nextPlayer){
        // ナビゲーション
        System.out.println(this.name_ + "が" + this.pieceType_ + "でプレイします");

        board.renderBoard();

        int putPos[] = AskPutPosition(board, nextPlayer);

        board.putPiece(putPos[X_axis],putPos[Y_axis],this.pieceType_);

//        OthelloBoard.reversePeace(putPos[X_axis], putPos[Y_axis], this.pieceType_, nextPlayer);

        System.out.println(this.name_ + "が、X軸：" + putPos[X_axis] + ",Y軸：" + putPos[Y_axis] + "に置きました");
    }
}
