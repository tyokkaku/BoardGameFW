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


    /**
     * 駒を置く
     *
     * @param x x軸
     * @param y y軸
     * @param PieceType
     * @param nextPlayer
     */
    public void putPiece(int x, int y, String PieceType, Player nextPlayer) {
        board_[y][x] = PieceType;
        reversePeace(x, y, PieceType,nextPlayer);
    }

    /**
     * 駒をリバースする
     *
     * @param x 置いたx座標
     * @param y 置いたy座標
     * @param pieceType 置いたプレイヤーの駒の種類
     * @param nextPlayer 次のプレイヤー
     */
    public void reversePeace(int x, int y, String pieceType, Player nextPlayer) {

        ArrayList<Integer> reverseDirection;

        reverseDirection = searchEnemyPiece_aroundOneMass(x, y, nextPlayer);

        System.out.println(reverseDirection);

        for (int index = 0; index < reverseDirection.size(); index++) {
            // 上方向を探索して、空白を挟まないで、あるならtrueを返す
            if (reverseDirection.get(index) == Top) {
                for (int i = 1; i < boardSideLength; i++) {
                    if(getPieceType(x, y - i).equals(EmptyPoint)) {
                        break;
                    }
                    // 自分の駒が見つかったなら
                    if (getPieceType(x, y - i).equals(pieceType)) {
                        // 置いた場所から見つけた場所まで逆転させる
                        for (int h = 0; h < i; h++) {
                            board_[y - h][x] = pieceType;
                        }
                        break;
                    }
                }
            }
            // 右斜め上方向を探索して、空白を挟まないで、あるならtrueを返す
             if (reverseDirection.get(index) == TopRightDiag) {
                for (int i = 1; i < boardSideLength; i++) {
                // 自分の駒が見つかったなら逆転させる
                    if(getPieceType(x + i, y - i).equals(EmptyPoint)) {
                        break;
                    }
                    if (getPieceType(x + i, y - i).equals(pieceType)) {
                            // 置いた場所から見つけた場所まで逆転させる
                            for (int h = 0; h < i; h++) {
                                board_[y - h][x + h] = pieceType;
                            }
                            break;
                        }
                    }
                }
                // 右方向を探索して、空白を挟まないで、あるならtrueを返す
            if (reverseDirection.get(index) == Right) {
                for (int i = 1; i < boardSideLength; i++) {
                    if(getPieceType(x + i, y).equals(EmptyPoint)) {
                        break;
                    }
                    // 自分の駒が見つかったなら逆転させる
                    if (getPieceType(x + i, y).equals(pieceType)) {
                        // 置いた場所から見つけた場所まで逆転させる
                        for (int h = 0; h < i; h++) {
                            board_[y][x + h] = pieceType;
                        }
                        break;
                    }
                }
            }
            // 右斜め下方向を探索して、空白を挟まないで、あるならtrueを返す
            if (reverseDirection.get(index) == BottomRightDiag) {
                for (int i = 1; i < boardSideLength; i++) {
                    if(getPieceType(x + i, y + i).equals(EmptyPoint)) {
                        break;
                    }
                    // 自分の駒が見つかったなら逆転させる
                    if (getPieceType(x + i, y + i).equals(pieceType)) {
                        // 置いた場所から見つけた場所まで逆転させる
                        for (int h = 0; h < i; h++) {
                            board_[y + h][x + h] = pieceType;
                            }
                        break;
                    }
                }
            }
            // 下方向を探索して、空白を挟まないで、あるならtrueを返す
            if (reverseDirection.get(index) == Bottom) {
                for (int i = 1; i < boardSideLength; i++) {
                    if(getPieceType(x, y + i).equals(EmptyPoint)) {
                        break;
                    }
                    // 自分の駒が見つかったなら逆転させる
                    if (getPieceType(x, y + i).equals(pieceType)) {
                        // 置いた場所から見つけた場所まで逆転させる
                        for (int h = 0; h < i; h++) {
                            board_[y + h][x] = pieceType;
                            }
                        break;
                    }
                }
            }
            // 左下方向を探索して、空白を挟まないで、あるならtrueを返す
            if (reverseDirection.get(index) == BottomLeftDiag) {
                for (int i = 1; i < boardSideLength; i++) {
                    if(getPieceType(x - i, y + i).equals(EmptyPoint)) {
                        break;
                    }
                    // 自分の駒が見つかったなら逆転させる
                    if (getPieceType(x - i, y + i).equals(pieceType)) {
                        // 置いた場所から見つけた場所まで逆転させる
                        for (int h = 0; h < i; h++) {
                            board_[y + h][x - h] = pieceType;
                            }
                        break;
                    }
                }
            }
            // 左方向を探索して、空白を挟まないで、あるならtrueを返す
            if (reverseDirection.get(index) == Left) {
                for (int i = 1; i < boardSideLength; i++) {
                    if(getPieceType(x - i, y).equals(EmptyPoint)) {
                        break;
                    }
                    // 自分の駒が見つかったなら逆転させる
                    if (getPieceType(x - i, y).equals(pieceType)) {
                        // 置いた場所から見つけた場所まで逆転させる
                        for (int h = 0; h < i; h++) {
                            board_[y][x - h] = pieceType;
                            }
                        break;
                    }
                }
            }
            // 左上方向を探索して、空白を挟まないで、あるならtrueを返す
            if (reverseDirection.get(index) == TopLeftDiag) {
                for (int i = 1; i < boardSideLength; i++) {
                    if(getPieceType(x - i, y - i).equals(EmptyPoint)) {
                        break;
                    }
                    // 自分の駒が見つかったなら逆転させる
                    if (getPieceType(x - i, y - i).equals(pieceType)) {
                        // 置いた場所から見つけた場所まで逆転させる
                        for (int h = 0; h < i; h++) {
                            board_[y - h][x - h] = pieceType;
                            }
                        break;
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
                if(getPieceType(x, y - i).equals(EmptyPoint)){
//                    System.out.println("上方向に空白を発見：" + x + "," + (y -i));
                    break;
                } else if(getPieceType(x, y - i).equals(player.pieceType_)){
//                    System.out.println("上方向に自分の駒を発見：" + x + "," + (y -i));
                    result = true;
                }
            }
        }
        // 右斜め上方向を探索して、空白を挟まないで、あるならtrueを返す
        if(direction == TopRightDiag){
            for(int i = 1; i < boardSideLength; i++){
                if(getPieceType(x + i, y - i).equals(EmptyPoint)){
//                    System.out.println("右斜め上方向に空白を発見：" + (x + i) + "," + (y - i));
                    break;
                } else if(getPieceType(x + i, y - i).equals(player.pieceType_)){
//                    System.out.println("右斜め上方向に自分の駒を発見：" + (x + i) + "," + (y - i));
                    result = true;
                }
            }
        }
        // 右方向を探索して、空白を挟まないで、あるならtrueを返す
        if(direction == Right){
            for(int i = 1; i < boardSideLength; i++){
                if(getPieceType(x + i, y).equals(EmptyPoint)){
//                    System.out.println("右方向に空白を発見：" + (x + i) + "," + (y));
                    break;
                } else if(getPieceType(x + i, y).equals(player.pieceType_)){
//                    System.out.println("右方向に自分の駒を発見：" + (x + i) + "," + (y));
                    result = true;
                }
            }
        }
        // 右斜め下方向を探索して、空白を挟まないで、あるならtrueを返す
        if(direction == BottomRightDiag){
            for(int i = 1; i < boardSideLength; i++){
                if(getPieceType(x + i, y + i).equals(EmptyPoint)){
//                    System.out.println("右斜め下方向に空白を発見：" + (x + i) + "," + (y + i));
                    break;
                } else if(getPieceType(x + i, y +  i).equals(player.pieceType_)){
//                    System.out.println("右斜め下方向に自分の駒を発見：" + (x + i) + "," + (y + i));
                    result = true;
                }
            }
        }
        // 下方向を探索して、空白を挟まないで、あるならtrueを返す
        if(direction == Bottom){
            for(int i = 1; i < boardSideLength; i++){
                if(getPieceType(x, y + i).equals(EmptyPoint)){
//                    System.out.println("下方向に空白を発見：" + x + "," + (y + i));
                    break;
                } else if(getPieceType(x, y + i).equals(player.pieceType_)){
//                    System.out.println("下方向に自分の駒を発見：" + x + "," + (y + i));

                    result = true;
                }
            }
        }
        // 左下方向を探索して、空白を挟まないで、あるならtrueを返す
        if(direction == BottomLeftDiag){
            for(int i = 1; i < boardSideLength; i++){
                if(getPieceType(x - i, y + i).equals(EmptyPoint)){
//                    System.out.println("左斜め下方向に空白を発見：" + (x -i) + "," + (y + i));
                    break;
                } else if(getPieceType(x - i, y +  i).equals(player.pieceType_)){
//                    System.out.println("左斜め下方向に自分の駒を発見：" + (x -i) + "," + (y + i));
                    result = true;
                }
            }
        }
        // 左方向を探索して、空白を挟まないで、あるならtrueを返す
        if(direction == Left){
            for(int i = 1; i < boardSideLength; i++){
                if(getPieceType(x - i, y).equals(EmptyPoint)){
//                    System.out.println("左方向に空白を発見：" + (x -i) + "," + y);
                    break;
                } else if(getPieceType(x - i, y).equals(player.pieceType_)){
//                    System.out.println("左方向に自分の駒を発見：" + (x -i) + "," + y);
                    result = true;
                }
            }
        }
        // 左上方向を探索して、空白を挟まないで、あるならtrueを返す
        if(direction == TopLeftDiag){
            for(int i = 1; i < boardSideLength; i++){
                if(getPieceType(x - i, y - i).equals(EmptyPoint)){
//                    System.out.println("左斜め上方向に空白を発見：" + (x -i) + "," + (y -i));
                    break;
                } else if(getPieceType(x - i, y - i).equals(player.pieceType_)){
//                    System.out.println("左斜め上方向に自分の駒を発見：" + (x - i) + "," + (y -i));
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
//        System.out.println("周囲1マスの結果：" + candidate);
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
     * @param board
     * @param player
     * @param nextPlayer
     * @return 勝利ならtrue
     */
    public boolean judgeWin(Board board, Player player, Player nextPlayer){
        int currentPlayerPieceCount = 0;
        int nextPlayerPieceCount = 0;

        for(int i =0; i < boardSideLength; i++){
            for(int h =0; h < boardSideLength; h++){
                if(board_[i][h] == player.pieceType_){
                    currentPlayerPieceCount++;
                } else if(board_[i][h] == nextPlayer.pieceType_){
                    nextPlayerPieceCount++;
                }
            }
        }

        if(currentPlayerPieceCount == nextPlayerPieceCount){
            System.out.println(player.pieceType_ + "が" + currentPlayerPieceCount + "個、" + nextPlayer.pieceType_ + "が" + nextPlayerPieceCount + "で、引き分けです！");
        } else if(currentPlayerPieceCount > nextPlayerPieceCount){
            System.out.println(player.pieceType_ + "が" + currentPlayerPieceCount + "個、" + nextPlayer.pieceType_ + "が" + nextPlayerPieceCount + "で、" + player.name_ + "の勝利です！");
        } else {
            System.out.println(player.pieceType_ + "が" + currentPlayerPieceCount + "個、" + nextPlayer.pieceType_ + "が" + nextPlayerPieceCount + "で、" + nextPlayer.name_ + "の勝利です！");
        }

        try{
            players_.remove(0);
            players_.remove(1);
        } catch(Exception e){
            System.out.println("ゲーム終了です");
        }
        return true;
    }
}
