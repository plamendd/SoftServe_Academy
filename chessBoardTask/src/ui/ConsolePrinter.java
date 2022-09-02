package ui;

public class ConsolePrinter implements Printer  {

    @Override
    public void printInstructions() {
        System.out.println("For generating a matrix with height and width: -> Type two  positive numbers separated by whitespace for height and width.");
        System.out.println("For exit the program: -> Type 'exit'.");
    }

    @Override
    public void printError(){
        System.out.println("Your input is incorrect !");
    }




    @Override
    public void printMatrix(Integer height, Integer width) {
        StringBuilder matrix = new StringBuilder();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix.append("*");
                if (j != width-1){
                    matrix.append(" ");
                }
            }
            matrix.append(System.lineSeparator());
        }
        System.out.println(matrix);
    }
}
