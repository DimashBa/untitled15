public class Home {
    class CustomException extends Exception {

        CustomException(String message) {
            super(message);
        }
    }

    class MyArrayDataException extends CustomException {

        MyArrayDataException(int row, int col) {
            super(String.format("Неверные данные находятся в ячейке [%d, %d]\n", row, col));
        }
    }

    class MyArraySizeException extends CustomException {

        MyArraySizeException() {
            super("Размер[4 x 4]\n");
        }
    }

    class Converter {
        static int strConverter(String[][] strArray)
                throws MyArraySizeException, MyArrayDataException {

            int sum = 0;

            if (4 != strArray.length) throw new MyArraySizeException();
            for (int i = 0; i < strArray.length; i++) {
                if (4 != strArray[i].length) throw new MyArraySizeException();
                for (int k = 0; k < strArray[i].length; k++) {
                    try {
                        sum += Integer.parseInt(strArray[i][k]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException(i, k);
                    }
                }
            }

            return sum;
        }
    }

    public class HomeTask02 {

        private static void bmiCalc(double[][] human) {

            for (int i = 0; i < human.length; i++) {
                for (int j = 0; j < human[i].length; j += 2) {
                    double bmi = human[i][j] / (human[i][j + 1] * human[i][j + 1]);

                    System.out.printf("Weight: %.2f\tHeight: %.2f | BMI: %.2f | ", human[i][j], human[i][j + 1], bmi);

                    if (bmi < 18.5) {
                        System.out.print("Underweight\n");
                    } else if (bmi > 18.5 && bmi < 25.0) {
                        System.out.print("Normal\n");
                    } else if (bmi > 25.0 && bmi < 30.0) {
                        System.out.print("Overweight\n");
                    } else {
                        System.out.print("Obesity\n");
                    }
                }
            }
        }

        public  void main(String[] args) {


            String[][] correctMatrix = {
                    {"1", "2", "3", "4"},
                    {"1", "2", "3", "4"},
                    {"1", "2", "3", "4"},
                    {"1", "2", "3", "4"}
            };
            String[][] wrongSizeMatrix = {
                    {"1", "2", "3", "4"},
                    {"1", "2", "3", "4"},
                    {"1", "2", "3", "4"},
                    {"1", "2"}
            };
            String[][] wrongCharMatrix = {
                    {"1", "2", "3", "4"},
                    {"1", "2", "3", "4"},
                    {"1", "2", "3", "4"},
                    {"1", "2", "3", "4"}
            };

            try {
                System.out.println("Вариант 1:");
                System.out.println("Сумма всех элементов массива равна " + Converter.strConverter(correctMatrix) + ".\n");
            } catch (CustomException e) {
                e.getMessage();
            }

            try {
                System.out.println("Вариант 2:");
                System.out.println("Сумма всех элементов массива равна " + Converter.strConverter(wrongSizeMatrix) + ".\n");
            } catch (CustomException e) {
                System.out.println(e.getMessage());
            }

            try {
                System.out.println("Вариант 3:");
                System.out.println("Сумма всех элементов массива равна " + Converter.strConverter(wrongCharMatrix) + ".\n");
            } catch (CustomException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
