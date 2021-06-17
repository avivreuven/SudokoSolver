public class Main {

    public static void main(String[] args) {
        /*
        int [][] grid= {{0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0}};

        int [][] grid= {{0,7,3,0,9,0,4,6,0},
                {0,9,0,0,0,0,0,8,7},
                {0,5,0,6,0,0,0,0,0},
                {3,0,0,0,0,0,8,0,0},
                {2,0,0,0,8,0,0,0,0},
                {0,0,1,7,0,2,6,0,0},
                {0,0,0,0,0,0,0,7,0},
                {0,1,8,9,0,0,0,0,4},
                {0,0,0,1,3,8,0,0,0}};


        int [][] grid= {{8,9,1,0,5,0,4,0,6},
                        {0,6,0,3,8,0,7,0,2},
                        {3,2,0,4,0,1,5,0,9},
                        {6,7,0,0,0,5,0,0,4},
                        {0,4,3,0,2,8,1,7,0},
                        {0,1,5,9,4,0,3,0,0},
                        {4,3,0,2,0,6,0,0,7},
                        {1,8,6,5,7,0,9,0,0},
                        {7,5,2,0,9,3,6,4,1}};

        int [][] grid= {{0,0,0,0,0,0,2,0,8},
                {3,0,0,0,0,0,0,0,7},
                {5,8,0,6,7,0,0,9,3},
                {0,0,0,0,6,0,0,0,1},
                {0,0,0,0,2,7,3,6,0},
                {0,0,0,1,0,0,4,7,0},
                {0,4,0,0,0,0,9,3,0},
                {9,0,3,0,5,0,0,0,0},
                {0,0,6,0,3,0,0,8,0}};
        */

        int [][] grid = {{0,0,0,7,0,0,3,0,0},
                {0,5,4,0,1,0,0,8,0},
                {3,0,0,0,2,0,0,9,0},
                {0,0,0,0,0,0,0,0,4},
                {0,2,1,0,0,0,6,7,0},
                {8,0,0,0,0,0,0,0,0},
                {0,3,0,0,7,0,0,0,6},
                {0,4,0,0,8,0,1,2,0},
                {0,0,5,0,0,4,0,0,0}};

        printGrid(grid);

        if (checkGrid(grid)){
            System.out.println("\n\nThe grid is OK");
            gridSolver(grid,0,0);
        }
        else
            System.out.println("\n\nThe grid is Wrong");
    }

    public static void printGrid(int [][] grid){
        for(int k=0;k<9;k++){
            System.out.print("\n");
            for(int l=0;l<9;l++){
                if(grid[k][l]==0)
                    System.out.print("[]\t");
                else
                    System.out.print(grid[k][l]+"\t");
                if (l==2 || l==5 || l==8)
                    System.out.print("|\t");
            }
            if (k==2 || k==5 || k==8)
                System.out.print("\n-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t-\t");
        }
    }

    public static boolean rowCheck(int [][] grid,int row,int col){
        for (int i=0;i<9;i++){
            if (col != i)
            {
                if (grid[row][col] == grid[row][i])
                    return false;
            }
        }
        return true;
    }

    public static boolean colCheck(int [][] grid,int row,int col){
        for (int i=0;i<9;i++){
            if (row != i)
            {
                if (grid[row][col] == grid[i][col])
                    return false;
            }
        }
        return true;
    }

    public static boolean boxCheck(int [][] grid,int row,int col){
        if (row < 3 && col < 3){
            for (int k=0;k<3;k++)
                for (int l=0;l<3;l++)
                    if (row != k && l != col)
                        if (grid[row][col] == grid[k][l])
                            return false;
        }
        if (row < 3 && col >= 3 && col < 6){
            for (int k=0;k<3;k++)
                for (int l=3;l<6;l++)
                    if (row != k && l != col)
                        if (grid[row][col] == grid[k][l])
                            return false;
        }
        if (row < 3 && col >= 6 && col < 9){
            for (int k=0;k<3;k++)
                for (int l=6;l<9;l++)
                    if (row != k && l != col)
                        if (grid[row][col] == grid[k][l])
                            return false;
        }
        if (row >= 3 && row < 6 && col < 3){
            for (int k=3;k<6;k++)
                for (int l=0;l<3;l++)
                    if (row != k && l != col)
                        if (grid[row][col] == grid[k][l])
                            return false;
        }
        if (row >= 3 && row < 6 && col >= 3 && col < 6){
            for (int k=3;k<6;k++)
                for (int l=3;l<6;l++)
                    if (row != k && l != col)
                        if (grid[row][col] == grid[k][l])
                            return false;
        }
        if (row >= 3 && row < 6 && col >= 6 && col < 9){
            for (int k=3;k<6;k++)
                for (int l=6;l<9;l++)
                    if (row != k && l != col)
                        if (grid[row][col] == grid[k][l])
                            return false;
        }
        if (row >= 6 && row < 9 && col < 3){
            for (int k=6;k<9;k++)
                for (int l=0;l<3;l++)
                    if (row != k && l != col)
                        if (grid[row][col] == grid[k][l])
                            return false;
        }
        if (row >= 6 && row < 9 && col >= 3 && col < 6){
            for (int k=6;k<9;k++)
                for (int l=3;l<6;l++)
                    if (row != k && l != col)
                        if (grid[row][col] == grid[k][l])
                            return false;
        }
        if (row >= 6 && row < 9 && col >= 6 && col < 9){
            for (int k=6;k<9;k++)
                for (int l=6;l<9;l++)
                    if (row != k && l != col)
                        if (grid[row][col] == grid[k][l])
                            return false;
        }
        return true;
    }

    public static boolean checkGrid(int [][] grid){
        for (int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++){
                if (grid[i][j] != 0){
                    for (int k=0;k<9;k++)
                    {
                        if (j != k)
                        {
                            if (grid[i][j] == grid[i][k])
                                return false;
                        }
                    }
                    for (int k=0;k<9;k++)
                    {
                        if (i != k)
                        {
                            if (grid[i][j] == grid[k][j])
                                return false;
                        }
                    }
                    if (i >= 0 && i <=2)
                    {
                        if (j >= 0 && j <= 2)
                        {
                            for (int k=0;k<3;k++)
                                for (int l=0;l<3;l++)
                                    if (i != k && l != j)
                                        if (grid[i][j] == grid[k][l])
                                            return false;
                        }
                        else if (j >= 3 && j <= 5)
                        {
                            for (int k=0;k<3;k++)
                                for (int l=3;l<6;l++)
                                    if (i != k && l != j)
                                        if (grid[i][j] == grid[k][l])
                                            return false;
                        }
                        else if (j >= 6 && j <= 8)
                        {
                            for (int k=0;k<3;k++)
                                for (int l=6;l<9;l++)
                                    if (i != k && l != j)
                                        if (grid[i][j] == grid[k][l])
                                            return false;
                        }
                    }
                    else if (i >= 3 && i <=5) {
                        if (j >= 0 && j <= 2) {
                            for (int k = 3; k < 6; k++)
                                for (int l = 0; l < 3; l++)
                                    if (i != k && l != j)
                                        if (grid[i][j] == grid[k][l])
                                            return false;
                        } else if (j >= 3 && j <= 5) {
                            for (int k = 3; k < 6; k++)
                                for (int l = 3; l < 6; l++)
                                    if (i != k && l != j)
                                        if (grid[i][j] == grid[k][l])
                                            return false;
                        } else if (j >= 6 && j <= 8) {
                            for (int k = 3; k < 6; k++)
                                for (int l = 6; l < 9; l++)
                                    if (i != k && l != j)
                                        if (grid[i][j] == grid[k][l])
                                            return false;
                        }
                    }
                    else if (i >= 6 && i <=8) {
                        if (j >= 0 && j <= 2) {
                            for (int k = 6; k < 9; k++)
                                for (int l = 0; l < 3; l++)
                                    if (i != k && l != j)
                                        if (grid[i][j] == grid[k][l])
                                            return false;
                        } else if (j >= 3 && j <= 5) {
                            for (int k = 6; k < 9; k++)
                                for (int l = 3; l < 6; l++)
                                    if (i != k && l != j)
                                        if (grid[i][j] == grid[k][l])
                                            return false;
                        } else if (j >= 6 && j <= 8) {
                            for (int k = 6; k < 9; k++)
                                for (int l = 6; l < 9; l++)
                                    if (i != k && l != j)
                                        if (grid[i][j] == grid[k][l])
                                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void gridSolver(int[][] grid,int i,int j){
        if (i==9 && checkGrid(grid))
        {
            printGrid(grid);
            return;
        }
        if (grid[i][j] != 0){
            if (j+1==9){
                gridSolver(grid,i+1,0);
            }
            else{
                gridSolver(grid,i,j+1);
            }
        }
        else {
            for (int m=1;m<10;m++){
                grid[i][j]=m;
                if (rowCheck(grid,i,j) && colCheck(grid,i,j) && boxCheck(grid,i,j)){
                    if (j+1==9){
                        gridSolver(grid,i+1,0);
                    }
                    else{
                        gridSolver(grid,i,j+1);
                    }
                }
                grid[i][j]=0;
            }
        }
    }

}
