package edu.miu;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private void DepthFirstSearch(char[][] grid, int i, int j) {
        int rows =grid.length;
        int cols =grid[0].length;

        //we need to check if the current cell is out of bounds or is it water
        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == '0') {
            return;
        }

        //mark the current cell is visited
        grid[i][j]='0';

        //we need to make recursive calls for up ,down , left, and right
        DepthFirstSearch(grid,i+1,j);
        DepthFirstSearch(grid,i-1,j);
        DepthFirstSearch(grid,i,j+1);
        DepthFirstSearch(grid,i,j-1);
    }

    public int NumberOfIslands(char[][]grid){
        if(grid ==null ||grid.length==0){
            return 0;
        }
        int NumberOfIslands =0;
        int rows = grid.length;
        int cols =grid[0].length;

        //we shall use the brute force method

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]=='1'){
                    NumberOfIslands +=1; //we increment the number of Island we meet at this point
                    DepthFirstSearch(grid,i,j); // We call this method to Implement the Depth First Search
                }
            }
        }
        return NumberOfIslands;
    }

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        Main Solution = new Main();

        char[][] grid ={
                {'1','1','1','0'},
                {'1','1','0','1'},
                {'0','0','0','0'},
                {'1','0','0','1'}
        };

        char [][] grid1 ={
                {'1','1','0','0'},
                {'1','1','0','1'},
                {'0','0','0','0'},
                {'1','0','0','1'}
        };
       System.out.println( "Output is "+Solution.NumberOfIslands(grid));
       System.out.println( "Output is "+Solution.NumberOfIslands(grid1));


//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + i);
//        }
    }
}