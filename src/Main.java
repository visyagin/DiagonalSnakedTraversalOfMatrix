public class Main {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(4, 4);
        matrix.printMatrix();
        matrix.traverseMatrix();

        System.out.println();
        System.out.println();

        Matrix matrix1 = new Matrix(15, 7);
        matrix1.printMatrix();
        matrix1.traverseMatrix();

        System.out.println();
        System.out.println();

        Matrix matrix2 = new Matrix(2, 3);
        matrix2.printMatrix();
        matrix2.traverseMatrix();
    }
}
