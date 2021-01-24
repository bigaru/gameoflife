public class ArrayLife implements Life {
    // [y][x] or [row][col]
    private boolean[][] internalGrid;
    private final int xLength;
    private final int yLength;

    public ArrayLife(boolean[][] grid) {
        yLength = grid.length;
        boolean hasYMinLength = yLength > 2;

        xLength = grid[0].length;
        boolean hasXMinLength = xLength > 2;

        boolean hasAllRowsEqualLength = true;
        for (boolean[] row: grid) {
            if (row.length != xLength) {
                hasAllRowsEqualLength = false;
                break;
            }
        }

        if(!hasYMinLength || !hasXMinLength || !hasAllRowsEqualLength){
            throw new IllegalArgumentException("Invalid Grid");
        }

        internalGrid = grid;
    }

    @Override
    public String toString(){
        var builder = new StringBuilder();

        for (boolean[] row: internalGrid) {
            for (boolean cell: row) {
                var c = cell ? "[*]" : "[ ]";
                builder.append(c);
            }

            builder.append("\n");
        }

        return builder.toString();
    }

    private int getActiveNeighbors(int row, int col){
        var isPopulated = internalGrid[row][col];
        var activeNeigbors = isPopulated ? -1 : 0;

        for(int r = row-1; r <= row+1; r++){
            for(int c = col-1; c <= col+1; c++){

                if(r >= 0 && r < yLength && c >= 0 && c < xLength){
                    activeNeigbors += internalGrid[r][c] ? 1 : 0;
                }

            }
        }

        return activeNeigbors;
    }

    private boolean computeIsPopulated(int row, int col, int activeNeigbors){
        var isActive = internalGrid[row][col];

        if(isActive) {
            switch (activeNeigbors) {
                case 2:
                case 3:
                    return true;

                case 0:
                case 1:
                    // > 4
                default:
                    return false;
            }
        }

        return activeNeigbors == 3;
    }

    @Override
    public void nextGeneration() {
        boolean[][] newGrid = new boolean[yLength][xLength];

        for(int row = 0; row < yLength; row++) {
            for(int col = 0; col < xLength; col++){
                var activeNeigbors = getActiveNeighbors(row, col);
                var isPopulated = computeIsPopulated(row, col, activeNeigbors);
                newGrid[row][col] = isPopulated;
            }
        }

        internalGrid = newGrid;
    }
}