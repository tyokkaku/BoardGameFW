package BoardGame;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * プレイヤーを表すクラス。
 */
public abstract class Player {

    // 配列のインデックス
    protected static int Y_axis = 0;
    protected static int X_axis = 1;

    // プレイヤーの情報
    public String name_;
    public String pieceType_;

    public Board board_;


    /**
     * プレイヤーのコンストラクタ。
     *
     * @param name プレイヤーの名前
     * @param pieceType マルかバツかを登録する
     */
    public Player(String name, String pieceType, Board board){
        this.name_ = name;
        this.pieceType_ = pieceType;
        this.board_ = board;
    }

    /**
     * プレイする。
     *
     * @param board ボード
     */
    public abstract void play(Board board);

    /**
     * プレイヤーに駒を置く場所を入力してもらう
     *
     * @param board ボード
     * @return putPosition 多次元配列の番号
     */
    protected int[] AskPutPosition(Board board){
        // 入力された数値を格納する配列
        int putPos[] = new int[2];

        int posX;
        int posY;

        while(true){
            try {
                // 入力を受け付ける
                System.out.println("置く場所を入力してください");

                InputStreamReader in = new InputStreamReader(System.in);
                BufferedReader reader = new BufferedReader(in);

                System.out.print("X軸：");
                String line1 = reader.readLine();
                posX = Integer.parseInt(line1);

                System.out.print("Y軸：");
                String line2 = reader.readLine();
                posY = Integer.parseInt(line2);

                if(!board.canPutPiece(posX, posY)) {
                    System.out.println("不正な入力値です。もう一度入力してください。");
                    System.out.println(this.name_ + "が" + this.pieceType_ + "でプレイします");
                    board.renderBoard();
                } else {
                    break;
                }
            } catch(Exception e) {
                System.out.println("不正な入力値です");
            }
        }
        // 二次元配列[Y軸][X軸]で代入する
        putPos[Y_axis] = posY;
        putPos[X_axis] = posX;
        return putPos;
    }
}
