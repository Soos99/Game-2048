package LeaderBoard;
import Component.*;
import java.io.*;

public class ScoreManager {
    // CURRENT SCORES
    private int currentScore;
    private int currentTopScore;
    private int[] board = new int[16];

    // File
    private String filePath;
    private String temp;
    private GameBoard gBoard;

    // Random booleans
    private boolean newGame;

    public ScoreManager(GameBoard gBoard) {
        try {
            filePath = new File("").getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
        }
        temp = "TEMP.tmp";

        this.gBoard = gBoard;
    }

    public void reset() {
        File f = new File(filePath, temp);
        if (f.isFile()) {
            f.delete();
        }
        newGame = true;
        currentScore = 0;
    }

    private void createFile() {
        FileWriter output = null;
        newGame = true;

        try {
            File f = new File(filePath, temp);
            output = new FileWriter(f);
            BufferedWriter writer = new BufferedWriter(output);
            writer.write("" + 0);
            writer.newLine();
            writer.write("" + 0);
            writer.newLine();
            writer.write("" + 0);
            writer.newLine();
            writer.write("" + 0);
            writer.newLine();
            for (int row = 0; row < GameBoard.ROWS; row++) {
                for (int col = 0; col < GameBoard.COLS; col++) {
                    if(row == GameBoard.ROWS - 1 && col == GameBoard.COLS - 1){
                        writer.write("" + 0);
                    }
                    else{
                        writer.write(0 + "-");
                    }
                }
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveGame() {
        FileWriter output = null;
        if (newGame) newGame = false;

        try {
            File f = new File(filePath, temp);
            output = new FileWriter(f);
            BufferedWriter writer = new BufferedWriter(output);
            writer.write("" + currentScore);
            writer.newLine();
            writer.write("" + currentTopScore);
            writer.newLine();
            for (int row = 0; row < GameBoard.ROWS; row++) {
                for (int col = 0; col < GameBoard.COLS; col++) {
                    this.board[row * GameBoard.COLS + col] = gBoard.getBoard()[row][col] != null ? gBoard.getBoard()[row][col].getValue() : 0;
                    if (row == GameBoard.ROWS - 1 && col == GameBoard.COLS - 1)
                        writer.write("" + board[row * GameBoard.COLS + col]);
                    else writer.write(board[row * GameBoard.COLS + col] + "-");
                }
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadGame() {
        try {
            File f = new File(filePath, temp);

            if (!f.isFile()) {
                createFile();
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            currentScore = Integer.parseInt(reader.readLine());
            currentTopScore = Integer.parseInt(reader.readLine());
            String[] board = reader.readLine().split("-");
            for (int i = 0; i < board.length; i++) {
                this.board[i] = Integer.parseInt(board[i]);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public int getCurrentTopScore() {
        return currentTopScore;
    }

    public void setCurrentTopScore(int currentTopScore) {
        this.currentTopScore = currentTopScore;
    }

    public boolean newGame() {
        return newGame;
    }

    public int[] getBoard() {
        return board;
    }
}
