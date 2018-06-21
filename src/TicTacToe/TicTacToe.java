package TicTacToe;

import BoardGame.Board;
import BoardGame.Player;

public class TicTacToe {
    public static void main(String args[]){

        // ボードの生成
        Board board = new TicTacToeBoard(3);

        // プレイヤーの生成
        Player Tyokkaku = new TicTacToePlayer("Tyokkaku", "○", board);
        Player Heikou = new TicTacToePlayer("Heikou", "×", board);

        // ボードの初期化
        board.prepareGame(board);

        // プレイヤーの登録
        board.registerPlayer(Tyokkaku,Heikou);

        // ゲームの開始
        board.startGame(board);
    }
}
