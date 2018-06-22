package Othello;

import BoardGame.Board;
import BoardGame.Player;

import java.util.ArrayList;

public class OthelloBoard extends Board {

    public static final String WhitePiece = "○";
    public static final String BlackPiece = "●";

    private static final int Top = 0;
    private static final int TopRightDiag = 1;
    private static final int Right = 2;
    private static final int BottomRightDiag = 3;
    private static final int Bottom = 4;
    private static final int BottomLeftDiag = 5;
    private static final int Left = 6;
    private static final int TopLeftDiag = 7;

    /**
     * ボードのコンストラクタ。
     */
    public OthelloBoard(int boardSideLength) {
        super(boardSideLength);
    }


    public String putPiece(int x, int y, String PieceType) {
        return board_[y][x] = PieceType;reversePeace(x, y, PieceType, );
    }


    /**
     * 駒をリバースする。
     *
     * @param x 置いたx座標
     * @param y 置いたy座標
     * @param pieceType 置いたプレイヤーの駒の種類
     * @param nextPlayer 次のプレイヤー
     */
    public void reversePeace(int x, int y, String pieceType, Player nextPlayer) {

        ArrayList<Integer> reverseDirection;

        reverseDirection = searchEnemyPiece_aroundOneMass(x, y, nextPlayer);

        for (int index = 0; index < reverseDirection.size(); index++) {
            // 上方向を探索して、空白を挟まないで、あるならtrueを返す
            if (reverseDirection.get(index) == Top) {
                for (int i = 1; i < boardSideLength; i++) {
                    // 自分の駒が見つかったなら
                    if (getPieceType(x, y - i).equals(pieceType)) {
                        // 置いた場所から見つけた場所まで逆転させる
                        for (int h = 0; h < i; h++) {
                            board_[y - h][x] = pieceType;
                        }
                    }
                }
            }
                // 右斜め上方向を探索して、空白を挟まないで、あるならtrueを返す
                if (reverseDirection.get(index) == TopRightDiag) {
                    for (int i = 1; i < boardSideLength; i++) {
                        // 自分の駒が見つかったなら逆転させる
                        if (getPieceType(x + i, y - i).equals(pieceType)) {
                            // 置いた場所から見つけた場所まで逆転させる
                            for (int h = 0; h < i; h++) {
                                board_[y - h][x + h] = pieceType;
                            }
                        }
                    }
                }
                    // 右方向を探索して、空白を挟まないで、あるならtrueを返す
                    if (reverseDirection.get(index) == Right) {
                        for (int i = 1; i < boardSideLength; i++) {
                            // 自分の駒が見つかったなら逆転させる
                            if (getPieceType(x + i, y).equals(pieceType)) {
                                // 置いた場所から見つけた場所まで逆転させる
                                for (int h = 0; h < i; h++) {
                                    board_[y][x + h] = pieceType;
                                }
                            }
                        }
                    }
                    // 右斜め下方向を探索して、空白を挟まないで、あるならtrueを返す
                    if (reverseDirection.get(index) == BottomRightDiag) {
                        for (int i = 1; i < boardSideLength; i++) {
                            // 自分の駒が見つかったなら逆転させる
                            if (getPieceType(x + i, y + i).equals(pieceType)) {
                                // 置いた場所から見つけた場所まで逆転させる
                                for (int h = 0; h < i; h++) {
                                    board_[y + h][x + h] = pieceType;
                                }
                            }
                        }
                    }
                    // 下方向を探索して、空白を挟まないで、あるならtrueを返す
                    if (reverseDirection.get(index) == Bottom) {
                        for (int i = 1; i < boardSideLength; i++) {
                            // 自分の駒が見つかったなら逆転させる
                            if (getPieceType(x, y + i).equals(pieceType)) {
                                // 置いた場所から見つけた場所まで逆転させる
                                for (int h = 0; h < i; h++) {
                                    board_[y + h][x] = pieceType;
                                }
                            }
                        }
                    }
                    // 左下方向を探索して、空白を挟まないで、あるならtrueを返す
                    if (reverseDirection.get(index) == BottomLeftDiag) {
                        for (int i = 1; i < boardSideLength; i++) {
                            // 自分の駒が見つかったなら逆転させる
                            if (getPieceType(x - i, y + i).equals(pieceType)) {
                                // 置いた場所から見つけた場所まで逆転させる
                                for (int h = 0; h < i; h++) {
                                    board_[y + h][x - h] = pieceType;
                                }
                            }
                        }
                    }
                    // 左方向を探索して、空白を挟まないで、あるならtrueを返す
                    if (reverseDirection.get(index) == Left) {
                        for (int i = 1; i < boardSideLength; i++) {
                            // 自分の駒が見つかったなら逆転させる
                            if (getPieceType(x - i, y).equals(pieceType)) {
                                // 置いた場所から見つけた場所まで逆転させる
                                for (int h = 0; h < i; h++) {
                                    board_[y][x - h] = pieceType;
                                }
                            }
                        }
                    }
                    // 左上方向を探索して、空白を挟まないで、あるならtrueを返す
                    if (reverseDirection.get(index) == TopLeftDiag) {
                        for (int i = 1; i < boardSideLength; i++) {
                            // 自分の駒が見つかったなら逆転させる
                            if (getPieceType(x - i, y - i).equals(pieceType)) {
                                // 置いた場所から見つけた場所まで逆転させる
                                for (int h = 0; h < i; h++) {
                                    board_[y - h][x - h] = pieceType;
                                }
                            }
                        }
            }
        }
    }


    /**
     * 持ち駒を置けるかどうか判定する。(
     *
     * @param x
     * @param y
     */
    public boolean canPutPiece(int x, int y, Player nextPlayer, Player player){

        boolean result = false;

        ArrayList<Integer> candidate;

        // 置く場所が空いているかどうか
        // 置く場所の周囲1マスに相手の駒があるかどうか
            // あれば、相手の駒を挟んで、自分の駒があるかどうか

        if(board_[y][x].equals(EmptyPoint)){
            candidate = searchEnemyPiece_aroundOneMass(x, y, nextPlayer);

            // 周囲1マスに敵がいれば、候補すべてを検索して欲しい。
            // ただし、true、false、falseとなってしまった場合に、最終的な結果がfalseになってしまう

            // 候補のうち、一つでも置けるラインがあればtrueを返してループを出る
            for(int i = 0; i < candidate.size(); i++){
                if(searchMyPiece_aroundOverTwoMass(x, y, candidate.get(i), player)){
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 置いた場所から周囲1マスよりも外側に、上下左右斜めに自分の駒があるかどうか調べる。
     *
     * @param x
     * @param y
     * @return ある場合はtrueを返す
     */
    public boolean searchMyPiece_aroundOverTwoMass(int x, int y, int direction, Player player){

        boolean result = false;

        // 上方向を探索して、空白を挟まないで、あるならtrueを返す
        if(direction == Top){
            for(int i = 1; i < boardSideLength; i++){
                // 空白を挟んでたら探索を中止する
                if(getPieceType(x, y - i).equals(EmptyPoint)){
                    break;
                }
                // 自分の駒が見つかったなら
                if(getPieceType(x, y - i).equals(player.pieceType_)){
                    result = true;
                }
            }
        }
        // 右斜め上方向を探索して、空白を挟まないで、あるならtrueを返す
        if(direction == TopRightDiag){
            for(int i = 1; i < boardSideLength; i++){
                // 空白を挟んでたら探索を中止する
                if(getPieceType(x + i, y - i).equals(EmptyPoint)){
                    break;
                }
                // 自分の駒が見つかったなら逆転させる
                if(getPieceType(x + i, y - i).equals(player.pieceType_)){
                    result = true;
                }
            }
        }
        // 右方向を探索して、空白を挟まないで、あるならtrueを返す
        if(direction == Right){
            for(int i = 1; i < boardSideLength; i++){
                // 空白を挟んでたら探索を中止する
                if(getPieceType(x + i, y).equals(EmptyPoint)){
                    break;
                }
                // 自分の駒が見つかったなら逆転させる
                if(getPieceType(x + i, y).equals(player.pieceType_)){
                    result = true;
                }
            }
        }
        // 右斜め下方向を探索して、空白を挟まないで、あるならtrueを返す
        if(direction == BottomRightDiag){
            for(int i = 1; i < boardSideLength; i++){
                // 空白を挟んでたら探索を中止する
                if(getPieceType(x + i, y + i).equals(EmptyPoint)){
                    break;
                }
                // 自分の駒が見つかったなら逆転させる
                if(getPieceType(x + i, y +  i).equals(player.pieceType_)){
                    result = true;
                }
            }
        }
        // 下方向を探索して、空白を挟まないで、あるならtrueを返す
        if(direction == Bottom){
            for(int i = 1; i < boardSideLength; i++){
                // 空白を挟んでたら探索を中止する
                if(getPieceType(x, y + i).equals(EmptyPoint)){
                    break;
                }
                // 自分の駒が見つかったなら逆転させる
                if(getPieceType(x, y + i).equals(player.pieceType_)){
                    result = true;
                }
            }
        }
        // 左下方向を探索して、空白を挟まないで、あるならtrueを返す
        if(direction == BottomLeftDiag){
            for(int i = 1; i < boardSideLength; i++){
                // 空白を挟んでたら探索を中止する
                if(getPieceType(x - i, y + i).equals(EmptyPoint)){
                    break;
                }
                // 自分の駒が見つかったなら逆転させる
                if(getPieceType(x - i, y +  i).equals(player.pieceType_)){
                    result = true;
                }
            }
        }
        // 左方向を探索して、空白を挟まないで、あるならtrueを返す
        if(direction == Left){
            System.out.println(player.name_);
            System.out.println(player.pieceType_);
            for(int i = 1; i < boardSideLength; i++){
                // 空白を挟んでたら探索を中止する
                if(getPieceType(x - i, y).equals(EmptyPoint)){
                    break;
                }
                // 自分の駒が見つかったなら逆転させる
                if(getPieceType(x - i, y).equals(player.pieceType_)){
                    result = true;
                }
            }
        }
        // 左上方向を探索して、空白を挟まないで、あるならtrueを返す
        if(direction == TopLeftDiag){
            for(int i = 1; i < boardSideLength; i++){
                // 空白を挟んでたら探索を中止する
                if(getPieceType(x - i, y - i).equals(EmptyPoint)){
                    break;
                }
                // 自分の駒が見つかったなら逆転させる
                if(getPieceType(x - i, y - i).equals(player.pieceType_)){
                    result = true;
                }
            }
        }
        return result;
    }


    /**
     * 置いた場所の周囲1マス以内に相手の駒があるかどうかを調べ、自駒を置ける候補を返す。
     *
     * @param x 置いた場所のx座標
     * @param y 置いた場所のy座標
     * @param nextPlayer 相手プレイヤー
     * @return 置ける候補を返す
     */
    public ArrayList<Integer> searchEnemyPiece_aroundOneMass(int x, int y, Player nextPlayer){

        ArrayList<Integer> candidate = new ArrayList<>();

        // 自分の周囲1マス
        int aroundOneMass_Upper = 1;
        int aroundOneMass_Lower = -1;

        for (int i = aroundOneMass_Lower; i <= aroundOneMass_Upper; i++) {
            // 上下を検索する
            if (getPieceType(x, y + i).equals(nextPlayer.pieceType_)) {
                // 上なら
                if(i < 0){
                    candidate.add(Top);
                } else {
                    // 下なら
                    candidate.add(Bottom);;
                }
            }
            // 左右を検索する
            if (getPieceType(x + i, y).equals(nextPlayer.pieceType_)) {
                // 左なら
                if(i < 0){
                    candidate.add(Left);
                } else {
                    // 右なら
                    candidate.add(Right);
                }
            }
            // 斜め右を検索する
            if (getPieceType(x + i, y - i).equals(nextPlayer.pieceType_)) {
                // 左下なら
                // マイナス。 x - i（左）, y + i（下）
                if(i < 0){
                    candidate.add(BottomLeftDiag);
                } else {
                    // 右上なら
                    // プラス。 x + i（右）, y - i（上）
                    candidate.add(TopRightDiag);
                }
            }
            // 斜め左を検索する
            if (getPieceType(x + i, y + i).equals(nextPlayer.pieceType_)) {
                // 左上なら
                // マイナス。 x - i（左）, y - i（上）
                if(i < 0){
                    candidate.add(TopLeftDiag);
                } else {
                    // 右下なら
                    // プラス。  x + i（右）, y + i（下）
                    candidate.add(BottomRightDiag);
                }
            }
        }
        System.out.println("周囲1マスの結果：" + candidate);
        return candidate;
    }


    /**
     * 盤面を初期化し、ゲームを準備する。
     *
     * @param board
     */
    public void prepareGame(Board board){
        // ボードオブジェクトの生成。以降はこのオブジェクトを使う。
        board_ = new String [boardSideLength][boardSideLength];

        for(int i = 0; i < boardSideLength; i++){
            for(int h = 0; h < boardSideLength; h++){
                board_[i][h] = EmptyPoint;
            }
        }
        board_[3][3] = WhitePiece;
        board_[4][4] = WhitePiece;
        board_[3][4] = BlackPiece;
        board_[4][3] = BlackPiece;
    }

    /**
     * ゲームを開始する。
     *
     * @param board
     */
    public void startGame(Board board){
        int numberOfPlayer = players_.size();
        for (int count = 0; 1 < players_.size(); count++) {
            int currentPlayerNumber = count % numberOfPlayer; // 0 // 1 // 0
            Player currentPlayer = players_.get(currentPlayerNumber);
            int nextPlayerNumber = (count + 1) % numberOfPlayer; // 1 // 0 // 1
            Player nextPlayer = players_.get(nextPlayerNumber);

            currentPlayer.play(board, nextPlayer);
        }
    }

    /**
     * 勝利条件を満たしているか判定する。
     *
     * @return 勝利ならtrue
     */
    public boolean judgeWin(Board board, Player player){
        return true;
    }
}
