
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);

        // implement the creation of a magic square with the Siamese method algorithm here
        
        // put in the initial value of 1 in the center of the top row
        int row = 0;
        int column = size / 2;
        
        square.placeValue(column, row, 1);
        
        for (int i = 2; i <= size * size; ++i){
            
            // refer to old column and row
            int oldColumn = column;
            int oldRow = row;
            
            // calculate the next position
            if (column == size - 1) {
                column = 0;
                if (row == 0){
                    row = size - 1;
                } else {
                    row--;
                }
            } else if (row == 0) {
                row = size - 1;
                if (column == size - 1){
                    column = 0;
                } else {
                    column++;
                }
            } else {
                row--;
                column++;
            }
            
            // check the value first
            while (square.readValue(column, row) != 0) {
                
                // go back to previous position
                column = oldColumn;
                row = oldRow;
                
                // set row to go down
                if (row == size - 1) { // check if row is currently in the last row
                    row = 0; // set to top row again
                } else {
                    row++;
                }

                oldRow = row;
            } 
            
            square.placeValue(column, row, i);
            
        }
        
        return square;
    }

}
