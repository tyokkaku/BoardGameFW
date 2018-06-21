package TicTacToe;

import BoardGame.Board;
import BoardGame.Player;

public class TicTacToePlayer extends Player{

    /**
     * プレイヤーのコンストラクタ。
     *
     * @param name プレイヤーの名前
     * @param pieceType マルかバツかを登録する
     */
    public TicTacToePlayer(String name, String pieceType, Board board){
        super(name, pieceType, board);
    }

    /**
     * プレイする。
     *
     * @param board
     */
    public void play(Board board){
        // ナビゲーション
        System.out.println(this.name_ + "が" + this.pieceType_ + "でプレイします");

        board.renderBoard();

        int putPos[] = AskPutPosition(board);

        board.putPiece(putPos[X_axis],putPos[Y_axis],this.pieceType_);
        System.out.println(this.name_ + "が、X軸：" + putPos[X_axis] + ",Y軸：" + putPos[Y_axis] + "に置きました");

        if(board.judgeWin(board, this)){
            board.declareWin(this, board);
        }
    }

}
