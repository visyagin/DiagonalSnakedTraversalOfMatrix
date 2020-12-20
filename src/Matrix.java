public class Matrix {
    private final int row;
    private final int col;
    private final int[][] m;

    private int currentI = 0;
    private int currentJ = 0;

    private int moves = 0;
    private String nextDirection = "right";

    public Matrix(int row, int col) {
        this.row = row;
        this.col = col;
        this.m = generateMatrix(row, col);
    }

    public Matrix(int row, int col, int[][] m) {
        this.row = row;
        this.col = col;
        this.m = m;
    }

    public void traverseMatrix() {
        printElement(); // printing the first element
        while (moves < (col * row)) {
            switch (nextDirection) {
                case "right": {
                    moveRight();
                    break;
                }
                case "bottom": {
                    moveBottom();
                    break;
                }
                case "left_bottom": {
                    moveLeftBottom();
                    break;
                }
                case "right_top": {
                    moveRightTop();
                    break;
                }
            }
            printElement();
        }
    }

    private void moveRight() {
        if (currentJ < col - 1) {
            currentJ++;
        }

        if (currentI == 0) {
            nextDirection = "left_bottom";
        } else if (currentI == row - 1) {
            nextDirection = "right_top";
        }
    }

    private void moveBottom() {
        if (currentI < row - 1) {
            currentI++;
        }

        if (currentI > 0 && currentJ < col - 1) {
            nextDirection = "right_top";
        } else if (currentJ > 0 && currentI < row - 1) {
            nextDirection = "left_bottom";
        }
    }

    private void moveLeftBottom() {
        if (currentI < row - 1 && currentJ > 0) {
            currentI++;
            currentJ--;
        }

        if (currentJ == 0 && currentI < row - 1) {
            nextDirection = "bottom";
        } else if (currentI == row - 1 && currentJ < col - 1) {
            nextDirection = "right";
        }
    }

    private void moveRightTop() {
        if (currentI > 0 || currentJ < col - 1) {
            currentI--;
            currentJ++;
        }

        if (currentJ < col - 1 && currentI > 0) {
            nextDirection = "right_top";
        } else if (currentJ < col - 1) {
            nextDirection = "right";
        } else if (currentI < row - 1) {
            nextDirection = "bottom";
        }
    }

    private void printElement() {
        System.out.print(m[currentI][currentJ] + " ");
        moves++;
    }

    public void printMatrix() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                final int element = m[i][j];
                String s = (element < 10) ? "   ": "  ";
                System.out.print(element + s);
            }
            System.out.println();
        }
    }

    public int[][] generateMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        int k = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = k++;
            }
        }

        return matrix;
    }
}
