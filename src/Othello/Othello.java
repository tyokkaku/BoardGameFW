package Othello;

import BoardGame.Board;
import BoardGame.Player;

import static Othello.OthelloBoard.BlackPiece;
import static Othello.OthelloBoard.WhitePiece;

public class Othello {

    public static void main(String[] args) {

        // ボードの生成
        Board board = new OthelloBoard(8);

        // プレイヤーの生成
        Player Tyokkaku = new OthelloPlayer("Tyokkaku", WhitePiece, board);
        Player Heikou = new OthelloPlayer("Heikou", BlackPiece, board);

        // プレイヤーの登録
        board.registerPlayer(Tyokkaku, Heikou);

        // ボードの初期化
        board.prepareGame(board);

        // ゲームの開始
        board.startGame(board);
    }
}
