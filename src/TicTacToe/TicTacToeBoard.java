package TicTacToe;

import BoardGame.Board;
import BoardGame.Player;

public class TicTacToeBoard extends Board {

    /**
     * 三目並べのボードのコンストラクタ。
     *
     * @param boardSideWidth ボードの辺の長さ
     */
    public TicTacToeBoard(int boardSideWidth) {
        super(boardSideWidth);
    }

    /**
     * ボードを初期化し、ゲームを準備する。
     *
     * @param board
     */
    public void prepareGame(Board board) {
        // ボードを初期化する際に、変数board_に辺の長さを設定する。
        // これ以降は、生成したboardオブジェクトから辺の長さを取得する。
        board_ = new String[boardSideLength][boardSideLength];
        // EmptyPointで初期化する
        for (int a = 0; a < board.boardSideLength; a++) {
            for (int b = 0; b < board.boardSideLength; b++) {
                board_[a][b] = EmptyPoint;
            }
        }
    }

    /**
     * 持ち駒を置けるかどうか判定する。
     *
     * @param x
     * @param y
     */
    public boolean canPutPiece(int x, int y){
        return (board_[y][x].equals(EmptyPoint));
    }
    /**
     * 勝敗を判定する。
     *
     * @return 勝利ならtrue
     */
    public boolean judgeWin(Board board, Player player){

        boolean result = false;

        // 全方位分のカウントストック
        int maruBatuCount_vertical = 0;
        int maruBatuCount_horizon = 0;
        int maruBatuCount_slightRight = 0;
        int maruBatuCount_slightLeft = 0;

        int judgeVictoryNum_Upper = 2;
        int judgeVictoryNum_Lower = -2;

        int centerBoard_X = 1;
        int centerBoard_Y = 1;

        for (int i = judgeVictoryNum_Lower; i < judgeVictoryNum_Upper; i++) {
            // 上下を検索する
            if (board.getPieceType(centerBoard_X, centerBoard_Y + i).equals(player.pieceType_)) {
                maruBatuCount_vertical++;
                if (maruBatuCount_vertical >= 3) {
                    result = true;
                    break;
                }
            }
            // 左右を検索する
            if (board.getPieceType(centerBoard_X + i, centerBoard_Y).equals(player.pieceType_)) {
                maruBatuCount_horizon++;
                if (maruBatuCount_horizon >= 3) {
                    result = true;
                    break;
                }
            }
            // 斜め右を検索する
            if (board.getPieceType(centerBoard_X + i, centerBoard_Y - i).equals(player.pieceType_)) {
                maruBatuCount_slightRight++;
                if (maruBatuCount_slightRight >= 3) {
                    result = true;
                    break;
                }
            }
            // 斜め左を検索する
            if (board.getPieceType(centerBoard_X + i, centerBoard_Y + i).equals(player.pieceType_)) {
                maruBatuCount_slightLeft++;
                if (maruBatuCount_slightLeft >= 3) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    /**
         * ゲームを開始する。
         *
         * @param board ボード
         */
        public void startGame (Board board){
            int numberOfPlayer = players_.size();
            for (int count = 0; 1 < players_.size(); count++) {
                int currentPlayerNumber = count % numberOfPlayer; // 0 // 1 // 0
                Player currentPlayer = players_.get(currentPlayerNumber);
                currentPlayer.play(board);
                if (count == board.boardSideLength * board.boardSideLength - 1) {
                    board.renderBoard();
                    System.out.println("引き分けです！");
                    break;
                }
            }
        }
    }
